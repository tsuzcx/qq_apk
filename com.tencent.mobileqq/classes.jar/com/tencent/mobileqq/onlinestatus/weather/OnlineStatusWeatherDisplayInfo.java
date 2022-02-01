package com.tencent.mobileqq.onlinestatus.weather;

import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo.UpdateUIListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusManager;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationLauncher;

public class OnlineStatusWeatherDisplayInfo
  extends BaseOnlineStatusDisplayInfo
{
  private WeatherObserver a;
  
  public OnlineStatusWeatherDisplayInfo(long paramLong, BaseOnlineStatusDisplayInfo.UpdateUIListener paramUpdateUIListener, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramLong, paramUpdateUIListener, paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver = new OnlineStatusWeatherDisplayInfo.4(this);
    paramQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698442);
    this.jdField_a_of_type_Boolean = true;
    Friends localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    this.jdField_b_of_type_JavaLangString = OnlineStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFriends, false);
  }
  
  public void a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    Intent localIntent = new Intent();
    if (paramOnlineStatusPermissionItem != null) {
      localIntent.putExtra("online_status_permission_item", paramOnlineStatusPermissionItem);
    }
    ((OnlineStatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_MANAGER)).b(8, localIntent);
  }
  
  public void a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new OnlineStatusWeatherDisplayInfo.1(this, paramBoolean), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    while (!paramBoolean) {
      return;
    }
    ((OnlineStatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_MANAGER)).a(9);
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
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new OnlineStatusWeatherDisplayInfo.3(this, paramOnlineStatusPermissionItem), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    a(paramOnlineStatusPermissionItem);
  }
  
  public void b()
  {
    Object localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    OnlineAutoStatusBean localOnlineAutoStatusBean = (OnlineAutoStatusBean)QConfigManager.a().a(652);
    if ((localOnlineAutoStatusBean != null) && (localOnlineAutoStatusBean.a != null) && (!TextUtils.isEmpty(localOnlineAutoStatusBean.a.jdField_a_of_type_JavaLangString)) && (OnlineStatusUtil.a((Friends)localObject)))
    {
      localObject = localOnlineAutoStatusBean.a.jdField_a_of_type_JavaLangString + ((Friends)localObject).adCode;
      ConstellationLauncher.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject, 4015);
      ReportHelperKt.a("0X800AF98");
    }
  }
  
  public void d()
  {
    super.d();
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new OnlineStatusWeatherDisplayInfo.2(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherDisplayInfo
 * JD-Core Version:    0.7.0.1
 */