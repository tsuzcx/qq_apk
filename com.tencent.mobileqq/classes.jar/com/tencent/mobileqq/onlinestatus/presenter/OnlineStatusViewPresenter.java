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
  OnlineStatusBean a = (OnlineStatusBean)QConfigManager.b().b(578);
  OnlineBatteryProducer b = new OnlineBatteryProducer();
  long c;
  int d;
  
  public boolean a(AppRuntime paramAppRuntime, Friends paramFriends, OnlineStatusView paramOnlineStatusView)
  {
    this.c = paramFriends.uExtOnlineStatus;
    this.d = paramFriends.getBatteryCapacity();
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusViewBinding", 2, new Object[] { "setOnlineStatus extStatus:", Long.valueOf(this.c), " battery:", Integer.valueOf(this.d) });
    }
    boolean bool = paramAppRuntime.getCurrentUin().equals(paramFriends.uin);
    OnlineStatusItem localOnlineStatusItem = OnLineStatusHelper.a().a(AppRuntime.Status.online, this.c, bool ^ true);
    if ((localOnlineStatusItem.f != 2) && ((this.c != 1000L) || (this.d > 0)))
    {
      paramAppRuntime = OnLineStatusHelper.a().b(paramAppRuntime, localOnlineStatusItem, localOnlineStatusItem.g, paramFriends, paramOnlineStatusView.getSuffixTextView(), 2);
      if ((localOnlineStatusItem.b == 1030L) && (TextUtils.isEmpty(paramAppRuntime))) {
        return false;
      }
      if ((localOnlineStatusItem.b == 1040L) && (TextUtils.isEmpty(paramAppRuntime))) {
        return false;
      }
      if ((localOnlineStatusItem.b == 40001L) && (TextUtils.isEmpty(paramAppRuntime))) {
        return false;
      }
      if (OnlineStatusItem.a(this.c)) {
        paramOnlineStatusView.setIconDrawable(this.b.a(this.d, 1));
      } else {
        paramOnlineStatusView.setIconDrawable(OnLineStatusHelper.a().b(localOnlineStatusItem, paramFriends));
      }
      paramOnlineStatusView.setDescText(paramAppRuntime);
      return true;
    }
    QLog.d("OnlineStatusViewBinding", 2, "setOnlineStatus item is null");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.presenter.OnlineStatusViewPresenter
 * JD-Core Version:    0.7.0.1
 */