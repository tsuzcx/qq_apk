package com.tencent.mobileqq.msf.core.wtlogin;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.remote.IWtloginService.Stub;
import com.tencent.qphone.base.util.QLog;

class b
  implements ServiceConnection
{
  b(MsfWtloginHelper paramMsfWtloginHelper) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" onServiceConnected service:");
    localStringBuilder.append(paramComponentName);
    QLog.d("MsfWtloginHelper", 2, localStringBuilder.toString());
    this.a._baseService = IWtloginService.Stub.asInterface(paramIBinder);
    MsfWtloginHelper.access$000(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" onServiceDisconnected ");
    localStringBuilder.append(paramComponentName);
    QLog.d("MsfWtloginHelper", 2, localStringBuilder.toString());
    this.a._baseService = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.wtlogin.b
 * JD-Core Version:    0.7.0.1
 */