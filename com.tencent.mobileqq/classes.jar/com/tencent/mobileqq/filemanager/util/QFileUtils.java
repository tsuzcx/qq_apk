package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;
import com.dataline.util.file.MediaStoreUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
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
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
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
import com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam;
import com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.recreate.IFModel;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.troopgag.data.TroopGagInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QFileUtils
{
  public static int a()
  {
    return QQFileUtils.a();
  }
  
  public static int a(int paramInt)
  {
    if (paramInt != 13) {
      switch (paramInt)
      {
      default: 
        return -1;
      case 5: 
      case 6: 
        return 3000;
      case 1: 
      case 2: 
        return 0;
      }
    }
    return 1;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return QQFileUtils.a(paramInt1, paramInt2);
  }
  
  public static int a(Context paramContext, boolean paramBoolean, Bundle paramBundle, int paramInt)
  {
    if ((paramInt != 3) && (paramInt != 1)) {
      return 0;
    }
    paramInt = ChatHistoryActivity.a(paramContext);
    paramBundle.putInt("FromChatHistoryTab", paramInt);
    paramBundle.putBoolean("file_location_pos_entrance_multiseq", paramBoolean);
    return paramInt;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    int i = 4;
    if (paramInt == 0) {}
    do
    {
      return 1;
      if (paramInt == 3000) {
        return 101;
      }
    } while (paramInt != 1);
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
    paramInt = i;
    if (paramQQAppInterface != null)
    {
      paramInt = i;
      if (paramQQAppInterface.isNewTroop) {
        paramInt = 113;
      }
    }
    return paramInt;
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    paramString = paramString.split("@");
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = paramString[0];
      if (!TextUtils.isEmpty(paramString)) {
        return Integer.parseInt(paramString);
      }
    }
    return -1;
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
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(HardCodeUtil.a(2131709679));
    paramQQAppInterface.append(FileManagerUtil.c(paramFileManagerEntity.fileName));
    paramQQAppInterface.append(HardCodeUtil.a(2131709691));
    paramQQAppInterface.append(FileUtil.a(paramFileManagerEntity.fileSize));
    paramQQAppInterface.append("。");
    paramActivity.putExtra("forward_text", paramQQAppInterface.toString());
    paramActivity.putExtra("k_favorites", FileManagerUtil.d(paramFileManagerEntity));
    if ((!FileUtil.a(paramFileManagerEntity.getFilePath())) && ((paramFileManagerEntity.getCloudType() == 6) || (paramFileManagerEntity.getCloudType() == 7)) && (paramFileManagerEntity.nFileType == 0)) {
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
    else
    {
      if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null) {
        localForwardFileInfo.e(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString());
      }
      localForwardFileInfo.b(10006);
      localForwardFileInfo.d(4);
    }
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
  
  public static DataLineHandler a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return (DataLineHandler)paramQQAppInterface.getBusinessHandler(paramString);
  }
  
  static IOCRService a()
  {
    return (IOCRService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOCRService.class, "");
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("@");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(long paramLong)
  {
    if (paramLong <= 0L) {
      return "00:00:00";
    }
    paramLong /= 1000L;
    long l = paramLong / 3600L;
    if (l > 9L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("");
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(l);
    }
    String str1 = ((StringBuilder)localObject).toString();
    paramLong %= 3600L;
    l = paramLong / 60L;
    if (l > 9L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("");
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(l);
    }
    String str2 = ((StringBuilder)localObject).toString();
    paramLong %= 60L;
    if (paramLong > 9L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("");
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramLong);
    }
    Object localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(":");
    localStringBuilder.append(str2);
    localStringBuilder.append(":");
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public static String a(long paramLong, int paramInt, String paramString)
  {
    if (paramInt == 128)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Thumb]");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("-");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    if (paramInt == 383)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Thumb]320");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("-");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Thumb]");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(paramLong);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, TextView paramTextView1, TextView paramTextView2, String paramString1, String paramString2)
  {
    return QQFileUtils.a(paramContext, paramInt1, paramInt2, paramTextView1, paramTextView2, paramString1, paramString2);
  }
  
  public static String a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return "";
    }
    Object localObject = new File(FMSettings.a().getDefaultRecvPath());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FMSettings.a().getDefaultRecvPath());
    ((StringBuilder)localObject).append(".video_frame/");
    localObject = new File(((StringBuilder)localObject).toString());
    FileUtils.deleteDirectory(((File)localObject).getAbsolutePath());
    ((File)localObject).mkdirs();
    localObject = ((File)localObject).getAbsolutePath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".jpg");
    localObject = new File((String)localObject, localStringBuilder.toString());
    try
    {
      ImageUtil.a(paramBitmap, (File)localObject);
      paramBitmap = ((File)localObject).getAbsolutePath();
      return paramBitmap;
    }
    catch (IOException paramBitmap)
    {
      paramBitmap.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[saveBitmapFileAsJPEG] error. ");
      ((StringBuilder)localObject).append(paramBitmap.getMessage());
      QLog.i("QFileUtils<QFile>", 1, ((StringBuilder)localObject).toString());
    }
    return "";
  }
  
  private static String a(AppInterface paramAppInterface, MessageForFile paramMessageForFile)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select * from ");
    ((StringBuilder)localObject1).append(FileManagerEntity.tableName());
    ((StringBuilder)localObject1).append(" where  uniseq = ");
    ((StringBuilder)localObject1).append(paramMessageForFile.uniseq);
    localObject1 = ((StringBuilder)localObject1).toString();
    paramAppInterface = paramAppInterface.getEntityManagerFactory().createEntityManager().rawQuery(FileManagerEntity.class, (String)localObject1, null);
    if (paramAppInterface == null) {
      return null;
    }
    localObject1 = (FileManagerEntity)paramAppInterface.get(0);
    paramAppInterface = ((FileManagerEntity)localObject1).getFilePath();
    if (FileManagerUtil.a(paramAppInterface))
    {
      if (QLog.isDebugVersion())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("find file[");
        ((StringBuilder)localObject1).append(paramAppInterface);
        ((StringBuilder)localObject1).append("] for msg:");
        ((StringBuilder)localObject1).append(paramMessageForFile.uniseq);
        QLog.i("FileClean", 1, ((StringBuilder)localObject1).toString());
      }
      return paramAppInterface;
    }
    Object localObject2 = FMSettings.a().getDefaultTmpPath();
    if (((FileManagerEntity)localObject1).Uuid != null)
    {
      Object localObject3 = com.tencent.qphone.base.util.MD5.toMD5(((FileManagerEntity)localObject1).Uuid);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append((String)localObject3);
      localObject3 = localStringBuilder.toString();
      if (FileManagerUtil.a((String)localObject3))
      {
        if (QLog.isDebugVersion())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("find tmp file[");
          ((StringBuilder)localObject1).append(paramAppInterface);
          ((StringBuilder)localObject1).append("] for msg:");
          ((StringBuilder)localObject1).append(paramMessageForFile.uniseq);
          QLog.i("FileClean", 1, ((StringBuilder)localObject1).toString());
        }
        return localObject3;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("dsc-");
      ((StringBuilder)localObject3).append(String.valueOf(((FileManagerEntity)localObject1).Uuid.replace("/", "")));
      localObject1 = ((StringBuilder)localObject3).toString();
      if (FileManagerUtil.a((String)localObject1))
      {
        if (QLog.isDebugVersion())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("find tmp file[");
          ((StringBuilder)localObject2).append(paramAppInterface);
          ((StringBuilder)localObject2).append("] for msg:");
          ((StringBuilder)localObject2).append(paramMessageForFile.uniseq);
          QLog.i("FileClean", 1, ((StringBuilder)localObject2).toString());
        }
        return localObject1;
      }
    }
    return null;
  }
  
  private static String a(AppInterface paramAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    String str = AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH;
    Object localObject1 = new TroopFileTansferItemEntity();
    ((TroopFileTansferItemEntity)localObject1).troopuin = Long.parseLong(paramMessageForTroopFile.frienduin);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select * from ");
    ((StringBuilder)localObject2).append(((TroopFileTansferItemEntity)localObject1).getTableName());
    ((StringBuilder)localObject2).append(" where troopuin = ? and _sId = ?");
    localObject2 = ((StringBuilder)localObject2).toString();
    paramAppInterface = paramAppInterface.getEntityManagerFactory().createEntityManager();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(((TroopFileTansferItemEntity)localObject1).troopuin);
    paramAppInterface = paramAppInterface.rawQuery(TroopFileTansferItemEntity.class, (String)localObject2, new String[] { localStringBuilder.toString(), SecurityUtile.encode(paramMessageForTroopFile.uuid) });
    if (paramAppInterface == null)
    {
      if (QLog.isDebugVersion())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("find troop file result is null, for msg:");
        paramAppInterface.append(paramMessageForTroopFile.uniseq);
        QLog.i("FileClean", 1, paramAppInterface.toString());
      }
      return null;
    }
    localObject1 = paramAppInterface.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramAppInterface = (TroopFileTansferItemEntity)((Iterator)localObject1).next();
      if (paramAppInterface.Id.equals(UUID.fromString(paramMessageForTroopFile.uuid)))
      {
        localObject1 = paramAppInterface.LocalFile;
        paramAppInterface = paramAppInterface.FilePath;
        break label243;
      }
    }
    localObject1 = null;
    paramAppInterface = (AppInterface)localObject1;
    label243:
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (FileManagerUtil.a((String)localObject1)))
    {
      if (QLog.isDebugVersion())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("find troop file[");
        paramAppInterface.append((String)localObject1);
        paramAppInterface.append("] for msg:");
        paramAppInterface.append(paramMessageForTroopFile.uniseq);
        QLog.i("FileClean", 1, paramAppInterface.toString());
      }
      return localObject1;
    }
    if (TextUtils.isEmpty(paramAppInterface))
    {
      if (QLog.isDebugVersion())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("find troop file but filePath is null, for msg:");
        paramAppInterface.append(paramMessageForTroopFile.uniseq);
        QLog.i("FileClean", 1, paramAppInterface.toString());
      }
      return null;
    }
    localObject1 = com.tencent.qphone.base.util.MD5.toMD5(paramAppInterface);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(HexUtil.bytes2HexStr(paramAppInterface.getBytes()));
    ((StringBuilder)localObject2).append(".tmp");
    str = ((StringBuilder)localObject2).toString();
    if (FileUtil.a(str) > 0L) {
      localObject1 = str;
    }
    if (FileManagerUtil.a((String)localObject1))
    {
      if (QLog.isDebugVersion())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("find tmp file[");
        paramAppInterface.append((String)localObject1);
        paramAppInterface.append("] for msg:");
        paramAppInterface.append(paramMessageForTroopFile.uniseq);
        QLog.i("FileClean", 1, paramAppInterface.toString());
      }
      return localObject1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(FMSettings.a().getDefaultTmpPath());
    ((StringBuilder)localObject1).append(com.tencent.securitysdk.utils.MD5.a(paramAppInterface));
    paramAppInterface = ((StringBuilder)localObject1).toString();
    if (FileManagerUtil.a(paramAppInterface))
    {
      if (QLog.isDebugVersion())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("find tmp2 file[");
        ((StringBuilder)localObject1).append(paramAppInterface);
        ((StringBuilder)localObject1).append("] for msg:");
        ((StringBuilder)localObject1).append(paramMessageForTroopFile.uniseq);
        QLog.i("FileClean", 1, ((StringBuilder)localObject1).toString());
      }
      return paramAppInterface;
    }
    return null;
  }
  
  public static String a(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileClean", 1, "queryFilePathForMessage, msg is null");
      }
      return null;
    }
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
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("queryFilePathForMessage, msg is :");
      paramAppInterface.append(paramMessageRecord.msgtype);
      QLog.i("FileClean", 1, paramAppInterface.toString());
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    Object localObject = (TroopGagMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
    if (localObject != null)
    {
      if (((TroopGagMgr)localObject).a(String.valueOf(paramLong1), String.valueOf(paramLong2))) {
        return HardCodeUtil.a(2131709680);
      }
      localObject = ((TroopGagMgr)localObject).a(String.valueOf(paramLong1));
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((localObject != null) && (((TroopGagInfo)localObject).jdField_a_of_type_Long != 0L))
      {
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.b(String.valueOf(paramLong1));
          if ((paramQQAppInterface != null) && ((paramQQAppInterface.isTroopOwner(String.valueOf(paramLong2))) || (paramQQAppInterface.isTroopAdmin(String.valueOf(paramLong2))))) {
            return "";
          }
        }
        return HardCodeUtil.a(2131709692);
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
    localStringBuilder.append("mrUniseq[");
    localStringBuilder.append(paramMessageRecord.uniseq);
    localStringBuilder.append("] ");
    localStringBuilder.append("mrSeq[");
    localStringBuilder.append(paramMessageRecord.msgseq);
    localStringBuilder.append("] ");
    localStringBuilder.append("mrUid[");
    localStringBuilder.append(paramMessageRecord.msgUid);
    localStringBuilder.append("] ");
    if (paramBoolean) {
      if ((paramMessageRecord instanceof MessageForFile))
      {
        paramQQAppInterface = paramQQAppInterface.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if (paramQQAppInterface != null)
        {
          localStringBuilder.append("offFileName[");
          localStringBuilder.append(paramQQAppInterface.fileName);
          localStringBuilder.append("] ");
          localStringBuilder.append("offFileUuid[");
          localStringBuilder.append(paramQQAppInterface.Uuid);
          localStringBuilder.append("] ");
        }
      }
      else if ((paramMessageRecord instanceof MessageForTroopFile))
      {
        paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord);
        if (paramQQAppInterface != null)
        {
          localStringBuilder.append("troopFileName[");
          localStringBuilder.append(paramQQAppInterface.g);
          localStringBuilder.append("] ");
          localStringBuilder.append("troopFileId");
          localStringBuilder.append(paramQQAppInterface.e);
          localStringBuilder.append("] ");
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
      return "";
    }
    if (FileManagerUtil.a(paramString) > 3145728L) {
      QLog.i("<QFile>", 1, "copyFileToQFileFolder: source file is too big. copy failed");
    }
    String str = FMSettings.a().getDefaultRecvPath();
    Object localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    localObject = FileManagerUtil.a(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("_");
    localStringBuilder.append((String)localObject);
    str = localStringBuilder.toString();
    if (FileUtils.copyFile(paramString, str)) {
      return str;
    }
    return "";
  }
  
  public static void a(int paramInt1, int paramInt2, FileBrowserCreator paramFileBrowserCreator)
  {
    if ((paramInt2 != 1) && ((paramInt2 != 3) || (paramInt1 != 1)))
    {
      paramFileBrowserCreator.a();
      return;
    }
    paramFileBrowserCreator.c(38);
  }
  
  public static void a(Context paramContext, Rect paramRect, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramRect, paramChatMessage, paramSessionInfo, paramBoolean1, paramBoolean2, false, null);
  }
  
  public static void a(Context paramContext, Rect paramRect, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, MessageForReplyText paramMessageForReplyText)
  {
    Bundle localBundle = new Bundle();
    if (paramRect != null) {
      localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramRect);
    }
    localBundle.putBoolean("muate_play", paramBoolean1);
    localBundle.putBoolean("is_one_item", paramBoolean2);
    localBundle.putBoolean(PeakUtils.jdField_a_of_type_JavaLangString, paramBoolean3);
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.b);
    }
    localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    i = paramSessionInfo.jdField_a_of_type_Int;
    int j = 2;
    if ((i == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramChatMessage.isMultiMsg);
    if (paramMessageForReplyText != null) {
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
    }
    localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramChatMessage.isMultiMsg);
    localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
    paramMessageForReplyText = paramChatMessage.selfuin;
    if (!paramChatMessage.isMultiMsg)
    {
      paramRect = paramMessageForReplyText;
      if (!paramChatMessage.isReplySource) {
        break label238;
      }
    }
    try
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramRect = paramMessageForReplyText;
      if ((localAppRuntime instanceof QQAppInterface)) {
        paramRect = localAppRuntime.getAccount();
      }
    }
    catch (Exception paramRect)
    {
      for (;;)
      {
        label238:
        paramRect = paramMessageForReplyText;
        continue;
        i = -1;
      }
    }
    paramMessageForReplyText = a();
    paramBoolean1 = paramMessageForReplyText.isSupportOcr(BaseApplicationImpl.sApplication.getRuntime().getAccount(), 1);
    localBundle.putBoolean("extra.OCR", paramBoolean1);
    if (paramBoolean1)
    {
      paramMessageForReplyText = paramMessageForReplyText.getAIOText(BaseApplicationImpl.sApplication.getRuntime().getAccount());
      if (!TextUtils.isEmpty(paramMessageForReplyText)) {
        localBundle.putString("extra.OCR_TEXT", paramMessageForReplyText);
      }
    }
    localBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
    localBundle.putString("uin", paramChatMessage.frienduin);
    try
    {
      paramMessageForReplyText = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(paramRect);
      paramBoolean1 = paramChatMessage instanceof MessageForFile;
      if (paramBoolean1)
      {
        if ((paramContext instanceof SplashActivity))
        {
          i = 1;
        }
        else
        {
          i = j;
          if (!(paramContext instanceof ChatHistoryActivity)) {
            if ((paramContext instanceof ChatHistory))
            {
              i = j;
            }
            else if ((paramContext instanceof PublicFragmentActivity))
            {
              if (!(((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)) {
                break label537;
              }
              i = j;
            }
            else
            {
              if (!(paramContext instanceof MultiForwardActivity)) {
                break label537;
              }
              i = 5;
            }
          }
        }
        localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramRect, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage), AIOGalleryUtils.a(paramChatMessage, paramMessageForReplyText), -1, i);
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
  }
  
  public static void a(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, QQFileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    QQFileUtils.a(paramContext, paramTextView, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean, paramTipsClickedInterface);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, Intent paramIntent)
  {
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    paramIntent.putExtra("detectType", paramInt2);
    paramIntent.putExtra("fromPicQRDecode", true);
    paramInt2 = 0;
    Object localObject = null;
    if ((paramInt1 != 1) && (paramInt1 != 3000))
    {
      if (paramBoolean) {
        paramInt1 = 3;
      } else {
        paramInt1 = 1;
      }
      try
      {
        if (!TextUtils.equals(paramString2, paramString6)) {
          break label622;
        }
        paramString6 = paramString7;
      }
      catch (Throwable paramString1)
      {
        label120:
        for (;;)
        {
          int i;
        }
      }
      if (!TextUtils.isEmpty(paramString4))
      {
        i = BaseDownloadProcessor.getPicDownloadPort();
        if (paramInt2 == 0) {
          break label648;
        }
        paramString7 = "gchat.qpic.cn";
        paramString1 = localObject;
        if (TextUtils.isEmpty(paramString7)) {
          break label659;
        }
        if (i != 80)
        {
          paramString1 = new StringBuilder();
          paramString1.append(paramString7);
          paramString1.append(":");
          paramString1.append(i);
          paramString1.append(paramString4);
          paramString1 = paramString1.toString();
          break label659;
        }
        paramString1 = new StringBuilder();
        paramString1.append(paramString7);
        paramString1.append(paramString4);
        paramString1 = paramString1.toString();
        break label659;
      }
      paramBoolean = TextUtils.isEmpty(paramString5);
      paramString1 = localObject;
      if (paramBoolean) {
        break label659;
      }
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          paramString1 = localObject;
          break label659;
        }
        paramString1 = "gchat.qpic.cn/gchatpic_new";
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1 = new StringBuilder();
          paramString1.append("gchat.qpic.cn/gchatpic_new");
          paramString1.append("/");
          paramString1.append(paramString2);
          paramString1 = paramString1.toString();
        }
        paramBoolean = paramString5.startsWith("/");
        if (paramBoolean)
        {
          paramString4 = new StringBuilder();
          paramString4.append(paramString1);
          paramString4.append("0-0-");
          paramString4.append(paramString5.replace(".jpg", ""));
          paramString4.append("/0");
          paramString1 = paramString4.toString();
          break label656;
        }
        paramString4 = new StringBuilder();
        paramString4.append(paramString1);
        paramString4.append("/0-0-");
        paramString4.append(paramString5.replace(".jpg", ""));
        paramString4.append("/0");
        paramString1 = paramString4.toString();
        break label656;
      }
      paramString1 = "c2cpicdw.qpic.cn/offpic_new";
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = new StringBuilder();
        paramString1.append("c2cpicdw.qpic.cn/offpic_new");
        paramString1.append("/");
        paramString1.append(paramString2);
        paramString1 = paramString1.toString();
      }
      if (paramString5.startsWith("/"))
      {
        paramString4 = new StringBuilder();
        paramString4.append(paramString1);
        paramString4.append(paramString5);
        paramString4.append("/0");
        paramString1 = paramString4.toString();
        break label656;
      }
      paramString4 = new StringBuilder();
      paramString4.append(paramString1);
      paramString4.append("/");
      paramString4.append(paramString5);
      paramString4.append("/0");
      paramString1 = paramString4.toString();
      break label656;
    }
    label648:
    label656:
    label659:
    for (;;)
    {
      paramIntent.putExtra("report_params", ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(paramString3, paramString1, paramString5, paramString2, paramString6, paramInt1));
      RouteUtils.a(paramContext, paramIntent, "/qrscan/scanner");
      return;
      label622:
      if (paramBoolean)
      {
        paramString6 = null;
        paramInt1 = 4;
        break;
      }
      paramString6 = null;
      paramInt2 = 1;
      paramInt1 = 2;
      break;
      paramString7 = "c2cpicdw.qpic.cn";
      break label120;
    }
  }
  
  public static void a(Context paramContext, String paramString, IQRMenuItemController paramIQRMenuItemController)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new QFileUtils.3(paramContext, paramString, paramIQRMenuItemController));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("preResult", paramString2);
    paramString2 = new StringBuilder();
    paramString2.append("file://");
    paramString2.append(paramString1);
    a(paramContext, Uri.parse(paramString2.toString()).getPath(), -1, false, null, paramString3, null, null, paramInt, null, null, localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity)
  {
    a(paramQQAppInterface, paramActivity, paramFileManagerEntity, false, null, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString, int paramInt)
  {
    if (NetworkUtil.getSystemNetwork(paramActivity) == 0)
    {
      TroopFileError.a(paramActivity, paramActivity.getString(2131697616));
      return;
    }
    if (paramFileManagerEntity == null) {
      return;
    }
    paramQQAppInterface = a(paramQQAppInterface, paramFileManagerEntity);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramInt != -1))
    {
      paramQQAppInterface.putExtra("key_req", 1);
      paramQQAppInterface.putExtra("key_direct_show_uin_type", paramInt);
      paramQQAppInterface.putExtra("key_direct_show_uin", paramString);
    }
    ForwardBaseOption.a(paramActivity, paramQQAppInterface, ForwardRecentTranslucentActivity.class, 103);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt)
  {
    if (TroopFileTransferManager.a(paramQQAppInterface, paramLong1) == null) {
      return;
    }
    paramString2 = TroopFileUtils.a(paramQQAppInterface, paramLong1, paramString1, paramString2, paramString3, paramLong2, paramInt);
    if (paramString2 == null) {
      return;
    }
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
    if (FileUtils.fileExistsAndNotEmpty(paramString2.jdField_a_of_type_JavaLangString))
    {
      paramString1.putString("dataline_forward_path", paramString2.jdField_a_of_type_JavaLangString);
    }
    else
    {
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
    paramQQAppInterface = (DataLineHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    paramString2 = new QFileUtils.6(paramContext);
    paramInt = paramQQAppInterface.a().b(AppConstants.DATALINE_PC_UIN, paramString1, paramString2);
    if ((!paramString2.a) || (paramInt == 0)) {
      DirectForwarder.b(paramContext, paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, long paramLong1, TroopFileStatusInfo paramTroopFileStatusInfo, String paramString, long paramLong2, int paramInt1, int paramInt2, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramChatMessage, paramLong1, paramTroopFileStatusInfo, paramString, paramLong2, paramInt1, paramInt2, paramRect, paramBoolean1, paramBoolean2, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, long paramLong1, TroopFileStatusInfo paramTroopFileStatusInfo, String paramString, long paramLong2, int paramInt1, int paramInt2, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject;
    if ((paramContext instanceof BasePluginActivity)) {
      localObject = ((BasePluginActivity)paramContext).getOutActivity();
    } else {
      localObject = paramContext;
    }
    paramTroopFileStatusInfo = new TroopFileBrowserParams(paramQQAppInterface, (Context)localObject, paramLong1, paramTroopFileStatusInfo, paramInt1);
    Bundle localBundle = new Bundle();
    if (paramBoolean2)
    {
      localBundle.putInt("FromChatHistoryTab", 106);
      paramInt1 = 106;
    }
    else
    {
      boolean bool;
      if ((paramChatMessage != null) && (!paramChatMessage.isMultiMsg)) {
        bool = false;
      } else {
        bool = true;
      }
      paramInt1 = a(paramContext, bool, localBundle, paramInt2);
    }
    if (paramTroopFileStatusInfo.a() == null) {
      return;
    }
    paramTroopFileStatusInfo.a(localBundle);
    paramTroopFileStatusInfo.a(paramLong2);
    paramTroopFileStatusInfo.a(paramString);
    paramTroopFileStatusInfo.a(paramSessionInfo);
    paramTroopFileStatusInfo.a(paramChatMessage);
    paramTroopFileStatusInfo.a(paramBoolean1);
    paramTroopFileStatusInfo.b(paramBoolean3);
    a(paramBoolean2, paramQQAppInterface, paramSessionInfo, paramTroopFileStatusInfo, (Context)localObject, paramInt2, paramRect, paramInt1, paramChatMessage);
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
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ChatMessage paramChatMessage, TroopFileStatusInfo paramTroopFileStatusInfo, String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    paramTroopFileStatusInfo = FileManagerUtil.a(paramTroopFileStatusInfo);
    if (!TextUtils.isEmpty(paramString)) {
      paramTroopFileStatusInfo.selfUin = paramString;
    }
    if (paramLong != 0L) {
      paramTroopFileStatusInfo.lastTime = paramLong;
    }
    paramTroopFileStatusInfo.bSend = paramQQAppInterface.getAccount().equals(paramTroopFileStatusInfo.selfUin);
    paramString = new Bundle();
    int i;
    if (paramBoolean)
    {
      i = 106;
      paramString.putInt("FromChatHistoryTab", 106);
    }
    else
    {
      i = ChatHistoryActivity.a(paramContext);
      if ((paramInt == 3) || (paramInt == 1))
      {
        paramString.putInt("FromChatHistoryTab", i);
        if ((paramChatMessage != null) && (!paramChatMessage.isMultiMsg)) {
          paramBoolean = false;
        } else {
          paramBoolean = true;
        }
        paramString.putBoolean("file_location_pos_entrance_multiseq", paramBoolean);
      }
    }
    if (paramLong != 0L) {
      paramString.putLong("last_time", paramLong);
    }
    paramQQAppInterface = new FileModelAdapter(paramQQAppInterface, paramTroopFileStatusInfo, 2);
    paramQQAppInterface.a(paramString);
    paramChatMessage = new FileBrowserParam().a(paramInt);
    if ((i != 1) && ((i != 3) || (paramInt != 1)))
    {
      ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(paramContext, paramQQAppInterface, paramChatMessage);
      return;
    }
    ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile((Activity)paramContext, 38, paramQQAppInterface, paramChatMessage);
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
    QFileUtils.5 local5 = new QFileUtils.5(paramContext);
    int i = localDataLineHandler.a().b(AppConstants.DATALINE_PC_UIN, paramBundle, local5);
    if ((!local5.a) || (i == 0))
    {
      DirectForwarder.b(paramContext, i);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800644B", "0X800644B", 0, 0, "6", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (paramMessageRecord1 != null)
    {
      if (!FileManagerUtil.a(paramMessageRecord1)) {
        return;
      }
      String str = paramMessageRecord2.getExtInfoFromExtStr("_m_ForwardFileType");
      if (TextUtils.isEmpty(str)) {
        return;
      }
      int i = Integer.parseInt(str);
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      str = paramMessageRecord2.getExtInfoFromExtStr("_m_ForwardReceiverUin");
      paramMessageRecord2 = paramMessageRecord2.getExtInfoFromExtStr("_m_ForwardSenderUin");
      if (i == 1)
      {
        paramMessageRecord1.istroop = 0;
        if ((!TextUtils.isEmpty(paramQQAppInterface)) && (!TextUtils.isEmpty(str)) && (paramQQAppInterface.equals(str))) {
          paramMessageRecord1.frienduin = paramMessageRecord2;
        }
      }
      else if (i == 2)
      {
        paramMessageRecord1.istroop = 3000;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<TroopFileInfo> paramList, Activity paramActivity, long paramLong)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      long l = 0L;
      if (paramLong == 0L) {
        return;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
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
        if (!TextUtils.isEmpty(localTroopFileStatusInfo.jdField_c_of_type_JavaLangString)) {
          localForwardFileInfo.f(localTroopFileStatusInfo.jdField_c_of_type_JavaLangString);
        } else if (!TextUtils.isEmpty(localTroopFileStatusInfo.d)) {
          localForwardFileInfo.f(localTroopFileStatusInfo.d);
        }
        localForwardFileInfo.d(1);
        localForwardFileInfo.a(3);
        if (FileUtils.fileExistsAndNotEmpty(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) {
          localArrayList2.add(Uri.parse(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString));
        } else {
          localArrayList2.add(Uri.parse(""));
        }
        l += localTroopFileStatusInfo.jdField_c_of_type_Long;
        localArrayList1.add(localForwardFileInfo);
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
      paramQQAppInterface = HardCodeUtil.a(2131709681);
      if (localArrayList1.size() == 1)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(HardCodeUtil.a(2131709689));
        paramQQAppInterface.append(FileManagerUtil.c(((ForwardFileInfo)localArrayList1.get(0)).d()));
        paramQQAppInterface.append(HardCodeUtil.a(2131709690));
        paramQQAppInterface.append(FileUtil.a(((ForwardFileInfo)localArrayList1.get(0)).d()));
        paramQQAppInterface.append("。");
        paramQQAppInterface = paramQQAppInterface.toString();
      }
      else if (localArrayList1.size() > 1)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(HardCodeUtil.a(2131709685));
        paramQQAppInterface.append(FileManagerUtil.c(((ForwardFileInfo)localArrayList1.get(0)).d()));
        paramQQAppInterface.append(HardCodeUtil.a(2131709684));
        paramQQAppInterface.append(localArrayList1.size());
        paramQQAppInterface.append(HardCodeUtil.a(2131709687));
        paramQQAppInterface.append(FileUtil.a(l));
        paramQQAppInterface.append("。");
        paramQQAppInterface = paramQQAppInterface.toString();
      }
      paramList.putExtra("forward_text", paramQQAppInterface);
      paramList.putExtra("k_favorites", false);
      ForwardBaseOption.a(paramActivity, paramList, 103);
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
    boolean bool = true;
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    if (i != 2)
    {
      if (i == 3) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(int paramInt1, int paramInt2, long paramLong)
  {
    if (paramInt1 * paramInt2 >= 350000000L) {
      return true;
    }
    if (Math.max(paramInt1, paramInt2) > 30000L) {
      return true;
    }
    return paramLong >= 31457280L;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
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
  
  public static boolean a(Context paramContext, String paramString, Uri paramUri)
  {
    return QQFileUtils.a(paramContext, paramString, paramUri);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, IFileWifiCheckCallback paramIFileWifiCheckCallback)
  {
    if (!NetworkUtil.isNetSupportHw(BaseApplicationImpl.getContext()))
    {
      FMToastUtil.a(2131693191);
      return false;
    }
    paramContext = (Activity)paramContext;
    int j = 2;
    int i;
    if (paramBoolean) {
      i = 3;
    } else {
      i = 2;
    }
    boolean bool2 = CUKingCardHelper.a(paramContext, i, new QFileUtils.1(paramIFileWifiCheckCallback), "");
    boolean bool1 = bool2;
    if (bool2)
    {
      if (paramBoolean) {
        i = j;
      } else {
        i = 1;
      }
      bool1 = FreeWifiHelper.a(paramContext, i, new QFileUtils.2(paramIFileWifiCheckCallback));
    }
    return bool1;
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
    return QQFileUtils.a(paramMessageRecord);
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity != null)
    {
      int i = paramFileManagerEntity.nOpType;
      int j = paramFileManagerEntity.status;
      if ((i == 21) || (i == 22) || (i == 24) || (i == 25) || (i == 28) || (i == 30))
      {
        if (j == 0) {
          break label63;
        }
        if (j == 2) {
          return false;
        }
      }
      return true;
    }
    label63:
    return false;
  }
  
  /* Error */
  private static boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: invokevirtual 1375	java/io/File:isFile	()Z
    //   10: ifeq +127 -> 137
    //   13: aload_0
    //   14: invokevirtual 412	java/io/File:exists	()Z
    //   17: ifne +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: new 1377	java/io/FileOutputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 1380	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: astore_1
    //   31: aload_1
    //   32: astore_3
    //   33: new 1382	java/io/FileInputStream
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 1383	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: astore 5
    //   43: invokestatic 1389	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   46: sipush 4096
    //   49: invokevirtual 1393	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   52: astore_0
    //   53: aload 5
    //   55: aload_0
    //   56: invokevirtual 1397	java/io/FileInputStream:read	([B)I
    //   59: istore_2
    //   60: iload_2
    //   61: iconst_m1
    //   62: if_icmpeq +13 -> 75
    //   65: aload_1
    //   66: aload_0
    //   67: iconst_0
    //   68: iload_2
    //   69: invokevirtual 1401	java/io/FileOutputStream:write	([BII)V
    //   72: goto -19 -> 53
    //   75: invokestatic 1389	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   78: aload_0
    //   79: invokevirtual 1405	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   82: aload_1
    //   83: invokevirtual 1408	java/io/FileOutputStream:flush	()V
    //   86: aload 5
    //   88: invokevirtual 1411	java/io/FileInputStream:close	()V
    //   91: aload_1
    //   92: invokevirtual 1412	java/io/FileOutputStream:close	()V
    //   95: iconst_1
    //   96: ireturn
    //   97: astore_0
    //   98: aload_0
    //   99: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   102: iconst_0
    //   103: ireturn
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   109: iconst_0
    //   110: ireturn
    //   111: astore_0
    //   112: aload 5
    //   114: astore 4
    //   116: goto +88 -> 204
    //   119: astore_3
    //   120: aload 5
    //   122: astore_0
    //   123: aload_3
    //   124: astore 5
    //   126: goto +30 -> 156
    //   129: astore 5
    //   131: aload 6
    //   133: astore_0
    //   134: goto +22 -> 156
    //   137: iconst_0
    //   138: ireturn
    //   139: astore_0
    //   140: aconst_null
    //   141: astore 4
    //   143: aload 4
    //   145: astore_1
    //   146: goto +58 -> 204
    //   149: astore 5
    //   151: aconst_null
    //   152: astore_1
    //   153: aload 6
    //   155: astore_0
    //   156: aload_0
    //   157: astore 4
    //   159: aload_1
    //   160: astore_3
    //   161: aload 5
    //   163: invokevirtual 1413	java/lang/Exception:printStackTrace	()V
    //   166: aload_0
    //   167: ifnull +17 -> 184
    //   170: aload_0
    //   171: invokevirtual 1411	java/io/FileInputStream:close	()V
    //   174: goto +10 -> 184
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   182: iconst_0
    //   183: ireturn
    //   184: aload_1
    //   185: ifnull +14 -> 199
    //   188: aload_1
    //   189: invokevirtual 1412	java/io/FileOutputStream:close	()V
    //   192: iconst_0
    //   193: ireturn
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   199: iconst_0
    //   200: ireturn
    //   201: astore_0
    //   202: aload_3
    //   203: astore_1
    //   204: aload 4
    //   206: ifnull +18 -> 224
    //   209: aload 4
    //   211: invokevirtual 1411	java/io/FileInputStream:close	()V
    //   214: goto +10 -> 224
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   222: iconst_0
    //   223: ireturn
    //   224: aload_1
    //   225: ifnull +17 -> 242
    //   228: aload_1
    //   229: invokevirtual 1412	java/io/FileOutputStream:close	()V
    //   232: goto +10 -> 242
    //   235: astore_0
    //   236: aload_0
    //   237: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   240: iconst_0
    //   241: ireturn
    //   242: goto +5 -> 247
    //   245: aload_0
    //   246: athrow
    //   247: goto -2 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	paramFile1	File
    //   0	250	1	paramFile2	File
    //   59	10	2	i	int
    //   32	1	3	localFile1	File
    //   119	5	3	localException1	Exception
    //   160	43	3	localFile2	File
    //   1	209	4	localObject1	Object
    //   41	84	5	localObject2	Object
    //   129	1	5	localException2	Exception
    //   149	13	5	localException3	Exception
    //   4	150	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   91	95	97	java/io/IOException
    //   86	91	104	java/io/IOException
    //   43	53	111	finally
    //   53	60	111	finally
    //   65	72	111	finally
    //   75	86	111	finally
    //   43	53	119	java/lang/Exception
    //   53	60	119	java/lang/Exception
    //   65	72	119	java/lang/Exception
    //   75	86	119	java/lang/Exception
    //   33	43	129	java/lang/Exception
    //   6	20	139	finally
    //   22	31	139	finally
    //   6	20	149	java/lang/Exception
    //   22	31	149	java/lang/Exception
    //   170	174	177	java/io/IOException
    //   188	192	194	java/io/IOException
    //   33	43	201	finally
    //   161	166	201	finally
    //   209	214	217	java/io/IOException
    //   228	232	235	java/io/IOException
  }
  
  public static boolean a(boolean paramBoolean, long paramLong, String paramString)
  {
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext())) {
      return false;
    }
    if (!QQFileManagerUtil.a())
    {
      QLog.i("QFileUtils", 1, "checkShowFlowDialog. do not show with Wi-Fi.");
      return false;
    }
    long l = ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize();
    ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogTime();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkShowFlowDialog. fileSize[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("] limit[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.i("QFileUtils", 1, localStringBuilder.toString());
    if (paramLong < l) {
      return false;
    }
    if (paramBoolean)
    {
      QLog.i("QFileUtils", 1, "checkShowFlowDialog. download so show.");
      return true;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      QLog.i("QFileUtils", 1, "checkShowFlowDialog. is not local File do not show.");
      return false;
    }
    QLog.i("QFileUtils", 1, "checkShowFlowDialog. show flow dialog");
    return true;
  }
  
  public static int b()
  {
    return QQFileUtils.b();
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 8: 
    default: 
      return 10;
    case 10: 
      return 5;
    case 9: 
      return 4;
    case 7: 
      return 3;
    case 6: 
      return 2;
    case 4: 
      return 6;
    case 3: 
      return 1;
    case 2: 
      return 8;
    case 1: 
      return 9;
    }
    return 7;
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return 4;
    }
    if (paramInt1 == 3) {
      return 3;
    }
    if (paramInt1 == 0) {
      return 4;
    }
    if (paramInt1 == 2) {
      return 4;
    }
    if (paramInt1 == 4) {
      return 12;
    }
    return paramInt2;
  }
  
  public static int b(String paramString)
  {
    return QQFileUtils.b(paramString);
  }
  
  public static String b(long paramLong)
  {
    float f;
    StringBuilder localStringBuilder;
    if (paramLong > 1048576L)
    {
      f = (float)paramLong / 1048576.0F;
      localObject = new DecimalFormat("0.00").format(f);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131709683));
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("MB/s");
      return localStringBuilder.toString();
    }
    if (paramLong > 1024L)
    {
      f = (float)paramLong / 1024.0F;
      localObject = new DecimalFormat("0.00").format(f);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131709682));
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("KB/s");
      return localStringBuilder.toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131709688));
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("KB/s");
    return ((StringBuilder)localObject).toString();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity)
  {
    b(paramQQAppInterface, paramActivity, paramFileManagerEntity, false, null, -1);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramQQAppInterface != null)
    {
      if (paramActivity == null) {
        return;
      }
      if (paramFileManagerEntity == null) {
        return;
      }
      FileManagerEntity localFileManagerEntity = new FileManagerEntity();
      localFileManagerEntity.copyFrom(paramFileManagerEntity);
      localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
      paramQQAppInterface.getFileManagerDataCenter().d(localFileManagerEntity);
      paramQQAppInterface = a(paramQQAppInterface, paramActivity, paramFileManagerEntity);
      if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramInt != -1))
      {
        paramQQAppInterface.putExtra("key_req", 1);
        paramQQAppInterface.putExtra("key_direct_show_uin_type", paramInt);
        paramQQAppInterface.putExtra("key_direct_show_uin", paramString);
      }
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        FMToastUtil.a(2131692554);
        return;
      }
      if (FileModel.a(localFileManagerEntity).a(false))
      {
        FMDialogUtil.a(paramActivity, 2131692561, 2131692566, new QFileUtils.4(paramActivity, paramQQAppInterface));
        return;
      }
      ForwardBaseOption.a(paramActivity, paramQQAppInterface, ForwardRecentTranslucentActivity.class, 103);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (paramMessageRecord1 != null)
    {
      if (!FileManagerUtil.a(paramMessageRecord1)) {
        return;
      }
      if (paramMessageRecord2 != null)
      {
        if (!FileManagerUtil.a(paramMessageRecord2)) {
          return;
        }
        paramQQAppInterface.getFileManagerEngine().a().a(paramMessageRecord1, paramMessageRecord2);
      }
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      QLog.e("QFileUtils", 1, "copyFileToMediaStore4LessArd10 file not exist.");
      return false;
    }
    String str1 = QQFileManagerUtil.e(paramString);
    int i = QQFileManagerUtil.b(str1);
    if (i == 0)
    {
      paramString = AppConstants.SDCARD_IMG_SAVE;
      localObject = new File(paramString);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString = new File(paramString, str1);
    }
    else
    {
      if (i != 2) {
        break label353;
      }
      paramString = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      paramString = new File(paramString, str1);
    }
    Object localObject = paramString.getAbsolutePath();
    if (!a(localFile, paramString))
    {
      QLog.e("QFileUtils", 1, "copyFileToMediaStore4LessArd10 copyFile fail.");
      return false;
    }
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
    else if (i == 2)
    {
      long l = ShortVideoUtils.getDuration((String)localObject);
      localContentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
      localContentValues.put("duration", Long.valueOf(l));
      paramString = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }
    paramContext.getContentResolver().insert(paramString, localContentValues);
    ImageUtil.a(paramContext, (String)localObject);
    return true;
    label353:
    paramContext = new StringBuilder();
    paramContext.append("copyFileToMediaStore4LessArd10 file not media file. filePath:");
    paramContext.append(paramString);
    QLog.e("QFileUtils", 1, paramContext.toString());
    return false;
  }
  
  public static boolean b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    if (6 != paramFileManagerEntity.getCloudType()) {
      return false;
    }
    return !FileUtil.a(paramFileManagerEntity.getFilePath());
  }
  
  public static int c()
  {
    return QQFileUtils.c();
  }
  
  public static int c(int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 6)
        {
          if (paramInt != 7)
          {
            if (paramInt != 9) {
              return 6;
            }
            return 4;
          }
          return 2;
        }
        return 3;
      }
      return 5;
    }
    return 1;
  }
  
  public static int c(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 7) {
      return 3;
    }
    int i = 1;
    if ((paramInt2 != 1) && (paramInt2 != 3)) {
      paramInt2 = 0;
    } else {
      paramInt2 = 1;
    }
    if (paramInt1 == 1)
    {
      paramInt1 = i;
      if (paramInt2 != 0) {
        paramInt1 = 2;
      }
      return paramInt1;
    }
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
    return QQFileUtils.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QFileUtils
 * JD-Core Version:    0.7.0.1
 */