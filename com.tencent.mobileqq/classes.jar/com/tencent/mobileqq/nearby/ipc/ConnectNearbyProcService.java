package com.tencent.mobileqq.nearby.ipc;

import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class ConnectNearbyProcService
  extends AppService
{
  private static NearbyProcessInterface b;
  private static Object c = new Object();
  private INearbyProxy a;
  private MainProcessInterface d = new ConnectNearbyProcService.1(this);
  
  public static Message a(Message paramMessage)
  {
    if (b != null)
    {
      if (paramMessage == null) {
        return null;
      }
      try
      {
        synchronized (c)
        {
          if (b == null) {
            return null;
          }
          paramMessage = b.a(paramMessage);
          return paramMessage;
        }
        return null;
      }
      catch (RemoteException paramMessage)
      {
        paramMessage.printStackTrace();
      }
    }
  }
  
  public static boolean a()
  {
    for (;;)
    {
      synchronized (c)
      {
        if (b != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public static Object[] a(int paramInt)
  {
    return a(paramInt, new Object[0]);
  }
  
  public static Object[] a(int paramInt, Object... paramVarArgs)
  {
    if (b == null) {
      return null;
    }
    try
    {
      synchronized (c)
      {
        if (b == null) {
          return null;
        }
        paramVarArgs = b.a(new BasicTypeDataParcel(paramInt, paramVarArgs));
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
      paramVarArgs.printStackTrace();
    }
  }
  
  private Message b(Message paramMessage)
  {
    INearbyProxy localINearbyProxy = this.a;
    if (localINearbyProxy != null) {
      return localINearbyProxy.a(this, paramMessage);
    }
    return null;
  }
  
  private void b()
  {
    if ((this.app != null) && ((this.app instanceof QQAppInterface)))
    {
      this.a = NearbyManagerHelper.a((QQAppInterface)this.app);
      return;
    }
    throw new IllegalArgumentException("not QQAppInterface. wrong.");
  }
  
  private Object[] b(int paramInt, Object... paramVarArgs)
  {
    INearbyProxy localINearbyProxy = this.a;
    if (localINearbyProxy != null) {
      return localINearbyProxy.a(this, paramInt, paramVarArgs);
    }
    return null;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    b();
    return this.d.asBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    synchronized (c)
    {
      b = null;
      if (QLog.isColorLevel()) {
        QLog.i("nearby_ipc_log_tag", 2, "ConnectNearbyProcService onUnbind.");
      }
      this.a = null;
      return super.onUnbind(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService
 * JD-Core Version:    0.7.0.1
 */