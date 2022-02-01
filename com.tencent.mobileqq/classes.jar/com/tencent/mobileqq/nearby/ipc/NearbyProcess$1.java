package com.tencent.mobileqq.nearby.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

class NearbyProcess$1
  implements ServiceConnection
{
  NearbyProcess$1(NearbyProcess paramNearbyProcess) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "onServiceConnected");
    }
    this.a.a = MainProcessInterface.Stub.a(paramIBinder);
    try
    {
      this.a.a.a(this.a.b);
    }
    catch (RemoteException paramComponentName)
    {
      if (QLog.isDevelopLevel()) {
        paramComponentName.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("nearby_ipc_log_tag", 2, "nearbyProcess onServiceConnected.");
    }
  }
  
  public void onServiceDisconnected(ComponentName arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "onServiceDisconnected");
    }
    synchronized (NearbyProcess.a(this.a))
    {
      this.a.a = null;
      if (QLog.isColorLevel()) {
        QLog.i("nearby_ipc_log_tag", 2, "nearbyProcess onServiceDisConnected.");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.NearbyProcess.1
 * JD-Core Version:    0.7.0.1
 */