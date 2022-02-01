package com.tencent.mobileqq.onlinestatus.viewmodel;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.ICardHandler;

class AccountOnlineStateViewModel$1
  implements Runnable
{
  AccountOnlineStateViewModel$1(AccountOnlineStateViewModel paramAccountOnlineStateViewModel) {}
  
  public void run()
  {
    ((ICardHandler)QRoute.api(ICardHandler.class)).getAutoReplyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel.1
 * JD-Core Version:    0.7.0.1
 */