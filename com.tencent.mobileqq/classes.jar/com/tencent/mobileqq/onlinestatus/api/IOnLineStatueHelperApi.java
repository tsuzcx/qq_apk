package com.tencent.mobileqq.onlinestatus.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;

@QAPI(process={"all"})
public abstract interface IOnLineStatueHelperApi
  extends QRouteApi
{
  public static final int ONLINE_STATUS_FROM_AIO = 1;
  public static final int ONLINE_STATUS_FROM_AIO_POPUP_DIALOG = 5;
  public static final int ONLINE_STATUS_FROM_AIO_POPUP_DIALOG_OLYMPIC = 6;
  public static final int ONLINE_STATUS_FROM_CONTACTS = 2;
  public static final int ONLINE_STATUS_FROM_CONVERSATION = 4;
  public static final int ONLINE_STATUS_FROM_PANEL = 3;
  
  public abstract boolean bindOnlineStatusView(AppRuntime paramAppRuntime, Friends paramFriends, OnlineStatusView paramOnlineStatusView);
  
  public abstract boolean enableAIOSubTitleClicked(AppRuntime paramAppRuntime, String paramString);
  
  public abstract int getButtonId(AppRuntime.Status paramStatus);
  
  public abstract String getDisplayOnlineStatusInfo(AppRuntime paramAppRuntime, Friends paramFriends, TextView paramTextView, int paramInt, OnlineStatusItem paramOnlineStatusItem, Boolean paramBoolean);
  
  public abstract Bitmap getOldStatusAIOIcon(OnlineStatusItem paramOnlineStatusItem);
  
  public abstract Class<? extends IQConfigProcessor> getOlympicConfigProcessorClass();
  
  public abstract Bitmap getOnlineStatusBatteryIcon(int paramInt1, int paramInt2);
  
  public abstract OnlineStatusItem getOnlineStatusItem(AppRuntime.Status paramStatus, long paramLong, boolean paramBoolean);
  
  public abstract String getOnlineStatusName(AppRuntime.Status paramStatus, long paramLong);
  
  public abstract long getSelfExtOnlineStatus(AppRuntime paramAppRuntime);
  
  public abstract Drawable getSelfStatusDrawable(long paramLong, AppRuntime.Status paramStatus, int paramInt, Friends paramFriends);
  
  public abstract Drawable getSelfStatusDrawable(long paramLong, AppRuntime.Status paramStatus, int paramInt1, Friends paramFriends, int paramInt2);
  
  public abstract String getSelfStatusNameBySubTitle(long paramLong, AppRuntime.Status paramStatus);
  
  public abstract int getSendBatteryStatus(int paramInt1, int paramInt2);
  
  public abstract Drawable getStatusDrawable(Friends paramFriends, long paramLong);
  
  public abstract Drawable getStatusDrawableWithBigType(Friends paramFriends, long paramLong);
  
  public abstract AppRuntime.Status getStatusFromProfile(int paramInt);
  
  public abstract OnlineStatusItem getStatusItem(int paramInt);
  
  public abstract String getStatusName(AppRuntime.Status paramStatus);
  
  public abstract String getStatusNamePlusNetWorkType(int paramInt);
  
  public abstract boolean handleAIOSubTitleClicked(AppRuntime paramAppRuntime, Activity paramActivity, String paramString, View paramView);
  
  public abstract boolean handleOlympicEggAnim(AppRuntime paramAppRuntime, View paramView);
  
  public abstract boolean hasPermission(String paramString);
  
  public abstract boolean isInOlympicMedalEvent();
  
  public abstract boolean isWeatherInfoValid(Friends paramFriends);
  
  public abstract void launchOlympicShareFragment(Activity paramActivity, Intent paramIntent);
  
  public abstract void onDestroyOlympicEggAnim(AppRuntime paramAppRuntime);
  
  public abstract void parseExtOnlineBusinessInfo(Friends paramFriends, byte[] paramArrayOfByte, String paramString);
  
  public abstract void parseFriendMusicInfo(Friends paramFriends, byte[] paramArrayOfByte, String paramString);
  
  public abstract void setSubtitleOnlineDrawable(AppRuntime paramAppRuntime, Friends paramFriends, TextView paramTextView, boolean paramBoolean);
  
  public abstract void showOnlineStatusDrawable(Friends paramFriends, TextView paramTextView, boolean paramBoolean, OnlineStatusItem paramOnlineStatusItem, int paramInt);
  
  public abstract void startAccountOnlineStateActivity(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void startAccountOnlineStateActivity(Context paramContext, Intent paramIntent);
  
  public abstract AppRuntime.Status translate(Friends paramFriends);
  
  public abstract AppRuntime.Status translateStatus(int paramInt);
  
  public abstract void updateOlympicMedalEventInfo(AppRuntime paramAppRuntime, int paramInt, long paramLong1, long paramLong2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
 * JD-Core Version:    0.7.0.1
 */