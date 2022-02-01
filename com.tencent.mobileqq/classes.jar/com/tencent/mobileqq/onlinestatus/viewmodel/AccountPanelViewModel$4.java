package com.tencent.mobileqq.onlinestatus.viewmodel;

import android.content.res.Resources;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineMusicStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineMusicStatusManager;
import com.tencent.mobileqq.onlinestatus.view.AutoStatusHintFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

class AccountPanelViewModel$4
  implements Runnable
{
  AccountPanelViewModel$4(AccountPanelViewModel paramAccountPanelViewModel, boolean paramBoolean, AppInterface paramAppInterface, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    Boolean localBoolean = Boolean.valueOf(true);
    if (bool)
    {
      long l = OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      int i;
      if ((AccountPanelViewModel.a(this.this$0) == 1000L) && (l == 1000L)) {
        i = 0;
      } else {
        i = 1;
      }
      int j = i;
      if (AccountPanelViewModel.a(this.this$0) == 1040L)
      {
        j = i;
        if (l == 1040L) {
          j = 0;
        }
      }
      if (l == 40001L) {
        j = 0;
      }
      if (!AccountPanelViewModel.b(this.this$0))
      {
        AccountPanelViewModel.c(this.this$0, true);
        if (l == 40001L) {
          AutoStatusHintFragment.a(MobileQQ.sMobileQQ);
        }
      }
      if ((j != 0) && (AccountPanelViewModel.a(this.this$0)))
      {
        String str = OnLineStatusHelper.a().a(l, this.jdField_a_of_type_MqqAppAppRuntime$Status);
        str = MobileQQ.sMobileQQ.getResources().getString(2131698509, new Object[] { str });
        QQToast.a(MobileQQ.sMobileQQ, 2, str, 1).a();
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanelViewModel", 2, "Show toast in account panel onSetOnlineStatus");
        }
      }
      ((OnlineMusicStatusManager)((IOnlineStatusManagerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineMusicStatusManager.class)).a(AccountPanelViewModel.a(this.this$0), l);
      if (!AccountPanelViewModel.a(this.this$0, l)) {
        AccountPanelViewModel.a(this.this$0).setValue(localBoolean);
      }
      AccountPanelViewModel.a(this.this$0, l);
      return;
    }
    AccountPanelViewModel.a(this.this$0).setValue(localBoolean);
    QQToast.a(MobileQQ.sMobileQQ, 1, 2131698496, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel.4
 * JD-Core Version:    0.7.0.1
 */