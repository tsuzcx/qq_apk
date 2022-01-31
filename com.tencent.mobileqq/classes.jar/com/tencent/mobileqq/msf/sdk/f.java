package com.tencent.mobileqq.msf.sdk;

import android.content.Intent;
import android.net.NetworkInfo;
import com.tencent.qphone.base.util.QLog;

class f
  implements Runnable
{
  f(e parame, Intent paramIntent) {}
  
  public void run()
  {
    QLog.d(d.l(), 1, "onReceive " + this.a.getAction());
    if ("com.tencent.mobileqq.msf.bd.netchange".equals(this.a.getAction()))
    {
      NetworkInfo localNetworkInfo = (NetworkInfo)this.a.getParcelableExtra("networkInfo");
      this.b.a.a(localNetworkInfo, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.f
 * JD-Core Version:    0.7.0.1
 */