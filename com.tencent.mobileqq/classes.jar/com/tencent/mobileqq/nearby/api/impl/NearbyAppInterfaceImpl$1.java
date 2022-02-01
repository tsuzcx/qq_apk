package com.tencent.mobileqq.nearby.api.impl;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.NearbyEntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants.LogoutReason;

class NearbyAppInterfaceImpl$1
  implements Runnable
{
  NearbyAppInterfaceImpl$1(NearbyAppInterfaceImpl paramNearbyAppInterfaceImpl) {}
  
  public void run()
  {
    if (!this.this$0.emFactory.verifyAuthentication())
    {
      QLog.e("NearbyAppInterface", 1, "verify fail!");
      if (this.this$0.isLogin()) {
        this.this$0.logout(true);
      }
      Intent localIntent = new Intent("mqq.intent.action.ACCOUNT_KICKED");
      localIntent.putExtra("title", HardCodeUtil.a(2131707138));
      localIntent.putExtra("msg", HardCodeUtil.a(2131707139));
      localIntent.putExtra("reason", Constants.LogoutReason.kicked);
      localIntent.addFlags(268435456);
      BaseApplicationImpl.sApplication.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbyAppInterfaceImpl.1
 * JD-Core Version:    0.7.0.1
 */