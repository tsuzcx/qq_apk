package com.tencent.mobileqq.filemanager.api;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppActivity;

@QAPI(process={"all"})
public abstract interface IQQFileTempUtils
  extends QRouteApi
{
  public abstract void addDatalineObserver();
  
  public abstract void addObserver(FMObserver paramFMObserver);
  
  public abstract boolean bShowFlowDialog(FileManagerEntity paramFileManagerEntity, boolean paramBoolean);
  
  public abstract void cancelDatalineFile(FileManagerEntity paramFileManagerEntity);
  
  public abstract void changeKingCardWording(QQCustomDialog paramQQCustomDialog, Context paramContext, CharSequence paramCharSequence);
  
  public abstract boolean checkEnds(String paramString, String[] paramArrayOfString);
  
  public abstract boolean checkFileWithCUKingCardHelper(Activity paramActivity, int paramInt, IQQFileTempUtils.FileModelOpenVideoBrowser paramFileModelOpenVideoBrowser);
  
  public abstract boolean checkFileWithFreeWifiHelper(Activity paramActivity, int paramInt, IQQFileTempUtils.FileModelOpenVideoBrowser paramFileModelOpenVideoBrowser);
  
  public abstract boolean checkNotifyDeviceOnline(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void checkPermission(AppActivity paramAppActivity, View.OnClickListener paramOnClickListener);
  
  public abstract boolean checkStatusToResume(Activity paramActivity, BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity);
  
  public abstract boolean checkWifiWithCUKingCardHelper(boolean paramBoolean, Activity paramActivity, FMDialogUtil.FMDialogInterface paramFMDialogInterface);
  
  public abstract boolean checkWifiWithFreeWifiHelper(boolean paramBoolean, Activity paramActivity, FMDialogUtil.FMDialogInterface paramFMDialogInterface);
  
  public abstract void clearAllData(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract IFileAssistantExt createFileAssistantExt();
  
  public abstract URL createFilePicDrawlableURLWithSend(FileManagerEntity paramFileManagerEntity);
  
  public abstract ForwardFileInfo createForwardFileInfo(FileManagerEntity paramFileManagerEntity);
  
  public abstract void createShortcut(BaseQQAppInterface paramBaseQQAppInterface, Intent paramIntent, String paramString, Bitmap paramBitmap);
  
  public abstract void createThumbWithOrig(FileManagerEntity paramFileManagerEntity);
  
  public abstract Bitmap decodeFileWithBufferedStream(String paramString, BitmapFactory.Options paramOptions);
  
  public abstract boolean deleteFile(String paramString);
  
  public abstract void deleteObserver(FMObserver paramFMObserver);
  
  public abstract void deleteOfflineFile(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean);
  
  public abstract void doJumpAction(Context paramContext, String paramString);
  
  public abstract void doWithWifiChecked(FileManagerEntity paramFileManagerEntity, boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface);
  
  public abstract String downLoadDiscThumb(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity, int paramInt);
  
  public abstract void downloadDatalineFile(FileManagerEntity paramFileManagerEntity);
  
  public abstract String downloadDiscVideoThumb(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity);
  
  public abstract String downloadOfflineVideoThumb(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity);
  
  public abstract int dp2px(float paramFloat, Resources paramResources);
  
  public abstract int dp2px(int paramInt, Resources paramResources);
  
  public abstract boolean favBuilderNewFile(Activity paramActivity, FileManagerEntity paramFileManagerEntity);
  
  public abstract boolean favBuilderNewFile(Activity paramActivity, String paramString);
  
  public abstract boolean favBuilderNewLink(Activity paramActivity, String paramString);
  
  public abstract ContentValues favUtilhandleFileEntry(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity, String paramString, boolean paramBoolean);
  
  public abstract ContentValues favUtilhandleWeiyunFile(WeiYunFileInfo paramWeiYunFileInfo);
  
  public abstract String formatNewRefreshTime(long paramLong);
  
  public abstract void forwardFile(Activity paramActivity, FileManagerEntity paramFileManagerEntity);
  
  public abstract boolean forwardFileManagerEntity(FileManagerEntity paramFileManagerEntity);
  
  public abstract Intent getChatActivityIntent(Context paramContext);
  
  public abstract int getDefaultTarget(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract URLDrawable getDrawable(URL paramURL);
  
  public abstract long getDuration(String paramString);
  
  public abstract int getExifRotation(String paramString);
  
  public abstract String getExtension(String paramString);
  
  public abstract ArrayList<FavFileInfo> getFavFiles();
  
  public abstract String getFileDirectoryOf(String paramString);
  
  public abstract FileManagerEntity getFileEntityByUniseq(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, String paramString, int paramInt);
  
  public abstract int[] getFileMediaInfo(String paramString);
  
  public abstract long getFileSize(String paramString);
  
  public abstract ArrayList<FileInfo> getFiles(String paramString, boolean paramBoolean, int paramInt);
  
  public abstract int getForwardId();
  
  public abstract int getForwardUtilsForwardTypeFILE();
  
  public abstract Friends getFriendsByFriendsManager(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity);
  
  public abstract int getFromStatisticAssist(Context paramContext, String paramString1, String paramString2);
  
  public abstract String getHistoryGroupByTime(long paramLong);
  
  public abstract int getImageDegree(String paramString);
  
  public abstract Bitmap getImageThumbnail(String paramString, int paramInt1, int paramInt2);
  
  public abstract Intent getIntentForFileBrowserActivity(Activity paramActivity);
  
  public abstract boolean getIsOnline(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean getIsQRing();
  
  public abstract String getJumpActivityName();
  
  public abstract int getMsfConnectedNetType();
  
  public abstract MessageCache getMsgCache(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract List<MessageRecord> getMsgList(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt);
  
  public abstract String getMultiMsgConstantEXTRAKEYOUTESTUIN();
  
  public abstract String getMultiMsgConstantEXTRAKEYOUTESTUINTYPE();
  
  public abstract String getMultiMsgConstantEXTRAKEYOUTESTUNISEQ();
  
  public abstract int getNetWorkType(Context paramContext);
  
  public abstract String getNickByDiscussionManager(BaseQQAppInterface paramBaseQQAppInterface, String paramString);
  
  public abstract String getNickName(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt);
  
  public abstract MessageRecord getPrimaryStructMsg(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord);
  
  public abstract long getProgress(BaseQQAppInterface paramBaseQQAppInterface, String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract Pair<StringBuilder, StringBuilder> getQRCodeResult(Context paramContext, File paramFile);
  
  public abstract String getSUNIFORMABSDKDOWNLOADCANCEL();
  
  public abstract String getSUNIFORMABSDKDOWNLOADENTER();
  
  public abstract String getSUNIFORMABSDKDOWNLOADFAILD();
  
  public abstract String getSUNIFORMABSDKDOWNLOADPAUSE();
  
  public abstract String getSUNIFORMABSDKDOWNLOADRUN();
  
  public abstract String getSUNIFORMABSDKDOWNLOADSUCC();
  
  public abstract String getSUNIFORMGENDOWNLOADCANCEL();
  
  public abstract String getSUNIFORMGENDOWNLOADENTER();
  
  public abstract String getSUNIFORMGENDOWNLOADFAILD();
  
  public abstract String getSUNIFORMGENDOWNLOADPAUSE();
  
  public abstract String getSUNIFORMGENDOWNLOADRUN();
  
  public abstract String getSUNIFORMGENDOWNLOADSUCC();
  
  public abstract SpannableString getSpannableString(String paramString, QQFileManagerUtil.TipsClickedInterface paramTipsClickedInterface, ColorStateList paramColorStateList, int paramInt1, int paramInt2);
  
  public abstract Intent getSplashActivityIntent(Context paramContext, String paramString);
  
  public abstract String getTDDocFileThumbUrl(String paramString);
  
  public abstract TroopInfo getTroopInfo(BaseQQAppInterface paramBaseQQAppInterface, long paramLong);
  
  public abstract String getVipType();
  
  public abstract void gotoTIMTeamworkFileUrl(Activity paramActivity, boolean paramBoolean);
  
  public abstract boolean handleVipForTroopFile(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener);
  
  public abstract boolean hasShortCut(Activity paramActivity, String[] paramArrayOfString);
  
  public abstract long insertAIOGrayTips(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3);
  
  public abstract long insertAIOGrayTips(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, Map<String, String> paramMap, String paramString3, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void insertToFMList(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity);
  
  public abstract void insertToMemMap(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity);
  
  public abstract void insertToMemMapByFileManagerProxy(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity);
  
  public abstract boolean isContainChinese(String paramString);
  
  public abstract boolean isFileExists(String paramString);
  
  public abstract boolean isKingCard();
  
  public abstract boolean isNeedCompressCut(FileManagerEntity paramFileManagerEntity);
  
  public abstract boolean isRunIWeiyunSaveTipsHelper(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean isShowByCUKingCardHelper(Context paramContext, boolean paramBoolean, FMDialogUtil.FMDialogInterface paramFMDialogInterface);
  
  public abstract boolean isShowByFreeWifiHelper(Context paramContext, boolean paramBoolean, FMDialogUtil.FMDialogInterface paramFMDialogInterface);
  
  public abstract boolean isUndownloadDatalineEntity(FileManagerEntity paramFileManagerEntity);
  
  public abstract void notifyItemStatus(long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, Object paramObject, int paramInt3, String paramString2);
  
  public abstract void notifyItemStatus(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, Object paramObject, int paramInt3, String paramString2);
  
  public abstract void notifyUpdateRecentFileAssistant(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void onResultByDataLineHandler(boolean paramBoolean, long paramLong, int paramInt, String paramString, BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void openAIO(Context paramContext, Intent paramIntent);
  
  public abstract void openFavorite(Activity paramActivity, String paramString, long paramLong);
  
  public abstract void openFileBrowserByFileInfo(Context paramContext, FileInfo paramFileInfo, int paramInt, String paramString, View paramView);
  
  public abstract void openLocalFileViewBrowser(Activity paramActivity, LinkedHashMap<String, List<FileInfo>> paramLinkedHashMap, FileInfo paramFileInfo, View paramView, FileManagerEntity paramFileManagerEntity);
  
  public abstract void openPCFile(Activity paramActivity);
  
  public abstract void openQQBrowserWithoutAD(Context paramContext, String paramString);
  
  public abstract void openRencentFileBrowser(Activity paramActivity, ForwardFileInfo paramForwardFileInfo);
  
  public abstract void openRencentFileBrowserOnItemClick(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity, boolean paramBoolean1, String paramString, View paramView, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void openTroopFilerDetailBrowse(Activity paramActivity, ForwardFileInfo paramForwardFileInfo);
  
  public abstract void openWeiYunFileBrowser(Context paramContext, ArrayList<WeiYunFileInfo> paramArrayList, WeiYunFileInfo paramWeiYunFileInfo);
  
  public abstract long prepareForwardByDataLineMsgRecord(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, BaseQQAppInterface paramBaseQQAppInterface, int paramInt4);
  
  public abstract void previewFavImageFile(Activity paramActivity);
  
  public abstract void previewImage(Activity paramActivity, FileManagerEntity paramFileManagerEntity, boolean paramBoolean);
  
  public abstract FileManagerEntity queryFileEntityBySessionId(BaseQQAppInterface paramBaseQQAppInterface, long paramLong);
  
  public abstract FileManagerEntity queryFileEntityByUniseq(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, String paramString, int paramInt);
  
  public abstract List<FileManagerEntity> queryFileManagerEntityByNameAndSize(BaseQQAppInterface paramBaseQQAppInterface, String paramString, long paramLong);
  
  public abstract FileManagerEntity queryFileManagerEntityBySessionId(BaseQQAppInterface paramBaseQQAppInterface, long paramLong);
  
  public abstract FileManagerEntity queryFileManagerEntityByWeiYunFileIdForMemory(BaseQQAppInterface paramBaseQQAppInterface, String paramString);
  
  public abstract List<FileManagerEntity> queryMaxRecentReocrds(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void removeDatalineObserver();
  
  public abstract void reportAppStoreDownloadSuc();
  
  public abstract ArrayList<String> reqDnsForIpList(String paramString, boolean paramBoolean, int paramInt);
  
  public abstract void resetFileAssistantOnlineMark(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void resumeByFileManagerEngine(BaseQQAppInterface paramBaseQQAppInterface, long paramLong);
  
  public abstract FileManagerEntity saveOfflineFile2WeiYun(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity, String paramString);
  
  public abstract void sendFavFiles(ArrayList<FavFileInfo> paramArrayList, String paramString, int paramInt, Bundle paramBundle);
  
  public abstract void sendFileToDataline(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity);
  
  public abstract void sendFiles(ArrayList<FileInfo> paramArrayList);
  
  public abstract void sendFilesToDevice(String paramString, ArrayList<FileInfo> paramArrayList);
  
  public abstract void sendFilesWithService(ArrayList<FileInfo> paramArrayList, String paramString, byte[] paramArrayOfByte, long paramLong);
  
  public abstract FileManagerEntity sendLocalFile(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean);
  
  public abstract void sendLocalFileToTroop(Set<FileInfo> paramSet);
  
  public abstract void sendQlinkFiles(Activity paramActivity, String paramString, ArrayList<String> paramArrayList, int paramInt);
  
  public abstract long sendTencentDocEntity(FileManagerEntity paramFileManagerEntity);
  
  public abstract void sendWeiYunFile(FileManagerEntity paramFileManagerEntity);
  
  public abstract void sendWeiYunFile(WeiYunFileInfo paramWeiYunFileInfo);
  
  public abstract void setDefaultTarget(BaseQQAppInterface paramBaseQQAppInterface, int paramInt);
  
  public abstract String setEntityUuidByEntityManager(BaseQQAppInterface paramBaseQQAppInterface, MessageForFile paramMessageForFile);
  
  public abstract void setFileAssistantOnlineMark(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, boolean paramBoolean);
  
  public abstract void setForwardBundle(Intent paramIntent, Bundle paramBundle);
  
  public abstract void setImageDegree(String paramString, int paramInt);
  
  public abstract void setStorageRptNeedScan(boolean paramBoolean);
  
  public abstract BubblePopupWindow showAsDropDown(View paramView, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener, BubblePopupWindow.OnDismissListener paramOnDismissListener);
  
  public abstract void showDeviceChoose(Context paramContext, String paramString, List<FileManagerEntity> paramList, Set<FileInfo> paramSet, View.OnClickListener paramOnClickListener);
  
  public abstract void speak(String paramString);
  
  public abstract void startActivityByLinkByWeiyunFragment(Context paramContext, FileManagerEntity paramFileManagerEntity, String paramString, boolean paramBoolean);
  
  public abstract void startAppStoreByTmast(String paramString, int paramInt);
  
  public abstract void startChatAndSendMsg(Activity paramActivity, Bundle paramBundle);
  
  public abstract void startForwardActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void startForwardByOriginFile(Activity paramActivity, Intent paramIntent, boolean paramBoolean);
  
  public abstract void startSeach(Activity paramActivity);
  
  public abstract void startSeach(Activity paramActivity, int paramInt, Bundle paramBundle);
  
  public abstract void updateFileEntity(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity);
  
  public abstract boolean uploadToWyForFreeWifi(Activity paramActivity, View.OnClickListener paramOnClickListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
 * JD-Core Version:    0.7.0.1
 */