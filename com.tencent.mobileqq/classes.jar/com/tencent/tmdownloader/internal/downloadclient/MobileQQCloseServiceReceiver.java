package com.tencent.tmdownloader.internal.downloadclient;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.text.format.Time;
import android.util.Log;
import com.tencent.hlyyb.HalleyAgent;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmassistantbase.util.o;
import com.tencent.tmassistantbase.util.t;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadSettingClient;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import java.util.ArrayList;
import java.util.List;

public class MobileQQCloseServiceReceiver
  extends BroadcastReceiver
{
  protected static MobileQQCloseServiceReceiver b = null;
  public boolean a = false;
  private long c = 0L;
  
  public static MobileQQCloseServiceReceiver a()
  {
    try
    {
      if (b == null) {
        b = new MobileQQCloseServiceReceiver();
      }
      MobileQQCloseServiceReceiver localMobileQQCloseServiceReceiver = b;
      return localMobileQQCloseServiceReceiver;
    }
    finally {}
  }
  
  private String a(ArrayList<String> paramArrayList, String paramString, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label157;
      }
    }
    label157:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = "";
      try
      {
        paramString = o.a(localStringBuilder.toString());
        paramArrayList = paramString;
        paramString = o.a(paramString + localStringBuilder.toString());
        return paramString;
      }
      catch (Throwable paramString) {}
      localStringBuilder.append(localTime.minute);
      break;
    }
    return paramArrayList;
  }
  
  private void e(Context paramContext)
  {
    boolean bool1;
    try
    {
      ac.c("MQQCloseServiceReceiver", "exitProcess thread id:" + Thread.currentThread().getId());
      if (System.currentTimeMillis() - this.c < 1000L) {
        Log.i("MQQCloseServiceReceiver", "exitProcess is running!!");
      }
      for (;;)
      {
        return;
        this.c = System.currentTimeMillis();
        bool1 = t.b();
        if (!bool1) {
          try
          {
            bool1 = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKSettingClient().isAllDownloadFinished();
            ac.c("MQQCloseServiceReceiver", "receive broadcast isAllDownloadFinished = " + bool1);
            if (!bool1) {
              continue;
            }
            ac.c("MQQCloseServiceReceiver", "TMAssistantDownloadManager.closeAllService ing");
            TMAssistantDownloadManager.closeAllService(paramContext);
          }
          catch (Exception paramContext)
          {
            ac.e("MQQCloseServiceReceiver", "do exit error :" + paramContext.getMessage());
          }
        } else {
          try
          {
            bool2 = ApkDownloadManager.getInstance().isAllDownloadFinished().booleanValue();
            Log.i("MQQCloseServiceReceiver", "receive broadcast isAllDownloadFinished = " + bool2);
            if ((HalleyAgent.getDownloader().getRunningTasks() != null) && (HalleyAgent.getDownloader().getRunningTasks().size() > 0))
            {
              bool1 = true;
              Log.i("MQQCloseServiceReceiver", "receive broadcast isHalleyDownloadRunning = " + bool1);
              if ((!bool2) || (bool1)) {
                continue;
              }
              Log.i("MQQCloseServiceReceiver", "killSDKServiceProcess ing");
              d(paramContext);
            }
          }
          catch (Exception paramContext)
          {
            Log.e("MQQCloseServiceReceiver", paramContext.getMessage());
          }
        }
      }
    }
    finally {}
    for (;;)
    {
      boolean bool2;
      break;
      bool1 = false;
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.process.exit");
      localIntentFilter.addAction("com.tencent.process.tmdownloader.exit");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
      localIntentFilter.addAction("mqq.intent.action.EXIT_" + paramContext.getApplicationContext().getPackageName());
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
      localIntentFilter.addAction("mqq.intent.action.LOGOUT");
      paramContext.registerReceiver(this, localIntentFilter);
      this.a = true;
    }
  }
  
  public void b(Context paramContext)
  {
    if ((paramContext == null) || (b == null)) {}
    while (!this.a) {
      return;
    }
    try
    {
      paramContext.unregisterReceiver(this);
      label23:
      this.a = false;
      return;
    }
    catch (Throwable paramContext)
    {
      break label23;
    }
  }
  
  public String c(Context paramContext)
  {
    Object localObject = new ComponentName(paramContext, "com.tencent.tmdownloader.TMAssistantDownloadService");
    try
    {
      localObject = paramContext.getPackageManager().getServiceInfo((ComponentName)localObject, 0);
      paramContext = "com.tencent.tmassistantsdk.Service";
      if (localObject != null) {
        paramContext = ((ServiceInfo)localObject).processName;
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public int d(Context paramContext)
  {
    int j = 0;
    String str = c(paramContext);
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localList != null) {
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= localList.size()) {
          break;
        }
        Object localObject = (ActivityManager.RunningAppProcessInfo)localList.get(j);
        int m = ((ActivityManager.RunningAppProcessInfo)localObject).pid;
        localObject = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
        k = i;
        if (str.equals(localObject))
        {
          Log.i("MQQCloseServiceReceiver", "MobileQQCloseServiceReceiver killProcessByName;process name: " + (String)localObject + " pid: " + m);
          Log.i("MQQCloseServiceReceiver", "MobileQQCloseServiceReceiver killProcessByName;killProcess pid-->" + m);
          localObject = paramContext.getApplicationContext();
          l.a().postDelayed(new b(this, (Context)localObject), 3000L);
          k = i + 1;
        }
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ac.c("MQQCloseServiceReceiver", "receive broadcast close all service");
    l.a().post(new a(this, paramContext, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver
 * JD-Core Version:    0.7.0.1
 */