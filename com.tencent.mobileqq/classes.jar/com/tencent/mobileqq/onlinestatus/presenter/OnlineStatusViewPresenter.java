package com.tencent.mobileqq.onlinestatus.presenter;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineStatusBean;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.OnlineBatteryProducer;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;

public class OnlineStatusViewPresenter
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  OnlineStatusBean jdField_a_of_type_ComTencentMobileqqConfigBusinessOnlineStatusBean = (OnlineStatusBean)QConfigManager.a().a(578);
  OnlineBatteryProducer jdField_a_of_type_ComTencentWidgetOnlineBatteryProducer = new OnlineBatteryProducer();
  
  public boolean a(AppRuntime paramAppRuntime, Friends paramFriends, OnlineStatusView paramOnlineStatusView)
  {
    this.jdField_a_of_type_Long = paramFriends.uExtOnlineStatus;
    this.jdField_a_of_type_Int = paramFriends.getBatteryCapacity();
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusViewBinding", 2, new Object[] { "setOnlineStatus extStatus:", Long.valueOf(this.jdField_a_of_type_Long), " battery:", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    boolean bool = paramAppRuntime.getCurrentUin().equals(paramFriends.uin);
    OnlineStatusItem localOnlineStatusItem = OnLineStatusHelper.a().a(AppRuntime.Status.online, this.jdField_a_of_type_Long, bool ^ true);
    if ((localOnlineStatusItem.jdField_a_of_type_Int != 2) && ((this.jdField_a_of_type_Long != 1000L) || (this.jdField_a_of_type_Int > 0)))
    {
      paramAppRuntime = OnLineStatusHelper.a().b(paramAppRuntime, localOnlineStatusItem, localOnlineStatusItem.jdField_a_of_type_MqqAppAppRuntime$Status, paramFriends, paramOnlineStatusView.a(), 2);
      if ((localOnlineStatusItem.jdField_a_of_type_Long == 1030L) && (TextUtils.isEmpty(paramAppRuntime))) {
        return false;
      }
      if ((localOnlineStatusItem.jdField_a_of_type_Long == 1040L) && (TextUtils.isEmpty(paramAppRuntime))) {
        return false;
      }
      if ((localOnlineStatusItem.jdField_a_of_type_Long == 40001L) && (TextUtils.isEmpty(paramAppRuntime))) {
        return false;
      }
      if (OnlineStatusItem.a(this.jdField_a_of_type_Long)) {
        paramOnlineStatusView.setIconDrawable(this.jdField_a_of_type_ComTencentWidgetOnlineBatteryProducer.a(this.jdField_a_of_type_Int, 1));
      } else {
        paramOnlineStatusView.setIconDrawable(OnLineStatusHelper.a().a(localOnlineStatusItem, paramFriends));
      }
      paramOnlineStatusView.setDescText(paramAppRuntime);
      return true;
    }
    QLog.d("OnlineStatusViewBinding", 2, "setOnlineStatus item is null");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.presenter.OnlineStatusViewPresenter
 * JD-Core Version:    0.7.0.1
 */