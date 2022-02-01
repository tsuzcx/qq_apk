package com.tencent.mobileqq.richmediabrowser.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.richmediabrowser.api.depend.IBrowserProvider;
import java.io.File;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IBrowserDepend
  extends QRouteApi
{
  public static final int DETECT_MODE_MINI = 2;
  public static final int DETECT_MODE_QR = 1;
  
  public abstract void addMsgRevokerListener(MsgRevokeListener paramMsgRevokeListener);
  
  public abstract void buildMessageRevokeUI(Activity paramActivity, RelativeLayout paramRelativeLayout);
  
  public abstract String checkQQCode(Uri paramUri, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList1, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList2, Activity paramActivity, String paramString, ShareActionSheet paramShareActionSheet);
  
  public abstract Parcelable convertAIORichMediaData(Parcelable paramParcelable);
  
  public abstract void dealAddFavorite(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2);
  
  public abstract void dealAddToEmotion(Parcelable paramParcelable, Activity paramActivity);
  
  public abstract void dealPicForwardToGroupAlbum(AIOPictureData paramAIOPictureData, Context paramContext, IProvider paramIProvider);
  
  public abstract void dealSendToWeiYun(Parcelable paramParcelable);
  
  public abstract void forwardPicToFriend(File paramFile, boolean paramBoolean, Parcelable paramParcelable, Bundle paramBundle, Activity paramActivity, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2);
  
  public abstract void forwardToFriend(Activity paramActivity, Intent paramIntent, boolean paramBoolean, int paramInt, String paramString);
  
  public abstract void fowardToQzoneAlbum(Activity paramActivity, String paramString1, String paramString2, int paramInt, Parcelable paramParcelable, boolean paramBoolean, String paramString3);
  
  public abstract String getExtraGroupCode();
  
  public abstract String getExtraGroupUin();
  
  public abstract String getExtraMutilMsg();
  
  public abstract Intent getForwardPicToFriendIntent(File paramFile, boolean paramBoolean, Parcelable paramParcelable, Bundle paramBundle, Activity paramActivity);
  
  public abstract Intent getForwardToFriendIntent(Activity paramActivity, Intent paramIntent, boolean paramBoolean);
  
  public abstract Intent getFriendPickerForForwardIntent(File paramFile, boolean paramBoolean, Parcelable paramParcelable, Bundle paramBundle, Activity paramActivity);
  
  public abstract int getSharePanelType();
  
  public abstract String getShowDataLine();
  
  public abstract void gotoChatHistoryActivity(Context paramContext, String paramString, int paramInt, Parcelable paramParcelable);
  
  public abstract boolean isFileSizeEnable(File paramFile);
  
  public abstract boolean isPicShareToWXEnable();
  
  public abstract boolean isShortVideoType(int paramInt);
  
  public abstract boolean isSoftInputPanel(int paramInt);
  
  public abstract void jumpToTargetAIOPosition(Activity paramActivity, int paramInt1, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean);
  
  public abstract void onQRDecodeSucceed(Context paramContext, String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, Intent paramIntent);
  
  public abstract void openMiniAioForDanmaku(Activity paramActivity, int paramInt, String paramString, boolean paramBoolean, long paramLong1, long paramLong2);
  
  public abstract void removeMsgRevokerListener(MsgRevokeListener paramMsgRevokeListener);
  
  public abstract void reportCommercialDrainage(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  public abstract boolean saveImageNeedBlock();
  
  public abstract void savePic(Activity paramActivity, File paramFile, String paramString);
  
  public abstract boolean saveVideoToAlbum(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean scanQrCodeNeedBlock();
  
  public abstract void sharePicToWXFromPeak(String paramString, Context paramContext);
  
  public abstract void showFriendPickerForForward(File paramFile, boolean paramBoolean, Parcelable paramParcelable, Bundle paramBundle, Activity paramActivity, int paramInt);
  
  public abstract void startChatAndSendMsg(Activity paramActivity, Bundle paramBundle);
  
  public abstract void startEditPicActivity(Activity paramActivity, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString, int paramInt3);
  
  public abstract boolean supportCapture();
  
  public abstract void updateMsgStatus(int paramInt1, long paramLong, MessageRecord paramMessageRecord, int paramInt2, IBrowserProvider paramIBrowserProvider);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
 * JD-Core Version:    0.7.0.1
 */