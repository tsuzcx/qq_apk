package com.tencent.mobileqq.onlinestatus;

import android.os.Bundle;

class AccountOnlineStateActivity$6
  extends OnlineStatusPermissionObserver
{
  AccountOnlineStateActivity$6(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if (paramBoolean)
    {
      if (!paramBundle.getBoolean("param_need_switch_online_status")) {
        AccountOnlineStateActivity.a(this.a, true, 0);
      }
      return;
    }
    AccountOnlineStateActivity.a(this.a, true, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity.6
 * JD-Core Version:    0.7.0.1
 */