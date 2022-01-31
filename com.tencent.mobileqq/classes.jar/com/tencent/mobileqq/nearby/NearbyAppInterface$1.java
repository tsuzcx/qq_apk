package com.tencent.mobileqq.nearby;

import alud;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants.LogoutReason;

public class NearbyAppInterface$1
  implements Runnable
{
  NearbyAppInterface$1(NearbyAppInterface paramNearbyAppInterface) {}
  
  public void run()
  {
    if (!this.this$0.a.verifyAuthentication())
    {
      QLog.e("NearbyAppInterface", 1, "verify fail!");
      if (this.this$0.isLogin()) {
        this.this$0.logout(true);
      }
      Intent localIntent = new Intent("mqq.intent.action.ACCOUNT_KICKED");
      localIntent.putExtra("title", alud.a(2131707494));
      localIntent.putExtra("msg", alud.a(2131707495));
      localIntent.putExtra("reason", Constants.LogoutReason.kicked);
      localIntent.addFlags(268435456);
      BaseApplicationImpl.sApplication.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyAppInterface.1
 * JD-Core Version:    0.7.0.1
 */