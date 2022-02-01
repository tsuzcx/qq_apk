package com.tencent.mobileqq.filemanager.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.storage.StorageManager;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.Message;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.recreate.QQFileModel;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.teamwork.TencentDocConfig;
import com.tencent.mobileqq.transfile.TimeoutParam;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShortcutUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig.Item;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardProcessor;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONObject;

public class QQFileManagerUtilImpl
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static final String jdField_a_of_type_JavaLangString;
  private static ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = null;
  private static HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private static final char[] jdField_a_of_type_ArrayOfChar = { '…' };
  private static HashMap<String, String> b;
  private static HashMap<Integer, String> c = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = new String(jdField_a_of_type_ArrayOfChar);
    jdField_a_of_type_JavaUtilHashMap = null;
    b = null;
  }
  
  public static int a(int paramInt)
  {
    return a(paramInt, 2);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 11: 
    case 13: 
    default: 
      return 2130844437;
    case 21: 
      return 2130844410;
    case 20: 
      return 2130844390;
    case 19: 
      return 2130844389;
    case 18: 
      return 2130844388;
    case 17: 
      return 2130844364;
    case 16: 
      return 2130844354;
    case 15: 
      return 2130844343;
    case 14: 
      return 2130844323;
    case 12: 
      return 2130844400;
    case 10: 
      return 2130844426;
    case 9: 
      return 2130844391;
    case 8: 
      return 2130844344;
    case 7: 
      return 2130844393;
    case 6: 
      return 2130844448;
    case 5: 
      return 2130844325;
    case 4: 
      return 2130844449;
    case 3: 
      return 2130844340;
    case 2: 
      return 2130844438;
    case 1: 
      return 2130844379;
    }
    return 2130844363;
  }
  
  public static int a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isMultiMsg)
    {
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
      if (!TextUtils.isEmpty(paramChatMessage))
      {
        int i = d(paramChatMessage);
        if ((i == 2) || (i == 0)) {
          return i;
        }
      }
    }
    return -1;
  }
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    int i = paramFileManagerEntity.status;
    int k = 0;
    if ((-1 != i) && (1 != paramFileManagerEntity.status)) {
      i = 0;
    } else {
      i = 1;
    }
    int j = k;
    if (paramFileManagerEntity.bSend)
    {
      j = k;
      if (8 != paramFileManagerEntity.nOpType)
      {
        j = k;
        if (5 != paramFileManagerEntity.nOpType)
        {
          j = k;
          if (1 != paramFileManagerEntity.nOpType) {
            j = 1;
          }
        }
      }
    }
    if (3 == paramFileManagerEntity.getCloudType())
    {
      if ((j == 0) || ((j != 0) && (i != 0)))
      {
        if ((!TextUtils.isEmpty(paramFileManagerEntity.Uuid)) && (paramFileManagerEntity.peerType != 6000)) {
          return 1;
        }
        if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId)) {
          return 2;
        }
        if (!TextUtils.isEmpty(paramFileManagerEntity.strTroopFilePath)) {
          return 4;
        }
      }
      return 3;
    }
    if (((2 == paramFileManagerEntity.getCloudType()) || (1 == paramFileManagerEntity.getCloudType()) || ((4 == paramFileManagerEntity.getCloudType()) && (paramFileManagerEntity.nOpType != 24))) && (j != 0) && (i == 0) && (!TextUtils.isEmpty(paramFileManagerEntity.getFilePath()))) {
      return 3;
    }
    return paramFileManagerEntity.getCloudType();
  }
  
  @TargetApi(9)
  public static int a(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    Object localObject = FileUtil.b(paramString);
    if (b().equalsIgnoreCase((String)localObject)) {
      return 0;
    }
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString, "-");
      if (Build.VERSION.SDK_INT < 9)
      {
        ((SharedPreferences.Editor)localObject).commit();
        return 0;
      }
      ((SharedPreferences.Editor)localObject).apply();
      return 0;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -2;
  }
  
  public static int a(List<FileInfo> paramList, long paramLong)
  {
    int j = paramList.size() - 1;
    int i = 0;
    while (i <= j)
    {
      int k = i + j >>> 1;
      FileInfo localFileInfo = (FileInfo)paramList.get(k);
      if (localFileInfo.b() > paramLong) {
        i = k + 1;
      } else if (localFileInfo.b() < paramLong) {
        j = k - 1;
      } else {
        return k;
      }
    }
    return i;
  }
  
  public static long a()
  {
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    return i;
  }
  
  public static long a(int paramInt)
  {
    if (paramInt != 1000)
    {
      if (paramInt != 1001)
      {
        if (paramInt != 1004)
        {
          if (paramInt != 1006)
          {
            if (paramInt != 1010)
            {
              if (paramInt != 10002)
              {
                if ((paramInt != 1024) && (paramInt != 1025)) {
                  return -1L;
                }
                return 124L;
              }
              return 127L;
            }
            return 109L;
          }
          return 102L;
        }
        return 105L;
      }
      return 100L;
    }
    return 104L;
  }
  
  public static long a(long paramLong)
  {
    return paramLong | 0x80000000;
  }
  
  private static long a(long paramLong, TimeZone paramTimeZone)
  {
    return (paramTimeZone.getOffset(paramLong) + paramLong) / 86400000L;
  }
  
  public static long a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("FileManagerUtil<FileAssistant>", 1, "getFileSizes: filePath is null");
      return 0L;
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" is not exists");
      QLog.w("FileManagerUtil<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return 0L;
    }
    long l = ((File)localObject).length();
    if (0L == l)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" len is 0");
      QLog.w("FileManagerUtil<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    return l;
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        float f = paramContext.getResources().getDisplayMetrics().density;
        int i1 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(paramInt, paramContext.getResources());
        paramInt = (int)(paramBitmap.getWidth() * f);
        int k = (int)(paramBitmap.getHeight() * f);
        int i = paramBitmap.getWidth();
        m = paramBitmap.getHeight();
        if (i > m)
        {
          j = (i - m) / 2;
          paramInt = k;
          i = m;
          break label291;
        }
        if (m > i)
        {
          m = (m - i) / 2;
          n = i;
          j = 0;
          k = paramInt;
          paramContext = Bitmap.createBitmap(paramInt, k, Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas(paramContext);
          Paint localPaint = new Paint();
          Rect localRect1 = new Rect(j, m, i + j, n + m);
          Rect localRect2 = new Rect(0, 0, paramInt, k);
          RectF localRectF = new RectF(localRect2);
          localPaint.setAntiAlias(true);
          localPaint.setDither(true);
          localPaint.setFilterBitmap(true);
          localCanvas.drawARGB(0, 0, 0, 0);
          localPaint.setColor(-12434878);
          f = i1;
          localCanvas.drawRoundRect(localRectF, f, f, localPaint);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
      int j = 0;
      label291:
      int n = m;
      int m = 0;
    }
  }
  
  public static SpannableString a(String paramString1, String paramString2, QQFileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    int i = paramString1.indexOf(paramString2);
    int j = paramString2.length() + i;
    paramString1 = new SpannableString(paramString1);
    paramString2 = new QQFileManagerUtilImpl.3(paramTipsClickedInterface);
    try
    {
      paramString1.setSpan(new ForegroundColorSpan(-12541697), i, j, 33);
      paramString1.setSpan(paramString2, i, j, 33);
      return paramString1;
    }
    catch (Exception paramString2) {}
    return paramString1;
  }
  
  public static BaseQQAppInterface a()
  {
    int i = MobileQQ.sProcessId;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i == 1)
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      localObject1 = localObject2;
      if (localAppRuntime != null)
      {
        localObject1 = localObject2;
        if ((localAppRuntime instanceof BaseQQAppInterface)) {
          localObject1 = (BaseQQAppInterface)localAppRuntime;
        }
      }
    }
    return localObject1;
  }
  
  public static FileManagerEntity a()
  {
    Object localObject3 = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getRecentFiles();
    Object localObject2 = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getLocalFiles();
    Object localObject1 = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getWeiYunFiles();
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject3).next();
        if (localFileManagerEntity.nFileType == 0) {
          return localFileManagerEntity;
        }
      }
    }
    if ((localObject2 != null) && (((Set)localObject2).size() > 0))
    {
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileInfo)((Iterator)localObject2).next();
        if (((FileInfo)localObject3).a() == 0) {
          return a((FileInfo)localObject3);
        }
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeiYunFileInfo)((Iterator)localObject1).next();
        if (d(((WeiYunFileInfo)localObject2).jdField_c_of_type_JavaLangString) == 0) {
          return a((WeiYunFileInfo)localObject2);
        }
      }
    }
    return null;
  }
  
  public static FileManagerEntity a(Bundle paramBundle)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(2);
    localFileManagerEntity.nOpType = 50;
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.WeiYunFileId = ((String)paramBundle.get("file_id"));
    localFileManagerEntity.fileName = ((String)paramBundle.get("filename"));
    localFileManagerEntity.WeiYunDirKey = ((String)paramBundle.get("pdir_key"));
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, String paramString, int paramInt, ChatMessage paramChatMessage)
  {
    FileManagerEntity localFileManagerEntity = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).queryFileEntityByUniseq(paramBaseQQAppInterface, paramLong, paramString, paramInt);
    paramString = localFileManagerEntity;
    if (localFileManagerEntity == null) {
      paramString = a(paramBaseQQAppInterface, paramChatMessage);
    }
    return paramString;
  }
  
  public static FileManagerEntity a(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage)
  {
    Object localObject;
    String str;
    if (paramChatMessage != null)
    {
      if (!QQFileUtilsImpl.a(paramChatMessage)) {
        return null;
      }
      localObject = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
      int i;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        i = Integer.parseInt((String)localObject);
      } else {
        i = -1;
      }
      if ((i != 1) && (i != 2)) {
        return null;
      }
      localObject = new FileManagerEntity();
      ((FileManagerEntity)localObject).nSessionId = a().longValue();
      ((FileManagerEntity)localObject).uniseq = paramChatMessage.uniseq;
      ((FileManagerEntity)localObject).selfUin = paramBaseQQAppInterface.getAccount();
      ((FileManagerEntity)localObject).isReaded = false;
      ((FileManagerEntity)localObject).peerUin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
      QQFileUtilsImpl.a(paramBaseQQAppInterface, (FileManagerEntity)localObject, paramChatMessage);
      ((FileManagerEntity)localObject).peerNick = a(paramBaseQQAppInterface, ((FileManagerEntity)localObject).peerUin, null, ((FileManagerEntity)localObject).peerType);
      ((FileManagerEntity)localObject).Uuid = paramChatMessage.getExtInfoFromExtStr("_m_ForwardUuid");
      ((FileManagerEntity)localObject).fileIdCrc = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
      ((FileManagerEntity)localObject).fileName = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
      str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSize");
      if (!TextUtils.isEmpty(str)) {
        ((FileManagerEntity)localObject).fileSize = Long.parseLong(str);
      }
      str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
      if (!TextUtils.isEmpty(((FileManagerEntity)localObject).selfUin)) {
        if (((FileManagerEntity)localObject).selfUin.equals(str)) {
          ((FileManagerEntity)localObject).nOpType = 0;
        } else {
          ((FileManagerEntity)localObject).nOpType = 1;
        }
      }
      ((FileManagerEntity)localObject).status = -1;
      str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
      if (!TextUtils.isEmpty(((FileManagerEntity)localObject).selfUin)) {
        ((FileManagerEntity)localObject).bSend = (((FileManagerEntity)localObject).selfUin.equals(str) ^ true);
      }
      str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFilePath");
      if (FileUtils.fileExistsAndNotEmpty(str))
      {
        ((FileManagerEntity)localObject).setFilePath(str);
        ((FileManagerEntity)localObject).setCloudType(3);
      }
      else
      {
        ((FileManagerEntity)localObject).setCloudType(1);
      }
      ((FileManagerEntity)localObject).strFileMd5 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardMd5");
      ((FileManagerEntity)localObject).strFileSHA = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSha");
      str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgWidth");
    }
    try
    {
      ((FileManagerEntity)localObject).imgWidth = Integer.parseInt(str);
      str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgHeight");
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        ((FileManagerEntity)localObject).imgHeight = Integer.parseInt(str);
        label358:
        a(paramBaseQQAppInterface, (FileManagerEntity)localObject);
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).insertToMemMapByFileManagerProxy(paramBaseQQAppInterface, (FileManagerEntity)localObject);
        if (a(paramChatMessage)) {
          ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).insertToFMList(paramBaseQQAppInterface, (FileManagerEntity)localObject);
        }
        return localObject;
        return null;
        localNumberFormatException1 = localNumberFormatException1;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        break label358;
      }
    }
  }
  
  public static FileManagerEntity a(BaseQQAppInterface paramBaseQQAppInterface, MessageForFile paramMessageForFile)
  {
    Object localObject2 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).queryFileEntityByUniseq(paramBaseQQAppInterface, paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFileEntityByUniseq(paramBaseQQAppInterface, paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("QueryFileEntityByUniseq return null, create new! sessionId[");
        ((StringBuilder)localObject2).append(((FileManagerEntity)localObject1).nSessionId);
        ((StringBuilder)localObject2).append("], messageId[");
        ((StringBuilder)localObject2).append(((FileManagerEntity)localObject1).uniseq);
        ((StringBuilder)localObject2).append("], peerUin[");
        ((StringBuilder)localObject2).append(e(((FileManagerEntity)localObject1).peerUin));
        ((StringBuilder)localObject2).append("], peerType[");
        ((StringBuilder)localObject2).append(((FileManagerEntity)localObject1).peerType);
        ((StringBuilder)localObject2).append("]");
        QLog.d("FileManager", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).setEntityUuidByEntityManager(paramBaseQQAppInterface, paramMessageForFile);
      if (!((String)localObject2).equals("")) {
        ((FileManagerEntity)localObject1).Uuid = ((String)localObject2);
      }
      ((FileManagerEntity)localObject1).status = b(paramMessageForFile.status);
      if (paramMessageForFile.isSend())
      {
        ((FileManagerEntity)localObject1).setCloudType(3);
        if (TextUtils.isEmpty(paramMessageForFile.url)) {
          ((FileManagerEntity)localObject1).status = 16;
        } else {
          ((FileManagerEntity)localObject1).setFilePath(paramMessageForFile.url);
        }
      }
      else
      {
        ((FileManagerEntity)localObject1).setCloudType(1);
        ((FileManagerEntity)localObject1).lastTime = (paramMessageForFile.time * 1000L + 604800000L);
        if (((FileManagerEntity)localObject1).status == 1)
        {
          ((FileManagerEntity)localObject1).setCloudType(3);
          ((FileManagerEntity)localObject1).setFilePath(paramMessageForFile.url);
        }
      }
      ((FileManagerEntity)localObject1).fileName = paramMessageForFile.fileName;
      ((FileManagerEntity)localObject1).fileSize = paramMessageForFile.fileSize;
      ((FileManagerEntity)localObject1).nOpType = (paramMessageForFile.isSend() ^ true);
      ((FileManagerEntity)localObject1).peerUin = paramMessageForFile.frienduin;
      ((FileManagerEntity)localObject1).peerType = paramMessageForFile.istroop;
      ((FileManagerEntity)localObject1).peerNick = a(paramBaseQQAppInterface, String.valueOf(paramMessageForFile.frienduin), null, paramMessageForFile.istroop);
      ((FileManagerEntity)localObject1).srvTime = (paramMessageForFile.time * 1000L);
      ((FileManagerEntity)localObject1).strServerPath = paramMessageForFile.urlAtServer;
      ((FileManagerEntity)localObject1).fProgress = ((float)((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getProgress(paramBaseQQAppInterface, paramMessageForFile.frienduin, paramMessageForFile.fileSize, paramMessageForFile.uniseq, paramMessageForFile.istroop) / 100.0F);
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).insertToMemMap(paramBaseQQAppInterface, (FileManagerEntity)localObject1);
      ((FileManagerEntity)localObject1).bDelInFM = true;
    }
    return localObject1;
  }
  
  public static FileManagerEntity a(FileInfo paramFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.fileName = paramFileInfo.d();
    localFileManagerEntity.setFilePath(paramFileInfo.c());
    localFileManagerEntity.fileSize = paramFileInfo.a();
    if (paramFileInfo.a() == 5)
    {
      localFileManagerEntity.nFileType = 5;
      ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).getApkPackageInfo(paramFileInfo.c(), new QQFileManagerUtilImpl.10(localFileManagerEntity));
    }
    else
    {
      localFileManagerEntity.nFileType = d(paramFileInfo.d());
    }
    localFileManagerEntity.status = -1;
    BaseQQAppInterface localBaseQQAppInterface = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("=_= create new Entity[");
    localStringBuilder.append(localFileManagerEntity.nSessionId);
    localStringBuilder.append("] fileName[");
    localStringBuilder.append(paramFileInfo.d());
    localStringBuilder.append("]by local size(");
    localStringBuilder.append(localFileManagerEntity.imgHeight);
    localStringBuilder.append(":");
    localStringBuilder.append(localFileManagerEntity.imgWidth);
    localStringBuilder.append(")");
    QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).insertToMemMap(localBaseQQAppInterface, localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(OfflineFileInfo paramOfflineFileInfo, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    BaseQQAppInterface localBaseQQAppInterface = a();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.Uuid = paramOfflineFileInfo.jdField_a_of_type_JavaLangString;
    localFileManagerEntity.fileIdCrc = paramOfflineFileInfo.jdField_b_of_type_JavaLangString;
    localFileManagerEntity.setCloudType(1);
    localFileManagerEntity.strThumbPath = paramOfflineFileInfo.e;
    localFileManagerEntity.peerUin = String.valueOf(paramOfflineFileInfo.jdField_a_of_type_Long);
    localFileManagerEntity.peerNick = a(localBaseQQAppInterface, localFileManagerEntity.peerUin, null, paramInt);
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.fileName = paramOfflineFileInfo.jdField_c_of_type_JavaLangString;
    localFileManagerEntity.fileSize = paramOfflineFileInfo.jdField_b_of_type_Long;
    localFileManagerEntity.nFileType = d(paramOfflineFileInfo.jdField_c_of_type_JavaLangString);
    localFileManagerEntity.lastTime = paramOfflineFileInfo.jdField_c_of_type_Long;
    localFileManagerEntity.status = -1;
    localFileManagerEntity.srvTime = paramOfflineFileInfo.d;
    localFileManagerEntity.bSend = paramOfflineFileInfo.jdField_a_of_type_Boolean;
    if ((localFileManagerEntity.Uuid == null) || (localFileManagerEntity.Uuid.length() == 0)) {
      localFileManagerEntity.nWeiYunSrcType = -1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("=_= create new Entity[");
    localStringBuilder.append(localFileManagerEntity.nSessionId);
    localStringBuilder.append("] fileName[");
    localStringBuilder.append(paramOfflineFileInfo.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("] by offlinefile size(");
    localStringBuilder.append(localFileManagerEntity.imgHeight);
    localStringBuilder.append(":");
    localStringBuilder.append(localFileManagerEntity.imgWidth);
    localStringBuilder.append(")");
    QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).insertToMemMap(localBaseQQAppInterface, localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.WeiYunFileId = paramWeiYunFileInfo.jdField_a_of_type_JavaLangString;
    localFileManagerEntity.fileName = paramWeiYunFileInfo.jdField_c_of_type_JavaLangString;
    localFileManagerEntity.fileSize = paramWeiYunFileInfo.jdField_a_of_type_Long;
    localFileManagerEntity.nFileType = d(paramWeiYunFileInfo.jdField_c_of_type_JavaLangString);
    localFileManagerEntity.strThumbPath = paramWeiYunFileInfo.h;
    localFileManagerEntity.setCloudType(2);
    localFileManagerEntity.nWeiYunSrcType = paramWeiYunFileInfo.jdField_a_of_type_Int;
    if (localFileManagerEntity.nWeiYunSrcType == 2) {
      localFileManagerEntity.strLargeThumPath = paramWeiYunFileInfo.e;
    }
    localFileManagerEntity.lastTime = paramWeiYunFileInfo.jdField_b_of_type_Long;
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = -1;
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.strFileMd5 = paramWeiYunFileInfo.i;
    localFileManagerEntity.WeiYunDirKey = paramWeiYunFileInfo.jdField_b_of_type_JavaLangString;
    localFileManagerEntity.strFileSHA = paramWeiYunFileInfo.j;
    BaseQQAppInterface localBaseQQAppInterface = a();
    Object localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).queryFileManagerEntityByWeiYunFileIdForMemory(localBaseQQAppInterface, paramWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      localFileManagerEntity.imgWidth = ((FileManagerEntity)localObject).imgWidth;
      localFileManagerEntity.imgHeight = ((FileManagerEntity)localObject).imgHeight;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= create new Entity[");
    ((StringBuilder)localObject).append(localFileManagerEntity.nSessionId);
    ((StringBuilder)localObject).append("] fileName[");
    ((StringBuilder)localObject).append(paramWeiYunFileInfo.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject).append("] by WeiYun size(");
    ((StringBuilder)localObject).append(localFileManagerEntity.imgHeight);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(localFileManagerEntity.imgWidth);
    ((StringBuilder)localObject).append(")");
    QLog.i("FileManagerUtil<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).insertToMemMap(localBaseQQAppInterface, localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.strFavFileId = paramString2;
    localFileManagerEntity.strFavId = paramString1;
    localFileManagerEntity.fileName = paramString4;
    localFileManagerEntity.fileSize = paramLong;
    localFileManagerEntity.nFileType = d(paramString4);
    localFileManagerEntity.setCloudType(10);
    localFileManagerEntity.setFilePath(paramString3);
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = -1;
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.strFileMd5 = paramString5;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.peerUin = paramString6;
    if (paramInt == 1) {
      localFileManagerEntity.nOpType = 36;
    } else if (paramInt == 0) {
      localFileManagerEntity.nOpType = 37;
    } else if (paramInt == 7) {
      localFileManagerEntity.nOpType = 38;
    }
    paramString1 = a();
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).insertToMemMap(paramString1, localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static IForwardCallBack a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    return new QQFileManagerUtilImpl.14(paramBaseQQAppInterface, paramInt);
  }
  
  /* Error */
  public static QQFileManagerUtil.VideoThumbInfo a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 827	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl:f	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore 4
    //   6: new 829	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil$VideoThumbInfo
    //   9: dup
    //   10: invokespecial 830	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil$VideoThumbInfo:<init>	()V
    //   13: astore 5
    //   15: aload 5
    //   17: iconst_0
    //   18: putfield 831	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   21: aload 4
    //   23: invokestatic 833	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Z
    //   26: ifeq +62 -> 88
    //   29: new 835	android/graphics/BitmapFactory$Options
    //   32: dup
    //   33: invokespecial 836	android/graphics/BitmapFactory$Options:<init>	()V
    //   36: astore_0
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 839	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   42: ldc_w 298
    //   45: invokestatic 304	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   48: checkcast 298	com/tencent/mobileqq/filemanager/api/IQQFileTempUtils
    //   51: aload 4
    //   53: aload_0
    //   54: invokeinterface 843 3 0
    //   59: pop
    //   60: aload 5
    //   62: aload_0
    //   63: getfield 846	android/graphics/BitmapFactory$Options:outWidth	I
    //   66: putfield 848	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil$VideoThumbInfo:b	I
    //   69: aload 5
    //   71: aload_0
    //   72: getfield 851	android/graphics/BitmapFactory$Options:outHeight	I
    //   75: putfield 853	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil$VideoThumbInfo:c	I
    //   78: aload 5
    //   80: aload 4
    //   82: putfield 854	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil$VideoThumbInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   85: aload 5
    //   87: areturn
    //   88: aload_0
    //   89: iconst_1
    //   90: invokestatic 860	android/media/ThumbnailUtils:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   93: astore_0
    //   94: aload_0
    //   95: astore_2
    //   96: aload_0
    //   97: ifnonnull +25 -> 122
    //   100: aload 5
    //   102: iconst_m1
    //   103: putfield 831	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   106: aload 5
    //   108: areturn
    //   109: astore_1
    //   110: goto +6 -> 116
    //   113: astore_1
    //   114: aconst_null
    //   115: astore_0
    //   116: aload_1
    //   117: invokevirtual 179	java/lang/Exception:printStackTrace	()V
    //   120: aload_0
    //   121: astore_2
    //   122: new 252	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   129: astore_0
    //   130: aload_0
    //   131: invokestatic 865	com/tencent/mobileqq/filemanager/settings/FMSettings:a	()Lcom/tencent/mobileqq/filemanager/api/IFMSettings;
    //   134: invokeinterface 870 1 0
    //   139: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_0
    //   144: invokestatic 875	java/lang/System:currentTimeMillis	()J
    //   147: invokevirtual 646	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_0
    //   152: ldc_w 877
    //   155: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_0
    //   160: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore 6
    //   165: new 252	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   172: astore_0
    //   173: aload_0
    //   174: invokestatic 865	com/tencent/mobileqq/filemanager/settings/FMSettings:a	()Lcom/tencent/mobileqq/filemanager/api/IFMSettings;
    //   177: invokeinterface 870 1 0
    //   182: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload_0
    //   187: ldc_w 879
    //   190: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_0
    //   195: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 882	com/tencent/mobileqq/utils/FileUtils:createFileIfNotExits	(Ljava/lang/String;)V
    //   201: new 884	com/tencent/mm/vfs/VFSFile
    //   204: dup
    //   205: aload 6
    //   207: invokespecial 885	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   210: astore 7
    //   212: aload 7
    //   214: invokevirtual 888	com/tencent/mm/vfs/VFSFile:getParent	()Ljava/lang/String;
    //   217: astore_0
    //   218: aload_0
    //   219: ifnonnull +6 -> 225
    //   222: aload 5
    //   224: areturn
    //   225: new 884	com/tencent/mm/vfs/VFSFile
    //   228: dup
    //   229: aload_0
    //   230: invokespecial 885	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   233: astore_0
    //   234: aload_0
    //   235: invokevirtual 889	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   238: ifeq +10 -> 248
    //   241: aload_0
    //   242: invokevirtual 892	com/tencent/mm/vfs/VFSFile:isDirectory	()Z
    //   245: ifne +8 -> 253
    //   248: aload_0
    //   249: invokevirtual 895	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   252: pop
    //   253: aload 7
    //   255: invokevirtual 889	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   258: ifeq +11 -> 269
    //   261: aload 7
    //   263: invokevirtual 898	com/tencent/mm/vfs/VFSFile:isFile	()Z
    //   266: ifne +17 -> 283
    //   269: aload 7
    //   271: invokevirtual 901	com/tencent/mm/vfs/VFSFile:createNewFile	()Z
    //   274: pop
    //   275: goto +8 -> 283
    //   278: astore_0
    //   279: aload_0
    //   280: invokevirtual 902	java/io/IOException:printStackTrace	()V
    //   283: new 904	java/io/BufferedOutputStream
    //   286: dup
    //   287: new 906	com/tencent/mm/vfs/VFSFileOutputStream
    //   290: dup
    //   291: aload 7
    //   293: invokespecial 909	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   296: invokespecial 912	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   299: astore_1
    //   300: aload_2
    //   301: ifnull +25 -> 326
    //   304: aload_1
    //   305: astore_0
    //   306: aload_2
    //   307: getstatic 918	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   310: bipush 80
    //   312: aload_1
    //   313: invokevirtual 922	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   316: pop
    //   317: aload_1
    //   318: astore_0
    //   319: aload_1
    //   320: invokevirtual 925	java/io/BufferedOutputStream:flush	()V
    //   323: goto +11 -> 334
    //   326: aload_1
    //   327: astore_0
    //   328: aload 5
    //   330: iconst_m1
    //   331: putfield 831	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   334: aload_1
    //   335: invokevirtual 928	java/io/BufferedOutputStream:close	()V
    //   338: goto +203 -> 541
    //   341: goto +200 -> 541
    //   344: astore_3
    //   345: goto +16 -> 361
    //   348: astore_3
    //   349: goto +100 -> 449
    //   352: astore_1
    //   353: aconst_null
    //   354: astore_0
    //   355: goto +265 -> 620
    //   358: astore_3
    //   359: aconst_null
    //   360: astore_1
    //   361: aload_1
    //   362: astore_0
    //   363: aload 5
    //   365: bipush 254
    //   367: putfield 831	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   370: aload_1
    //   371: astore_0
    //   372: invokestatic 641	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +269 -> 644
    //   378: aload_1
    //   379: astore_0
    //   380: new 252	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   387: astore 8
    //   389: aload_1
    //   390: astore_0
    //   391: aload 8
    //   393: ldc_w 930
    //   396: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload_1
    //   401: astore_0
    //   402: aload 8
    //   404: aload 6
    //   406: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload_1
    //   411: astore_0
    //   412: aload 8
    //   414: ldc_w 932
    //   417: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload_1
    //   422: astore_0
    //   423: aload 8
    //   425: aload_3
    //   426: invokevirtual 935	java/io/IOException:getMessage	()Ljava/lang/String;
    //   429: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload_1
    //   434: astore_0
    //   435: ldc 234
    //   437: iconst_2
    //   438: aload 8
    //   440: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: goto +198 -> 644
    //   449: aload_1
    //   450: astore_0
    //   451: aload 5
    //   453: bipush 254
    //   455: putfield 831	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   458: aload_1
    //   459: astore_0
    //   460: invokestatic 641	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   463: ifeq +71 -> 534
    //   466: aload_1
    //   467: astore_0
    //   468: new 252	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   475: astore 8
    //   477: aload_1
    //   478: astore_0
    //   479: aload 8
    //   481: ldc_w 930
    //   484: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload_1
    //   489: astore_0
    //   490: aload 8
    //   492: aload 6
    //   494: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload_1
    //   499: astore_0
    //   500: aload 8
    //   502: ldc_w 937
    //   505: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload_1
    //   510: astore_0
    //   511: aload 8
    //   513: aload_3
    //   514: invokevirtual 938	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   517: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload_1
    //   522: astore_0
    //   523: ldc 234
    //   525: iconst_2
    //   526: aload 8
    //   528: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   534: aload_1
    //   535: ifnull +6 -> 541
    //   538: goto -204 -> 334
    //   541: aload 7
    //   543: invokevirtual 889	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   546: ifeq +49 -> 595
    //   549: aload 6
    //   551: aload 4
    //   553: invokestatic 942	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   556: pop
    //   557: aload 6
    //   559: invokestatic 944	com/tencent/mobileqq/filemanager/util/FileUtil:c	(Ljava/lang/String;)Z
    //   562: pop
    //   563: aload 5
    //   565: aload 4
    //   567: putfield 854	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil$VideoThumbInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   570: aload_2
    //   571: ifnull +45 -> 616
    //   574: aload 5
    //   576: aload_2
    //   577: invokevirtual 313	android/graphics/Bitmap:getWidth	()I
    //   580: putfield 848	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil$VideoThumbInfo:b	I
    //   583: aload 5
    //   585: aload_2
    //   586: invokevirtual 316	android/graphics/Bitmap:getHeight	()I
    //   589: putfield 853	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil$VideoThumbInfo:c	I
    //   592: aload 5
    //   594: areturn
    //   595: aload 5
    //   597: iconst_m1
    //   598: putfield 831	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   601: invokestatic 641	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   604: ifeq +12 -> 616
    //   607: ldc 234
    //   609: iconst_2
    //   610: ldc_w 946
    //   613: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: aload 5
    //   618: areturn
    //   619: astore_1
    //   620: aload_0
    //   621: ifnull +7 -> 628
    //   624: aload_0
    //   625: invokevirtual 928	java/io/BufferedOutputStream:close	()V
    //   628: goto +5 -> 633
    //   631: aload_1
    //   632: athrow
    //   633: goto -2 -> 631
    //   636: astore_0
    //   637: goto -296 -> 341
    //   640: astore_0
    //   641: goto -13 -> 628
    //   644: aload_1
    //   645: ifnull -104 -> 541
    //   648: goto -314 -> 334
    //   651: astore_3
    //   652: aconst_null
    //   653: astore_1
    //   654: goto -205 -> 449
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	657	0	paramString	String
    //   109	1	1	localException1	Exception
    //   113	4	1	localException2	Exception
    //   299	36	1	localBufferedOutputStream	java.io.BufferedOutputStream
    //   352	1	1	localObject1	Object
    //   360	175	1	localObject2	Object
    //   619	26	1	localObject3	Object
    //   653	1	1	localObject4	Object
    //   95	491	2	str1	String
    //   344	1	3	localIOException1	IOException
    //   348	1	3	localFileNotFoundException1	FileNotFoundException
    //   358	156	3	localIOException2	IOException
    //   651	1	3	localFileNotFoundException2	FileNotFoundException
    //   4	562	4	str2	String
    //   13	604	5	localVideoThumbInfo	QQFileManagerUtil.VideoThumbInfo
    //   163	395	6	str3	String
    //   210	332	7	localVFSFile	VFSFile
    //   387	140	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   100	106	109	java/lang/Exception
    //   88	94	113	java/lang/Exception
    //   269	275	278	java/io/IOException
    //   306	317	344	java/io/IOException
    //   319	323	344	java/io/IOException
    //   328	334	344	java/io/IOException
    //   306	317	348	java/io/FileNotFoundException
    //   319	323	348	java/io/FileNotFoundException
    //   328	334	348	java/io/FileNotFoundException
    //   283	300	352	finally
    //   283	300	358	java/io/IOException
    //   306	317	619	finally
    //   319	323	619	finally
    //   328	334	619	finally
    //   363	370	619	finally
    //   372	378	619	finally
    //   380	389	619	finally
    //   391	400	619	finally
    //   402	410	619	finally
    //   412	421	619	finally
    //   423	433	619	finally
    //   435	446	619	finally
    //   451	458	619	finally
    //   460	466	619	finally
    //   468	477	619	finally
    //   479	488	619	finally
    //   490	498	619	finally
    //   500	509	619	finally
    //   511	521	619	finally
    //   523	534	619	finally
    //   334	338	636	java/io/IOException
    //   624	628	640	java/io/IOException
    //   283	300	651	java/io/FileNotFoundException
  }
  
  public static TimeoutParam a()
  {
    Object localObject = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    boolean bool = false;
    int i;
    int k;
    if (localObject != null)
    {
      j = ((NetworkInfo)localObject).getType();
      i = j;
      if (j == 1)
      {
        k = 1;
        i = j;
        j = k;
        break label51;
      }
    }
    else
    {
      i = -1;
    }
    int j = 0;
    label51:
    int m = MobileQQ.sMobileQQ.getMsfConnectedNetType();
    if (m == 2) {
      k = 1;
    } else {
      k = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNetworkInfo,systemType:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" msfType:");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append(" isSameNet:");
      if (j == k) {
        bool = true;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.i("FileManagerUtil<FileAssistant>.NetDebug", 1, ((StringBuilder)localObject).toString());
    }
    if (j != k)
    {
      localObject = new TimeoutParam();
      ((TimeoutParam)localObject).readTimeoutFor2G = 20000;
      ((TimeoutParam)localObject).readTimeoutFor3G = 15000;
      ((TimeoutParam)localObject).readTimeoutForWifi = 10000;
      ((TimeoutParam)localObject).connectTimeoutFor2G = 10000;
      ((TimeoutParam)localObject).connectTimeoutFor3G = 5000;
      ((TimeoutParam)localObject).connectTimeoutForWifi = 5000;
      return localObject;
    }
    return null;
  }
  
  private static IUniformDownloadMgr a()
  {
    return (IUniformDownloadMgr)a().getRuntimeService(IUniformDownloadMgr.class, "all");
  }
  
  public static Long a()
  {
    return Long.valueOf((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  public static String a()
  {
    try
    {
      String str = FileUtils.printStack();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String a(int paramInt)
  {
    return HardCodeUtil.a(paramInt);
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3) {
            return String.valueOf(0);
          }
          return String.valueOf(1);
        }
        return String.valueOf(3);
      }
      if (paramInt2 == 0) {
        return String.valueOf(2);
      }
      return String.valueOf(4);
    }
    return String.valueOf(7);
  }
  
  public static String a(long paramLong)
  {
    if (paramLong == 0L) {
      return "0";
    }
    if (paramLong <= 512000L) {
      return "0-500k";
    }
    if (paramLong <= 1048576L) {
      return "500k-1m";
    }
    if (paramLong <= 3145728L) {
      return "1m-3m";
    }
    if (paramLong <= 5242880L) {
      return "3m-5m";
    }
    if (paramLong <= 10485760L) {
      return "5m-10m";
    }
    return ">10m";
  }
  
  public static String a(long paramLong, int paramInt)
  {
    long l2 = 604800000L;
    long l1 = l2;
    if (paramInt != 0) {
      if (paramInt != 3000) {
        l1 = l2;
      } else {
        l1 = 2592000000L;
      }
    }
    Object localObject = new Date(paramLong + l1);
    Date localDate = new Date(MessageCache.a() * 1000L);
    paramInt = (int)((((Date)localObject).getTime() - localDate.getTime()) / 86400000L);
    if (paramInt < 0) {
      return a(2131704631);
    }
    if (paramInt == 0) {
      return a(2131704637);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(a(2131704634));
    return ((StringBuilder)localObject).toString();
  }
  
  public static String a(TextView paramTextView, int paramInt, String paramString1, String paramString2)
  {
    int i = paramTextView.getWidth();
    TextPaint localTextPaint = paramTextView.getPaint();
    float f1 = localTextPaint.measureText(paramString1);
    if (f1 < i) {
      return paramString2;
    }
    float f2 = paramInt * i - 50;
    if (f1 > f2)
    {
      paramTextView = paramString1;
      paramInt = 0;
      for (;;)
      {
        i = paramString2.length() - paramInt - 1;
        if (i < 1) {
          return paramTextView;
        }
        paramString1 = new StringBuilder();
        paramString1.append(paramString2.substring(0, i));
        paramString1.append(jdField_a_of_type_JavaLangString);
        paramString1 = paramString1.toString();
        paramTextView = paramTextView.replace(paramString2, paramString1);
        if (localTextPaint.measureText(paramTextView) < f2) {
          return paramString1;
        }
        paramInt += 1;
        paramString2 = paramString1;
      }
    }
    return paramString2;
  }
  
  public static String a(TextView paramTextView, String paramString)
  {
    int m = paramTextView.getWidth();
    StringBuilder localStringBuilder = new StringBuilder();
    paramTextView = paramTextView.getPaint();
    if (paramTextView.measureText(paramString) < m) {
      return paramString;
    }
    int k = 0;
    int i = 1;
    while (i < paramString.length())
    {
      int j = i + 1;
      i = j;
      if (paramTextView.measureText(paramString, k, j) >= m - 30)
      {
        localStringBuilder.append(paramString, k, j);
        localStringBuilder.append('\n');
        k = j;
        i = j;
      }
    }
    localStringBuilder.append(paramString, k, i);
    return localStringBuilder.toString();
  }
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage)
  {
    paramBaseQQAppInterface = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).queryFileEntityByUniseq(paramBaseQQAppInterface, paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop);
    if (paramBaseQQAppInterface == null) {
      return null;
    }
    if (paramBaseQQAppInterface.nFileType == -1) {
      paramBaseQQAppInterface.nFileType = d(paramBaseQQAppInterface.getFilePath());
    }
    paramMessage = b(paramBaseQQAppInterface.nFileType);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramMessage);
    localStringBuilder.append("]");
    localStringBuilder.append(paramBaseQQAppInterface.fileName);
    return localStringBuilder.toString();
  }
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramBaseQQAppInterface = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).queryFileEntityByUniseq(paramBaseQQAppInterface, paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (paramBaseQQAppInterface == null) {
      return null;
    }
    if (paramBaseQQAppInterface.nFileType == -1) {
      paramBaseQQAppInterface.nFileType = d(paramBaseQQAppInterface.getFilePath());
    }
    paramMessageRecord = b(paramBaseQQAppInterface.nFileType);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramMessageRecord);
    localStringBuilder.append("]");
    localStringBuilder.append(paramBaseQQAppInterface.fileName);
    return localStringBuilder.toString();
  }
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (AppConstants.DATALINE_PC_UIN.equalsIgnoreCase(paramString1)) {
      return HardCodeUtil.a(2131694380);
    }
    if (AppConstants.DATALINE_IPAD_UIN.equalsIgnoreCase(paramString1)) {
      return HardCodeUtil.a(2131693780);
    }
    if (AppConstants.FM_EXTERNAL_SAVEFILE_UIN.equalsIgnoreCase(paramString1)) {
      return "";
    }
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getNickName(paramBaseQQAppInterface, paramString1, paramInt);
  }
  
  public static String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      if (!paramChatMessage.isMultiMsg) {
        return "";
      }
      String str = paramChatMessage.getExtInfoFromExtStr("_f_thumb_path_750_");
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("_f_thumb_path_384_");
      if ((!TextUtils.isEmpty(str)) && (FileUtils.fileExistsAndNotEmpty(str))) {
        return str;
      }
      if ((!TextUtils.isEmpty(str)) && (FileUtils.fileExistsAndNotEmpty(paramChatMessage))) {
        return paramChatMessage;
      }
      return "";
    }
    return "";
  }
  
  public static String a(FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity.isZipInnerFile) && (paramFileManagerEntity.nFileType == 0))
    {
      Object localObject = paramFileManagerEntity.zipInnerPath;
      paramFileManagerEntity = (String)paramFileManagerEntity.mContext;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFileManagerEntity);
      localStringBuilder.append((String)localObject);
      paramFileManagerEntity = MD5.a(localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FMSettings.a().getDefaultThumbPath());
      ((StringBuilder)localObject).append("x-zip-");
      ((StringBuilder)localObject).append(paramFileManagerEntity);
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  private static String a(FileManagerEntity paramFileManagerEntity, Context paramContext, String paramString)
  {
    int i = paramFileManagerEntity.nOpType;
    if (i != -1)
    {
      if ((i != 0) && (i != 3) && (i != 24) && (i != 7))
      {
        if (i == 8) {
          break label90;
        }
        if ((i != 21) && (i != 22)) {
          return paramString;
        }
      }
      if ((paramFileManagerEntity.nFileType == 13) && (paramFileManagerEntity.selfUin.equals(paramFileManagerEntity.peerUin))) {
        return paramContext.getString(2131692268);
      }
      return paramContext.getString(2131692341);
    }
    label90:
    paramString = paramContext.getString(2131692306);
    if (paramFileManagerEntity.bSend) {
      paramString = paramContext.getString(2131692341);
    }
    return paramString;
  }
  
  private static String a(FileManagerEntity paramFileManagerEntity, Context paramContext, String paramString, BaseQQAppInterface paramBaseQQAppInterface)
  {
    paramString = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getTroopInfo(paramBaseQQAppInterface, paramFileManagerEntity.TroopUin);
    if ((paramString != null) && (paramString.getTroopDisplayName() != null))
    {
      if ((paramString != null) && (paramString.getTroopDisplayName() != null) && (paramString.getTroopDisplayName().length() > 14)) {
        paramString = paramString.getTroopDisplayName();
      } else {
        paramString = paramString.getTroopDisplayName();
      }
    }
    else {
      paramString = "";
    }
    if (paramFileManagerEntity.bSend)
    {
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append(paramContext.getString(2131692272));
      paramFileManagerEntity.append(paramString);
      return paramFileManagerEntity.toString();
    }
    paramFileManagerEntity = new StringBuilder();
    paramFileManagerEntity.append(paramContext.getString(2131692270));
    paramFileManagerEntity.append(paramString);
    return paramFileManagerEntity.toString();
  }
  
  private static String a(FileManagerEntity paramFileManagerEntity, Context paramContext, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString1 != null)
    {
      str = paramString2;
      if (!paramString1.equals(paramContext.getString(2131692313)))
      {
        str = paramString2;
        if (!paramString1.equals(paramContext.getString(2131692307))) {
          str = paramFileManagerEntity.peerNick;
        }
      }
    }
    return str;
  }
  
  public static String a(ByteStringMicro paramByteStringMicro)
  {
    try
    {
      paramByteStringMicro = paramByteStringMicro.toByteArray();
      if (paramByteStringMicro == null) {
        return "";
      }
      char[] arrayOfChar = "0123456789ABCDEF".toCharArray();
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 0;
      while (i < paramByteStringMicro.length)
      {
        int j = paramByteStringMicro[i];
        localStringBuffer.append(arrayOfChar[(j >>> 4 & 0xF)]);
        localStringBuffer.append(arrayOfChar[(j & 0xF)]);
        i += 1;
      }
      return localStringBuffer.toString();
    }
    catch (Exception paramByteStringMicro)
    {
      paramByteStringMicro.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    if (b == null)
    {
      b = new HashMap();
      b.put("OnlinePreViewRotateScreenFunctionalSwitch", "1");
      b.put("OnlinePreViewLocalPreviewFunctionalSwitch", "0");
      b.put("OnlinePreViewAutoPreviewFunctionSwitch", "1");
      b.put("OnlinePreViewAutoPreviewWiFiMaxSize", "1000");
      b.put("OnlinePreViewAutoPreview3GMaxSize", "0");
      b.put("OnlinePreViewAutoPreviewWiFiGroupMaxSize", "1000");
      b.put("OnlinePreViewAutoPreview3GGroupMaxSize", "0");
      b.put("OnlinePreViewdocFileMaxSize", "10");
      b.put("OnlinePreViewdocFileType", "1");
      b.put("OnlinePreViewdocInterfacePage", "qq_document_previewer_v2.html");
      b.put("OnlinePreViewdocPreviewMode", "0");
      b.put("OnlinePreViewdocxFileMaxSize", "10");
      b.put("OnlinePreViewdocxFileType", "2");
      b.put("OnlinePreViewdocxInterfacePage", "qq_document_previewer_v2.html");
      b.put("OnlinePreViewdocxPreviewMode", "0");
      b.put("OnlinePreViewrtfFileMaxSize", "10");
      b.put("OnlinePreViewrtfFileType", "7");
      b.put("OnlinePreViewrtfInterfacePage", "qq_document_previewer_v2.html");
      b.put("OnlinePreViewrtfPreviewMode", "0");
      b.put("OnlinePreViewpptFileMaxSize", "10");
      b.put("OnlinePreViewpptFileType", "5");
      b.put("OnlinePreViewpptInterfacePage", "qq_ppt_previewer_v2.html");
      b.put("OnlinePreViewpptPreviewMode", "4");
      b.put("OnlinePreViewpptxFileMaxSize", "10");
      b.put("OnlinePreViewpptxFileType", "6");
      b.put("OnlinePreViewpptxInterfacePage", "qq_ppt_previewer_v2.html");
      b.put("OnlinePreViewpptxPreviewMode", "5");
      b.put("OnlinePreViewpdfFileMaxSize", "10");
      b.put("OnlinePreViewpdfFileType", "8");
      b.put("OnlinePreViewpdfInterfacePage", "qq_pdf_previewer_v2.html");
      b.put("OnlinePreViewpdfPreviewMode", "3");
      b.put("OnlinePreViewzipFileMaxSize", "100");
      b.put("OnlinePreViewzipFileType", "13");
      b.put("OnlinePreViewzipInterfacePage", "qq_compress_previewer_v2.html");
      b.put("OnlinePreViewzipPreviewMode", "1");
      b.put("OnlinePreViewrarFileMaxSize", "100");
      b.put("OnlinePreViewrarFileType", "14");
      b.put("OnlinePreViewrarInterfacePage", "qq_compress_previewer_v2.html");
      b.put("OnlinePreViewrarPreviewMode", "1");
      b.put("OnlinePreView7zFileMaxSize", "100");
      b.put("OnlinePreView7zFileType", "15");
      b.put("OnlinePreView7zInterfacePage", "qq_compress_previewer_v2.html");
      b.put("OnlinePreView7zPreviewMode", "1");
      b.put("OnlinePreViewtxtFileMaxSize", "10");
      b.put("OnlinePreViewtxtFileType", "16");
      b.put("OnlinePreViewtxtInterfacePage", "qq_txt_previewer_v2.html");
      b.put("OnlinePreViewtxtPreviewMode", "2");
      b.put("OfflineConfigFlowSize", "1024");
      b.put("OfflineConfigFlowTime", "30");
      b.put("OfflineConfigFtnThumbMaxSize", "32768");
    }
    String str = (String)b.get(paramString);
    if ((str == null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("],value null!");
      QLog.e("FileManagerUtil<FileAssistant>", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.getBytes().length >= paramInt))
    {
      int i = paramInt / 2;
      int k = paramInt / 4;
      Object localObject = paramString.toCharArray();
      StringBuilder localStringBuilder1 = new StringBuilder();
      paramInt = 0;
      while (paramInt < localObject.length)
      {
        localStringBuilder1.append(localObject[paramInt]);
        if (localStringBuilder1.toString().getBytes().length > i) {
          break;
        }
        paramInt += 1;
      }
      StringBuilder localStringBuilder2 = new StringBuilder();
      int j = localObject.length - 1;
      paramInt = localObject.length - 1;
      for (;;)
      {
        i = j;
        if (paramInt <= 0) {
          break;
        }
        localStringBuilder2.append(localObject[paramInt]);
        if (localStringBuilder2.toString().getBytes().length > k)
        {
          i = paramInt;
          break;
        }
        paramInt -= 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localStringBuilder1.toString());
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(paramString.substring(i));
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, QQFileManagerUtil.IThumbResult paramIThumbResult)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramIThumbResult != null) {
        paramIThumbResult.a(null);
      }
      return null;
    }
    Object localObject = new VFSFile(FMSettings.a().getDefaultThumbPath());
    if (!((VFSFile)localObject).exists()) {
      ((VFSFile)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FMSettings.a().getDefaultThumbPath());
    ((StringBuilder)localObject).append(b(paramString));
    ((StringBuilder)localObject).append(".JPG");
    localObject = ((StringBuilder)localObject).toString();
    if (FileUtil.a((String)localObject))
    {
      if (paramIThumbResult != null) {
        paramIThumbResult.a((String)localObject);
      }
      return localObject;
    }
    int i = d(paramString);
    if (i == 0)
    {
      if (!b(paramString, paramInt1, paramInt2, paramIThumbResult, (String)localObject)) {
        return null;
      }
    }
    else
    {
      if (i != 2) {
        break label166;
      }
      a(paramString, paramInt1, paramInt2, paramIThumbResult, (String)localObject);
    }
    return localObject;
    label166:
    if (paramIThumbResult != null) {
      paramIThumbResult.a(null);
    }
    return null;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, boolean paramBoolean, int paramInt1, TextPaint paramTextPaint, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramTextPaint != null) && (paramInt1 > 0))
    {
      int j;
      if (paramInt2 > 1) {
        j = paramInt2;
      } else {
        j = 1;
      }
      char[] arrayOfChar = paramString.toCharArray();
      Object localObject = new StringBuilder();
      int i = 0;
      int n;
      int m;
      for (int k = 0; i < arrayOfChar.length; k = m)
      {
        ((StringBuilder)localObject).append(arrayOfChar[i]);
        n = i;
        m = k;
        if (paramTextPaint.measureText(((StringBuilder)localObject).toString()) > paramInt1)
        {
          n = i - 1;
          i = k + 1;
          ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
          m = i;
          if (i >= j)
          {
            i = 1;
            break label154;
          }
        }
        i = n + 1;
      }
      i = 0;
      label154:
      localObject = paramString;
      if (i != 0)
      {
        if (paramBoolean) {
          j = 6;
        } else {
          j = 15;
        }
        if (paramString.length() < j) {
          localObject = paramString;
        } else {
          localObject = paramString.substring(paramString.length() - j);
        }
        StringBuilder localStringBuilder = new StringBuilder((String)localObject);
        m = 0;
        i = 0;
        k = 0;
        while (m < arrayOfChar.length - j)
        {
          localStringBuilder.append(arrayOfChar[m]);
          if (paramTextPaint.measureText(localStringBuilder.toString()) > paramInt1 * paramInt2)
          {
            paramInt1 = m - 2;
            break label328;
          }
          n = m + 1;
          if (paramString.substring(m, n).equals(jdField_a_of_type_JavaLangString)) {
            k = 1;
          }
          if (m == arrayOfChar.length - j - 1) {
            i = m - 2;
          }
          m = n;
        }
        paramInt1 = i;
        label328:
        if (paramInt1 <= 0) {
          paramInt1 = 0;
        }
        if (k == 0)
        {
          paramTextPaint = new StringBuilder();
          paramTextPaint.append(paramString.substring(0, paramInt1));
          paramTextPaint.append(jdField_a_of_type_JavaLangString);
          paramTextPaint.append((String)localObject);
          return paramTextPaint.toString();
        }
        paramTextPaint = new StringBuilder();
        paramTextPaint.append(paramString.substring(0, paramInt1));
        paramTextPaint.append((String)localObject);
        localObject = paramTextPaint.toString();
      }
      return localObject;
    }
    return "";
  }
  
  public static String a(Map paramMap)
  {
    try
    {
      paramMap = new JSONObject(paramMap).toString();
      return paramMap;
    }
    catch (Exception paramMap)
    {
      label14:
      break label14;
    }
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramArrayOfByte == null) {
      return "";
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      Object localObject2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      Object localObject1 = localObject2;
      if (((String)localObject2).length() == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append('0');
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((String)localObject1).toUpperCase());
      localStringBuilder.append(" ");
      ((PrintStream)localObject2).print(localStringBuilder.toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((String)localObject1).toUpperCase());
      ((StringBuilder)localObject2).append("");
      localStringBuffer.append(((StringBuilder)localObject2).toString());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static ArrayList<FileInfo> a(boolean paramBoolean, int paramInt)
  {
    Object localObject2 = new VFSFile(b()).listFiles();
    if (localObject2 == null) {
      return null;
    }
    localArrayList = new ArrayList();
    int i = 0;
    Object localObject3;
    Object localObject1;
    while (i < localObject2.length)
    {
      FileInfo localFileInfo = localObject2[i];
      localObject3 = localFileInfo.getPath();
      if ((paramBoolean) || (!localFileInfo.getName().startsWith(".")))
      {
        try
        {
          localFileInfo = new FileInfo((String)localObject3);
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localFileNotFoundException.printStackTrace();
          localObject1 = null;
        }
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
      }
      i += 1;
    }
    try
    {
      localObject1 = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).getAll();
      if ((localObject1 != null) && (((Map)localObject1).size() > 0))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Map.Entry)((Iterator)localObject1).next()).getKey();
          if (FileUtil.b((String)localObject2))
          {
            localObject2 = new VFSFile((String)localObject2);
            localObject3 = new FileInfo();
            ((FileInfo)localObject3).d(((VFSFile)localObject2).getName());
            ((FileInfo)localObject3).b(((VFSFile)localObject2).isDirectory());
            ((FileInfo)localObject3).e(((VFSFile)localObject2).getPath());
            ((FileInfo)localObject3).a(((VFSFile)localObject2).length());
            ((FileInfo)localObject3).b(((VFSFile)localObject2).lastModified());
            localArrayList.add(localObject3);
          }
        }
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (paramInt == 0)
      {
        Collections.sort(localArrayList, new FileUtil.MyFileCompare());
        return localArrayList;
      }
      Collections.sort(localArrayList, new FileCompare());
    }
  }
  
  public static HashMap<String, String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("&");
    if ((paramString != null) && (paramString.length > 0))
    {
      int i = 0;
      while (i < paramString.length)
      {
        String[] arrayOfString = paramString[i].split("_");
        if ((arrayOfString != null) && (arrayOfString.length == 2) && (!TextUtils.isEmpty(arrayOfString[0])) && (!TextUtils.isEmpty(arrayOfString[1]))) {
          localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public static LinkedHashMap a(String paramString)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "jsonToMap but jsonString is null!");
      }
      return localLinkedHashMap;
    }
    Object localObject = paramString.replace("\"", "");
    paramString = (String)localObject;
    if (((String)localObject).startsWith("{")) {
      paramString = ((String)localObject).substring(1);
    }
    localObject = paramString;
    if (paramString.endsWith("}")) {
      localObject = paramString.substring(0, paramString.length() - 1);
    }
    paramString = ((String)localObject).split(",");
    int i = 0;
    while (i < paramString.length)
    {
      localObject = paramString[i].split(":");
      if (localObject.length == 1) {
        localLinkedHashMap.put(localObject[0].toLowerCase(), "");
      } else {
        localLinkedHashMap.put(localObject[0].toLowerCase(), localObject[1]);
      }
      i += 1;
    }
    return localLinkedHashMap;
  }
  
  @TargetApi(9)
  public static Map<String, File> a(Context paramContext)
  {
    HashMap localHashMap = new HashMap(10);
    for (;;)
    {
      try
      {
        localHashMap.put("sdCard", Environment.getExternalStorageDirectory());
        Object localObject1 = (StorageManager)paramContext.getSystemService("storage");
        localObject1 = (String[])localObject1.getClass().getMethod("getVolumePaths", new Class[] { (Class)null }).invoke(localObject1, new Object[] { null });
        int k = localObject1.length;
        int i = 0;
        if (i >= k) {
          break label322;
        }
        Object localObject2 = localObject1[i];
        File localFile = new File((String)localObject2);
        if ((Build.VERSION.SDK_INT > 9) && (localFile.getUsableSpace() > 0L))
        {
          if (!localHashMap.isEmpty())
          {
            Iterator localIterator = localHashMap.keySet().iterator();
            if (!localIterator.hasNext()) {
              break label519;
            }
            if (((File)localHashMap.get((String)localIterator.next())).getPath().equalsIgnoreCase((String)localObject2) != true) {
              continue;
            }
            j = 1;
            break label521;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("this is a extCard Path:");
          ((StringBuilder)localObject2).append(localFile.getPath());
          QLog.i("FileManagerUtil<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
          localHashMap.put("externalSdCard", localFile);
        }
        i += 1;
        continue;
        localIllegalArgumentException.printStackTrace();
      }
      catch (Exception localException) {}catch (NoSuchMethodException localNoSuchMethodException)
      {
        break label293;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        break label301;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        break label309;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        break label317;
      }
      break label322;
      label293:
      localIllegalArgumentException.printStackTrace();
      break label322;
      label301:
      localIllegalArgumentException.printStackTrace();
      break label322;
      label309:
      localIllegalArgumentException.printStackTrace();
      break label322;
      label317:
      localIllegalArgumentException.printStackTrace();
      label322:
      if (!localHashMap.containsKey("externalSdCard")) {
        try
        {
          paramContext = paramContext.getExternalFilesDir(null);
          if (paramContext != null)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("extCard Path:");
            localStringBuilder.append(paramContext.getPath());
            QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
            if (!paramContext.getAbsolutePath().contains(((File)localHashMap.get("sdCard")).getAbsolutePath()))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("this is a extCard. Path:");
              localStringBuilder.append(paramContext.getPath());
              QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
              localHashMap.put("externalSdCard", paramContext);
              return localHashMap;
            }
          }
          else
          {
            QLog.i("FileManagerUtil<FileAssistant>", 1, "extCard Path:null");
            return localHashMap;
          }
        }
        catch (Exception paramContext)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Exception:");
          localStringBuilder.append(paramContext.toString());
          QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
        }
      }
      return localHashMap;
      label519:
      int j = 0;
      label521:
      if (j != 1) {}
    }
  }
  
  public static AppRuntime a()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public static void a()
  {
    ThreadManager.post(new QQFileManagerUtilImpl.5(), 8, null, false);
  }
  
  public static void a(int paramInt)
  {
    QQFMToastUtil.a(paramInt);
  }
  
  private static void a(int paramInt, String paramString, BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(paramInt))
    {
      if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).needShowGrayTips())
      {
        ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).showGrayTips(paramBaseQQAppInterface);
        return;
      }
      a(paramInt, paramString, paramFileManagerEntity);
    }
  }
  
  private static void a(int paramInt, String paramString, FileManagerEntity paramFileManagerEntity)
  {
    if (a(paramInt, paramFileManagerEntity.fileName)) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      a(paramString);
      return;
    }
    a(11, paramFileManagerEntity.fileName);
  }
  
  public static void a(long paramLong)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilArrayList == null) {
        jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      boolean bool = jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong));
      if (bool) {
        return;
      }
      jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("nSessionID[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]加入不显示取消按钮队列");
        QLog.e("##########", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public static void a(long paramLong, int paramInt, String paramString)
  {
    BaseQQAppInterface localBaseQQAppInterface = a();
    FileManagerEntity localFileManagerEntity = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).queryFileEntityBySessionId(localBaseQQAppInterface, paramLong);
    if (localFileManagerEntity == null) {
      return;
    }
    int i = localFileManagerEntity.nOpType;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 20) {}
        switch (i)
        {
        default: 
          return;
        case 9: 
          a(paramInt, null);
          return;
        case 7: 
          a(paramString, localFileManagerEntity);
          return;
        case 4: 
        case 6: 
          b(paramInt, paramString, localBaseQQAppInterface, localFileManagerEntity);
          return;
        case 3: 
        case 5: 
          a(paramInt, paramString, localFileManagerEntity);
          return;
          a(paramInt, paramString, localBaseQQAppInterface, localFileManagerEntity);
          return;
        }
      }
      c(paramInt, paramString, localFileManagerEntity);
      return;
    }
    if (!a(paramInt, localFileManagerEntity.fileName)) {
      a(paramString, localFileManagerEntity);
    }
  }
  
  public static void a(Activity paramActivity, TextView paramTextView)
  {
    if ((paramTextView != null) && (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramActivity.getResources().getDrawable(2130839399);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if ((paramString != null) && (FileUtil.b(paramString)))
    {
      if (d(paramString) == 5)
      {
        c(paramActivity, paramString);
        return;
      }
      ReportController.b(null, "dc00898", "", "", "0X800AE42", "0X800AE42", 0, 0, "", "", "", "");
      FileManagerReporter.a("0X8007152");
      WeakReference localWeakReference = new WeakReference(paramActivity);
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("ChannelId", "biz_src_jc_file");
      WXShareHelper localWXShareHelper = WXShareHelper.a();
      if ((localWXShareHelper.a()) && (localWXShareHelper.d()))
      {
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("name", "send_to_wx");
        localBundle2.putInt("resource_id", 2130844444);
        localBundle2.putString("value", "发送到微信");
        Bundle localBundle3 = new Bundle();
        localBundle3.putBundle("weixin", localBundle2);
        localBundle1.putBundle("extraMenu", localBundle3);
      }
      QbSdk.openFileReaderListWithQBDownload(paramActivity, paramString, localBundle1, new QQFileManagerUtilImpl.6(localWeakReference, paramString, localWXShareHelper));
      return;
    }
    a(2131692717);
  }
  
  public static void a(Context paramContext)
  {
    paramContext.getSharedPreferences("LAST_CHOOSE_", 0).edit().clear().commit();
  }
  
  public static void a(Context paramContext, FileManagerEntity paramFileManagerEntity, BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    QQFileModel.a(paramFileManagerEntity).a(paramBoolean, paramContext, new QQFileManagerUtilImpl.2(paramFileManagerEntity, paramBaseQQAppInterface));
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (!new VFSFile(paramString).exists())
    {
      QQFMToastUtil.a(paramContext, 0, 2131692737);
      return;
    }
    ThreadManager.post(new QQFileManagerUtilImpl.4(paramString, paramContext), 8, null, true);
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (a().getApp() == null)
    {
      localBundle1 = new Bundle();
      localBundle1.putString("_filename_from_dlg", paramContext.getString(2131694576));
      localBundle1.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
      Bundle localBundle2 = new Bundle();
      localBundle2.putAll(paramBundle);
      localBundle2.putString("big_brother_source_key", "biz_src_jc_file");
      localBundle1.putBundle("_user_data", localBundle2);
      paramBundle = new Intent("com.tencent.mobileqq.qfile_unifromdownload");
      paramBundle.putExtra("param", localBundle1);
      paramBundle.putExtra("url", paramString);
      paramContext.sendBroadcast(paramBundle);
      QLog.i("FileManagerUtil<FileAssistant>", 1, "app is null try sendBroadcast!");
      return;
    }
    Bundle localBundle1 = new Bundle();
    localBundle1.putAll(paramBundle);
    localBundle1.putString("big_brother_source_key", "biz_src_jc_file");
    b(paramContext, paramString, localBundle1);
  }
  
  public static void a(ImageView paramImageView, FileManagerEntity paramFileManagerEntity)
  {
    Drawable localDrawable;
    if (paramFileManagerEntity.nFileType == 13) {
      localDrawable = BaseApplication.getContext().getResources().getDrawable(2130844437);
    }
    try
    {
      if (paramFileManagerEntity.strThumbPath == null)
      {
        paramImageView.setImageDrawable(localDrawable);
        return;
      }
      paramImageView.setImageDrawable(URLDrawable.getDrawable(new URL(paramFileManagerEntity.strThumbPath), localDrawable, localDrawable));
      return;
    }
    catch (Exception paramFileManagerEntity)
    {
      label55:
      break label55;
    }
    paramImageView.setImageDrawable(localDrawable);
    return;
    paramFileManagerEntity = FileUtil.a(paramFileManagerEntity.fileName);
    if (paramFileManagerEntity == null)
    {
      paramImageView.setImageResource(2130844437);
      return;
    }
    paramImageView.setImageResource(c(paramFileManagerEntity));
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    paramString = FileUtil.a(paramString);
    if (paramString == null)
    {
      paramImageView.setImageResource(2130844437);
      return;
    }
    paramImageView.setImageResource(c(paramString));
  }
  
  public static void a(TextView paramTextView)
  {
    if (paramTextView != null)
    {
      Drawable localDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localDrawable != null)
      {
        ((Animatable)localDrawable).stop();
        jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
        paramTextView.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  public static void a(TextView paramTextView, FileManagerEntity paramFileManagerEntity)
  {
    if (paramTextView.getMeasuredWidth() == 0)
    {
      paramTextView.post(new QQFileManagerUtilImpl.9(paramTextView, paramFileManagerEntity));
      return;
    }
    c(paramTextView, paramFileManagerEntity);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    int k = ((IFMConfig)QRoute.api(IFMConfig.class)).timAIOGaryTipsCount();
    if (k == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "aio switch is off,return!");
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showTime_");
    ((StringBuilder)localObject).append(paramBaseQQAppInterface.getCurrentAccountUin());
    String str = ((StringBuilder)localObject).toString();
    localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).queryFileManagerEntityBySessionId(paramBaseQQAppInterface, paramLong);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "entity is null! return");
      }
      return;
    }
    int j = d(((FileManagerEntity)localObject).fileName);
    if (j != -1)
    {
      i = j;
      if (j != 11) {}
    }
    else
    {
      i = d(((FileManagerEntity)localObject).getFilePath());
    }
    if ((i != 3) && (i != 6))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "File type wrong, return!");
      }
      return;
    }
    if ((((FileManagerEntity)localObject).peerType != 0) && (((FileManagerEntity)localObject).peerType != 3000))
    {
      if (QLog.isColorLevel())
      {
        paramBaseQQAppInterface = new StringBuilder();
        paramBaseQQAppInterface.append("aio[");
        paramBaseQQAppInterface.append(((FileManagerEntity)localObject).peerType);
        paramBaseQQAppInterface.append("] not buddy or disc, return!");
        QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, paramBaseQQAppInterface.toString());
      }
      return;
    }
    SharedPreferences localSharedPreferences = paramBaseQQAppInterface.getApplication().getSharedPreferences("TimTips", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt("AIOshowTime_Total", 0);
    if (i >= k)
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerUtil<FileAssistant>_TimTips", 2, "more then total return!");
      }
      return;
    }
    paramLong = localSharedPreferences.getLong(str, 0L);
    long l = MessageCache.a();
    if (l - paramLong < 86400000L)
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerUtil<FileAssistant>_TimTips", 2, "less OneDay return!");
      }
      return;
    }
    if (PackageUtil.a(paramBaseQQAppInterface.getApp().getBaseContext(), "com.tencent.tim"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "Tim installed return!");
      }
      return;
    }
    new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new QQFileManagerUtilImpl.15(paramBaseQQAppInterface, (FileManagerEntity)localObject), 1000L);
    localEditor.putLong(str, l);
    localEditor.putInt("AIOshowTime_Total", i + 1);
    localEditor.commit();
    if (QLog.isColorLevel())
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("lastShowTime[");
      paramBaseQQAppInterface.append(l);
      paramBaseQQAppInterface.append("],[");
      paramBaseQQAppInterface.append(e(((FileManagerEntity)localObject).peerUin));
      paramBaseQQAppInterface.append("]add new aiograyTips!");
      QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, paramBaseQQAppInterface.toString());
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6)
  {
    a(paramBaseQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramLong4, paramLong5, paramInt, paramString6, new Bundle());
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6, Bundle paramBundle)
  {
    str = paramString2;
    HashMap localHashMap = new HashMap();
    long l3 = 0L;
    if (paramLong2 < 0L) {
      paramLong2 = 0L;
    }
    if (str != null) {}
    try
    {
      if (paramString2.length() > 0) {
        paramString2 = str.substring(str.indexOf("://") + 3, str.lastIndexOf(":"));
      } else {
        paramString2 = "";
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        int n;
        long l1;
        long l2;
        float f;
        int i1;
        int i2;
        int j;
        int k;
        int m;
        int i;
        paramString2 = str;
      }
    }
    n = QQFileUtilsImpl.a();
    localHashMap.put("serverip", paramString2);
    localHashMap.put("param_Server", paramString2);
    localHashMap.put("param_ftnIP", paramString2);
    localHashMap.put("param_PeerUin", paramString3);
    localHashMap.put("param_uuid", paramString4);
    localHashMap.put("param_MD5", paramString5);
    localHashMap.put("param_fsized", String.valueOf(paramLong4));
    localHashMap.put("param_fsizeo", String.valueOf(paramLong5));
    localHashMap.put("param_retry", String.valueOf(paramInt));
    localHashMap.put("param_nSessionId", String.valueOf(paramLong1));
    localHashMap.put("param_errMsg", String.valueOf(paramString6));
    localHashMap.put("param_ipStackType", String.valueOf(n));
    localHashMap.put("param_realTransferType", String.valueOf(0));
    if (paramBundle != null)
    {
      l1 = paramBundle.getLong("param_transferTime", -1L);
      if (l1 >= 0L) {}
    }
    else
    {
      l1 = paramLong2;
    }
    l2 = l3;
    if (l1 > 0L)
    {
      l2 = l3;
      if (paramLong3 >= 1024L)
      {
        f = (float)l1 / 1000.0F;
        l2 = ((float)paramLong3 / f);
      }
    }
    localHashMap.put("param_speed", String.valueOf(l2));
    i1 = QQFileUtilsImpl.b();
    i2 = QQFileUtilsImpl.c();
    if (paramBundle != null)
    {
      j = paramBundle.getInt("param_fromType", 0);
      k = paramBundle.getInt("param_V6SelectType", 0);
      m = paramBundle.getInt("param_ipAddrType", 0);
      i = paramBundle.getInt("param_ishttps", 0);
    }
    else
    {
      i = 0;
      j = 0;
      k = 0;
      m = 0;
    }
    localHashMap.put("param_fromType", String.valueOf(j));
    localHashMap.put("param_V6SelectType", String.valueOf(k));
    localHashMap.put("param_ipAddrType", String.valueOf(m));
    localHashMap.put("param_stackType", String.valueOf(i1));
    localHashMap.put("param_loginType", String.valueOf(i2));
    localHashMap.put("param_ishttps", String.valueOf(i));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramBaseQQAppInterface.getCurrentAccountUin(), paramString1, true, paramLong2, paramLong3, localHashMap, paramString6);
    if (QLog.isColorLevel())
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("ReportFilemanagerInfo actType[");
      paramBaseQQAppInterface.append(paramString1);
      paramBaseQQAppInterface.append("], isSuccess[");
      paramBaseQQAppInterface.append(true);
      paramBaseQQAppInterface.append("], nSessionId[");
      paramBaseQQAppInterface.append(paramLong1);
      paramBaseQQAppInterface.append("], duration[");
      paramBaseQQAppInterface.append(paramLong2);
      paramBaseQQAppInterface.append("], rpSize[");
      paramBaseQQAppInterface.append(paramLong3);
      paramBaseQQAppInterface.append("], transfSize[");
      paramBaseQQAppInterface.append(paramLong4);
      paramBaseQQAppInterface.append("], fileSize[");
      paramBaseQQAppInterface.append(paramLong5);
      paramBaseQQAppInterface.append("], retryTimes[");
      paramBaseQQAppInterface.append(paramInt);
      paramBaseQQAppInterface.append("], reserved[");
      paramBaseQQAppInterface.append(paramString6);
      paramBaseQQAppInterface.append("], ipStackType[");
      paramBaseQQAppInterface.append(n);
      paramBaseQQAppInterface.append("] realTransferType[");
      paramBaseQQAppInterface.append(0);
      paramBaseQQAppInterface.append("] speed[");
      paramBaseQQAppInterface.append(l2);
      paramBaseQQAppInterface.append("] fromType[");
      paramBaseQQAppInterface.append(j);
      paramBaseQQAppInterface.append("] transferTime[");
      paramBaseQQAppInterface.append(l1);
      paramBaseQQAppInterface.append("] isHttps[");
      paramBaseQQAppInterface.append(i);
      paramBaseQQAppInterface.append("]");
      QLog.d("@@@@@@@", 2, paramBaseQQAppInterface.toString());
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    a(paramBaseQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramString6, paramLong4, paramLong5, paramLong6, paramString7, paramString8, paramInt, paramString9, paramString10, new Bundle());
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10, Bundle paramBundle)
  {
    str = paramString2;
    Object localObject = paramString9;
    long l1;
    if (paramLong2 == 0L) {
      l1 = System.currentTimeMillis();
    } else {
      l1 = paramLong2;
    }
    if (l1 < 1L) {
      paramLong2 = 0L;
    } else {
      paramLong2 = System.currentTimeMillis() - l1;
    }
    if (str != null) {}
    try
    {
      if (paramString2.length() > 0) {
        paramString2 = str.substring(str.indexOf("://") + 3, str.lastIndexOf(":"));
      } else {
        paramString2 = "";
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        int i;
        int n;
        long l2;
        float f;
        long l3;
        int i1;
        int i2;
        int j;
        int k;
        int m;
        paramString2 = str;
      }
    }
    if (paramLong2 < 0L) {
      paramLong2 = 0L;
    }
    i = 1;
    if ((localObject == null) || (paramString9.length() <= 0) || ((((String)localObject).indexOf("Network is unreachable") <= 0) && (((String)localObject).indexOf("No route to host") <= 0) && (((String)localObject).indexOf("MalformedURLException") <= 0))) {
      i = 0;
    }
    if ((NetworkUtil.isNetSupport(BaseApplication.getContext())) && (i == 0))
    {
      paramString9 = (String)localObject;
    }
    else
    {
      paramString9 = new StringBuilder();
      paramString9.append((String)localObject);
      paramString9.append("_NotNetWork");
      paramString9 = paramString9.toString();
      paramLong3 = 9004L;
    }
    if (!paramBaseQQAppInterface.isLogin())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString9);
      ((StringBuilder)localObject).append("_NotLogin");
      paramString9 = ((StringBuilder)localObject).toString();
      paramLong3 = 9004L;
    }
    n = QQFileUtilsImpl.a();
    localObject = new HashMap();
    ((HashMap)localObject).put("serverip", paramString2);
    ((HashMap)localObject).put("param_Server", paramString2);
    ((HashMap)localObject).put("param_ftnIP", paramString2);
    ((HashMap)localObject).put("param_PeerUin", String.valueOf(paramString3));
    ((HashMap)localObject).put("param_uuid", String.valueOf(paramString4));
    ((HashMap)localObject).put("param_MD5", paramString5);
    ((HashMap)localObject).put("param_FailCode", Long.toString(paramLong3));
    ((HashMap)localObject).put("param_errorDesc", String.valueOf(paramString6));
    ((HashMap)localObject).put("param_fsized", String.valueOf(paramLong5));
    ((HashMap)localObject).put("param_fsizeo", String.valueOf(paramLong6));
    ((HashMap)localObject).put("param_url", String.valueOf(paramString7));
    ((HashMap)localObject).put("param_rspHeader", String.valueOf(paramString8));
    ((HashMap)localObject).put("param_retry", String.valueOf(paramInt));
    paramString2 = new StringBuilder();
    paramString2.append(paramString9);
    paramString2.append("uin[");
    paramString2.append(paramBaseQQAppInterface.getCurrentAccountUin());
    paramString2.append("]");
    ((HashMap)localObject).put("param_errMsg", paramString2.toString());
    ((HashMap)localObject).put("param_nSessionId", String.valueOf(paramLong1));
    ((HashMap)localObject).put("param_ipStackType", String.valueOf(n));
    ((HashMap)localObject).put("param_realTransferType", String.valueOf(0));
    if (paramBundle != null)
    {
      l2 = paramBundle.getLong("param_transferTime", -1L);
      if (l2 >= 0L) {}
    }
    else
    {
      l2 = paramLong2;
    }
    if ((l2 > 0L) && (paramLong4 >= 1024L))
    {
      f = (float)l2 / 1000.0F;
      l3 = ((float)paramLong4 / f);
    }
    else
    {
      l3 = 0L;
    }
    ((HashMap)localObject).put("param_speed", String.valueOf(l3));
    i1 = QQFileUtilsImpl.b();
    i2 = QQFileUtilsImpl.c();
    if (paramBundle != null)
    {
      i = paramBundle.getInt("param_fromType", 0);
      j = paramBundle.getInt("param_V6SelectType", 0);
      k = paramBundle.getInt("param_ipAddrType", 0);
      m = paramBundle.getInt("param_ishttps", 0);
    }
    else
    {
      m = 0;
      i = 0;
      j = 0;
      k = 0;
    }
    ((HashMap)localObject).put("param_fromType", String.valueOf(i));
    ((HashMap)localObject).put("param_V6SelectType", String.valueOf(j));
    ((HashMap)localObject).put("param_ipAddrType", String.valueOf(k));
    ((HashMap)localObject).put("param_stackType", String.valueOf(i1));
    ((HashMap)localObject).put("param_loginType", String.valueOf(i2));
    ((HashMap)localObject).put("param_ishttps", String.valueOf(m));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramBaseQQAppInterface.getCurrentAccountUin(), paramString1, false, paramLong2, paramLong4, (HashMap)localObject, paramString10);
    if (QLog.isColorLevel())
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("ReportFilemanagerInfo actType[");
      paramBaseQQAppInterface.append(paramString1);
      paramBaseQQAppInterface.append("], isSuccess[");
      paramBaseQQAppInterface.append(false);
      paramBaseQQAppInterface.append("], nSessionId[");
      paramBaseQQAppInterface.append(paramLong1);
      paramBaseQQAppInterface.append("], param_FailCode[");
      paramBaseQQAppInterface.append(paramLong3);
      paramBaseQQAppInterface.append("], startTime[");
      paramBaseQQAppInterface.append(l1);
      paramBaseQQAppInterface.append("], duration[");
      paramBaseQQAppInterface.append(paramLong2);
      paramBaseQQAppInterface.append("], rpSize[");
      paramBaseQQAppInterface.append(paramLong4);
      paramBaseQQAppInterface.append("], transfSize[");
      paramBaseQQAppInterface.append(paramLong5);
      paramBaseQQAppInterface.append("], fileSize[");
      paramBaseQQAppInterface.append(paramLong6);
      paramBaseQQAppInterface.append("], param_errorDesc[");
      paramBaseQQAppInterface.append(paramString6);
      paramBaseQQAppInterface.append("], retryTimes[");
      paramBaseQQAppInterface.append(paramInt);
      paramBaseQQAppInterface.append("], reserved[");
      paramBaseQQAppInterface.append(paramString10);
      paramBaseQQAppInterface.append("], ipStackType[");
      paramBaseQQAppInterface.append(n);
      paramBaseQQAppInterface.append("] realTransferType[");
      paramBaseQQAppInterface.append(0);
      paramBaseQQAppInterface.append("] speed[");
      paramBaseQQAppInterface.append(l3);
      paramBaseQQAppInterface.append("], errMsg[");
      paramBaseQQAppInterface.append(paramString9);
      paramBaseQQAppInterface.append("] fromType[");
      paramBaseQQAppInterface.append(i);
      paramBaseQQAppInterface.append("] transferTime[");
      paramBaseQQAppInterface.append(l2);
      paramBaseQQAppInterface.append("] isHttps[");
      paramBaseQQAppInterface.append(m);
      paramBaseQQAppInterface.append("]");
      QLog.d("@@@@@@@", 2, paramBaseQQAppInterface.toString());
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    a(paramBaseQQAppInterface, paramBaseQQAppInterface.getCurrentAccountUin(), paramContext);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    if (!paramFileManagerEntity.bSend)
    {
      paramBaseQQAppInterface = new QQFileManagerUtilImpl.7();
      DialogUtil.a(paramContext, 230, paramContext.getString(2131698384), paramContext.getString(2131698383), 2131720490, 2131694583, paramBaseQQAppInterface, null).show();
      return;
    }
    paramBaseQQAppInterface = paramContext.getString(2131692311);
    paramFileManagerEntity = paramContext.getString(2131692310);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null);
    localActionSheet.addButton(paramBaseQQAppInterface);
    localActionSheet.addCancelButton(paramContext.getString(2131690728));
    localActionSheet.setMainTitle(paramFileManagerEntity);
    localActionSheet.setOnButtonClickListener(new QQFileManagerUtilImpl.8(localActionSheet));
    localActionSheet.show();
  }
  
  public static void a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    ThreadManager.post(new QQFileManagerUtilImpl.17(paramContext, paramInt, paramString1, paramBaseQQAppInterface, paramString2), 2, null, true);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    if (paramChatMessage == null) {
      return;
    }
    if (!(paramChatMessage instanceof MessageForFile)) {
      return;
    }
    paramChatMessage = a(paramBaseQQAppInterface, (MessageForFile)paramChatMessage);
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).sendFileToDataline(paramBaseQQAppInterface, paramContext, paramChatMessage);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    Object localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFriendsByFriendsManager(paramBaseQQAppInterface, paramFileManagerEntity);
    int i = -1;
    if (localObject != null) {
      i = ((Friends)localObject).iTermType;
    }
    int j = d(paramFileManagerEntity.fileName);
    if (j == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PreloadThumb Id[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
      ((StringBuilder)localObject).append("] PicFile, from device[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("] size(wh)[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.imgWidth);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramFileManagerEntity.imgHeight);
      ((StringBuilder)localObject).append("]");
      QLog.i("FileManagerUtil<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      if (j != 2) {
        break label642;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PreloadThumb Id[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
      ((StringBuilder)localObject).append("] VideoFile, from device[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("] Preload VideoThumb size(wh)[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.imgWidth);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramFileManagerEntity.imgHeight);
      ((StringBuilder)localObject).append("]");
      QLog.i("FileManagerUtil<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    if ((!b()) && (a())) {
      return;
    }
    if (j == 0)
    {
      if (((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).isNeedCompressCut(paramFileManagerEntity))
      {
        paramFileManagerEntity.strThumbPath = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).downLoadDiscThumb(paramBaseQQAppInterface, paramFileManagerEntity, 7);
        if (QLog.isColorLevel())
        {
          paramBaseQQAppInterface = new StringBuilder();
          paramBaseQQAppInterface.append("PreloadThumb Id[");
          paramBaseQQAppInterface.append(paramFileManagerEntity.nSessionId);
          paramBaseQQAppInterface.append("] is badPic Preload 750 Thumb[");
          paramBaseQQAppInterface.append(paramFileManagerEntity.strThumbPath);
          paramBaseQQAppInterface.append("]");
          QLog.i("FileManagerUtil<FileAssistant>", 1, paramBaseQQAppInterface.toString());
        }
      }
      else
      {
        paramFileManagerEntity.strThumbPath = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).downLoadDiscThumb(paramBaseQQAppInterface, paramFileManagerEntity, 5);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("PreloadThumb Id[");
          ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
          ((StringBuilder)localObject).append("] Preload 384 Thumb[");
          ((StringBuilder)localObject).append(paramFileManagerEntity.strThumbPath);
          ((StringBuilder)localObject).append("]");
          QLog.i("FileManagerUtil<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        }
        if (!a())
        {
          paramFileManagerEntity.strThumbPath = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).downLoadDiscThumb(paramBaseQQAppInterface, paramFileManagerEntity, 7);
          if (QLog.isColorLevel())
          {
            paramBaseQQAppInterface = new StringBuilder();
            paramBaseQQAppInterface.append("PreloadThumb Id[");
            paramBaseQQAppInterface.append(paramFileManagerEntity.nSessionId);
            paramBaseQQAppInterface.append("] is Wi-Fi Preload 750 Thumb[");
            paramBaseQQAppInterface.append(paramFileManagerEntity.strThumbPath);
            paramBaseQQAppInterface.append("]");
            QLog.i("FileManagerUtil<FileAssistant>", 1, paramBaseQQAppInterface.toString());
          }
        }
      }
    }
    else if (j == 2) {
      if (paramFileManagerEntity.peerType == 3000)
      {
        paramBaseQQAppInterface = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).downloadDiscVideoThumb(paramBaseQQAppInterface, paramFileManagerEntity);
        if (paramBaseQQAppInterface != null) {
          paramFileManagerEntity.strLargeThumPath = paramBaseQQAppInterface;
        }
      }
      else
      {
        paramBaseQQAppInterface = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).downloadOfflineVideoThumb(paramBaseQQAppInterface, paramFileManagerEntity);
        if (paramBaseQQAppInterface != null) {
          paramFileManagerEntity.strLargeThumPath = paramBaseQQAppInterface;
        }
      }
    }
    return;
    label642:
    QLog.i("FileManagerUtil<FileAssistant>", 1, "not pic or video!");
  }
  
  private static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Context paramContext)
  {
    int i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(paramContext, paramString, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getSUNIFORMGENDOWNLOADCANCEL());
    if (i > 0) {
      ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "1", "1", null, null);
    }
    i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(paramContext, paramString, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getSUNIFORMABSDKDOWNLOADCANCEL());
    if (i > 0) {
      ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "1", "0", null, null);
    }
    i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(paramContext, paramString, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getSUNIFORMGENDOWNLOADPAUSE());
    if (i > 0) {
      ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "2", "1", null, null);
    }
    i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(paramContext, paramString, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getSUNIFORMABSDKDOWNLOADPAUSE());
    if (i > 0) {
      ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "2", "0", null, null);
    }
    i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(paramContext, paramString, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getSUNIFORMGENDOWNLOADENTER());
    if (i > 0) {
      ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "0", "1", null, null);
    }
    i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(paramContext, paramString, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getSUNIFORMABSDKDOWNLOADENTER());
    if (i > 0) {
      ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "0", "0", null, null);
    }
    i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(paramContext, paramString, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getSUNIFORMGENDOWNLOADRUN());
    if (i > 0) {
      ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "3", "1", null, null);
    }
    i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(paramContext, paramString, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getSUNIFORMABSDKDOWNLOADRUN());
    if (i > 0) {
      ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "3", "0", null, null);
    }
    i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(paramContext, paramString, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getSUNIFORMGENDOWNLOADSUCC());
    if (i > 0) {
      ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", "Download", "Complete_download", 1, i, 0, "0", "1", null, null);
    }
    i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(paramContext, paramString, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getSUNIFORMGENDOWNLOADFAILD());
    if (i > 0) {
      ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "0", "1", null, null);
    }
    i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(paramContext, paramString, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getSUNIFORMABSDKDOWNLOADSUCC());
    if (i > 0) {
      ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", "Download", "Complete_download", 1, i, 0, "0", null, null, null);
    }
    i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(paramContext, paramString, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getSUNIFORMABSDKDOWNLOADFAILD());
    if (i > 0) {
      ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "0", "0", null, null);
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ThreadManager.post(new QQFileManagerUtilImpl.16(paramString2, paramBaseQQAppInterface, paramInt, paramString1), 8, null, true);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, a());
      }
      return;
    }
    int i = (int)a(paramFileManagerEntity.peerType);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("=_= Id[");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    localStringBuilder.append("],setTempParam[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    QLog.i("FileManagerUtil<FileAssistant>", 2, localStringBuilder.toString());
    paramFileManagerEntity.tmpSessionType = i;
    paramFileManagerEntity.tmpSessionSig = a(paramBaseQQAppInterface, paramFileManagerEntity.peerUin, i);
    if (i != 102)
    {
      if ((i != 104) && (i != 105)) {
        return;
      }
      paramFileManagerEntity.tmpSessionRelatedUin = paramString1;
      return;
    }
    paramFileManagerEntity.tmpSessionFromPhone = paramString1;
    paramFileManagerEntity.tmpSessionToPhone = paramString2;
  }
  
  public static void a(ChatMessage paramChatMessage, MessageForFile paramMessageForFile)
  {
    paramMessageForFile.uniseq = paramChatMessage.uniseq;
    paramMessageForFile.msgseq = paramChatMessage.msgseq;
    paramMessageForFile.fileName = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
    String str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSize");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForFile.fileSize = Long.parseLong(str1);
    }
    str1 = paramChatMessage.getExtInfoFromExtStr(((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getMultiMsgConstantEXTRAKEYOUTESTUIN());
    String str2 = paramChatMessage.getExtInfoFromExtStr(((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getMultiMsgConstantEXTRAKEYOUTESTUINTYPE());
    paramChatMessage = paramChatMessage.getExtInfoFromExtStr(((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getMultiMsgConstantEXTRAKEYOUTESTUNISEQ());
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForFile.saveExtInfoToExtStr(((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getMultiMsgConstantEXTRAKEYOUTESTUIN(), str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      paramMessageForFile.saveExtInfoToExtStr(((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getMultiMsgConstantEXTRAKEYOUTESTUINTYPE(), str2);
    }
    if (!TextUtils.isEmpty(paramChatMessage)) {
      paramMessageForFile.saveExtInfoToExtStr(((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getMultiMsgConstantEXTRAKEYOUTESTUNISEQ(), paramChatMessage);
    }
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    boolean bool = FileUtil.b(paramFileManagerEntity.getFilePath());
    if ((bool) && (b(paramFileManagerEntity.nOpType)))
    {
      paramFileManagerEntity.cloudType = 3;
      paramFileManagerEntity.status = 1;
      return;
    }
    if (paramFileManagerEntity.getCloudType() != 3) {
      return;
    }
    if ((bool) && ((paramFileManagerEntity.nOpType == 0) || (paramFileManagerEntity.nOpType == 6))) {
      return;
    }
    if ((bool) && (paramFileManagerEntity.nOpType == 51))
    {
      if (paramFileManagerEntity.status == 16) {
        paramFileManagerEntity.status = 0;
      }
      return;
    }
    if (paramFileManagerEntity.nFileType == 5) {
      ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(paramFileManagerEntity);
    }
    if (paramFileManagerEntity.status == 1)
    {
      paramFileManagerEntity.status = 16;
      if (paramFileManagerEntity.peerType == 6000)
      {
        paramFileManagerEntity.setCloudType(6);
        paramFileManagerEntity.status = 16;
        return;
      }
      if ((paramFileManagerEntity.Uuid != null) && (paramFileManagerEntity.Uuid.length() > 0))
      {
        paramFileManagerEntity.setCloudType(1);
        paramFileManagerEntity.status = -1;
        return;
      }
      if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId))
      {
        paramFileManagerEntity.setCloudType(2);
        paramFileManagerEntity.status = -1;
      }
    }
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, BaseQQAppInterface paramBaseQQAppInterface, Activity paramActivity, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.status = 2;
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).insertToMemMap(paramBaseQQAppInterface, localFileManagerEntity);
    paramBaseQQAppInterface = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).createForwardFileInfo(localFileManagerEntity);
    paramBaseQQAppInterface.b(paramInt);
    paramFileManagerEntity = new Bundle();
    paramFileManagerEntity.putInt("forward_type", ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getForwardUtilsForwardTypeFILE());
    paramFileManagerEntity.putParcelable("fileinfo", paramBaseQQAppInterface);
    paramFileManagerEntity.putBoolean("not_forward", true);
    paramBaseQQAppInterface = new Intent();
    paramBaseQQAppInterface.putExtras(paramFileManagerEntity);
    paramBaseQQAppInterface.putExtra("destroy_last_activity", true);
    paramBaseQQAppInterface.putExtra("forward_type", ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getForwardUtilsForwardTypeFILE());
    paramBaseQQAppInterface.putExtra("forward_filepath", localFileManagerEntity.getFilePath());
    paramFileManagerEntity = new StringBuilder();
    paramFileManagerEntity.append(a(2131704647));
    paramFileManagerEntity.append(d(localFileManagerEntity.fileName));
    paramFileManagerEntity.append(a(2131704640));
    paramFileManagerEntity.append(FileUtil.a(localFileManagerEntity.fileSize));
    paramFileManagerEntity.append("。");
    paramBaseQQAppInterface.putExtra("forward_text", paramFileManagerEntity.toString());
    paramBaseQQAppInterface.putExtra("k_favorites", c(localFileManagerEntity));
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).startForwardActivityForResult(paramActivity, paramBaseQQAppInterface, 103);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, BaseQQAppInterface paramBaseQQAppInterface, QQFileManagerUtil.CheckResult paramCheckResult)
  {
    QQFileManagerUtil.FileExecutor.a().execute(new QQFileManagerUtilImpl.18(paramFileManagerEntity, paramCheckResult, paramBaseQQAppInterface));
  }
  
  public static void a(AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    b(paramFileManagerEntity);
    String str = paramFileManagerEntity.getFilePath();
    if (paramFileManagerEntity.nFileType == 0)
    {
      if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath))
      {
        str = paramFileManagerEntity.strMiddleThumPath;
      }
      else if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath))
      {
        str = paramFileManagerEntity.strLargeThumPath;
      }
      else if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))
      {
        str = paramFileManagerEntity.getFilePath();
        ThreadManager.executeOnSubThread(new QQFileManagerUtilImpl.1(paramFileManagerEntity));
      }
    }
    else if (paramFileManagerEntity.nFileType == 2)
    {
      if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath)) {
        str = paramFileManagerEntity.strLargeThumPath;
      } else if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath)) {
        str = paramFileManagerEntity.strMiddleThumPath;
      } else {
        str = null;
      }
    }
    else if (paramFileManagerEntity.nFileType == 13) {
      str = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getTDDocFileThumbUrl(paramFileManagerEntity.Uuid);
    }
    a(paramAsyncImageView, str, paramFileManagerEntity.nFileType);
  }
  
  public static void a(AsyncImageView paramAsyncImageView, String paramString)
  {
    int i = d(paramString);
    try
    {
      paramAsyncImageView.setImageResource(a(i));
      return;
    }
    catch (Exception paramAsyncImageView)
    {
      paramAsyncImageView.printStackTrace();
    }
  }
  
  public static void a(AsyncImageView paramAsyncImageView, String paramString, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        if (paramInt != 5)
        {
          if (paramInt != 13)
          {
            paramAsyncImageView.setDefaultImage(a(paramInt));
            return;
          }
          paramAsyncImageView.setDefaultImage(2130844437);
          paramAsyncImageView.setUrlIconAsyncImage(paramString);
          return;
        }
        paramAsyncImageView.setDefaultImage(2130844325);
        if (!FileUtil.a(paramString)) {
          return;
        }
        paramAsyncImageView.setApkIconAsyncImage(paramString);
        return;
      }
      paramAsyncImageView.setDefaultImage(2130844438);
      if (!FileUtil.a(paramString)) {
        return;
      }
      try
      {
        paramAsyncImageView.setAsyncImage(paramString);
        return;
      }
      catch (Exception paramAsyncImageView)
      {
        paramAsyncImageView.printStackTrace();
        return;
      }
    }
    paramAsyncImageView.setDefaultImage(2130844363);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  public static void a(AsyncImageView paramAsyncImageView, String paramString, boolean paramBoolean)
  {
    String str = FileUtil.a(paramString);
    if (str == null)
    {
      paramAsyncImageView.setImageResource(2130844437);
      return;
    }
    paramAsyncImageView.setImageResource(c(paramString));
    if (paramBoolean)
    {
      int i = d(str);
      if (i != 0)
      {
        if (i != 2) {
          return;
        }
        paramAsyncImageView.setDefaultImage(2130844438);
        paramAsyncImageView.setAsyncImage(paramString);
        return;
      }
      paramAsyncImageView.setDefaultImage(2130844363);
      paramAsyncImageView.setAsyncImage(paramString);
    }
  }
  
  public static void a(String paramString)
  {
    QQFMToastUtil.a(paramString);
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qlink_new_count_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localSharedPreferences.edit().putInt(paramString, paramInt).commit();
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, QQFileManagerUtil.IThumbResult paramIThumbResult, String paramString2)
  {
    a(paramString1, true, paramInt1, paramInt2, 3, new QQFileManagerUtilImpl.11(paramIThumbResult, paramString2, paramString1));
  }
  
  private static void a(String paramString, FileManagerEntity paramFileManagerEntity)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      a(paramString);
      return;
    }
    a(13, paramFileManagerEntity.fileName);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qlink_new_flag_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    localSharedPreferences.edit().putBoolean(paramString1, paramBoolean).commit();
  }
  
  @TargetApi(10)
  public static void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, QQFileManagerUtil.IGetVideoCallback paramIGetVideoCallback)
  {
    ThreadManager.post(new QQFileManagerUtilImpl.13(paramString, paramInt3, paramBoolean, paramIGetVideoCallback, paramInt1, paramInt2), 8, null, true);
  }
  
  public static void a(List<FileManagerEntity> paramList, Activity paramActivity)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    long l1 = 0L;
    long l2 = l1;
    if (paramList != null)
    {
      l2 = l1;
      if (paramList.size() > 0)
      {
        paramList = paramList.iterator();
        for (;;)
        {
          l2 = l1;
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (FileManagerEntity)paramList.next();
          if (!((FileManagerEntity)localObject).sendCloudUnsuccessful())
          {
            ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
            localForwardFileInfo.b(10001);
            localForwardFileInfo.d(((FileManagerEntity)localObject).getCloudType());
            localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
            localForwardFileInfo.d(((FileManagerEntity)localObject).fileName);
            localForwardFileInfo.c(((FileManagerEntity)localObject).uniseq);
            localForwardFileInfo.c(((FileManagerEntity)localObject).WeiYunFileId);
            localForwardFileInfo.d(((FileManagerEntity)localObject).fileSize);
            localForwardFileInfo.a(((FileManagerEntity)localObject).getFilePath());
            localForwardFileInfo.b(((FileManagerEntity)localObject).Uuid);
            localForwardFileInfo.jdField_a_of_type_Int = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getForwardId();
            if ((((FileManagerEntity)localObject).getCloudType() == 3) && (((FileManagerEntity)localObject).getFilePath() != null) && (((FileManagerEntity)localObject).getFilePath().length() > 0)) {
              localArrayList2.add(Uri.parse(((FileManagerEntity)localObject).getFilePath()));
            } else {
              localArrayList2.add(Uri.parse(""));
            }
            l1 += localForwardFileInfo.d();
            localArrayList1.add(localForwardFileInfo);
          }
        }
      }
    }
    paramList = new Bundle();
    Object localObject = new Intent();
    paramList.putInt("forward_type", ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getForwardUtilsForwardTypeFILE());
    paramList.putParcelableArrayList("fileinfo_array", localArrayList1);
    paramList.putBoolean("not_forward", true);
    ((Intent)localObject).putExtra("sendMultiple", true);
    paramList.putParcelableArrayList("android.intent.extra.STREAM", localArrayList2);
    ((Intent)localObject).putExtras(paramList);
    ((Intent)localObject).putExtra("foward_editbar", true);
    ((Intent)localObject).putExtra("forward_type", ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getForwardUtilsForwardTypeFILE());
    paramList = a(2131704660);
    if (localArrayList1.size() == 1)
    {
      paramList = new StringBuilder();
      paramList.append(a(2131704642));
      paramList.append(d(((ForwardFileInfo)localArrayList1.get(0)).d()));
      paramList.append(a(2131704652));
      paramList.append(FileUtil.a(((ForwardFileInfo)localArrayList1.get(0)).d()));
      paramList.append("。");
      paramList = paramList.toString();
    }
    else if (localArrayList1.size() > 1)
    {
      paramList = new StringBuilder();
      paramList.append(a(2131704636));
      paramList.append(d(((ForwardFileInfo)localArrayList1.get(0)).d()));
      paramList.append(a(2131704649));
      paramList.append(localArrayList1.size());
      paramList.append(a(2131704653));
      paramList.append(FileUtil.a(l2));
      paramList.append("。");
      paramList = paramList.toString();
    }
    ((Intent)localObject).putExtra("forward_text", paramList);
    ((Intent)localObject).putExtra("k_favorites", false);
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).startForwardActivityForResult(paramActivity, (Intent)localObject, 103);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    a(paramBoolean, paramContext, paramFMDialogInterface, -1);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetSupportHw(BaseApplication.getContext()))
    {
      a(2131693191);
      return;
    }
    if (!a())
    {
      paramFMDialogInterface.a();
      return;
    }
    boolean bool2 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).isShowByCUKingCardHelper(paramContext, paramBoolean, paramFMDialogInterface);
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).isShowByFreeWifiHelper(paramContext, paramBoolean, paramFMDialogInterface);
    }
    if (bool1)
    {
      int i = 2131692566;
      if ((paramInt == 0) && (KingCardProcessor.c().a.jdField_a_of_type_Boolean) && (!((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).isKingCard()))
      {
        if (!paramBoolean) {
          i = 2131692563;
        }
        String str = paramContext.getString(i);
        FMDialogUtil.a(paramContext, paramContext.getString(2131692561), KingCardProcessor.c().a.a(paramContext, str), paramFMDialogInterface);
        return;
      }
      if (!paramBoolean) {
        i = 2131692563;
      }
      FMDialogUtil.a(paramContext, 2131692561, i, paramFMDialogInterface);
    }
  }
  
  public static boolean a()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == FMConstants.b;
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder;
    switch (paramInt)
    {
    case 8: 
    case 14: 
    default: 
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("unknow errCode:");
        paramString.append(paramInt);
        QLog.e("FileManagerUtil<FileAssistant>", 1, paramString.toString());
      }
      break;
    case 16: 
      a(2131692708);
      return true;
    case 15: 
      a(2131694600);
      return true;
    case 13: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(d(paramString));
      localStringBuilder.append(d(2131692747));
      b(localStringBuilder.toString());
      return true;
    case 12: 
      if (QLog.isDevelopLevel()) {
        a();
      }
      a(2131692744);
      return true;
    case 11: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(d(paramString));
      localStringBuilder.append(d(2131692747));
      b(localStringBuilder.toString());
      return true;
    case 10: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(d(paramString));
      localStringBuilder.append(d(2131692747));
      b(localStringBuilder.toString());
      return true;
    case 9: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(d(paramString));
      localStringBuilder.append(d(2131692747));
      b(localStringBuilder.toString());
      return true;
    case 7: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(d(paramString));
      localStringBuilder.append(d(2131692747));
      b(localStringBuilder.toString());
      return true;
    case 6: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(d(paramString));
      localStringBuilder.append(d(2131692747));
      b(localStringBuilder.toString());
      return true;
    case 5: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(d(paramString));
      localStringBuilder.append(d(2131692747));
      b(localStringBuilder.toString());
      return true;
    case 4: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(d(paramString));
      localStringBuilder.append(d(2131692717));
      b(localStringBuilder.toString());
      return true;
    case 3: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(d(paramString));
      localStringBuilder.append(d(2131692717));
      b(localStringBuilder.toString());
      return true;
    case 2: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(d(paramString));
      localStringBuilder.append(d(2131692747));
      b(localStringBuilder.toString());
      return true;
    case 1: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(d(paramString));
      localStringBuilder.append(d(2131692717));
      b(localStringBuilder.toString());
    case 0: 
      return true;
    }
    return false;
  }
  
  public static boolean a(long paramLong1, long paramLong2, TimeZone paramTimeZone)
  {
    long l = paramLong1 - paramLong2;
    return (l < 86400000L) && (l > -86400000L) && (a(paramLong1, paramTimeZone) == a(paramLong2, paramTimeZone));
  }
  
  public static boolean a(Context paramContext)
  {
    return ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).isImportLocaFilesForH5(paramContext);
  }
  
  public static boolean a(Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    return (a(paramContext)) && ((paramFileManagerEntity.fileSize > b(paramFileManagerEntity.fileName)) || (!a(paramFileManagerEntity.fileName, TencentDocConfig.a().jdField_a_of_type_JavaLangString)) || ((!((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).isSelected(paramFileManagerEntity)) && (((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getRecentFiles().size() != 0)));
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return ShortcutUtils.a(paramContext, new String[] { paramString });
    }
    return a(paramString, (ShortcutManager)paramContext.getSystemService(ShortcutManager.class));
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = FMConfig.a(paramContext, paramString, "FileMaxSize");
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    if (Integer.parseInt(paramContext) * 1048576 >= paramLong) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage != null)
    {
      if (!paramChatMessage.isMultiMsg) {
        return false;
      }
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramChatMessage.senderuin))
      {
        bool1 = bool2;
        if (paramChatMessage.senderuin.equals(paramBaseQQAppInterface.getCurrentAccountUin())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    return a(paramBaseQQAppInterface, paramChatMessage, paramContext, false);
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage, Context paramContext, boolean paramBoolean)
  {
    ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
    if (paramChatMessage == null) {
      return false;
    }
    if (!(paramChatMessage instanceof MessageForFile)) {
      return false;
    }
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = a(paramBaseQQAppInterface, localMessageForFile);
    int i = localFileManagerEntity.getCloudType();
    if (i != 1)
    {
      if (i != 2)
      {
        if ((i != 3) && (i != 5)) {
          return false;
        }
        if (!paramBoolean) {
          FMToastUtil.d(paramContext.getString(2131692690));
        }
        ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).startSave2Weiyun();
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).sendLocalFile(paramBaseQQAppInterface, localFileManagerEntity.getFilePath(), null, paramBaseQQAppInterface.getAccount(), 0, false);
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).updateFileEntity(paramBaseQQAppInterface, localFileManagerEntity);
        if (QLog.isColorLevel())
        {
          paramBaseQQAppInterface = new StringBuilder();
          paramBaseQQAppInterface.append("mEntity[");
          paramBaseQQAppInterface.append(localFileManagerEntity.nSessionId);
          paramBaseQQAppInterface.append("]'s relateId[");
          paramBaseQQAppInterface.append(localFileManagerEntity.nRelatedSessionId);
          paramBaseQQAppInterface.append("] reInit");
          QLog.i("@-@", 1, paramBaseQQAppInterface.toString());
        }
        return true;
      }
      return false;
    }
    if (paramChatMessage.isSend()) {
      paramChatMessage = paramBaseQQAppInterface.getCurrentAccountUin();
    } else {
      paramChatMessage = localMessageForFile.frienduin;
    }
    if (!paramBoolean) {
      FMToastUtil.d(paramContext.getString(2131692690));
    }
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).saveOfflineFile2WeiYun(paramBaseQQAppInterface, localFileManagerEntity, paramChatMessage);
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).updateFileEntity(paramBaseQQAppInterface, localFileManagerEntity);
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("mEntity[");
      paramChatMessage.append(localFileManagerEntity.nSessionId);
      paramChatMessage.append("]'s relateId[");
      paramChatMessage.append(localFileManagerEntity.nRelatedSessionId);
      paramChatMessage.append("] No reInit,Show Juhua");
      QLog.i("@-@", 1, paramChatMessage.toString());
    }
    paramChatMessage = new FileManagerReporter.FileAssistantReportData();
    paramChatMessage.jdField_b_of_type_JavaLangString = "file_to_weiyun";
    paramChatMessage.jdField_a_of_type_Int = 9;
    paramChatMessage.jdField_a_of_type_Long = localFileManagerEntity.fileSize;
    paramChatMessage.jdField_c_of_type_JavaLangString = FileUtil.a(localFileManagerEntity.fileName);
    FileManagerReporter.a(paramBaseQQAppInterface.getCurrentAccountUin(), paramChatMessage);
    return true;
  }
  
  public static boolean a(VFSFile paramVFSFile1, VFSFile paramVFSFile2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("vfs renameFile: src[");
      localStringBuilder.append(paramVFSFile1.getAbsolutePath());
      localStringBuilder.append("] dest[");
      localStringBuilder.append(paramVFSFile2.getAbsolutePath());
      localStringBuilder.append("]");
      QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
    }
    boolean bool1;
    if (paramVFSFile2.exists())
    {
      bool1 = paramVFSFile2.delete();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("vfs rename, delete result[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("]");
      QLog.e("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
    }
    else
    {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      bool2 = paramVFSFile1.renameTo(paramVFSFile2);
      paramVFSFile1 = new StringBuilder();
      paramVFSFile1.append("vfs rename, rename result[");
      paramVFSFile1.append(bool2);
      paramVFSFile1.append("]");
      QLog.e("FileManagerUtil<FileAssistant>", 1, paramVFSFile1.toString());
    }
    return bool2;
  }
  
  private static boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage != null)
    {
      if (!QQFileUtilsImpl.a(paramChatMessage)) {
        return false;
      }
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileStatus");
      if (!TextUtils.isEmpty(paramChatMessage))
      {
        bool1 = bool2;
        if (Integer.parseInt(paramChatMessage) != 1) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(ChatMessage paramChatMessage, BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if (paramChatMessage != null)
    {
      if (!paramChatMessage.isMultiMsg) {
        return false;
      }
      String str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileStatus");
      if ((!TextUtils.isEmpty(str)) && (Integer.parseInt(str) == 4))
      {
        QQToast.a(paramContext, 2131692570, 0).a();
        return false;
      }
      paramChatMessage = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getPrimaryStructMsg(paramBaseQQAppInterface, paramChatMessage);
      if ((paramChatMessage != null) && (paramChatMessage.extraflag == 32768))
      {
        QQToast.a(paramContext, 2131692569, 0).a();
        return false;
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = false;
    if (paramFileManagerEntity == null) {
      return false;
    }
    long l3 = paramFileManagerEntity.srvTime;
    int i = paramFileManagerEntity.peerType;
    long l2 = 604800000L;
    long l1 = l2;
    if (i != 0) {
      if (i != 3000) {
        l1 = l2;
      } else {
        l1 = 2592000000L;
      }
    }
    if (l3 + l1 <= MessageCache.a() * 1000L) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("normal renameFile: src[");
      localStringBuilder.append(paramFile1.getAbsolutePath());
      localStringBuilder.append("] dest[");
      localStringBuilder.append(paramFile2.getAbsolutePath());
      localStringBuilder.append("]");
      QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
    }
    for (;;)
    {
      boolean bool2;
      try
      {
        if (!paramFile2.exists()) {
          break label227;
        }
        bool1 = paramFile2.delete();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("normal rename, delete result[");
        localStringBuilder.append(bool1);
        localStringBuilder.append("]");
        QLog.e("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
        bool2 = bool1;
        if (bool1)
        {
          bool1 = paramFile1.renameTo(paramFile2);
          paramFile1 = new StringBuilder();
          paramFile1.append("normal rename, rename result[");
          paramFile1.append(bool1);
          paramFile1.append("]");
          QLog.e("FileManagerUtil<FileAssistant>", 1, paramFile1.toString());
          return bool1;
        }
      }
      catch (Exception paramFile1)
      {
        paramFile2 = new StringBuilder();
        paramFile2.append("normal rename exception: ");
        paramFile2.append(paramFile1.getMessage());
        QLog.e("FileManagerUtil<FileAssistant>", 1, paramFile2.toString());
        bool2 = false;
      }
      return bool2;
      label227:
      boolean bool1 = true;
    }
  }
  
  public static boolean a(String paramString)
  {
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).isContainChinese(paramString);
  }
  
  @RequiresApi(api=25)
  public static boolean a(String paramString, ShortcutManager paramShortcutManager)
  {
    boolean bool2 = false;
    if (paramShortcutManager == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramShortcutManager = paramShortcutManager.getPinnedShortcuts().iterator();
      do
      {
        bool1 = bool2;
        if (!paramShortcutManager.hasNext()) {
          break;
        }
      } while (!paramString.equals(((ShortcutInfo)paramShortcutManager.next()).getShortLabel()));
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (paramString2 != null)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      paramString1 = QQFileUtil.a(paramString1);
      bool1 = bool2;
      if (paramString1 != null)
      {
        if (paramString1.length() == 0) {
          return false;
        }
        bool1 = bool2;
        if (paramString2.indexOf(paramString1.toLowerCase()) >= 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(boolean paramBoolean, ArrayList<FileManagerEntity> paramArrayList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return false;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (QQFileModel.a((FileManagerEntity)paramArrayList.next()).a(paramBoolean)) {
          return true;
        }
      }
      bool1 = bool2;
      if (0L > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static byte[] a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt)
  {
    paramBaseQQAppInterface = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getMsgCache(paramBaseQQAppInterface);
    if (paramInt != 100)
    {
      if (paramInt != 102)
      {
        if (paramInt != 109)
        {
          if (paramInt != 124)
          {
            if (paramInt != 127) {
              return null;
            }
            return paramBaseQQAppInterface.j(paramString);
          }
          return paramBaseQQAppInterface.d(paramString);
        }
        return paramBaseQQAppInterface.p(paramString);
      }
      return null;
    }
    return paramBaseQQAppInterface.m(paramString);
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 2805	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl:a	(Ljava/lang/String;)J
    //   4: lstore 12
    //   6: lload 12
    //   8: ldc2_w 2806
    //   11: lcmp
    //   12: ifge +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: lload 12
    //   19: ldc2_w 2808
    //   22: ldiv
    //   23: ldc2_w 1052
    //   26: lsub
    //   27: lstore 10
    //   29: lload 12
    //   31: ldc2_w 2808
    //   34: ldiv
    //   35: ldc2_w 1052
    //   38: ladd
    //   39: lconst_1
    //   40: lsub
    //   41: lstore 14
    //   43: lload 12
    //   45: ldc2_w 1056
    //   48: lsub
    //   49: lstore 4
    //   51: ldc_w 2811
    //   54: invokestatic 2816	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   57: astore 17
    //   59: new 2818	java/io/BufferedInputStream
    //   62: dup
    //   63: new 2820	java/io/FileInputStream
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 2821	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   71: invokespecial 2824	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   74: astore 16
    //   76: iconst_0
    //   77: istore_1
    //   78: lconst_0
    //   79: lstore 6
    //   81: ldc2_w 2825
    //   84: lload 6
    //   86: lsub
    //   87: lconst_1
    //   88: ladd
    //   89: ldc2_w 2827
    //   92: invokestatic 2832	java/lang/Math:min	(JJ)J
    //   95: l2i
    //   96: newarray byte
    //   98: astore_0
    //   99: aload 16
    //   101: aload_0
    //   102: invokevirtual 2838	java/io/InputStream:read	([B)I
    //   105: istore_2
    //   106: aload 17
    //   108: aload_0
    //   109: iconst_0
    //   110: iload_2
    //   111: invokevirtual 2842	java/security/MessageDigest:update	([BII)V
    //   114: lload 6
    //   116: iload_2
    //   117: i2l
    //   118: ladd
    //   119: lstore 6
    //   121: iload_1
    //   122: iload_2
    //   123: iadd
    //   124: istore_1
    //   125: lload 6
    //   127: ldc2_w 1056
    //   130: lcmp
    //   131: iflt +256 -> 387
    //   134: aload 16
    //   136: lload 10
    //   138: ldc2_w 2825
    //   141: lsub
    //   142: lconst_1
    //   143: lsub
    //   144: invokevirtual 2845	java/io/InputStream:skip	(J)J
    //   147: pop2
    //   148: lconst_0
    //   149: lstore 8
    //   151: lload 10
    //   153: lstore 6
    //   155: lload 14
    //   157: lload 6
    //   159: lsub
    //   160: lstore 10
    //   162: lload 10
    //   164: lload 8
    //   166: lsub
    //   167: lconst_1
    //   168: ladd
    //   169: ldc2_w 2827
    //   172: invokestatic 2832	java/lang/Math:min	(JJ)J
    //   175: l2i
    //   176: newarray byte
    //   178: astore_0
    //   179: aload 16
    //   181: aload_0
    //   182: invokevirtual 2838	java/io/InputStream:read	([B)I
    //   185: istore_2
    //   186: aload 17
    //   188: aload_0
    //   189: iconst_0
    //   190: iload_2
    //   191: invokevirtual 2842	java/security/MessageDigest:update	([BII)V
    //   194: lload 8
    //   196: iload_2
    //   197: i2l
    //   198: ladd
    //   199: lstore 8
    //   201: iload_1
    //   202: iload_2
    //   203: iadd
    //   204: istore_1
    //   205: lload 8
    //   207: lload 10
    //   209: lconst_1
    //   210: ladd
    //   211: lcmp
    //   212: iflt +172 -> 384
    //   215: aload 16
    //   217: lload 4
    //   219: lload 14
    //   221: lsub
    //   222: lconst_1
    //   223: lsub
    //   224: invokevirtual 2845	java/io/InputStream:skip	(J)J
    //   227: pop2
    //   228: lconst_0
    //   229: lstore 6
    //   231: lload 12
    //   233: lconst_1
    //   234: lsub
    //   235: lload 4
    //   237: lsub
    //   238: lstore 10
    //   240: lload 10
    //   242: lload 6
    //   244: lsub
    //   245: lconst_1
    //   246: ladd
    //   247: ldc2_w 2827
    //   250: invokestatic 2832	java/lang/Math:min	(JJ)J
    //   253: l2i
    //   254: newarray byte
    //   256: astore_0
    //   257: aload 16
    //   259: aload_0
    //   260: invokevirtual 2838	java/io/InputStream:read	([B)I
    //   263: istore_2
    //   264: iload_2
    //   265: ifgt +6 -> 271
    //   268: goto +208 -> 476
    //   271: aload 17
    //   273: aload_0
    //   274: iconst_0
    //   275: iload_2
    //   276: invokevirtual 2842	java/security/MessageDigest:update	([BII)V
    //   279: lload 6
    //   281: iload_2
    //   282: i2l
    //   283: ladd
    //   284: lstore 8
    //   286: iload_1
    //   287: iload_2
    //   288: iadd
    //   289: istore_2
    //   290: iload_2
    //   291: istore_1
    //   292: lload 8
    //   294: lstore 6
    //   296: lload 8
    //   298: lload 10
    //   300: lconst_1
    //   301: ladd
    //   302: lcmp
    //   303: iflt -72 -> 231
    //   306: iload_2
    //   307: istore_1
    //   308: goto +168 -> 476
    //   311: bipush 8
    //   313: newarray byte
    //   315: astore_0
    //   316: iconst_0
    //   317: istore_2
    //   318: goto +161 -> 479
    //   321: aload 17
    //   323: aload_0
    //   324: iconst_0
    //   325: bipush 8
    //   327: invokevirtual 2842	java/security/MessageDigest:update	([BII)V
    //   330: new 252	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   337: astore_0
    //   338: aload_0
    //   339: ldc_w 2847
    //   342: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload_0
    //   347: iload_1
    //   348: invokevirtual 657	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: ldc 234
    //   354: iconst_1
    //   355: aload_0
    //   356: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 749	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: aload 17
    //   364: invokevirtual 2850	java/security/MessageDigest:digest	()[B
    //   367: astore_0
    //   368: aload 16
    //   370: invokevirtual 2851	java/io/InputStream:close	()V
    //   373: aload_0
    //   374: areturn
    //   375: astore 16
    //   377: aload 16
    //   379: invokevirtual 902	java/io/IOException:printStackTrace	()V
    //   382: aload_0
    //   383: areturn
    //   384: goto -229 -> 155
    //   387: goto -306 -> 81
    //   390: astore_0
    //   391: goto +57 -> 448
    //   394: astore 17
    //   396: aload 16
    //   398: astore_0
    //   399: aload 17
    //   401: astore 16
    //   403: goto +14 -> 417
    //   406: astore_0
    //   407: aconst_null
    //   408: astore 16
    //   410: goto +38 -> 448
    //   413: astore 16
    //   415: aconst_null
    //   416: astore_0
    //   417: aload 16
    //   419: invokevirtual 179	java/lang/Exception:printStackTrace	()V
    //   422: aload_0
    //   423: ifnull +15 -> 438
    //   426: aload_0
    //   427: invokevirtual 2851	java/io/InputStream:close	()V
    //   430: goto +8 -> 438
    //   433: astore_0
    //   434: aload_0
    //   435: invokevirtual 902	java/io/IOException:printStackTrace	()V
    //   438: aconst_null
    //   439: areturn
    //   440: astore 17
    //   442: aload_0
    //   443: astore 16
    //   445: aload 17
    //   447: astore_0
    //   448: aload 16
    //   450: ifnull +18 -> 468
    //   453: aload 16
    //   455: invokevirtual 2851	java/io/InputStream:close	()V
    //   458: goto +10 -> 468
    //   461: astore 16
    //   463: aload 16
    //   465: invokevirtual 902	java/io/IOException:printStackTrace	()V
    //   468: goto +5 -> 473
    //   471: aload_0
    //   472: athrow
    //   473: goto -2 -> 471
    //   476: goto -165 -> 311
    //   479: iload_2
    //   480: bipush 8
    //   482: if_icmpge -161 -> 321
    //   485: iload_2
    //   486: iconst_1
    //   487: iadd
    //   488: istore_3
    //   489: aload_0
    //   490: bipush 8
    //   492: iload_2
    //   493: isub
    //   494: iconst_1
    //   495: isub
    //   496: lload 12
    //   498: bipush 64
    //   500: iload_3
    //   501: bipush 8
    //   503: imul
    //   504: isub
    //   505: lshr
    //   506: ldc2_w 2852
    //   509: land
    //   510: l2i
    //   511: i2b
    //   512: bastore
    //   513: iload_3
    //   514: istore_2
    //   515: goto -36 -> 479
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	518	0	paramString	String
    //   77	271	1	i	int
    //   105	410	2	j	int
    //   488	26	3	k	int
    //   49	187	4	l1	long
    //   79	216	6	l2	long
    //   149	148	8	l3	long
    //   27	272	10	l4	long
    //   4	493	12	l5	long
    //   41	179	14	l6	long
    //   74	295	16	localBufferedInputStream	java.io.BufferedInputStream
    //   375	22	16	localIOException1	IOException
    //   401	8	16	localException1	Exception
    //   413	5	16	localException2	Exception
    //   443	11	16	str	String
    //   461	3	16	localIOException2	IOException
    //   57	306	17	localMessageDigest	java.security.MessageDigest
    //   394	6	17	localException3	Exception
    //   440	6	17	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   368	373	375	java/io/IOException
    //   81	114	390	finally
    //   134	148	390	finally
    //   162	194	390	finally
    //   215	228	390	finally
    //   240	264	390	finally
    //   271	279	390	finally
    //   311	316	390	finally
    //   321	368	390	finally
    //   81	114	394	java/lang/Exception
    //   134	148	394	java/lang/Exception
    //   162	194	394	java/lang/Exception
    //   215	228	394	java/lang/Exception
    //   240	264	394	java/lang/Exception
    //   271	279	394	java/lang/Exception
    //   311	316	394	java/lang/Exception
    //   321	368	394	java/lang/Exception
    //   17	43	406	finally
    //   51	76	406	finally
    //   17	43	413	java/lang/Exception
    //   51	76	413	java/lang/Exception
    //   426	430	433	java/io/IOException
    //   417	422	440	finally
    //   453	458	461	java/io/IOException
  }
  
  /* Error */
  public static byte[] a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: new 2820	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 2821	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: lload_1
    //   11: ldc2_w 2855
    //   14: lcmp
    //   15: ifge +6 -> 21
    //   18: goto +7 -> 25
    //   21: ldc2_w 2855
    //   24: lstore_1
    //   25: aload 4
    //   27: astore_3
    //   28: aload_0
    //   29: lload_1
    //   30: invokestatic 2861	com/tencent/qphone/base/util/MD5:getPartfileMd5	(Ljava/lang/String;J)[B
    //   33: astore_0
    //   34: aload 4
    //   36: invokevirtual 2862	java/io/FileInputStream:close	()V
    //   39: aload_0
    //   40: areturn
    //   41: astore_3
    //   42: aload_3
    //   43: invokevirtual 902	java/io/IOException:printStackTrace	()V
    //   46: new 252	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   53: astore 4
    //   55: aload 4
    //   57: ldc_w 2864
    //   60: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 4
    //   66: aload_3
    //   67: invokevirtual 2865	java/io/IOException:toString	()Ljava/lang/String;
    //   70: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: ldc 234
    //   76: iconst_1
    //   77: aload 4
    //   79: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aload_0
    //   86: areturn
    //   87: astore_3
    //   88: aload 4
    //   90: astore_0
    //   91: aload_3
    //   92: astore 4
    //   94: goto +13 -> 107
    //   97: astore_0
    //   98: aconst_null
    //   99: astore_3
    //   100: goto +108 -> 208
    //   103: astore 4
    //   105: aconst_null
    //   106: astore_0
    //   107: aload_0
    //   108: astore_3
    //   109: new 252	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   116: astore 5
    //   118: aload_0
    //   119: astore_3
    //   120: aload 5
    //   122: ldc_w 2867
    //   125: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_0
    //   130: astore_3
    //   131: aload 5
    //   133: aload 4
    //   135: invokevirtual 2865	java/io/IOException:toString	()Ljava/lang/String;
    //   138: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_0
    //   143: astore_3
    //   144: ldc 234
    //   146: iconst_1
    //   147: aload 5
    //   149: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_0
    //   156: ifnull +49 -> 205
    //   159: aload_0
    //   160: invokevirtual 2862	java/io/FileInputStream:close	()V
    //   163: aconst_null
    //   164: areturn
    //   165: astore_0
    //   166: aload_0
    //   167: invokevirtual 902	java/io/IOException:printStackTrace	()V
    //   170: new 252	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   177: astore_3
    //   178: aload_3
    //   179: ldc_w 2864
    //   182: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload_3
    //   187: aload_0
    //   188: invokevirtual 2865	java/io/IOException:toString	()Ljava/lang/String;
    //   191: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: ldc 234
    //   197: iconst_1
    //   198: aload_3
    //   199: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aconst_null
    //   206: areturn
    //   207: astore_0
    //   208: aload_3
    //   209: ifnull +54 -> 263
    //   212: aload_3
    //   213: invokevirtual 2862	java/io/FileInputStream:close	()V
    //   216: goto +47 -> 263
    //   219: astore_3
    //   220: aload_3
    //   221: invokevirtual 902	java/io/IOException:printStackTrace	()V
    //   224: new 252	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   231: astore 4
    //   233: aload 4
    //   235: ldc_w 2864
    //   238: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 4
    //   244: aload_3
    //   245: invokevirtual 2865	java/io/IOException:toString	()Ljava/lang/String;
    //   248: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: ldc 234
    //   254: iconst_1
    //   255: aload 4
    //   257: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: aload_0
    //   264: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramString	String
    //   0	265	1	paramLong	long
    //   27	1	3	localObject1	Object
    //   41	26	3	localIOException1	IOException
    //   87	5	3	localIOException2	IOException
    //   99	114	3	localObject2	Object
    //   219	26	3	localIOException3	IOException
    //   8	85	4	localObject3	Object
    //   103	31	4	localIOException4	IOException
    //   231	25	4	localStringBuilder1	StringBuilder
    //   116	32	5	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   34	39	41	java/io/IOException
    //   28	34	87	java/io/IOException
    //   0	10	97	finally
    //   0	10	103	java/io/IOException
    //   159	163	165	java/io/IOException
    //   28	34	207	finally
    //   109	118	207	finally
    //   120	129	207	finally
    //   131	142	207	finally
    //   144	155	207	finally
    //   212	216	219	java/io/IOException
  }
  
  /* Error */
  private static byte[] a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 2818	java/io/BufferedInputStream
    //   3: dup
    //   4: new 2820	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 2821	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 2824	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_0
    //   16: sipush 10240
    //   19: newarray byte
    //   21: astore_3
    //   22: aload_1
    //   23: invokestatic 2816	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   26: astore_1
    //   27: goto +10 -> 37
    //   30: astore_1
    //   31: aload_1
    //   32: invokevirtual 2871	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   35: aconst_null
    //   36: astore_1
    //   37: aload_0
    //   38: aload_3
    //   39: invokevirtual 2838	java/io/InputStream:read	([B)I
    //   42: istore_2
    //   43: iload_2
    //   44: ifle +13 -> 57
    //   47: aload_1
    //   48: aload_3
    //   49: iconst_0
    //   50: iload_2
    //   51: invokevirtual 2842	java/security/MessageDigest:update	([BII)V
    //   54: goto -17 -> 37
    //   57: aload_0
    //   58: invokevirtual 2851	java/io/InputStream:close	()V
    //   61: aload_1
    //   62: ifnull +14 -> 76
    //   65: aload_1
    //   66: invokevirtual 2850	java/security/MessageDigest:digest	()[B
    //   69: astore_1
    //   70: aload_0
    //   71: invokevirtual 2851	java/io/InputStream:close	()V
    //   74: aload_1
    //   75: areturn
    //   76: aload_0
    //   77: invokevirtual 2851	java/io/InputStream:close	()V
    //   80: aconst_null
    //   81: areturn
    //   82: astore_3
    //   83: aload_0
    //   84: astore_1
    //   85: aload_3
    //   86: astore_0
    //   87: goto +6 -> 93
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 2851	java/io/InputStream:close	()V
    //   101: aload_0
    //   102: athrow
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: ifnull +18 -> 124
    //   109: aload_0
    //   110: invokevirtual 2851	java/io/InputStream:close	()V
    //   113: aconst_null
    //   114: areturn
    //   115: aconst_null
    //   116: astore_0
    //   117: aload_0
    //   118: ifnull +6 -> 124
    //   121: goto -12 -> 109
    //   124: aconst_null
    //   125: areturn
    //   126: astore_0
    //   127: goto -12 -> 115
    //   130: astore_0
    //   131: goto -28 -> 103
    //   134: astore_1
    //   135: goto -18 -> 117
    //   138: astore_1
    //   139: goto -34 -> 105
    //   142: astore_3
    //   143: goto -82 -> 61
    //   146: astore_0
    //   147: aload_1
    //   148: areturn
    //   149: astore_0
    //   150: aconst_null
    //   151: areturn
    //   152: astore_1
    //   153: goto -52 -> 101
    //   156: astore_0
    //   157: aconst_null
    //   158: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramString1	String
    //   0	159	1	paramString2	String
    //   42	9	2	i	int
    //   21	28	3	arrayOfByte	byte[]
    //   82	4	3	localObject	Object
    //   142	1	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   22	27	30	java/security/NoSuchAlgorithmException
    //   16	22	82	finally
    //   22	27	82	finally
    //   31	35	82	finally
    //   37	43	82	finally
    //   47	54	82	finally
    //   57	61	82	finally
    //   65	70	82	finally
    //   0	16	90	finally
    //   0	16	126	java/io/FileNotFoundException
    //   0	16	130	java/io/IOException
    //   16	22	134	java/io/FileNotFoundException
    //   22	27	134	java/io/FileNotFoundException
    //   31	35	134	java/io/FileNotFoundException
    //   37	43	134	java/io/FileNotFoundException
    //   47	54	134	java/io/FileNotFoundException
    //   57	61	134	java/io/FileNotFoundException
    //   65	70	134	java/io/FileNotFoundException
    //   16	22	138	java/io/IOException
    //   22	27	138	java/io/IOException
    //   31	35	138	java/io/IOException
    //   37	43	138	java/io/IOException
    //   47	54	138	java/io/IOException
    //   65	70	138	java/io/IOException
    //   57	61	142	java/io/IOException
    //   70	74	146	java/io/IOException
    //   76	80	149	java/io/IOException
    //   97	101	152	java/io/IOException
    //   109	113	156	java/io/IOException
  }
  
  public static int[] a(String paramString)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
      return new int[] { 0, 0 };
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, localOptions);
    int i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExifRotation(paramString);
    int j;
    if ((i != 90) && (i != 270))
    {
      j = localOptions.outWidth;
      i = localOptions.outHeight;
    }
    else
    {
      i = localOptions.outWidth;
      j = localOptions.outHeight;
    }
    return new int[] { j, i };
  }
  
  public static int b(int paramInt)
  {
    int j = 0;
    int i;
    if (paramInt != -1)
    {
      i = j;
      if (paramInt == 0) {
        return i;
      }
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3)
          {
            if (paramInt == 2008) {
              break label133;
            }
            if (paramInt != 4001) {
              i = j;
            }
          }
        }
      }
    }
    switch (paramInt)
    {
    default: 
      i = j;
      switch (paramInt)
      {
      }
      break;
    case 1004: 
      return 3;
    case 1001: 
    case 1002: 
      return 2;
    case 1003: 
      return 1;
    case 1000: 
      label133:
      i = -1;
    }
    return i;
  }
  
  public static int b(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = paramFileManagerEntity.fileName.toUpperCase();
    if (paramFileManagerEntity.endsWith(".ZIP")) {
      return 13;
    }
    if (paramFileManagerEntity.endsWith(".RAR")) {
      return 14;
    }
    if (paramFileManagerEntity.endsWith(".7Z")) {
      return 15;
    }
    return -1;
  }
  
  public static int b(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    Object localObject = FileUtil.b(paramString);
    if (b().equalsIgnoreCase((String)localObject)) {
      return 0;
    }
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).edit();
      ((SharedPreferences.Editor)localObject).remove(paramString);
      ((SharedPreferences.Editor)localObject).commit();
      return 0;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -2;
  }
  
  public static long b()
  {
    return MessageUtils.a(MessageUtils.a());
  }
  
  public static long b(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          return 0L;
        }
        paramString = g(paramString);
        if (TextUtils.isEmpty(paramString)) {
          return 0L;
        }
        l = 20971520L;
        if ("txt".equals(paramString.toLowerCase())) {
          l = 102400L;
        }
        localObject = TencentDocImportFileInfoProcessor.a().b();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return l;
        }
        localObject = ((String)localObject).split("#");
        if (localObject.length != 0) {
          break label181;
        }
        return l;
      }
      catch (Exception paramString)
      {
        long l;
        String[] arrayOfString;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" get docs import file max size exception =");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.e("FileManagerUtil<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        return 0L;
      }
      if (i < localObject.length)
      {
        arrayOfString = localObject[i].split("_");
        if (!arrayOfString[0].contains(paramString)) {
          if (!arrayOfString[0].contains(paramString.toLowerCase())) {
            break label186;
          }
        }
        l = Long.parseLong(arrayOfString[1]);
        return l;
      }
      else
      {
        return 0L;
        label181:
        i = 0;
        continue;
      }
      label186:
      i += 1;
    }
  }
  
  private static long b(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, BaseQQAppInterface paramBaseQQAppInterface, int paramInt4)
  {
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).prepareForwardByDataLineMsgRecord(paramString1, paramInt1, paramString2, paramInt2, paramString3, paramString4, paramString5, paramLong, paramInt3, paramBaseQQAppInterface, paramInt4);
  }
  
  private static Bitmap b(Matrix paramMatrix, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int j = paramBitmap.getWidth() - paramInt1;
    int i = paramBitmap.getHeight() - paramInt2;
    if ((j >= 0) && (i >= 0))
    {
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = f1 / f2;
      float f4 = paramInt1;
      float f5 = paramInt2;
      if (f3 > f4 / f5)
      {
        f1 = f5 / f2;
        if ((f1 >= 0.9F) && (f1 <= 1.0F)) {
          paramMatrix = null;
        } else {
          paramMatrix.setScale(f1, f1);
        }
      }
      else
      {
        f1 = f4 / f1;
        if ((f1 >= 0.9F) && (f1 <= 1.0F)) {
          paramMatrix = null;
        } else {
          paramMatrix.setScale(f1, f1);
        }
      }
      if (paramMatrix == null) {}
    }
    try
    {
      paramMatrix = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true);
    }
    catch (OutOfMemoryError paramMatrix)
    {
      label174:
      break label174;
    }
    QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
    return null;
    paramMatrix = paramBitmap;
    if (paramMatrix != paramBitmap) {
      paramBitmap.recycle();
    }
    i = Math.max(0, paramMatrix.getWidth() - paramInt1);
    j = Math.max(0, paramMatrix.getHeight() - paramInt2);
    try
    {
      localObject = Bitmap.createBitmap(paramMatrix, i / 2, j / 2, paramInt1, paramInt2);
      if ((localObject != paramMatrix) && (paramMatrix != paramBitmap)) {
        paramMatrix.recycle();
      }
      return localObject;
    }
    catch (OutOfMemoryError paramMatrix)
    {
      Object localObject;
      label254:
      break label254;
    }
    QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
    return null;
    try
    {
      paramMatrix = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(paramMatrix);
      j = Math.max(0, j / 2);
      i = Math.max(0, i / 2);
      Rect localRect = new Rect(j, i, Math.min(paramInt1, paramBitmap.getWidth()) + j, Math.min(paramInt2, paramBitmap.getHeight()) + i);
      i = (paramInt1 - localRect.width()) / 2;
      j = (paramInt2 - localRect.height()) / 2;
      ((Canvas)localObject).drawBitmap(paramBitmap, localRect, new Rect(i, j, paramInt1 - i, paramInt2 - j), null);
      return paramMatrix;
    }
    catch (OutOfMemoryError paramMatrix)
    {
      label391:
      break label391;
    }
    QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
    return null;
  }
  
  public static String b()
  {
    return FMSettings.a().getDefaultRecvPath();
  }
  
  public static String b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            if (paramInt != 5)
            {
              if ((paramInt != 6) && (paramInt != 7) && (paramInt != 9)) {
                return a(2131704635);
              }
            }
            else {
              return a(2131704658);
            }
          }
          return a(2131704638);
        }
        return a(2131704651);
      }
      return a(2131704629);
    }
    return a(2131704645);
  }
  
  public static String b(FileManagerEntity paramFileManagerEntity)
  {
    if (!ZhuoXusManager.a().i())
    {
      paramFileManagerEntity.strQRUrl = "";
      return "";
    }
    Object localObject1;
    if (!TextUtils.isEmpty(paramFileManagerEntity.strQRUrl))
    {
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getImageUrl:");
        ((StringBuilder)localObject1).append(paramFileManagerEntity.strQRUrl);
        QLog.i("IMG_FILE_QR", 1, ((StringBuilder)localObject1).toString());
      }
      return paramFileManagerEntity.strQRUrl;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath))
    {
      localObject2 = new File(paramFileManagerEntity.strMiddleThumPath);
      localObject1 = "mid";
    }
    else
    {
      if (!FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath)) {
        break label234;
      }
      localObject2 = new File(paramFileManagerEntity.strLargeThumPath);
      localObject1 = "larg";
    }
    Object localObject2 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getQRCodeResult(BaseApplication.getContext(), (File)localObject2);
    if (localObject2 != null)
    {
      paramFileManagerEntity.strQRUrl = ((StringBuilder)((Pair)localObject2).first).toString();
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getImageUrl success:");
        ((StringBuilder)localObject2).append(paramFileManagerEntity.strQRUrl);
        ((StringBuilder)localObject2).append(" use:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("IMG_FILE_QR", 1, ((StringBuilder)localObject2).toString());
      }
      return paramFileManagerEntity.strQRUrl;
    }
    return "";
    label234:
    return null;
  }
  
  private static String b(FileManagerEntity paramFileManagerEntity, Context paramContext, String paramString, BaseQQAppInterface paramBaseQQAppInterface)
  {
    paramString = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getNickByDiscussionManager(paramBaseQQAppInterface, paramFileManagerEntity.peerUin);
    if (paramFileManagerEntity.bSend)
    {
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append(paramContext.getString(2131692271));
      paramFileManagerEntity.append(paramString);
      return paramFileManagerEntity.toString();
    }
    paramFileManagerEntity = new StringBuilder();
    paramFileManagerEntity.append(paramContext.getString(2131692269));
    paramFileManagerEntity.append(paramString);
    return paramFileManagerEntity.toString();
  }
  
  public static String b(String paramString)
  {
    return FileUtils.getFileName(paramString);
  }
  
  public static void b()
  {
    BaseQQAppInterface localBaseQQAppInterface = a();
    Object localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).queryMaxRecentReocrds(localBaseQQAppInterface);
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localFileManagerEntity.Uuid))
      {
        localFileManagerEntity.status = 16;
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteOfflineFile(localBaseQQAppInterface, localFileManagerEntity.peerUin, localFileManagerEntity.fileName, localFileManagerEntity.Uuid, localFileManagerEntity.fileIdCrc, localFileManagerEntity.bSend);
      }
    }
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).clearAllData(localBaseQQAppInterface);
  }
  
  private static void b(int paramInt, String paramString, BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.nOpType == 4)
    {
      if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(paramInt))
      {
        if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).needShowGrayTips())
        {
          ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).showGrayTips(paramBaseQQAppInterface);
          return;
        }
        b(paramInt, paramString, paramFileManagerEntity);
      }
    }
    else {
      b(paramInt, paramString, paramFileManagerEntity);
    }
  }
  
  private static void b(int paramInt, String paramString, FileManagerEntity paramFileManagerEntity)
  {
    if (a(paramInt, paramFileManagerEntity.fileName)) {
      return;
    }
    if ((paramString != null) && (paramString.length() > 0))
    {
      a(paramString);
      return;
    }
    paramString = new StringBuilder();
    paramString.append(d(paramFileManagerEntity.fileName));
    paramString.append(d(2131692689));
    a(paramString.toString());
  }
  
  public static void b(long paramLong)
  {
    try
    {
      Object localObject1 = jdField_a_of_type_JavaUtilArrayList;
      if (localObject1 == null) {
        return;
      }
      jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramLong));
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("nSessionID[");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append("]移除不显示取消按钮队列");
        QLog.e("##########", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    finally {}
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (!FileUtil.b(paramString))
    {
      a(2131693702);
      return;
    }
    String str = MimeTypesTools.getMimeType(paramContext, paramString);
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    FileProvider7Helper.setIntentDataAndType(paramContext, localIntent, str, new File(paramString));
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
    paramString = paramContext.getPackageManager().queryIntentActivities(localIntent, 65536);
    int j = paramString.size();
    int i = 1;
    if ((j != 1) || (!((ResolveInfo)paramString.get(0)).activityInfo.name.equals("com.tencent.mobileqq.activity.JumpActivity"))) {
      i = 0;
    }
    if ((paramString.size() > 0) && (i == 0)) {}
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      label153:
      break label153;
    }
    QQFMToastUtil.a(2131693702);
    return;
    QQFMToastUtil.a(2131693702);
  }
  
  private static void b(Context paramContext, String paramString, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("_filename_from_dlg", paramContext.getString(2131694576));
    localBundle.putString("big_brother_source_key", "biz_src_jc_file");
    localBundle.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
    localBundle.putBundle("_user_data", paramBundle);
    a().startDownloadNoSzie(paramString, localBundle);
    paramContext = new StringBuilder();
    paramContext.append("downloadQQBrowser:");
    paramContext.append(paramString);
    QLog.i("FileManagerUtil<FileAssistant>", 1, paramContext.toString());
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      ShortcutManager localShortcutManager = (ShortcutManager)paramContext.getSystemService(ShortcutManager.class);
      if (localShortcutManager != null)
      {
        if (a(paramString2, localShortcutManager)) {
          return;
        }
        if (localShortcutManager.isRequestPinShortcutSupported())
        {
          Intent localIntent = new Intent("android.intent.action.MAIN");
          localIntent.addCategory("android.intent.category.LAUNCHER");
          localIntent.putExtra(paramString1, true);
          localIntent.setClassName(paramContext, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getJumpActivityName());
          localIntent.setFlags(337641472);
          if ((!TextUtils.isEmpty(paramString2)) && (paramString2.equals(paramContext.getString(2131694380)))) {
            paramString1 = "my-dataline-shortcut";
          } else {
            paramString1 = "my-shortcut";
          }
          localShortcutManager.requestPinShortcut(new ShortcutInfo.Builder(paramContext, paramString1).setShortLabel(paramString2).setIcon(Icon.createWithResource(paramContext, paramInt)).setIntent(localIntent).build(), PendingIntent.getBroadcast(paramContext, 0, new Intent("com.tencent.fileassistant.createshrotcut"), 134217728).getIntentSender());
        }
      }
    }
  }
  
  public static void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FileManagerUtil<FileAssistant>", 1, "entity null!");
      return;
    }
    String str;
    if (!paramFileManagerEntity.isCheckPrivateDir)
    {
      paramFileManagerEntity.isCheckPrivateDir = true;
      str = paramFileManagerEntity.getFilePath();
      if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
        paramFileManagerEntity.setFilePath(VFSAssistantUtils.getSDKPrivatePath(paramFileManagerEntity.getFilePath()));
      }
      str = paramFileManagerEntity.strThumbPath;
      if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
        paramFileManagerEntity.strThumbPath = VFSAssistantUtils.getSDKPrivatePath(paramFileManagerEntity.strThumbPath);
      }
      str = paramFileManagerEntity.strMiddleThumPath;
      if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
        paramFileManagerEntity.strMiddleThumPath = VFSAssistantUtils.getSDKPrivatePath(paramFileManagerEntity.strMiddleThumPath);
      }
      str = paramFileManagerEntity.strLargeThumPath;
      if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
        paramFileManagerEntity.strLargeThumPath = VFSAssistantUtils.getSDKPrivatePath(paramFileManagerEntity.strLargeThumPath);
      }
    }
    if ((paramFileManagerEntity.nFileType == -1) || (paramFileManagerEntity.nFileType == 5))
    {
      str = paramFileManagerEntity.getFilePath();
      if (str != null)
      {
        paramFileManagerEntity.nFileType = d(str);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(AppConstants.SDCARD_PATH);
        localStringBuilder.append("/Android/data/com.tencent.mobileqq");
        if (str.startsWith(localStringBuilder.toString())) {
          paramFileManagerEntity.setFilePath(VFSAssistantUtils.getSDKPrivatePath(paramFileManagerEntity.getFilePath()));
        }
      }
      else
      {
        if ((paramFileManagerEntity.getCloudType() != 3) && (paramFileManagerEntity.getCloudType() != 5))
        {
          if ((paramFileManagerEntity.strSrcName != null) && (paramFileManagerEntity.strSrcName.length() > 0))
          {
            paramFileManagerEntity.nFileType = d(paramFileManagerEntity.strSrcName);
            return;
          }
          paramFileManagerEntity.nFileType = d(paramFileManagerEntity.fileName);
          return;
        }
        paramFileManagerEntity.nFileType = d(paramFileManagerEntity.fileName);
      }
    }
  }
  
  private static void b(FileManagerEntity paramFileManagerEntity, QQFileManagerUtil.CheckResult paramCheckResult, BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("CHECK_FILE_EXISTED", 1, "checkFileExisted: entity is null");
      if (paramCheckResult != null) {
        paramCheckResult.a(false);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkFile 10md5[");
      localStringBuilder.append(paramFileManagerEntity.str10Md5);
      localStringBuilder.append("], sha3[");
      localStringBuilder.append(paramFileManagerEntity.strFileSha3);
      localStringBuilder.append("], md5[");
      localStringBuilder.append(paramFileManagerEntity.strFileMd5);
      localStringBuilder.append("]");
      QLog.i("CHECK_FILE_EXISTED", 1, localStringBuilder.toString());
    }
    if ((paramFileManagerEntity.nFileType == 0) || (paramFileManagerEntity.nFileType == 2)) {
      new Handler(Looper.getMainLooper()).post(new QQFileManagerUtilImpl.19(paramBaseQQAppInterface, paramFileManagerEntity, paramCheckResult));
    }
  }
  
  private static void b(QQFileManagerUtil.IThumbResult paramIThumbResult, IOException paramIOException, String paramString)
  {
    paramIOException.printStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramIOException.getMessage());
    QLog.w("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
    if (paramIThumbResult != null) {
      paramIThumbResult.a(null);
    }
  }
  
  public static void b(AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    b(paramFileManagerEntity);
    if (paramFileManagerEntity.nFileType == 0)
    {
      String str2 = paramFileManagerEntity.strLargeThumPath;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = a(paramFileManagerEntity);
      }
      if (FileUtils.fileExistsAndNotEmpty(str1))
      {
        paramFileManagerEntity.strLargeThumPath = str1;
        paramAsyncImageView.setDefaultImage(2130844363);
        paramAsyncImageView.setAsyncImage(str1);
        return;
      }
    }
    a(paramAsyncImageView, paramFileManagerEntity.fileName);
  }
  
  private static void b(String paramString)
  {
    QQFMToastUtil.a(paramString);
  }
  
  private static void b(boolean paramBoolean, long paramLong, int paramInt, String paramString, BaseQQAppInterface paramBaseQQAppInterface)
  {
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).onResultByDataLineHandler(paramBoolean, paramLong, paramInt, paramString, paramBaseQQAppInterface);
  }
  
  public static boolean b()
  {
    return FMConfig.c();
  }
  
  private static boolean b(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 8)
    {
      bool1 = bool2;
      if (paramInt != 190)
      {
        bool1 = bool2;
        if (paramInt != 1)
        {
          bool1 = bool2;
          if (paramInt != 16)
          {
            bool1 = bool2;
            if (paramInt != 14)
            {
              bool1 = bool2;
              if (paramInt != 15)
              {
                bool1 = bool2;
                if (paramInt != 17)
                {
                  bool1 = bool2;
                  if (paramInt != 18)
                  {
                    bool1 = bool2;
                    if (paramInt != 19)
                    {
                      bool1 = bool2;
                      if (paramInt != 5)
                      {
                        bool1 = bool2;
                        if (paramInt != 50)
                        {
                          if (paramInt == -1) {
                            return true;
                          }
                          bool1 = false;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    if (FileUtil.a(paramFileManagerEntity.strLargeThumPath)) {
      return true;
    }
    if (FileUtil.a(paramFileManagerEntity.strMiddleThumPath)) {
      return true;
    }
    return FileUtil.a(paramFileManagerEntity.strThumbPath);
  }
  
  private static boolean b(FileManagerEntity paramFileManagerEntity1, FileManagerEntity paramFileManagerEntity2)
  {
    if ((paramFileManagerEntity1.Uuid != null) && (paramFileManagerEntity1.Uuid.equals(paramFileManagerEntity2.Uuid))) {
      return true;
    }
    if ((paramFileManagerEntity2.strFileSHA != null) && (paramFileManagerEntity2.strFileSHA.equals(paramFileManagerEntity1.strFileSHA))) {
      return true;
    }
    if ((paramFileManagerEntity2.strFileMd5 != null) && ((paramFileManagerEntity2.strFileMd5.equals(paramFileManagerEntity1.strFileMd5)) || (paramFileManagerEntity2.strFileMd5.equals(paramFileManagerEntity1.str10Md5)))) {
      return true;
    }
    if ((paramFileManagerEntity2.strTroopFileSha1 != null) && (paramFileManagerEntity2.strTroopFileSha1.equals(paramFileManagerEntity1.strTroopFileSha1))) {
      return true;
    }
    if ((paramFileManagerEntity2.strFileSha3 != null) && (paramFileManagerEntity2.strFileSha3.equals(paramFileManagerEntity1.strFileSha3))) {
      return true;
    }
    return (paramFileManagerEntity2.str10Md5 != null) && (paramFileManagerEntity2.str10Md5.equals(paramFileManagerEntity1.str10Md5));
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new VFSFile(paramString).exists();
  }
  
  private static boolean b(String paramString1, int paramInt1, int paramInt2, QQFileManagerUtil.IThumbResult paramIThumbResult, String paramString2)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      if (c(paramString1, paramInt1, paramInt2, paramIThumbResult, paramString2)) {
        return false;
      }
    }
    else {
      QQFileManagerUtil.FileExecutor.a().execute(new QQFileManagerUtilImpl.12(paramString2, paramIThumbResult, paramString1, paramInt1, paramInt2));
    }
    return true;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qlink_new_flag_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
  }
  
  public static byte[] b(String paramString)
  {
    return a(paramString);
  }
  
  private static int[] b(String paramString)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).decodeFileWithBufferedStream(paramString, localOptions);
      int i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExifRotation(paramString);
      if ((i != 90) && (i != 270)) {
        return new int[] { localOptions.outWidth, localOptions.outHeight };
      }
      return new int[] { localOptions.outHeight, localOptions.outWidth };
    }
    return new int[] { 0, 0 };
  }
  
  public static int c(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = paramFileManagerEntity.fileName.toUpperCase();
    if (paramFileManagerEntity.endsWith(".ZIP")) {
      return 13;
    }
    if (paramFileManagerEntity.endsWith(".RAR")) {
      return 14;
    }
    if (paramFileManagerEntity.endsWith(".7Z")) {
      return 15;
    }
    return -1;
  }
  
  public static int c(String paramString)
  {
    paramString = FileUtil.a(paramString);
    if (paramString == null) {
      return 2130844437;
    }
    return a(d(paramString));
  }
  
  public static String c(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    default: 
      return "other";
    case 12: 
      return "psd";
    case 10: 
      return "txt";
    case 9: 
      return "pdf";
    case 8: 
      return "html";
    case 7: 
      return "ppt";
    case 6: 
      return "excel";
    case 5: 
      return "apk";
    case 4: 
      return "zip";
    case 3: 
      return "doc";
    case 2: 
      return "video";
    case 1: 
      return "audio";
    }
    return "image";
  }
  
  public static String c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return "";
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FileManagerEntity info, ");
      localStringBuilder.append("], nSessionId[");
      localStringBuilder.append(paramFileManagerEntity.nSessionId);
      localStringBuilder.append("], fileName[");
      localStringBuilder.append(paramFileManagerEntity.fileName);
      localStringBuilder.append("], cloudType[");
      localStringBuilder.append(paramFileManagerEntity.getCloudType());
      localStringBuilder.append("], uniseq[");
      localStringBuilder.append(paramFileManagerEntity.uniseq);
      localStringBuilder.append("], nRelatedSessionId[");
      localStringBuilder.append(paramFileManagerEntity.nRelatedSessionId);
      localStringBuilder.append("], bDelInAio[");
      localStringBuilder.append(paramFileManagerEntity.bDelInAio);
      localStringBuilder.append("], bDelInFM[");
      localStringBuilder.append(paramFileManagerEntity.bDelInFM);
      localStringBuilder.append("], fileSize[");
      localStringBuilder.append(paramFileManagerEntity.fileSize);
      localStringBuilder.append("], fProgress[");
      localStringBuilder.append(paramFileManagerEntity.fProgress);
      localStringBuilder.append("], lastTime[");
      localStringBuilder.append(paramFileManagerEntity.lastTime);
      localStringBuilder.append("], msgSeq[");
      localStringBuilder.append(paramFileManagerEntity.msgSeq);
      localStringBuilder.append("], msgUid[");
      localStringBuilder.append(paramFileManagerEntity.msgUid);
      localStringBuilder.append("], msgTime[");
      localStringBuilder.append(paramFileManagerEntity.msgTime);
      localStringBuilder.append("], nFileType[");
      localStringBuilder.append(paramFileManagerEntity.nFileType);
      localStringBuilder.append("], nOpType[");
      localStringBuilder.append(paramFileManagerEntity.nOpType);
      localStringBuilder.append("], nWeiYunSrcType[");
      localStringBuilder.append(paramFileManagerEntity.nWeiYunSrcType);
      localStringBuilder.append("], peerNick[");
      localStringBuilder.append(paramFileManagerEntity.peerNick);
      localStringBuilder.append("], peerType[");
      localStringBuilder.append(paramFileManagerEntity.peerType);
      localStringBuilder.append("], peerUin[");
      localStringBuilder.append(e(paramFileManagerEntity.peerUin));
      localStringBuilder.append("], selfUin[");
      localStringBuilder.append(e(paramFileManagerEntity.selfUin));
      localStringBuilder.append("], srvTime[");
      localStringBuilder.append(paramFileManagerEntity.srvTime);
      localStringBuilder.append("], status[");
      localStringBuilder.append(paramFileManagerEntity.status);
      localStringBuilder.append("], strFilePath[");
      localStringBuilder.append(paramFileManagerEntity.getFilePath());
      localStringBuilder.append("], strServerPath[");
      localStringBuilder.append(paramFileManagerEntity.strServerPath);
      localStringBuilder.append("], strThumbPath[");
      localStringBuilder.append(paramFileManagerEntity.strThumbPath);
      localStringBuilder.append("], Uuid[");
      localStringBuilder.append(paramFileManagerEntity.Uuid);
      localStringBuilder.append("], WeiYunFileId[");
      localStringBuilder.append(paramFileManagerEntity.WeiYunFileId);
      localStringBuilder.append("], nOLfileSessionId[");
      localStringBuilder.append(paramFileManagerEntity.nOLfileSessionId);
      localStringBuilder.append("], strFileMd5[");
      localStringBuilder.append(paramFileManagerEntity.strFileMd5);
      localStringBuilder.append("], strFileSHA[");
      localStringBuilder.append(paramFileManagerEntity.strFileSHA);
      localStringBuilder.append("], nOLfileSessionId[");
      localStringBuilder.append(paramFileManagerEntity.nOLfileSessionId);
      localStringBuilder.append("], WeiYunDirKey[");
      localStringBuilder.append(paramFileManagerEntity.WeiYunDirKey);
      localStringBuilder.append("], _status[");
      localStringBuilder.append(paramFileManagerEntity.getStatus());
      localStringBuilder.append("], bOnceSuccess[");
      localStringBuilder.append(paramFileManagerEntity.bOnceSuccess);
      localStringBuilder.append("], imgHeight[");
      localStringBuilder.append(paramFileManagerEntity.imgHeight);
      localStringBuilder.append("], imgWidth[");
      localStringBuilder.append(paramFileManagerEntity.imgWidth);
      localStringBuilder.append("]");
      paramFileManagerEntity = localStringBuilder.toString();
      return paramFileManagerEntity;
    }
    finally
    {
      paramFileManagerEntity = finally;
      throw paramFileManagerEntity;
    }
  }
  
  public static String c(String paramString)
  {
    int i = paramString.lastIndexOf("/");
    int j = paramString.lastIndexOf(".");
    String str1 = "";
    Object localObject;
    String str2;
    if (i > 0)
    {
      if ((j > 0) && (j > i))
      {
        str1 = paramString.substring(i, j);
        localObject = paramString.substring(j);
      }
      else
      {
        str1 = paramString.substring(i);
        localObject = "";
      }
      str2 = paramString.substring(0, i);
    }
    else
    {
      str2 = "";
      localObject = str2;
    }
    VFSFile localVFSFile = new VFSFile(paramString);
    i = 1;
    String str3 = paramString;
    paramString = localVFSFile;
    while (paramString.exists())
    {
      paramString = new StringBuilder();
      paramString.append(str2);
      paramString.append(str1);
      paramString.append("(");
      paramString.append(i);
      paramString.append(")");
      paramString.append((String)localObject);
      str3 = paramString.toString();
      paramString = new VFSFile(str3);
      i += 1;
    }
    return str3;
  }
  
  private static void c(int paramInt, String paramString, FileManagerEntity paramFileManagerEntity)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      a(paramString);
      return;
    }
    if (!a(paramInt, paramFileManagerEntity.fileName)) {
      a(13, paramFileManagerEntity.fileName);
    }
  }
  
  public static void c(long paramLong)
  {
    Object localObject = a();
    localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).queryFileEntityBySessionId((BaseQQAppInterface)localObject, paramLong);
    if (localObject == null) {
      return;
    }
    int i = ((FileManagerEntity)localObject).nOpType;
    if ((i != -1) && (i != 0))
    {
      if (i != 1) {
        if (i == 20) {}
      }
      switch (i)
      {
      default: 
      case 4: 
      case 6: 
        if (((FileManagerEntity)localObject).nOpType == 6)
        {
          QQFMToastUtil.c(BaseApplication.getContext().getString(2131697389));
          return;
        }
        if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(0))
        {
          QQFMToastUtil.c(BaseApplication.getContext().getString(2131697389));
          return;
        }
        break;
      case 5: 
      case 8: 
        localObject = d(((FileManagerEntity)localObject).fileName);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(d(2131692314));
        localStringBuilder.append(FMSettings.a().getDefaultRecvPath());
        QQFMToastUtil.c(localStringBuilder.toString());
      }
    }
  }
  
  public static void c(Context paramContext, String paramString)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString))
    {
      QQFMToastUtil.a(2131692717);
      return;
    }
    paramString = FileProvider7Helper.openApkIntent(paramContext, paramString);
    paramString.putExtra("big_brother_source_key", "biz_src_jc_file");
    List localList = paramContext.getPackageManager().queryIntentActivities(paramString, 65536);
    int j = localList.size();
    int i = 1;
    if ((j != 1) || (!((ResolveInfo)localList.get(0)).activityInfo.name.equals("com.tencent.mobileqq.activity.JumpActivity"))) {
      i = 0;
    }
    if ((localList.size() > 0) && (i == 0)) {}
    try
    {
      paramContext.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      label110:
      break label110;
    }
    QQFMToastUtil.a(2131693702);
    return;
    QQFMToastUtil.a(2131693702);
  }
  
  private static void c(TextView paramTextView, FileManagerEntity paramFileManagerEntity)
  {
    String str1 = QfileTimeUtils.b(paramFileManagerEntity.srvTime);
    String str2 = e(paramFileManagerEntity);
    String str4 = FileUtil.a(paramFileManagerEntity.fileSize);
    String str5 = d(paramFileManagerEntity);
    String str3 = BaseApplication.getContext().getString(2131692346);
    int i = paramTextView.getWidth();
    TextPaint localTextPaint = paramTextView.getPaint();
    if (paramFileManagerEntity.nFileType == 13)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(BaseApplication.getContext().getString(2131692298));
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(str3);
      ((StringBuilder)localObject).append(str4);
      ((StringBuilder)localObject).append(str3);
      ((StringBuilder)localObject).append(str5);
      localObject = ((StringBuilder)localObject).toString();
    }
    float f1 = localTextPaint.measureText((String)localObject) + 30.0F;
    float f2 = i;
    if (f1 < f2)
    {
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    float f3 = i * 2;
    StringBuilder localStringBuilder;
    if (f1 > f3)
    {
      int j = str2.length();
      i = 1;
      for (;;)
      {
        int k = j - i;
        if (k <= 0) {
          break;
        }
        localObject = str2.substring(0, k);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append(str3);
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(jdField_a_of_type_JavaLangString);
        localStringBuilder.append(str3);
        localStringBuilder.append(str4);
        localStringBuilder.append(str3);
        localStringBuilder.append(str5);
        if (localTextPaint.measureText(localStringBuilder.toString()) + 30.0F < f3)
        {
          paramTextView.setVisibility(0);
          if (paramFileManagerEntity.nFileType == 13)
          {
            paramFileManagerEntity = new StringBuilder();
            paramFileManagerEntity.append(str1);
            paramFileManagerEntity.append(" ");
            paramFileManagerEntity.append(str2);
            paramFileManagerEntity.append(jdField_a_of_type_JavaLangString);
            paramFileManagerEntity.append(" ");
            paramFileManagerEntity.append(BaseApplication.getContext().getString(2131692298));
            paramTextView.setText(paramFileManagerEntity.toString());
            return;
          }
          paramFileManagerEntity = new StringBuilder();
          paramFileManagerEntity.append(str1);
          paramFileManagerEntity.append(str3);
          paramFileManagerEntity.append((String)localObject);
          paramFileManagerEntity.append(jdField_a_of_type_JavaLangString);
          paramFileManagerEntity.append(str3);
          paramFileManagerEntity.append(str4);
          paramFileManagerEntity.append(str3);
          paramFileManagerEntity.append(str5);
          paramTextView.setText(paramFileManagerEntity.toString());
          return;
        }
        i += 1;
      }
      if (paramFileManagerEntity.nFileType == 13)
      {
        paramFileManagerEntity = new StringBuilder();
        paramFileManagerEntity.append(str1);
        paramFileManagerEntity.append(" ");
        paramFileManagerEntity.append(str2);
        paramFileManagerEntity.append("\n");
        paramFileManagerEntity.append(BaseApplication.getContext().getString(2131692298));
        paramTextView.setText(paramFileManagerEntity.toString());
        return;
      }
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append(str1);
      paramFileManagerEntity.append(str3);
      paramFileManagerEntity.append(str2);
      paramFileManagerEntity.append("\n");
      paramFileManagerEntity.append(str4);
      paramFileManagerEntity.append(str3);
      paramFileManagerEntity.append(str5);
      paramTextView.setText(paramFileManagerEntity.toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(str3);
    ((StringBuilder)localObject).append(str2);
    if (localTextPaint.measureText(((StringBuilder)localObject).toString()) + 30.0F > f2)
    {
      i = 4;
      while (i <= str2.length())
      {
        localObject = str2.substring(0, i);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append(str3);
        localStringBuilder.append((String)localObject);
        if (localTextPaint.measureText(localStringBuilder.toString()) + 30.0F > f2)
        {
          localObject = str2.substring(0, i - 1);
          str2 = str2.replace((CharSequence)localObject, "");
          if (paramFileManagerEntity.nFileType == 13)
          {
            paramFileManagerEntity = new StringBuilder();
            paramFileManagerEntity.append(str1);
            paramFileManagerEntity.append(" ");
            paramFileManagerEntity.append((String)localObject);
            paramFileManagerEntity.append("\n");
            paramFileManagerEntity.append(str2);
            paramFileManagerEntity.append(str3);
            paramFileManagerEntity.append(BaseApplication.getContext().getString(2131692298));
            paramTextView.setText(paramFileManagerEntity.toString());
          }
          else
          {
            paramFileManagerEntity = new StringBuilder();
            paramFileManagerEntity.append(str1);
            paramFileManagerEntity.append(str3);
            paramFileManagerEntity.append((String)localObject);
            paramFileManagerEntity.append("\n");
            paramFileManagerEntity.append(str2);
            paramFileManagerEntity.append(str3);
            paramFileManagerEntity.append(str4);
            paramFileManagerEntity.append(str3);
            paramFileManagerEntity.append(str5);
            paramTextView.setText(paramFileManagerEntity.toString());
          }
          paramTextView.setVisibility(0);
          return;
        }
        i += 1;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(str3);
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(str3);
    ((StringBuilder)localObject).append(str4);
    if (localTextPaint.measureText(((StringBuilder)localObject).toString()) + 30.0F > f2)
    {
      if (paramFileManagerEntity.nFileType == 13)
      {
        paramFileManagerEntity = new StringBuilder();
        paramFileManagerEntity.append(str1);
        paramFileManagerEntity.append(" ");
        paramFileManagerEntity.append(str2);
        paramFileManagerEntity.append("\n");
        paramFileManagerEntity.append(BaseApplication.getContext().getString(2131692298));
        paramTextView.setText(paramFileManagerEntity.toString());
      }
      else
      {
        paramFileManagerEntity = new StringBuilder();
        paramFileManagerEntity.append(str1);
        paramFileManagerEntity.append(str3);
        paramFileManagerEntity.append(str2);
        paramFileManagerEntity.append("\n");
        paramFileManagerEntity.append(str4);
        paramFileManagerEntity.append(str3);
        paramFileManagerEntity.append(str5);
        paramTextView.setText(paramFileManagerEntity.toString());
      }
      paramTextView.setVisibility(0);
      return;
    }
    if (paramFileManagerEntity.nFileType == 13)
    {
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append(str1);
      paramFileManagerEntity.append(" ");
      paramFileManagerEntity.append(str2);
      paramFileManagerEntity.append(BaseApplication.getContext().getString(2131692298));
      paramTextView.setText(paramFileManagerEntity.toString());
    }
    else
    {
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append(str1);
      paramFileManagerEntity.append(str3);
      paramFileManagerEntity.append(str2);
      paramFileManagerEntity.append(str3);
      paramFileManagerEntity.append(str4);
      paramFileManagerEntity.append(str3);
      paramFileManagerEntity.append(str5);
      paramTextView.setText(paramFileManagerEntity.toString());
    }
    paramTextView.setVisibility(0);
  }
  
  public static void c(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject;
    if (paramFileManagerEntity.nFileType == 0)
    {
      if ((paramFileManagerEntity.imgHeight <= 0) || (paramFileManagerEntity.imgWidth <= 0))
      {
        if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))
        {
          localObject = b(paramFileManagerEntity.getFilePath());
          paramFileManagerEntity.imgWidth = localObject[0];
          paramFileManagerEntity.imgHeight = localObject[1];
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("localPic[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
        ((StringBuilder)localObject).append("] get thumbsize success size(wh)[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.imgWidth);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(paramFileManagerEntity.imgHeight);
        ((StringBuilder)localObject).append("]");
        QLog.i("FileManagerUtil<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
      localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).createFilePicDrawlableURLWithSend(paramFileManagerEntity);
      if (localObject != null) {
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getDrawable((URL)localObject).downloadImediatly();
      }
      if ((ZhuoXusManager.a().i()) && (b(paramFileManagerEntity.strMiddleThumPath)))
      {
        localObject = new File(paramFileManagerEntity.strMiddleThumPath);
        localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getQRCodeResult(BaseApplication.getContext(), (File)localObject);
        if (localObject != null)
        {
          paramFileManagerEntity.strQRUrl = ((StringBuilder)((Pair)localObject).first).toString();
          if (QLog.isDevelopLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("createMediThumbnail success:");
            ((StringBuilder)localObject).append(paramFileManagerEntity.strQRUrl);
            QLog.i("IMG_FILE_QR", 1, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          if (((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getIsQRing())
          {
            paramFileManagerEntity.strQRUrl = null;
            return;
          }
          paramFileManagerEntity.strQRUrl = "";
        }
      }
    }
    else if (paramFileManagerEntity.nFileType == 2)
    {
      localObject = a(paramFileManagerEntity.getFilePath());
      if (((QQFileManagerUtil.VideoThumbInfo)localObject).jdField_a_of_type_Int == -1) {
        return;
      }
      paramFileManagerEntity.strLargeThumPath = ((QQFileManagerUtil.VideoThumbInfo)localObject).jdField_a_of_type_JavaLangString;
      if ((paramFileManagerEntity.imgHeight > 0) && (paramFileManagerEntity.imgWidth > 0))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Id[");
          ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
          ((StringBuilder)localObject).append("] has size(wh)[");
          ((StringBuilder)localObject).append(paramFileManagerEntity.imgWidth);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append(paramFileManagerEntity.imgHeight);
          ((StringBuilder)localObject).append("]");
          QLog.i("FileManagerUtil<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        paramFileManagerEntity.imgWidth = ((QQFileManagerUtil.VideoThumbInfo)localObject).b;
        paramFileManagerEntity.imgHeight = ((QQFileManagerUtil.VideoThumbInfo)localObject).c;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Id[");
          ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
          ((StringBuilder)localObject).append("]get local video,(wh)[");
          ((StringBuilder)localObject).append(paramFileManagerEntity.imgWidth);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append(paramFileManagerEntity.imgHeight);
          ((StringBuilder)localObject).append("]");
          QLog.i("FileManagerUtil<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("localvideo[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
      ((StringBuilder)localObject).append("] create thumb success size(wh)[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.imgWidth);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramFileManagerEntity.imgHeight);
      ((StringBuilder)localObject).append("]");
      QLog.i("FileManagerUtil<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public static boolean c()
  {
    Object localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFavFiles();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (d(((FavFileInfo)((Iterator)localObject).next()).jdField_c_of_type_JavaLangString) == 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean c(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramFileManagerEntity == null) {
      return false;
    }
    if (paramFileManagerEntity.isZipInnerFile) {
      return false;
    }
    int i = a(paramFileManagerEntity);
    if ((i != 1) && (i != 2)) {
      if (i != 3)
      {
        if (i != 4)
        {
          if (i != 6) {
            return false;
          }
          if (paramFileManagerEntity.nFileType == 0) {
            bool1 = true;
          }
          return bool1;
        }
      }
      else
      {
        bool1 = bool2;
        if (paramFileManagerEntity.nFileType == 0) {
          bool1 = true;
        }
        return bool1;
      }
    }
    return true;
  }
  
  public static boolean c(String paramString)
  {
    return QQFileUtil.b(paramString);
  }
  
  private static boolean c(String paramString1, int paramInt1, int paramInt2, QQFileManagerUtil.IThumbResult paramIThumbResult, String paramString2)
  {
    Bitmap localBitmap = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getImageThumbnail(paramString1, paramInt1, paramInt2);
    if (localBitmap == null)
    {
      if (paramIThumbResult != null) {
        paramIThumbResult.a(null);
      }
      return true;
    }
    try
    {
      FileUtil.a(localBitmap, paramString2);
      localBitmap.recycle();
      paramInt1 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getImageDegree(paramString1);
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).setImageDegree(paramString2, paramInt1);
      if (paramIThumbResult != null) {
        paramIThumbResult.a(paramString2);
      }
      return false;
    }
    catch (OutOfMemoryError paramString1)
    {
      paramString1.printStackTrace();
      paramString2 = new StringBuilder();
      paramString2.append("createThumbnail OutOfMemoryError:");
      paramString2.append(paramString1.getMessage());
      QLog.w("FileManagerUtil<FileAssistant>", 1, paramString2.toString());
      if (paramIThumbResult != null) {
        paramIThumbResult.a(null);
      }
      return true;
    }
    catch (IOException paramString1)
    {
      b(paramIThumbResult, paramString1, "createThumbnail IOException:");
      return true;
    }
    catch (FileNotFoundException paramString1)
    {
      b(paramIThumbResult, paramString1, "createThumbnail FileNotFoundException:");
    }
    return true;
  }
  
  public static byte[] c(String paramString)
  {
    return a(paramString, a(paramString));
  }
  
  public static int d(String paramString)
  {
    try
    {
      Object localObject = FileUtil.a(paramString);
      if ((localObject != null) && (((String)localObject).length() != 0))
      {
        localObject = ((String)localObject).toLowerCase();
        if (jdField_a_of_type_JavaUtilHashMap == null)
        {
          jdField_a_of_type_JavaUtilHashMap = new HashMap();
          jdField_a_of_type_JavaUtilHashMap.put(".mp3", Integer.valueOf(1));
          jdField_a_of_type_JavaUtilHashMap.put(".3gpp", Integer.valueOf(1));
          jdField_a_of_type_JavaUtilHashMap.put(".flac", Integer.valueOf(1));
          jdField_a_of_type_JavaUtilHashMap.put(".ogg", Integer.valueOf(1));
          jdField_a_of_type_JavaUtilHashMap.put(".wav", Integer.valueOf(1));
          jdField_a_of_type_JavaUtilHashMap.put(".m4a", Integer.valueOf(1));
          jdField_a_of_type_JavaUtilHashMap.remove(".flv");
          jdField_a_of_type_JavaUtilHashMap.remove(".m");
          jdField_a_of_type_JavaUtilHashMap.remove(".webp");
          jdField_a_of_type_JavaUtilHashMap.remove(".vcf");
          jdField_a_of_type_JavaUtilHashMap.put(".bmp", Integer.valueOf(0));
          jdField_a_of_type_JavaUtilHashMap.put(".jpg", Integer.valueOf(0));
          jdField_a_of_type_JavaUtilHashMap.put(".jpeg", Integer.valueOf(0));
          jdField_a_of_type_JavaUtilHashMap.put(".png", Integer.valueOf(0));
          jdField_a_of_type_JavaUtilHashMap.put(".gif", Integer.valueOf(0));
          jdField_a_of_type_JavaUtilHashMap.put(".webp", Integer.valueOf(0));
          jdField_a_of_type_JavaUtilHashMap.put(".psd", Integer.valueOf(12));
          jdField_a_of_type_JavaUtilHashMap.put(".swf", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".mov", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".mp4", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".3gp", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".avi", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".rmvb", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".mpg", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".rm", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".asf", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".mpeg", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".mkv", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".wmv", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".flv", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".f4v", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".webm", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".mod", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".mpe", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".fla", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".m4r", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".m4u", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".m4v", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".vob", Integer.valueOf(2));
          jdField_a_of_type_JavaUtilHashMap.put(".doc", Integer.valueOf(3));
          jdField_a_of_type_JavaUtilHashMap.put(".docx", Integer.valueOf(3));
          jdField_a_of_type_JavaUtilHashMap.put(".wps", Integer.valueOf(3));
          jdField_a_of_type_JavaUtilHashMap.put(".pages", Integer.valueOf(3));
          jdField_a_of_type_JavaUtilHashMap.put(".zip", Integer.valueOf(4));
          jdField_a_of_type_JavaUtilHashMap.put(".rar", Integer.valueOf(4));
          jdField_a_of_type_JavaUtilHashMap.put(".7z", Integer.valueOf(4));
          jdField_a_of_type_JavaUtilHashMap.put(".tar", Integer.valueOf(4));
          jdField_a_of_type_JavaUtilHashMap.put(".iso", Integer.valueOf(4));
          jdField_a_of_type_JavaUtilHashMap.put(".gz", Integer.valueOf(4));
          jdField_a_of_type_JavaUtilHashMap.put(".apk", Integer.valueOf(5));
          jdField_a_of_type_JavaUtilHashMap.put(".apk.rename", Integer.valueOf(5));
          jdField_a_of_type_JavaUtilHashMap.put(".xls", Integer.valueOf(6));
          jdField_a_of_type_JavaUtilHashMap.put(".xlsx", Integer.valueOf(6));
          jdField_a_of_type_JavaUtilHashMap.put(".csv", Integer.valueOf(6));
          jdField_a_of_type_JavaUtilHashMap.put(".numbers", Integer.valueOf(6));
          jdField_a_of_type_JavaUtilHashMap.put(".et", Integer.valueOf(6));
          jdField_a_of_type_JavaUtilHashMap.put(".ppt", Integer.valueOf(7));
          jdField_a_of_type_JavaUtilHashMap.put(".pptx", Integer.valueOf(7));
          jdField_a_of_type_JavaUtilHashMap.put(".pps", Integer.valueOf(7));
          jdField_a_of_type_JavaUtilHashMap.put(".dps", Integer.valueOf(7));
          jdField_a_of_type_JavaUtilHashMap.put(".keynotes", Integer.valueOf(7));
          jdField_a_of_type_JavaUtilHashMap.put(".htm", Integer.valueOf(8));
          jdField_a_of_type_JavaUtilHashMap.put(".html", Integer.valueOf(8));
          jdField_a_of_type_JavaUtilHashMap.put(".php", Integer.valueOf(8));
          jdField_a_of_type_JavaUtilHashMap.put(".pdf", Integer.valueOf(9));
          jdField_a_of_type_JavaUtilHashMap.put(".txt", Integer.valueOf(10));
          jdField_a_of_type_JavaUtilHashMap.put(".epub", Integer.valueOf(10));
          jdField_a_of_type_JavaUtilHashMap.put(".rtf", Integer.valueOf(10));
          jdField_a_of_type_JavaUtilHashMap.put(".c", Integer.valueOf(10));
          jdField_a_of_type_JavaUtilHashMap.put(".conf", Integer.valueOf(10));
          jdField_a_of_type_JavaUtilHashMap.put(".cpp", Integer.valueOf(10));
          jdField_a_of_type_JavaUtilHashMap.put(".h", Integer.valueOf(10));
          jdField_a_of_type_JavaUtilHashMap.put(".java", Integer.valueOf(10));
          jdField_a_of_type_JavaUtilHashMap.put(".log", Integer.valueOf(10));
          jdField_a_of_type_JavaUtilHashMap.put(".prop", Integer.valueOf(10));
          jdField_a_of_type_JavaUtilHashMap.put(".rc", Integer.valueOf(10));
          jdField_a_of_type_JavaUtilHashMap.put(".sh", Integer.valueOf(10));
          jdField_a_of_type_JavaUtilHashMap.put(".csv", Integer.valueOf(10));
          jdField_a_of_type_JavaUtilHashMap.put(".xml", Integer.valueOf(10));
          jdField_a_of_type_JavaUtilHashMap.put(".ai", Integer.valueOf(14));
          jdField_a_of_type_JavaUtilHashMap.put(".font", Integer.valueOf(15));
          jdField_a_of_type_JavaUtilHashMap.put(".ipa", Integer.valueOf(16));
          jdField_a_of_type_JavaUtilHashMap.put(".keynote", Integer.valueOf(17));
          jdField_a_of_type_JavaUtilHashMap.put(".note", Integer.valueOf(18));
          jdField_a_of_type_JavaUtilHashMap.put(".numbers", Integer.valueOf(19));
          jdField_a_of_type_JavaUtilHashMap.put(".pages", Integer.valueOf(20));
          jdField_a_of_type_JavaUtilHashMap.put(".sketch", Integer.valueOf(21));
        }
        if (jdField_a_of_type_JavaUtilHashMap.containsKey(((String)localObject).toLowerCase()))
        {
          int i = ((Integer)jdField_a_of_type_JavaUtilHashMap.get(((String)localObject).toLowerCase())).intValue();
          return i;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unknow file Type[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          QLog.w("FileManagerUtil<FileAssistant>", 2, ((StringBuilder)localObject).toString());
        }
        return 11;
      }
      return -1;
    }
    finally {}
  }
  
  private static String d(int paramInt)
  {
    return BaseApplication.getContext().getString(paramInt);
  }
  
  public static String d(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = BaseApplication.getContext();
    String str3 = ((Context)localObject).getString(2131692346);
    int i = paramFileManagerEntity.getCloudType();
    String str1 = null;
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2)
        {
          if ((i != 3) && (i == 5))
          {
            localObject = ((Context)localObject).getString(2131698402);
            break label94;
          }
        }
        else
        {
          localObject = ((Context)localObject).getString(2131692375);
          break label94;
        }
      }
      else
      {
        localObject = ((Context)localObject).getString(2131692296);
        str1 = a(paramFileManagerEntity.srvTime, paramFileManagerEntity.peerType);
        break label94;
      }
    }
    localObject = null;
    label94:
    String str2 = "";
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(a(str3, str1));
      localObject = ((StringBuilder)localObject).toString();
    }
    if ((paramFileManagerEntity.getCloudType() == 2) && (3 == paramFileManagerEntity.nOpType)) {
      return localObject;
    }
    if (paramFileManagerEntity.getCloudType() == 5) {
      return localObject;
    }
    if (paramFileManagerEntity.TroopUin != 0L) {
      return localObject;
    }
    paramFileManagerEntity = str2;
    if (str1 != null) {
      paramFileManagerEntity = str1;
    }
    return paramFileManagerEntity;
  }
  
  public static String d(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      boolean bool = a(paramString);
      if (FontSettingManager.getFontLevel() >= 20.0F) {
        if (bool)
        {
          i = 7;
          break label92;
        }
      }
      do
      {
        i = 3;
        break label92;
        if (FontSettingManager.getFontLevel() >= 18.0F)
        {
          if (bool)
          {
            i = 5;
            break label92;
          }
          i = 2;
          break label92;
        }
        if (FontSettingManager.getFontLevel() < 17.0F) {
          break;
        }
      } while (bool);
      int i = 1;
      break label92;
      i = 0;
      label92:
      int j = paramString.length();
      i = 16 - i;
      String str = paramString;
      if (j > i)
      {
        j = paramString.length();
        i /= 2;
        str = paramString.substring(0, i);
        paramString = paramString.substring(j - i);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("...");
        localStringBuilder.append(paramString);
        str = localStringBuilder.toString();
      }
      return str;
    }
    return "";
  }
  
  public static void d(FileManagerEntity paramFileManagerEntity)
  {
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramFileManagerEntity == null)
        {
          paramFileManagerEntity = new StringBuilder();
          paramFileManagerEntity.append("entity is nll,stack:");
          paramFileManagerEntity.append(a());
          localStringBuilder.append(paramFileManagerEntity.toString());
          QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
          return;
        }
        int i = paramFileManagerEntity.nFileType;
        if ((i != 2) && (i != 0))
        {
          localStringBuilder.append("entity[");
          localStringBuilder.append(paramFileManagerEntity.nSessionId);
          localStringBuilder.append("] is not pic or video, return");
          QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
          return;
        }
        if ((paramFileManagerEntity.imgHeight > 0) && (paramFileManagerEntity.imgWidth > 0))
        {
          localStringBuilder.append("entity[");
          localStringBuilder.append(paramFileManagerEntity.nSessionId);
          localStringBuilder.append("] size(wh)[");
          localStringBuilder.append(paramFileManagerEntity.imgWidth);
          localStringBuilder.append(":");
          localStringBuilder.append(paramFileManagerEntity.imgHeight);
          localStringBuilder.append("] OK, return!");
          QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
          return;
        }
        Object localObject1 = paramFileManagerEntity.getFilePath();
        Object localObject2;
        if (FileUtil.a((String)localObject1))
        {
          if (i != 2) {
            break label674;
          }
          bool = false;
          localStringBuilder.append("entity[");
          localStringBuilder.append(paramFileManagerEntity.nSessionId);
          localStringBuilder.append("] is local, use local calc size!");
        }
        else
        {
          localObject1 = paramFileManagerEntity.strLargeThumPath;
          if (FileUtil.a((String)localObject1))
          {
            localStringBuilder.append("entity[");
            localStringBuilder.append(paramFileManagerEntity.nSessionId);
            localStringBuilder.append("] is cloude , use largThumb calc size!");
            break label679;
          }
          localObject1 = paramFileManagerEntity.strMiddleThumPath;
          if (FileUtil.a((String)localObject1))
          {
            localStringBuilder.append("entity[");
            localStringBuilder.append(paramFileManagerEntity.nSessionId);
            localStringBuilder.append("] is cloud , use middleThumb calc size!,becarefull middle must createByLarge!!!");
            break label679;
          }
          if (i != 2) {
            break label679;
          }
          localObject2 = paramFileManagerEntity.strThumbPath;
          localObject1 = localObject2;
          if (!FileUtil.a((String)localObject2)) {
            break label679;
          }
          localStringBuilder.append("entity[");
          localStringBuilder.append(paramFileManagerEntity.nSessionId);
          localStringBuilder.append("] video is cloud , use thumb calc size!");
          localObject1 = localObject2;
          break label679;
        }
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localStringBuilder.append("entity[");
          localStringBuilder.append(paramFileManagerEntity.nSessionId);
          localStringBuilder.append("] is No LoaclFile,No LargeThumb,No middleThumb,so return");
          QLog.e("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
          return;
        }
        if (bool)
        {
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).decodeFileWithBufferedStream((String)localObject1, (BitmapFactory.Options)localObject2);
          if ((paramFileManagerEntity.imgHeight <= 0) || (paramFileManagerEntity.imgWidth <= 0))
          {
            paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject2).outWidth;
            paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject2).outHeight;
          }
          i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExifRotation((String)localObject1);
          if ((i == 90) || (i == 270))
          {
            paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject2).outHeight;
            paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject2).outWidth;
          }
        }
        else if (i == 2)
        {
          c(paramFileManagerEntity);
        }
        localStringBuilder.append(" calc size over size(wh)[");
        localStringBuilder.append(paramFileManagerEntity.imgWidth);
        localStringBuilder.append(":");
        localStringBuilder.append(paramFileManagerEntity.imgHeight);
        localStringBuilder.append("]");
        localStringBuilder.append(" useImageCreateThumb:");
        localStringBuilder.append(bool);
        QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
        return;
      }
      finally {}
      label674:
      boolean bool = true;
      continue;
      label679:
      bool = true;
    }
  }
  
  public static boolean d()
  {
    return false;
  }
  
  public static boolean d(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool2 = false;
    if (paramFileManagerEntity == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramFileManagerEntity.TroopUin != 0L)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramFileManagerEntity.strTroopFileID))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramFileManagerEntity.strTroopFilePath)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static byte[] d(String paramString)
  {
    return a(paramString, "SHA-1");
  }
  
  public static int e(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qlink_new_count_");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String e(FileManagerEntity paramFileManagerEntity)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (c.size() == 0)
    {
      c.put(Integer.valueOf(1), localBaseApplication.getString(2131692306));
      c.put(Integer.valueOf(9), localBaseApplication.getString(2131692306));
      c.put(Integer.valueOf(10), localBaseApplication.getString(2131692306));
      c.put(Integer.valueOf(11), localBaseApplication.getString(2131692306));
      c.put(Integer.valueOf(12), localBaseApplication.getString(2131692306));
      c.put(Integer.valueOf(13), localBaseApplication.getString(2131692306));
      c.put(Integer.valueOf(6), localBaseApplication.getString(2131692313));
      c.put(Integer.valueOf(4), localBaseApplication.getString(2131692313));
      c.put(Integer.valueOf(20), localBaseApplication.getString(2131692313));
      c.put(Integer.valueOf(22), localBaseApplication.getString(2131692341));
      c.put(Integer.valueOf(21), localBaseApplication.getString(2131692341));
      c.put(Integer.valueOf(0), localBaseApplication.getString(2131692341));
      c.put(Integer.valueOf(7), localBaseApplication.getString(2131692341));
      c.put(Integer.valueOf(3), localBaseApplication.getString(2131692341));
      c.put(Integer.valueOf(24), localBaseApplication.getString(2131692341));
      c.put(Integer.valueOf(5), localBaseApplication.getString(2131692307));
      c.put(Integer.valueOf(50), localBaseApplication.getString(2131692307));
      c.put(Integer.valueOf(14), localBaseApplication.getString(2131720078));
      c.put(Integer.valueOf(15), localBaseApplication.getString(2131720079));
      c.put(Integer.valueOf(16), localBaseApplication.getString(2131720084));
      c.put(Integer.valueOf(17), localBaseApplication.getString(2131720081));
      c.put(Integer.valueOf(18), localBaseApplication.getString(2131720080));
      c.put(Integer.valueOf(19), localBaseApplication.getString(2131720082));
      c.put(Integer.valueOf(190), localBaseApplication.getString(2131720085));
      c.put(Integer.valueOf(40), localBaseApplication.getString(2131720083));
    }
    localObject1 = a(paramFileManagerEntity, localBaseApplication, (String)c.get(Integer.valueOf(paramFileManagerEntity.nOpType)));
    if (paramFileManagerEntity.getCloudType() == 0) {
      localObject1 = localBaseApplication.getString(2131692306);
    }
    if (paramFileManagerEntity.getCloudType() == 5)
    {
      localObject1 = localBaseApplication.getString(2131692306);
      if (paramFileManagerEntity.bSend) {
        localObject1 = localBaseApplication.getString(2131692341);
      }
      localObject2 = paramFileManagerEntity.peerNick;
    }
    else
    {
      localObject2 = null;
    }
    Object localObject2 = a(paramFileManagerEntity, localBaseApplication, (String)localObject1, (String)localObject2);
    Object localObject3 = localObject1;
    if (paramFileManagerEntity.nOpType == 1)
    {
      localObject3 = localObject1;
      if (paramFileManagerEntity.bSend) {
        localObject3 = localBaseApplication.getString(2131692341);
      }
    }
    localObject5 = localObject3;
    localObject1 = localObject2;
    try
    {
      BaseQQAppInterface localBaseQQAppInterface = a();
      localObject5 = localObject3;
      localObject1 = localObject2;
      localObject6 = a(localBaseQQAppInterface, paramFileManagerEntity.peerUin, "", paramFileManagerEntity.peerType);
      localObject2 = localObject3;
      localObject4 = localObject6;
      localObject5 = localObject3;
      localObject1 = localObject6;
      if (paramFileManagerEntity.TroopUin != 0L)
      {
        localObject5 = localObject3;
        localObject1 = localObject6;
        localObject4 = a(paramFileManagerEntity, localBaseApplication, (String)localObject6, localBaseQQAppInterface);
        localObject2 = null;
      }
      localObject3 = localObject4;
      if (localObject2 != null)
      {
        localObject3 = localObject4;
        localObject5 = localObject2;
        localObject1 = localObject4;
        if (((String)localObject2).equals(localBaseApplication.getString(2131692313))) {
          localObject3 = null;
        }
      }
      localObject6 = localObject2;
      localObject4 = localObject3;
      localObject5 = localObject2;
      localObject1 = localObject3;
      if (paramFileManagerEntity.peerType == 3000)
      {
        if (localObject2 != null)
        {
          localObject5 = localObject2;
          localObject1 = localObject3;
          if (!((String)localObject2).equals(localBaseApplication.getString(2131692313))) {}
        }
        else
        {
          localObject6 = localObject2;
          localObject4 = localObject3;
          localObject5 = localObject2;
          localObject1 = localObject3;
          if (paramFileManagerEntity.nOpType != 28) {
            break label820;
          }
        }
        localObject5 = localObject2;
        localObject1 = localObject3;
        localObject4 = b(paramFileManagerEntity, localBaseApplication, (String)localObject3, localBaseQQAppInterface);
        localObject6 = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label820:
        Object localObject6 = localObject5;
        Object localObject4 = localObject1;
      }
    }
    if ((localObject6 != null) && (((String)localObject6).equalsIgnoreCase(localBaseApplication.getString(2131692307))) && (paramFileManagerEntity.bSend))
    {
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append(localBaseApplication.getString(2131692341));
      paramFileManagerEntity.append(" ");
      paramFileManagerEntity.append((String)localObject4);
      return paramFileManagerEntity.toString();
    }
    if ((localObject6 != null) && (localObject4 != null))
    {
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append((String)localObject6);
      paramFileManagerEntity.append(" ");
      paramFileManagerEntity.append((String)localObject4);
      return paramFileManagerEntity.toString();
    }
    if (localObject6 != null) {
      return localObject6;
    }
    return localObject4;
  }
  
  public static String e(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      Object localObject = new ByteArrayBuffer(paramString.length());
      if (!paramString.equals(null))
      {
        int j = 0;
        int k;
        for (int i = 0; j < paramString.length(); i = k + 1)
        {
          k = i;
          if (i > 15) {
            k = i % 16;
          }
          int m = paramString.codePointAt(j) + "AnDrDQ_Fm_String".codePointAt(k);
          i = m;
          if (m > 65535) {
            i = m % 65535;
          }
          ((ByteArrayBuffer)localObject).append(i);
          j += 1;
        }
      }
      paramString = HexUtil.bytes2HexStr(((ByteArrayBuffer)localObject).toByteArray());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#_#");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("O_O");
      paramString = ((StringBuilder)localObject).toString();
      return paramString;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static boolean e(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    if (FileUtil.a(paramFileManagerEntity.getFilePath())) {
      return true;
    }
    if (FileUtil.a(paramFileManagerEntity.strMiddleThumPath)) {
      return true;
    }
    if (FileUtil.a(paramFileManagerEntity.strLargeThumPath)) {
      return true;
    }
    if (FileUtil.a(paramFileManagerEntity.strThumbPath)) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    localStringBuilder.append("] no Thumb!");
    QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
    return false;
  }
  
  public static byte[] e(String paramString)
  {
    return a(paramString, "MD5");
  }
  
  public static String f(String paramString)
  {
    paramString = c(paramString);
    if (paramString == null) {
      return "";
    }
    paramString = HexUtil.bytes2HexStr(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FMSettings.a().getDefaultThumbPath());
    localStringBuilder.append("x-video-");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static boolean f(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileUtil.a(paramFileManagerEntity.getFilePath()).equalsIgnoreCase(".mov") ^ true;
  }
  
  private static int g(String paramString)
  {
    if (paramString == null) {
      return 4;
    }
    if (paramString.equalsIgnoreCase("com.tencent.mtt")) {
      return 1;
    }
    if (paramString.equalsIgnoreCase("send_to_wx")) {
      return 2;
    }
    if (paramString.equalsIgnoreCase("cn.wps.moffice_eng")) {
      return 3;
    }
    return 4;
  }
  
  public static String g(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int i = paramString.lastIndexOf(".");
    if ((i > 0) && (i < paramString.length() - 1)) {
      return paramString.substring(i + 1).toUpperCase();
    }
    return "";
  }
  
  public static String h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.replace("ftn_compress_getfile", "ftn_compress_getabs");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("size=750&");
    return localStringBuilder.toString();
  }
  
  private static String j(String paramString)
  {
    if (paramString.equalsIgnoreCase("userClickOnceEvent")) {
      return "0X800AE45";
    }
    if (paramString.equalsIgnoreCase("userClickAlwaysEvent")) {
      return "0X800AE44";
    }
    if (paramString.equalsIgnoreCase("userMenuClickEvent")) {
      return "0X800AE43";
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl
 * JD-Core Version:    0.7.0.1
 */