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
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.d("MSF.D.RemoteServiceProxy", 1, "onServiceConnected service:" + paramComponentName);
    this.a.c = IBaseService.Stub.asInterface(paramIBinder);
    this.a.d();
    this.a.onProcessViewableChanged(ab.a(this.a), ab.b(this.a), BaseApplication.processName);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.d("MSF.D.RemoteServiceProxy", 1, " onServiceDisconnected " + paramComponentName);
    this.a.c = null;
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.ac
 * JD-Core Version:    0.7.0.1
 */