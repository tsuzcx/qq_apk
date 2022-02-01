package com.tencent.mobileqq.onlinestatus.viewmodel;

import android.content.res.Resources;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineMusicStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineMusicStatusManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

class AccountPanelViewModel$3
  implements Runnable
{
  AccountPanelViewModel$3(AccountPanelViewModel paramAccountPanelViewModel, boolean paramBoolean, AppInterface paramAppInterface, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    boolean bool = this.a;
    Boolean localBoolean = Boolean.valueOf(true);
    if (bool)
    {
      long l = OnLineStatusHelper.a().a(this.b);
      int i;
      if ((AccountPanelViewModel.a(this.this$0) == 1000L) && (l == 1000L)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((i != 0) && (AccountPanelViewModel.b(this.this$0)))
      {
        String str = OnLineStatusHelper.a().a(l, this.c);
        str = MobileQQ.sMobileQQ.getResources().getString(2131896451, new Object[] { str });
        QQToast.makeText(MobileQQ.sMobileQQ, 2, str, 1).show();
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanelViewModel", 2, "Show toast in account panel mAccountObserver");
        }
      }
      this.this$0.o();
      ((OnlineMusicStatusManager)((IOnlineStatusManagerService)this.b.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineMusicStatusManager.class)).a(AccountPanelViewModel.a(this.this$0), l);
      if (!AccountPanelViewModel.a(this.this$0, l)) {
        AccountPanelViewModel.c(this.this$0).setValue(localBoolean);
      }
      AccountPanelViewModel.b(this.this$0, l);
      return;
    }
    AccountPanelViewModel.c(this.this$0).setValue(localBoolean);
    QQToast.makeText(MobileQQ.sMobileQQ, 1, 2131896438, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel.3
 * JD-Core Version:    0.7.0.1
 */