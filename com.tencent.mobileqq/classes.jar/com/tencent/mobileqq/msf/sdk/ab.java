package com.tencent.mobileqq.msf.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msf.sdk.b.c;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.IBaseService;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ab
{
  private static final String a = "MSF.D.RemoteServiceProxy";
  protected static ConcurrentLinkedQueue d = new ConcurrentLinkedQueue();
  protected static ConcurrentHashMap e = new ConcurrentHashMap();
  protected static ConcurrentLinkedQueue f = new ConcurrentLinkedQueue();
  protected static final HashSet g = new HashSet(3);
  static final String m = "appTimeoutReq";
  protected volatile IBaseService b;
  protected Object c = new Object();
  protected volatile Handler h;
  protected volatile long i = -1L;
  protected volatile long j = -1L;
  protected volatile int k = -1;
  AtomicInteger l = new AtomicInteger();
  String n;
  protected boolean o = false;
  protected boolean p = false;
  protected ab.a q = null;
  protected MsfServiceSdk r;
  protected ServiceConnection s = new ac(this);
  private volatile boolean t = false;
  private volatile long u;
  private IBinder.DeathRecipient v;
  
  public ab(String paramString)
  {
    this.n = paramString;
    if (BaseApplication.processName == null) {
      BaseApplication.processName = MsfSdkUtils.getProcessName(BaseApplication.getContext());
    }
    if ("com.tencent.mobileqq".equals(BaseApplication.processName))
    {
      this.o = true;
      this.p = true;
      g.add(MsfCommand.reportRdm.name());
      g.add(MsfCommand.reportSocket.name());
      g.add("App_reportRDM");
    }
    this.q = new ab.a(this);
  }
  
  protected int a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      int i1 = this.b.sendToServiceMsg(paramToServiceMsg);
      c.a().onSendToService(paramToServiceMsg, i1);
      return i1;
    }
    catch (NullPointerException paramToServiceMsg)
    {
      throw paramToServiceMsg;
    }
    catch (RemoteException paramToServiceMsg)
    {
      throw paramToServiceMsg;
    }
  }
  
  protected FromServiceMsg a(ToServiceMsg paramToServiceMsg, String paramString)
  {
    paramToServiceMsg = o.a(paramToServiceMsg);
    paramToServiceMsg.setBusinessFail(1013, paramString);
    return paramToServiceMsg;
  }
  
  void a()
  {
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.n);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      BaseApplication.getContext().startService(localIntent);
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.D.RemoteServiceProxy", 2, " start service finish");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void a(IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    try
    {
      if (this.v == null) {
        this.v = new ad(this);
      }
      if (paramIMsfServiceCallbacker != null)
      {
        paramIMsfServiceCallbacker.asBinder().linkToDeath(this.v, 0);
        QLog.d("MSF.D.RemoteServiceProxy", 1, "linkToDeath");
        return;
      }
    }
    catch (Throwable paramIMsfServiceCallbacker)
    {
      QLog.e("MSF.D.RemoteServiceProxy", 1, "linkToDeath fail.", paramIMsfServiceCallbacker);
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  protected void b(IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    if (paramIMsfServiceCallbacker != null) {
      try
      {
        if (this.v != null)
        {
          paramIMsfServiceCallbacker.asBinder().unlinkToDeath(this.v, 0);
          QLog.d("MSF.D.RemoteServiceProxy", 1, "unlinkToDeath");
          return;
        }
      }
      catch (Throwable paramIMsfServiceCallbacker)
      {
        QLog.e("MSF.D.RemoteServiceProxy", 1, "unlinkToDeath fail.", paramIMsfServiceCallbacker);
      }
    }
  }
  
  protected void b(ToServiceMsg paramToServiceMsg)
  {
    if (!d.add(paramToServiceMsg))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addMsgToSendQueue fail, size = ");
      localStringBuilder.append(d.size());
      localStringBuilder.append(", msg = ");
      localStringBuilder.append(paramToServiceMsg.getShortStringForLog());
      QLog.i("MSF.D.RemoteServiceProxy", 1, localStringBuilder.toString());
    }
  }
  
  boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    boolean bool3;
    try
    {
      Object localObject = new ComponentName(BaseApplication.getContext().getPackageName(), this.n);
      bool1 = bool2;
      Intent localIntent = new Intent();
      bool1 = bool2;
      localIntent.setComponent((ComponentName)localObject);
      bool1 = bool2;
      bool2 = BaseApplication.getContext().bindService(localIntent, this.s, 1);
      bool1 = bool2;
      bool3 = bool2;
      if (QLog.isColorLevel())
      {
        bool1 = bool2;
        localObject = new StringBuilder();
        bool1 = bool2;
        ((StringBuilder)localObject).append(" bind ");
        bool1 = bool2;
        ((StringBuilder)localObject).append(this.n);
        bool1 = bool2;
        ((StringBuilder)localObject).append(" service finished ");
        bool1 = bool2;
        ((StringBuilder)localObject).append(bool2);
        bool1 = bool2;
        QLog.d("MSF.D.RemoteServiceProxy", 2, ((StringBuilder)localObject).toString());
        return bool2;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      bool3 = bool1;
    }
    return bool3;
  }
  
  protected void c(ToServiceMsg paramToServiceMsg)
  {
    f.add(paramToServiceMsg);
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      paramToServiceMsg.getActionListener().onRecvFromMsg(paramFromServiceMsg);
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
    c.a().onRespToApp(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean c()
  {
    try
    {
      Object localObject = new ComponentName(BaseApplication.getContext(), this.n);
      Intent localIntent = new Intent();
      localIntent.setComponent((ComponentName)localObject);
      boolean bool = BaseApplication.getContext().stopService(localIntent);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" stopService ");
        ((StringBuilder)localObject).append(this.n);
        ((StringBuilder)localObject).append(" service finished ");
        ((StringBuilder)localObject).append(bool);
        QLog.d("MSF.D.RemoteServiceProxy", 2, ((StringBuilder)localObject).toString());
      }
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  protected abstract void d();
  
  protected boolean d(ToServiceMsg paramToServiceMsg)
  {
    return (this.o) && (this.p) && (paramToServiceMsg != null) && ((g.contains(paramToServiceMsg.getMsfCommand())) || (g.contains(paramToServiceMsg.getServiceCmd())));
  }
  
  protected abstract void e();
  
  public void g()
  {
    try
    {
      BaseApplication.getContext().unbindService(this.s);
      this.b = null;
      QLog.d("MSF.D.RemoteServiceProxy", 1, "unbindService service finished");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int getMsfConnectedIPFamily()
  {
    try
    {
      int i1 = this.b.getMsfConnectedIPFamily();
      return i1;
    }
    catch (Exception localException)
    {
      label12:
      break label12;
    }
    return 0;
  }
  
  public final int getMsfConnectedNetType()
  {
    try
    {
      int i1 = this.b.getMsfConnectedNetType();
      return i1;
    }
    catch (RemoteException localRemoteException)
    {
      label12:
      break label12;
    }
    return 0;
  }
  
  protected boolean m()
  {
    return this.b != null;
  }
  
  public final int onKillProcess()
  {
    IBaseService localIBaseService = this.b;
    if (localIBaseService != null) {}
    try
    {
      localIBaseService.onKillProcess();
      label16:
      return 0;
    }
    catch (Exception localException)
    {
      break label16;
    }
  }
  
  public int onProcessViewableChanged(boolean paramBoolean, long paramLong, String paramString)
  {
    IBaseService localIBaseService = this.b;
    this.t = paramBoolean;
    this.u = paramLong;
    if (localIBaseService != null) {}
    try
    {
      localIBaseService.onProcessViewableChanged(paramBoolean, this.u, paramString);
      label36:
      return 0;
    }
    catch (Exception paramString)
    {
      break label36;
    }
  }
  
  public abstract int sendMsg(ToServiceMsg paramToServiceMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.ab
 * JD-Core Version:    0.7.0.1
 */