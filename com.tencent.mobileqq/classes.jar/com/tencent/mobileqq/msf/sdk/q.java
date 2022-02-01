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
import com.tencent.mobileqq.msf.core.d.e;
import com.tencent.mobileqq.msf.core.d.e.a;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecvServicePushResp fromServiceMsg = ");
    localStringBuilder.append(paramFromServiceMsg.getServiceCmd());
    localStringBuilder.append(", ssoSeq = ");
    localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
    localStringBuilder.append(", length = ");
    localStringBuilder.append(paramFromServiceMsg.getWupBuffer().length);
    QLog.d("MSF.D.ProxyNew", 1, localStringBuilder.toString());
    if (!b(null, paramFromServiceMsg))
    {
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
      else
      {
        if (this.a)
        {
          this.r.addServicePushMsg(paramFromServiceMsg);
          return;
        }
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
          e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 16);
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(" close msfServiceConn. push msg is droped.");
          localStringBuilder.append(paramFromServiceMsg);
          QLog.d("MSF.D.ProxyNew", 2, localStringBuilder.toString());
        }
      }
    }
    else if (paramFromServiceMsg.getBusinessFailCode() == -2)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("receive service ipc test push, length = ");
        localStringBuilder.append(paramFromServiceMsg.getWupBuffer().length);
        QLog.d("MSF.D.ProxyNew", 2, localStringBuilder.toString());
      }
    }
    else if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
      e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 15);
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceiveResp fromServiceMsg = ");
    ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
    ((StringBuilder)localObject).append(", ssoSeq = ");
    ((StringBuilder)localObject).append(paramFromServiceMsg.getRequestSsoSeq());
    ((StringBuilder)localObject).append(", length = ");
    ((StringBuilder)localObject).append(paramFromServiceMsg.getWupBuffer().length);
    QLog.d("MSF.D.ProxyNew", 1, ((StringBuilder)localObject).toString());
    localObject = (ToServiceMsg)e.remove(Integer.valueOf(paramToServiceMsg.getAppSeq()));
    if (localObject != null)
    {
      if ((!"LongConn.OffPicUp".equalsIgnoreCase(((ToServiceMsg)localObject).getServiceCmd())) && (!"ImgStore.GroupPicUp".equalsIgnoreCase(((ToServiceMsg)localObject).getServiceCmd())))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" onResponse ");
          ((StringBuilder)localObject).append(paramToServiceMsg.getRequestSsoSeq());
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(paramFromServiceMsg);
          QLog.d("MSF.D.ProxyNew", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceiveResp.");
        localStringBuilder.append(((ToServiceMsg)localObject).getStringForLog());
        localStringBuilder.append(" isConnectedMsf:");
        localStringBuilder.append(this.a);
        QLog.d("MSF.D.ProxyNew", 1, localStringBuilder.toString());
      }
      if (!b(paramToServiceMsg, paramFromServiceMsg))
      {
        if (this.a)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("add queue req:");
            ((StringBuilder)localObject).append(paramToServiceMsg);
            ((StringBuilder)localObject).append(" from:");
            ((StringBuilder)localObject).append(paramFromServiceMsg);
            QLog.d("MSF.D.ProxyNew", 2, ((StringBuilder)localObject).toString());
          }
          this.r.addServiceRespMsg(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" close msfServiceConn. msg is droped.");
          ((StringBuilder)localObject).append(paramToServiceMsg.getRequestSsoSeq());
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(paramFromServiceMsg);
          QLog.d("MSF.D.ProxyNew", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    else if ((!"LongConn.OffPicUp".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"ImgStore.GroupPicUp".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" found timeout resp to:");
        ((StringBuilder)localObject).append(paramToServiceMsg);
        ((StringBuilder)localObject).append(" from:");
        ((StringBuilder)localObject).append(paramFromServiceMsg);
        QLog.d("MSF.D.ProxyNew", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("onReceiveResp.");
      paramToServiceMsg.append(paramFromServiceMsg.getStringForLog());
      paramToServiceMsg.append(" waiteTemp is null.");
      QLog.d("MSF.D.ProxyNew", 1, paramToServiceMsg.toString());
      if (paramFromServiceMsg.isSuccess())
      {
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("appSeq", String.valueOf(paramFromServiceMsg.getAppSeq()));
        paramToServiceMsg.put("ssoSeq", String.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
        paramFromServiceMsg = new RdmReq();
        paramFromServiceMsg.eventName = "PicUpMsgErroCase1";
        paramFromServiceMsg.isRealTime = true;
        paramFromServiceMsg.params = paramToServiceMsg;
      }
    }
    try
    {
      paramToServiceMsg = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramFromServiceMsg);
      paramToServiceMsg.setTimeout(30000L);
      MsfServiceSdk.get().sendMsg(paramToServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg) {}
  }
  
  private int e(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    try
    {
      if (m()) {
        return a(paramToServiceMsg);
      }
      b(paramToServiceMsg);
      return -1;
    }
    catch (Exception localException)
    {
      if (this.b == null)
      {
        b(paramToServiceMsg);
        return -1;
      }
      localException.printStackTrace();
      return -1;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      b(paramToServiceMsg);
      QLog.w("MSF.D.ProxyNew", 1, localDeadObjectException.getMessage(), localDeadObjectException);
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
    if ((QLog.isColorLevel()) && ((paramToServiceMsg.getServiceCmd() == null) || (!"socketnetflow".equals(paramToServiceMsg.getServiceCmd()))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" send req to msfService:");
      localStringBuilder.append(paramToServiceMsg);
      QLog.d("MSF.D.ProxyNew", 2, localStringBuilder.toString());
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
      localObject = new Intent();
      ((Intent)localObject).setComponent(localComponentName);
      ((Intent)localObject).putExtra("to_SenderProcessName", this.r.processName);
      BaseApplication.getContext().startService((Intent)localObject);
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(localException);
      QLog.d("MSF.D.ProxyNew", 1, ((StringBuilder)localObject).toString(), localException);
    }
    QLog.d("MSF.D.ProxyNew", 1, "start service finish");
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  boolean b()
  {
    boolean bool2 = p.a();
    boolean bool1 = false;
    if (!bool2)
    {
      QLog.d("MSF.D.ProxyNew", 1, "bindBaseService no allow");
      return false;
    }
    c.a().onBindStart();
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.r.msfServiceName);
      localObject = new Intent();
      ((Intent)localObject).putExtra("to_SenderProcessName", this.r.processName);
      ((Intent)localObject).setComponent(localComponentName);
      if (QLog.isColorLevel())
      {
        bool2 = BaseApplication.getContext().bindService((Intent)localObject, this.s, 3);
        bool1 = bool2;
      }
      else
      {
        bool2 = BaseApplication.getContext().bindService((Intent)localObject, this.s, 1);
        bool1 = bool2;
      }
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(localException);
      QLog.w("MSF.D.ProxyNew", 1, ((StringBuilder)localObject).toString(), localException);
    }
    c.a().onBindEnd(bool1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bind service finished ");
    localStringBuilder.append(bool1);
    QLog.d("MSF.D.ProxyNew", 1, localStringBuilder.toString());
    return bool1;
  }
  
  public boolean b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramFromServiceMsg.getBusinessFailCode();
    boolean bool;
    if (paramFromServiceMsg.getAttributes().containsKey("_attr_sameDevice")) {
      bool = ((Boolean)paramFromServiceMsg.getAttribute("_attr_sameDevice")).booleanValue();
    } else {
      bool = false;
    }
    if (i != -2)
    {
      if (i != 2001)
      {
        if (i != 2008)
        {
          if (i != 2009)
          {
            switch (i)
            {
            default: 
              return false;
            case 2014: 
              this.r.errorHandler.onInvalidSign(bool);
              return true;
            case 2013: 
              this.r.errorHandler.onKicked(paramToServiceMsg, paramFromServiceMsg, bool);
              return true;
            case 2012: 
              this.r.errorHandler.onKickedAndClearToken(paramToServiceMsg, paramFromServiceMsg, bool);
              return true;
            }
            this.r.errorHandler.onRecvServerTip(paramToServiceMsg, paramFromServiceMsg, bool);
            return true;
          }
          this.r.errorHandler.onServerSuspended(paramToServiceMsg, paramFromServiceMsg, bool);
          return true;
        }
        this.r.errorHandler.onGrayError(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BaseConstants.CODE_NO_LOGIN ");
      localStringBuilder.append(paramFromServiceMsg.hashCode());
      QLog.d("MSF.D.ProxyNew", 1, localStringBuilder.toString());
      this.r.errorHandler.onUserTokenExpired(paramToServiceMsg, paramFromServiceMsg, bool);
    }
    return true;
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add fail queue req:");
      localStringBuilder.append(paramToServiceMsg);
      localStringBuilder.append(" from:");
      localStringBuilder.append(paramFromServiceMsg);
      QLog.d("MSF.D.ProxyNew", 2, localStringBuilder.toString());
    }
    this.r.addServiceRespMsg(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
  }
  
  public boolean c()
  {
    boolean bool;
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.r.msfServiceName);
      localObject = new Intent();
      ((Intent)localObject).setComponent(localComponentName);
      ((Intent)localObject).putExtra("to_SenderProcessName", this.r.processName);
      bool = BaseApplication.getContext().stopService((Intent)localObject);
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(localException);
      QLog.w("MSF.D.ProxyNew", 1, ((StringBuilder)localObject).toString(), localException);
      localException.printStackTrace();
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopService service finished ");
    localStringBuilder.append(bool);
    QLog.d("MSF.D.ProxyNew", 1, localStringBuilder.toString());
    return bool;
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
      q.a locala = this.y;
      locala.g = 3;
      long l = System.currentTimeMillis();
      locala.n = l;
      locala.j = l;
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localToServiceMsg.getServiceName());
          localStringBuilder.append("sendMsgToServiceFailed，");
          localStringBuilder.append(localException.toString());
          c(localToServiceMsg, a(localToServiceMsg, localStringBuilder.toString()));
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
        if (this.o)
        {
          this.v.postDelayed(this.q, 10000L);
          return;
        }
        this.v.postDelayed(this.q, 2000L);
      }
    }
  }
  
  public void initMsfService()
  {
    f();
  }
  
  public int registerMsfService(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.z;
      if (localObject1 != null)
      {
        if (localObject1 != null) {
          localObject1 = Integer.toHexString(localObject1.hashCode());
        } else {
          localObject1 = "null";
        }
        localObject2 = this.z;
        if (localObject2 != null) {
          localObject2 = ((IMsfServiceCallbacker)localObject2).asBinder();
        } else {
          localObject2 = null;
        }
        if (localObject2 != null) {
          paramBoolean1 = ((IBinder)localObject2).isBinderAlive();
        } else {
          paramBoolean1 = false;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("registerMsfService processName=");
        ((StringBuilder)localObject2).append(this.r.processName);
        ((StringBuilder)localObject2).append(" callback=");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" isBindAlive=");
        ((StringBuilder)localObject2).append(paramBoolean1);
        QLog.d("MSF.D.ProxyNew", 2, ((StringBuilder)localObject2).toString());
        break label210;
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("registerMsfService processName=");
    ((StringBuilder)localObject1).append(this.r.processName);
    ((StringBuilder)localObject1).append(" callback=");
    ((StringBuilder)localObject1).append(this.z);
    QLog.d("MSF.D.ProxyNew", 1, ((StringBuilder)localObject1).toString());
    label210:
    localObject1 = new ToServiceMsg(this.r.msfServiceName, "0", "cmd_RegisterMsfService");
    ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.registerMsfService);
    Object localObject2 = new MsfServiceBindInfo(this.r.appid, this.r.processName, this.r.getBootBroadcastName(), this.z);
    a(this.z);
    ((ToServiceMsg)localObject1).getAttributes().put("intent_bindServiceInfo", localObject2);
    ((ToServiceMsg)localObject1).setNeedCallback(false);
    this.a = true;
    return sendMsg((ToServiceMsg)localObject1);
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
    if (paramToServiceMsg == null) {
      return -1;
    }
    Object localObject;
    if (d(paramToServiceMsg))
    {
      c(paramToServiceMsg);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("add delaySendQueue sCmd:");
        ((StringBuilder)localObject).append(paramToServiceMsg.getServiceCmd());
        ((StringBuilder)localObject).append(" ssoSeq:");
        ((StringBuilder)localObject).append(paramToServiceMsg.getRequestSsoSeq());
        ((StringBuilder)localObject).append(" appSeq:");
        ((StringBuilder)localObject).append(paramToServiceMsg.getAppSeq());
        QLog.d("MSF.D.ProxyNew", 2, ((StringBuilder)localObject).toString());
      }
      return -1;
    }
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
    if (paramToServiceMsg.isNeedCallback())
    {
      paramToServiceMsg.addAttribute("appTimeoutReq", Integer.valueOf(this.l.incrementAndGet()));
      e.put(Integer.valueOf(paramToServiceMsg.getAppSeq()), paramToServiceMsg);
      localObject = new ab.b(this, paramToServiceMsg);
      if ((!"LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) && (!"ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())))
      {
        if ("login.auth".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))
        {
          this.v.postDelayed((Runnable)localObject, paramToServiceMsg.getTimeout() + NetConnInfoCenter.sAppTimeoutConfig);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("login timer start, appSeq: ");
          ((StringBuilder)localObject).append(paramToServiceMsg.getAppSeq());
          ((StringBuilder)localObject).append(", delayMillis: ");
          ((StringBuilder)localObject).append(String.valueOf(paramToServiceMsg.getTimeout() + NetConnInfoCenter.sAppTimeoutConfig));
          QLog.d("MSF.D.ProxyNew", 1, ((StringBuilder)localObject).toString());
        }
        else
        {
          this.v.postDelayed((Runnable)localObject, paramToServiceMsg.getTimeout() + 2000L);
        }
      }
      else
      {
        this.v.postDelayed((Runnable)localObject, paramToServiceMsg.getTimeout() + 20000L);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PicUpMsg timer start, appSeq: ");
        ((StringBuilder)localObject).append(paramToServiceMsg.getAppSeq());
        ((StringBuilder)localObject).append(", delayMillis: ");
        ((StringBuilder)localObject).append(String.valueOf(paramToServiceMsg.getTimeout() + 20000L));
        QLog.d("MSF.D.ProxyNew", 1, ((StringBuilder)localObject).toString());
      }
    }
    if (m()) {
      return e(paramToServiceMsg);
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
    for (;;)
    {
      try
      {
        if (this.z == null) {
          break label81;
        }
        IBinder localIBinder = this.z.asBinder();
        if (localIBinder == null) {
          break label87;
        }
        bool1 = localIBinder.isBinderAlive();
        if (localIBinder == null) {
          break label92;
        }
        bool2 = localIBinder.pingBinder();
        boolean bool3 = m();
        if ((bool3) && (bool1) && (bool2)) {
          return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return false;
      label81:
      Object localObject = null;
      continue;
      label87:
      boolean bool1 = false;
      continue;
      label92:
      boolean bool2 = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.q
 * JD-Core Version:    0.7.0.1
 */