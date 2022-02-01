package com.tencent.mobileqq.msf.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.StringBuilderPrinter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.core.c.e.a;
import com.tencent.mobileqq.msf.core.p;
import com.tencent.mobileqq.msf.sdk.b.c;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfProxy;
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

public class q
  extends ab
  implements IMsfProxy
{
  private static final String t = "MSF.D.ProxyNew";
  private static final int u = 20000;
  protected boolean a = false;
  private volatile Handler v;
  private ConcurrentHashMap w = new ConcurrentHashMap();
  private ConcurrentHashMap x = new ConcurrentHashMap();
  private final q.a y = new q.a(this);
  private IMsfServiceCallbacker z = new r(this);
  
  public q(String paramString)
  {
    super(paramString);
    paramString = new HandlerThread("Transport-Timeout-Checker", 5);
    paramString.start();
    this.v = new Handler(paramString.getLooper());
  }
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    QLog.d("MSF.D.ProxyNew", 1, "onRecvServicePushResp fromServiceMsg = " + paramFromServiceMsg.getServiceCmd() + ", ssoSeq = " + paramFromServiceMsg.getRequestSsoSeq() + ", length = " + paramFromServiceMsg.getWupBuffer().length);
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
    do
    {
      do
      {
        do
        {
          return;
          if (this.a)
          {
            this.r.addServicePushMsg(paramFromServiceMsg);
            return;
          }
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
            e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 16);
          }
        } while (!QLog.isColorLevel());
        QLog.d("MSF.D.ProxyNew", 2, " close msfServiceConn. push msg is droped." + paramFromServiceMsg);
        return;
        if (paramFromServiceMsg.getBusinessFailCode() != -2) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MSF.D.ProxyNew", 2, "receive service ipc test push, length = " + paramFromServiceMsg.getWupBuffer().length);
      return;
    } while ((paramFromServiceMsg == null) || (paramFromServiceMsg.getServiceCmd() == null) || (!paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")));
    e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 15);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d("MSF.D.ProxyNew", 1, "onReceiveResp fromServiceMsg = " + paramFromServiceMsg.getServiceCmd() + ", ssoSeq = " + paramFromServiceMsg.getRequestSsoSeq() + ", length = " + paramFromServiceMsg.getWupBuffer().length);
    ToServiceMsg localToServiceMsg = (ToServiceMsg)e.remove(Integer.valueOf(paramToServiceMsg.getAppSeq()));
    if (localToServiceMsg != null) {
      if (("LongConn.OffPicUp".equalsIgnoreCase(localToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(localToServiceMsg.getServiceCmd()))) {
        QLog.d("MSF.D.ProxyNew", 1, "onReceiveResp." + localToServiceMsg.getStringForLog() + " isConnectedMsf:" + this.a);
      }
    }
    label216:
    do
    {
      do
      {
        do
        {
          break label216;
          for (;;)
          {
            if (!b(paramToServiceMsg, paramFromServiceMsg))
            {
              if (!this.a) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("MSF.D.ProxyNew", 2, "add queue req:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
              }
              this.r.addServiceRespMsg(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
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
        if (this.b == null)
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
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    paramToServiceMsg.setAppId(this.r.appid);
    paramToServiceMsg.getAttributes().put("to_SendTime", Long.valueOf(System.currentTimeMillis()));
    paramToServiceMsg.getAttributes().put("to_SenderProcessName", this.r.processName);
    if ((QLog.isColorLevel()) && ((paramToServiceMsg.getServiceCmd() == null) || (!"socketnetflow".equals(paramToServiceMsg.getServiceCmd())))) {
      QLog.d("MSF.D.ProxyNew", 2, " send req to msfService:" + paramToServiceMsg);
    }
    return super.a(paramToServiceMsg);
  }
  
  void a()
  {
    if (!p.a())
    {
      QLog.d("MSF.D.ProxyNew", 1, "startBaseService no allow");
      return;
    }
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.r.msfServiceName);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      localIntent.putExtra("to_SenderProcessName", this.r.processName);
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
    if (!p.a())
    {
      QLog.d("MSF.D.ProxyNew", 1, "bindBaseService no allow");
      return false;
    }
    c.a().onBindStart();
    for (;;)
    {
      try
      {
        ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.r.msfServiceName);
        localIntent = new Intent();
        localIntent.putExtra("to_SenderProcessName", this.r.processName);
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
      default: 
        return false;
      case 2001: 
        QLog.d("MSF.D.ProxyNew", 1, "BaseConstants.CODE_NO_LOGIN " + paramFromServiceMsg.hashCode());
        this.r.errorHandler.onUserTokenExpired(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2011: 
        this.r.errorHandler.onRecvServerTip(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2012: 
        this.r.errorHandler.onKickedAndClearToken(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2013: 
        this.r.errorHandler.onKicked(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2009: 
        this.r.errorHandler.onServerSuspended(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2008: 
        this.r.errorHandler.onGrayError(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2014: 
        this.r.errorHandler.onInvalidSign(bool);
        return true;
      }
      return true;
    }
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.ProxyNew", 2, "add fail queue req:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
    }
    this.r.addServiceRespMsg(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
  }
  
  public boolean c()
  {
    boolean bool1 = false;
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.r.msfServiceName);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      localIntent.putExtra("to_SenderProcessName", this.r.processName);
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
    s locals = new s(this);
    locals.setName("handleWaitSendProxyMsgThread");
    locals.start();
  }
  
  protected void e()
  {
    c.a().onServiceDisconnected();
  }
  
  void f()
  {
    if ((!m()) && (this.y.h.compareAndSet(false, true)))
    {
      this.y.g = 3;
      q.a locala1 = this.y;
      q.a locala2 = this.y;
      long l = System.currentTimeMillis();
      locala2.n = l;
      locala1.j = l;
      this.v.postAtFrontOfQueue(this.y);
      c.a().onReqServiceConn();
      if (QLog.isColorLevel()) {
        QLog.i("MSF.D.ProxyNew", 2, "MSF_Alive_Log requestServiceConn");
      }
    }
  }
  
  public void g()
  {
    super.g();
  }
  
  public void h()
  {
    while (!d.isEmpty())
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)d.poll();
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
    this.v.dump(localStringBuilderPrinter, "");
    if (QLog.isColorLevel()) {
      QLog.i("MSF.D.ProxyNew", 2, localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  public void init(MsfServiceSdk paramMsfServiceSdk)
  {
    this.r = paramMsfServiceSdk;
    paramMsfServiceSdk.msfServiceName = this.n;
    if (this.v == null)
    {
      paramMsfServiceSdk = new HandlerThread("MsfServiceTimeoutChecker", 5);
      paramMsfServiceSdk.start();
      this.v = new Handler(paramMsfServiceSdk.getLooper());
      if (this.q != null)
      {
        if (!this.o) {
          break label81;
        }
        this.v.postDelayed(this.q, 10000L);
      }
    }
    return;
    label81:
    this.v.postDelayed(this.q, 2000L);
  }
  
  public void initMsfService()
  {
    f();
  }
  
  public int registerMsfService(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    Object localObject2;
    if ((QLog.isColorLevel()) && (this.z != null)) {
      if (this.z != null)
      {
        localObject1 = Integer.toHexString(this.z.hashCode());
        if (this.z == null) {
          break label220;
        }
        localObject2 = this.z.asBinder();
        label49:
        if (localObject2 == null) {
          break label226;
        }
        paramBoolean1 = ((IBinder)localObject2).isBinderAlive();
        label62:
        QLog.d("MSF.D.ProxyNew", 2, "registerMsfService processName=" + this.r.processName + " callback=" + (String)localObject1 + " isBindAlive=" + paramBoolean1);
      }
    }
    for (;;)
    {
      localObject1 = new ToServiceMsg(this.r.msfServiceName, "0", "cmd_RegisterMsfService");
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.registerMsfService);
      localObject2 = new MsfServiceBindInfo(this.r.appid, this.r.processName, this.r.getBootBroadcastName(), this.z);
      a(this.z);
      ((ToServiceMsg)localObject1).getAttributes().put("intent_bindServiceInfo", localObject2);
      ((ToServiceMsg)localObject1).setNeedCallback(false);
      this.a = true;
      return sendMsg((ToServiceMsg)localObject1);
      localObject1 = "null";
      break;
      label220:
      localObject2 = null;
      break label49;
      label226:
      paramBoolean1 = false;
      break label62;
      QLog.d("MSF.D.ProxyNew", 1, "registerMsfService processName=" + this.r.processName + " callback=" + this.z);
    }
  }
  
  public void registerProxyDone()
  {
    if ((this.o) && (this.p) && (this.q != null))
    {
      this.v.removeCallbacks(this.q);
      this.v.post(this.q);
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
    ab.b localb;
    if (paramToServiceMsg.isNeedCallback())
    {
      paramToServiceMsg.addAttribute("appTimeoutReq", Integer.valueOf(this.l.incrementAndGet()));
      e.put(Integer.valueOf(paramToServiceMsg.getAppSeq()), paramToServiceMsg);
      localb = new ab.b(this, paramToServiceMsg);
      if ((!"LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) && (!"ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))) {
        break label299;
      }
      this.v.postDelayed(localb, paramToServiceMsg.getTimeout() + 20000L);
      QLog.d("MSF.D.ProxyNew", 1, "PicUpMsg timer start, appSeq: " + paramToServiceMsg.getAppSeq() + ", delayMillis: " + String.valueOf(paramToServiceMsg.getTimeout() + 20000L));
    }
    while (m())
    {
      return e(paramToServiceMsg);
      label299:
      if ("login.auth".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))
      {
        this.v.postDelayed(localb, paramToServiceMsg.getTimeout() + NetConnInfoCenter.sAppTimeoutConfig);
        QLog.d("MSF.D.ProxyNew", 1, "login timer start, appSeq: " + paramToServiceMsg.getAppSeq() + ", delayMillis: " + String.valueOf(paramToServiceMsg.getTimeout() + NetConnInfoCenter.sAppTimeoutConfig));
      }
      else
      {
        this.v.postDelayed(localb, paramToServiceMsg.getTimeout() + 2000L);
      }
    }
    b(paramToServiceMsg);
    if (m()) {
      return e(paramToServiceMsg);
    }
    QLog.i("MSF.D.ProxyNew", 1, "MSF_Alive_Log requestServiceConn in MsfServiceProxyNew sendMsg");
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
      if (this.z != null)
      {
        localIBinder = this.z.asBinder();
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
  
  public void startMsfService()
  {
    a();
  }
  
  public void stopMsfService()
  {
    c();
  }
  
  public int unRegisterMsfService(Boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(this.r.msfServiceName, "0", "cmd_UnRegisterMsfService");
    localToServiceMsg.setMsfCommand(MsfCommand.unRegisterMsfService);
    localToServiceMsg.extraData.putBoolean("to_stop_wake_process", paramBoolean.booleanValue());
    this.a = false;
    b(this.z);
    return sendMsg(localToServiceMsg);
  }
  
  public void unbindMsfService()
  {
    h();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.q
 * JD-Core Version:    0.7.0.1
 */