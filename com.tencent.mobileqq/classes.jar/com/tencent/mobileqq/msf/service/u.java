package com.tencent.mobileqq.msf.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mobileqq.msf.core.ad;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class u
{
  public static final String a = "MSF.S.Util";
  
  public static FromServiceMsg a(ToServiceMsg paramToServiceMsg)
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    localFromServiceMsg.setAppId(paramToServiceMsg.getAppId());
    localFromServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
    localFromServiceMsg.setRequestSsoSeq(paramToServiceMsg.getRequestSsoSeq());
    localFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
    MsfSdkUtils.addFromMsgProcessName(b(paramToServiceMsg), localFromServiceMsg);
    return localFromServiceMsg;
  }
  
  public static String a()
  {
    Random localRandom = new Random(System.currentTimeMillis());
    String str = "---------";
    int i = 0;
    while (i < 12)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(String.valueOf(localRandom.nextInt(10)));
      str = localStringBuilder.toString();
      i += 1;
    }
    return str;
  }
  
  public static String a(FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getAttributes().get("to_SenderProcessName") != null)) {
      return (String)paramFromServiceMsg.getAttributes().get("to_SenderProcessName");
    }
    return "";
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d("MSF.S.Util", 1, String.format("sendBootAction processName=%s uin=%s bootAction=%s status=%s type=%s fromServiceMsg=%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramFromServiceMsg }));
    try
    {
      Intent localIntent = new Intent(paramString3);
      localIntent.putExtra("uin", paramString2);
      localIntent.putExtra("istatus", paramInt1);
      localIntent.putExtra("type", paramInt2);
      localIntent.putExtra("gatewayip", ad.q());
      localIntent.setPackage(paramContext.getPackageName());
      if (paramInt2 == 1) {
        localIntent.putExtra("processExitTimestamp", System.currentTimeMillis());
      }
      a("MSF:BootAction", 5000L);
      if (paramString3.toLowerCase().indexOf("activity", 0) != -1)
      {
        localIntent.setFlags(268435456);
        if ((paramFromServiceMsg != null) && (paramString1 != null) && (paramString1.endsWith(":video")))
        {
          if (paramFromServiceMsg.getAttribute("msf_timestamp") == null) {
            paramFromServiceMsg.addAttribute("msf_timestamp", Long.valueOf(System.currentTimeMillis()));
          }
          localIntent.putExtra("fromServiceMsg", paramFromServiceMsg);
        }
        paramContext.startActivity(localIntent);
      }
      localIntent.setFlags(32);
      paramContext.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("MSF.S.Util", 1, "sendBootAction fail.", paramContext);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, FromServiceMsg paramFromServiceMsg)
  {
    a(paramContext, paramString1, paramString2, paramString3, paramInt, 0, paramFromServiceMsg);
  }
  
  public static void a(String paramString, long paramLong)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(paramString, 1, String.format("requestPartialWakeLock tag=%s timeout=%s", new Object[] { paramString, Long.valueOf(paramLong) }));
      }
      PowerManager localPowerManager = (PowerManager)BaseApplication.getContext().getSystemService("power");
      if (localPowerManager != null)
      {
        localPowerManager.newWakeLock(1, paramString).acquire(paramLong);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d(paramString, 1, "requestPartialWakeLock fail.", localThrowable);
    }
  }
  
  public static String b(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes().get("to_SenderProcessName") != null)) {
      return (String)paramToServiceMsg.getAttributes().get("to_SenderProcessName");
    }
    return "";
  }
  
  public static boolean b()
  {
    try
    {
      List localList = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningAppProcesses();
      if (localList == null)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.S.Util", 2, "can not load appProcesses.");
          return false;
        }
      }
      else
      {
        localObject2 = MsfSdkUtils.getProcessName(BaseApplication.getContext());
        Object localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).indexOf(":") > 0) {
            localObject1 = ((String)localObject2).substring(0, ((String)localObject2).indexOf(":"));
          }
        }
        localObject2 = localList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          boolean bool = ((ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next()).processName.equals(localObject1);
          if (bool) {
            return true;
          }
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("check isMainProcessRunning error ");
      ((StringBuilder)localObject2).append(localException);
      QLog.d("MSF.S.Util", 1, ((StringBuilder)localObject2).toString());
    }
    return false;
  }
  
  public static String c()
  {
    c localc = e.a(BaseApplication.getContext().getPackageName());
    if (localc != null) {
      return localc.b();
    }
    return "com.tencent.mobileqq.broadcast.qq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.u
 * JD-Core Version:    0.7.0.1
 */