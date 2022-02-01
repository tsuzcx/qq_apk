package com.tencent.mobileqq.richmediabrowser.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.util.Pair;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IVideoDepend
  extends QRouteApi
{
  public abstract VideoPlayParam buildVideoPlayParam(MessageRecord paramMessageRecord, VideoPlayParam paramVideoPlayParam);
  
  public abstract void dealAddFavorite(Intent paramIntent, Activity paramActivity, AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void dealSendToFriend(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem);
  
  public abstract String getCameraMaterialName();
  
  public abstract String getCameraVideoParam();
  
  public abstract int getVideoIpType();
  
  public abstract Pair<Boolean, Boolean> hasCode(Bitmap paramBitmap);
  
  public abstract void onQRDecodeSucceed(Context paramContext, String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7);
  
  public abstract void sendToQZone(Activity paramActivity, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.IVideoDepend
 * JD-Core Version:    0.7.0.1
 */