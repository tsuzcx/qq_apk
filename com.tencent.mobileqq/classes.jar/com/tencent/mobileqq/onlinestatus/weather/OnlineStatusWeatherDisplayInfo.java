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
  private WeatherObserver a;
  
  public OnlineStatusWeatherDisplayInfo(long paramLong, BaseOnlineStatusDisplayInfo.UpdateUIListener paramUpdateUIListener, AppInterface paramAppInterface, QBaseActivity paramQBaseActivity)
  {
    super(paramLong, paramUpdateUIListener, paramAppInterface, paramQBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver = new OnlineStatusWeatherDisplayInfo.4(this);
    paramAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131698508);
    this.jdField_a_of_type_Boolean = true;
    Friends localFriends = ((IFriendDataService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriend(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), true, true, true);
    this.jdField_b_of_type_JavaLangString = OnlineStatusUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, localFriends, false);
  }
  
  public void a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    Intent localIntent = new Intent();
    if (paramOnlineStatusPermissionItem != null) {
      localIntent.putExtra("online_status_permission_item", paramOnlineStatusPermissionItem);
    }
    ((OnlineStatusDataManager)((IOnlineStatusManagerService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusDataManager.class)).b(8, localIntent);
  }
  
  public void a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.requestPermissions(new OnlineStatusWeatherDisplayInfo.1(this, paramBoolean), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    if (paramBoolean) {
      ((OnlineStatusDataManager)((IOnlineStatusManagerService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusDataManager.class)).a(9);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.requestPermissions(new OnlineStatusWeatherDisplayInfo.3(this, paramOnlineStatusPermissionItem), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    a(paramOnlineStatusPermissionItem);
  }
  
  public void b()
  {
    Object localObject = ((IFriendDataService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriend(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), true, true, true);
    OnlineAutoStatusBean localOnlineAutoStatusBean = (OnlineAutoStatusBean)QConfigManager.a().a(652);
    if ((localOnlineAutoStatusBean != null) && (localOnlineAutoStatusBean.a != null) && (!TextUtils.isEmpty(localOnlineAutoStatusBean.a.jdField_a_of_type_JavaLangString)) && (OnlineStatusUtil.a((Friends)localObject)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localOnlineAutoStatusBean.a.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(((Friends)localObject).adCode);
      localObject = localStringBuilder.toString();
      ConstellationLauncher.a.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, (String)localObject, 4015);
      ReportHelperKt.a("0X800AF98");
    }
  }
  
  public void d()
  {
    super.d();
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.requestPermissions(new OnlineStatusWeatherDisplayInfo.2(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherDisplayInfo
 * JD-Core Version:    0.7.0.1
 */