package com.tencent.mobileqq.nearby.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class NearbyProcess
{
  MainProcessInterface a;
  NearbyProcessInterface b = new NearbyProcess.2(this);
  private Object c = new Object();
  private AppInterface d;
  private INearbyProcManager e;
  private ServiceConnection f = new NearbyProcess.1(this);
  
  public NearbyProcess() {}
  
  public NearbyProcess(AppInterface paramAppInterface, INearbyProcManager paramINearbyProcManager)
  {
    this.d = paramAppInterface;
    this.e = paramINearbyProcManager;
  }
  
  public Message a(Message paramMessage)
  {
    if (this.a != null)
    {
      if (paramMessage == null) {
        return null;
      }
      try
      {
        synchronized (this.c)
        {
          if (this.a == null) {
            return null;
          }
          paramMessage = this.a.a(paramMessage);
          return paramMessage;
        }
        return null;
      }
      catch (RemoteException paramMessage)
      {
        if (QLog.isDevelopLevel()) {
          paramMessage.printStackTrace();
        }
      }
    }
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this.d.getApp(), ConnectNearbyProcService.class);
    this.d.getApp().bindService(localIntent, this.f, 1);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "bindService");
    }
  }
  
  public Object[] a(int paramInt)
  {
    return a(paramInt, new Object[0]);
  }
  
  public Object[] a(int paramInt, Object... paramVarArgs)
  {
    if (this.a == null) {
      return null;
    }
    try
    {
      synchronized (this.c)
      {
        if (this.a == null) {
          return null;
        }
        paramVarArgs = this.a.a(new BasicTypeDataParcel(paramInt, paramVarArgs));
        if (paramVarArgs == null) {
          return null;
        }
        paramVarArgs = paramVarArgs.b;
        return paramVarArgs;
      }
      return null;
    }
    catch (RemoteException paramVarArgs)
    {
      if (QLog.isDevelopLevel()) {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  Message b(Message paramMessage)
  {
    INearbyProcManager localINearbyProcManager = this.e;
    if (localINearbyProcManager != null) {
      return localINearbyProcManager.a(paramMessage);
    }
    return null;
  }
  
  public void b()
  {
    this.d.getApp().unbindService(this.f);
  }
  
  Object[] b(int paramInt, Object... paramVarArgs)
  {
    INearbyProcManager localINearbyProcManager = this.e;
    if (localINearbyProcManager != null) {
      return localINearbyProcManager.a(paramInt, paramVarArgs);
    }
    return null;
  }
  
  public boolean c()
  {
    return this.a != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.NearbyProcess
 * JD-Core Version:    0.7.0.1
 */