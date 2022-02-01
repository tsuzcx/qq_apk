package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocAIOPlusPanelEntryConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocAIOPlusPanelEntryConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocFormKeyWordsBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocFormKeyWordsProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigProcessor;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.imcore.proxy.troop.TroopManagerProxy;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocsListFragment;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.qipc.TDFileQIPCModule;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.teamworkforgroup.GroupPadTemplateInfo;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xae9.online_docs.DocId;

public class TeamWorkUtilsImpl
  implements ITeamWorkUtils
{
  private static final String IMAGE_BASE64_PREFIX_GIF = "data:image/gif;base64,";
  private static final String IMAGE_BASE64_PREFIX_JPEG = "data:image/jpeg;base64,";
  private static final String IMAGE_BASE64_PREFIX_JPG = "data:image/jpg;base64,";
  private static final String IMAGE_BASE64_PREFIX_PNG = "data:image/png;base64,";
  private static final int MIN_DELAY_TIME = 1000;
  private static final String TAG = "TeamWorkUtils";
  private static final SparseArray<Pair<Integer, String>> WX_H5_SHARE_TYPE_ICON_MAP;
  private static final SparseArray<Pair<Integer, String>> WX_MINI_SHARE_TYPE_ICON_MAP;
  private static final Map<String, Integer> WX_SHARE_TYPE_MAP;
  private static long lastClickTime = 0L;
  private static volatile int mLastMsgSeq = -2147483648;
  public final String THIS_WEEK = HardCodeUtil.a(2131714610);
  public final String TODAY = HardCodeUtil.a(2131714584);
  public final String YESTERDAY = HardCodeUtil.a(2131714569);
  
  static
  {
    MINIAPP_CONFIG_TYPE_MAP.put("s_qq_aiomsg", "docs_miniapp_config_aio_msg");
    MINIAPP_CONFIG_TYPE_MAP.put("s_qq_myfile", "docs_miniapp_config_my_file");
    MINIAPP_CONFIG_TYPE_MAP.put("s_qq_myfile_yindao", "docs_miniapp_config_my_file");
    MINIAPP_CONFIG_TYPE_MAP.put("s_qq_myfile_banner", "docs_miniapp_config_my_file");
    MINIAPP_CONFIG_TYPE_MAP.put("s_qq_myfile_menu_create", "docs_miniapp_config_templatelist");
    MINIAPP_CONFIG_TYPE_MAP.put("s_qq_grpfile", "docs_miniapp_config_troop_file");
    MINIAPP_CONFIG_TYPE_MAP.put("s_qq_aio_grey", "docs_miniapp_config_gray_bar");
    MINIAPP_CONFIG_TYPE_MAP.put("s_qq_aio_edit", "docs_miniapp_config_aio_edit");
    MINIAPP_CONFIG_TYPE_MAP.put("s_qq_file_edit", "docs_miniapp_config_bottom_edit");
    MINIAPP_CONFIG_TYPE_MAP.put("s_QQ_file_share_edit", "docs_miniapp_config_menu_edit");
    MINIAPP_CONFIG_TYPE_MAP.put("s_qq_file_preview", "docs_miniapp_config_online_preview");
    MINIAPP_CONFIG_TYPE_MAP.put("s_qq_ocr_save", "docs_miniapp_config_ocr_save");
    MINIAPP_CONFIG_TYPE_MAP.put("s_qq_url_2_doc", "docs_miniapp_config_url_2_doc");
    MINIAPP_CONFIG_TYPE_MAP.put("s_qq_mini_importing", "s_qq_mini_importing");
    MINIAPP_CONFIG_TYPE_MAP.put("s_qq_aio_ark_h5", "docs_miniapp_config_aio_ark_h5");
    ENTRANCE_TO_AD_TAG_MAP.put(Integer.valueOf(9), "s_qq_mini_importing");
    ENTRANCE_TO_AD_TAG_MAP.put(Integer.valueOf(12), "s_qq_url_2_doc");
    WX_SHARE_TYPE_MAP = new HashMap();
    WX_MINI_SHARE_TYPE_ICON_MAP = new SparseArray();
    WX_H5_SHARE_TYPE_ICON_MAP = new SparseArray();
    WX_SHARE_TYPE_MAP.put("docx", Integer.valueOf(1));
    WX_SHARE_TYPE_MAP.put("sheet", Integer.valueOf(2));
    WX_SHARE_TYPE_MAP.put("form", Integer.valueOf(3));
    WX_SHARE_TYPE_MAP.put("slide", Integer.valueOf(4));
    WX_SHARE_TYPE_MAP.put("pdf", Integer.valueOf(5));
    WX_MINI_SHARE_TYPE_ICON_MAP.put(1, new Pair(Integer.valueOf(2130850048), "static://DefaultTeamWorkMiniShareDoc"));
    WX_MINI_SHARE_TYPE_ICON_MAP.put(2, new Pair(Integer.valueOf(2130850055), "static://DefaultTeamWorkMiniShareSheet"));
    WX_MINI_SHARE_TYPE_ICON_MAP.put(3, new Pair(Integer.valueOf(2130850051), "static://DefaultTeamWorkMiniShareForm"));
    WX_MINI_SHARE_TYPE_ICON_MAP.put(4, new Pair(Integer.valueOf(2130850057), "static://DefaultTeamWorkMiniShareSlide"));
    WX_MINI_SHARE_TYPE_ICON_MAP.put(5, new Pair(Integer.valueOf(2130850053), "static://DefaultTeamWorkMiniSharePdf"));
    WX_H5_SHARE_TYPE_ICON_MAP.put(1, new Pair(Integer.valueOf(2130850047), "static://DefaultTeamWorkH5ShareDoc"));
    WX_H5_SHARE_TYPE_ICON_MAP.put(2, new Pair(Integer.valueOf(2130850054), "static://DefaultTeamWorkH5ShareSheet"));
    WX_H5_SHARE_TYPE_ICON_MAP.put(3, new Pair(Integer.valueOf(2130850050), "static://DefaultTeamWorkH5ShareForm"));
    WX_H5_SHARE_TYPE_ICON_MAP.put(4, new Pair(Integer.valueOf(2130850056), "static://DefaultTeamWorkH5ShareSlide"));
    WX_H5_SHARE_TYPE_ICON_MAP.put(5, new Pair(Integer.valueOf(2130850052), "static://DefaultTeamWorkH5SharePdf"));
  }
  
  private Bitmap obtainShareBitmap(SparseArray<Pair<Integer, String>> paramSparseArray, int paramInt1, String paramString, int paramInt2)
  {
    int i = paramInt1;
    String str = paramString;
    if (paramSparseArray != null)
    {
      paramSparseArray = (Pair)paramSparseArray.get(paramInt2);
      i = paramInt1;
      str = paramString;
      if (paramSparseArray != null)
      {
        str = (String)paramSparseArray.second;
        i = ((Integer)paramSparseArray.first).intValue();
      }
    }
    if (GlobalImageCache.a != null) {
      paramSparseArray = (Bitmap)GlobalImageCache.a.get(str);
    } else {
      paramSparseArray = null;
    }
    paramString = paramSparseArray;
    if (paramSparseArray == null)
    {
      paramSparseArray = BitmapManager.b(MobileQQ.sMobileQQ.getResources(), i);
      paramString = paramSparseArray;
      if (paramSparseArray != null)
      {
        paramString = paramSparseArray;
        if (GlobalImageCache.a != null)
        {
          GlobalImageCache.a.put(str, paramSparseArray);
          paramString = paramSparseArray;
        }
      }
    }
    return paramString;
  }
  
  private void updateTdDocTitle(String paramString, AppInterface paramAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = TeamWorkHandlerUtils.a(paramString, paramAppInterface.getCurrentAccountUin());
      if (paramString.getInt("retcode") == 0)
      {
        paramString = (String)((JSONObject)paramString.get("doc_meta")).get("title");
        if (!paramFileManagerEntity.fileName.equals(paramString))
        {
          paramFileManagerEntity.fileName = paramString;
          ((IQQFileDataCenter)paramAppInterface.getRuntimeService(IQQFileDataCenter.class, "all")).updateFileEntity(paramFileManagerEntity);
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void checkDirectShareChangePolicy(int paramInt1, int paramInt2, Intent paramIntent, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((paramInt1 == 2865) && (paramInt2 == -1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkUtils", 1, "direct share done, try change policy");
      }
      Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if ((localObject1 instanceof AppInterface))
      {
        localObject1 = (AppInterface)localObject1;
        if ((ITeamWorkFileImportHandler)((AppInterface)localObject1).getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName()) != null)
        {
          if (paramTeamWorkFileImportInfo == null) {
            return;
          }
          Object localObject2 = paramIntent.getExtras();
          paramIntent = ((Bundle)localObject2).getString("uin");
          paramInt1 = ((Bundle)localObject2).getInt("uintype", 0);
          if (paramTeamWorkFileImportInfo.m != null)
          {
            localObject2 = new ArrayList(1);
            ((List)localObject2).add(paramIntent);
            paramIntent = paramTeamWorkFileImportInfo.m;
            if (!TextUtils.isEmpty(paramIntent)) {
              ThreadManager.excute(new TeamWorkUtilsImpl.2(this, paramIntent, ((AppInterface)localObject1).getCurrentAccountUin(), paramInt1, (List)localObject2), 128, null, false);
            }
          }
        }
      }
    }
  }
  
  public boolean clickWebTDDoc(String paramString, Context paramContext)
  {
    return clickWebTDDocAndUpdateTitle(paramString, paramContext, -1, null, null);
  }
  
  public boolean clickWebTDDocAndUpdateTitle(String paramString, Context paramContext, int paramInt, FileManagerEntity paramFileManagerEntity, AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TencentDoc clickWeb url = ");
      localStringBuilder.append(paramString);
      QLog.d("TeamWorkUtils", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((paramFileManagerEntity != null) && (paramAppInterface != null)) {
      ThreadManager.postImmediately(new TeamWorkUtilsImpl.1(this, paramString, paramAppInterface, paramFileManagerEntity), null, true);
    }
    paramString = paramString.trim();
    if (isDocsUrl(paramString))
    {
      paramFileManagerEntity = new Bundle();
      paramFileManagerEntity.putString("url", paramString);
      paramFileManagerEntity.putString("tdsourcetag", "s_qq_aiomsg");
      paramFileManagerEntity.putInt("tdsourcetab", paramInt);
      ((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(paramContext, paramFileManagerEntity, false);
      return true;
    }
    return false;
  }
  
  public Bitmap decodeBase64ToBitmap(String paramString)
  {
    try
    {
      localObject = new BitmapFactory.Options();
      if (Build.VERSION.SDK_INT > 19) {
        ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
      } else {
        ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_4444;
      }
      paramString = Base64.decode(paramString.split(",")[1], 0);
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length, (BitmapFactory.Options)localObject);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Texture: cannot decode base64: ");
        ((StringBuilder)localObject).append(QLog.getStackTraceString(paramString));
        QLog.d("TeamWorkUtils", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public String excelColIndexToStr(int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    paramInt -= 1;
    Object localObject1 = "";
    int i;
    Object localObject2;
    do
    {
      i = paramInt;
      if (((String)localObject1).length() > 0) {
        i = paramInt - 1;
      }
      localObject2 = new StringBuilder();
      paramInt = i % 26;
      ((StringBuilder)localObject2).append((char)(paramInt + 65));
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
      i = (i - paramInt) / 26;
      localObject1 = localObject2;
      paramInt = i;
    } while (i > 0);
    return localObject2;
  }
  
  public TeamWorkFileImportInfo generateTencentDocImportInfo(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null) {
      return null;
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    localTeamWorkFileImportInfo.jdField_e_of_type_Boolean = false;
    localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = paramFileManagerEntity.fileName;
    localTeamWorkFileImportInfo.jdField_d_of_type_Long = paramFileManagerEntity.fileSize;
    localTeamWorkFileImportInfo.c = paramFileManagerEntity.getFilePath();
    localTeamWorkFileImportInfo.jdField_e_of_type_Int = paramFileManagerEntity.nFileType;
    localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = paramBoolean;
    localTeamWorkFileImportInfo.n = paramFileManagerEntity.WeiYunFileId;
    localTeamWorkFileImportInfo.o = paramFileManagerEntity.Uuid;
    localTeamWorkFileImportInfo.h = paramFileManagerEntity.bSend;
    if (!TextUtils.isEmpty(paramFileManagerEntity.peerUin))
    {
      localTeamWorkFileImportInfo.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
      localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = paramFileManagerEntity.peerUin;
      localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = String.valueOf(paramFileManagerEntity.TroopUin);
      localTeamWorkFileImportInfo.jdField_b_of_type_Int = paramFileManagerEntity.busId;
      localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = paramFileManagerEntity.strTroopFilePath;
      localTeamWorkFileImportInfo.jdField_a_of_type_Long = paramFileManagerEntity.uniseq;
      if (paramFileManagerEntity.status != 16) {
        localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
      }
    }
    return localTeamWorkFileImportInfo;
  }
  
  public String getCloudFileTime(long paramLong)
  {
    try
    {
      Object localObject = toListDate(new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(paramLong)));
      boolean bool = ((String)localObject).equals(this.TODAY);
      if (bool)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.TODAY);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(new SimpleDateFormat("HH:mm").format(Long.valueOf(paramLong)));
        return ((StringBuilder)localObject).toString();
      }
      if (((String)localObject).equals(this.YESTERDAY))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.YESTERDAY);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(new SimpleDateFormat("HH:mm").format(Long.valueOf(paramLong)));
        return ((StringBuilder)localObject).toString();
      }
      localObject = new SimpleDateFormat("MM-dd HH:mm").format(Long.valueOf(paramLong));
      return localObject;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return "";
  }
  
  public online_docs.DocId getDocId(long paramLong, String paramString)
  {
    online_docs.DocId localDocId = new online_docs.DocId();
    localDocId.pad_id.set(ByteStringMicro.copyFromUtf8(paramString));
    localDocId.domain_id.set(paramLong);
    return localDocId;
  }
  
  public String getNoDotExtension(String paramString)
  {
    paramString = FileUtil.a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return paramString.toLowerCase().replace(".", "");
  }
  
  public String getNoParamUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String[] arrayOfString = paramString.split("\\?");
    String str = paramString;
    if (arrayOfString != null)
    {
      str = paramString;
      if (arrayOfString.length > 0) {
        str = arrayOfString[0];
      }
    }
    return str;
  }
  
  public String getPadInfoUrl(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    String[] arrayOfString1 = paramString.split("\\?");
    paramString = localStringBuilder;
    if (arrayOfString1 != null)
    {
      paramString = localStringBuilder;
      if (arrayOfString1.length > 0)
      {
        int j = 0;
        localStringBuilder = new StringBuilder(arrayOfString1[0]);
        int i = j;
        if (arrayOfString1.length > 1)
        {
          arrayOfString1 = arrayOfString1[1].split("&");
          i = j;
          if (arrayOfString1 != null)
          {
            int k = 0;
            int m;
            for (i = 0; k < arrayOfString1.length; i = m)
            {
              String[] arrayOfString2 = arrayOfString1[k].split("=");
              m = i;
              if (arrayOfString2 != null)
              {
                m = i;
                if (arrayOfString2.length == 2)
                {
                  paramString = null;
                  if (arrayOfString2[0].equals("type"))
                  {
                    if (i == 0) {
                      localStringBuilder.append("?");
                    }
                    if (i != 0) {
                      localStringBuilder.append("&");
                    }
                    paramString = new StringBuilder();
                    paramString.append("type=");
                    paramString.append(arrayOfString2[1]);
                  }
                  for (paramString = paramString.toString();; paramString = paramString.toString())
                  {
                    j = 1;
                    break;
                    j = i;
                    if (!arrayOfString2[0].equals("_wv")) {
                      break;
                    }
                    if (i == 0) {
                      localStringBuilder.append("?");
                    }
                    if (i != 0) {
                      localStringBuilder.append("&");
                    }
                    paramString = new StringBuilder();
                    paramString.append("_wv=");
                    paramString.append(arrayOfString2[1]);
                  }
                  m = j;
                  if (paramString != null)
                  {
                    localStringBuilder.append(paramString);
                    m = j;
                  }
                }
              }
              k += 1;
            }
          }
        }
        paramString = localStringBuilder;
        if (i == 0) {
          if (paramInt != 1)
          {
            paramString = localStringBuilder;
            if (paramInt != 2) {}
          }
          else
          {
            localStringBuilder.append("?type=");
            localStringBuilder.append(paramInt);
            localStringBuilder.append("&_wv=1");
            paramString = localStringBuilder;
          }
        }
      }
    }
    return paramString.toString();
  }
  
  public Bitmap getShareBitMapBase64(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTeamWorkForWXMiniProShareBitMap mMiniProgramImageUrl = ");
        localStringBuilder.append(paramString);
        QLog.e("TeamWorkUtils", 2, localStringBuilder.toString());
      }
      if ((!TextUtils.isEmpty(paramString)) && (isBase64ImgFormatData(paramString)))
      {
        paramString = decodeBase64ToBitmap(paramString);
        return paramString;
      }
    }
    catch (IllegalArgumentException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError paramString) {}
    return null;
  }
  
  public String getTDDocFileThumbUrl(String paramString)
  {
    if (FMConstants.b(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/fd11abde219141a6f97e79c7fde6b71f.png";
    }
    if (FMConstants.c(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/f15795a2b4c9a5f7668f10eb78d27499.png";
    }
    if (FMConstants.e(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/ed532c207b5439a6c29ce241ad7decb7.png";
    }
    if (FMConstants.d(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/fcbfa8f749abb54bf66b48e93c82b295.png";
    }
    if (FMConstants.f(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/90226039f41abf0e1f42e46a5350e364.png";
    }
    return "";
  }
  
  public QIPCModule getTDIPCModule()
  {
    return new TDFileQIPCModule();
  }
  
  public String getTDocFileType(String paramString)
  {
    if (FMConstants.b(paramString)) {
      return String.valueOf(1);
    }
    if (FMConstants.c(paramString)) {
      return String.valueOf(2);
    }
    if (FMConstants.e(paramString)) {
      return String.valueOf(3);
    }
    if (FMConstants.d(paramString)) {
      return String.valueOf(4);
    }
    return "";
  }
  
  public Bitmap getTeamWorkForH5ShareBitMap(int paramInt)
  {
    return obtainShareBitmap(WX_H5_SHARE_TYPE_ICON_MAP, 2130850047, "static://DefaultTeamWorkH5ShareDoc", paramInt);
  }
  
  public Bitmap getTeamWorkForShareBitMap(int paramInt)
  {
    return obtainShareBitmap(WX_MINI_SHARE_TYPE_ICON_MAP, 2130850048, "static://DefaultTeamWorkMiniShareDoc", paramInt);
  }
  
  /* Error */
  public String getTencentDocLocalCacheFromFile(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 400	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 6
    //   15: aconst_null
    //   16: astore 4
    //   18: aload 6
    //   20: astore_3
    //   21: new 747	java/io/File
    //   24: dup
    //   25: aload_1
    //   26: invokevirtual 753	android/content/Context:getCacheDir	()Ljava/io/File;
    //   29: aload_2
    //   30: invokespecial 756	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore_1
    //   34: aload 6
    //   36: astore_3
    //   37: aload_1
    //   38: invokevirtual 759	java/io/File:exists	()Z
    //   41: ifeq +55 -> 96
    //   44: aload 6
    //   46: astore_3
    //   47: new 761	java/io/BufferedReader
    //   50: dup
    //   51: new 763	java/io/FileReader
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 766	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   59: invokespecial 769	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 772	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: astore_2
    //   68: aload_2
    //   69: ifnonnull +6 -> 75
    //   72: goto +26 -> 98
    //   75: aload 7
    //   77: aload_2
    //   78: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: goto -19 -> 63
    //   85: goto +104 -> 189
    //   88: astore_2
    //   89: goto +40 -> 129
    //   92: astore_2
    //   93: goto +68 -> 161
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_1
    //   99: ifnull +15 -> 114
    //   102: aload_1
    //   103: invokevirtual 775	java/io/BufferedReader:close	()V
    //   106: goto +8 -> 114
    //   109: astore_1
    //   110: aload_1
    //   111: invokevirtual 776	java/io/IOException:printStackTrace	()V
    //   114: aload 7
    //   116: invokevirtual 410	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: areturn
    //   120: aload_3
    //   121: astore_1
    //   122: goto +67 -> 189
    //   125: astore_2
    //   126: aload 4
    //   128: astore_1
    //   129: aload_1
    //   130: astore_3
    //   131: aload_2
    //   132: invokevirtual 776	java/io/IOException:printStackTrace	()V
    //   135: aload_1
    //   136: ifnull +15 -> 151
    //   139: aload_1
    //   140: invokevirtual 775	java/io/BufferedReader:close	()V
    //   143: goto +8 -> 151
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 776	java/io/IOException:printStackTrace	()V
    //   151: aload 7
    //   153: invokevirtual 410	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: areturn
    //   157: astore_2
    //   158: aload 5
    //   160: astore_1
    //   161: aload_1
    //   162: astore_3
    //   163: aload_2
    //   164: invokevirtual 777	java/io/FileNotFoundException:printStackTrace	()V
    //   167: aload_1
    //   168: ifnull +15 -> 183
    //   171: aload_1
    //   172: invokevirtual 775	java/io/BufferedReader:close	()V
    //   175: goto +8 -> 183
    //   178: astore_1
    //   179: aload_1
    //   180: invokevirtual 776	java/io/IOException:printStackTrace	()V
    //   183: aload 7
    //   185: invokevirtual 410	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: areturn
    //   189: aload_1
    //   190: ifnull +15 -> 205
    //   193: aload_1
    //   194: invokevirtual 775	java/io/BufferedReader:close	()V
    //   197: goto +8 -> 205
    //   200: astore_1
    //   201: aload_1
    //   202: invokevirtual 776	java/io/IOException:printStackTrace	()V
    //   205: aload 7
    //   207: invokevirtual 410	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: areturn
    //   211: astore_1
    //   212: goto -92 -> 120
    //   215: astore_2
    //   216: goto -131 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	TeamWorkUtilsImpl
    //   0	219	1	paramContext	Context
    //   0	219	2	paramString	String
    //   20	143	3	localObject1	Object
    //   16	111	4	localObject2	Object
    //   10	149	5	localObject3	Object
    //   13	32	6	localObject4	Object
    //   7	199	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   63	68	88	java/io/IOException
    //   75	82	88	java/io/IOException
    //   63	68	92	java/io/FileNotFoundException
    //   75	82	92	java/io/FileNotFoundException
    //   102	106	109	java/io/IOException
    //   21	34	125	java/io/IOException
    //   37	44	125	java/io/IOException
    //   47	63	125	java/io/IOException
    //   139	143	146	java/io/IOException
    //   21	34	157	java/io/FileNotFoundException
    //   37	44	157	java/io/FileNotFoundException
    //   47	63	157	java/io/FileNotFoundException
    //   171	175	178	java/io/IOException
    //   193	197	200	java/io/IOException
    //   21	34	211	finally
    //   37	44	211	finally
    //   47	63	211	finally
    //   131	135	211	finally
    //   163	167	211	finally
    //   63	68	215	finally
    //   75	82	215	finally
  }
  
  public String getTencentDocSourceAdtagStrUrl(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("?tdsourcetag=");
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
      if (paramString1.contains("?"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("&tdsourcetag=");
        ((StringBuilder)localObject).append(paramString2);
        localObject = ((StringBuilder)localObject).toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append((String)localObject);
      localObject = localStringBuilder.toString();
      TenDocLogReportHelper.a(null, TenDocLogReportHelper.c(paramString1), "0X8009EA0", paramString2, TenDocLogReportHelper.d(paramString1), "");
      TenDocLogReportHelper.a("TeamWorkUtils", "tdsourcetag", paramString2);
      return localObject;
    }
    return "";
  }
  
  public String getTencentDocWithEditedUrl(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = URLEncoder.encode(paramString2, "UTF-8");
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = new StringBuilder();
        paramString2.append("?edited_url=");
        paramString2.append((String)localObject);
        paramString2 = paramString2.toString();
        if (paramString1.contains("?"))
        {
          paramString2 = new StringBuilder();
          paramString2.append("&edited_url=");
          paramString2.append((String)localObject);
          paramString2 = paramString2.toString();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(paramString2);
        paramString1 = ((StringBuilder)localObject).toString();
        return paramString1;
      }
    }
    catch (UnsupportedEncodingException paramString1)
    {
      QLog.e("TeamWorkUtils", 1, paramString1.getLocalizedMessage(), paramString1);
    }
    return "";
  }
  
  public String getTencentDocWithReadOnlyParam(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str;
      if (paramString.contains("?")) {
        str = "&m_readonly=1";
      } else {
        str = "?m_readonly=1";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String getTime8(String paramString)
  {
    paramString = Pattern.compile("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]").matcher(paramString);
    if (paramString.find()) {
      return paramString.group(0);
    }
    return "";
  }
  
  public boolean gotoAIOTencentDocListWebH5(AppInterface paramAppInterface, Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    for (;;)
    {
      try
      {
        str2 = TencentDocAIOPlusPanelEntryConfigProcessor.a().a();
        String str1 = str2;
        if (str2 == null) {
          str1 = "https://docs.qq.com/desktop/m/send.html";
        }
        String str3 = URLEncoder.encode(paramString2, "UTF-8");
        paramString2 = "";
        if (paramInt == 1)
        {
          str2 = "group_aio";
          paramString2 = str2;
          if ((paramAppInterface instanceof BaseQQAppInterface))
          {
            paramAppInterface = TroopManagerProxy.a((BaseQQAppInterface)paramAppInterface, paramString1);
            paramString2 = str2;
            if (paramAppInterface != null)
            {
              l = paramAppInterface.dwGroupClassExt;
              paramAppInterface = new StringBuilder();
              paramAppInterface.append(str1);
              paramAppInterface.append("?toUin=");
              paramAppInterface.append(paramString1);
              paramAppInterface.append("&uinType=");
              paramAppInterface.append(String.valueOf(paramInt));
              paramAppInterface.append("&remarkName=");
              paramAppInterface.append(str3);
              paramAppInterface = paramAppInterface.toString();
              if (str1.contains("?"))
              {
                paramAppInterface = new StringBuilder();
                paramAppInterface.append(str1);
                paramAppInterface.append("&toUin=");
                paramAppInterface.append(paramString1);
                paramAppInterface.append("&uinType=");
                paramAppInterface.append(String.valueOf(paramInt));
                paramAppInterface.append("&remarkName=");
                paramAppInterface.append(str3);
                paramAppInterface = paramAppInterface.toString();
              }
              paramString2 = paramAppInterface;
              if (!TextUtils.isEmpty(str2))
              {
                paramString2 = new StringBuilder();
                paramString2.append(paramAppInterface);
                paramString2.append("&create_from=");
                paramString2.append(str2);
                paramString2 = paramString2.toString();
              }
              paramAppInterface = paramString2;
              if (l != -1L)
              {
                paramAppInterface = new StringBuilder();
                paramAppInterface.append(paramString2);
                paramAppInterface.append("&group_type=");
                paramAppInterface.append(l);
                paramAppInterface = paramAppInterface.toString();
              }
              paramActivity = new ActivityURIRequest(paramActivity, "/base/browser");
              paramActivity.extra().putString("url", paramAppInterface);
              paramActivity.extra().putString("toUin", paramString1);
              paramActivity.extra().putInt("uinType", paramInt);
              paramActivity.extra().putString("big_brother_source_key", "biz_src_jc_xiaolv");
              QRoute.startUri(paramActivity, null);
              return true;
            }
          }
        }
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        return true;
      }
      long l = -1L;
      String str2 = paramString2;
    }
  }
  
  public boolean gotoTeamWorkListWebH5(AppInterface paramAppInterface, Activity paramActivity)
  {
    try
    {
      if (TextUtils.isEmpty(TencentDocConvertConfigProcessor.a().h())) {
        paramAppInterface = "https://docs.qq.com/desktop/m/index.html?_from=1";
      } else {
        paramAppInterface = TencentDocConvertConfigProcessor.a().h();
      }
      paramActivity = new ActivityURIRequest(paramActivity, "/base/browser");
      paramActivity.extra().putString("big_brother_source_key", "biz_src_jc_xiaolv");
      paramActivity.extra().putString("url", paramAppInterface);
      QRoute.startUri(paramActivity, null);
    }
    catch (Exception paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
    return true;
  }
  
  public boolean gotoTeamWorkWebH5(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramContext = new ActivityURIRequest(paramContext, "/base/browser");
      paramContext.extra().putString("big_brother_source_key", "biz_src_jc_file");
      paramContext.extra().putString("url", paramString);
      QRoute.startUri(paramContext, null);
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return true;
  }
  
  public boolean isBase64ImgFormatData(String paramString)
  {
    return (paramString.startsWith("data:image/jpg;base64,")) || (paramString.startsWith("data:image/png;base64,")) || (paramString.startsWith("data:image/jpeg;base64,")) || (paramString.startsWith("data:image/gif;base64,"));
  }
  
  public boolean isCollectionNotEmpty(Collection paramCollection)
  {
    return (paramCollection != null) && (!paramCollection.isEmpty());
  }
  
  public boolean isDocOrXLS(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = new File(paramString1);
        str = paramString2;
        if (paramString1.exists()) {
          str = paramString1.getName();
        }
      }
    }
    paramString1 = FileUtil.a(str);
    return (!TextUtils.isEmpty(paramString1)) && (".doc|.docx|.xls|.xlsx|".indexOf(paramString1.toLowerCase()) >= 0);
  }
  
  public boolean isDocsFile(String paramString)
  {
    return ".doc|.docx|.xls|.xlsx|".contains(paramString);
  }
  
  public boolean isDocsFormUrl(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = true;
    if ((!bool2) && ((paramString.contains("docs.qq.com/form")) || (paramString.contains("docx.qq.com/form")))) {
      try
      {
        paramString = new URL(paramString).getPath();
        if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("/")) && (!paramString.equals("/index.html")) && (!paramString.equals("/mobile.html")))
        {
          bool2 = paramString.equals("/login.html");
          if (!bool2) {
            return bool1;
          }
        }
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" detect docHome error: ");
        localStringBuilder.append(paramString.toString());
        QLog.e("docHome", 1, localStringBuilder.toString());
        return true;
      }
    } else {
      bool1 = false;
    }
    return bool1;
  }
  
  public boolean isDocsSupport(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = new File(paramString1);
        str = paramString2;
        if (paramString1.exists()) {
          str = paramString1.getName();
        }
      }
    }
    paramString1 = FileUtil.a(str);
    return (!TextUtils.isEmpty(paramString1)) && (paramString3.indexOf(paramString1.toLowerCase()) >= 0);
  }
  
  public boolean isDocsUrl(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = true;
    if ((!bool2) && ((paramString.contains("docs.qq.com")) || (paramString.contains("docx.qq.com")))) {
      try
      {
        paramString = new URL(paramString).getPath();
        if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("/")) && (!paramString.equals("/index.html")) && (!paramString.equals("/mobile.html")))
        {
          bool2 = paramString.equals("/login.html");
          if (!bool2) {
            return bool1;
          }
        }
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" detect docHome error: ");
        localStringBuilder.append(paramString.toString());
        QLog.e("docHome", 1, localStringBuilder.toString());
        return true;
      }
    } else {
      bool1 = false;
    }
    return bool1;
  }
  
  public boolean isDocsUrlForPreLoad(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.contains("docs.qq.com/doc/")) || (paramString.contains("docs.qq.com/sheet/")) || (paramString.contains("docs.qq.com/form/fill/")) || (paramString.contains("docs.qq.com/form/edit/")));
  }
  
  public boolean isFastClick()
  {
    long l = System.currentTimeMillis();
    boolean bool;
    if (l - lastClickTime >= 1000L) {
      bool = false;
    } else {
      bool = true;
    }
    lastClickTime = l;
    return bool;
  }
  
  public boolean isPushMessageDuplicated(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (mLastMsgSeq == paramInt)
        {
          bool = true;
          mLastMsgSeq = paramInt;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void jumpToTencentDocIndex(Activity paramActivity, String paramString, int paramInt)
  {
    try
    {
      if (TextUtils.isEmpty(TencentDocConvertConfigProcessor.a().h())) {
        str1 = "https://docs.qq.com/desktop/m/index.html?_from=1";
      } else {
        str1 = TencentDocConvertConfigProcessor.a().h();
      }
      String str2 = getTencentDocSourceAdtagStrUrl(str1, paramString);
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramActivity, "/base/browser");
      localActivityURIRequest.extra().putString("tdsourcetag", paramString);
      localActivityURIRequest.extra().putString("big_brother_source_key", "biz_src_jc_file");
      localActivityURIRequest.extra().putString("fragment_class", ((ITeamWorkDocsListFragment)QRoute.api(ITeamWorkDocsListFragment.class)).getCanonicalName());
      localActivityURIRequest.extra().putString("url", str2);
      String str1 = paramString;
      if (TextUtils.equals(paramString, "s_qq_history_tab")) {
        str1 = "s_qq_myfile";
      }
      if (!((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openDocsMiniApp(paramActivity, str2, str1))
      {
        if (paramInt >= 0) {
          localActivityURIRequest.setRequestCode(paramInt);
        }
        QRoute.startUri(localActivityURIRequest, null);
        return;
      }
    }
    catch (Exception paramActivity)
    {
      QLog.i("TeamWorkUtils", 1, paramActivity.toString());
    }
  }
  
  public void openGroupPadTemplateListUrl(AppInterface paramAppInterface, Activity paramActivity, int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    Object localObject = String.valueOf(paramLong1);
    int i = 3;
    StringBuilder localStringBuilder;
    if (paramInt == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append(".");
      localStringBuilder.append("docs.qq.com/desktop/m/templates_list.html?padtype=0&_wv=2&_wwv=512");
      localStringBuilder.append("&group_code=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("&group_type=");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("&create_from=");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
    }
    for (;;)
    {
      break;
      if (paramInt == 2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https://");
        localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
        localStringBuilder.append(".");
        localStringBuilder.append("docs.qq.com/desktop/m/templates_list.html?padtype=1&_wv=2&_wwv=512");
        localStringBuilder.append("&group_code=");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("&group_type=");
        localStringBuilder.append(paramLong2);
        localStringBuilder.append("&create_from=");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
      }
      else if (paramInt == 3)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https://");
        localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
        localStringBuilder.append(".");
        localStringBuilder.append("docs.qq.com/desktop/m/templates_list.html?padtype=2&_wv=2&_wwv=512");
        localStringBuilder.append("&group_code=");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("&group_type=");
        localStringBuilder.append(paramLong2);
        localStringBuilder.append("&create_from=");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
      }
      else
      {
        paramString = "";
      }
    }
    if (paramInt == 1) {}
    do
    {
      paramInt = 1;
      break;
      if (paramInt == 2)
      {
        paramInt = 2;
        break;
      }
    } while (paramInt != 3);
    paramInt = i;
    localObject = new Bundle();
    ((Bundle)localObject).putString("url", paramString);
    ((Bundle)localObject).putString("title", paramActivity.getString(2131719546));
    ((Bundle)localObject).putInt("key_team_work_edit_type", paramInt);
    if ((paramAppInterface instanceof BaseQQAppInterface))
    {
      paramAppInterface = TroopManagerProxy.a((BaseQQAppInterface)paramAppInterface, String.valueOf(paramLong1));
      if ((paramAppInterface != null) && (!TextUtils.isEmpty(paramAppInterface.troopname)))
      {
        ((Bundle)localObject).putString("troop_name", paramAppInterface.troopname);
      }
      else
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("");
        paramAppInterface.append(paramLong1);
        ((Bundle)localObject).putString("troop_name", paramAppInterface.toString());
      }
    }
    ((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(paramActivity, (Bundle)localObject, true);
  }
  
  public void openGroupPadTemplatePreviewUrl(AppInterface paramAppInterface, Activity paramActivity, String paramString, long paramLong, GroupPadTemplateInfo paramGroupPadTemplateInfo)
  {
    int i;
    int j;
    Object localObject2;
    if (paramGroupPadTemplateInfo != null)
    {
      i = paramGroupPadTemplateInfo.docOrSheetType;
      j = paramGroupPadTemplateInfo.templateID;
      localObject2 = String.valueOf(paramGroupPadTemplateInfo.groupCode);
      paramGroupPadTemplateInfo = paramGroupPadTemplateInfo.templateUrl;
    }
    else
    {
      paramGroupPadTemplateInfo = "";
      localObject2 = paramGroupPadTemplateInfo;
      i = 1;
      j = 0;
    }
    if (!TextUtils.isEmpty(paramGroupPadTemplateInfo))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https:");
      ((StringBuilder)localObject1).append(paramGroupPadTemplateInfo);
      paramGroupPadTemplateInfo = ((StringBuilder)localObject1).toString();
      if (!URLUtil.a(paramGroupPadTemplateInfo))
      {
        localObject1 = paramGroupPadTemplateInfo;
      }
      else
      {
        k = 0;
        localObject1 = paramGroupPadTemplateInfo;
        break label128;
      }
    }
    else
    {
      localObject1 = "";
    }
    int k = 1;
    label128:
    int m = 2;
    paramGroupPadTemplateInfo = (GroupPadTemplateInfo)localObject1;
    if (k != 0) {
      if (i == 1)
      {
        paramGroupPadTemplateInfo = String.format("docs.qq.com/template/preview?padtype=doc&tid=%s&pdid=null", new Object[] { Integer.valueOf(j) });
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("https://");
        ((StringBuilder)localObject1).append(paramAppInterface.getCurrentAccountUin());
        ((StringBuilder)localObject1).append(".");
        ((StringBuilder)localObject1).append(paramGroupPadTemplateInfo);
        ((StringBuilder)localObject1).append("&group_code=");
        ((StringBuilder)localObject1).append((String)localObject2);
        paramGroupPadTemplateInfo = ((StringBuilder)localObject1).toString();
      }
      else
      {
        paramGroupPadTemplateInfo = (GroupPadTemplateInfo)localObject1;
        if (i == 2)
        {
          paramGroupPadTemplateInfo = String.format("docs.qq.com/template/preview?padtype=sheet&tid=%s&pdid=null", new Object[] { Integer.valueOf(j) });
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("https://");
          ((StringBuilder)localObject1).append(paramAppInterface.getCurrentAccountUin());
          ((StringBuilder)localObject1).append(".");
          ((StringBuilder)localObject1).append(paramGroupPadTemplateInfo);
          ((StringBuilder)localObject1).append("&group_code=");
          ((StringBuilder)localObject1).append((String)localObject2);
          paramGroupPadTemplateInfo = ((StringBuilder)localObject1).toString();
        }
      }
    }
    Object localObject1 = paramGroupPadTemplateInfo;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = paramGroupPadTemplateInfo;
      if (paramLong != -1L)
      {
        localObject1 = paramGroupPadTemplateInfo;
        if (!TextUtils.isEmpty(paramGroupPadTemplateInfo)) {
          if (paramGroupPadTemplateInfo.contains("?"))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramGroupPadTemplateInfo);
            ((StringBuilder)localObject1).append("&group_type=");
            ((StringBuilder)localObject1).append(paramLong);
            ((StringBuilder)localObject1).append("&create_from=");
            ((StringBuilder)localObject1).append(paramString);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramGroupPadTemplateInfo);
            ((StringBuilder)localObject1).append("?group_type=");
            ((StringBuilder)localObject1).append(paramLong);
            ((StringBuilder)localObject1).append("&create_from=");
            ((StringBuilder)localObject1).append(paramString);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
      }
    }
    if ((i != 1) && (i == 2)) {
      i = m;
    } else {
      i = 1;
    }
    paramString = new Bundle();
    paramString.putString("tdsourcetag", "s_qq_grpfile");
    paramString.putString("url", (String)localObject1);
    paramString.putInt("key_team_work_edit_type", i);
    if ((paramAppInterface instanceof BaseQQAppInterface))
    {
      paramAppInterface = TroopManagerProxy.a((BaseQQAppInterface)paramAppInterface, (String)localObject2);
      if ((paramAppInterface != null) && (!TextUtils.isEmpty(paramAppInterface.troopname)))
      {
        paramString.putString("troop_name", paramAppInterface.troopname);
      }
      else
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("");
        paramAppInterface.append((String)localObject2);
        paramString.putString("troop_name", paramAppInterface.toString());
      }
    }
    ((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(paramActivity, paramString, true);
  }
  
  public boolean openTroopFormMiniApp(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("troopFormLog openTroopFormMiniApp =");
    ((StringBuilder)localObject).append(paramString1);
    QLog.d("TeamWorkUtils", 1, ((StringBuilder)localObject).toString());
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString1);
        localObject = "";
        if (!bool)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("pages/detail/detail");
          localStringBuilder.append("?url=");
          localStringBuilder.append(URLEncoder.encode(paramString1, "utf-8"));
          if (TextUtils.isEmpty(paramString2))
          {
            paramString2 = (String)localObject;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("&");
            ((StringBuilder)localObject).append(paramString2);
            paramString2 = ((StringBuilder)localObject).toString();
          }
          localStringBuilder.append(paramString2);
          paramString2 = localStringBuilder.toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("url=");
          ((StringBuilder)localObject).append(paramString1);
          localObject = ((StringBuilder)localObject).toString();
          paramString1 = paramString2;
          paramString2 = (String)localObject;
          ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById(paramContext, "1108961705", paramString1, paramString2, "", "", 0, null);
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("openTroopFormMiniApp:open :scene = ");
            paramContext.append(0);
            paramContext.append("miniAppId = ");
            paramContext.append("1108961705");
            paramContext.append("entryPath = ");
            paramContext.append(paramString1);
            paramContext.append("navigateExtData = ");
            paramContext.append(paramString2);
            QLog.i("TeamWorkUtils", 2, paramContext.toString());
          }
          return true;
        }
      }
      catch (UnsupportedEncodingException paramContext)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("openTroopFormMiniApp ");
          paramString1.append(paramContext.getMessage());
          QLog.e("TeamWorkUtils", 2, paramString1.toString());
        }
        return false;
      }
      paramString1 = "pages/detail/detail";
      paramString2 = "";
    }
  }
  
  public ArrayList<TencentDocData> parseTencentDocRspJson(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      if (((JSONObject)localObject).getInt("retcode") == 0)
      {
        paramString = new ArrayList();
        localObject = ((JSONObject)localObject).getJSONArray("recent_file_list");
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          paramString.add(TencentDocData.creatorFromJsonObject((JSONObject)((JSONArray)localObject).get(i)));
          i += 1;
        }
        return paramString;
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TeamWorkUtils", 1, paramString.getMessage());
      }
    }
    return null;
  }
  
  /* Error */
  public com.tencent.mobileqq.teamwork.DocsGrayTipsInfo paseDocsGrayTipsInfoFromJson(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 262	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +39 -> 43
    //   7: new 400	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   14: astore_1
    //   15: aload_1
    //   16: ldc 25
    //   18: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_1
    //   23: getstatic 1143	com/tencent/mobileqq/teamwork/TeamWorkConstants:i	Ljava/lang/String;
    //   26: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_1
    //   31: invokevirtual 410	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: iconst_2
    //   35: ldc_w 1145
    //   38: invokestatic 413	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aconst_null
    //   42: areturn
    //   43: new 1147	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo
    //   46: dup
    //   47: invokespecial 1148	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:<init>	()V
    //   50: astore 4
    //   52: aload 4
    //   54: aload_2
    //   55: putfield 1149	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   58: aload 4
    //   60: aload_3
    //   61: putfield 1150	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   64: new 277	org/json/JSONObject
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 1117	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   72: astore_1
    //   73: aload_1
    //   74: ldc_w 674
    //   77: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   80: ifeq +15 -> 95
    //   83: aload 4
    //   85: aload_1
    //   86: ldc_w 674
    //   89: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   92: putfield 1155	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:c	Ljava/lang/String;
    //   95: aload_1
    //   96: ldc_w 1157
    //   99: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   102: ifeq +15 -> 117
    //   105: aload 4
    //   107: aload_1
    //   108: ldc_w 1157
    //   111: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: putfield 1158	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   117: aload_1
    //   118: ldc_w 1160
    //   121: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   124: ifeq +15 -> 139
    //   127: aload 4
    //   129: aload_1
    //   130: ldc_w 1160
    //   133: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   136: putfield 1161	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   139: aload_1
    //   140: ldc_w 1163
    //   143: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   146: ifeq +15 -> 161
    //   149: aload 4
    //   151: aload_1
    //   152: ldc_w 1163
    //   155: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   158: putfield 1165	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:f	Ljava/lang/String;
    //   161: aload_1
    //   162: ldc_w 1167
    //   165: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   168: ifeq +15 -> 183
    //   171: aload 4
    //   173: aload_1
    //   174: ldc_w 1167
    //   177: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   180: putfield 1169	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:h	Ljava/lang/String;
    //   183: aload_1
    //   184: ldc_w 1171
    //   187: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   190: ifeq +15 -> 205
    //   193: aload 4
    //   195: aload_1
    //   196: ldc_w 1171
    //   199: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   202: putfield 1174	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:g	Ljava/lang/String;
    //   205: aload_1
    //   206: ldc_w 1176
    //   209: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   212: ifeq +15 -> 227
    //   215: aload 4
    //   217: aload_1
    //   218: ldc_w 1176
    //   221: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   224: putfield 1177	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:i	Ljava/lang/String;
    //   227: aload_1
    //   228: ldc_w 1179
    //   231: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   234: ifeq +15 -> 249
    //   237: aload 4
    //   239: aload_1
    //   240: ldc_w 1179
    //   243: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   246: putfield 1182	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:j	Ljava/lang/String;
    //   249: aload_1
    //   250: ldc_w 1184
    //   253: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   256: ifeq +15 -> 271
    //   259: aload 4
    //   261: aload_1
    //   262: ldc_w 1184
    //   265: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   268: putfield 1187	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:k	Ljava/lang/String;
    //   271: aload_1
    //   272: ldc_w 1189
    //   275: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   278: ifeq +15 -> 293
    //   281: aload 4
    //   283: aload_1
    //   284: ldc_w 1189
    //   287: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   290: putfield 1192	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:l	Ljava/lang/String;
    //   293: aload_1
    //   294: ldc_w 1194
    //   297: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   300: ifeq +15 -> 315
    //   303: aload 4
    //   305: aload_1
    //   306: ldc_w 1194
    //   309: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   312: putfield 1195	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:m	Ljava/lang/String;
    //   315: aload_1
    //   316: ldc_w 1197
    //   319: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   322: ifeq +15 -> 337
    //   325: aload 4
    //   327: aload_1
    //   328: ldc_w 1197
    //   331: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   334: putfield 1198	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:n	Ljava/lang/String;
    //   337: aload_1
    //   338: ldc_w 1200
    //   341: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   344: ifeq +15 -> 359
    //   347: aload 4
    //   349: aload_1
    //   350: ldc_w 1200
    //   353: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   356: putfield 1201	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:o	Ljava/lang/String;
    //   359: aload_1
    //   360: ldc_w 1203
    //   363: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   366: ifeq +15 -> 381
    //   369: aload 4
    //   371: aload_1
    //   372: ldc_w 1203
    //   375: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   378: putfield 1206	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:p	Ljava/lang/String;
    //   381: aload_1
    //   382: ldc_w 1208
    //   385: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   388: ifeq +15 -> 403
    //   391: aload 4
    //   393: aload_1
    //   394: ldc_w 1208
    //   397: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   400: putfield 1211	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:q	Ljava/lang/String;
    //   403: aload_1
    //   404: ldc_w 1213
    //   407: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   410: ifeq +15 -> 425
    //   413: aload 4
    //   415: aload_1
    //   416: ldc_w 1213
    //   419: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   422: putfield 1216	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:r	Ljava/lang/String;
    //   425: aload_1
    //   426: ldc_w 1218
    //   429: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   432: ifeq +15 -> 447
    //   435: aload 4
    //   437: aload_1
    //   438: ldc_w 1218
    //   441: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   444: putfield 1221	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:s	Ljava/lang/String;
    //   447: aload 4
    //   449: astore_2
    //   450: aload_1
    //   451: ldc_w 1223
    //   454: invokevirtual 1153	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   457: ifeq +101 -> 558
    //   460: aload 4
    //   462: aload_1
    //   463: ldc_w 1223
    //   466: invokevirtual 1154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   469: putfield 1226	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:t	Ljava/lang/String;
    //   472: aload 4
    //   474: areturn
    //   475: astore_1
    //   476: aload 4
    //   478: astore_2
    //   479: goto +13 -> 492
    //   482: astore_1
    //   483: aload 4
    //   485: astore_2
    //   486: goto +6 -> 492
    //   489: astore_1
    //   490: aconst_null
    //   491: astore_2
    //   492: new 400	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   499: astore_3
    //   500: aload_3
    //   501: ldc 25
    //   503: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: aload_3
    //   508: getstatic 1143	com/tencent/mobileqq/teamwork/TeamWorkConstants:i	Ljava/lang/String;
    //   511: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload_3
    //   516: invokevirtual 410	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: astore_3
    //   520: new 400	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   527: astore 4
    //   529: aload 4
    //   531: ldc_w 1228
    //   534: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload 4
    //   540: aload_1
    //   541: invokevirtual 975	java/lang/Exception:toString	()Ljava/lang/String;
    //   544: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload_3
    //   549: iconst_1
    //   550: aload 4
    //   552: invokevirtual 410	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 696	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   558: aload_2
    //   559: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	560	0	this	TeamWorkUtilsImpl
    //   0	560	1	paramString1	String
    //   0	560	2	paramString2	String
    //   0	560	3	paramString3	String
    //   50	501	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   64	95	475	java/lang/Exception
    //   95	117	475	java/lang/Exception
    //   117	139	475	java/lang/Exception
    //   139	161	475	java/lang/Exception
    //   161	183	475	java/lang/Exception
    //   183	205	475	java/lang/Exception
    //   205	227	475	java/lang/Exception
    //   227	249	475	java/lang/Exception
    //   249	271	475	java/lang/Exception
    //   271	293	475	java/lang/Exception
    //   293	315	475	java/lang/Exception
    //   315	337	475	java/lang/Exception
    //   337	359	475	java/lang/Exception
    //   359	381	475	java/lang/Exception
    //   381	403	475	java/lang/Exception
    //   403	425	475	java/lang/Exception
    //   425	447	475	java/lang/Exception
    //   450	472	475	java/lang/Exception
    //   52	64	482	java/lang/Exception
    //   43	52	489	java/lang/Exception
  }
  
  public void report(AppInterface paramAppInterface, String paramString)
  {
    ReportController.b(paramAppInterface, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public void reportClickWithTroopType(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if (paramAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      String str = "";
      Object localObject = str;
      if ((paramAppInterface instanceof BaseQQAppInterface))
      {
        paramString2 = TroopManagerProxy.a((BaseQQAppInterface)paramAppInterface, paramString2);
        localObject = str;
        if (paramString2 != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(paramString2.dwGroupClassExt);
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      ReportController.b(paramAppInterface, "CliOper", "", "", paramString1, paramString1, 0, 0, "", "", (String)localObject, "");
    }
  }
  
  public void reportOnlinePreview(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.setClassLoader(TeamWorkUtilsImpl.class.getClassLoader());
    if (!(paramBundle.getParcelable("key_team_work_file_import_info") instanceof TeamWorkFileImportInfo)) {
      return;
    }
    reportOnlinePreview((TeamWorkFileImportInfo)paramBundle.getParcelable("key_team_work_file_import_info"), paramBundle.getString("url"), paramString);
  }
  
  public void reportOnlinePreview(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString1, String paramString2)
  {
    if (paramTeamWorkFileImportInfo != null)
    {
      if (!paramTeamWorkFileImportInfo.d()) {
        return;
      }
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      String str1 = paramTeamWorkFileImportInfo.k;
      String str2 = getNoDotExtension(paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString);
      long l = paramTeamWorkFileImportInfo.jdField_d_of_type_Long;
      boolean bool;
      if ((paramString1 != null) && (paramString1.contains("m_readonly"))) {
        bool = true;
      } else {
        bool = false;
      }
      TenDocLogReportHelper.a(null, str1, paramString2, str2, String.valueOf(bool), String.valueOf(l));
    }
  }
  
  /* Error */
  public void saveTencentDocCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 262	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore 6
    //   14: aconst_null
    //   15: astore 7
    //   17: aload 7
    //   19: astore 4
    //   21: new 747	java/io/File
    //   24: dup
    //   25: aload_1
    //   26: invokevirtual 753	android/content/Context:getCacheDir	()Ljava/io/File;
    //   29: aload_3
    //   30: invokespecial 756	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore_1
    //   34: aload 7
    //   36: astore 4
    //   38: aload_1
    //   39: invokevirtual 759	java/io/File:exists	()Z
    //   42: ifne +12 -> 54
    //   45: aload 7
    //   47: astore 4
    //   49: aload_1
    //   50: invokevirtual 1275	java/io/File:createNewFile	()Z
    //   53: pop
    //   54: aload 7
    //   56: astore 4
    //   58: new 1277	java/io/FileWriter
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 1278	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   66: astore_1
    //   67: aload_1
    //   68: aload_2
    //   69: invokevirtual 1281	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   72: aload_1
    //   73: invokevirtual 1284	java/io/FileWriter:flush	()V
    //   76: aload_1
    //   77: invokevirtual 1285	java/io/FileWriter:close	()V
    //   80: return
    //   81: astore_2
    //   82: aload_1
    //   83: astore 4
    //   85: goto +61 -> 146
    //   88: astore_2
    //   89: goto +15 -> 104
    //   92: astore_2
    //   93: goto +31 -> 124
    //   96: astore_2
    //   97: goto +49 -> 146
    //   100: astore_2
    //   101: aload 5
    //   103: astore_1
    //   104: aload_1
    //   105: astore 4
    //   107: aload_2
    //   108: invokevirtual 776	java/io/IOException:printStackTrace	()V
    //   111: aload_1
    //   112: ifnull +33 -> 145
    //   115: aload_1
    //   116: invokevirtual 1285	java/io/FileWriter:close	()V
    //   119: return
    //   120: astore_2
    //   121: aload 6
    //   123: astore_1
    //   124: aload_1
    //   125: astore 4
    //   127: aload_2
    //   128: invokevirtual 777	java/io/FileNotFoundException:printStackTrace	()V
    //   131: aload_1
    //   132: ifnull +13 -> 145
    //   135: aload_1
    //   136: invokevirtual 1285	java/io/FileWriter:close	()V
    //   139: return
    //   140: astore_1
    //   141: aload_1
    //   142: invokevirtual 776	java/io/IOException:printStackTrace	()V
    //   145: return
    //   146: aload 4
    //   148: ifnull +16 -> 164
    //   151: aload 4
    //   153: invokevirtual 1285	java/io/FileWriter:close	()V
    //   156: goto +8 -> 164
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 776	java/io/IOException:printStackTrace	()V
    //   164: aload_2
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	TeamWorkUtilsImpl
    //   0	166	1	paramContext	Context
    //   0	166	2	paramString1	String
    //   0	166	3	paramString2	String
    //   19	133	4	localObject1	Object
    //   9	93	5	localObject2	Object
    //   12	110	6	localObject3	Object
    //   15	40	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   67	76	81	finally
    //   67	76	88	java/io/IOException
    //   67	76	92	java/io/FileNotFoundException
    //   21	34	96	finally
    //   38	45	96	finally
    //   49	54	96	finally
    //   58	67	96	finally
    //   107	111	96	finally
    //   127	131	96	finally
    //   21	34	100	java/io/IOException
    //   38	45	100	java/io/IOException
    //   49	54	100	java/io/IOException
    //   58	67	100	java/io/IOException
    //   21	34	120	java/io/FileNotFoundException
    //   38	45	120	java/io/FileNotFoundException
    //   49	54	120	java/io/FileNotFoundException
    //   58	67	120	java/io/FileNotFoundException
    //   76	80	140	java/io/IOException
    //   115	119	140	java/io/IOException
    //   135	139	140	java/io/IOException
    //   151	156	159	java/io/IOException
  }
  
  public boolean supportTencentDoc(Map<String, Long> paramMap, String paramString1, String paramString2, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMap != null)
    {
      if (paramMap.isEmpty()) {
        return false;
      }
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        str = paramString2;
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString1 = new File(paramString1);
          str = paramString2;
          if (paramString1.exists()) {
            str = paramString1.getName();
          }
        }
      }
      paramString1 = getNoDotExtension(str);
      if (TextUtils.isEmpty(paramString1)) {
        return false;
      }
      bool1 = bool2;
      if (paramMap.containsKey(paramString1))
      {
        bool1 = bool2;
        if (((Long)paramMap.get(paramString1)).longValue() > paramLong) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean supportTencentDocForEdit(String paramString1, String paramString2, long paramLong)
  {
    return supportTencentDoc(TencentDocConvertConfigProcessor.a().a(), paramString1, paramString2, paramLong);
  }
  
  public boolean supportTencentDocForLocalCooperation(String paramString1, String paramString2, long paramLong)
  {
    return supportTencentDoc(TencentDocLocalCooperationProcessor.a().a, paramString1, paramString2, paramLong);
  }
  
  public boolean supportTencentDocForPreview(String paramString1, String paramString2, long paramLong)
  {
    return supportTencentDoc(TencentDocPreviewConfigProcessor.a().a(), paramString1, paramString2, paramLong);
  }
  
  public boolean targetTencentDocFormKeyWords(String paramString1, String paramString2, long paramLong)
  {
    TencentDocFormKeyWordsBean localTencentDocFormKeyWordsBean = TencentDocFormKeyWordsProcessor.a();
    if (localTencentDocFormKeyWordsBean != null)
    {
      boolean bool2 = supportTencentDoc(localTencentDocFormKeyWordsBean.a, paramString1, paramString2, paramLong);
      boolean bool1 = bool2;
      if (bool2) {
        bool1 = localTencentDocFormKeyWordsBean.a(paramString2);
      }
      return bool1;
    }
    return false;
  }
  
  public String toListDate(String paramString)
  {
    Object localObject1 = new SimpleDateFormat("yyyy-MM-dd");
    Object localObject3 = getTime8(paramString);
    Object localObject2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    localObject3 = ((SimpleDateFormat)localObject1).parse((String)localObject3);
    localObject1 = ((SimpleDateFormat)localObject1).parse((String)localObject2);
    if (((Date)localObject1).getTime() - ((Date)localObject3).getTime() == 0L) {
      return this.TODAY;
    }
    if ((((Date)localObject1).getTime() - ((Date)localObject3).getTime() > 0L) && (((Date)localObject1).getTime() - ((Date)localObject3).getTime() <= 86400000L)) {
      return this.YESTERDAY;
    }
    if ((((Date)localObject1).getTime() - ((Date)localObject3).getTime() > 0L) && (((Date)localObject1).getTime() - ((Date)localObject3).getTime() <= 604800000L)) {
      return this.THIS_WEEK;
    }
    localObject1 = paramString.substring(0, 4);
    paramString = paramString.substring(5, 7);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131714601));
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131714567));
    return ((StringBuilder)localObject2).toString();
  }
  
  public void tryOpenWithTencentDoc(AppInterface paramAppInterface, Context paramContext, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((paramAppInterface != null) && (paramTeamWorkFileImportInfo != null))
    {
      paramTeamWorkFileImportInfo.jdField_d_of_type_Int = 7;
      TeamWorkConvertUtils.a(paramAppInterface, paramContext, paramString, paramTeamWorkFileImportInfo, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkUtils", 2, "appInterface == null || info == null");
    }
  }
  
  public void tryReportHistoryTab(Intent paramIntent, String paramString)
  {
    if (paramIntent != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramIntent = paramIntent.getStringExtra("tdsourcetype");
      if (TextUtils.isEmpty(paramIntent)) {
        return;
      }
      int i;
      if (paramIntent.contains("1")) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", paramString, paramString, i, 0, "", "", "s_qq_history_tab", paramIntent.substring(0, paramIntent.length() - 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkUtilsImpl
 * JD-Core Version:    0.7.0.1
 */