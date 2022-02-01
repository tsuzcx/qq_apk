package com.tencent.mobileqq.msf.service;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.d.e.a;
import com.tencent.mobileqq.msf.core.d.j;
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
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      QLog.d("MSF.S.AppProcessManager", 1, "loadAppProcessInfo UnsatisfiedLinkError", paramContext);
      if (new Random().nextInt(100) < 1) {
        CrashReport.handleCatchException(Thread.currentThread(), paramContext, "NativeConfigStoreCatchedException", null);
      }
      paramContext = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start loadAppProcessInfos proInfos size=");
    Object localObject;
    if (paramContext == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(paramContext.length);
    }
    localStringBuilder.append(localObject);
    QLog.d("MSF.S.AppProcessManager", 1, localStringBuilder.toString());
    if (paramContext != null)
    {
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        localObject = paramContext[i];
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadAppProcessInfo proInfo:");
        localStringBuilder.append((String)localObject);
        QLog.d("MSF.S.AppProcessManager", 1, localStringBuilder.toString());
        localObject = ((String)localObject).split(",");
        localStringBuilder = localObject[0];
        if (localObject.length > 1) {
          localObject = localObject[1];
        } else {
          localObject = "";
        }
        a(localStringBuilder, (String)localObject, null, 0);
        i += 1;
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
    if ((paramString != null) && (paramString.length() != 0))
    {
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
      boolean bool = true;
      if (localObject != null)
      {
        ((c)localObject).i.add(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
      }
      else
      {
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
          com.tencent.mobileqq.msf.core.d.e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 8);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("can not find ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" to receive msg to:");
        localStringBuilder.append(paramToServiceMsg);
        localStringBuilder.append(" from:");
        localStringBuilder.append(paramFromServiceMsg);
        QLog.e("MSF.S.AppProcessManager", 1, localStringBuilder.toString());
      }
      if (paramFromServiceMsg.getServiceCmd().equals(com.tencent.qphone.base.BaseConstants.CMD_NeedBootPushCmdHeads[1]))
      {
        paramToServiceMsg = new HashMap();
        a(paramToServiceMsg);
        paramToServiceMsg.put("MsgType", paramFromServiceMsg.toString());
        if (localObject == null) {
          bool = false;
        }
        paramToServiceMsg.put("AppInfo", String.valueOf(bool));
        paramToServiceMsg.put("uin", paramFromServiceMsg.getUin());
        paramToServiceMsg.put("ProcName", paramString);
        paramToServiceMsg.put("appid", String.valueOf(paramFromServiceMsg.getAppId()));
        if (e.getStatReporter() != null) {
          e.getStatReporter().a("dim.Msf.ForkVideoProc", false, 0L, 0L, paramToServiceMsg, true, false);
        }
      }
      d.a();
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("find null processName msg to app ");
      paramString.append(paramToServiceMsg);
      paramString.append(" ");
      paramString.append(paramFromServiceMsg);
      QLog.e("MSF.S.AppProcessManager", 2, paramString.toString());
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
      com.tencent.mobileqq.msf.core.d.e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 7);
    }
  }
  
  public static void a(String paramString, Boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onUnRegisterApp process=");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" stopWakeupProcess=");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.i("MSF.S.AppProcessManager", 1, ((StringBuilder)localObject1).toString());
    Object localObject2 = (c)c.get(paramString);
    if (localObject2 != null)
    {
      ((c)localObject2).a(((c)localObject2).c());
      if (BaseApplication.getContext().getPackageName().equals(paramString)) {
        ((c)localObject2).a(100, 0L, 0L);
      }
    }
    boolean bool = paramBoolean.booleanValue();
    paramBoolean = "failed";
    if (!bool)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("unregister process :");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" ");
        if (localObject2 != null) {
          paramBoolean = "succ";
        }
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.d("MSF.S.AppProcessManager", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      localObject1 = (c)c.remove(paramString);
      localObject2 = MsfStore.getNativeConfigStore();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("app_process_info_");
      localStringBuilder.append(paramString);
      ((NativeConfigStore)localObject2).removeConfig(localStringBuilder.toString());
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("remove process :");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" ");
        if (localObject1 != null) {
          paramBoolean = "succ";
        }
        ((StringBuilder)localObject2).append(paramBoolean);
        QLog.d("MSF.S.AppProcessManager", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, IMsfServiceCallbacker paramIMsfServiceCallbacker, int paramInt)
  {
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("onRegisterApp process=");
    localStringBuilder2.append(paramString1);
    localStringBuilder2.append(" processBootName=");
    localStringBuilder2.append(paramString2);
    localStringBuilder2.append(" appid=");
    localStringBuilder2.append(paramInt);
    localStringBuilder2.append(" callback=");
    if (paramIMsfServiceCallbacker != null) {
      str = Integer.toHexString(paramIMsfServiceCallbacker.hashCode());
    } else {
      str = "null";
    }
    localStringBuilder2.append(str);
    QLog.i("MSF.S.AppProcessManager", 1, localStringBuilder2.toString());
    if (paramString1 == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append(MsfSdkUtils.getProcessName(BaseApplication.getContext()));
      paramString1.append(" ");
      paramString1.append(Thread.currentThread().getName());
      paramString1.append(" onRegisterApp appProcessName is null");
      QLog.w("MSF.S.AppProcessManager", 1, paramString1.toString());
      return;
    }
    String str = BaseApplication.getContext().getPackageName();
    int i = 0;
    try
    {
      boolean bool = paramString1.equals(str);
      i = bool;
    }
    catch (Exception localException)
    {
      QLog.w("MSF.S.AppProcessManager", 1, "except at string compare ", localException);
    }
    if (!c.containsKey(paramString1))
    {
      c.putIfAbsent(paramString1, new c());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("add processName: ");
        localStringBuilder1.append(paramString1);
        QLog.d("MSF.S.AppProcessManager", 2, localStringBuilder1.toString());
      }
      if (i != 0)
      {
        ((c)c.get(paramString1)).j = f;
        ((c)c.get(paramString1)).e = true;
      }
    }
    ((c)c.get(paramString1)).a(paramString1, paramString2, paramIMsfServiceCallbacker);
    paramString2 = MsfStore.getNativeConfigStore();
    paramIMsfServiceCallbacker = new StringBuilder();
    paramIMsfServiceCallbacker.append("app_process_info_");
    paramIMsfServiceCallbacker.append(paramString1);
    paramString2.setConfig(paramIMsfServiceCallbacker.toString(), ((c)c.get(paramString1)).a());
    if ((paramInt != 0) && (i != 0) && ((MsfCore.mobileQQAppid == -1) || (MsfCore.mobileQQAppid != paramInt)))
    {
      MsfCore.mobileQQAppid = paramInt;
      MsfStore.getNativeConfigStore().setConfig("key_mobileQQAppid", String.valueOf(paramInt));
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("set mobileQQAppid :");
        paramString2.append(paramInt);
        QLog.d("MSF.S.AppProcessManager", 2, paramString2.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("add process :");
      paramString2.append(paramString1);
      QLog.d("MSF.S.AppProcessManager", 2, paramString2.toString());
    }
    d.a();
    f.a().c();
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
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.AppProcessManager", 2, "getSystemStatus exception", paramHashMap);
      }
    }
  }
  
  public static boolean a()
  {
    return f.a();
  }
  
  public static void b(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      Object localObject = (c)c.get(paramString);
      if (localObject != null)
      {
        int i = ((Integer)paramToServiceMsg.getAttribute("status")).intValue();
        paramFromServiceMsg.addAttribute("status", Integer.valueOf(i));
        paramFromServiceMsg.setMsgSuccess();
        if (i == 1)
        {
          a(paramString, paramToServiceMsg, paramFromServiceMsg);
          ((c)localObject).c = true;
          ((c)localObject).b = SystemClock.elapsedRealtime();
        }
        else if (i == 2)
        {
          ((c)localObject).c = false;
        }
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("setAppConnStatus ");
        paramToServiceMsg.append(paramString);
        paramToServiceMsg.append(" ");
        paramToServiceMsg.append(i);
        QLog.e("MSF.S.AppProcessManager", 1, paramToServiceMsg.toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("can not find ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" to receive msg to:");
      ((StringBuilder)localObject).append(paramToServiceMsg);
      ((StringBuilder)localObject).append(" from:");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      QLog.e("MSF.S.AppProcessManager", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("find null processName msg to app ");
      paramString.append(paramToServiceMsg);
      paramString.append(" ");
      paramString.append(paramFromServiceMsg);
      QLog.e("MSF.S.AppProcessManager", 2, paramString.toString());
    }
  }
  
  public static boolean b(String paramString)
  {
    Object localObject = (c)c.get(paramString);
    if ((localObject != null) && (((c)localObject).c() != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("process ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" also registed,can not unregister by proxy.");
      QLog.w("MSF.S.AppProcessManager", 1, ((StringBuilder)localObject).toString());
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
        return;
      }
      QLog.e("MSF.S.AppProcessManager", 1, String.format("keepProcessAlive can not find process to receive msg, processName=%s", new Object[] { paramString }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.e
 * JD-Core Version:    0.7.0.1
 */