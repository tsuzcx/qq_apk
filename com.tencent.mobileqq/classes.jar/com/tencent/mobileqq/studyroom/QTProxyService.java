package com.tencent.mobileqq.studyroom;

import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginProcessService;
import com.tencent.shadow.dynamic.host.PpsController;

public class QTProxyService
  extends PluginProcessService
{
  private PpsController a;
  private long b = 0L;
  
  public IBinder onBind(Intent paramIntent)
  {
    paramIntent = super.onBind(paramIntent);
    this.a = wrapBinder(paramIntent);
    return paramIntent;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.b = SystemClock.elapsedRealtime();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    PpsController localPpsController = this.a;
    if (localPpsController != null) {}
    try
    {
      localPpsController.exit();
      label17:
      this.a = null;
      Process.killProcess(Process.myPid());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label17;
    }
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    super.onTaskRemoved(paramIntent);
    if (SystemClock.elapsedRealtime() - this.b < 1000L)
    {
      QLog.i("studyroom.QTProxyService", 2, "onTaskRemoved, SystemClock.elapsedRealtime() - mOnCreateTimeStamp < 1000");
      return;
    }
    QLog.i("studyroom.QTProxyService", 2, "onTaskRemoved");
    paramIntent = this.a;
    if (paramIntent != null) {}
    try
    {
      paramIntent.exit();
      return;
    }
    catch (RemoteException paramIntent) {}
    QLog.i("studyroom.QTProxyService", 2, "ppsController null System.exit");
    System.exit(0);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.QTProxyService
 * JD-Core Version:    0.7.0.1
 */