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
    Object localObject = d.l();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceive ");
    localStringBuilder.append(this.a.getAction());
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    if ("com.tencent.mobileqq.msf.bd.netchange".equals(this.a.getAction()))
    {
      localObject = (NetworkInfo)this.a.getParcelableExtra("networkInfo");
      this.b.a.a((NetworkInfo)localObject, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.f
 * JD-Core Version:    0.7.0.1
 */