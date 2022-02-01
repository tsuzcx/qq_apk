package com.tencent.open.model;

import android.os.Bundle;
import mqq.observer.SSOAccountObserver;

class AccountManage$2
  implements Runnable
{
  AccountManage$2(AccountManage paramAccountManage, SSOAccountObserver paramSSOAccountObserver, String paramString1, String paramString2, Bundle paramBundle) {}
  
  public void run()
  {
    this.a.onGetTicketNoPasswd(this.b, this.c.getBytes(), 4096, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.model.AccountManage.2
 * JD-Core Version:    0.7.0.1
 */