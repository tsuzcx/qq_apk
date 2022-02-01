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
  public static int a(int paramInt1, int paramInt2)
  {
    return e().getFileIconResId(paramInt1, paramInt2);
  }
  
  public static int a(ChatMessage paramChatMessage)
  {
    return e().getFileTypeFromMultiMsgRecord(paramChatMessage);
  }
  
  public static long a(long paramLong)
  {
    return e().getWeiyunZipTargetId(paramLong);
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt)
  {
    return e().getCircleFaceBitmap(paramContext, paramBitmap, paramInt);
  }
  
  public static SpannableString a(String paramString1, String paramString2, QQFileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    return e().getClickableTips(paramString1, paramString2, paramTipsClickedInterface);
  }
  
  public static FileManagerEntity a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, String paramString, int paramInt, ChatMessage paramChatMessage)
  {
    return e().getFileRecordForMultiMsg(paramBaseQQAppInterface, paramLong, paramString, paramInt, paramChatMessage);
  }
  
  public static FileManagerEntity a(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage)
  {
    return e().createFileRecordForMultiMsg(paramBaseQQAppInterface, paramChatMessage);
  }
  
  public static FileManagerEntity a(BaseQQAppInterface paramBaseQQAppInterface, MessageForFile paramMessageForFile)
  {
    return e().getFileManagerEntityByMsgFile(paramBaseQQAppInterface, paramMessageForFile);
  }
  
  public static FileManagerEntity a(FileInfo paramFileInfo)
  {
    return e().newEntityByLocalFileInfo(paramFileInfo);
  }
  
  public static FileManagerEntity a(OfflineFileInfo paramOfflineFileInfo, int paramInt)
  {
    return e().newEntityByOfflineFileInfo(paramOfflineFileInfo, paramInt);
  }
  
  public static FileManagerEntity a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    return e().newEntityByWeiYunFileInfo(paramWeiYunFileInfo);
  }
  
  public static IForwardCallBack a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    return e().getDatalineProcessCallBack(paramBaseQQAppInterface, paramInt);
  }
  
  public static String a(long paramLong, int paramInt)
  {
    return e().millsTimeToString(paramLong, paramInt);
  }
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage)
  {
    return e().updateRecentListTxt(paramBaseQQAppInterface, paramMessage);
  }
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    return e().updateRecentListTxtByMessageRecord(paramBaseQQAppInterface, paramMessageRecord);
  }
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    return e().getPeerNick(paramBaseQQAppInterface, paramString1, paramString2, paramInt);
  }
  
  public static String a(FileManagerEntity paramFileManagerEntity)
  {
    return e().printFileManagerEntityInfo(paramFileManagerEntity);
  }
  
  public static String a(ByteStringMicro paramByteStringMicro)
  {
    return e().binToHEX(paramByteStringMicro);
  }
  
  public static String a(String paramString)
  {
    return e().enCodecString(paramString);
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, QQFileManagerUtil.IThumbResult paramIThumbResult)
  {
    return e().createMediaThumbnail(paramString, paramInt1, paramInt2, paramIThumbResult);
  }
  
  public static String a(String paramString, boolean paramBoolean, int paramInt1, TextPaint paramTextPaint, int paramInt2)
  {
    return e().handleLongFileName(paramString, paramBoolean, paramInt1, paramTextPaint, paramInt2);
  }
  
  public static String a(Map paramMap)
  {
    return e().mapToJson(paramMap);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return e().hexToString(paramArrayOfByte);
  }
  
  public static ArrayList<FileInfo> a(boolean paramBoolean, int paramInt)
  {
    return e().getAllFMRecvFiles(paramBoolean, paramInt);
  }
  
  public static void a()
  {
    e().initNoMedia();
  }
  
  public static void a(long paramLong, int paramInt, String paramString)
  {
    e().dealWithTransFileFaild(paramLong, paramInt, paramString);
  }
  
  public static void a(Activity paramActivity, TextView paramTextView)
  {
    e().startLoadingAnim(paramActivity, paramTextView);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    e().openWithOtherApp(paramActivity, paramString);
  }
  
  public static void a(Context paramContext)
  {
    e().clearRememberPicSelectForQlink(paramContext);
  }
  
  public static void a(Context paramContext, FileManagerEntity paramFileManagerEntity, BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    e().resume(paramContext, paramFileManagerEntity, paramBaseQQAppInterface, paramBoolean);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    e().saveToAlbum(paramContext, paramString);
  }
  
  public static void a(ImageView paramImageView, FileManagerEntity paramFileManagerEntity)
  {
    e().setFileIcon(paramImageView, paramFileManagerEntity);
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    e().setFileIcon(paramImageView, paramString);
  }
  
  public static void a(TextView paramTextView)
  {
    e().stopLoadingAnim(paramTextView);
  }
  
  public static void a(TextView paramTextView, FileManagerEntity paramFileManagerEntity)
  {
    e().calcFileDescription(paramTextView, paramFileManagerEntity);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    e().processAIOTimGraytips(paramBaseQQAppInterface, paramLong);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6)
  {
    e().reportFilemanagerSuccessInfo(paramBaseQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramLong4, paramLong5, paramInt, paramString6);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6, Bundle paramBundle)
  {
    e().reportFilemanagerSuccessInfoEx(paramBaseQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramLong4, paramLong5, paramInt, paramString6, paramBundle);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    e().reportFilemanagerFaildInfo(paramBaseQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramString6, paramLong4, paramLong5, paramLong6, paramString7, paramString8, paramInt, paramString9, paramString10);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10, Bundle paramBundle)
  {
    e().reportFilemanagerFaildInfoEx(paramBaseQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramString6, paramLong4, paramLong5, paramLong6, paramString7, paramString8, paramInt, paramString9, paramString10, paramBundle);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    e().reportFileAssistans(paramBaseQQAppInterface, paramContext);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    e().addShortcut(paramBaseQQAppInterface, paramContext, paramString1, paramString2, paramInt);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    e().initSaveToPc(paramBaseQQAppInterface, paramChatMessage, paramContext);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    e().preLoadThumb(paramBaseQQAppInterface, paramFileManagerEntity);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    e().setTempParam(paramBaseQQAppInterface, paramString1, paramString2, paramFileManagerEntity);
  }
  
  public static void a(ChatMessage paramChatMessage, MessageForFile paramMessageForFile)
  {
    e().fillFileMessageRecord(paramChatMessage, paramMessageForFile);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, BaseQQAppInterface paramBaseQQAppInterface, Activity paramActivity, int paramInt)
  {
    e().onDatalineForward(paramFileManagerEntity, paramBaseQQAppInterface, paramActivity, paramInt);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, BaseQQAppInterface paramBaseQQAppInterface, QQFileManagerUtil.CheckResult paramCheckResult)
  {
    e().checkFileExisted(paramFileManagerEntity, paramBaseQQAppInterface, paramCheckResult);
  }
  
  public static void a(AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    e().setZipImageFileIcon(paramAsyncImageView, paramFileManagerEntity);
  }
  
  public static void a(AsyncImageView paramAsyncImageView, String paramString, int paramInt)
  {
    e().setFileIcon(paramAsyncImageView, paramString, paramInt);
  }
  
  public static void a(AsyncImageView paramAsyncImageView, String paramString, boolean paramBoolean)
  {
    e().setFileIcon(paramAsyncImageView, paramString, paramBoolean);
  }
  
  public static void a(String paramString, int paramInt)
  {
    e().saveQlinkIntroShowTime(paramString, paramInt);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    e().setBuddyIntroShow(paramString1, paramString2, paramBoolean);
  }
  
  public static void a(List<FileManagerEntity> paramList, Activity paramActivity)
  {
    e().forwardRencentFiles(paramList, paramActivity);
  }
  
  public static void a(TreeMap<Long, FileInfo> paramTreeMap, int paramInt, LinkedHashMap<String, List<FileInfo>> paramLinkedHashMap1, LinkedHashMap<String, List<FileInfo>> paramLinkedHashMap2, List<FileInfo> paramList)
  {
    e().getSortMap(paramTreeMap, paramInt, paramLinkedHashMap1, paramLinkedHashMap2, paramList);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    e().showFlowDialog(paramBoolean, paramContext, paramFMDialogInterface);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface, int paramInt)
  {
    e().showFlowDialog(paramBoolean, paramContext, paramFMDialogInterface, paramInt);
  }
  
  public static boolean a(int paramInt)
  {
    return e().bZip(paramInt);
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    return e().dealWithErrCode(paramInt, paramString);
  }
  
  public static boolean a(Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    return e().ifShowFileMask(paramContext, paramFileManagerEntity);
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong)
  {
    return e().canPreview(paramContext, paramString, paramLong);
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage, Context paramContext, boolean paramBoolean)
  {
    return e().initSaveToWeiYun(paramBaseQQAppInterface, paramChatMessage, paramContext, paramBoolean);
  }
  
  public static boolean a(VFSFile paramVFSFile1, VFSFile paramVFSFile2)
  {
    return e().renameFile(paramVFSFile1, paramVFSFile2);
  }
  
  public static boolean a(ChatMessage paramChatMessage, BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    return e().checkMultiFileBubbleClickable(paramChatMessage, paramBaseQQAppInterface, paramContext);
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    return e().renameFile(paramFile1, paramFile2);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return e().isBuddyIntroShow(paramString1, paramString2);
  }
  
  public static boolean a(boolean paramBoolean, ArrayList<FileManagerEntity> paramArrayList)
  {
    return e().bShowFlowDlg(paramBoolean, paramArrayList);
  }
  
  public static byte[] a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt)
  {
    return e().getTempSessionSig(paramBaseQQAppInterface, paramString, paramInt);
  }
  
  public static byte[] a(String paramString, long paramLong)
  {
    return e().getMd5(paramString, paramLong);
  }
  
  public static long b()
  {
    return e().genMsgSeq();
  }
  
  public static String b(int paramInt)
  {
    return e().getFileType(paramInt);
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    return e().reportSrcType(paramInt1, paramInt2);
  }
  
  public static String b(ChatMessage paramChatMessage)
  {
    return e().getMultiFileThumbPath(paramChatMessage);
  }
  
  public static String b(FileManagerEntity paramFileManagerEntity)
  {
    return e().getImageUrl(paramFileManagerEntity);
  }
  
  public static String b(String paramString)
  {
    return e().cutLongName(paramString);
  }
  
  public static String b(String paramString, int paramInt)
  {
    return e().cutLongLongFileName(paramString, paramInt);
  }
  
  public static Map<String, File> b(Context paramContext)
  {
    return e().getAllStorageLocations(paramContext);
  }
  
  public static void b(long paramLong)
  {
    e().dealWithTransFileSuc(paramLong);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    e().installApkFile(paramContext, paramString);
  }
  
  public static void b(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    e().updateBatProcessTips(paramBaseQQAppInterface, paramString1, paramString2, paramInt);
  }
  
  public static void b(AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    e().setFileIcon(paramAsyncImageView, paramFileManagerEntity);
  }
  
  public static boolean b(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage)
  {
    return e().isMultiMessageSender(paramBaseQQAppInterface, paramChatMessage);
  }
  
  public static boolean b(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    return e().initSaveToWeiYun(paramBaseQQAppInterface, paramChatMessage, paramContext);
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    return e().filterFiles(paramString1, paramString2);
  }
  
  public static long c()
  {
    return e().genMsgUid();
  }
  
  public static String c(int paramInt)
  {
    return e().getReportFileTypeStr(paramInt);
  }
  
  public static String c(FileManagerEntity paramFileManagerEntity)
  {
    return e().getZipThumbSavePath(paramFileManagerEntity);
  }
  
  public static void c(long paramLong)
  {
    e().addCloseButtonSessionId(paramLong);
  }
  
  public static boolean c(Context paramContext)
  {
    return e().isImportLocaFilesForH5(paramContext);
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    return e().hasShortCut(paramContext, paramString);
  }
  
  public static int[] c(String paramString)
  {
    return e().getMediaFileWidthHeight(paramString);
  }
  
  public static int d(int paramInt)
  {
    return e().getFileIconResId(paramInt);
  }
  
  public static long d(String paramString)
  {
    return e().getDocsImportFileMaxSize(paramString);
  }
  
  public static TimeoutParam d()
  {
    return e().getTimeOutParamer();
  }
  
  public static void d(long paramLong)
  {
    e().delCloseButtonSessionId(paramLong);
  }
  
  public static void d(FileManagerEntity paramFileManagerEntity)
  {
    e().fixEntityThumbSize(paramFileManagerEntity);
  }
  
  public static int e(int paramInt)
  {
    return e().getStatus(paramInt);
  }
  
  public static IFileManagerUtil e()
  {
    return (IFileManagerUtil)QRoute.api(IFileManagerUtil.class);
  }
  
  public static String e(String paramString)
  {
    return e().getZipThumbUrlWithFileUrl(paramString);
  }
  
  public static void e(FileManagerEntity paramFileManagerEntity)
  {
    e().createMediThumbnail(paramFileManagerEntity);
  }
  
  public static long f(int paramInt)
  {
    return e().getTempSessionType(paramInt);
  }
  
  public static BaseQQAppInterface f()
  {
    return e().getApp();
  }
  
  public static QQFileManagerUtil.VideoThumbInfo f(String paramString)
  {
    return e().syncCreateVideoThumb(paramString);
  }
  
  public static boolean f(FileManagerEntity paramFileManagerEntity)
  {
    return e().hasThumb(paramFileManagerEntity);
  }
  
  public static int g(String paramString)
  {
    return e().getQlinkIntroShowTime(paramString);
  }
  
  public static Long g()
  {
    return e().genSessionId();
  }
  
  public static String g(FileManagerEntity paramFileManagerEntity)
  {
    return e().getFileSizeInvalidTime(paramFileManagerEntity);
  }
  
  public static String h(FileManagerEntity paramFileManagerEntity)
  {
    return e().getFileOperationTypeToPeer(paramFileManagerEntity);
  }
  
  public static boolean h()
  {
    return e().is2GOr3G();
  }
  
  public static byte[] h(String paramString)
  {
    return e().getSha3(paramString);
  }
  
  public static String i()
  {
    try
    {
      String str = e().printStack();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean i(FileManagerEntity paramFileManagerEntity)
  {
    return e().hasNoThumb(paramFileManagerEntity);
  }
  
  public static byte[] i(String paramString)
  {
    return e().get3SHA(paramString);
  }
  
  public static String j()
  {
    return e().getFMDownloadPath();
  }
  
  public static void j(FileManagerEntity paramFileManagerEntity)
  {
    e().associateLocalWithCloud(paramFileManagerEntity);
  }
  
  public static byte[] j(String paramString)
  {
    return e().getMd5(paramString);
  }
  
  public static int k(String paramString)
  {
    try
    {
      int i = e().getFileType(paramString);
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean k(FileManagerEntity paramFileManagerEntity)
  {
    return e().canCreateThumb(paramFileManagerEntity);
  }
  
  public static String l(String paramString)
  {
    return e().getHardCodeConfig(paramString);
  }
  
  public static boolean l(FileManagerEntity paramFileManagerEntity)
  {
    return e().isTroopFile(paramFileManagerEntity);
  }
  
  public static long m(String paramString)
  {
    return e().getFileSizes(paramString);
  }
  
  public static void m(FileManagerEntity paramFileManagerEntity)
  {
    e().correctFileInfo(paramFileManagerEntity);
  }
  
  public static int n(FileManagerEntity paramFileManagerEntity)
  {
    return e().getFileSrcCloudType(paramFileManagerEntity);
  }
  
  public static String n(String paramString)
  {
    return e().getFileName(paramString);
  }
  
  public static boolean o(FileManagerEntity paramFileManagerEntity)
  {
    return e().isSupportFavorite(paramFileManagerEntity);
  }
  
  public static byte[] o(String paramString)
  {
    return e().getSHA(paramString);
  }
  
  public static boolean p(FileManagerEntity paramFileManagerEntity)
  {
    return e().fileWhetherExpire(paramFileManagerEntity);
  }
  
  public static byte[] p(String paramString)
  {
    return e().getFullMd5(paramString);
  }
  
  public static int q(FileManagerEntity paramFileManagerEntity)
  {
    return e().chechZipFileType(paramFileManagerEntity);
  }
  
  public static int q(String paramString)
  {
    return e().getFileIconResId(paramString);
  }
  
  public static int r(FileManagerEntity paramFileManagerEntity)
  {
    return e().chechFileType(paramFileManagerEntity);
  }
  
  public static LinkedHashMap r(String paramString)
  {
    return e().jsonToMap(paramString);
  }
  
  public static int s(String paramString)
  {
    return e().addExternalFileToFMRecv(paramString);
  }
  
  public static String t(String paramString)
  {
    return e().recreateFilePath(paramString);
  }
  
  public static int u(String paramString)
  {
    return e().delExternalFileFromFMRecv(paramString);
  }
  
  public static boolean v(String paramString)
  {
    return e().fileExist(paramString);
  }
  
  public static void w(String paramString)
  {
    e().dealWithErrCode(paramString);
  }
  
  public static String x(String paramString)
  {
    return e().createVideoThumbPath(paramString);
  }
  
  public static String y(String paramString)
  {
    return e().getFileSuffix(paramString);
  }
  
  public static boolean z(String paramString)
  {
    return e().isLocalFile(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtil
 * JD-Core Version:    0.7.0.1
 */