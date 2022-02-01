package com.tencent.mobileqq.troop.api;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.net.URL;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface ITroopCardApi
  extends QRouteApi
{
  public abstract void ForwardSdkShareOption_startGameSdkCallback(Activity paramActivity, boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2);
  
  public abstract void FreezedLiangGroup(Activity paramActivity, Object paramObject);
  
  public abstract void JoinTroopSecurityTipsHelper_showTips(AppInterface paramAppInterface, int paramInt, long paramLong, Activity paramActivity);
  
  public abstract Intent addFriendLogicActivity_startJoinTroop(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);
  
  public abstract Intent addFriendLogicActivity_startJoinTroop(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9);
  
  public abstract void addRecentTroopItemIntoRecentMsgList(AppInterface paramAppInterface, String paramString1, String paramString2, long paramLong);
  
  public abstract void addRecentTroopItemIntoRecentMsgList(AppRuntime paramAppRuntime, Object paramObject);
  
  public abstract byte[] base64Decode(String paramString);
  
  public abstract void bnrReport(AppInterface paramAppInterface, int paramInt);
  
  public abstract int[] buildCustomClipDecoderParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public abstract Dialog createQuestionDialog(Activity paramActivity);
  
  public abstract void doReportTroop(Activity paramActivity, Object paramObject, AppInterface paramAppInterface);
  
  public abstract Bitmap exifBitmapCreator_createBitmap(Bitmap paramBitmap, String paramString);
  
  public abstract Intent getChatActivityIntent(Activity paramActivity, int paramInt);
  
  public abstract String getFriendDisplayName(AppInterface paramAppInterface, String paramString);
  
  public abstract void getFriendInfo(AppInterface paramAppInterface, String paramString);
  
  public abstract Object getHighwayConfig();
  
  public abstract void getOpenID(AppInterface paramAppInterface, String paramString);
  
  public abstract Object getOpenIDFromCacheAndDB(AppInterface paramAppInterface, String paramString);
  
  public abstract Class<?> getTroopAdminListClass();
  
  public abstract Class<?> getTroopAvatarWallEditActivityClass();
  
  public abstract String getTroopCardTipsContent(Context paramContext);
  
  public abstract Class<?> getTroopClassChoiceActivtiyClass();
  
  public abstract String getTroopGameCardResDownloadPath();
  
  public abstract Class<?> getTroopTagViewActivityClass();
  
  public abstract Object get_CUSTOM_CLIP_DECODER();
  
  public abstract void goToMsgList(Activity paramActivity);
  
  public abstract void handleAppShareAction(AppRuntime paramAppRuntime, Activity paramActivity, Intent paramIntent);
  
  public abstract void handleEditClosed(boolean paramBoolean, ImageView paramImageView, Bundle paramBundle);
  
  public abstract void handleModiftyTroopHeadFreezed(Object paramObject, Context paramContext);
  
  public abstract void handleModifyNameFreezed(Object paramObject, Context paramContext);
  
  public abstract boolean isFastDoubleClick();
  
  public abstract boolean isGrayTroopForTroopGameCard(String paramString);
  
  public abstract boolean isInstanceOfTroopAvatarWallEditActivity(Activity paramActivity);
  
  public abstract void jionTroopFromTroopAssociation(Context paramContext, Object paramObject);
  
  public abstract URL nearbyImgDownloader_convertURL(String paramString);
  
  public abstract boolean needAnswerQuestion(String paramString);
  
  public abstract void openAddTroopWebInfo(Activity paramActivity, String paramString1, String paramString2);
  
  public abstract void openTroopAssociationWebPage(Context paramContext, String paramString);
  
  public abstract void openTroopInfoFromTroopAssociation(Context paramContext, Object paramObject);
  
  public abstract int parseColor(String paramString);
  
  public abstract Uri profileCardUtils_enterSnapshot(Activity paramActivity, int paramInt);
  
  public abstract void refreshTroopFace(AppInterface paramAppInterface, String paramString);
  
  public abstract void reportTask(AppInterface paramAppInterface, String paramString, int paramInt);
  
  public abstract void secRecognize(boolean paramBoolean, View paramView);
  
  public abstract void setNightModeFilterForDrawable(AppInterface paramAppInterface, Drawable paramDrawable);
  
  public abstract void startModifyHomeworkTroopNickname(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public abstract void startModifyLocationActivityForResultEx(Activity paramActivity, String paramString1, String paramString2, int paramInt);
  
  public abstract void startPhotoEdit(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3);
  
  public abstract void startPhotoList(Activity paramActivity, Bundle paramBundle);
  
  public abstract void startPhotoListEdit(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2);
  
  public abstract void storyReportor(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopCardApi
 * JD-Core Version:    0.7.0.1
 */