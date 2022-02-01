package com.tencent.mobileqq.onlinestatus.binder;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.onlinestatus.AccountPanel;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanelParams;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusData;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusMood;
import com.tencent.mobileqq.onlinestatus.view.AccountPanelViewContainer;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

class AccountPanelBinder$9
  implements Observer<OnlineStatusMood>
{
  AccountPanelBinder$9(AccountPanelBinder paramAccountPanelBinder, OnlineStatusPanelParams paramOnlineStatusPanelParams, AccountPanel paramAccountPanel, AccountPanelViewModel paramAccountPanelViewModel, AccountPanelViewContainer paramAccountPanelViewContainer) {}
  
  public void a(OnlineStatusMood paramOnlineStatusMood)
  {
    if (!paramOnlineStatusMood.b) {
      this.a.m = false;
    }
    if (!this.b.isShowing())
    {
      QLog.d("AccountPanelViewModel", 2, "refreshPanelWhenMoodChange dialog not showing");
      return;
    }
    if ((paramOnlineStatusMood.b) || (paramOnlineStatusMood.a))
    {
      paramOnlineStatusMood = MobileQQ.sMobileQQ.peekAppRuntime();
      AppRuntime.Status localStatus = ((IOnlineStatusService)paramOnlineStatusMood.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
      long l = OnLineStatusHelper.a().a(paramOnlineStatusMood);
      this.c.g().setValue(new OnlineStatusData(localStatus, l));
      this.b.b(localStatus, l);
      this.d.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountPanelBinder.9
 * JD-Core Version:    0.7.0.1
 */