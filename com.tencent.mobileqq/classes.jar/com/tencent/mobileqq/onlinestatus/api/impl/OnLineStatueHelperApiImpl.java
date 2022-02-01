package com.tencent.mobileqq.onlinestatus.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusConstants;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.mobileqq.onlinestatus.manager.OnlineMusicStatusManager;
import com.tencent.mobileqq.onlinestatus.presenter.OnlineStatusViewPresenter;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusTranslateUtils;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;

public class OnLineStatueHelperApiImpl
  implements IOnLineStatueHelperApi
{
  OnlineStatusViewPresenter mViewBinding;
  
  public boolean bindOnlineStatusView(AppRuntime paramAppRuntime, Friends paramFriends, OnlineStatusView paramOnlineStatusView)
  {
    if (this.mViewBinding == null) {
      this.mViewBinding = new OnlineStatusViewPresenter();
    }
    return this.mViewBinding.a(paramAppRuntime, paramFriends, paramOnlineStatusView);
  }
  
  public boolean enableAIOSubTitleClicked(AppRuntime paramAppRuntime, String paramString)
  {
    return OnLineStatusHelper.a().a(paramAppRuntime, paramString);
  }
  
  public int getButtonId(AppRuntime.Status paramStatus)
  {
    return OnlineStatusConstants.a(paramStatus);
  }
  
  public String getDisplayOnlineStatusInfo(AppRuntime paramAppRuntime, Friends paramFriends, TextView paramTextView, int paramInt, OnlineStatusItem paramOnlineStatusItem, Boolean paramBoolean)
  {
    return OnLineStatusHelper.a().a(paramAppRuntime, paramFriends, paramTextView, paramInt, paramOnlineStatusItem, paramBoolean);
  }
  
  public OnlineStatusItem getOnlineStatusItem(AppRuntime.Status paramStatus, long paramLong, boolean paramBoolean)
  {
    return OnLineStatusHelper.a().a(paramStatus, paramLong, paramBoolean);
  }
  
  public String getOnlineStatusName(AppRuntime.Status paramStatus, long paramLong)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      if (paramLong == 1000L) {
        return "我的电量";
      }
      OnlineStatusItem localOnlineStatusItem = getOnlineStatusItem(AppRuntime.Status.online, paramLong, false);
      if ((localOnlineStatusItem != null) && (!TextUtils.isEmpty(localOnlineStatusItem.b))) {
        return localOnlineStatusItem.b;
      }
    }
    return OnlineStatusConstants.a(paramStatus);
  }
  
  public long getSelfExtOnlineStatus(AppRuntime paramAppRuntime)
  {
    return OnLineStatusHelper.a().a(paramAppRuntime);
  }
  
  public Drawable getSelfStatusDrawable(long paramLong, AppRuntime.Status paramStatus, int paramInt, Friends paramFriends)
  {
    return OnLineStatusHelper.a().a(paramLong, paramStatus, paramInt, paramFriends);
  }
  
  public String getSelfStatusNameBySubTitle(long paramLong, AppRuntime.Status paramStatus)
  {
    return OnLineStatusHelper.a().b(paramLong, paramStatus);
  }
  
  public int getSendBatteryStatus(int paramInt1, int paramInt2)
  {
    return OnLineStatusHelper.a(paramInt1, paramInt2);
  }
  
  public AppRuntime.Status getStatusFromProfile(int paramInt)
  {
    return OnlineStatusConstants.a(paramInt);
  }
  
  public OnlineStatusItem getStatusItem(int paramInt)
  {
    return Constant.a(paramInt);
  }
  
  public String getStatusName(AppRuntime.Status paramStatus)
  {
    return OnlineStatusConstants.a(paramStatus);
  }
  
  public String getStatusNamePlusNetWorkType(int paramInt)
  {
    return OnlineStatusUtil.a(paramInt);
  }
  
  public boolean handleAIOSubTitleClicked(AppRuntime paramAppRuntime, Activity paramActivity, String paramString, View paramView)
  {
    return OnLineStatusHelper.a().a(paramAppRuntime, paramActivity, paramString, paramView);
  }
  
  public boolean isWeatherInfoValid(Friends paramFriends)
  {
    return OnlineStatusUtil.a(paramFriends);
  }
  
  public void parseExtOnlineBusinessInfo(Friends paramFriends, byte[] paramArrayOfByte, String paramString)
  {
    OnlineStatusUtil.a(paramFriends, paramArrayOfByte, paramString);
  }
  
  public void parseFriendMusicInfo(Friends paramFriends, byte[] paramArrayOfByte, String paramString)
  {
    OnlineMusicStatusManager.a(paramFriends, paramArrayOfByte, paramString);
  }
  
  public void setSubtitleOnlineDrawable(AppRuntime paramAppRuntime, Friends paramFriends, TextView paramTextView, boolean paramBoolean)
  {
    OnLineStatusHelper.a().a(paramAppRuntime, paramFriends, paramTextView, paramBoolean);
  }
  
  public void showOnlineStatusDrawable(Friends paramFriends, TextView paramTextView, boolean paramBoolean, OnlineStatusItem paramOnlineStatusItem, int paramInt)
  {
    OnLineStatusHelper.a().a(paramFriends, paramTextView, paramBoolean, paramOnlineStatusItem, paramInt);
  }
  
  public void startAccountOnlineStateActivity(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    QPublicFragmentActivity.startForResult(paramActivity, paramIntent, AccountOnlineStateActivity.class, paramInt);
  }
  
  public void startAccountOnlineStateActivity(Context paramContext, Intent paramIntent)
  {
    QPublicFragmentActivity.start(paramContext, paramIntent, AccountOnlineStateActivity.class);
  }
  
  public AppRuntime.Status translateStatus(int paramInt)
  {
    return OnlineStatusTranslateUtils.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.api.impl.OnLineStatueHelperApiImpl
 * JD-Core Version:    0.7.0.1
 */