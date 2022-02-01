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
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.u;
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
    boolean bool2 = true;
    boolean bool1;
    if (invalidUids.contains(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.MsfService", 2, "MSF_Alive_Log found invalid uid call " + paramInt);
      }
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (passedUids.contains(Integer.valueOf(paramInt)));
    String[] arrayOfString = paramContext.getPackageManager().getPackagesForUid(paramInt);
    paramContext = paramContext.getPackageName();
    int j = arrayOfString.length;
    int i = 0;
    label92:
    if (i < j) {
      if (arrayOfString[i].equals(paramContext))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.MsfService", 2, "MSF_Alive_Log found accountSyncRequest from the same packeName application,");
        }
        passedUids.add(Integer.valueOf(paramInt));
      }
    }
    for (i = 0;; i = 1)
    {
      bool1 = bool2;
      if (i == 0) {
        break;
      }
      invalidUids.add(Integer.valueOf(paramInt));
      paramContext = "";
      Object localObject = paramContext;
      if (arrayOfString != null)
      {
        i = arrayOfString.length;
        paramInt = 0;
        for (;;)
        {
          localObject = paramContext;
          if (paramInt >= i) {
            break;
          }
          localObject = arrayOfString[paramInt];
          paramContext = paramContext + " " + (String)localObject + ";";
          paramInt += 1;
        }
        i += 1;
        break label92;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.MsfService", 2, "MSF_Alive_Log found invalid uid call " + (String)localObject);
      }
      try
      {
        paramContext = new HashMap();
        paramContext.put("param_Reason", localObject);
        paramContext.put("method", paramString);
        if (core.getStatReporter() != null) {
          core.getStatReporter().a("dim.Msf.invaildAppCall", true, 0L, 0L, paramContext, false, false);
        }
        return false;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.S.MsfService", 2, "send invaild call error " + paramContext, paramContext);
          }
        }
      }
    }
  }
  
  public static void serviceInit(Context paramContext, boolean paramBoolean)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1;
    try
    {
      QLog.d("MSF.S.MsfService", 1, "MSF_Alive_Log serviceInit inited=" + inited + " boot=" + paramBoolean + " gray=" + false + " public=" + true);
      long l1;
      if (!inited)
      {
        serviceInitStart = SystemClock.elapsedRealtime();
        core.init(paramContext, paramBoolean);
        l1 = SystemClock.elapsedRealtime();
        QLog.d("MsfInitCost", 1, "MSF_Alive_Log MsfCoreInitCost: " + (l1 - serviceInitStart));
        e.a(paramContext, core);
        msfServiceRespHandler = new t(core);
        msfServiceRespHandler.setName("MsfServiceRespHandler");
        msfServiceRespHandler.start();
        inited = true;
        long l2 = SystemClock.elapsedRealtime() - serviceInitStart;
        QLog.d("MsfInitCost", 1, "MSF_Alive_Log ServiceInitCost: " + l2);
        new p(l1, l2).start();
        bool1 = bool3;
      }
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
        bool2 = paramBoolean;
        bool1 = paramBoolean;
        if (QLog.isColorLevel())
        {
          bool1 = paramBoolean;
          QLog.d("MSF.S.MsfService", 2, "needReportStartWay=" + paramBoolean + " " + l1);
          bool2 = paramBoolean;
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          bool2 = bool1;
        }
      }
      if (bool2) {
        new q().start();
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
    if (paramToServiceMsg == null) {
      if (QLog.isColorLevel()) {
        QLog.w("MSF.S.MsfService", 2, "handleAccountSyncRequest toServiceMsg null!");
      }
    }
    do
    {
      do
      {
        return;
      } while (!paramToServiceMsg.getServiceCmd().equals("cmd_sync_syncuser"));
      try
      {
        core.handleAccountSyncRequest(paramContext, paramToServiceMsg, paramInt);
        return;
      }
      catch (Exception paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("MSF.S.MsfService", 2, "handleAccountSyncRequestReport error " + paramContext, paramContext);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    label68:
    for (;;)
    {
      try
      {
        String str = paramIntent.getStringExtra("to_SenderProcessName");
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          fromProcessName = str;
          QLog.d("MSF.S.MsfService", 1, "MSF_Alive_Log serivce onBind by :" + str);
          if (a.am()) {
            a.a(false);
          }
          k.a(paramIntent, 1);
          l.a(this.mUIHandler);
          return this.binder;
        }
        catch (Exception localException2)
        {
          break label68;
        }
        localException1 = localException1;
        str = null;
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    QLog.d("MSF.S.MsfService", 1, "MSF_Alive_Log serivce onCreate");
    serviceInit(this, sIsCreatedByAutoBoot);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.S.MsfService", 2, "MSF_Alive_Log serivce onCreate... autoBoot[" + sIsCreatedByAutoBoot + "]");
    }
    sIsCreatedByAutoBoot = false;
    startForegroundCompat();
    this.mUIHandler.postDelayed(new o(this), 10000L);
  }
  
  public void onDestroy()
  {
    QLog.d("MSF.S.MsfService", 1, "MSF_Alive_Log serivce onDestroy");
    try
    {
      BaseApplication.getContext().unregisterReceiver(core.getNetFlowStore());
    }
    catch (Exception localException2)
    {
      try
      {
        BaseApplication.getContext().unregisterReceiver(core.getStandyModeManager());
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            u.a(u.P);
            stopForegroundCompat();
            super.onDestroy();
            return;
            localException1 = localException1;
            QLog.d("MSF.S.MsfService", 1, "unregisterReceiver failed. " + localException1, localException1);
            continue;
            localException2 = localException2;
            QLog.d("MSF.S.MsfService", 1, "unregisterReceiver failed. " + localException2, localException2);
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            QLog.d("MSF.S.MsfService", 1, "unregisterReceiver failed. " + localException3, localException3);
          }
        }
      }
    }
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
    QLog.d("MSF.S.MsfService", 1, "MSF_Alive_Log serivce onUnbind by :" + str);
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.MsfService
 * JD-Core Version:    0.7.0.1
 */