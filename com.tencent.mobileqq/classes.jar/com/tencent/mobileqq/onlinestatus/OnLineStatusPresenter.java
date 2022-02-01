package com.tencent.mobileqq.onlinestatus;

import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.BatteryBroadcastReceiver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class OnLineStatusPresenter
  implements IOnLineStatusPresenter
{
  private int jdField_a_of_type_Int = 0;
  private BatteryBroadcastReceiver jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private StatusInfoCallback jdField_a_of_type_ComTencentMobileqqOnlinestatusStatusInfoCallback;
  private int b = -2147483548;
  
  public OnLineStatusPresenter(@NonNull QBaseActivity paramQBaseActivity, @NonNull StatusInfoCallback paramStatusInfoCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusStatusInfoCallback = paramStatusInfoCallback;
  }
  
  private Friends a(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Friends localFriends2 = ((IFriendDataService)localAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriend(localAppRuntime.getCurrentUin());
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (localFriends2 == null) {
        bool = true;
      }
      QLog.d("OnLineStatusPresenter", 2, new Object[] { "updateOnlineStatus friends is empty:", Boolean.valueOf(bool), " friendsEntityNotLoad=", Boolean.valueOf(paramBoolean) });
    }
    if ((localFriends2 == null) && (!paramBoolean))
    {
      a(localAppRuntime);
      return null;
    }
    Friends localFriends1 = localFriends2;
    if (localFriends2 == null)
    {
      localFriends1 = new Friends();
      localFriends1.uin = localAppRuntime.getCurrentUin();
    }
    return localFriends1;
  }
  
  private void a(Friends paramFriends, AppRuntime.Status paramStatus, long paramLong)
  {
    paramFriends = OnLineStatusHelper.a().a(paramLong, paramStatus, 0, paramFriends);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131704962));
    ((StringBuilder)localObject).append(OnLineStatusHelper.a().a(paramLong, paramStatus));
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusStatusInfoCallback.a(paramFriends, (String)localObject);
    if (QLog.isColorLevel())
    {
      paramFriends = new StringBuilder();
      paramFriends.append("user head updateOnlineStatus: ");
      paramFriends.append(paramStatus);
      QLog.d("OnLineStatusPresenter", 2, paramFriends.toString());
    }
  }
  
  private void a(Friends paramFriends, AppRuntime.Status paramStatus, long paramLong, OnlineStatusItem paramOnlineStatusItem)
  {
    Drawable localDrawable = OnLineStatusHelper.a().a(paramLong, paramStatus, 0, paramFriends);
    TextView localTextView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusStatusInfoCallback.a();
    if (localTextView == null) {
      return;
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    paramFriends = OnLineStatusHelper.a().a(localAppRuntime, paramOnlineStatusItem, paramStatus, paramFriends, localTextView, 4);
    if (!TextUtils.isEmpty(paramFriends)) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusStatusInfoCallback.a(paramFriends, localDrawable);
    }
  }
  
  private void a(AppRuntime paramAppRuntime)
  {
    IFriendDataService localIFriendDataService = (IFriendDataService)paramAppRuntime.getRuntimeService(IFriendDataService.class, "");
    ThreadManager.getSubThreadHandler().post(new OnLineStatusPresenter.1(this, localIFriendDataService, paramAppRuntime));
  }
  
  private void b(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusPresenter", 2, "registerBatteryBroadcastReceiver start");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver == null)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver = new BatteryBroadcastReceiver(paramAppRuntime);
        MobileQQ.getContext().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver, localIntentFilter);
        if (QLog.isColorLevel()) {
          QLog.d("OnLineStatusPresenter", 2, "registerBatteryBroadcastReceiver success");
        }
      }
      ((IOnlineStatusService)paramAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).registerBatteryBroadcastReceiver();
      return;
    }
    catch (Throwable paramAppRuntime)
    {
      QLog.e("OnLineStatusPresenter", 1, paramAppRuntime, new Object[] { "registerBatteryBroadcastReceiver fail" });
    }
  }
  
  private void b(AppRuntime paramAppRuntime, AppRuntime.Status paramStatus, long paramLong)
  {
    a(paramAppRuntime, paramStatus, paramLong);
    if ((paramStatus == AppRuntime.Status.online) && (paramLong == 1000L)) {
      ((IOnlineStatusService)paramAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).checkBatteryStatus();
    }
  }
  
  public int a()
  {
    if (this.b == -2147483548)
    {
      this.b = -1;
      if (a()) {
        try
        {
          this.b = ((BatteryManager)BaseApplication.getContext().getSystemService("batterymanager")).getIntProperty(4);
          if (QLog.isColorLevel()) {
            QLog.d("OnLineStatusPresenter", 2, new Object[] { "BatterManager ", Integer.valueOf(this.b) });
          }
        }
        catch (NoSuchMethodError localNoSuchMethodError)
        {
          QLog.e("OnLineStatusPresenter", 1, localNoSuchMethodError, new Object[] { "getLocalBatteryCapacity fail" });
        }
      }
    }
    return this.b;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusPresenter", 2, "unRegisterBatteryBroadcastReceiver start");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver != null)
      {
        MobileQQ.getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver);
        this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver = null;
        if (QLog.isColorLevel()) {
          QLog.d("OnLineStatusPresenter", 2, "unRegisterBatteryBroadcastReceiver success");
        }
      }
      AppRuntime localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
      if (localAppRuntime != null)
      {
        ((IOnlineStatusService)localAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).unRegisterBatteryBroadcastReceiver();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("OnLineStatusPresenter", 1, localThrowable, new Object[] { "unRegisterBatteryBroadcastReceiver fail" });
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    a(paramString, false);
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[status][conversation] updateOnlineStatus from: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" friendsEntityNotLoad: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("OnLineStatusPresenter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    paramString = ((IOnlineStatusService)((AppRuntime)localObject).getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    long l = OnLineStatusHelper.a().a((AppRuntime)localObject);
    b((AppRuntime)localObject, paramString, l);
    localObject = a(paramBoolean);
    if (localObject == null) {
      return;
    }
    OnlineStatusItem localOnlineStatusItem = OnLineStatusHelper.a().a(paramString, l);
    if (!OnLineStatusHelper.a().a(localOnlineStatusItem, (Friends)localObject, true))
    {
      l = 0L;
      paramString = AppRuntime.Status.online;
    }
    a((Friends)localObject, paramString, l, localOnlineStatusItem);
    a((Friends)localObject, paramString, l);
  }
  
  public void a(AppRuntime paramAppRuntime, AppRuntime.Status paramStatus, long paramLong)
  {
    if (paramAppRuntime != null)
    {
      if (a() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnLineStatusPresenter", 2, "handleBatteryChangeBroadcastReceiver LocalBattery correct");
        }
        if ((paramStatus == AppRuntime.Status.online) && (paramLong == 1000L))
        {
          b(paramAppRuntime);
          return;
        }
        a();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusPresenter", 2, "handleBatteryChangeBroadcastReceiver LocalBattery wrong");
      }
      int i = this.jdField_a_of_type_Int;
      if (i == 0)
      {
        b(paramAppRuntime);
        return;
      }
      if (i == 1)
      {
        if ((paramStatus == AppRuntime.Status.online) && (paramLong == 1000L))
        {
          b(paramAppRuntime);
          return;
        }
        a();
        return;
      }
      if (i == 2) {
        a();
      }
    }
  }
  
  boolean a()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnLineStatusPresenter
 * JD-Core Version:    0.7.0.1
 */