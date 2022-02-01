package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;
import com.dataline.util.file.MediaStoreUtil;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.qrcode.activity.ScannerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVipTroopFileConfig;
import com.tencent.mobileqq.config.business.qvip.QVipTroopFileProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileassistant.forward.QFileAssistantForwardManager;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IQRMenuItemController;
import com.tencent.mobileqq.filemanager.fileviewer.open.CommonFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.fileviewer.open.TroopFileBrowserParams;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.widget.QFileClickableSpan;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.ocr.OCRManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.TroopGagInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QFileUtils
{
  public static int a()
  {
    int i = 1;
    switch (NetConnInfoCenter.getActiveNetIpFamily(true))
    {
    default: 
      i = 0;
    case 1: 
      return i;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public static int a(float paramFloat, Resources paramResources)
  {
    return AIOUtils.a(paramFloat, paramResources);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      return -1;
    case 1: 
    case 2: 
      return 0;
    case 5: 
    case 6: 
      return 3000;
    }
    return 1;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 * 1.0F / paramInt2 >= 1.777778F) {
      return 2;
    }
    return 1;
  }
  
  public static int a(Context paramContext, boolean paramBoolean, Bundle paramBundle, int paramInt)
  {
    int i = 0;
    if ((paramInt == 3) || (paramInt == 1))
    {
      i = ChatHistoryActivity.a(paramContext);
      paramBundle.putInt("FromChatHistoryTab", i);
      paramBundle.putBoolean("file_location_pos_entrance_multiseq", paramBoolean);
    }
    return i;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramInt == 0) {}
    do
    {
      return 1;
      if (paramInt == 3000) {
        return 101;
      }
    } while (paramInt != 1);
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
    if (paramQQAppInterface != null)
    {
      if (paramQQAppInterface.isNewTroop) {
        return 113;
      }
      return 4;
    }
    return 4;
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return -1;
        paramString = paramString.split("@");
      } while ((paramString == null) || (paramString.length <= 0));
      paramString = paramString[0];
    } while (TextUtils.isEmpty(paramString));
    return Integer.parseInt(paramString);
  }
  
  public static Intent a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity)
  {
    int i = ForwardFileOption.a(paramFileManagerEntity);
    paramActivity = ForwardFileOption.a(paramFileManagerEntity);
    paramActivity.b(i);
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt("forward_type", 0);
    paramQQAppInterface.putParcelable("fileinfo", paramActivity);
    paramQQAppInterface.putBoolean("not_forward", true);
    paramActivity = new Intent();
    paramActivity.putExtras(paramQQAppInterface);
    paramActivity.putExtra("destroy_last_activity", true);
    paramActivity.putExtra("forward_type", 0);
    paramActivity.putExtra("forward_filepath", paramFileManagerEntity.getFilePath());
    paramActivity.putExtra("forward_text", HardCodeUtil.a(2131709686) + FileManagerUtil.d(paramFileManagerEntity.fileName) + HardCodeUtil.a(2131709698) + FileUtil.a(paramFileManagerEntity.fileSize) + "。");
    paramActivity.putExtra("k_favorites", FileManagerUtil.d(paramFileManagerEntity));
    if ((!FileUtil.b(paramFileManagerEntity.getFilePath())) && ((paramFileManagerEntity.getCloudType() == 6) || (paramFileManagerEntity.getCloudType() == 7)) && (paramFileManagerEntity.nFileType == 0)) {
      paramActivity.putExtra("forward_type", 0);
    }
    if ((paramFileManagerEntity.getCloudType() == 8) && (paramFileManagerEntity.nFileType == 0)) {
      paramActivity.putExtra("forward_type", 1);
    }
    return paramActivity;
  }
  
  public static Intent a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    localFileManagerEntity.status = 2;
    paramQQAppInterface.getFileManagerDataCenter().d(localFileManagerEntity);
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(paramQQAppInterface, localFileManagerEntity);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(localFileManagerEntity.nSessionId);
    if (!TextUtils.isEmpty(localFileManagerEntity.getFilePath())) {
      localForwardFileInfo.a(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
    }
    localForwardFileInfo.d(localTroopFileStatusInfo.g);
    localForwardFileInfo.d(localTroopFileStatusInfo.jdField_c_of_type_Long);
    localForwardFileInfo.a(localFileManagerEntity.TroopUin);
    paramFileManagerEntity = localTroopFileStatusInfo.d;
    paramQQAppInterface = paramFileManagerEntity;
    if (TextUtils.isEmpty(paramFileManagerEntity)) {
      paramQQAppInterface = localTroopFileStatusInfo.jdField_c_of_type_JavaLangString;
    }
    localForwardFileInfo.f(paramQQAppInterface);
    if (localFileManagerEntity.isZipInnerFile)
    {
      localForwardFileInfo.b(10000);
      localForwardFileInfo.d(3);
    }
    for (;;)
    {
      localForwardFileInfo.a(2);
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putInt("forward_type", 0);
      paramQQAppInterface.putParcelable("fileinfo", localForwardFileInfo);
      paramQQAppInterface.putBoolean("not_forward", true);
      paramFileManagerEntity = new Intent();
      paramFileManagerEntity.putExtras(paramQQAppInterface);
      paramFileManagerEntity.putExtra("forward_text", localTroopFileStatusInfo.g);
      paramFileManagerEntity.putExtra("forward_from_troop_file", true);
      return paramFileManagerEntity;
      if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null) {
        localForwardFileInfo.e(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString());
      }
      localForwardFileInfo.b(10006);
      localForwardFileInfo.d(4);
    }
  }
  
  public static Rect a(View paramView, String paramString)
  {
    if ((paramView != null) && (!TextUtils.isEmpty(paramString)))
    {
      int i = FileManagerUtil.a(paramString);
      if ((i == 2) || (i == 0)) {
        return AnimationUtils.a(paramView);
      }
    }
    return null;
  }
  
  public static SpannableString a(String paramString1, String paramString2, FileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    int k = paramString1.indexOf(paramString2);
    if (k < 0) {
      return new SpannableString(paramString1);
    }
    int m = paramString2.length();
    int j = Color.parseColor("#4799DF");
    if (paramTipsClickedInterface != null) {}
    for (int i = Color.parseColor("#A3CCEF");; i = j)
    {
      paramString2 = new ColorStateList(new int[][] { { 16842919 }, new int[0] }, new int[] { i, j });
      paramString1 = new SpannableString(paramString1);
      paramString1.setSpan(new QFileClickableSpan(new QFileUtils.1(paramTipsClickedInterface), paramString2), k, k + m, 33);
      return paramString1;
    }
  }
  
  public static DataLineHandler a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return (DataLineHandler)paramQQAppInterface.getBusinessHandler(paramString);
  }
  
  public static TroopFileStatusInfo a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileInfo paramTroopFileInfo)
  {
    TroopFileStatusInfo localTroopFileStatusInfo2 = TroopFileTransferManager.a(paramQQAppInterface, paramLong).a(paramTroopFileInfo.b);
    TroopFileStatusInfo localTroopFileStatusInfo1 = localTroopFileStatusInfo2;
    if (localTroopFileStatusInfo2 == null)
    {
      localTroopFileStatusInfo1 = TroopFileUtils.a(paramQQAppInterface, paramLong, paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID.toString(), paramTroopFileInfo.b, paramTroopFileInfo.jdField_c_of_type_JavaLangString, paramTroopFileInfo.jdField_a_of_type_Long, paramTroopFileInfo.jdField_a_of_type_Int);
      localTroopFileStatusInfo1.jdField_c_of_type_JavaLangString = paramTroopFileInfo.k;
      localTroopFileStatusInfo1.d = paramTroopFileInfo.l;
      localTroopFileStatusInfo1.b = paramTroopFileInfo.j;
    }
    return localTroopFileStatusInfo1;
  }
  
  public static ShareActionSheetBuilder.ActionSheetItem a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = ShareActionSheetBuilder.ActionSheetItem.build(paramInt);
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.listener = paramOnClickListener;
    localActionSheetItem.argus = "";
    return localActionSheetItem;
  }
  
  public static String a(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "x-dsc-";
    }
    for (;;)
    {
      return str + paramString;
      str = "micro-dsc-";
      continue;
      str = "minni-dsc-";
      continue;
      str = "small-dsc-";
      continue;
      str = "middle-dsc-";
      continue;
      str = "large-dsc-";
      continue;
      str = "qlarge-dsc-";
      continue;
      str = "xlarge-dsc-";
      continue;
      str = "qxlarge-dsc-";
      continue;
      str = "screen-dsc-";
    }
  }
  
  public static String a(long paramLong)
  {
    if (paramLong <= 0L) {
      return "00:00:00";
    }
    paramLong /= 1000L;
    String str1;
    String str2;
    if (paramLong / 3600L > 9L)
    {
      str1 = paramLong / 3600L + "";
      if (paramLong % 3600L / 60L <= 9L) {
        break label208;
      }
      str2 = paramLong % 3600L / 60L + "";
      label98:
      if (paramLong % 3600L % 60L <= 9L) {
        break label240;
      }
    }
    label208:
    label240:
    for (String str3 = paramLong % 3600L % 60L + "";; str3 = "0" + paramLong % 3600L % 60L)
    {
      return str1 + ":" + str2 + ":" + str3;
      str1 = "0" + paramLong / 3600L;
      break;
      str2 = "0" + paramLong % 3600L / 60L;
      break label98;
    }
  }
  
  public static String a(long paramLong, int paramInt, String paramString)
  {
    if (paramInt == 128) {
      return "[Thumb]" + paramLong + "-" + paramString;
    }
    if (paramInt == 383) {
      return "[Thumb]320" + paramLong + "-" + paramString;
    }
    return "[Thumb]" + paramInt + paramLong + "-" + paramString;
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, TextView paramTextView1, TextView paramTextView2, String paramString1, String paramString2)
  {
    paramTextView1 = paramTextView1.getPaint();
    paramTextView2 = paramTextView2.getPaint();
    int i = a(7.0F, paramContext.getResources());
    int j = (int)paramTextView2.measureText(paramString2);
    int k = a(15.0F, paramContext.getResources());
    switch (paramInt1)
    {
    case 1: 
    default: 
      return paramString1;
    }
    return (String)TextUtils.ellipsize(paramString1, paramTextView1, paramInt2 - i * 2 - j - k, TextUtils.TruncateAt.END);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramContext.getString(2131692414));
      }
      localStringBuilder.append("来自");
      localStringBuilder.append(paramString2);
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramContext.getString(2131692414));
      }
      localStringBuilder.append(paramString3);
    }
    if (!TextUtils.isEmpty(paramString4))
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramContext.getString(2131692414));
      }
      localStringBuilder.append(paramString4);
    }
    return localStringBuilder.toString();
  }
  
  public static String a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return "";
    }
    File localFile = new File(FMSettings.a().b());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(FMSettings.a().b() + ".video_frame/");
    FileUtils.a(localFile.getAbsolutePath());
    localFile.mkdirs();
    localFile = new File(localFile.getAbsolutePath(), System.currentTimeMillis() + ".jpg");
    try
    {
      ImageUtil.a(paramBitmap, localFile);
      paramBitmap = localFile.getAbsolutePath();
      return paramBitmap;
    }
    catch (IOException paramBitmap)
    {
      paramBitmap.printStackTrace();
      QLog.i("QFileUtils<QFile>", 1, "[saveBitmapFileAsJPEG] error. " + paramBitmap.getMessage());
    }
    return "";
  }
  
  private static String a(AppInterface paramAppInterface, MessageForFile paramMessageForFile)
  {
    String str1 = "select * from " + FileManagerEntity.tableName() + " where  uniseq = " + paramMessageForFile.uniseq;
    paramAppInterface = paramAppInterface.getEntityManagerFactory().createEntityManager().rawQuery(FileManagerEntity.class, str1, null);
    if (paramAppInterface == null) {
      paramAppInterface = null;
    }
    String str2;
    do
    {
      return paramAppInterface;
      paramAppInterface = (FileManagerEntity)paramAppInterface.get(0);
      str2 = paramAppInterface.getFilePath();
      if (FileManagerUtil.b(str2))
      {
        if (QLog.isDebugVersion()) {
          QLog.i("FileClean", 1, "find file[" + str2 + "] for msg:" + paramMessageForFile.uniseq);
        }
        return str2;
      }
      str1 = FMSettings.a().c();
      if (paramAppInterface.Uuid == null) {
        break;
      }
      String str3 = com.tencent.qphone.base.util.MD5.toMD5(paramAppInterface.Uuid);
      str3 = str1 + str3;
      if (FileManagerUtil.b(str3))
      {
        if (QLog.isDebugVersion()) {
          QLog.i("FileClean", 1, "find tmp file[" + str2 + "] for msg:" + paramMessageForFile.uniseq);
        }
        return str3;
      }
      str1 = str1 + "dsc-" + String.valueOf(paramAppInterface.Uuid.replace("/", ""));
      if (!FileManagerUtil.b(str1)) {
        break;
      }
      paramAppInterface = str1;
    } while (!QLog.isDebugVersion());
    QLog.i("FileClean", 1, "find tmp file[" + str2 + "] for msg:" + paramMessageForFile.uniseq);
    return str1;
    return null;
  }
  
  private static String a(AppInterface paramAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    String str1 = AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH;
    Object localObject = new TroopFileTansferItemEntity();
    ((TroopFileTansferItemEntity)localObject).troopuin = Long.parseLong(paramMessageForTroopFile.frienduin);
    String str2 = "select * from " + ((TroopFileTansferItemEntity)localObject).getTableName() + " where troopuin = ? and _sId = ?";
    paramAppInterface = paramAppInterface.getEntityManagerFactory().createEntityManager().rawQuery(TroopFileTansferItemEntity.class, str2, new String[] { "" + ((TroopFileTansferItemEntity)localObject).troopuin, SecurityUtile.encode(paramMessageForTroopFile.uuid) });
    if (paramAppInterface == null)
    {
      if (QLog.isDebugVersion()) {
        QLog.i("FileClean", 1, "find troop file result is null, for msg:" + paramMessageForTroopFile.uniseq);
      }
      return null;
    }
    localObject = paramAppInterface.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramAppInterface = (TroopFileTansferItemEntity)((Iterator)localObject).next();
      if (paramAppInterface.Id.equals(UUID.fromString(paramMessageForTroopFile.uuid)))
      {
        localObject = paramAppInterface.LocalFile;
        paramAppInterface = paramAppInterface.FilePath;
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (FileManagerUtil.b((String)localObject)))
      {
        if (QLog.isDebugVersion()) {
          QLog.i("FileClean", 1, "find troop file[" + (String)localObject + "] for msg:" + paramMessageForTroopFile.uniseq);
        }
        return localObject;
      }
      if (TextUtils.isEmpty(paramAppInterface))
      {
        if (!QLog.isDebugVersion()) {
          break;
        }
        QLog.i("FileClean", 1, "find troop file but filePath is null, for msg:" + paramMessageForTroopFile.uniseq);
        return null;
      }
      localObject = com.tencent.qphone.base.util.MD5.toMD5(paramAppInterface);
      localObject = str1 + (String)localObject;
      str1 = str1 + HexUtil.bytes2HexStr(paramAppInterface.getBytes()) + ".tmp";
      if (FileUtil.a(str1) > 0L) {
        localObject = str1;
      }
      for (;;)
      {
        if (FileManagerUtil.b((String)localObject))
        {
          if (QLog.isDebugVersion()) {
            QLog.i("FileClean", 1, "find tmp file[" + (String)localObject + "] for msg:" + paramMessageForTroopFile.uniseq);
          }
          return localObject;
        }
        paramAppInterface = FMSettings.a().c() + com.tencent.securitysdk.utils.MD5.a(paramAppInterface);
        if (!FileManagerUtil.b(paramAppInterface)) {
          break;
        }
        if (QLog.isDebugVersion()) {
          QLog.i("FileClean", 1, "find tmp2 file[" + paramAppInterface + "] for msg:" + paramMessageForTroopFile.uniseq);
        }
        return paramAppInterface;
      }
      paramAppInterface = null;
      localObject = null;
    }
  }
  
  public static String a(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      if (QLog.isColorLevel()) {
        QLog.i("FileClean", 1, "queryFilePathForMessage, msg is null");
      }
    }
    do
    {
      return null;
      if (MessageForFile.class.isInstance(paramMessageRecord))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileClean", 1, "queryFilePathForMessage, msg is MessageForFile");
        }
        return a(paramAppInterface, (MessageForFile)paramMessageRecord);
      }
      if (MessageForTroopFile.class.isInstance(paramMessageRecord))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileClean", 1, "queryFilePathForMessage, msg is MessageForTroopFile");
        }
        return a(paramAppInterface, (MessageForTroopFile)paramMessageRecord);
      }
    } while (!QLog.isColorLevel());
    QLog.i("FileClean", 1, "queryFilePathForMessage, msg is :" + paramMessageRecord.msgtype);
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    Object localObject = (TroopGagMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
    if (localObject != null)
    {
      if (((TroopGagMgr)localObject).a(String.valueOf(paramLong1), String.valueOf(paramLong2))) {
        return HardCodeUtil.a(2131709687);
      }
      localObject = ((TroopGagMgr)localObject).a(String.valueOf(paramLong1));
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((localObject != null) && (((TroopGagMgr.TroopGagInfo)localObject).jdField_a_of_type_Long != 0L))
      {
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.b(String.valueOf(paramLong1));
          if ((paramQQAppInterface != null) && ((paramQQAppInterface.isTroopOwner(String.valueOf(paramLong2))) || (paramQQAppInterface.isTroopAdmin(String.valueOf(paramLong2))))) {
            return "";
          }
        }
        return HardCodeUtil.a(2131709699);
      }
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return "";
    }
    return a(paramQQAppInterface, paramMessageRecord, true);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mrUniseq[").append(paramMessageRecord.uniseq).append("] ");
    localStringBuilder.append("mrSeq[").append(paramMessageRecord.msgseq).append("] ");
    localStringBuilder.append("mrUid[").append(paramMessageRecord.msgUid).append("] ");
    if (paramBoolean)
    {
      if (!(paramMessageRecord instanceof MessageForFile)) {
        break label161;
      }
      paramQQAppInterface = paramQQAppInterface.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (paramQQAppInterface != null)
      {
        localStringBuilder.append("offFileName[").append(paramQQAppInterface.fileName).append("] ");
        localStringBuilder.append("offFileUuid[").append(paramQQAppInterface.Uuid).append("] ");
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label161:
      if ((paramMessageRecord instanceof MessageForTroopFile))
      {
        paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord);
        if (paramQQAppInterface != null)
        {
          localStringBuilder.append("troopFileName[").append(paramQQAppInterface.g).append("] ");
          localStringBuilder.append("troopFileId").append(paramQQAppInterface.e).append("] ");
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    Object localObject1;
    if (!FileUtils.b(paramString)) {
      localObject1 = "";
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (FileManagerUtil.a(paramString) > 3145728L) {
        QLog.i("<QFile>", 1, "copyFileToQFileFolder: source file is too big. copy failed");
      }
      localObject1 = FMSettings.a().b();
      localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdir();
      }
      localObject2 = FileManagerUtil.a(paramString);
      localObject2 = (String)localObject1 + "/" + System.currentTimeMillis() + "_" + (String)localObject2;
      localObject1 = localObject2;
    } while (FileUtils.d(paramString, (String)localObject2));
    return "";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf(paramString3);
    if (i < 0) {}
    do
    {
      int j;
      do
      {
        return paramString2;
        j = paramString1.indexOf("\n");
      } while (j <= i);
      paramString1 = paramString1.substring(i + paramString3.length(), j);
    } while ((paramString1.contains(paramString2)) || (paramString1.length() >= paramString2.length()));
    paramString2 = new StringBuilder(paramString2);
    paramString2.insert(paramString1.length(), "\n");
    return paramString2.toString();
  }
  
  public static void a(int paramInt1, int paramInt2, FileBrowserCreator paramFileBrowserCreator)
  {
    if ((paramInt2 == 1) || ((paramInt2 == 3) && (paramInt1 == 1)))
    {
      paramFileBrowserCreator.c(38);
      return;
    }
    paramFileBrowserCreator.a();
  }
  
  public static void a(Context paramContext, Rect paramRect, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramRect, paramChatMessage, paramSessionInfo, paramBoolean1, paramBoolean2, false, null);
  }
  
  public static void a(Context paramContext, Rect paramRect, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, MessageForReplyText paramMessageForReplyText)
  {
    i = 1;
    Bundle localBundle = new Bundle();
    if (paramRect != null) {
      localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramRect);
    }
    localBundle.putBoolean("muate_play", paramBoolean1);
    localBundle.putBoolean("is_one_item", paramBoolean2);
    localBundle.putBoolean(PeakUtils.b, paramBoolean3);
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.b);
    }
    localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramChatMessage.isMultiMsg);
    if (paramMessageForReplyText != null) {
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
    }
    localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramChatMessage.isMultiMsg);
    localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
    paramRect = paramChatMessage.selfuin;
    if ((paramChatMessage.isMultiMsg) || (paramChatMessage.isReplySource)) {}
    for (;;)
    {
      try
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        paramMessageForReplyText = paramRect;
        if ((localAppRuntime instanceof QQAppInterface)) {
          paramMessageForReplyText = localAppRuntime.getAccount();
        }
        paramRect = paramMessageForReplyText;
      }
      catch (Exception paramMessageForReplyText)
      {
        continue;
        i = 2;
        continue;
      }
      paramBoolean1 = OCRManager.a(BaseApplicationImpl.sApplication.getRuntime().getAccount(), 1);
      localBundle.putBoolean("extra.OCR", paramBoolean1);
      if (paramBoolean1)
      {
        paramMessageForReplyText = OCRManager.a(BaseApplicationImpl.sApplication.getRuntime().getAccount());
        if (!TextUtils.isEmpty(paramMessageForReplyText)) {
          localBundle.putString("extra.OCR_TEXT", paramMessageForReplyText);
        }
      }
      localBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
      localBundle.putString("uin", paramChatMessage.frienduin);
      try
      {
        paramMessageForReplyText = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(paramRect);
        if ((paramChatMessage instanceof MessageForFile))
        {
          if ((paramContext instanceof SplashActivity))
          {
            localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
            PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramRect, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage), AIOGalleryUtils.a(paramChatMessage, paramMessageForReplyText), -1, i);
            return;
          }
          if (((paramContext instanceof ChatHistoryActivity)) || ((paramContext instanceof ChatHistory))) {
            continue;
          }
          if ((paramContext instanceof PublicFragmentActivity))
          {
            if ((((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)) {
              i = 2;
            }
          }
          else if ((paramContext instanceof MultiForwardActivity))
          {
            i = 5;
            continue;
          }
        }
        else
        {
          localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
          PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramRect, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage), AIOGalleryUtils.a(paramChatMessage, paramMessageForReplyText), -1, paramSessionInfo.c);
          return;
        }
      }
      catch (AccountNotMatchException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      i = -1;
    }
  }
  
  public static void a(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, FileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    String str = a(paramContext, paramString1, paramString2, paramString3, paramString4);
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString2))) {
      if (paramTextView.getWidth() == 0) {
        paramTextView.post(new QFileUtils.2(paramContext, paramTextView, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean, paramTipsClickedInterface));
      }
    }
    while (TextUtils.isEmpty(str.replace(" ", "")))
    {
      return;
      b(paramContext, paramTextView, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean, paramTipsClickedInterface);
      return;
    }
    paramTextView.setText(paramString5 + str);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("detectType", paramInt2);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString1);
    paramString1 = null;
    paramIntent = null;
    paramInt2 = 0;
    switch (paramInt1)
    {
    default: 
      if (paramBoolean) {
        paramInt1 = 3;
      }
      break;
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.equals(paramString2, paramString6)) {
          continue;
        }
        paramString6 = paramString7;
        if (TextUtils.isEmpty(paramString4)) {
          continue;
        }
        int i = BaseDownloadProcessor.getPicDownloadPort();
        if (paramInt2 == 0) {
          continue;
        }
        paramString7 = "gchat.qpic.cn";
        if (TextUtils.isEmpty(paramString7)) {
          continue;
        }
        if (i == 80) {
          continue;
        }
        paramString1 = paramString7 + ":" + i + paramString4;
      }
      catch (Throwable paramString1)
      {
        continue;
        continue;
        paramString1 = null;
        continue;
        paramString1 = null;
        continue;
        paramString1 = null;
        continue;
      }
      localIntent.putExtra("report_params", ScannerUtils.a(paramString3, paramString1, paramString5, paramString2, paramString6, paramInt1));
      paramContext.startActivity(localIntent);
      return;
      if (paramBoolean)
      {
        paramInt1 = 4;
        paramString6 = paramIntent;
      }
      else
      {
        paramInt1 = 2;
        paramInt2 = 1;
        paramString6 = paramIntent;
        continue;
        paramInt1 = 1;
        continue;
        continue;
        paramString7 = "c2cpicdw.qpic.cn";
        continue;
        paramString1 = paramString7 + paramString4;
        continue;
        if (TextUtils.isEmpty(paramString5)) {
          continue;
        }
        switch (paramInt1)
        {
        case 2: 
          paramString1 = "gchat.qpic.cn/gchatpic_new";
          if (!TextUtils.isEmpty(paramString2)) {
            paramString1 = "gchat.qpic.cn/gchatpic_new" + "/" + paramString2;
          }
          if (paramString5.startsWith("/")) {
            paramString1 = paramString1 + "0-0-" + paramString5.replace(".jpg", "") + "/0";
          } else {
            paramString1 = paramString1 + "/0-0-" + paramString5.replace(".jpg", "") + "/0";
          }
          break;
        case 1: 
          paramString1 = "c2cpicdw.qpic.cn/offpic_new";
          if (!TextUtils.isEmpty(paramString2)) {
            paramString1 = "c2cpicdw.qpic.cn/offpic_new" + "/" + paramString2;
          }
          if (paramString5.startsWith("/")) {
            paramString1 = paramString1 + paramString5 + "/0";
          } else {
            paramString1 = paramString1 + "/" + paramString5 + "/0";
          }
          break;
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, IQRMenuItemController paramIQRMenuItemController)
  {
    if (!FileUtils.b(paramString)) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new QFileUtils.5(paramContext, paramString, paramIQRMenuItemController));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("preResult", paramString2);
    a(paramContext, Uri.parse("file://" + paramString1).getPath(), -1, false, null, paramString3, null, null, paramInt, null, null, localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity)
  {
    a(paramQQAppInterface, paramActivity, paramFileManagerEntity, false, null, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString, int paramInt)
  {
    if (NetworkUtil.a(paramActivity) == 0) {
      TroopFileError.a(paramActivity, paramActivity.getString(2131697610));
    }
    while (paramFileManagerEntity == null) {
      return;
    }
    paramQQAppInterface = a(paramQQAppInterface, paramFileManagerEntity);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramInt != -1))
    {
      paramQQAppInterface.putExtra("key_req", ForwardRecentActivity.f);
      paramQQAppInterface.putExtra("key_direct_show_uin_type", paramInt);
      paramQQAppInterface.putExtra("key_direct_show_uin", paramString);
    }
    ForwardBaseOption.a(paramActivity, paramQQAppInterface, ForwardRecentTranslucentActivity.class, 103);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt)
  {
    if (TroopFileTransferManager.a(paramQQAppInterface, paramLong1) == null) {}
    do
    {
      return;
      paramString2 = TroopFileUtils.a(paramQQAppInterface, paramLong1, paramString1, paramString2, paramString3, paramLong2, paramInt);
    } while (paramString2 == null);
    if (QFileAssistantUtils.a(paramQQAppInterface))
    {
      paramQQAppInterface = new QFileAssistantForwardManager(paramQQAppInterface);
      paramContext = FileManagerUtil.a(paramString2);
      paramContext.TroopUin = paramLong1;
      paramQQAppInterface.a(true);
      paramQQAppInterface.a(paramContext);
      return;
    }
    paramString1 = new Bundle();
    paramString1.putInt("dataline_forward_type", 100);
    if (FileUtils.b(paramString2.jdField_a_of_type_JavaLangString)) {
      paramString1.putString("dataline_forward_path", paramString2.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramQQAppInterface = (DataLineHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      paramString2 = new QFileUtils.9(paramContext);
      paramInt = paramQQAppInterface.a().b(AppConstants.DATALINE_PC_UIN, paramString1, paramString2);
      if ((paramString2.a) && (paramInt != 0)) {
        break;
      }
      DirectForwarder.b(paramContext, paramInt);
      return;
      paramString3 = FileManagerUtil.a(paramString2);
      paramString3.status = 2;
      paramString3.nOpType = 24;
      paramString3 = ForwardFileOption.a(paramString3);
      paramString3.d(1);
      paramString3.b(10006);
      paramString3.a(1);
      paramString3.a(paramLong1);
      if (paramString2.jdField_a_of_type_JavaUtilUUID != null) {
        paramString3.e(paramString2.jdField_a_of_type_JavaUtilUUID.toString());
      }
      paramString1.putParcelable("fileinfo", paramString3);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, long paramLong1, TroopFileStatusInfo paramTroopFileStatusInfo, String paramString, long paramLong2, int paramInt1, int paramInt2, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramChatMessage, paramLong1, paramTroopFileStatusInfo, paramString, paramLong2, paramInt1, paramInt2, paramRect, paramBoolean1, paramBoolean2, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, long paramLong1, TroopFileStatusInfo paramTroopFileStatusInfo, String paramString, long paramLong2, int paramInt1, int paramInt2, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramContext instanceof BasePluginActivity)) {}
    for (Object localObject = ((BasePluginActivity)paramContext).getOutActivity();; localObject = paramContext)
    {
      paramTroopFileStatusInfo = new TroopFileBrowserParams(paramQQAppInterface, (Context)localObject, paramLong1, paramTroopFileStatusInfo, paramInt1);
      Bundle localBundle = new Bundle();
      if (paramBoolean2)
      {
        paramInt1 = 106;
        localBundle.putInt("FromChatHistoryTab", 106);
        paramTroopFileStatusInfo.a(localBundle);
        paramTroopFileStatusInfo.a(paramLong2);
        paramTroopFileStatusInfo.a(paramString);
        paramTroopFileStatusInfo.a(paramSessionInfo);
        paramTroopFileStatusInfo.a(paramChatMessage);
        paramTroopFileStatusInfo.a(paramBoolean1);
        paramTroopFileStatusInfo.b(paramBoolean3);
        a(paramBoolean2, paramQQAppInterface, paramSessionInfo, paramTroopFileStatusInfo, (Context)localObject, paramInt2, paramRect, paramInt1, paramChatMessage);
        return;
      }
      if ((paramChatMessage == null) || (paramChatMessage.isMultiMsg)) {}
      for (boolean bool = true;; bool = false)
      {
        paramInt1 = a(paramContext, bool, localBundle, paramInt2);
        break;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, Rect paramRect, int paramInt1, int paramInt2, FileManagerEntity paramFileManagerEntity, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramQQAppInterface = new CommonFileBrowserParams(paramQQAppInterface, paramContext, paramFileManagerEntity, paramInt2);
    new Bundle();
    paramQQAppInterface.a(paramSessionInfo);
    paramQQAppInterface.a(paramChatMessage);
    paramQQAppInterface.a(paramBoolean1);
    paramQQAppInterface.b(paramBoolean2);
    paramQQAppInterface = new FileBrowserCreator(paramContext, paramQQAppInterface);
    paramQQAppInterface.a(paramInt1);
    paramQQAppInterface.a(paramRect);
    paramQQAppInterface.a(true);
    paramQQAppInterface.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    if (QFileAssistantUtils.a(paramQQAppInterface))
    {
      paramQQAppInterface = new QFileAssistantForwardManager(paramQQAppInterface);
      paramQQAppInterface.a(true);
      paramQQAppInterface.a(paramFileManagerEntity);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 0);
    localBundle.putBoolean("not_forward", true);
    localBundle.putInt("dataline_forward_type", 100);
    localBundle.putString("dataline_forward_path", paramFileManagerEntity.getFilePath());
    localBundle.putParcelable("fileinfo", ForwardFileOption.a(paramFileManagerEntity));
    a(paramQQAppInterface, localBundle, paramContext);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Bundle paramBundle, Context paramContext)
  {
    DataLineHandler localDataLineHandler = a(paramQQAppInterface, BusinessHandlerFactory.DATALINE_HANDLER);
    QFileUtils.8 local8 = new QFileUtils.8(paramContext);
    int i = localDataLineHandler.a().b(AppConstants.DATALINE_PC_UIN, paramBundle, local8);
    if ((!local8.a) || (i == 0))
    {
      DirectForwarder.b(paramContext, i);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800644B", "0X800644B", 0, 0, "6", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if ((paramMessageRecord1 == null) || (!FileManagerUtil.a(paramMessageRecord1))) {}
    int i;
    do
    {
      String str;
      do
      {
        do
        {
          return;
          str = paramMessageRecord2.getExtInfoFromExtStr("_m_ForwardFileType");
        } while (TextUtils.isEmpty(str));
        i = Integer.parseInt(str);
        paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
        str = paramMessageRecord2.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        paramMessageRecord2 = paramMessageRecord2.getExtInfoFromExtStr("_m_ForwardSenderUin");
        if (i != 1) {
          break;
        }
        paramMessageRecord1.istroop = 0;
      } while ((TextUtils.isEmpty(paramQQAppInterface)) || (TextUtils.isEmpty(str)) || (!paramQQAppInterface.equals(str)));
      paramMessageRecord1.frienduin = paramMessageRecord2;
      return;
    } while (i != 2);
    paramMessageRecord1.istroop = 3000;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, MessageRecord paramMessageRecord)
  {
    if (paramFileManagerEntity == null) {}
    int i;
    do
    {
      String str;
      do
      {
        do
        {
          return;
          str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType");
        } while (TextUtils.isEmpty(str));
        i = Integer.parseInt(str);
        paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
        str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSenderUin");
        if (i != 1) {
          break;
        }
        paramFileManagerEntity.peerType = 0;
      } while ((TextUtils.isEmpty(paramQQAppInterface)) || (TextUtils.isEmpty(str)) || (!paramQQAppInterface.equals(str)));
      paramFileManagerEntity.peerUin = paramMessageRecord;
      return;
    } while (i != 2);
    paramFileManagerEntity.peerType = 3000;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<TroopFileInfo> paramList, Activity paramActivity, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    while (paramLong == 0L) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    long l1 = 0L;
    if (paramList.hasNext())
    {
      TroopFileStatusInfo localTroopFileStatusInfo = a(paramQQAppInterface, paramLong, (TroopFileInfo)paramList.next());
      FileManagerEntity localFileManagerEntity = FileManagerUtil.a(localTroopFileStatusInfo);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.nOpType = 24;
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(localFileManagerEntity.nSessionId);
      localForwardFileInfo.b(10006);
      if (!TextUtils.isEmpty(localFileManagerEntity.getFilePath())) {
        localForwardFileInfo.a(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
      }
      localForwardFileInfo.d(localTroopFileStatusInfo.g);
      localForwardFileInfo.d(localTroopFileStatusInfo.jdField_c_of_type_Long);
      localForwardFileInfo.a(paramLong);
      if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null) {
        localForwardFileInfo.e(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString());
      }
      if (!TextUtils.isEmpty(localTroopFileStatusInfo.jdField_c_of_type_JavaLangString))
      {
        localForwardFileInfo.f(localTroopFileStatusInfo.jdField_c_of_type_JavaLangString);
        label209:
        localForwardFileInfo.d(1);
        localForwardFileInfo.a(3);
        if (!FileUtils.b(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) {
          break label295;
        }
        localArrayList2.add(Uri.parse(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString));
      }
      for (;;)
      {
        long l2 = localTroopFileStatusInfo.jdField_c_of_type_Long;
        localArrayList1.add(localForwardFileInfo);
        l1 = l2 + l1;
        break;
        if (TextUtils.isEmpty(localTroopFileStatusInfo.d)) {
          break label209;
        }
        localForwardFileInfo.f(localTroopFileStatusInfo.d);
        break label209;
        label295:
        localArrayList2.add(Uri.parse(""));
      }
    }
    paramQQAppInterface = new Bundle();
    paramList = new Intent();
    paramQQAppInterface.putInt("forward_type", 0);
    paramQQAppInterface.putParcelableArrayList("fileinfo_array", localArrayList1);
    paramQQAppInterface.putBoolean("not_forward", true);
    paramQQAppInterface.putBoolean("support_multi_forward", true);
    paramList.putExtra("sendMultiple", true);
    paramQQAppInterface.putParcelableArrayList("android.intent.extra.STREAM", localArrayList2);
    paramList.putExtras(paramQQAppInterface);
    paramList.putExtra("foward_editbar", true);
    paramList.putExtra("forward_type", 0);
    paramQQAppInterface = HardCodeUtil.a(2131709688);
    if (localArrayList1.size() == 1) {
      paramQQAppInterface = HardCodeUtil.a(2131709696) + FileManagerUtil.d(((ForwardFileInfo)localArrayList1.get(0)).d()) + HardCodeUtil.a(2131709697) + FileUtil.a(((ForwardFileInfo)localArrayList1.get(0)).d()) + "。";
    }
    for (;;)
    {
      paramList.putExtra("forward_text", paramQQAppInterface);
      paramList.putExtra("k_favorites", false);
      ForwardBaseOption.a(paramActivity, paramList, 103);
      return;
      if (localArrayList1.size() > 1) {
        paramQQAppInterface = HardCodeUtil.a(2131709692) + FileManagerUtil.d(((ForwardFileInfo)localArrayList1.get(0)).d()) + HardCodeUtil.a(2131709691) + localArrayList1.size() + HardCodeUtil.a(2131709694) + FileUtil.a(l1) + "。";
      }
    }
  }
  
  public static void a(boolean paramBoolean, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, TroopFileBrowserParams paramTroopFileBrowserParams, Context paramContext, int paramInt1, Rect paramRect, int paramInt2, ChatMessage paramChatMessage)
  {
    if ((paramBoolean) && ((ChatMessage)paramQQAppInterface.getMessageFacade().c(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramChatMessage.shmsgseq) == null)) {
      paramTroopFileBrowserParams.c(false);
    }
    paramSessionInfo = new FileBrowserCreator(paramContext, paramTroopFileBrowserParams);
    paramSessionInfo.a(paramInt1);
    if (paramRect != null) {
      paramSessionInfo.a(paramRect);
    }
    paramSessionInfo.a(TroopFileDetailBrowserActivity.class);
    paramSessionInfo.a(a(paramQQAppInterface));
    paramSessionInfo.b(a(paramQQAppInterface));
    a(paramInt1, paramInt2, paramSessionInfo);
  }
  
  public static boolean a()
  {
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    return (i == 2) || (i == 3);
  }
  
  public static boolean a(int paramInt1, int paramInt2, long paramLong)
  {
    if (paramInt1 * paramInt2 >= 350000000L) {}
    while ((Math.max(paramInt1, paramInt2) > 30000L) || (paramLong >= 31457280L)) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (!FileUtils.b(paramString)) {
      return false;
    }
    if (Build.VERSION.SDK_INT < 29) {
      return b(paramContext, paramString);
    }
    String str1 = FileManagerUtil.a(paramString);
    String str2 = MimeTypesTools.getMimeType(paramContext, str1);
    long l = ShortVideoUtils.getDuration(paramString);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("title", str1);
    localContentValues.put("_display_name", str1);
    localContentValues.put("description", str1);
    localContentValues.put("_display_name", str1);
    localContentValues.put("mime_type", str2);
    localContentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
    localContentValues.put("duration", Long.valueOf(l));
    return a(paramContext, paramString, paramContext.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, localContentValues));
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 6
    //   9: iconst_0
    //   10: istore 4
    //   12: aload_1
    //   13: invokestatic 793	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   16: ifne +10 -> 26
    //   19: iload 4
    //   21: istore 5
    //   23: iload 5
    //   25: ireturn
    //   26: iload 4
    //   28: istore 5
    //   30: aload_2
    //   31: ifnull -8 -> 23
    //   34: iconst_1
    //   35: istore 5
    //   37: aload_0
    //   38: invokevirtual 1374	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   41: aload_2
    //   42: ldc_w 1390
    //   45: invokevirtual 1394	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnonnull +64 -> 114
    //   53: iconst_0
    //   54: ifeq +11 -> 65
    //   57: new 1396	java/lang/NullPointerException
    //   60: dup
    //   61: invokespecial 1397	java/lang/NullPointerException:<init>	()V
    //   64: athrow
    //   65: iconst_0
    //   66: ifeq +11 -> 77
    //   69: new 1396	java/lang/NullPointerException
    //   72: dup
    //   73: invokespecial 1397	java/lang/NullPointerException:<init>	()V
    //   76: athrow
    //   77: iload 4
    //   79: istore 5
    //   81: aload_2
    //   82: ifnull -59 -> 23
    //   85: aload_2
    //   86: invokevirtual 1402	android/os/ParcelFileDescriptor:close	()V
    //   89: iconst_0
    //   90: ireturn
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   96: iconst_0
    //   97: ireturn
    //   98: astore_0
    //   99: aload_0
    //   100: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   103: goto -38 -> 65
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   111: goto -34 -> 77
    //   114: new 1404	java/io/FileOutputStream
    //   117: dup
    //   118: aload_2
    //   119: invokevirtual 1408	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   122: invokespecial 1411	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   125: astore 7
    //   127: new 1413	java/io/FileInputStream
    //   130: dup
    //   131: aload_1
    //   132: invokespecial 1414	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   135: astore_0
    //   136: invokestatic 1420	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   139: sipush 4096
    //   142: invokevirtual 1424	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   145: astore_1
    //   146: aload_0
    //   147: aload_1
    //   148: invokevirtual 1428	java/io/FileInputStream:read	([B)I
    //   151: istore_3
    //   152: iload_3
    //   153: iconst_m1
    //   154: if_icmpeq +70 -> 224
    //   157: aload 7
    //   159: aload_1
    //   160: iconst_0
    //   161: iload_3
    //   162: invokevirtual 1432	java/io/FileOutputStream:write	([BII)V
    //   165: goto -19 -> 146
    //   168: astore 8
    //   170: aload_0
    //   171: astore_1
    //   172: aload 7
    //   174: astore_0
    //   175: aload_1
    //   176: astore 7
    //   178: aload 8
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 1433	java/lang/Exception:printStackTrace	()V
    //   185: aload 7
    //   187: ifnull +8 -> 195
    //   190: aload 7
    //   192: invokevirtual 1434	java/io/FileInputStream:close	()V
    //   195: aload_0
    //   196: ifnull +7 -> 203
    //   199: aload_0
    //   200: invokevirtual 1435	java/io/FileOutputStream:close	()V
    //   203: iload 4
    //   205: istore 5
    //   207: aload_2
    //   208: ifnull -185 -> 23
    //   211: aload_2
    //   212: invokevirtual 1402	android/os/ParcelFileDescriptor:close	()V
    //   215: iconst_0
    //   216: ireturn
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   222: iconst_0
    //   223: ireturn
    //   224: invokestatic 1420	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   227: aload_1
    //   228: invokevirtual 1439	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   231: aload 7
    //   233: invokevirtual 1442	java/io/FileOutputStream:flush	()V
    //   236: iload 5
    //   238: istore 4
    //   240: aload_0
    //   241: ifnull +11 -> 252
    //   244: aload_0
    //   245: invokevirtual 1434	java/io/FileInputStream:close	()V
    //   248: iload 5
    //   250: istore 4
    //   252: aload 7
    //   254: ifnull +8 -> 262
    //   257: aload 7
    //   259: invokevirtual 1435	java/io/FileOutputStream:close	()V
    //   262: iload 4
    //   264: istore 5
    //   266: aload_2
    //   267: ifnull -244 -> 23
    //   270: aload_2
    //   271: invokevirtual 1402	android/os/ParcelFileDescriptor:close	()V
    //   274: iload 4
    //   276: ireturn
    //   277: astore_0
    //   278: aload_0
    //   279: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   282: iload 4
    //   284: ireturn
    //   285: astore_0
    //   286: aload_0
    //   287: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   290: iconst_0
    //   291: istore 4
    //   293: goto -41 -> 252
    //   296: astore_0
    //   297: aload_0
    //   298: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   301: iload 6
    //   303: istore 4
    //   305: goto -43 -> 262
    //   308: astore_1
    //   309: aload_1
    //   310: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   313: goto -118 -> 195
    //   316: astore_0
    //   317: aload_0
    //   318: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   321: goto -118 -> 203
    //   324: astore_0
    //   325: aconst_null
    //   326: astore_2
    //   327: aconst_null
    //   328: astore_1
    //   329: aload 9
    //   331: astore 8
    //   333: aload 8
    //   335: ifnull +8 -> 343
    //   338: aload 8
    //   340: invokevirtual 1434	java/io/FileInputStream:close	()V
    //   343: aload_1
    //   344: ifnull +7 -> 351
    //   347: aload_1
    //   348: invokevirtual 1435	java/io/FileOutputStream:close	()V
    //   351: aload_2
    //   352: ifnull +7 -> 359
    //   355: aload_2
    //   356: invokevirtual 1402	android/os/ParcelFileDescriptor:close	()V
    //   359: aload_0
    //   360: athrow
    //   361: astore 7
    //   363: aload 7
    //   365: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   368: goto -25 -> 343
    //   371: astore_1
    //   372: aload_1
    //   373: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   376: goto -25 -> 351
    //   379: astore_1
    //   380: aload_1
    //   381: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   384: goto -25 -> 359
    //   387: astore_0
    //   388: aconst_null
    //   389: astore_1
    //   390: aload 9
    //   392: astore 8
    //   394: goto -61 -> 333
    //   397: astore_0
    //   398: aload 9
    //   400: astore 8
    //   402: aload 7
    //   404: astore_1
    //   405: goto -72 -> 333
    //   408: astore_1
    //   409: aload_0
    //   410: astore 8
    //   412: aload_1
    //   413: astore_0
    //   414: aload 7
    //   416: astore_1
    //   417: goto -84 -> 333
    //   420: astore 8
    //   422: aload_0
    //   423: astore_1
    //   424: aload 8
    //   426: astore_0
    //   427: aload 7
    //   429: astore 8
    //   431: goto -98 -> 333
    //   434: astore_1
    //   435: aconst_null
    //   436: astore_2
    //   437: aconst_null
    //   438: astore_0
    //   439: aload 8
    //   441: astore 7
    //   443: goto -262 -> 181
    //   446: astore_1
    //   447: aconst_null
    //   448: astore_0
    //   449: aload 8
    //   451: astore 7
    //   453: goto -272 -> 181
    //   456: astore_1
    //   457: aload 7
    //   459: astore_0
    //   460: aload 8
    //   462: astore 7
    //   464: goto -283 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	paramContext	Context
    //   0	467	1	paramString	String
    //   0	467	2	paramUri	Uri
    //   151	11	3	i	int
    //   10	294	4	bool1	boolean
    //   21	244	5	bool2	boolean
    //   7	295	6	bool3	boolean
    //   125	133	7	localObject1	Object
    //   361	67	7	localIOException	IOException
    //   441	22	7	localObject2	Object
    //   4	1	8	localObject3	Object
    //   168	11	8	localException	Exception
    //   331	80	8	localObject4	Object
    //   420	5	8	localObject5	Object
    //   429	32	8	localObject6	Object
    //   1	398	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   85	89	91	java/io/IOException
    //   57	65	98	java/io/IOException
    //   69	77	106	java/io/IOException
    //   136	146	168	java/lang/Exception
    //   146	152	168	java/lang/Exception
    //   157	165	168	java/lang/Exception
    //   224	236	168	java/lang/Exception
    //   211	215	217	java/io/IOException
    //   270	274	277	java/io/IOException
    //   244	248	285	java/io/IOException
    //   257	262	296	java/io/IOException
    //   190	195	308	java/io/IOException
    //   199	203	316	java/io/IOException
    //   37	49	324	finally
    //   338	343	361	java/io/IOException
    //   347	351	371	java/io/IOException
    //   355	359	379	java/io/IOException
    //   114	127	387	finally
    //   127	136	397	finally
    //   136	146	408	finally
    //   146	152	408	finally
    //   157	165	408	finally
    //   224	236	408	finally
    //   181	185	420	finally
    //   37	49	434	java/lang/Exception
    //   114	127	446	java/lang/Exception
    //   127	136	456	java/lang/Exception
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, IFileWifiCheckCallback paramIFileWifiCheckCallback)
  {
    int j = 2;
    boolean bool1;
    if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      FMToastUtil.a(2131693237);
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      Activity localActivity = (Activity)paramContext;
      if (!paramBoolean) {
        break;
      }
      i = 3;
      bool2 = CUKingCardHelper.a(localActivity, i, new QFileUtils.3(paramIFileWifiCheckCallback), "");
      bool1 = bool2;
    } while (!bool2);
    paramContext = (Activity)paramContext;
    if (paramBoolean) {}
    for (int i = j;; i = 1)
    {
      return FreeWifiHelper.a(paramContext, i, new QFileUtils.4(paramIFileWifiCheckCallback));
      i = 2;
      break;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    int i = VipUtils.a(paramQQAppInterface, null);
    paramQQAppInterface = (IQFileConfigManager)paramQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
    if (i >> 8 == 2)
    {
      if (((i & 0xF) == 1) && (paramQQAppInterface.getTroopVideoFileYearSVIPSwitch())) {
        return true;
      }
      if (paramQQAppInterface.getTroopVideoFileSVIPSwitch()) {
        return true;
      }
    }
    else if (paramQQAppInterface.getTroopVideoFileSwitch())
    {
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.equals(((IQFileConfigManager)paramQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin());
    }
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (((!paramMessageRecord.isMultiMsg) && (!paramMessageRecord.isReplySource)) || (TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType")))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    int i;
    int j;
    if (paramFileManagerEntity != null)
    {
      i = paramFileManagerEntity.nOpType;
      j = paramFileManagerEntity.status;
    }
    return ((i != 21) && (i != 22) && (i != 24) && (i != 25) && (i != 28) && (i != 30)) || ((j != 0) && (j != 2));
  }
  
  /* Error */
  private static boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokevirtual 1502	java/io/File:isFile	()Z
    //   7: ifeq +12 -> 19
    //   10: aload_0
    //   11: invokevirtual 496	java/io/File:exists	()Z
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +43 -> 59
    //   19: iconst_0
    //   20: ifeq +11 -> 31
    //   23: new 1396	java/lang/NullPointerException
    //   26: dup
    //   27: invokespecial 1397	java/lang/NullPointerException:<init>	()V
    //   30: athrow
    //   31: iconst_0
    //   32: ifeq +11 -> 43
    //   35: new 1396	java/lang/NullPointerException
    //   38: dup
    //   39: invokespecial 1397	java/lang/NullPointerException:<init>	()V
    //   42: athrow
    //   43: iconst_0
    //   44: ireturn
    //   45: astore_0
    //   46: aload_0
    //   47: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   50: iconst_0
    //   51: ireturn
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   57: iconst_0
    //   58: ireturn
    //   59: new 1404	java/io/FileOutputStream
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 1505	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   67: astore 4
    //   69: new 1413	java/io/FileInputStream
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 1506	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   77: astore_0
    //   78: invokestatic 1420	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   81: sipush 4096
    //   84: invokevirtual 1424	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   87: astore_1
    //   88: aload_0
    //   89: aload_1
    //   90: invokevirtual 1428	java/io/FileInputStream:read	([B)I
    //   93: istore_2
    //   94: iload_2
    //   95: iconst_m1
    //   96: if_icmpeq +53 -> 149
    //   99: aload 4
    //   101: aload_1
    //   102: iconst_0
    //   103: iload_2
    //   104: invokevirtual 1432	java/io/FileOutputStream:write	([BII)V
    //   107: goto -19 -> 88
    //   110: astore 5
    //   112: aload 4
    //   114: astore_1
    //   115: aload 5
    //   117: astore 4
    //   119: aload 4
    //   121: invokevirtual 1433	java/lang/Exception:printStackTrace	()V
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 1434	java/io/FileInputStream:close	()V
    //   132: aload_1
    //   133: ifnull -90 -> 43
    //   136: aload_1
    //   137: invokevirtual 1435	java/io/FileOutputStream:close	()V
    //   140: iconst_0
    //   141: ireturn
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   147: iconst_0
    //   148: ireturn
    //   149: invokestatic 1420	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   152: aload_1
    //   153: invokevirtual 1439	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   156: aload 4
    //   158: invokevirtual 1442	java/io/FileOutputStream:flush	()V
    //   161: aload_0
    //   162: ifnull +7 -> 169
    //   165: aload_0
    //   166: invokevirtual 1434	java/io/FileInputStream:close	()V
    //   169: aload 4
    //   171: ifnull +8 -> 179
    //   174: aload 4
    //   176: invokevirtual 1435	java/io/FileOutputStream:close	()V
    //   179: iconst_1
    //   180: ireturn
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   186: iconst_0
    //   187: ireturn
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   193: iconst_0
    //   194: ireturn
    //   195: astore_0
    //   196: aload_0
    //   197: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   200: iconst_0
    //   201: ireturn
    //   202: astore_1
    //   203: aconst_null
    //   204: astore_0
    //   205: aconst_null
    //   206: astore 4
    //   208: aload_0
    //   209: ifnull +7 -> 216
    //   212: aload_0
    //   213: invokevirtual 1434	java/io/FileInputStream:close	()V
    //   216: aload 4
    //   218: ifnull +8 -> 226
    //   221: aload 4
    //   223: invokevirtual 1435	java/io/FileOutputStream:close	()V
    //   226: aload_1
    //   227: athrow
    //   228: astore_0
    //   229: aload_0
    //   230: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   233: iconst_0
    //   234: ireturn
    //   235: astore_0
    //   236: aload_0
    //   237: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   240: iconst_0
    //   241: ireturn
    //   242: astore_1
    //   243: aconst_null
    //   244: astore_0
    //   245: goto -37 -> 208
    //   248: astore_1
    //   249: goto -41 -> 208
    //   252: astore 5
    //   254: aload_1
    //   255: astore 4
    //   257: aload 5
    //   259: astore_1
    //   260: goto -52 -> 208
    //   263: astore 4
    //   265: aconst_null
    //   266: astore_0
    //   267: aload 5
    //   269: astore_1
    //   270: goto -151 -> 119
    //   273: astore 5
    //   275: aconst_null
    //   276: astore_0
    //   277: aload 4
    //   279: astore_1
    //   280: aload 5
    //   282: astore 4
    //   284: goto -165 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramFile1	File
    //   0	287	1	paramFile2	File
    //   93	11	2	i	int
    //   14	2	3	bool	boolean
    //   67	189	4	localObject1	Object
    //   263	15	4	localException1	Exception
    //   282	1	4	localException2	Exception
    //   1	1	5	localObject2	Object
    //   110	6	5	localException3	Exception
    //   252	16	5	localObject3	Object
    //   273	8	5	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   23	31	45	java/io/IOException
    //   35	43	52	java/io/IOException
    //   78	88	110	java/lang/Exception
    //   88	94	110	java/lang/Exception
    //   99	107	110	java/lang/Exception
    //   149	161	110	java/lang/Exception
    //   136	140	142	java/io/IOException
    //   165	169	181	java/io/IOException
    //   174	179	188	java/io/IOException
    //   128	132	195	java/io/IOException
    //   3	15	202	finally
    //   59	69	202	finally
    //   212	216	228	java/io/IOException
    //   221	226	235	java/io/IOException
    //   69	78	242	finally
    //   78	88	248	finally
    //   88	94	248	finally
    //   99	107	248	finally
    //   149	161	248	finally
    //   119	124	252	finally
    //   3	15	263	java/lang/Exception
    //   59	69	263	java/lang/Exception
    //   69	78	273	java/lang/Exception
  }
  
  public static boolean a(boolean paramBoolean, long paramLong, String paramString)
  {
    if (!NetworkUtil.d(BaseApplicationImpl.getContext())) {
      return false;
    }
    if (!FileManagerUtil.a())
    {
      QLog.i("QFileUtils", 1, "checkShowFlowDialog. do not show with Wi-Fi.");
      return false;
    }
    long l = ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize();
    ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogTime();
    QLog.i("QFileUtils", 1, "checkShowFlowDialog. fileSize[" + paramLong + "] limit[" + l + "]");
    if (paramLong < l) {
      return false;
    }
    if (paramBoolean)
    {
      QLog.i("QFileUtils", 1, "checkShowFlowDialog. download so show.");
      return true;
    }
    if (FileUtils.b(paramString))
    {
      QLog.i("QFileUtils", 1, "checkShowFlowDialog. is not local File do not show.");
      return false;
    }
    QLog.i("QFileUtils", 1, "checkShowFlowDialog. show flow dialog");
    return true;
  }
  
  public static int b()
  {
    int i = a();
    if (1 == i) {
      return 1;
    }
    if (3 == i) {
      return 2;
    }
    if (2 == i) {
      return 3;
    }
    return 0;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 8: 
    default: 
      return 10;
    case 0: 
      return 7;
    case 2: 
      return 8;
    case 4: 
      return 6;
    case 1: 
      return 9;
    case 10: 
      return 5;
    case 3: 
      return 1;
    case 6: 
      return 2;
    case 7: 
      return 3;
    }
    return 4;
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      paramInt2 = 4;
    }
    do
    {
      return paramInt2;
      if (paramInt1 == 3) {
        return 3;
      }
      if (paramInt1 == 0) {
        return 4;
      }
      if (paramInt1 == 2) {
        return 4;
      }
    } while (paramInt1 != 4);
    return 12;
  }
  
  public static int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      if (Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$").matcher(paramString).matches()) {
        return 1;
      }
      paramString = paramString.replaceAll("[\\[\\]]", "");
    } while ((TextUtils.isEmpty(paramString)) || (!IPAddressUtil.isIPv6LiteralAddress(paramString)));
    return 2;
  }
  
  public static String b(int paramInt, String paramString)
  {
    return paramInt + "@" + paramString;
  }
  
  public static String b(long paramLong)
  {
    float f;
    String str;
    if (paramLong > 1048576L)
    {
      f = (float)paramLong / 1048576.0F;
      str = new DecimalFormat("0.00").format(f);
      return HardCodeUtil.a(2131709690) + str + "MB/s";
    }
    if (paramLong > 1024L)
    {
      f = (float)paramLong / 1024.0F;
      str = new DecimalFormat("0.00").format(f);
      return HardCodeUtil.a(2131709689) + str + "KB/s";
    }
    return HardCodeUtil.a(2131709695) + paramLong + "KB/s";
  }
  
  public static void b(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, FileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    String str = a(paramContext, paramString1, paramString2, paramString3, paramString4);
    paramString2 = FileManagerUtil.a(paramTextView, 2, paramString5 + str, paramString2);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramContext = a(paramContext, paramString1, paramString2, paramString3, paramString4);
      paramContext = FileManagerUtil.a(paramTextView, paramString5 + paramContext);
      paramString1 = a(paramContext, paramString2, HardCodeUtil.a(2131709693));
      if (paramBoolean) {
        paramContext = a(paramContext, paramString1, paramTipsClickedInterface);
      }
    }
    for (;;)
    {
      if (QVipTroopFileProcessor.c().a())
      {
        paramString1 = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
        QVipTroopFileProcessor.c().a(paramContext, paramString4, paramString1);
      }
      if ((paramContext != null) && (paramContext.length() > 0))
      {
        paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
        paramTextView.setText(paramContext);
        paramTextView.setFocusable(false);
        paramTextView.setClickable(false);
        paramTextView.setLongClickable(false);
      }
      return;
      paramContext = new SpannableString(paramContext);
      continue;
      paramContext = null;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity)
  {
    b(paramQQAppInterface, paramActivity, paramFileManagerEntity, false, null, -1);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null)) {}
    while (paramFileManagerEntity == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    paramQQAppInterface.getFileManagerDataCenter().d(localFileManagerEntity);
    paramQQAppInterface = a(paramQQAppInterface, paramActivity, paramFileManagerEntity);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramInt != -1))
    {
      paramQQAppInterface.putExtra("key_req", ForwardRecentActivity.f);
      paramQQAppInterface.putExtra("key_direct_show_uin_type", paramInt);
      paramQQAppInterface.putExtra("key_direct_show_uin", paramString);
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      FMToastUtil.a(2131692602);
      return;
    }
    if (FileModel.a(localFileManagerEntity).a(false))
    {
      FMDialogUtil.a(paramActivity, 2131692609, 2131692614, new QFileUtils.6(paramActivity, paramQQAppInterface));
      return;
    }
    ForwardBaseOption.a(paramActivity, paramQQAppInterface, ForwardRecentTranslucentActivity.class, 103);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if ((paramMessageRecord1 == null) || (!FileManagerUtil.a(paramMessageRecord1))) {}
    while ((paramMessageRecord2 == null) || (!FileManagerUtil.a(paramMessageRecord2))) {
      return;
    }
    paramQQAppInterface.getFileManagerEngine().a().a(paramMessageRecord1, paramMessageRecord2);
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      QLog.e("QFileUtils", 1, "copyFileToMediaStore4LessArd10 file not exist.");
      return false;
    }
    String str1 = FileManagerUtil.a(paramString);
    int i = FileManagerUtil.a(str1);
    Object localObject;
    if (i == 0)
    {
      paramString = AppConstants.SDCARD_IMG_SAVE;
      localObject = new File(paramString);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
    }
    for (paramString = new File(paramString, str1);; paramString = new File(paramString, str1))
    {
      localObject = paramString.getAbsolutePath();
      if (a(localFile, paramString)) {
        break label179;
      }
      QLog.e("QFileUtils", 1, "copyFileToMediaStore4LessArd10 copyFile fail.");
      return false;
      if (i != 2) {
        break;
      }
      paramString = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
    }
    QLog.e("QFileUtils", 1, "copyFileToMediaStore4LessArd10 file not media file. filePath:" + paramString);
    return false;
    label179:
    paramString = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    String str2 = MimeTypesTools.getMimeType(paramContext, str1);
    int j = MediaStoreUtil.a((String)localObject);
    ContentValues localContentValues = new ContentValues(7);
    localContentValues.put("title", str1);
    localContentValues.put("_display_name", localFile.getName());
    localContentValues.put("date_modified", Long.valueOf(localFile.lastModified() / 1000L));
    localContentValues.put("mime_type", str2);
    localContentValues.put("_data", (String)localObject);
    localContentValues.put("_size", Long.valueOf(localFile.length()));
    if (i == 0)
    {
      localContentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
      localContentValues.put("orientation", Integer.valueOf(j));
    }
    for (;;)
    {
      paramContext.getContentResolver().insert(paramString, localContentValues);
      ImageUtil.a(paramContext, (String)localObject);
      return true;
      if (i == 2)
      {
        long l = ShortVideoUtils.getDuration((String)localObject);
        localContentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        localContentValues.put("duration", Long.valueOf(l));
        paramString = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
      }
    }
  }
  
  public static boolean b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    while ((6 != paramFileManagerEntity.getCloudType()) || (FileUtil.b(paramFileManagerEntity.getFilePath()))) {
      return false;
    }
    return true;
  }
  
  public static int c()
  {
    int i = MsfServiceSdk.get().getConnectedIPFamily();
    if (2 == i) {
      return 2;
    }
    if (1 == i) {
      return 1;
    }
    return 0;
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 8: 
    default: 
      return 6;
    case 3: 
      return 1;
    case 6: 
      return 3;
    case 7: 
      return 2;
    case 9: 
      return 4;
    }
    return 5;
  }
  
  public static int c(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt2 == 7)
    {
      paramInt1 = 3;
      return paramInt1;
    }
    if ((paramInt2 == 1) || (paramInt2 == 3)) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      if (paramInt1 != 1) {
        break label42;
      }
      paramInt1 = i;
      if (paramInt2 == 0) {
        break;
      }
      return 2;
    }
    label42:
    if (paramInt1 == 3)
    {
      if (paramInt2 != 0) {
        return 5;
      }
      return 4;
    }
    return 0;
  }
  
  public static int c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = b(new URL(paramString).getHost());
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    if (FileManagerUtil.a(paramString) <= 10485760L) {
      return true;
    }
    FMDialogUtil.a(paramContext, "", 2131698169, new QFileUtils.7(paramContext, paramString));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QFileUtils
 * JD-Core Version:    0.7.0.1
 */