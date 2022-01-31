package com.tencent.mobileqq.msf.sdk;

import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class c
  implements Runnable
{
  c(b paramb, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      QLog.d(a.i(), 1, "receive broadcast " + this.a);
      NetworkInfo localNetworkInfo = (NetworkInfo)this.a.getParcelableExtra("networkInfo");
      a.a(BaseApplication.getContext(), localNetworkInfo);
      a.e.sendEmptyMessage(3);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(a.i(), 2, localException.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.c
 * JD-Core Version:    0.7.0.1
 */