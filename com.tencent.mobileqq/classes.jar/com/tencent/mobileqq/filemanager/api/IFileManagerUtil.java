package com.tencent.mobileqq.filemanager.api;

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
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.CheckResult;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.IThumbResult;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.VideoThumbInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.TimeoutParam;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IFileManagerUtil
  extends QRouteApi
{
  public abstract void addCloseButtonSessionId(long paramLong);
  
  public abstract int addExternalFileToFMRecv(String paramString);
  
  public abstract void addShortcut(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt);
  
  public abstract void associateLocalWithCloud(FileManagerEntity paramFileManagerEntity);
  
  public abstract boolean bShowFlowDlg(boolean paramBoolean, ArrayList<FileManagerEntity> paramArrayList);
  
  public abstract boolean bZip(int paramInt);
  
  public abstract String binToHEX(ByteStringMicro paramByteStringMicro);
  
  public abstract int binanrySearch(List<FileInfo> paramList, long paramLong);
  
  public abstract void calcFileDescription(TextView paramTextView, FileManagerEntity paramFileManagerEntity);
  
  public abstract boolean canCreateThumb(FileManagerEntity paramFileManagerEntity);
  
  public abstract boolean canPreview(Context paramContext, String paramString, long paramLong);
  
  public abstract int chechFileType(FileManagerEntity paramFileManagerEntity);
  
  public abstract int chechZipFileType(FileManagerEntity paramFileManagerEntity);
  
  public abstract void checkFileExisted(FileManagerEntity paramFileManagerEntity, BaseQQAppInterface paramBaseQQAppInterface, QQFileManagerUtil.CheckResult paramCheckResult);
  
  public abstract boolean checkMultiFileBubbleClickable(ChatMessage paramChatMessage, BaseQQAppInterface paramBaseQQAppInterface, Context paramContext);
  
  public abstract void clearAllRecentFileForTest();
  
  public abstract void clearRememberPicSelectForQlink(Context paramContext);
  
  public abstract void correctFileInfo(FileManagerEntity paramFileManagerEntity);
  
  public abstract FileManagerEntity createFileRecordForMultiMsg(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage);
  
  public abstract void createMediThumbnail(FileManagerEntity paramFileManagerEntity);
  
  public abstract String createMediaThumbnail(String paramString, int paramInt1, int paramInt2, QQFileManagerUtil.IThumbResult paramIThumbResult);
  
  public abstract String createVideoThumbPath(String paramString);
  
  public abstract String cutLongLongFileName(String paramString, int paramInt);
  
  public abstract String cutLongName(String paramString);
  
  public abstract void dealWithErrCode(String paramString);
  
  public abstract boolean dealWithErrCode(int paramInt, String paramString);
  
  public abstract void dealWithErrCodeById(int paramInt);
  
  public abstract void dealWithTransFileFaild(long paramLong, int paramInt, String paramString);
  
  public abstract void dealWithTransFileSuc(long paramLong);
  
  public abstract void delCloseButtonSessionId(long paramLong);
  
  public abstract int delExternalFileFromFMRecv(String paramString);
  
  public abstract void downloadUniformQQBrowser(Context paramContext, String paramString, Bundle paramBundle);
  
  public abstract String enCodecString(String paramString);
  
  public abstract boolean fileExist(String paramString);
  
  public abstract boolean fileWhetherExpire(FileManagerEntity paramFileManagerEntity);
  
  public abstract String filesizeToString(long paramLong);
  
  public abstract void fillFileMessageRecord(ChatMessage paramChatMessage, MessageForFile paramMessageForFile);
  
  public abstract boolean filterFiles(String paramString1, String paramString2);
  
  public abstract void fixEntityThumbSize(FileManagerEntity paramFileManagerEntity);
  
  public abstract void forwardRencentFiles(List<FileManagerEntity> paramList, Activity paramActivity);
  
  public abstract long genMsgSeq();
  
  public abstract long genMsgUid();
  
  public abstract Long genSessionId();
  
  public abstract byte[] get3SHA(String paramString);
  
  public abstract ArrayList<FileInfo> getAllFMRecvFiles(boolean paramBoolean, int paramInt);
  
  public abstract Map<String, File> getAllStorageLocations(Context paramContext);
  
  public abstract BaseQQAppInterface getApp();
  
  public abstract Bitmap getCircleFaceBitmap(Context paramContext, Bitmap paramBitmap, int paramInt);
  
  public abstract SpannableString getClickableTips(String paramString1, String paramString2, QQFileManagerUtil.TipsClickedInterface paramTipsClickedInterface);
  
  public abstract IForwardCallBack getDatalineProcessCallBack(BaseQQAppInterface paramBaseQQAppInterface, int paramInt);
  
  public abstract HashMap<String, String> getDocsImportConfigGroupFromStr(String paramString);
  
  public abstract long getDocsImportFileMaxSize(String paramString);
  
  public abstract String getFMDownloadPath();
  
  public abstract int getFileIconResId(int paramInt);
  
  public abstract int getFileIconResId(int paramInt1, int paramInt2);
  
  public abstract int getFileIconResId(String paramString);
  
  public abstract FileManagerEntity getFileManagerEntityByMsgFile(BaseQQAppInterface paramBaseQQAppInterface, MessageForFile paramMessageForFile);
  
  public abstract String getFileName(String paramString);
  
  public abstract String getFileOperationTypeToPeer(FileManagerEntity paramFileManagerEntity);
  
  public abstract FileManagerEntity getFileRecordForMultiMsg(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, String paramString, int paramInt, ChatMessage paramChatMessage);
  
  public abstract String getFileSizeInvalidTime(FileManagerEntity paramFileManagerEntity);
  
  public abstract long getFileSizes(String paramString);
  
  public abstract int getFileSrcCloudType(FileManagerEntity paramFileManagerEntity);
  
  public abstract String getFileSuffix(String paramString);
  
  public abstract int getFileType(String paramString);
  
  public abstract String getFileType(int paramInt);
  
  public abstract int getFileTypeFromMultiMsgRecord(ChatMessage paramChatMessage);
  
  public abstract byte[] getFullMd5(String paramString);
  
  public abstract String getHardCodeConfig(String paramString);
  
  public abstract String getImageUrl(FileManagerEntity paramFileManagerEntity);
  
  public abstract byte[] getMd5(String paramString);
  
  public abstract byte[] getMd5(String paramString, long paramLong);
  
  public abstract int[] getMediaFileWidthHeight(String paramString);
  
  public abstract String getMultiFileThumbPath(ChatMessage paramChatMessage);
  
  public abstract String getPeerNick(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt);
  
  public abstract String getQQStr(int paramInt);
  
  public abstract int getQlinkIntroShowTime(String paramString);
  
  public abstract String getReportFileTypeStr(int paramInt);
  
  public abstract AppRuntime getRuntime();
  
  public abstract byte[] getSHA(String paramString);
  
  public abstract FileManagerEntity getSelectedEntity();
  
  public abstract byte[] getSha3(String paramString);
  
  public abstract void getSortMap(TreeMap<Long, FileInfo> paramTreeMap, int paramInt, LinkedHashMap<String, List<FileInfo>> paramLinkedHashMap1, LinkedHashMap<String, List<FileInfo>> paramLinkedHashMap2, List<FileInfo> paramList);
  
  public abstract int getStatus(int paramInt);
  
  public abstract byte[] getTempSessionSig(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt);
  
  public abstract long getTempSessionType(int paramInt);
  
  public abstract TimeoutParam getTimeOutParamer();
  
  public abstract long getWeiyunZipTargetId(long paramLong);
  
  public abstract String getZipThumbSavePath(FileManagerEntity paramFileManagerEntity);
  
  public abstract String getZipThumbUrlWithFileUrl(String paramString);
  
  public abstract String handleLongFileName(String paramString, boolean paramBoolean, int paramInt1, TextPaint paramTextPaint, int paramInt2);
  
  public abstract boolean hasNoThumb(FileManagerEntity paramFileManagerEntity);
  
  public abstract boolean hasShortCut(Context paramContext, String paramString);
  
  public abstract boolean hasThumb(FileManagerEntity paramFileManagerEntity);
  
  public abstract String hexToString(byte[] paramArrayOfByte);
  
  public abstract boolean ifShowFileMask(Context paramContext, FileManagerEntity paramFileManagerEntity);
  
  public abstract void initNoMedia();
  
  public abstract void initSaveToPc(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage, Context paramContext);
  
  public abstract boolean initSaveToWeiYun(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage, Context paramContext);
  
  public abstract boolean initSaveToWeiYun(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage, Context paramContext, boolean paramBoolean);
  
  public abstract void installApkFile(Context paramContext, String paramString);
  
  public abstract boolean is2GOr3G();
  
  public abstract boolean isBuddyIntroShow(String paramString1, String paramString2);
  
  public abstract boolean isContainChinese(String paramString);
  
  public abstract boolean isDebugVersion();
  
  public abstract boolean isImportLocaFilesForH5(Context paramContext);
  
  public abstract boolean isLocalFile(String paramString);
  
  public abstract boolean isMultiMessageSender(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage);
  
  public abstract boolean isPreDownloadThumb();
  
  public abstract boolean isSameDay(long paramLong1, long paramLong2, TimeZone paramTimeZone);
  
  public abstract boolean isSelectedFavImageEntity();
  
  public abstract boolean isSupportFavorite(FileManagerEntity paramFileManagerEntity);
  
  public abstract boolean isTroopFile(FileManagerEntity paramFileManagerEntity);
  
  public abstract LinkedHashMap jsonToMap(String paramString);
  
  public abstract String mapToJson(Map paramMap);
  
  public abstract String millsTimeToString(long paramLong, int paramInt);
  
  public abstract FileManagerEntity newEntityByFav(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, int paramInt);
  
  public abstract FileManagerEntity newEntityByLocalFileInfo(FileInfo paramFileInfo);
  
  public abstract FileManagerEntity newEntityByOfflineFileInfo(OfflineFileInfo paramOfflineFileInfo, int paramInt);
  
  public abstract FileManagerEntity newEntityByWeiYunFileInfo(WeiYunFileInfo paramWeiYunFileInfo);
  
  public abstract FileManagerEntity newEntityByWeiYunMiniAppParams(Bundle paramBundle);
  
  public abstract void onDatalineForward(FileManagerEntity paramFileManagerEntity, BaseQQAppInterface paramBaseQQAppInterface, Activity paramActivity, int paramInt);
  
  public abstract void onQlinkFileErrIconClicked(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity);
  
  public abstract void openFileWithOtherAppWithSystem(Context paramContext, String paramString);
  
  public abstract void openWithOtherApp(Activity paramActivity, String paramString);
  
  public abstract void preLoadThumb(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity);
  
  public abstract String printFileManagerEntityInfo(FileManagerEntity paramFileManagerEntity);
  
  public abstract String printStack();
  
  public abstract void processAIOTimGraytips(BaseQQAppInterface paramBaseQQAppInterface, long paramLong);
  
  public abstract String recreateFilePath(String paramString);
  
  public abstract boolean renameFile(VFSFile paramVFSFile1, VFSFile paramVFSFile2);
  
  public abstract boolean renameFile(File paramFile1, File paramFile2);
  
  public abstract void reportFileAssistans(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext);
  
  public abstract void reportFilemanagerFaildInfo(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10);
  
  public abstract void reportFilemanagerFaildInfoEx(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10, Bundle paramBundle);
  
  public abstract void reportFilemanagerSuccessInfo(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6);
  
  public abstract void reportFilemanagerSuccessInfoEx(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6, Bundle paramBundle);
  
  public abstract String reportSrcType(int paramInt1, int paramInt2);
  
  public abstract void resume(Context paramContext, FileManagerEntity paramFileManagerEntity, BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean);
  
  public abstract void saveQlinkIntroShowTime(String paramString, int paramInt);
  
  public abstract void saveToAlbum(Context paramContext, String paramString);
  
  public abstract void setBuddyIntroShow(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void setFileIcon(ImageView paramImageView, FileManagerEntity paramFileManagerEntity);
  
  public abstract void setFileIcon(ImageView paramImageView, String paramString);
  
  public abstract void setFileIcon(AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity);
  
  public abstract void setFileIcon(AsyncImageView paramAsyncImageView, String paramString);
  
  public abstract void setFileIcon(AsyncImageView paramAsyncImageView, String paramString, int paramInt);
  
  public abstract void setFileIcon(AsyncImageView paramAsyncImageView, String paramString, boolean paramBoolean);
  
  public abstract void setTempParam(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity);
  
  public abstract void setZipImageFileIcon(AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity);
  
  public abstract void showFlowDialog(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface);
  
  public abstract void showFlowDialog(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface, int paramInt);
  
  public abstract void startLoadingAnim(Activity paramActivity, TextView paramTextView);
  
  public abstract void stopLoadingAnim(TextView paramTextView);
  
  public abstract QQFileManagerUtil.VideoThumbInfo syncCreateVideoThumb(String paramString);
  
  public abstract void updateBatProcessTips(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt);
  
  public abstract String updateRecentListTxt(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage);
  
  public abstract String updateRecentListTxtByMessageRecord(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IFileManagerUtil
 * JD-Core Version:    0.7.0.1
 */