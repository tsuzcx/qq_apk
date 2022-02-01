package com.tencent.mobileqq.onlinestatus.binder;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.onlinestatus.AutoReplyAdapter;
import java.util.List;

class AccountOnlineStateBinder$4
  implements Observer<List<AutoReplyText>>
{
  AccountOnlineStateBinder$4(AccountOnlineStateBinder paramAccountOnlineStateBinder) {}
  
  public void a(List<AutoReplyText> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && (AccountOnlineStateBinder.e(this.a) != null)) {
      AccountOnlineStateBinder.e(this.a).a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountOnlineStateBinder.4
 * JD-Core Version:    0.7.0.1
 */