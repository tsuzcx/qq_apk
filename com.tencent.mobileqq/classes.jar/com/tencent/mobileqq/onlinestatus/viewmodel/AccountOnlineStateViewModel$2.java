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
    if (this.jdField_a_of_type_Boolean)
    {
      AccountOnlineStateViewModel.a(this.this$0).setValue(this.jdField_a_of_type_JavaUtilList);
      return;
    }
    QQToast.a(MobileQQ.sMobileQQ, 1, 2131690243, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel.2
 * JD-Core Version:    0.7.0.1
 */