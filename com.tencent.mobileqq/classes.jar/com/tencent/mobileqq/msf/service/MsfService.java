package com.tencent.mobileqq.msf.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.core.stepcount.i;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.remote.IBaseService.Stub;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MsfService
  extends Service
{
  public static final int MSF_ALIVE_UPLOAD_MESSAGE = 10500;
  public static MsfCore core = new MsfCore();
  private static String fromProcessName = "null";
  public static volatile boolean inited = false;
  static HashSet invalidUids;
  static r msfServiceReqHandler = new r();
  static t msfServiceRespHandler;
  static HashSet passedUids = new HashSet();
  public static volatile boolean sIsCreatedByAutoBoot = false;
  public static long serviceInitStart = 0L;
  public static final String tag = "MSF.S.MsfService";
  private IBaseService.Stub binder = new n(this);
  private NetConnInfoCenter mReceiver;
  public Handler mUIHandler = new m(this, Looper.getMainLooper());
  
  static
  {
    invalidUids = new HashSet();
    sIsCreatedByAutoBoot = false;
    serviceInitStart = 0L;
  }
  
  public static MsfCore getCore()
  {
    return core;
  }
  
  public static boolean isSamePackage(Context paramContext, int paramInt, String paramString)
  {
    if (invalidUids.contains(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("MSF_Alive_Log found invalid uid call ");
        paramContext.append(paramInt);
        QLog.d("MSF.S.MsfService", 2, paramContext.toString());
      }
      return false;
    }
    if (!passedUids.contains(Integer.valueOf(paramInt)))
    {
      Object localObject = paramContext.getPackageManager().getPackagesForUid(paramInt);
      paramContext = paramContext.getPackageName();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (localObject[i].equals(paramContext))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.S.MsfService", 2, "MSF_Alive_Log found accountSyncRequest from the same packeName application,");
          }
          passedUids.add(Integer.valueOf(paramInt));
          i = 0;
          break label143;
        }
        i += 1;
      }
      i = 1;
      label143:
      if (i != 0)
      {
        invalidUids.add(Integer.valueOf(paramInt));
        paramContext = "";
        if (localObject != null)
        {
          i = localObject.length;
          paramContext = "";
          paramInt = 0;
          while (paramInt < i)
          {
            String str = localObject[paramInt];
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramContext);
            localStringBuilder.append(" ");
            localStringBuilder.append(str);
            localStringBuilder.append(";");
            paramContext = localStringBuilder.toString();
            paramInt += 1;
          }
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("MSF_Alive_Log found invalid uid call ");
          ((StringBuilder)localObject).append(paramContext);
          QLog.d("MSF.S.MsfService", 2, ((StringBuilder)localObject).toString());
        }
        try
        {
          localObject = new HashMap();
          ((Map)localObject).put("param_Reason", paramContext);
          ((Map)localObject).put("method", paramString);
          if (core.getStatReporter() != null)
          {
            core.getStatReporter().a("dim.Msf.invaildAppCall", true, 0L, 0L, (Map)localObject, false, false);
            return false;
          }
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("send invaild call error ");
            paramString.append(paramContext);
            QLog.d("MSF.S.MsfService", 2, paramString.toString(), paramContext);
          }
        }
        return false;
      }
    }
    return true;
  }
  
  public static void serviceInit(Context paramContext, boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MSF_Alive_Log serviceInit inited=");
      localStringBuilder.append(inited);
      localStringBuilder.append(" boot=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" gray=");
      boolean bool3 = false;
      boolean bool2 = false;
      localStringBuilder.append(false);
      localStringBuilder.append(" public=");
      localStringBuilder.append(true);
      QLog.d("MSF.S.MsfService", 1, localStringBuilder.toString());
      if (!inited)
      {
        serviceInitStart = SystemClock.elapsedRealtime();
        core.init(paramContext, paramBoolean);
        long l1 = SystemClock.elapsedRealtime();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("MSF_Alive_Log MsfCoreInitCost: ");
        localStringBuilder.append(l1 - serviceInitStart);
        QLog.d("MsfInitCost", 1, localStringBuilder.toString());
        e.a(paramContext, core);
        msfServiceRespHandler = new t(core);
        msfServiceRespHandler.setName("MsfServiceRespHandler");
        msfServiceRespHandler.start();
        inited = true;
        long l2 = SystemClock.elapsedRealtime() - serviceInitStart;
        paramContext = new StringBuilder();
        paramContext.append("MSF_Alive_Log ServiceInitCost: ");
        paramContext.append(l2);
        QLog.d("MsfInitCost", 1, paramContext.toString());
        new p(l1, l2).start();
        boolean bool1 = bool3;
        try
        {
          l1 = Long.parseLong(getCore().getAccountCenter().i());
          paramBoolean = bool2;
          if (l1 > 0L)
          {
            paramBoolean = bool2;
            bool1 = bool3;
            if (Long.valueOf(l1).longValue() / 1000L % 1000L < 5L) {
              paramBoolean = true;
            }
          }
          bool1 = paramBoolean;
          bool2 = paramBoolean;
          if (QLog.isColorLevel())
          {
            bool1 = paramBoolean;
            paramContext = new StringBuilder();
            bool1 = paramBoolean;
            paramContext.append("needReportStartWay=");
            bool1 = paramBoolean;
            paramContext.append(paramBoolean);
            bool1 = paramBoolean;
            paramContext.append(" ");
            bool1 = paramBoolean;
            paramContext.append(l1);
            bool1 = paramBoolean;
            QLog.d("MSF.S.MsfService", 2, paramContext.toString());
            bool2 = paramBoolean;
          }
        }
        catch (Throwable paramContext)
        {
          paramContext.printStackTrace();
          bool2 = bool1;
        }
        if (bool2) {
          new q().start();
        }
      }
      return;
    }
    finally {}
  }
  
  private void startForegroundCompat()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 18) {
        startForeground(9527, new Notification());
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void stopForegroundCompat()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 18) {
        stopForeground(true);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  protected void handleAccountSyncRequest(Context paramContext, ToServiceMsg paramToServiceMsg, int paramInt)
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MSF.S.MsfService", 2, "handleAccountSyncRequest toServiceMsg null!");
      }
      return;
    }
    if (paramToServiceMsg.getServiceCmd().equals("cmd_sync_syncuser")) {
      try
      {
        core.handleAccountSyncRequest(paramContext, paramToServiceMsg, paramInt);
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleAccountSyncRequestReport error ");
          paramToServiceMsg.append(paramContext);
          QLog.d("MSF.S.MsfService", 2, paramToServiceMsg.toString(), paramContext);
        }
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    Object localObject = null;
    try
    {
      String str = paramIntent.getStringExtra("to_SenderProcessName");
      localObject = str;
      fromProcessName = str;
      localObject = str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MSF_Alive_Log serivce onBind by :");
    localStringBuilder.append(localObject);
    QLog.d("MSF.S.MsfService", 1, localStringBuilder.toString());
    if (a.am()) {
      a.a(false);
    }
    k.a(paramIntent, 1);
    l.a(this.mUIHandler);
    return this.binder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    QLog.d("MSF.S.MsfService", 1, "MSF_Alive_Log serivce onCreate");
    serviceInit(this, sIsCreatedByAutoBoot);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MSF_Alive_Log serivce onCreate... autoBoot[");
      localStringBuilder.append(sIsCreatedByAutoBoot);
      localStringBuilder.append("]");
      QLog.d("MSF.S.MsfService", 2, localStringBuilder.toString());
    }
    sIsCreatedByAutoBoot = false;
    startForegroundCompat();
    this.mUIHandler.postDelayed(new o(this), 10000L);
  }
  
  public void onDestroy()
  {
    QLog.d("MSF.S.MsfService", 1, "MSF_Alive_Log serivce onDestroy");
    StringBuilder localStringBuilder;
    try
    {
      BaseApplication.getContext().unregisterReceiver(core.getNetFlowStore());
    }
    catch (Exception localException1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("unregisterReceiver failed. ");
      localStringBuilder.append(localException1);
      QLog.d("MSF.S.MsfService", 1, localStringBuilder.toString(), localException1);
    }
    try
    {
      BaseApplication.getContext().unregisterReceiver(core.getStandyModeManager());
    }
    catch (Exception localException2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("unregisterReceiver failed. ");
      localStringBuilder.append(localException2);
      QLog.d("MSF.S.MsfService", 1, localStringBuilder.toString(), localException2);
    }
    try
    {
      i.b().a();
    }
    catch (Exception localException3)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("unregisterReceiver failed. ");
      localStringBuilder.append(localException3);
      QLog.d("MSF.S.MsfService", 1, localStringBuilder.toString(), localException3);
    }
    stopForegroundCompat();
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    QLog.d("MSF.S.MsfService", 1, "MSF_Alive_Log serivce onStart");
    k.a(paramIntent, 2);
    l.a(this.mUIHandler);
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    return 1;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("to_SenderProcessName");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MSF_Alive_Log serivce onUnbind by :");
    localStringBuilder.append(str);
    QLog.d("MSF.S.MsfService", 1, localStringBuilder.toString());
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.MsfService
 * JD-Core Version:    0.7.0.1
 */