package com.tencent.mobileqq.msf.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.RemoteException;
import com.tencent.mobileqq.msf.core.w;
import com.tencent.mobileqq.msf.sdk.report.c;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.IBaseService;
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
  protected static ConcurrentLinkedQueue e = new ConcurrentLinkedQueue();
  protected static ConcurrentHashMap f = new ConcurrentHashMap();
  protected static ConcurrentLinkedQueue g = new ConcurrentLinkedQueue();
  protected static final HashSet h = new HashSet(3);
  static final String n = "appTimeoutReq";
  private volatile boolean b = false;
  protected volatile IBaseService c;
  protected Object d = new Object();
  protected volatile Handler i;
  protected volatile long j = -1L;
  protected volatile long k = -1L;
  protected volatile int l = -1;
  AtomicInteger m = new AtomicInteger();
  String o;
  protected boolean p = false;
  protected boolean q = false;
  protected ab.a r = null;
  protected ServiceConnection s = new ac(this);
  private volatile long t;
  
  public ab(String paramString)
  {
    this.o = paramString;
    if (BaseApplication.processName == null) {
      BaseApplication.processName = MsfSdkUtils.getProcessName(BaseApplication.getContext());
    }
    if ("com.tencent.mobileqq".equals(BaseApplication.processName))
    {
      this.p = true;
      this.q = true;
      h.add(MsfCommand.reportRdm.name());
      h.add(MsfCommand.reportSocket.name());
      h.add("App_reportRDM");
    }
    this.r = new ab.a(this);
  }
  
  protected int a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      int i1 = this.c.sendToServiceMsg(paramToServiceMsg);
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
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.o);
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
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  protected void b(ToServiceMsg paramToServiceMsg)
  {
    e.add(paramToServiceMsg);
  }
  
  /* Error */
  boolean b()
  {
    // Byte code:
    //   0: new 184	android/content/ComponentName
    //   3: dup
    //   4: invokestatic 108	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 187	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   10: aload_0
    //   11: getfield 99	com/tencent/mobileqq/msf/sdk/ab:o	Ljava/lang/String;
    //   14: invokespecial 190	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: astore_2
    //   18: new 192	android/content/Intent
    //   21: dup
    //   22: invokespecial 193	android/content/Intent:<init>	()V
    //   25: astore_3
    //   26: aload_3
    //   27: aload_2
    //   28: invokevirtual 197	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   31: pop
    //   32: invokestatic 108	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   35: aload_3
    //   36: aload_0
    //   37: getfield 97	com/tencent/mobileqq/msf/sdk/ab:s	Landroid/content/ServiceConnection;
    //   40: iconst_1
    //   41: invokevirtual 224	com/tencent/qphone/base/util/BaseApplication:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   44: istore_1
    //   45: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   48: ifeq +40 -> 88
    //   51: ldc 8
    //   53: iconst_2
    //   54: new 226	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   61: ldc 229
    //   63: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_0
    //   67: getfield 99	com/tencent/mobileqq/msf/sdk/ab:o	Ljava/lang/String;
    //   70: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 235
    //   75: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: iload_1
    //   79: invokevirtual 238	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   82: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: iload_1
    //   89: ireturn
    //   90: astore_2
    //   91: iconst_0
    //   92: istore_1
    //   93: aload_2
    //   94: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   97: iload_1
    //   98: ireturn
    //   99: astore_2
    //   100: goto -7 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	ab
    //   44	54	1	bool	boolean
    //   17	11	2	localComponentName	ComponentName
    //   90	4	2	localException1	Exception
    //   99	1	2	localException2	Exception
    //   25	11	3	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   0	45	90	java/lang/Exception
    //   45	88	99	java/lang/Exception
  }
  
  protected void c(ToServiceMsg paramToServiceMsg)
  {
    g.add(paramToServiceMsg);
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
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext(), this.o);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      boolean bool = BaseApplication.getContext().stopService(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.RemoteServiceProxy", 2, " stopService " + this.o + " service finished " + bool);
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
    return (this.p) && (this.q) && (paramToServiceMsg != null) && ((h.contains(paramToServiceMsg.getMsfCommand())) || (h.contains(paramToServiceMsg.getServiceCmd())));
  }
  
  protected abstract void e();
  
  public void g()
  {
    try
    {
      BaseApplication.getContext().unbindService(this.s);
      this.c = null;
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
      int i1 = this.c.getMsfConnectedIPFamily();
      return i1;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public final int getMsfConnectedNetType()
  {
    try
    {
      int i1 = this.c.getMsfConnectedNetType();
      return i1;
    }
    catch (RemoteException localRemoteException) {}
    return 0;
  }
  
  protected boolean m()
  {
    return this.c != null;
  }
  
  public final int onKillProcess()
  {
    IBaseService localIBaseService = this.c;
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
    IBaseService localIBaseService = this.c;
    this.b = paramBoolean;
    this.t = paramLong;
    if (localIBaseService != null) {}
    try
    {
      localIBaseService.onProcessViewableChanged(paramBoolean, this.t, paramString);
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