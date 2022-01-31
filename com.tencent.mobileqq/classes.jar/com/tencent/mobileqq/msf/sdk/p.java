package com.tencent.mobileqq.msf.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.StringBuilderPrinter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.core.c.e.a;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfProxy;
import com.tencent.mobileqq.msf.sdk.report.c;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.MsfServiceBindInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class p
  extends z
  implements IMsfProxy
{
  private static final String t = "MSF.D.ProxyNew";
  MsfServiceSdk a;
  protected boolean b;
  private final a u = new a();
  private IMsfServiceCallbacker v = new q(this);
  
  public p(String paramString)
  {
    super(paramString);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.ProxyNew", 2, " onRecvPushResp " + paramFromServiceMsg);
    }
    if (!b(null, paramFromServiceMsg)) {
      if (paramFromServiceMsg.getMsfCommand() == MsfCommand.pushSetConfig)
      {
        QLog.setUIN_REPORTLOG_LEVEL(((Integer)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd())).intValue());
        NetConnInfoCenter.socketConnState = ((Integer)paramFromServiceMsg.getAttribute("_attr_socket_connstate")).intValue();
        NetConnInfoCenter.servetTimeSecondInterv = ((Long)paramFromServiceMsg.getAttribute("_attr_server")).longValue();
        NetConnInfoCenter.GUID = (byte[])paramFromServiceMsg.getAttribute("_attr_deviceGUID");
        NetConnInfoCenter.sAppTimeoutConfig = ((Integer)paramFromServiceMsg.getAttribute("_attr_app_timeout")).intValue();
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
          e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 17);
        }
      }
    }
    while ((paramFromServiceMsg == null) || (paramFromServiceMsg.getServiceCmd() == null) || (!paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")))
    {
      do
      {
        return;
        if (this.b)
        {
          this.a.addServicePushMsg(paramFromServiceMsg);
          return;
        }
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
          e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 16);
        }
      } while (!QLog.isColorLevel());
      QLog.d("MSF.D.ProxyNew", 2, " close msfServiceConn. push msg is droped." + paramFromServiceMsg);
      return;
    }
    e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 15);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    ToServiceMsg localToServiceMsg = (ToServiceMsg)f.remove(Integer.valueOf(paramToServiceMsg.getAppSeq()));
    if (localToServiceMsg != null) {
      if (("LongConn.OffPicUp".equalsIgnoreCase(localToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(localToServiceMsg.getServiceCmd()))) {
        QLog.d("MSF.D.ProxyNew", 1, "onReceiveResp." + localToServiceMsg.getStringForLog() + " isConnectedMsf:" + this.b);
      }
    }
    label158:
    do
    {
      do
      {
        do
        {
          break label158;
          for (;;)
          {
            if (!b(paramToServiceMsg, paramFromServiceMsg))
            {
              if (!this.b) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("MSF.D.ProxyNew", 2, "add queue req:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
              }
              this.a.addServiceRespMsg(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
            }
            return;
            if (QLog.isColorLevel()) {
              QLog.d("MSF.D.ProxyNew", 2, " onResponse " + paramToServiceMsg.getRequestSsoSeq() + " " + paramFromServiceMsg);
            }
          }
        } while (!QLog.isColorLevel());
        QLog.d("MSF.D.ProxyNew", 2, " close msfServiceConn. msg is droped." + paramToServiceMsg.getRequestSsoSeq() + " " + paramFromServiceMsg);
        return;
        if ((!"LongConn.OffPicUp".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"ImgStore.GroupPicUp".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
          break;
        }
        QLog.d("MSF.D.ProxyNew", 1, "onReceiveResp." + paramFromServiceMsg.getStringForLog() + " waiteTemp is null.");
      } while (!paramFromServiceMsg.isSuccess());
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("appSeq", String.valueOf(paramFromServiceMsg.getAppSeq()));
      paramToServiceMsg.put("ssoSeq", String.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
      paramFromServiceMsg = new RdmReq();
      paramFromServiceMsg.eventName = "PicUpMsgErroCase1";
      paramFromServiceMsg.isRealTime = true;
      paramFromServiceMsg.params = paramToServiceMsg;
      try
      {
        paramToServiceMsg = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramFromServiceMsg);
        paramToServiceMsg.setTimeout(30000L);
        MsfServiceSdk.get().sendMsg(paramToServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.D.ProxyNew", 2, " found timeout resp to:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
  }
  
  private int e(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {}
    for (;;)
    {
      return -1;
      try
      {
        if (m()) {
          return a(paramToServiceMsg);
        }
        b(paramToServiceMsg);
        return -1;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        b(paramToServiceMsg);
        if (localDeadObjectException != null)
        {
          QLog.w("MSF.D.ProxyNew", 1, localDeadObjectException.getMessage(), localDeadObjectException);
          return -1;
        }
      }
      catch (Exception localException)
      {
        if (this.c == null)
        {
          b(paramToServiceMsg);
          return -1;
        }
        localException.printStackTrace();
      }
    }
    return -1;
  }
  
  protected int a(ToServiceMsg paramToServiceMsg)
    throws RemoteException, NullPointerException
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    paramToServiceMsg.setAppId(this.a.appid);
    paramToServiceMsg.getAttributes().put("to_SendTime", Long.valueOf(System.currentTimeMillis()));
    paramToServiceMsg.getAttributes().put("to_SenderProcessName", this.a.processName);
    if ((QLog.isColorLevel()) && ((paramToServiceMsg.getServiceCmd() == null) || (!"socketnetflow".equals(paramToServiceMsg.getServiceCmd())))) {
      QLog.d("MSF.D.ProxyNew", 2, " send req to msfService:" + paramToServiceMsg);
    }
    return super.a(paramToServiceMsg);
  }
  
  void a()
  {
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.a.msfServiceName);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      localIntent.putExtra("to_SenderProcessName", this.a.processName);
      BaseApplication.getContext().startService(localIntent);
      QLog.d("MSF.D.ProxyNew", 1, "start service finish");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("MSF.D.ProxyNew", 1, " " + localException, localException);
      }
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  boolean b()
  {
    boolean bool1 = false;
    c.a().onBindStart();
    for (;;)
    {
      try
      {
        ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.a.msfServiceName);
        localIntent = new Intent();
        localIntent.putExtra("to_SenderProcessName", this.a.processName);
        localIntent.setComponent(localComponentName);
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool2 = BaseApplication.getContext().bindService(localIntent, this.s, 3);
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        Intent localIntent;
        boolean bool2;
        QLog.w("MSF.D.ProxyNew", 1, " " + localException, localException);
        continue;
      }
      c.a().onBindEnd(bool1);
      QLog.d("MSF.D.ProxyNew", 1, "bind service finished " + bool1);
      return bool1;
      bool2 = BaseApplication.getContext().bindService(localIntent, this.s, 1);
      bool1 = bool2;
    }
  }
  
  public boolean b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramFromServiceMsg.getBusinessFailCode();
    if (paramFromServiceMsg.getAttributes().containsKey("_attr_sameDevice")) {}
    for (boolean bool = ((Boolean)paramFromServiceMsg.getAttribute("_attr_sameDevice")).booleanValue();; bool = false)
    {
      switch (i)
      {
      case 2002: 
      case 2003: 
      case 2004: 
      case 2005: 
      case 2006: 
      case 2007: 
      case 2010: 
      default: 
        return false;
      case 2001: 
        QLog.d("MSF.D.ProxyNew", 1, "BaseConstants.CODE_NO_LOGIN " + paramFromServiceMsg.hashCode());
        this.a.errorHandler.onUserTokenExpired(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2011: 
        this.a.errorHandler.onRecvServerTip(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2012: 
        this.a.errorHandler.onKickedAndClearToken(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2013: 
        this.a.errorHandler.onKicked(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2009: 
        this.a.errorHandler.onServerSuspended(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2008: 
        this.a.errorHandler.onGrayError(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      }
      this.a.errorHandler.onInvalidSign(bool);
      return true;
    }
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.ProxyNew", 2, "add fail queue req:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
    }
    this.a.addServiceRespMsg(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
  }
  
  public boolean c()
  {
    boolean bool1 = false;
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.a.msfServiceName);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      localIntent.putExtra("to_SenderProcessName", this.a.processName);
      boolean bool2 = BaseApplication.getContext().stopService(localIntent);
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("MSF.D.ProxyNew", 1, " " + localException, localException);
        localException.printStackTrace();
      }
    }
    QLog.d("MSF.D.ProxyNew", 1, "stopService service finished " + bool1);
    return bool1;
  }
  
  protected void d()
  {
    r localr = new r(this);
    localr.setName("handleWaitSendProxyMsgThread");
    localr.start();
  }
  
  protected void e()
  {
    c.a().onServiceDisconnected();
  }
  
  void f()
  {
    if ((!m()) && (this.u.h.compareAndSet(false, true)))
    {
      this.u.g = 3;
      a locala1 = this.u;
      a locala2 = this.u;
      long l = System.currentTimeMillis();
      locala2.n = l;
      locala1.j = l;
      this.i.postAtFrontOfQueue(this.u);
      c.a().onReqServiceConn();
      if (QLog.isColorLevel()) {
        QLog.i("MSF.D.ProxyNew", 2, "requestServiceConn");
      }
    }
  }
  
  public void g()
  {
    super.g();
  }
  
  public void h()
  {
    while (!e.isEmpty())
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)e.poll();
      if (localToServiceMsg != null) {
        try
        {
          a(localToServiceMsg);
        }
        catch (Exception localException)
        {
          c(localToServiceMsg, a(localToServiceMsg, localToServiceMsg.getServiceName() + "sendMsgToServiceFailed，" + localException.toString()));
        }
      }
    }
  }
  
  String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    StringBuilderPrinter localStringBuilderPrinter = new StringBuilderPrinter(localStringBuilder);
    this.i.dump(localStringBuilderPrinter, "");
    if (QLog.isColorLevel()) {
      QLog.i("MSF.D.ProxyNew", 2, localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  public void init(MsfServiceSdk paramMsfServiceSdk)
  {
    this.a = paramMsfServiceSdk;
    paramMsfServiceSdk.msfServiceName = this.o;
    if (this.i == null)
    {
      paramMsfServiceSdk = new HandlerThread("Timeout-Checker", 5);
      paramMsfServiceSdk.start();
      this.i = new Handler(paramMsfServiceSdk.getLooper());
      if (this.r != null)
      {
        if (!this.p) {
          break label81;
        }
        this.i.postDelayed(this.r, 10000L);
      }
    }
    return;
    label81:
    this.i.postDelayed(this.r, 2000L);
  }
  
  public void initMsfService()
  {
    f();
  }
  
  public int registerMsfService(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    Object localObject2;
    if ((QLog.isColorLevel()) && (this.v != null)) {
      if (this.v != null)
      {
        localObject1 = Integer.toHexString(this.v.hashCode());
        if (this.v == null) {
          break label212;
        }
        localObject2 = this.v.asBinder();
        label49:
        if (localObject2 == null) {
          break label218;
        }
        paramBoolean1 = ((IBinder)localObject2).isBinderAlive();
        label62:
        QLog.d("MSF.D.ProxyNew", 2, "registerMsfService processName=" + this.a.processName + " callback=" + (String)localObject1 + " isBindAlive=" + paramBoolean1);
      }
    }
    for (;;)
    {
      localObject1 = new ToServiceMsg(this.a.msfServiceName, "0", "cmd_RegisterMsfService");
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.registerMsfService);
      localObject2 = new MsfServiceBindInfo(this.a.appid, this.a.processName, this.a.getBootBroadcastName(), this.v);
      ((ToServiceMsg)localObject1).getAttributes().put("intent_bindServiceInfo", localObject2);
      ((ToServiceMsg)localObject1).setNeedCallback(false);
      this.b = true;
      return sendMsg((ToServiceMsg)localObject1);
      localObject1 = "null";
      break;
      label212:
      localObject2 = null;
      break label49;
      label218:
      paramBoolean1 = false;
      break label62;
      QLog.d("MSF.D.ProxyNew", 1, "registerMsfService processName=" + this.a.processName + " callback=" + this.v);
    }
  }
  
  public void registerProxyDone()
  {
    if ((this.p) && (this.q) && (this.r != null))
    {
      this.i.removeCallbacks(this.r);
      this.i.post(this.r);
    }
  }
  
  public int sendMsg(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {}
    do
    {
      return -1;
      if (!d(paramToServiceMsg)) {
        break;
      }
      c(paramToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("MSF.D.ProxyNew", 2, "add delaySendQueue sCmd:" + paramToServiceMsg.getServiceCmd() + " ssoSeq:" + paramToServiceMsg.getRequestSsoSeq() + " appSeq:" + paramToServiceMsg.getAppSeq());
    return -1;
    c.a().onSendMsg(paramToServiceMsg, m());
    if (paramToServiceMsg.getServiceCmd().equals("RegPrxySvc.PbSyncMsg")) {
      paramToServiceMsg.setMsfCommand(MsfCommand.msf_pbSyncMsg);
    }
    if (paramToServiceMsg.getAppSeq() < 0) {
      paramToServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
    }
    if (paramToServiceMsg.getTimeout() == -1L) {
      paramToServiceMsg.setTimeout(30000L);
    }
    z.b localb;
    if (paramToServiceMsg.isNeedCallback())
    {
      paramToServiceMsg.addAttribute("appTimeoutReq", Integer.valueOf(this.m.incrementAndGet()));
      f.put(Integer.valueOf(paramToServiceMsg.getAppSeq()), paramToServiceMsg);
      localb = new z.b(this, paramToServiceMsg);
      if ((!"LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) && (!"ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))) {
        break label298;
      }
      this.i.postDelayed(localb, paramToServiceMsg.getTimeout() + 20000L);
      QLog.d("MSF.D.ProxyNew", 1, "PicUpMsg timer start, appSeq: " + paramToServiceMsg.getAppSeq() + ", delayMillis: " + String.valueOf(paramToServiceMsg.getTimeout() + 20000L));
    }
    while (m())
    {
      return e(paramToServiceMsg);
      label298:
      if ("login.auth".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))
      {
        this.i.postDelayed(localb, paramToServiceMsg.getTimeout() + NetConnInfoCenter.sAppTimeoutConfig);
        QLog.d("MSF.D.ProxyNew", 1, "login timer start, appSeq: " + paramToServiceMsg.getAppSeq() + ", delayMillis: " + String.valueOf(paramToServiceMsg.getTimeout() + NetConnInfoCenter.sAppTimeoutConfig));
      }
      else
      {
        this.i.postDelayed(localb, paramToServiceMsg.getTimeout() + 2000L);
      }
    }
    b(paramToServiceMsg);
    if (m()) {
      return e(paramToServiceMsg);
    }
    f();
    return -1;
  }
  
  public boolean serviceConnected()
  {
    boolean bool4 = false;
    try
    {
      IBinder localIBinder;
      boolean bool1;
      if (this.v != null)
      {
        localIBinder = this.v.asBinder();
        if (localIBinder == null) {
          break label85;
        }
        bool1 = localIBinder.isBinderAlive();
        label34:
        if (localIBinder == null) {
          break label90;
        }
      }
      label85:
      label90:
      for (boolean bool2 = localIBinder.pingBinder();; bool2 = false)
      {
        boolean bool5 = m();
        boolean bool3 = bool4;
        if (bool5)
        {
          bool3 = bool4;
          if (bool1)
          {
            bool3 = bool4;
            if (bool2) {
              bool3 = true;
            }
          }
        }
        return bool3;
        localIBinder = null;
        break;
        bool1 = false;
        break label34;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void stopMsfService()
  {
    c();
  }
  
  public int unRegisterMsfService(Boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(this.a.msfServiceName, "0", "cmd_UnRegisterMsfService");
    localToServiceMsg.setMsfCommand(MsfCommand.unRegisterMsfService);
    localToServiceMsg.extraData.putBoolean("to_stop_wake_process", paramBoolean.booleanValue());
    this.b = false;
    return sendMsg(localToServiceMsg);
  }
  
  public void unbindMsfService()
  {
    h();
    g();
  }
  
  private class a
    implements Runnable
  {
    static final String a = "BindService";
    static final int b = 1;
    static final int c = 2;
    static final int d = 4;
    static final int e = 8;
    static final int f = 16;
    int g = 0;
    final AtomicBoolean h = new AtomicBoolean(false);
    boolean i = false;
    long j = 0L;
    long k = 0L;
    long l = 0L;
    long m = 0L;
    long n = 0L;
    short o = 0;
    short p = 0;
    short q = 0;
    short r = 0;
    short s = 0;
    boolean t = false;
    boolean u = false;
    boolean v = false;
    boolean w = false;
    
    public a() {}
    
    String a()
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("control=").append(Integer.toBinaryString(this.g)).append(" conned=").append(p.this.m()).append(" start=[").append(this.o).append(",").append(this.j).append("]").append(" bindSucc=[").append(this.p).append(",").append(this.k).append("]").append(" bindFail=[").append(this.q).append(",").append(this.l).append("]").append(" unbind=[").append(this.r).append(",").append(this.m).append("]").append(" stop=[").append(this.s).append(",").append(this.n).append("]");
      if (QLog.isColorLevel()) {
        QLog.i("BindService", 2, localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
    
    public void run()
    {
      int i1 = 1;
      int i2 = this.g;
      if (QLog.isColorLevel()) {
        QLog.d("BindService", 2, "execute cmd: " + Integer.toBinaryString(i2));
      }
      long l1;
      if ((i2 & 0x8) == 8)
      {
        l1 = System.currentTimeMillis();
        if (p.this.m()) {
          p.this.h();
        }
        this.u = p.this.c();
        this.s = ((short)(this.s + 1));
        this.n = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("BindService", 2, "stop service cost=" + (this.n - l1));
        }
      }
      if ((i2 & 0x4) == 4)
      {
        l1 = System.currentTimeMillis();
        if (p.this.m()) {
          p.this.h();
        }
        p.this.g();
        if (p.this.m()) {
          break label447;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        this.w = bool;
        if (!this.w) {
          QLog.i("BindService", 1, "unbind service failed");
        }
        this.r = ((short)(this.r + 1));
        this.m = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("BindService", 2, "unbind service cost=" + (this.m - l1));
        }
        if ((i2 & 0x1) == 1)
        {
          l1 = System.currentTimeMillis();
          p.this.a();
          this.o = ((short)(this.o + 1));
          this.j = System.currentTimeMillis();
          this.t = true;
          if (QLog.isColorLevel()) {
            QLog.d("BindService", 2, "start service cost=" + (System.currentTimeMillis() - l1));
          }
        }
        if (((i2 & 0x10) == 16) && (Build.VERSION.SDK_INT >= 21)) {
          BaseApplication.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.msf.startmsf"));
        }
        if ((i2 & 0x2) != 2) {
          break label730;
        }
        long l2 = System.currentTimeMillis();
        if (p.this.m()) {
          break label665;
        }
        this.v = p.this.b();
        i2 = 50;
        for (;;)
        {
          if ((p.this.m()) || (Thread.interrupted()) || (i2 > 2000)) {
            break label453;
          }
          l1 = i2;
          label447:
          try
          {
            Thread.sleep(l1);
            i2 = i1 * 50 + i2;
            i1 += 1;
          }
          catch (Exception localException) {}
        }
      }
      label453:
      if (!p.this.m())
      {
        this.q = ((short)(this.q + 1));
        this.l = System.currentTimeMillis();
        i2 = 6;
        if (System.currentTimeMillis() - this.j > 10000L) {
          i2 = 23;
        }
        i1 = i2;
        if (System.currentTimeMillis() - this.n > 30000L) {
          i1 = i2 | 0x1D;
        }
        i2 = i1;
        if (QLog.isColorLevel())
        {
          if (!p.this.m()) {
            break label670;
          }
          l1 = this.k;
          QLog.d("BindService", 2, "bind service bindSucc=" + this.v + " conned=" + p.this.m() + " cost=" + (l1 - l2));
        }
      }
      label547:
      label730:
      for (i2 = i1;; i2 = 0)
      {
        if (p.this.m()) {
          this.h.set(false);
        }
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            a();
            QLog.d("BindService", 2, "execute cmd finished");
          }
          return;
          this.p = ((short)(this.p + 1));
          this.q = 0;
          this.k = System.currentTimeMillis();
          i1 = 0;
          break;
          l1 = this.l;
          break label547;
          if (i2 > 0)
          {
            p.a(p.this).g = i2;
            p.this.i.post(p.a(p.this));
          }
          else
          {
            this.h.set(false);
          }
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.p
 * JD-Core Version:    0.7.0.1
 */