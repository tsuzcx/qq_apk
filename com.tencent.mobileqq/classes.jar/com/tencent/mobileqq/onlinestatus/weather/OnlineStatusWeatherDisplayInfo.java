package com.tencent.mobileqq.onlinestatus.weather;

import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo.UpdateUIListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationLauncher;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import mqq.app.AppRuntime;

public class OnlineStatusWeatherDisplayInfo
  extends BaseOnlineStatusDisplayInfo
{
  private WeatherObserver k = new OnlineStatusWeatherDisplayInfo.4(this);
  
  public OnlineStatusWeatherDisplayInfo(long paramLong, BaseOnlineStatusDisplayInfo.UpdateUIListener paramUpdateUIListener, AppInterface paramAppInterface, QBaseActivity paramQBaseActivity)
  {
    super(paramLong, paramUpdateUIListener, paramAppInterface, paramQBaseActivity);
    paramAppInterface.registObserver(this.k);
  }
  
  protected void a()
  {
    this.a = this.h.getString(2131896450);
    this.d = true;
    Friends localFriends = ((IFriendDataService)this.i.getRuntimeService(IFriendDataService.class, "")).getFriend(this.i.getCurrentUin(), true, true, true);
    this.b = OnlineStatusUtil.a(this.i, localFriends, false);
  }
  
  public void a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    Intent localIntent = new Intent();
    if (paramOnlineStatusPermissionItem != null) {
      localIntent.putExtra("online_status_permission_item", paramOnlineStatusPermissionItem);
    }
    ((OnlineStatusDataManager)((IOnlineStatusManagerService)this.i.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusDataManager.class)).b(8, localIntent);
  }
  
  public void a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.h.requestPermissions(new OnlineStatusWeatherDisplayInfo.1(this, paramBoolean), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    if (paramBoolean) {
      ((OnlineStatusDataManager)((IOnlineStatusManagerService)this.i.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusDataManager.class)).b(9);
    }
  }
  
  public void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    if (paramBoolean)
    {
      a(paramOnlineStatusPermissionItem);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.h.requestPermissions(new OnlineStatusWeatherDisplayInfo.3(this, paramOnlineStatusPermissionItem), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    a(paramOnlineStatusPermissionItem);
  }
  
  public void b()
  {
    Object localObject = ((IFriendDataService)this.i.getRuntimeService(IFriendDataService.class, "")).getFriend(this.i.getCurrentUin(), true, true, true);
    OnlineAutoStatusBean localOnlineAutoStatusBean = (OnlineAutoStatusBean)QConfigManager.b().b(652);
    if ((localOnlineAutoStatusBean != null) && (localOnlineAutoStatusBean.a != null) && (!TextUtils.isEmpty(localOnlineAutoStatusBean.a.c)) && (OnlineStatusUtil.b((Friends)localObject)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localOnlineAutoStatusBean.a.c);
      localStringBuilder.append(((Friends)localObject).adCode);
      localObject = localStringBuilder.toString();
      ConstellationLauncher.c.a(this.h, (String)localObject, 4015);
      ReportHelperKt.a("0X800AF98");
    }
  }
  
  public void e()
  {
    super.e();
    if (Build.VERSION.SDK_INT >= 23) {
      this.h.requestPermissions(new OnlineStatusWeatherDisplayInfo.2(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
  }
  
  public void f()
  {
    super.f();
    this.i.unRegistObserver(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherDisplayInfo
 * JD-Core Version:    0.7.0.1
 */