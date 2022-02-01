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
      Object localObject = a.i();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("receive broadcast ");
      localStringBuilder.append(this.a);
      QLog.d((String)localObject, 1, localStringBuilder.toString());
      localObject = (NetworkInfo)this.a.getParcelableExtra("networkInfo");
      a.a(BaseApplication.getContext(), (NetworkInfo)localObject);
      a.e.sendEmptyMessage(3);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a.i(), 2, localException.toString(), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.c
 * JD-Core Version:    0.7.0.1
 */