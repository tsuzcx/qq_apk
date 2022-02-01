package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TimeoutParam;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class QQFileManagerUtil
{
  public static int a(int paramInt)
  {
    return a().getFileIconResId(paramInt);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return a().getFileIconResId(paramInt1, paramInt2);
  }
  
  public static int a(ChatMessage paramChatMessage)
  {
    return a().getFileTypeFromMultiMsgRecord(paramChatMessage);
  }
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    return a().getFileSrcCloudType(paramFileManagerEntity);
  }
  
  public static int a(String paramString)
  {
    return a().getQlinkIntroShowTime(paramString);
  }
  
  public static long a()
  {
    return a().genMsgSeq();
  }
  
  public static long a(int paramInt)
  {
    return a().getTempSessionType(paramInt);
  }
  
  public static long a(long paramLong)
  {
    return a().getWeiyunZipTargetId(paramLong);
  }
  
  public static long a(String paramString)
  {
    return a().getDocsImportFileMaxSize(paramString);
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt)
  {
    return a().getCircleFaceBitmap(paramContext, paramBitmap, paramInt);
  }
  
  public static SpannableString a(String paramString1, String paramString2, QQFileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    return a().getClickableTips(paramString1, paramString2, paramTipsClickedInterface);
  }
  
  public static BaseQQAppInterface a()
  {
    return a().getApp();
  }
  
  public static IFileManagerUtil a()
  {
    return (IFileManagerUtil)QRoute.api(IFileManagerUtil.class);
  }
  
  public static FileManagerEntity a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, String paramString, int paramInt, ChatMessage paramChatMessage)
  {
    return a().getFileRecordForMultiMsg(paramBaseQQAppInterface, paramLong, paramString, paramInt, paramChatMessage);
  }
  
  public static FileManagerEntity a(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage)
  {
    return a().createFileRecordForMultiMsg(paramBaseQQAppInterface, paramChatMessage);
  }
  
  public static FileManagerEntity a(BaseQQAppInterface paramBaseQQAppInterface, MessageForFile paramMessageForFile)
  {
    return a().getFileManagerEntityByMsgFile(paramBaseQQAppInterface, paramMessageForFile);
  }
  
  public static FileManagerEntity a(FileInfo paramFileInfo)
  {
    return a().newEntityByLocalFileInfo(paramFileInfo);
  }
  
  public static FileManagerEntity a(OfflineFileInfo paramOfflineFileInfo, int paramInt)
  {
    return a().newEntityByOfflineFileInfo(paramOfflineFileInfo, paramInt);
  }
  
  public static FileManagerEntity a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    return a().newEntityByWeiYunFileInfo(paramWeiYunFileInfo);
  }
  
  public static IForwardCallBack a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    return a().getDatalineProcessCallBack(paramBaseQQAppInterface, paramInt);
  }
  
  public static QQFileManagerUtil.VideoThumbInfo a(String paramString)
  {
    return a().syncCreateVideoThumb(paramString);
  }
  
  public static TimeoutParam a()
  {
    return a().getTimeOutParamer();
  }
  
  public static Long a()
  {
    return a().genSessionId();
  }
  
  public static String a()
  {
    try
    {
      String str = a().printStack();
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
    return a().getFileType(paramInt);
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    return a().reportSrcType(paramInt1, paramInt2);
  }
  
  public static String a(long paramLong, int paramInt)
  {
    return a().millsTimeToString(paramLong, paramInt);
  }
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage)
  {
    return a().updateRecentListTxt(paramBaseQQAppInterface, paramMessage);
  }
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    return a().updateRecentListTxtByMessageRecord(paramBaseQQAppInterface, paramMessageRecord);
  }
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    return a().getPeerNick(paramBaseQQAppInterface, paramString1, paramString2, paramInt);
  }
  
  public static String a(ChatMessage paramChatMessage)
  {
    return a().getMultiFileThumbPath(paramChatMessage);
  }
  
  public static String a(FileManagerEntity paramFileManagerEntity)
  {
    return a().printFileManagerEntityInfo(paramFileManagerEntity);
  }
  
  public static String a(ByteStringMicro paramByteStringMicro)
  {
    return a().binToHEX(paramByteStringMicro);
  }
  
  public static String a(String paramString)
  {
    return a().enCodecString(paramString);
  }
  
  public static String a(String paramString, int paramInt)
  {
    return a().cutLongLongFileName(paramString, paramInt);
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, QQFileManagerUtil.IThumbResult paramIThumbResult)
  {
    return a().createMediaThumbnail(paramString, paramInt1, paramInt2, paramIThumbResult);
  }
  
  public static String a(String paramString, boolean paramBoolean, int paramInt1, TextPaint paramTextPaint, int paramInt2)
  {
    return a().handleLongFileName(paramString, paramBoolean, paramInt1, paramTextPaint, paramInt2);
  }
  
  public static String a(Map paramMap)
  {
    return a().mapToJson(paramMap);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return a().hexToString(paramArrayOfByte);
  }
  
  public static ArrayList<FileInfo> a(boolean paramBoolean, int paramInt)
  {
    return a().getAllFMRecvFiles(paramBoolean, paramInt);
  }
  
  public static LinkedHashMap a(String paramString)
  {
    return a().jsonToMap(paramString);
  }
  
  public static Map<String, File> a(Context paramContext)
  {
    return a().getAllStorageLocations(paramContext);
  }
  
  public static void a()
  {
    a().initNoMedia();
  }
  
  public static void a(long paramLong)
  {
    a().dealWithTransFileSuc(paramLong);
  }
  
  public static void a(long paramLong, int paramInt, String paramString)
  {
    a().dealWithTransFileFaild(paramLong, paramInt, paramString);
  }
  
  public static void a(Activity paramActivity, TextView paramTextView)
  {
    a().startLoadingAnim(paramActivity, paramTextView);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    a().openWithOtherApp(paramActivity, paramString);
  }
  
  public static void a(Context paramContext)
  {
    a().clearRememberPicSelectForQlink(paramContext);
  }
  
  public static void a(Context paramContext, FileManagerEntity paramFileManagerEntity, BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    a().resume(paramContext, paramFileManagerEntity, paramBaseQQAppInterface, paramBoolean);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a().saveToAlbum(paramContext, paramString);
  }
  
  public static void a(ImageView paramImageView, FileManagerEntity paramFileManagerEntity)
  {
    a().setFileIcon(paramImageView, paramFileManagerEntity);
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    a().setFileIcon(paramImageView, paramString);
  }
  
  public static void a(TextView paramTextView)
  {
    a().stopLoadingAnim(paramTextView);
  }
  
  public static void a(TextView paramTextView, FileManagerEntity paramFileManagerEntity)
  {
    a().calcFileDescription(paramTextView, paramFileManagerEntity);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    a().processAIOTimGraytips(paramBaseQQAppInterface, paramLong);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6)
  {
    a().reportFilemanagerSuccessInfo(paramBaseQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramLong4, paramLong5, paramInt, paramString6);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6, Bundle paramBundle)
  {
    a().reportFilemanagerSuccessInfoEx(paramBaseQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramLong4, paramLong5, paramInt, paramString6, paramBundle);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    a().reportFilemanagerFaildInfo(paramBaseQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramString6, paramLong4, paramLong5, paramLong6, paramString7, paramString8, paramInt, paramString9, paramString10);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10, Bundle paramBundle)
  {
    a().reportFilemanagerFaildInfoEx(paramBaseQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramString6, paramLong4, paramLong5, paramLong6, paramString7, paramString8, paramInt, paramString9, paramString10, paramBundle);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    a().reportFileAssistans(paramBaseQQAppInterface, paramContext);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    a().addShortcut(paramBaseQQAppInterface, paramContext, paramString1, paramString2, paramInt);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    a().initSaveToPc(paramBaseQQAppInterface, paramChatMessage, paramContext);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    a().preLoadThumb(paramBaseQQAppInterface, paramFileManagerEntity);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    a().updateBatProcessTips(paramBaseQQAppInterface, paramString1, paramString2, paramInt);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    a().setTempParam(paramBaseQQAppInterface, paramString1, paramString2, paramFileManagerEntity);
  }
  
  public static void a(ChatMessage paramChatMessage, MessageForFile paramMessageForFile)
  {
    a().fillFileMessageRecord(paramChatMessage, paramMessageForFile);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    a().fixEntityThumbSize(paramFileManagerEntity);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, BaseQQAppInterface paramBaseQQAppInterface, Activity paramActivity, int paramInt)
  {
    a().onDatalineForward(paramFileManagerEntity, paramBaseQQAppInterface, paramActivity, paramInt);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, BaseQQAppInterface paramBaseQQAppInterface, QQFileManagerUtil.CheckResult paramCheckResult)
  {
    a().checkFileExisted(paramFileManagerEntity, paramBaseQQAppInterface, paramCheckResult);
  }
  
  public static void a(AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    a().setZipImageFileIcon(paramAsyncImageView, paramFileManagerEntity);
  }
  
  public static void a(AsyncImageView paramAsyncImageView, String paramString, int paramInt)
  {
    a().setFileIcon(paramAsyncImageView, paramString, paramInt);
  }
  
  public static void a(AsyncImageView paramAsyncImageView, String paramString, boolean paramBoolean)
  {
    a().setFileIcon(paramAsyncImageView, paramString, paramBoolean);
  }
  
  public static void a(String paramString)
  {
    a().dealWithErrCode(paramString);
  }
  
  public static void a(String paramString, int paramInt)
  {
    a().saveQlinkIntroShowTime(paramString, paramInt);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    a().setBuddyIntroShow(paramString1, paramString2, paramBoolean);
  }
  
  public static void a(List<FileManagerEntity> paramList, Activity paramActivity)
  {
    a().forwardRencentFiles(paramList, paramActivity);
  }
  
  public static void a(TreeMap<Long, FileInfo> paramTreeMap, int paramInt, LinkedHashMap<String, List<FileInfo>> paramLinkedHashMap1, LinkedHashMap<String, List<FileInfo>> paramLinkedHashMap2, List<FileInfo> paramList)
  {
    a().getSortMap(paramTreeMap, paramInt, paramLinkedHashMap1, paramLinkedHashMap2, paramList);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    a().showFlowDialog(paramBoolean, paramContext, paramFMDialogInterface);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface, int paramInt)
  {
    a().showFlowDialog(paramBoolean, paramContext, paramFMDialogInterface, paramInt);
  }
  
  public static boolean a()
  {
    return a().is2GOr3G();
  }
  
  public static boolean a(int paramInt)
  {
    return a().bZip(paramInt);
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    return a().dealWithErrCode(paramInt, paramString);
  }
  
  public static boolean a(Context paramContext)
  {
    return a().isImportLocaFilesForH5(paramContext);
  }
  
  public static boolean a(Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    return a().ifShowFileMask(paramContext, paramFileManagerEntity);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return a().hasShortCut(paramContext, paramString);
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong)
  {
    return a().canPreview(paramContext, paramString, paramLong);
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage)
  {
    return a().isMultiMessageSender(paramBaseQQAppInterface, paramChatMessage);
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    return a().initSaveToWeiYun(paramBaseQQAppInterface, paramChatMessage, paramContext);
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage, Context paramContext, boolean paramBoolean)
  {
    return a().initSaveToWeiYun(paramBaseQQAppInterface, paramChatMessage, paramContext, paramBoolean);
  }
  
  public static boolean a(VFSFile paramVFSFile1, VFSFile paramVFSFile2)
  {
    return a().renameFile(paramVFSFile1, paramVFSFile2);
  }
  
  public static boolean a(ChatMessage paramChatMessage, BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    return a().checkMultiFileBubbleClickable(paramChatMessage, paramBaseQQAppInterface, paramContext);
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return a().hasThumb(paramFileManagerEntity);
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    return a().renameFile(paramFile1, paramFile2);
  }
  
  public static boolean a(String paramString)
  {
    return a().fileExist(paramString);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return a().isBuddyIntroShow(paramString1, paramString2);
  }
  
  public static boolean a(boolean paramBoolean, ArrayList<FileManagerEntity> paramArrayList)
  {
    return a().bShowFlowDlg(paramBoolean, paramArrayList);
  }
  
  public static byte[] a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt)
  {
    return a().getTempSessionSig(paramBaseQQAppInterface, paramString, paramInt);
  }
  
  public static byte[] a(String paramString)
  {
    return a().getSha3(paramString);
  }
  
  public static byte[] a(String paramString, long paramLong)
  {
    return a().getMd5(paramString, paramLong);
  }
  
  public static int[] a(String paramString)
  {
    return a().getMediaFileWidthHeight(paramString);
  }
  
  public static int b(int paramInt)
  {
    return a().getStatus(paramInt);
  }
  
  public static int b(FileManagerEntity paramFileManagerEntity)
  {
    return a().chechZipFileType(paramFileManagerEntity);
  }
  
  public static int b(String paramString)
  {
    try
    {
      int i = a().getFileType(paramString);
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static long b()
  {
    return a().genMsgUid();
  }
  
  public static long b(String paramString)
  {
    return a().getFileSizes(paramString);
  }
  
  public static String b()
  {
    return a().getFMDownloadPath();
  }
  
  public static String b(int paramInt)
  {
    return a().getReportFileTypeStr(paramInt);
  }
  
  public static String b(FileManagerEntity paramFileManagerEntity)
  {
    return a().getImageUrl(paramFileManagerEntity);
  }
  
  public static String b(String paramString)
  {
    return a().cutLongName(paramString);
  }
  
  public static void b(long paramLong)
  {
    a().addCloseButtonSessionId(paramLong);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    a().installApkFile(paramContext, paramString);
  }
  
  public static void b(FileManagerEntity paramFileManagerEntity)
  {
    a().createMediThumbnail(paramFileManagerEntity);
  }
  
  public static void b(AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    a().setFileIcon(paramAsyncImageView, paramFileManagerEntity);
  }
  
  public static boolean b(FileManagerEntity paramFileManagerEntity)
  {
    return a().hasNoThumb(paramFileManagerEntity);
  }
  
  public static boolean b(String paramString)
  {
    return a().isLocalFile(paramString);
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    return a().filterFiles(paramString1, paramString2);
  }
  
  public static byte[] b(String paramString)
  {
    return a().get3SHA(paramString);
  }
  
  public static int c(FileManagerEntity paramFileManagerEntity)
  {
    return a().chechFileType(paramFileManagerEntity);
  }
  
  public static int c(String paramString)
  {
    return a().getFileIconResId(paramString);
  }
  
  public static String c(FileManagerEntity paramFileManagerEntity)
  {
    return a().getZipThumbSavePath(paramFileManagerEntity);
  }
  
  public static String c(String paramString)
  {
    return a().getZipThumbUrlWithFileUrl(paramString);
  }
  
  public static void c(long paramLong)
  {
    a().delCloseButtonSessionId(paramLong);
  }
  
  public static void c(FileManagerEntity paramFileManagerEntity)
  {
    a().associateLocalWithCloud(paramFileManagerEntity);
  }
  
  public static boolean c(FileManagerEntity paramFileManagerEntity)
  {
    return a().canCreateThumb(paramFileManagerEntity);
  }
  
  public static byte[] c(String paramString)
  {
    return a().getMd5(paramString);
  }
  
  public static int d(String paramString)
  {
    return a().addExternalFileToFMRecv(paramString);
  }
  
  public static String d(FileManagerEntity paramFileManagerEntity)
  {
    return a().getFileSizeInvalidTime(paramFileManagerEntity);
  }
  
  public static String d(String paramString)
  {
    return a().getHardCodeConfig(paramString);
  }
  
  public static void d(FileManagerEntity paramFileManagerEntity)
  {
    a().correctFileInfo(paramFileManagerEntity);
  }
  
  public static boolean d(FileManagerEntity paramFileManagerEntity)
  {
    return a().isTroopFile(paramFileManagerEntity);
  }
  
  public static byte[] d(String paramString)
  {
    return a().getSHA(paramString);
  }
  
  public static int e(String paramString)
  {
    return a().delExternalFileFromFMRecv(paramString);
  }
  
  public static String e(FileManagerEntity paramFileManagerEntity)
  {
    return a().getFileOperationTypeToPeer(paramFileManagerEntity);
  }
  
  public static String e(String paramString)
  {
    return a().getFileName(paramString);
  }
  
  public static boolean e(FileManagerEntity paramFileManagerEntity)
  {
    return a().isSupportFavorite(paramFileManagerEntity);
  }
  
  public static byte[] e(String paramString)
  {
    return a().getFullMd5(paramString);
  }
  
  public static String f(String paramString)
  {
    return a().recreateFilePath(paramString);
  }
  
  public static boolean f(FileManagerEntity paramFileManagerEntity)
  {
    return a().fileWhetherExpire(paramFileManagerEntity);
  }
  
  public static String g(String paramString)
  {
    return a().createVideoThumbPath(paramString);
  }
  
  public static String h(String paramString)
  {
    return a().getFileSuffix(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtil
 * JD-Core Version:    0.7.0.1
 */