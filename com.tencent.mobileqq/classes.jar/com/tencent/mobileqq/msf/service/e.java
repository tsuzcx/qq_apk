package com.tencent.mobileqq.msf.service;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.c.f.a;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class e
{
  static final String a = "MSF.S.AppProcessManager";
  public static final String b = "app_process_info_";
  static ConcurrentHashMap c = new ConcurrentHashMap();
  static b d = new b();
  static MsfCore e;
  static v f = null;
  
  public static c a(String paramString)
  {
    return (c)c.get(paramString);
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      paramContext = MsfStore.getNativeConfigStore().getConfigList("app_process_info_");
      StringBuilder localStringBuilder = new StringBuilder().append("start loadAppProcessInfos proInfos size=");
      if (paramContext == null)
      {
        localObject = "null";
        QLog.d("MSF.S.AppProcessManager", 1, localObject);
        if (paramContext == null) {
          return;
        }
        int j = paramContext.length;
        int i = 0;
        while (i < j)
        {
          localObject = paramContext[i];
          QLog.d("MSF.S.AppProcessManager", 1, "loadAppProcessInfo proInfo:" + (String)localObject);
          String[] arrayOfString = ((String)localObject).split(",");
          localStringBuilder = arrayOfString[0];
          localObject = "";
          if (arrayOfString.length > 1) {
            localObject = arrayOfString[1];
          }
          a(localStringBuilder, (String)localObject, null, 0);
          i += 1;
        }
      }
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      for (;;)
      {
        QLog.d("MSF.S.AppProcessManager", 1, "loadAppProcessInfo UnsatisfiedLinkError", paramContext);
        if (new Random().nextInt(100) < 1) {
          CrashReport.handleCatchException(Thread.currentThread(), paramContext, "NativeConfigStoreCatchedException", null);
        }
        paramContext = null;
        continue;
        Object localObject = Integer.valueOf(paramContext.length);
      }
    }
  }
  
  public static void a(Context paramContext, MsfCore paramMsfCore)
  {
    e = paramMsfCore;
    d.setName("MsfServiceAppMsgHandler");
    f = new v(paramMsfCore);
    d.start();
    a(paramContext);
  }
  
  public static void a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    paramString = (c)c.get(paramString);
    if (paramString != null) {
      paramString.a(paramInt, paramLong1, paramLong2);
    }
  }
  
  public static void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MSF.S.AppProcessManager", 2, "find null processName msg to app " + paramToServiceMsg + " " + paramFromServiceMsg);
      }
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
        com.tencent.mobileqq.msf.core.c.f.a().a(f.a.c, paramFromServiceMsg.getWupBuffer(), 7);
      }
      return;
    }
    if (paramString.equals("*"))
    {
      paramString = c.entrySet().iterator();
      while (paramString.hasNext())
      {
        localObject = (Map.Entry)paramString.next();
        MsfSdkUtils.addFromMsgProcessName((String)((Map.Entry)localObject).getKey(), paramFromServiceMsg);
        ((c)((Map.Entry)localObject).getValue()).i.add(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
      }
    }
    Object localObject = (c)c.get(paramString);
    if (localObject != null)
    {
      ((c)localObject).i.add(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
      if (paramFromServiceMsg.getServiceCmd().equals(com.tencent.qphone.base.BaseConstants.CMD_NeedBootPushCmdHeads[1]))
      {
        paramToServiceMsg = new HashMap();
        a(paramToServiceMsg);
        paramToServiceMsg.put("MsgType", paramFromServiceMsg.toString());
        if (localObject == null) {
          break label424;
        }
      }
    }
    label424:
    for (boolean bool = true;; bool = false)
    {
      paramToServiceMsg.put("AppInfo", String.valueOf(bool));
      paramToServiceMsg.put("uin", paramFromServiceMsg.getUin());
      paramToServiceMsg.put("ProcName", paramString);
      paramToServiceMsg.put("appid", String.valueOf(paramFromServiceMsg.getAppId()));
      if (e.getStatReporter() != null) {
        e.getStatReporter().a("dim.Msf.ForkVideoProc", false, 0L, 0L, paramToServiceMsg, true, false);
      }
      d.a();
      return;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
        com.tencent.mobileqq.msf.core.c.f.a().a(f.a.c, paramFromServiceMsg.getWupBuffer(), 8);
      }
      QLog.e("MSF.S.AppProcessManager", 1, "can not find " + paramString + " to receive msg to:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
      break;
    }
  }
  
  public static void a(String paramString, Boolean paramBoolean)
  {
    QLog.i("MSF.S.AppProcessManager", 1, "onUnRegisterApp process=" + paramString + " stopWakeupProcess=" + paramBoolean);
    c localc = (c)c.get(paramString);
    if (localc != null)
    {
      localc.a(localc.c());
      if (BaseApplication.getContext().getPackageName().equals(paramString)) {
        localc.a(100, 0L, 0L);
      }
    }
    if (!paramBoolean.booleanValue()) {
      if (QLog.isColorLevel())
      {
        paramBoolean = new StringBuilder().append("unregister process :").append(paramString).append(" ");
        if (localc != null) {
          break label139;
        }
        paramString = "failed";
        QLog.d("MSF.S.AppProcessManager", 2, paramString);
      }
    }
    label139:
    do
    {
      return;
      paramString = "succ";
      break;
      localc = (c)c.remove(paramString);
      MsfStore.getNativeConfigStore().removeConfig("app_process_info_" + paramString);
    } while (!QLog.isColorLevel());
    paramBoolean = new StringBuilder().append("remove process :").append(paramString).append(" ");
    if (localc == null) {}
    for (paramString = "failed";; paramString = "succ")
    {
      QLog.d("MSF.S.AppProcessManager", 2, paramString);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, IMsfServiceCallbacker paramIMsfServiceCallbacker, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onRegisterApp process=").append(paramString1).append(" processBootName=").append(paramString2).append(" appid=").append(paramInt).append(" callback=");
    if (paramIMsfServiceCallbacker != null) {}
    for (String str = Integer.toHexString(paramIMsfServiceCallbacker.hashCode());; str = "null")
    {
      QLog.i("MSF.S.AppProcessManager", 1, str);
      if (paramString1 != null) {
        break;
      }
      QLog.w("MSF.S.AppProcessManager", 1, MsfSdkUtils.getProcessName(BaseApplication.getContext()) + " " + Thread.currentThread().getName() + " onRegisterApp appProcessName is null");
      return;
    }
    str = BaseApplication.getContext().getPackageName();
    try
    {
      bool = paramString1.equals(str);
      if (!c.containsKey(paramString1))
      {
        c.putIfAbsent(paramString1, new c());
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.AppProcessManager", 2, "add processName: " + paramString1);
        }
        if (bool)
        {
          ((c)c.get(paramString1)).j = f;
          ((c)c.get(paramString1)).e = true;
        }
      }
      ((c)c.get(paramString1)).a(paramString1, paramString2, paramIMsfServiceCallbacker);
      MsfStore.getNativeConfigStore().setConfig("app_process_info_" + paramString1, ((c)c.get(paramString1)).a());
      if ((paramInt != 0) && (bool) && ((MsfCore.mobileQQAppid == -1) || (MsfCore.mobileQQAppid != paramInt)))
      {
        MsfCore.mobileQQAppid = paramInt;
        MsfStore.getNativeConfigStore().setConfig("key_mobileQQAppid", String.valueOf(paramInt));
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.AppProcessManager", 2, "set mobileQQAppid :" + paramInt);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.AppProcessManager", 2, "add process :" + paramString1);
      }
      d.a();
      f.a().c();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("MSF.S.AppProcessManager", 1, "except at string compare ", localException);
        boolean bool = false;
      }
    }
  }
  
  public static void a(HashMap paramHashMap)
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)BaseApplication.getContext().getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      localActivityManager.getMemoryInfo(localMemoryInfo);
      paramHashMap.put("availMem", String.valueOf(localMemoryInfo.availMem));
      paramHashMap.put("lowMemory", String.valueOf(localMemoryInfo.lowMemory));
      return;
    }
    catch (Exception paramHashMap)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MSF.S.AppProcessManager", 2, "getSystemStatus exception", paramHashMap);
    }
  }
  
  public static boolean a()
  {
    return f.a();
  }
  
  public static void b(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MSF.S.AppProcessManager", 2, "find null processName msg to app " + paramToServiceMsg + " " + paramFromServiceMsg);
      }
      return;
    }
    c localc = (c)c.get(paramString);
    if (localc != null)
    {
      int i = ((Integer)paramToServiceMsg.getAttribute("status")).intValue();
      paramFromServiceMsg.addAttribute("status", Integer.valueOf(i));
      paramFromServiceMsg.setMsgSuccess();
      if (i == 1)
      {
        a(paramString, paramToServiceMsg, paramFromServiceMsg);
        localc.c = true;
        localc.b = SystemClock.elapsedRealtime();
      }
      for (;;)
      {
        QLog.e("MSF.S.AppProcessManager", 1, "setAppConnStatus " + paramString + " " + i);
        return;
        if (i == 2) {
          localc.c = false;
        }
      }
    }
    QLog.e("MSF.S.AppProcessManager", 1, "can not find " + paramString + " to receive msg to:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
  }
  
  public static boolean b(String paramString)
  {
    c localc = (c)c.get(paramString);
    if ((localc != null) && (localc.c() != null))
    {
      QLog.w("MSF.S.AppProcessManager", 1, "process " + paramString + " also registed,can not unregister by proxy.");
      return false;
    }
    return true;
  }
  
  public static void c(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.S.AppProcessManager", 2, String.format("keepProcessAlive processName=%s toServiceMsg=%s fromServiceMsg=%s", new Object[] { paramString, paramToServiceMsg, paramFromServiceMsg }));
    }
    if (!TextUtils.isEmpty(paramString))
    {
      c localc = (c)c.get(paramString);
      if (localc != null)
      {
        boolean bool = ((Boolean)paramToServiceMsg.getAttribute("keepAlive")).booleanValue();
        QLog.d("MSF.S.AppProcessManager", 1, String.format("keepProcessAlive processName=%s keepProcessAlive=%s", new Object[] { paramString, Boolean.valueOf(bool) }));
        localc.k = bool;
        paramFromServiceMsg.addAttribute("keepAlive", Boolean.valueOf(bool));
        paramFromServiceMsg.setMsgSuccess();
        a(paramString, paramToServiceMsg, paramFromServiceMsg);
      }
    }
    else
    {
      return;
    }
    QLog.e("MSF.S.AppProcessManager", 1, String.format("keepProcessAlive can not find process to receive msg, processName=%s", new Object[] { paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.e
 * JD-Core Version:    0.7.0.1
 */