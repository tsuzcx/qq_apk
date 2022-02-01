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
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.core.c.e.a;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.sdk.b.c;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfProxy;
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
import java.util.Map;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecvServicePushResp, fromServiceMsg cmd = ");
    localStringBuilder.append(paramFromServiceMsg.getServiceCmd());
    localStringBuilder.append(", ssoSeq = ");
    localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
    localStringBuilder.append(", length = ");
    localStringBuilder.append(paramFromServiceMsg.getWupBuffer().length);
    QLog.d("MSF.D.Proxy", 1, localStringBuilder.toString());
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
          QLog.d("MSF.D.Proxy", 2, localStringBuilder.toString());
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
        QLog.d("MSF.D.Proxy", 2, localStringBuilder.toString());
      }
    }
    else if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
      e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 15);
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Build.MANUFACTURER);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(Build.MODEL);
    localObject1 = ((StringBuilder)localObject1).toString().toLowerCase();
    Object localObject2 = h();
    boolean bool2 = MsfServiceSdk.isUseNewProxy;
    int i = 1;
    boolean bool1;
    if ((localObject1 != null) && (((String)localObject1).indexOf("vivo") >= 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((bool2) || (!bool1)) {
      if ((bool2) && (bool1)) {
        i = 2;
      } else if ((!bool2) && (!bool1)) {
        i = 3;
      } else if ((bool2) && (!bool1)) {
        i = 4;
      } else {
        i = 0;
      }
    }
    boolean bool3 = "com.tencent.mobileqq".equals(localObject2);
    if (Build.VERSION.SDK_INT >= 21) {
      localObject1 = "android5.0+";
    } else {
      localObject1 = "android4.x";
    }
    Object localObject3 = new HashMap();
    ((HashMap)localObject3).put("proxy", String.valueOf(bool2));
    ((HashMap)localObject3).put("vivo", String.valueOf(bool1));
    ((HashMap)localObject3).put("param_FailCode", String.valueOf(i));
    ((HashMap)localObject3).put("mainProcess", String.valueOf(bool3));
    ((HashMap)localObject3).put("sdkver", localObject1);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.Proxy", 2, "MTA is not initConfig or unsupported.");
      }
      localObject3 = BaseApplication.getContext();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pull_msf_succ");
      localStringBuilder.append((String)localObject2);
      localObject2 = ((BaseApplication)localObject3).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      ((SharedPreferences.Editor)localObject2).putString("uin", paramString);
      ((SharedPreferences.Editor)localObject2).putString("proxy", String.valueOf(bool2));
      ((SharedPreferences.Editor)localObject2).putString("vivo", String.valueOf(bool1));
      ((SharedPreferences.Editor)localObject2).putString("param_FailCode", String.valueOf(i));
      ((SharedPreferences.Editor)localObject2).putString("mainProcess", String.valueOf(bool3));
      ((SharedPreferences.Editor)localObject2).putString("sdkver", (String)localObject1);
      a((SharedPreferences.Editor)localObject2);
      ((SharedPreferences.Editor)localObject2).commit();
      return;
    }
    if ((MsfCore.sCore != null) && (MsfCore.sCore.statReporter != null)) {
      MsfCore.sCore.statReporter.a("pullMsfReportQQ_V4", true, 0L, 0L, (Map)localObject3, false, false);
    }
    localObject3 = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pull_msf");
    localStringBuilder.append((String)localObject2);
    localObject2 = ((BaseApplication)localObject3).getSharedPreferences(localStringBuilder.toString(), 0).edit();
    ((SharedPreferences.Editor)localObject2).putString("uin", paramString);
    ((SharedPreferences.Editor)localObject2).putString("proxy", String.valueOf(bool2));
    ((SharedPreferences.Editor)localObject2).putString("vivo", String.valueOf(bool1));
    ((SharedPreferences.Editor)localObject2).putString("param_FailCode", String.valueOf(i));
    ((SharedPreferences.Editor)localObject2).putString("mainProcess", String.valueOf(bool3));
    ((SharedPreferences.Editor)localObject2).putString("sdkver", (String)localObject1);
    a((SharedPreferences.Editor)localObject2);
    ((SharedPreferences.Editor)localObject2).commit();
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceiveResp, fromServiceMsg = ");
    ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
    ((StringBuilder)localObject).append(", ssoSeq = ");
    ((StringBuilder)localObject).append(paramFromServiceMsg.getRequestSsoSeq());
    ((StringBuilder)localObject).append(", length = ");
    ((StringBuilder)localObject).append(paramFromServiceMsg.getWupBuffer().length);
    QLog.d("MSF.D.Proxy", 1, ((StringBuilder)localObject).toString());
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
          QLog.d("MSF.D.Proxy", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceiveResp.");
        localStringBuilder.append(((ToServiceMsg)localObject).getStringForLog());
        localStringBuilder.append(" isConnectedMsf:");
        localStringBuilder.append(this.a);
        QLog.d("MSF.D.Proxy", 1, localStringBuilder.toString());
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
            QLog.d("MSF.D.Proxy", 2, ((StringBuilder)localObject).toString());
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
          QLog.d("MSF.D.Proxy", 2, ((StringBuilder)localObject).toString());
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
        QLog.d("MSF.D.Proxy", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("onReceiveResp.");
      paramToServiceMsg.append(paramFromServiceMsg.getStringForLog());
      paramToServiceMsg.append(" waiteTemp is null.");
      QLog.d("MSF.D.Proxy", 1, paramToServiceMsg.toString());
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
  
  public static String h()
  {
    try
    {
      int i = Process.myPid();
      Object localObject = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      } while (localRunningAppProcessInfo.pid != i);
      localObject = localRunningAppProcessInfo.processName;
      return localObject;
    }
    catch (Exception localException)
    {
      label59:
      break label59;
    }
    QLog.d("MSF.D.Proxy", 1, "failed to get current process name");
    return null;
  }
  
  public static String j()
  {
    try
    {
      Object localObject2 = (ActivityManager)BaseApplication.getContext().getSystemService("activity");
      Object localObject1 = new ActivityManager.MemoryInfo();
      ((ActivityManager)localObject2).getMemoryInfo((ActivityManager.MemoryInfo)localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Property get avail memory:");
      ((StringBuilder)localObject2).append(((ActivityManager.MemoryInfo)localObject1).availMem);
      QLog.d("MSF.D.Proxy", 1, ((StringBuilder)localObject2).toString());
      localObject1 = Formatter.formatFileSize(BaseApplication.getContext(), ((ActivityManager.MemoryInfo)localObject1).availMem);
      return localObject1;
    }
    catch (Exception localException)
    {
      label74:
      break label74;
    }
    QLog.d("MSF.D.Proxy", 1, "failed to get avail memory");
    return null;
  }
  
  public static String k()
  {
    try
    {
      Object localObject = (ActivityManager)BaseApplication.getContext().getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Property get low memory feature:");
      ((StringBuilder)localObject).append(localMemoryInfo.lowMemory);
      QLog.d("MSF.D.Proxy", 1, ((StringBuilder)localObject).toString());
      boolean bool = localMemoryInfo.lowMemory;
      return String.valueOf(bool);
    }
    catch (Exception localException)
    {
      label71:
      break label71;
    }
    QLog.d("MSF.D.Proxy", 1, "failed to get low memory feature");
    return null;
  }
  
  public static String l()
  {
    try
    {
      Iterator localIterator = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningServices(256).iterator();
      int i = 0;
      Object localObject1 = null;
      boolean bool = false;
      while (localIterator.hasNext())
      {
        int j = i + 1;
        localObject2 = (ActivityManager.RunningServiceInfo)localIterator.next();
        i = j;
        if (((ActivityManager.RunningServiceInfo)localObject2).process.trim().equals("com.tencent.mobileqq:MSF"))
        {
          localObject1 = localObject2;
          bool = true;
          i = j;
        }
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isMsfAlive:");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", cur service process count:");
      ((StringBuilder)localObject2).append(i);
      QLog.d("MSF.D.Proxy", 1, ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("countService_");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(":");
      if ((bool) && (localObject1 != null))
      {
        ((StringBuilder)localObject2).append("alive_");
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append("activeSince_");
        ((StringBuilder)localObject2).append(((ActivityManager.RunningServiceInfo)localObject1).activeSince);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append("clientCount_");
        ((StringBuilder)localObject2).append(((ActivityManager.RunningServiceInfo)localObject1).clientCount);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append("clientLabel_");
        ((StringBuilder)localObject2).append(((ActivityManager.RunningServiceInfo)localObject1).clientLabel);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append("clientPkg_");
        ((StringBuilder)localObject2).append(((ActivityManager.RunningServiceInfo)localObject1).clientPackage);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append("crashCount_");
        ((StringBuilder)localObject2).append(((ActivityManager.RunningServiceInfo)localObject1).crashCount);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append("flags_");
        ((StringBuilder)localObject2).append(((ActivityManager.RunningServiceInfo)localObject1).flags);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append("foreground_");
        ((StringBuilder)localObject2).append(((ActivityManager.RunningServiceInfo)localObject1).foreground);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append("lastActivityTime_");
        ((StringBuilder)localObject2).append(((ActivityManager.RunningServiceInfo)localObject1).lastActivityTime);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append("pid_");
        ((StringBuilder)localObject2).append(((ActivityManager.RunningServiceInfo)localObject1).pid);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append("process_");
        ((StringBuilder)localObject2).append(((ActivityManager.RunningServiceInfo)localObject1).process);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append("restarting_");
        ((StringBuilder)localObject2).append(((ActivityManager.RunningServiceInfo)localObject1).restarting);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append("started_");
        ((StringBuilder)localObject2).append(((ActivityManager.RunningServiceInfo)localObject1).started);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append("uid_");
        ((StringBuilder)localObject2).append(((ActivityManager.RunningServiceInfo)localObject1).uid);
      }
      else
      {
        ((StringBuilder)localObject2).append("alive_");
        ((StringBuilder)localObject2).append(bool);
      }
      localObject1 = ((StringBuilder)localObject2).toString();
      return localObject1;
    }
    catch (Exception localException)
    {
      label587:
      break label587;
    }
    QLog.d("MSF.D.Proxy", 1, "failed to getServiceState");
    return null;
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
    if (paramToServiceMsg == null) {
      return -1;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("proxy#sendMsgToService start: cmd = ");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      QLog.d("MSF.D.Proxy", 2, localStringBuilder.toString());
    }
    paramToServiceMsg.setAppId(this.r.appid);
    paramToServiceMsg.getAttributes().put("to_SendTime", Long.valueOf(System.currentTimeMillis()));
    paramToServiceMsg.getAttributes().put("to_SenderProcessName", this.r.processName);
    int i = super.a(paramToServiceMsg);
    if ((QLog.isColorLevel()) && ((paramToServiceMsg.getServiceCmd() == null) || (!"socketnetflow".equals(paramToServiceMsg.getServiceCmd()))))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" sendMsgToService ");
      localStringBuilder.append(paramToServiceMsg);
      QLog.d("MSF.D.Proxy", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  void a()
  {
    if (!com.tencent.mobileqq.msf.core.p.a())
    {
      QLog.d("MSF.D.Proxy", 1, "startBaseService no allow");
      return;
    }
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.r.msfServiceName);
      localObject = new Intent();
      ((Intent)localObject).setComponent(localComponentName);
      ((Intent)localObject).putExtra("to_SenderProcessName", this.r.processName);
      BaseApplication.getContext().startService((Intent)localObject);
      QLog.d("MSF.D.Proxy", 1, "MSF_Alive_Log start service finish");
      return;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MSF_Alive_Log ");
      ((StringBuilder)localObject).append(localException);
      QLog.d("MSF.D.Proxy", 1, ((StringBuilder)localObject).toString(), localException);
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  boolean b()
  {
    boolean bool1 = com.tencent.mobileqq.msf.core.p.a();
    boolean bool2 = false;
    if (!bool1)
    {
      QLog.d("MSF.D.Proxy", 1, "bindBaseService no allow");
      return false;
    }
    c.a().onBindStart();
    bool1 = bool2;
    try
    {
      Object localObject1 = new ComponentName(BaseApplication.getContext().getPackageName(), this.r.msfServiceName);
      bool1 = bool2;
      localObject2 = new Intent();
      bool1 = bool2;
      ((Intent)localObject2).putExtra("to_SenderProcessName", this.r.processName);
      bool1 = bool2;
      ((Intent)localObject2).setComponent((ComponentName)localObject1);
      bool1 = bool2;
      bool2 = BaseApplication.getContext().bindService((Intent)localObject2, this.s, 1);
      bool1 = bool2;
      localObject1 = new StringBuilder();
      bool1 = bool2;
      ((StringBuilder)localObject1).append("threadID:");
      bool1 = bool2;
      ((StringBuilder)localObject1).append(Thread.currentThread().getId());
      bool1 = bool2;
      ((StringBuilder)localObject1).append(", threadName: ");
      bool1 = bool2;
      ((StringBuilder)localObject1).append(Thread.currentThread().getName());
      bool1 = bool2;
      ((StringBuilder)localObject1).append(" bind service finished ");
      bool1 = bool2;
      ((StringBuilder)localObject1).append(bool2);
      bool1 = bool2;
      QLog.d("MSF.D.Proxy", 1, ((StringBuilder)localObject1).toString());
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(localException);
      QLog.d("MSF.D.Proxy", 1, ((StringBuilder)localObject2).toString(), localException);
    }
    c.a().onBindEnd(bool1);
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
          if (i != 2009) {
            switch (i)
            {
            default: 
              bool = false;
              break;
            case 2014: 
              this.r.errorHandler.onInvalidSign(bool);
              break;
            case 2013: 
              this.r.errorHandler.onKicked(paramToServiceMsg, paramFromServiceMsg, bool);
              break;
            case 2012: 
              this.r.errorHandler.onKickedAndClearToken(paramToServiceMsg, paramFromServiceMsg, bool);
              break;
            case 2011: 
              this.r.errorHandler.onRecvServerTip(paramToServiceMsg, paramFromServiceMsg, bool);
              break;
            }
          } else {
            this.r.errorHandler.onServerSuspended(paramToServiceMsg, paramFromServiceMsg, bool);
          }
        }
        else {
          this.r.errorHandler.onGrayError(paramToServiceMsg, paramFromServiceMsg, bool);
        }
      }
      else {
        this.r.errorHandler.onUserTokenExpired(paramToServiceMsg, paramFromServiceMsg, bool);
      }
      bool = true;
      if (bool) {
        QLog.d("MSF.D.Proxy", 1, new Object[] { "tokenExpired, failcode:", Integer.valueOf(i), " fromServiceMsg:", Integer.valueOf(paramFromServiceMsg.hashCode()) });
      }
      return bool;
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
      QLog.d("MSF.D.Proxy", 2, localStringBuilder.toString());
    }
    this.r.addServiceRespMsg(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
  }
  
  public boolean c()
  {
    try
    {
      Object localObject = new ComponentName(BaseApplication.getContext().getPackageName(), this.r.msfServiceName);
      Intent localIntent = new Intent();
      localIntent.setComponent((ComponentName)localObject);
      localIntent.putExtra("to_SenderProcessName", this.r.processName);
      boolean bool = BaseApplication.getContext().stopService(localIntent);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopService service finished ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("MSF.D.Proxy", 1, ((StringBuilder)localObject).toString());
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
        if (localToServiceMsg.isNeedCallback())
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
  
  public void g()
  {
    super.g();
  }
  
  public void i()
  {
    if (!com.tencent.mobileqq.msf.core.p.a())
    {
      QLog.d("MSF.D.Proxy", 1, "startBaseServiceConn no allow");
      return;
    }
    long l1 = System.currentTimeMillis();
    if ((this.i != -1L) && (l1 - this.i <= 10000L))
    {
      try
      {
        int i = Build.VERSION.SDK_INT;
        Object localObject;
        if (i >= 21)
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
            localObject = new Intent("com.tencent.mobileqq.msf.startmsf");
            ((Intent)localObject).setPackage(BaseApplication.getContext().getPackageName());
            BaseApplication.getContext().sendBroadcast((Intent)localObject);
            this.k = 1;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("start MsfService through Broadcast, ");
            ((StringBuilder)localObject).append(y);
            QLog.d("MSF.D.Proxy", 1, ((StringBuilder)localObject).toString());
          }
          if ((this.j == -1L) || (l2 <= this.k * 2000)) {
            return;
          }
          b();
          this.k += 1;
          QLog.d("MSF.D.Proxy", 1, "delay binding MSF Service");
          return;
        }
        long l2 = l1 - this.j;
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
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("start MsfService ignore, ");
          ((StringBuilder)localObject).append(y);
          QLog.d("MSF.D.Proxy", 1, ((StringBuilder)localObject).toString());
        }
        if ((this.j == -1L) || (l2 <= this.k * 2000)) {
          return;
        }
        b();
        this.k += 1;
        QLog.d("MSF.D.Proxy", 1, "delay binding MSF Service");
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start MsfService exception ");
        localStringBuilder.append(localException.toString());
        QLog.d("MSF.D.Proxy", 1, localStringBuilder.toString());
        return;
      }
    }
    else
    {
      this.i = l1;
      a();
      b();
    }
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
      if (((MsfServiceBindInfo)localObject).getMsfServiceCallbacker() != null) {
        localObject = Integer.toHexString(((MsfServiceBindInfo)localObject).getMsfServiceCallbacker().hashCode());
      } else {
        localObject = "null";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("registerMsfService processName=");
      localStringBuilder.append(this.r.processName);
      localStringBuilder.append(" callback=");
      localStringBuilder.append((String)localObject);
      QLog.d("MSF.D.Proxy", 2, localStringBuilder.toString());
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.v.postAtFrontOfQueue(new o(this, localToServiceMsg));
        return 0;
      }
      this.v.post(new p(this, localToServiceMsg));
      return 0;
    }
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
    if (paramToServiceMsg == null) {
      return -1;
    }
    if (d(paramToServiceMsg))
    {
      c(paramToServiceMsg);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("add delaySendQueue sCmd:");
        ((StringBuilder)???).append(paramToServiceMsg.getServiceCmd());
        ((StringBuilder)???).append(" ssoSeq:");
        ((StringBuilder)???).append(paramToServiceMsg.getRequestSsoSeq());
        ((StringBuilder)???).append(" appSeq:");
        ((StringBuilder)???).append(paramToServiceMsg.getAppSeq());
        QLog.d("MSF.D.Proxy", 2, ((StringBuilder)???).toString());
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
    for (;;)
    {
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
          if (!m()) {
            break label730;
          }
          i = 1;
          if (paramToServiceMsg.getTimeout() == -1L) {
            paramToServiceMsg.setTimeout(30000L);
          }
          if (paramToServiceMsg.isNeedCallback())
          {
            paramToServiceMsg.addAttribute("appTimeoutReq", Integer.valueOf(this.l.incrementAndGet()));
            e.put(Integer.valueOf(paramToServiceMsg.getAppSeq()), paramToServiceMsg);
            ??? = new ab.b(this, paramToServiceMsg);
            if ((!"LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) && (!"ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())))
            {
              if ("login.auth".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))
              {
                this.v.postDelayed((Runnable)???, paramToServiceMsg.getTimeout() + NetConnInfoCenter.sAppTimeoutConfig);
                ??? = new StringBuilder();
                ((StringBuilder)???).append("login timer start, appSeq: ");
                ((StringBuilder)???).append(paramToServiceMsg.getAppSeq());
                ((StringBuilder)???).append(", delayMillis: ");
                ((StringBuilder)???).append(String.valueOf(paramToServiceMsg.getTimeout() + NetConnInfoCenter.sAppTimeoutConfig));
                QLog.d("MSF.D.Proxy", 1, ((StringBuilder)???).toString());
              }
              else
              {
                this.v.postDelayed((Runnable)???, paramToServiceMsg.getTimeout() + 2000L);
              }
            }
            else
            {
              this.v.postDelayed((Runnable)???, paramToServiceMsg.getTimeout() + 20000L);
              ??? = new StringBuilder();
              ((StringBuilder)???).append("PicUpMsg timer start, appSeq: ");
              ((StringBuilder)???).append(paramToServiceMsg.getAppSeq());
              ((StringBuilder)???).append(", delayMillis: ");
              ((StringBuilder)???).append(String.valueOf(paramToServiceMsg.getTimeout() + 20000L));
              QLog.d("MSF.D.Proxy", 1, ((StringBuilder)???).toString());
            }
          }
          if (i != 0)
          {
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
            return a(paramToServiceMsg);
          }
          c.a().onReqServiceConn();
          b(paramToServiceMsg);
          synchronized (this.c)
          {
            i();
            if ((y > 10) && (System.currentTimeMillis() > z + 60000L) && (!A))
            {
              QLog.d("MSF.D.Proxy", 1, "cannot pull msf service.");
              A = true;
              a(paramToServiceMsg.getUin(), false);
              return -1;
            }
          }
        }
        return -1;
      }
      catch (Exception localException)
      {
        if (this.b == null)
        {
          b(paramToServiceMsg);
          return -1;
        }
        QLog.i("MSF.D.Proxy", 1, localException.getMessage(), localException);
        localException.printStackTrace();
        return -1;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        b(paramToServiceMsg);
        QLog.i("MSF.D.Proxy", 1, "DeadObjectException", localDeadObjectException);
      }
      label730:
      int i = 0;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.l
 * JD-Core Version:    0.7.0.1
 */