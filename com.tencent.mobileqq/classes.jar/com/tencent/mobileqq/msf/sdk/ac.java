package com.tencent.mobileqq.msf.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.remote.IBaseService.Stub;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ac
  implements ServiceConnection
{
  ac(ab paramab) {}
  
  public void onBindingDied(ComponentName paramComponentName)
  {
    for (;;)
    {
      try
      {
        if (this.a.r != null)
        {
          str = this.a.r.processName;
          QLog.d("MSF.D.RemoteServiceProxy", 1, new Object[] { "onBindingDied: name = ", paramComponentName, ", process = ", str });
          return;
        }
      }
      catch (Throwable paramComponentName)
      {
        QLog.e("MSF.D.RemoteServiceProxy", 1, "log onBindingDied throw t", paramComponentName);
        return;
      }
      String str = "sdk_null";
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onServiceConnected service:");
    localStringBuilder.append(paramComponentName);
    QLog.d("MSF.D.RemoteServiceProxy", 1, localStringBuilder.toString());
    this.a.b = IBaseService.Stub.asInterface(paramIBinder);
    this.a.d();
    paramComponentName = this.a;
    paramComponentName.onProcessViewableChanged(ab.a(paramComponentName), ab.b(this.a), BaseApplication.processName);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" onServiceDisconnected ");
    localStringBuilder.append(paramComponentName);
    QLog.d("MSF.D.RemoteServiceProxy", 1, localStringBuilder.toString());
    paramComponentName = this.a;
    paramComponentName.b = null;
    paramComponentName.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.ac
 * JD-Core Version:    0.7.0.1
 */