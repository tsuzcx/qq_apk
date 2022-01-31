package com.tencent.mobileqq.msf.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.RemoteException;
import android.text.format.Formatter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.core.c.e.a;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfProxy;
import com.tencent.mobileqq.msf.sdk.report.IMTAReporter;
import com.tencent.mobileqq.msf.sdk.report.MTAReportManager;
import com.tencent.mobileqq.msf.sdk.report.c;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.MsfServiceBindInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class k
  extends z
  implements IMsfProxy
{
  private static final String t = "MSF.D.Proxy";
  private static int u;
  private static long v = -1L;
  private static boolean w;
  MsfServiceSdk a;
  protected volatile boolean b;
  
  public k(String paramString)
  {
    super(paramString);
  }
  
  public static void a(SharedPreferences.Editor paramEditor)
  {
    paramEditor.putString("availMem", j());
    paramEditor.putString("lowMem", k());
    paramEditor.putString("time", new Date().toString());
    paramEditor.putString("process", h());
    paramEditor.putString("state", l());
  }
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.Proxy", 2, " onRecvPushResp " + paramFromServiceMsg);
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
      QLog.d("MSF.D.Proxy", 2, " close msfServiceConn. push msg is droped." + paramFromServiceMsg);
      return;
    }
    e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 15);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    boolean bool2 = true;
    String str = (Build.MANUFACTURER + "_" + Build.MODEL).toLowerCase();
    Object localObject = h();
    boolean bool3 = MsfServiceSdk.isUseNewProxy;
    boolean bool1;
    int i;
    if ((str != null) && (str.indexOf("vivo") >= 0))
    {
      bool1 = true;
      if ((bool3) || (!bool1)) {
        break label321;
      }
      i = 1;
    }
    for (;;)
    {
      label73:
      if ("com.tencent.mobileqq".equals(localObject)) {
        label83:
        if (Build.VERSION.SDK_INT < 21) {
          break label369;
        }
      }
      Properties localProperties;
      label321:
      label369:
      for (str = "android5.0+";; str = "android4.x")
      {
        localProperties = new Properties();
        localProperties.setProperty("proxy", String.valueOf(bool3));
        localProperties.setProperty("vivo", String.valueOf(bool1));
        localProperties.setProperty("param_FailCode", String.valueOf(i));
        localProperties.setProperty("mainProcess", String.valueOf(bool2));
        localProperties.setProperty("sdkver", str);
        if (!paramBoolean) {
          break label377;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.D.Proxy", 2, "MTA is not initConfig or unsupported.");
        }
        localObject = BaseApplication.getContext().getSharedPreferences("pull_msf_succ" + (String)localObject, 0).edit();
        ((SharedPreferences.Editor)localObject).putString("uin", paramString);
        ((SharedPreferences.Editor)localObject).putString("proxy", String.valueOf(bool3));
        ((SharedPreferences.Editor)localObject).putString("vivo", String.valueOf(bool1));
        ((SharedPreferences.Editor)localObject).putString("param_FailCode", String.valueOf(i));
        ((SharedPreferences.Editor)localObject).putString("mainProcess", String.valueOf(bool2));
        ((SharedPreferences.Editor)localObject).putString("sdkver", String.valueOf(str));
        a((SharedPreferences.Editor)localObject);
        ((SharedPreferences.Editor)localObject).commit();
        return;
        bool1 = false;
        break;
        if ((bool3) && (bool1))
        {
          i = 2;
          break label73;
        }
        if ((!bool3) && (!bool1))
        {
          i = 3;
          break label73;
        }
        if ((!bool3) || (bool1)) {
          break label530;
        }
        i = 4;
        break label73;
        bool2 = false;
        break label83;
      }
      label377:
      if (MTAReportManager.getMtaReporter() != null) {
        MTAReportManager.getMtaReporter().reportKVEvent("pullMsfReportQQ_V4", localProperties);
      }
      localObject = BaseApplication.getContext().getSharedPreferences("pull_msf" + (String)localObject, 0).edit();
      ((SharedPreferences.Editor)localObject).putString("uin", paramString);
      ((SharedPreferences.Editor)localObject).putString("proxy", String.valueOf(bool3));
      ((SharedPreferences.Editor)localObject).putString("vivo", String.valueOf(bool1));
      ((SharedPreferences.Editor)localObject).putString("param_FailCode", String.valueOf(i));
      ((SharedPreferences.Editor)localObject).putString("mainProcess", String.valueOf(bool2));
      ((SharedPreferences.Editor)localObject).putString("sdkver", String.valueOf(str));
      a((SharedPreferences.Editor)localObject);
      ((SharedPreferences.Editor)localObject).commit();
      return;
      label530:
      i = 0;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    ToServiceMsg localToServiceMsg = (ToServiceMsg)f.remove(Integer.valueOf(paramToServiceMsg.getAppSeq()));
    if (localToServiceMsg != null) {
      if (("LongConn.OffPicUp".equalsIgnoreCase(localToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(localToServiceMsg.getServiceCmd()))) {
        QLog.d("MSF.D.Proxy", 1, "onReceiveResp." + localToServiceMsg.getStringForLog() + " isConnectedMsf:" + this.b);
      }
    }
    label164:
    do
    {
      do
      {
        do
        {
          break label164;
          for (;;)
          {
            if (!b(paramToServiceMsg, paramFromServiceMsg))
            {
              if (!this.b) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("MSF.D.Proxy", 2, "add queue req:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
              }
              this.a.addServiceRespMsg(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
            }
            return;
            if (QLog.isColorLevel()) {
              QLog.d("MSF.D.Proxy", 2, " onResponse " + paramToServiceMsg.getRequestSsoSeq() + " " + paramFromServiceMsg);
            }
          }
        } while (!QLog.isColorLevel());
        QLog.d("MSF.D.Proxy", 2, " close msfServiceConn. msg is droped." + paramToServiceMsg.getRequestSsoSeq() + " " + paramFromServiceMsg);
        return;
        if ((!"LongConn.OffPicUp".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"ImgStore.GroupPicUp".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
          break;
        }
        QLog.d("MSF.D.Proxy", 1, "onReceiveResp." + paramFromServiceMsg.getStringForLog() + " waiteTemp is null.");
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
    QLog.d("MSF.D.Proxy", 2, " found timeout resp to:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
  }
  
  public static String h()
  {
    try
    {
      int i = Process.myPid();
      Object localObject = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.pid == i)
        {
          localObject = localRunningAppProcessInfo.processName;
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d("MSF.D.Proxy", 1, "failed to get current process name");
    }
    return null;
  }
  
  public static String j()
  {
    try
    {
      Object localObject = (ActivityManager)BaseApplication.getContext().getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
      QLog.d("MSF.D.Proxy", 1, "Property get avail memory:" + localMemoryInfo.availMem);
      localObject = Formatter.formatFileSize(BaseApplication.getContext(), localMemoryInfo.availMem);
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.D.Proxy", 1, "failed to get avail memory");
    }
    return null;
  }
  
  public static String k()
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)BaseApplication.getContext().getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      localActivityManager.getMemoryInfo(localMemoryInfo);
      QLog.d("MSF.D.Proxy", 1, "Property get low memory feature:" + localMemoryInfo.lowMemory);
      boolean bool = localMemoryInfo.lowMemory;
      return String.valueOf(bool);
    }
    catch (Exception localException)
    {
      QLog.d("MSF.D.Proxy", 1, "failed to get low memory feature");
    }
    return null;
  }
  
  public static String l()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        Iterator localIterator = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningServices(256).iterator();
        Object localObject1 = null;
        int i = 0;
        Object localObject2;
        if (localIterator.hasNext())
        {
          localObject2 = (ActivityManager.RunningServiceInfo)localIterator.next();
          if (((ActivityManager.RunningServiceInfo)localObject2).process.trim().equals("com.tencent.mobileqq:MSF"))
          {
            bool = true;
            localObject1 = localObject2;
          }
        }
        else
        {
          QLog.d("MSF.D.Proxy", 1, "isMsfAlive:" + bool + ", cur service process count:" + i);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("countService_").append(i).append(":");
          if ((bool) && (localObject1 != null))
          {
            ((StringBuilder)localObject2).append("alive_").append(bool).append(":");
            ((StringBuilder)localObject2).append("activeSince_").append(localObject1.activeSince).append(":");
            ((StringBuilder)localObject2).append("clientCount_").append(localObject1.clientCount).append(":");
            ((StringBuilder)localObject2).append("clientLabel_").append(localObject1.clientLabel).append(":");
            ((StringBuilder)localObject2).append("clientPkg_").append(localObject1.clientPackage).append(":");
            ((StringBuilder)localObject2).append("crashCount_").append(localObject1.crashCount).append(":");
            ((StringBuilder)localObject2).append("flags_").append(localObject1.flags).append(":");
            ((StringBuilder)localObject2).append("foreground_").append(localObject1.foreground).append(":");
            ((StringBuilder)localObject2).append("lastActivityTime_").append(localObject1.lastActivityTime).append(":");
            ((StringBuilder)localObject2).append("pid_").append(localObject1.pid).append(":");
            ((StringBuilder)localObject2).append("process_").append(localObject1.process).append(":");
            ((StringBuilder)localObject2).append("restarting_").append(localObject1.restarting).append(":");
            ((StringBuilder)localObject2).append("started_").append(localObject1.started).append(":");
            ((StringBuilder)localObject2).append("uid_").append(localObject1.uid);
            return ((StringBuilder)localObject2).toString();
          }
          ((StringBuilder)localObject2).append("alive_").append(bool);
          continue;
        }
        i += 1;
      }
      catch (Exception localException)
      {
        QLog.d("MSF.D.Proxy", 1, "failed to getServiceState");
        return null;
      }
    }
  }
  
  private void n()
  {
    u = 0;
    this.k = -1L;
    v = -1L;
    w = false;
  }
  
  protected int a(ToServiceMsg paramToServiceMsg)
    throws RemoteException
  {
    int i;
    if (paramToServiceMsg == null) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        paramToServiceMsg.setAppId(this.a.appid);
        paramToServiceMsg.getAttributes().put("to_SendTime", Long.valueOf(System.currentTimeMillis()));
        paramToServiceMsg.getAttributes().put("to_SenderProcessName", this.a.processName);
        j = super.a(paramToServiceMsg);
        i = j;
      } while (!QLog.isColorLevel());
      if (paramToServiceMsg.getServiceCmd() == null) {
        break;
      }
      i = j;
    } while ("socketnetflow".equals(paramToServiceMsg.getServiceCmd()));
    QLog.d("MSF.D.Proxy", 2, " sendMsgToService " + paramToServiceMsg);
    return j;
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
      QLog.d("MSF.D.Proxy", 1, "start service finish");
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.D.Proxy", 1, " " + localException, localException);
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  boolean b()
  {
    c.a().onBindStart();
    label137:
    for (;;)
    {
      try
      {
        ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.a.msfServiceName);
        Intent localIntent = new Intent();
        localIntent.putExtra("to_SenderProcessName", this.a.processName);
        localIntent.setComponent(localComponentName);
        boolean bool = BaseApplication.getContext().bindService(localIntent, this.s, 1);
        QLog.d("MSF.D.Proxy", 1, " " + localException1, localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          QLog.d("MSF.D.Proxy", 1, "threadID:" + Thread.currentThread().getId() + ", threadName: " + Thread.currentThread().getName() + " bind service finished " + bool);
          c.a().onBindEnd(bool);
          return bool;
        }
        catch (Exception localException2)
        {
          break label137;
        }
        localException1 = localException1;
        bool = false;
      }
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
        bool = false;
      }
      for (;;)
      {
        if (bool) {
          QLog.d("MSF.D.Proxy", 1, new Object[] { "tokenExpired, failcode:", Integer.valueOf(i), " fromServiceMsg:", Integer.valueOf(paramFromServiceMsg.hashCode()) });
        }
        return bool;
        this.a.errorHandler.onUserTokenExpired(paramToServiceMsg, paramFromServiceMsg, bool);
        bool = true;
        continue;
        this.a.errorHandler.onRecvServerTip(paramToServiceMsg, paramFromServiceMsg, bool);
        bool = true;
        continue;
        this.a.errorHandler.onKickedAndClearToken(paramToServiceMsg, paramFromServiceMsg, bool);
        bool = true;
        continue;
        this.a.errorHandler.onKicked(paramToServiceMsg, paramFromServiceMsg, bool);
        bool = true;
        continue;
        this.a.errorHandler.onServerSuspended(paramToServiceMsg, paramFromServiceMsg, bool);
        bool = true;
        continue;
        this.a.errorHandler.onGrayError(paramToServiceMsg, paramFromServiceMsg, bool);
        bool = true;
        continue;
        this.a.errorHandler.onInvalidSign(bool);
        bool = true;
      }
    }
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.Proxy", 2, "add fail queue req:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
    }
    this.a.addServiceRespMsg(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
  }
  
  public boolean c()
  {
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.a.msfServiceName);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      localIntent.putExtra("to_SenderProcessName", this.a.processName);
      boolean bool = BaseApplication.getContext().stopService(localIntent);
      QLog.d("MSF.D.Proxy", 1, "stopService service finished " + bool);
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  protected void d()
  {
    l locall = new l(this);
    locall.setName("handleWaitSendProxyMsgThread");
    locall.start();
    n();
  }
  
  protected void e()
  {
    c.a().onServiceDisconnected();
    n();
  }
  
  public void f()
  {
    while (!e.isEmpty())
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)e.poll();
      if (localToServiceMsg != null)
      {
        try
        {
          a(localToServiceMsg);
        }
        catch (Exception localException) {}
        if (localToServiceMsg.isNeedCallback()) {
          c(localToServiceMsg, a(localToServiceMsg, localToServiceMsg.getServiceName() + "sendMsgToServiceFailed，" + localException.toString()));
        }
      }
    }
  }
  
  public void g()
  {
    super.g();
  }
  
  public void i()
  {
    long l1 = System.currentTimeMillis();
    if ((this.j == -1L) || (l1 - this.j > 10000L))
    {
      this.j = l1;
      a();
      b();
    }
    long l2;
    do
    {
      for (;;)
      {
        return;
        try
        {
          if (Build.VERSION.SDK_INT >= 21)
          {
            l2 = l1 - this.k;
            if ((this.k == -1L) || (l2 > 10000L))
            {
              if (u == 0) {
                v = l1;
              }
              u += 1;
              this.k = l1;
              if (u % 3 == 2)
              {
                c();
                g();
                QLog.d("MSF.D.Proxy", 1, "pullmsf to stop and unbind service above android 5");
              }
              BaseApplication.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.msf.startmsf"));
              this.l = 1;
              QLog.d("MSF.D.Proxy", 1, "start MsfService through Broadcast, " + u);
            }
            if ((this.k == -1L) || (l2 <= this.l * 2000)) {
              continue;
            }
            b();
            this.l += 1;
            QLog.d("MSF.D.Proxy", 1, "delay binding MSF Service");
          }
        }
        catch (Exception localException)
        {
          QLog.d("MSF.D.Proxy", 1, "start MsfService exception " + localException.toString());
          return;
        }
      }
      l2 = l1 - this.k;
      if ((this.k == -1L) || (l2 > 10000L))
      {
        if (u == 0) {
          v = l1;
        }
        u += 1;
        this.k = l1;
        if (u % 3 == 2)
        {
          c();
          g();
          QLog.d("MSF.D.Proxy", 1, "pullmsf to stop and unbind service below android 5");
        }
        this.l = 1;
        QLog.d("MSF.D.Proxy", 1, "start MsfService ignore, " + u);
      }
    } while ((this.k == -1L) || (l2 <= this.l * 2000));
    b();
    this.l += 1;
    QLog.d("MSF.D.Proxy", 1, "delay binding MSF Service");
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
    a();
    b();
  }
  
  public int registerMsfService(boolean paramBoolean1, boolean paramBoolean2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(this.a.msfServiceName, "0", "cmd_RegisterMsfService");
    localToServiceMsg.setMsfCommand(MsfCommand.registerMsfService);
    Object localObject = new MsfServiceBindInfo(this.a.appid, this.a.processName, this.a.getBootBroadcastName(), new m(this));
    localToServiceMsg.getAttributes().put("intent_bindServiceInfo", localObject);
    localToServiceMsg.setNeedCallback(false);
    this.b = true;
    if ((QLog.isColorLevel()) && (((MsfServiceBindInfo)localObject).getMsfServiceCallbacker() != null))
    {
      if (((MsfServiceBindInfo)localObject).getMsfServiceCallbacker() != null)
      {
        localObject = Integer.toHexString(((MsfServiceBindInfo)localObject).getMsfServiceCallbacker().hashCode());
        QLog.d("MSF.D.Proxy", 2, "registerMsfService processName=" + this.a.processName + " callback=" + (String)localObject);
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label220;
      }
      if (!paramBoolean2) {
        break label199;
      }
      this.i.postAtFrontOfQueue(new n(this, localToServiceMsg));
    }
    for (;;)
    {
      return 0;
      localObject = "null";
      break;
      label199:
      this.i.post(new o(this, localToServiceMsg));
    }
    label220:
    return sendMsg(localToServiceMsg);
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
    int i = 0;
    if (paramToServiceMsg == null) {}
    for (;;)
    {
      return -1;
      if (d(paramToServiceMsg))
      {
        c(paramToServiceMsg);
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.D.Proxy", 2, "add delaySendQueue sCmd:" + paramToServiceMsg.getServiceCmd() + " ssoSeq:" + paramToServiceMsg.getRequestSsoSeq() + " appSeq:" + paramToServiceMsg.getAppSeq());
          return -1;
        }
      }
      else
      {
        c.a().onSendMsg(paramToServiceMsg, m());
        if (paramToServiceMsg.getServiceCmd().equals("RegPrxySvc.PbSyncMsg")) {
          paramToServiceMsg.setMsfCommand(MsfCommand.msf_pbSyncMsg);
        }
        if (paramToServiceMsg.getAppSeq() < 0) {
          paramToServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
        }
        try
        {
          synchronized (this.d)
          {
            if (this.i == null)
            {
              HandlerThread localHandlerThread = new HandlerThread("Timeout-Checker", 5);
              localHandlerThread.start();
              this.i = new Handler(localHandlerThread.getLooper());
            }
            if (m()) {
              i = 1;
            }
            if (paramToServiceMsg.getTimeout() == -1L) {
              paramToServiceMsg.setTimeout(30000L);
            }
            if (paramToServiceMsg.isNeedCallback())
            {
              paramToServiceMsg.addAttribute("appTimeoutReq", Integer.valueOf(this.m.incrementAndGet()));
              f.put(Integer.valueOf(paramToServiceMsg.getAppSeq()), paramToServiceMsg);
              ??? = new z.b(this, paramToServiceMsg);
              if (("LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())))
              {
                this.i.postDelayed((Runnable)???, paramToServiceMsg.getTimeout() + 20000L);
                QLog.d("MSF.D.Proxy", 1, "PicUpMsg timer start, appSeq: " + paramToServiceMsg.getAppSeq() + ", delayMillis: " + String.valueOf(paramToServiceMsg.getTimeout() + 20000L));
              }
            }
            else
            {
              if (i == 0) {
                break label568;
              }
              if (u > 0)
              {
                long l = System.currentTimeMillis();
                if ((-1L != v) && (l < v + 120000L))
                {
                  QLog.d("MSF.D.Proxy", 1, "succ to pull msf service.");
                  a(paramToServiceMsg.getUin(), true);
                }
                n();
              }
              i = a(paramToServiceMsg);
              return i;
            }
          }
        }
        catch (DeadObjectException localDeadObjectException)
        {
          for (;;)
          {
            b(paramToServiceMsg);
            QLog.i("MSF.D.Proxy", 1, "DeadObjectException", localDeadObjectException);
            return -1;
            if (!"login.auth".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
              break;
            }
            this.i.postDelayed(localDeadObjectException, paramToServiceMsg.getTimeout() + NetConnInfoCenter.sAppTimeoutConfig);
            QLog.d("MSF.D.Proxy", 1, "login timer start, appSeq: " + paramToServiceMsg.getAppSeq() + ", delayMillis: " + String.valueOf(paramToServiceMsg.getTimeout() + NetConnInfoCenter.sAppTimeoutConfig));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            for (;;)
            {
              if (this.c == null)
              {
                b(paramToServiceMsg);
                return -1;
                this.i.postDelayed(localException, paramToServiceMsg.getTimeout() + 2000L);
                continue;
                label568:
                c.a().onReqServiceConn();
                b(paramToServiceMsg);
                synchronized (this.d)
                {
                  i();
                  if ((u <= 10) || (System.currentTimeMillis() <= v + 60000L) || (w)) {
                    break;
                  }
                  QLog.d("MSF.D.Proxy", 1, "cannot pull msf service.");
                  w = true;
                  a(paramToServiceMsg.getUin(), false);
                  return -1;
                }
              }
            }
          }
          QLog.i("MSF.D.Proxy", 1, ???.getMessage(), ???);
          ???.printStackTrace();
        }
      }
    }
    return -1;
  }
  
  public boolean serviceConnected()
  {
    return true;
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
    f();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.k
 * JD-Core Version:    0.7.0.1
 */