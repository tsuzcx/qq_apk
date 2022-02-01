package com.tencent.mobileqq.onlinestatus.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;
import mqq.app.MobileQQ;

class AccountOnlineStateViewModel$2
  implements Runnable
{
  AccountOnlineStateViewModel$2(AccountOnlineStateViewModel paramAccountOnlineStateViewModel, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (this.a)
    {
      AccountOnlineStateViewModel.a(this.this$0).setValue(this.b);
      return;
    }
    QQToast.makeText(MobileQQ.sMobileQQ, 1, 2131887154, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel.2
 * JD-Core Version:    0.7.0.1
 */