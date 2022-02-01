package com.tencent.mobileqq.onlinestatus.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusConstants;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfProcessor;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusOlympicManager;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineMusicStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusOlympicManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.olympic.fragment.OlympicShareFragment;
import com.tencent.mobileqq.onlinestatus.olympic.model.OlympicMedalEventInfo;
import com.tencent.mobileqq.onlinestatus.presenter.OnlineStatusViewPresenter;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusTranslateUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class OnLineStatueHelperApiImpl
  implements IOnLineStatueHelperApi
{
  OnlineStatusViewPresenter mViewBinding;
  
  private Bitmap getBitmap(AppRuntime.Status paramStatus, BitmapFactory.Options paramOptions)
  {
    switch (OnLineStatueHelperApiImpl.1.a[paramStatus.ordinal()])
    {
    default: 
      return null;
    case 6: 
      return BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), 2130837648, paramOptions);
    case 5: 
      return BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), 2130837646, paramOptions);
    case 4: 
      return BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), 2130837643, paramOptions);
    case 3: 
      return BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), 2130837641, paramOptions);
    case 2: 
      return BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), 2130837652, paramOptions);
    }
    return BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), 2130837650, paramOptions);
  }
  
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
    return OnlineStatusConstants.c(paramStatus);
  }
  
  public String getDisplayOnlineStatusInfo(AppRuntime paramAppRuntime, Friends paramFriends, TextView paramTextView, int paramInt, OnlineStatusItem paramOnlineStatusItem, Boolean paramBoolean)
  {
    return OnLineStatusHelper.a().a(paramAppRuntime, paramFriends, paramTextView, paramInt, paramOnlineStatusItem, paramBoolean);
  }
  
  public Bitmap getOldStatusAIOIcon(OnlineStatusItem paramOnlineStatusItem)
  {
    if (paramOnlineStatusItem.f == 2)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      getBitmap(paramOnlineStatusItem.g, localOptions);
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = (localOptions.outHeight / ViewUtils.dip2px(16.0F));
      return getBitmap(paramOnlineStatusItem.g, localOptions);
    }
    return null;
  }
  
  public Class<? extends IQConfigProcessor> getOlympicConfigProcessorClass()
  {
    return OlympicConfProcessor.class;
  }
  
  public Bitmap getOnlineStatusBatteryIcon(int paramInt1, int paramInt2)
  {
    return OnLineStatusHelper.a().a(paramInt1, paramInt2);
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
      if ((localOnlineStatusItem != null) && (!TextUtils.isEmpty(localOnlineStatusItem.c))) {
        return localOnlineStatusItem.c;
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
  
  public Drawable getSelfStatusDrawable(long paramLong, AppRuntime.Status paramStatus, int paramInt1, Friends paramFriends, int paramInt2)
  {
    return OnLineStatusHelper.a().a(paramLong, paramStatus, paramInt1, paramFriends, paramInt2);
  }
  
  public String getSelfStatusNameBySubTitle(long paramLong, AppRuntime.Status paramStatus)
  {
    return OnLineStatusHelper.a().b(paramLong, paramStatus);
  }
  
  public int getSendBatteryStatus(int paramInt1, int paramInt2)
  {
    return OnLineStatusHelper.b(paramInt1, paramInt2);
  }
  
  public Drawable getStatusDrawable(Friends paramFriends, long paramLong)
  {
    Object localObject = OnlineStatusTranslateUtils.a(paramFriends);
    localObject = OnLineStatusHelper.a().a((AppRuntime.Status)localObject, paramLong);
    return OnLineStatusHelper.a().b((OnlineStatusItem)localObject, paramFriends);
  }
  
  public Drawable getStatusDrawableWithBigType(Friends paramFriends, long paramLong)
  {
    Object localObject = OnlineStatusTranslateUtils.a(paramFriends);
    localObject = OnLineStatusHelper.a().a((AppRuntime.Status)localObject, paramLong);
    return OnLineStatusHelper.a().a((OnlineStatusItem)localObject, paramFriends, 5);
  }
  
  public AppRuntime.Status getStatusFromProfile(int paramInt)
  {
    return OnlineStatusConstants.a(paramInt);
  }
  
  public OnlineStatusItem getStatusItem(int paramInt)
  {
    return Constant.b(paramInt);
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
  
  public boolean handleOlympicEggAnim(AppRuntime paramAppRuntime, View paramView)
  {
    return ((OnlineStatusOlympicManager)((IOnlineStatusManagerService)paramAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusOlympicManager.class)).a(paramView);
  }
  
  public boolean hasPermission(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    Object localObject = ((OnlineStatusPermissionManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class)).a(40001L, false, null);
    bool1 = bool2;
    if (localObject != null)
    {
      localObject = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, ((OnlineStatusFriendsPermissionItem)localObject).allHasPermission, ((OnlineStatusFriendsPermissionItem)localObject).permissionUins);
      bool1 = bool2;
      if (!((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject).isAllHasPermission())
      {
        if (((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject).getPermissionUins().contains(Long.valueOf(Long.parseLong(paramString)))) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean isInOlympicMedalEvent()
  {
    return OnLineStatusHelper.a().d();
  }
  
  public boolean isWeatherInfoValid(Friends paramFriends)
  {
    return OnlineStatusUtil.b(paramFriends);
  }
  
  public void launchOlympicShareFragment(Activity paramActivity, Intent paramIntent)
  {
    OlympicShareFragment.a(paramActivity, paramIntent);
  }
  
  public void onDestroyOlympicEggAnim(AppRuntime paramAppRuntime)
  {
    ((OnlineStatusOlympicManager)((IOnlineStatusManagerService)paramAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusOlympicManager.class)).d();
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
  
  public AppRuntime.Status translate(Friends paramFriends)
  {
    return OnlineStatusTranslateUtils.a(paramFriends);
  }
  
  public AppRuntime.Status translateStatus(int paramInt)
  {
    return OnlineStatusTranslateUtils.a(paramInt);
  }
  
  public void updateOlympicMedalEventInfo(AppRuntime paramAppRuntime, int paramInt, long paramLong1, long paramLong2, String paramString)
  {
    ((OnlineStatusOlympicManager)((IOnlineStatusManagerService)paramAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusOlympicManager.class)).a(new OlympicMedalEventInfo(paramInt, paramLong1, paramLong2, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.api.impl.OnLineStatueHelperApiImpl
 * JD-Core Version:    0.7.0.1
 */