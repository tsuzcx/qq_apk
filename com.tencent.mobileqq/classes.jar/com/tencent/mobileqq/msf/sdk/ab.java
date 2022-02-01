package com.tencent.mobileqq.msf.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.tencent.mobileqq.msf.core.w;
import com.tencent.mobileqq.msf.sdk.report.c;
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
    catch (RemoteException paramToServiceMsg)
    {
      throw paramToServiceMsg;
    }
    catch (NullPointerException paramToServiceMsg)
    {
      throw paramToServiceMsg;
    }
  }
  
  protected FromServiceMsg a(ToServiceMsg paramToServiceMsg, String paramString)
  {
    paramToServiceMsg = w.a(paramToServiceMsg);
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
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.RemoteServiceProxy", 2, " start service finish");
      }
      return;
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
      }
      return;
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
    if (paramIMsfServiceCallbacker != null) {}
    try
    {
      if (this.v != null)
      {
        paramIMsfServiceCallbacker.asBinder().unlinkToDeath(this.v, 0);
        QLog.d("MSF.D.RemoteServiceProxy", 1, "unlinkToDeath");
      }
      return;
    }
    catch (Throwable paramIMsfServiceCallbacker)
    {
      QLog.e("MSF.D.RemoteServiceProxy", 1, "unlinkToDeath fail.", paramIMsfServiceCallbacker);
    }
  }
  
  protected void b(ToServiceMsg paramToServiceMsg)
  {
    d.add(paramToServiceMsg);
  }
  
  /* Error */
  boolean b()
  {
    // Byte code:
    //   0: new 188	android/content/ComponentName
    //   3: dup
    //   4: invokestatic 112	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 191	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   10: aload_0
    //   11: getfield 103	com/tencent/mobileqq/msf/sdk/ab:n	Ljava/lang/String;
    //   14: invokespecial 194	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: astore_2
    //   18: new 196	android/content/Intent
    //   21: dup
    //   22: invokespecial 197	android/content/Intent:<init>	()V
    //   25: astore_3
    //   26: aload_3
    //   27: aload_2
    //   28: invokevirtual 201	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   31: pop
    //   32: invokestatic 112	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   35: aload_3
    //   36: aload_0
    //   37: getfield 101	com/tencent/mobileqq/msf/sdk/ab:s	Landroid/content/ServiceConnection;
    //   40: iconst_1
    //   41: invokevirtual 261	com/tencent/qphone/base/util/BaseApplication:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   44: istore_1
    //   45: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   48: ifeq +42 -> 90
    //   51: ldc 8
    //   53: iconst_2
    //   54: new 263	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 266
    //   64: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: getfield 103	com/tencent/mobileqq/msf/sdk/ab:n	Ljava/lang/String;
    //   71: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 272
    //   77: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: iload_1
    //   81: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   84: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iload_1
    //   91: ireturn
    //   92: astore_2
    //   93: iconst_0
    //   94: istore_1
    //   95: aload_2
    //   96: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   99: iload_1
    //   100: ireturn
    //   101: astore_2
    //   102: goto -7 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	ab
    //   44	56	1	bool	boolean
    //   17	11	2	localComponentName	ComponentName
    //   92	4	2	localException1	Exception
    //   101	1	2	localException2	Exception
    //   25	11	3	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   0	45	92	java/lang/Exception
    //   45	90	101	java/lang/Exception
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
      c.a().onRespToApp(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
      }
    }
  }
  
  public boolean c()
  {
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext(), this.n);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      boolean bool = BaseApplication.getContext().stopService(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.RemoteServiceProxy", 2, " stopService " + this.n + " service finished " + bool);
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
    catch (Exception localException) {}
    return 0;
  }
  
  public final int getMsfConnectedNetType()
  {
    try
    {
      int i1 = this.b.getMsfConnectedNetType();
      return i1;
    }
    catch (RemoteException localRemoteException) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.ab
 * JD-Core Version:    0.7.0.1
 */