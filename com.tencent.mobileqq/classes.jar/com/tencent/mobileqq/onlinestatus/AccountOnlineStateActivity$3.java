package com.tencent.mobileqq.onlinestatus;

import anri;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

class AccountOnlineStateActivity$3
  implements Runnable
{
  AccountOnlineStateActivity$3(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void run()
  {
    anri localanri = (anri)AccountOnlineStateActivity.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (localanri != null) {
      localanri.B();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity.3
 * JD-Core Version:    0.7.0.1
 */