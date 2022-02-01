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
import android.text.format.Formatter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c.f;
import com.tencent.mobileqq.msf.core.c.f.a;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfProxy;
import com.tencent.mobileqq.msf.sdk.report.IMTAReporter;
import com.tencent.mobileqq.msf.sdk.report.MTAReportManager;
import com.tencent.mobileqq.msf.sdk.report.c;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
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

public class l
  extends ab
  implements IMsfProxy
{
  private static boolean A = false;
  private static final String t = "MSF.D.Proxy";
  private static final int u = 20000;
  private static int y = 0;
  private static long z = -1L;
  private IMsfServiceCallbacker B;
  protected volatile boolean a = false;
  private volatile Handler v;
  private ConcurrentHashMap w = new ConcurrentHashMap();
  private ConcurrentHashMap x = new ConcurrentHashMap();
  
  public l(String paramString)
  {
    super(paramString);
    paramString = new HandlerThread("Transport-Timeout-Checker", 5);
    paramString.start();
    this.v = new Handler(paramString.getLooper());
  }
  
  public static void a(SharedPreferences.Editor paramEditor)
  {
    paramEditor.putString("availMem", j());
    paramEditor.putString("lowMem", k());
    try
    {
      paramEditor.putString("time", new Date().toString());
      label43:
      paramEditor.putString("process", h());
      paramEditor.putString("state", l());
      return;
    }
    catch (AssertionError localAssertionError)
    {
      break label43;
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    QLog.d("MSF.D.Proxy", 1, "onRecvServicePushResp, fromServiceMsg cmd = " + paramFromServiceMsg.getServiceCmd() + ", ssoSeq = " + paramFromServiceMsg.getRequestSsoSeq() + ", length = " + paramFromServiceMsg.getWupBuffer().length);
    if (!b(null, paramFromServiceMsg)) {
      if (paramFromServiceMsg.getMsfCommand() == MsfCommand.pushSetConfig)
      {
        QLog.setUIN_REPORTLOG_LEVEL(((Integer)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd())).intValue());
        NetConnInfoCenter.socketConnState = ((Integer)paramFromServiceMsg.getAttribute("_attr_socket_connstate")).intValue();
        NetConnInfoCenter.servetTimeSecondInterv = ((Long)paramFromServiceMsg.getAttribute("_attr_server")).longValue();
        NetConnInfoCenter.GUID = (byte[])paramFromServiceMsg.getAttribute("_attr_deviceGUID");
        NetConnInfoCenter.sAppTimeoutConfig = ((Integer)paramFromServiceMsg.getAttribute("_attr_app_timeout")).intValue();
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
          f.a().a(f.a.c, paramFromServiceMsg.getWupBuffer(), 17);
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
            f.a().a(f.a.c, paramFromServiceMsg.getWupBuffer(), 16);
          }
        } while (!QLog.isColorLevel());
        QLog.d("MSF.D.Proxy", 2, " close msfServiceConn. push msg is droped." + paramFromServiceMsg);
        return;
        if (paramFromServiceMsg.getBusinessFailCode() != -2) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MSF.D.Proxy", 2, "receive service ipc test push, length = " + paramFromServiceMsg.getWupBuffer().length);
      return;
    } while ((paramFromServiceMsg == null) || (paramFromServiceMsg.getServiceCmd() == null) || (!paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")));
    f.a().a(f.a.c, paramFromServiceMsg.getWupBuffer(), 15);
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
        break label336;
      }
      i = 1;
    }
    for (;;)
    {
      label75:
      if ("com.tencent.mobileqq".equals(localObject)) {
        label86:
        if (Build.VERSION.SDK_INT < 21) {
          break label384;
        }
      }
      Properties localProperties;
      label384:
      for (str = "android5.0+";; str = "android4.x")
      {
        localProperties = new Properties();
        localProperties.setProperty("proxy", String.valueOf(bool3));
        localProperties.setProperty("vivo", String.valueOf(bool1));
        localProperties.setProperty("param_FailCode", String.valueOf(i));
        localProperties.setProperty("mainProcess", String.valueOf(bool2));
        localProperties.setProperty("sdkver", str);
        if (!paramBoolean) {
          break label392;
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
        label336:
        if ((bool3) && (bool1))
        {
          i = 2;
          break label75;
        }
        if ((!bool3) && (!bool1))
        {
          i = 3;
          break label75;
        }
        if ((!bool3) || (bool1)) {
          break label550;
        }
        i = 4;
        break label75;
        bool2 = false;
        break label86;
      }
      label392:
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
      label550:
      i = 0;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d("MSF.D.Proxy", 1, "onReceiveResp, fromServiceMsg = " + paramFromServiceMsg.getServiceCmd() + ", ssoSeq = " + paramFromServiceMsg.getRequestSsoSeq() + ", length = " + paramFromServiceMsg.getWupBuffer().length);
    ToServiceMsg localToServiceMsg = (ToServiceMsg)e.remove(Integer.valueOf(paramToServiceMsg.getAppSeq()));
    if (localToServiceMsg != null) {
      if (("LongConn.OffPicUp".equalsIgnoreCase(localToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(localToServiceMsg.getServiceCmd()))) {
        QLog.d("MSF.D.Proxy", 1, "onReceiveResp." + localToServiceMsg.getStringForLog() + " isConnectedMsf:" + this.a);
      }
    }
    label218:
    do
    {
      do
      {
        do
        {
          break label218;
          for (;;)
          {
            if (!b(paramToServiceMsg, paramFromServiceMsg))
            {
              if (!this.a) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("MSF.D.Proxy", 2, "add queue req:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
              }
              this.r.addServiceRespMsg(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
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
    y = 0;
    this.j = -1L;
    z = -1L;
    A = false;
  }
  
  protected int a(ToServiceMsg paramToServiceMsg)
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
        paramToServiceMsg.setAppId(this.r.appid);
        paramToServiceMsg.getAttributes().put("to_SendTime", Long.valueOf(System.currentTimeMillis()));
        paramToServiceMsg.getAttributes().put("to_SenderProcessName", this.r.processName);
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
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.r.msfServiceName);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      localIntent.putExtra("to_SenderProcessName", this.r.processName);
      BaseApplication.getContext().startService(localIntent);
      QLog.d("MSF.D.Proxy", 1, "MSF_Alive_Log start service finish");
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.D.Proxy", 1, "MSF_Alive_Log " + localException, localException);
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
        ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.r.msfServiceName);
        Intent localIntent = new Intent();
        localIntent.putExtra("to_SenderProcessName", this.r.processName);
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
      default: 
        bool = false;
      case 2001: 
      case 2011: 
      case 2012: 
      case 2013: 
      case 2009: 
      case 2008: 
      case 2014: 
        for (;;)
        {
          if (bool) {
            QLog.d("MSF.D.Proxy", 1, new Object[] { "tokenExpired, failcode:", Integer.valueOf(i), " fromServiceMsg:", Integer.valueOf(paramFromServiceMsg.hashCode()) });
          }
          return bool;
          this.r.errorHandler.onUserTokenExpired(paramToServiceMsg, paramFromServiceMsg, bool);
          bool = true;
          continue;
          this.r.errorHandler.onRecvServerTip(paramToServiceMsg, paramFromServiceMsg, bool);
          bool = true;
          continue;
          this.r.errorHandler.onKickedAndClearToken(paramToServiceMsg, paramFromServiceMsg, bool);
          bool = true;
          continue;
          this.r.errorHandler.onKicked(paramToServiceMsg, paramFromServiceMsg, bool);
          bool = true;
          continue;
          this.r.errorHandler.onServerSuspended(paramToServiceMsg, paramFromServiceMsg, bool);
          bool = true;
          continue;
          this.r.errorHandler.onGrayError(paramToServiceMsg, paramFromServiceMsg, bool);
          bool = true;
          continue;
          this.r.errorHandler.onInvalidSign(bool);
          bool = true;
        }
      }
      return true;
    }
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.Proxy", 2, "add fail queue req:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
    }
    this.r.addServiceRespMsg(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
  }
  
  public boolean c()
  {
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.r.msfServiceName);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      localIntent.putExtra("to_SenderProcessName", this.r.processName);
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
    m localm = new m(this);
    localm.setName("handleWaitSendProxyMsgThread");
    localm.start();
    n();
  }
  
  protected void e()
  {
    c.a().onServiceDisconnected();
    n();
  }
  
  public void f()
  {
    while (!d.isEmpty())
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)d.poll();
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
    if ((this.i == -1L) || (l1 - this.i > 10000L))
    {
      this.i = l1;
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
            l2 = l1 - this.j;
            if ((this.j == -1L) || (l2 > 10000L))
            {
              if (y == 0) {
                z = l1;
              }
              y += 1;
              this.j = l1;
              if (y % 3 == 2)
              {
                c();
                g();
                QLog.d("MSF.D.Proxy", 1, "pullmsf to stop and unbind service above android 5");
              }
              Intent localIntent = new Intent("com.tencent.mobileqq.msf.startmsf");
              localIntent.setPackage(BaseApplication.getContext().getPackageName());
              BaseApplication.getContext().sendBroadcast(localIntent);
              this.k = 1;
              QLog.d("MSF.D.Proxy", 1, "start MsfService through Broadcast, " + y);
            }
            if ((this.j == -1L) || (l2 <= this.k * 2000)) {
              continue;
            }
            b();
            this.k += 1;
            QLog.d("MSF.D.Proxy", 1, "delay binding MSF Service");
          }
        }
        catch (Exception localException)
        {
          QLog.d("MSF.D.Proxy", 1, "start MsfService exception " + localException.toString());
          return;
        }
      }
      l2 = l1 - this.j;
      if ((this.j == -1L) || (l2 > 10000L))
      {
        if (y == 0) {
          z = l1;
        }
        y += 1;
        this.j = l1;
        if (y % 3 == 2)
        {
          c();
          g();
          QLog.d("MSF.D.Proxy", 1, "pullmsf to stop and unbind service below android 5");
        }
        this.k = 1;
        QLog.d("MSF.D.Proxy", 1, "start MsfService ignore, " + y);
      }
    } while ((this.j == -1L) || (l2 <= this.k * 2000));
    b();
    this.k += 1;
    QLog.d("MSF.D.Proxy", 1, "delay binding MSF Service");
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
    a();
    b();
  }
  
  public int registerMsfService(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.B = new n(this);
    ToServiceMsg localToServiceMsg = new ToServiceMsg(this.r.msfServiceName, "0", "cmd_RegisterMsfService");
    localToServiceMsg.setMsfCommand(MsfCommand.registerMsfService);
    Object localObject = new MsfServiceBindInfo(this.r.appid, this.r.processName, this.r.getBootBroadcastName(), this.B);
    localToServiceMsg.getAttributes().put("intent_bindServiceInfo", localObject);
    localToServiceMsg.setNeedCallback(false);
    a(this.B);
    this.a = true;
    if ((QLog.isColorLevel()) && (((MsfServiceBindInfo)localObject).getMsfServiceCallbacker() != null))
    {
      if (((MsfServiceBindInfo)localObject).getMsfServiceCallbacker() != null)
      {
        localObject = Integer.toHexString(((MsfServiceBindInfo)localObject).getMsfServiceCallbacker().hashCode());
        QLog.d("MSF.D.Proxy", 2, "registerMsfService processName=" + this.r.processName + " callback=" + (String)localObject);
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label236;
      }
      if (!paramBoolean2) {
        break label215;
      }
      this.v.postAtFrontOfQueue(new o(this, localToServiceMsg));
    }
    for (;;)
    {
      return 0;
      localObject = "null";
      break;
      label215:
      this.v.post(new p(this, localToServiceMsg));
    }
    label236:
    return sendMsg(localToServiceMsg);
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
          synchronized (this.c)
          {
            if (this.v == null)
            {
              HandlerThread localHandlerThread = new HandlerThread("MsfServiceTimeoutChecker", 5);
              localHandlerThread.start();
              this.v = new Handler(localHandlerThread.getLooper());
            }
            if (m()) {
              i = 1;
            }
            if (paramToServiceMsg.getTimeout() == -1L) {
              paramToServiceMsg.setTimeout(30000L);
            }
            if (paramToServiceMsg.isNeedCallback())
            {
              paramToServiceMsg.addAttribute("appTimeoutReq", Integer.valueOf(this.l.incrementAndGet()));
              e.put(Integer.valueOf(paramToServiceMsg.getAppSeq()), paramToServiceMsg);
              ??? = new ab.b(this, paramToServiceMsg);
              if (("LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())))
              {
                this.v.postDelayed((Runnable)???, paramToServiceMsg.getTimeout() + 20000L);
                QLog.d("MSF.D.Proxy", 1, "PicUpMsg timer start, appSeq: " + paramToServiceMsg.getAppSeq() + ", delayMillis: " + String.valueOf(paramToServiceMsg.getTimeout() + 20000L));
              }
            }
            else
            {
              if (i == 0) {
                break label568;
              }
              if (y > 0)
              {
                long l = System.currentTimeMillis();
                if ((-1L != z) && (l < z + 120000L))
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
            this.v.postDelayed(localDeadObjectException, paramToServiceMsg.getTimeout() + NetConnInfoCenter.sAppTimeoutConfig);
            QLog.d("MSF.D.Proxy", 1, "login timer start, appSeq: " + paramToServiceMsg.getAppSeq() + ", delayMillis: " + String.valueOf(paramToServiceMsg.getTimeout() + NetConnInfoCenter.sAppTimeoutConfig));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            for (;;)
            {
              if (this.b == null)
              {
                b(paramToServiceMsg);
                return -1;
                this.v.postDelayed(localException, paramToServiceMsg.getTimeout() + 2000L);
                continue;
                label568:
                c.a().onReqServiceConn();
                b(paramToServiceMsg);
                synchronized (this.c)
                {
                  i();
                  if ((y <= 10) || (System.currentTimeMillis() <= z + 60000L) || (A)) {
                    break;
                  }
                  QLog.d("MSF.D.Proxy", 1, "cannot pull msf service.");
                  A = true;
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
    return m();
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
    b(this.B);
    return sendMsg(localToServiceMsg);
  }
  
  public void unbindMsfService()
  {
    f();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.l
 * JD-Core Version:    0.7.0.1
 */