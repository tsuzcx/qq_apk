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
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.k;
import com.tencent.tmassistantbase.util.n;
import com.tencent.tmassistantbase.util.s;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadSettingClient;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import java.util.ArrayList;
import java.util.List;

public class MobileQQCloseServiceReceiver
  extends BroadcastReceiver
{
  protected static MobileQQCloseServiceReceiver b;
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
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(((Time)localObject).year);
    localStringBuilder.append(((Time)localObject).month + 1);
    localStringBuilder.append(((Time)localObject).monthDay);
    localStringBuilder.append(((Time)localObject).hour);
    if (paramBoolean) {
      localStringBuilder.append(((Time)localObject).minute - 1);
    } else {
      localStringBuilder.append(((Time)localObject).minute);
    }
    if (paramArrayList == null) {
      paramArrayList = "null";
    } else {
      paramArrayList = paramArrayList.toString();
    }
    localStringBuilder.append(paramArrayList);
    paramArrayList = "";
    try
    {
      paramString = n.a(localStringBuilder.toString());
      paramArrayList = paramString;
      localObject = new StringBuilder();
      paramArrayList = paramString;
      ((StringBuilder)localObject).append(paramString);
      paramArrayList = paramString;
      ((StringBuilder)localObject).append(localStringBuilder.toString());
      paramArrayList = paramString;
      paramString = n.a(((StringBuilder)localObject).toString());
      return paramString;
    }
    catch (Throwable paramString) {}
    return paramArrayList;
  }
  
  private void e(Context paramContext)
  {
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exitProcess thread id:");
        localStringBuilder.append(Thread.currentThread().getId());
        ab.c("MQQCloseServiceReceiver", localStringBuilder.toString());
        if (System.currentTimeMillis() - this.c < 1000L)
        {
          Log.i("MQQCloseServiceReceiver", "exitProcess is running!!");
          return;
        }
        this.c = System.currentTimeMillis();
        bool1 = s.b();
        if (!bool1) {
          try
          {
            bool1 = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKSettingClient().isAllDownloadFinished();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("receive broadcast isAllDownloadFinished = ");
            localStringBuilder.append(bool1);
            ab.c("MQQCloseServiceReceiver", localStringBuilder.toString());
            if (!bool1) {
              continue;
            }
            ab.c("MQQCloseServiceReceiver", "TMAssistantDownloadManager.closeAllService ing");
            TMAssistantDownloadManager.closeAllService(paramContext);
          }
          catch (Exception paramContext)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("do exit error :");
            localStringBuilder.append(paramContext.getMessage());
            ab.e("MQQCloseServiceReceiver", localStringBuilder.toString());
          }
        } else {
          try
          {
            boolean bool2 = ApkDownloadManager.getInstance().isAllDownloadFinished().booleanValue();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("receive broadcast isAllDownloadFinished = ");
            localStringBuilder.append(bool2);
            Log.i("MQQCloseServiceReceiver", localStringBuilder.toString());
            if ((HalleyAgent.getDownloader().getRunningTasks() == null) || (HalleyAgent.getDownloader().getRunningTasks().size() <= 0)) {
              break label342;
            }
            bool1 = true;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("receive broadcast isHalleyDownloadRunning = ");
            localStringBuilder.append(bool1);
            Log.i("MQQCloseServiceReceiver", localStringBuilder.toString());
            if ((bool2) && (!bool1))
            {
              Log.i("MQQCloseServiceReceiver", "killSDKServiceProcess ing");
              d(paramContext);
            }
          }
          catch (Exception paramContext)
          {
            Log.e("MQQCloseServiceReceiver", paramContext.getMessage());
          }
        }
        return;
      }
      finally {}
      label342:
      boolean bool1 = false;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mqq.intent.action.EXIT_");
      localStringBuilder.append(paramContext.getApplicationContext().getPackageName());
      localIntentFilter.addAction(localStringBuilder.toString());
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
      localIntentFilter.addAction("mqq.intent.action.LOGOUT");
      paramContext.registerReceiver(this, localIntentFilter);
      this.a = true;
    }
  }
  
  public void b(Context paramContext)
  {
    if (paramContext != null)
    {
      if (b == null) {
        return;
      }
      if (!this.a) {}
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
    String str = c(paramContext);
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    int i = 0;
    int j = 0;
    if (localList != null)
    {
      int k;
      for (i = 0; j < localList.size(); i = k)
      {
        Object localObject = (ActivityManager.RunningAppProcessInfo)localList.get(j);
        int m = ((ActivityManager.RunningAppProcessInfo)localObject).pid;
        localObject = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
        k = i;
        if (str.equals(localObject))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("MobileQQCloseServiceReceiver killProcessByName;process name: ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" pid: ");
          localStringBuilder.append(m);
          Log.i("MQQCloseServiceReceiver", localStringBuilder.toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("MobileQQCloseServiceReceiver killProcessByName;killProcess pid-->");
          ((StringBuilder)localObject).append(m);
          Log.i("MQQCloseServiceReceiver", ((StringBuilder)localObject).toString());
          localObject = paramContext.getApplicationContext();
          k.a().postDelayed(new b(this, (Context)localObject), 3000L);
          k = i + 1;
        }
        j += 1;
      }
    }
    return i;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ab.c("MQQCloseServiceReceiver", "receive broadcast close all service");
    k.a().post(new a(this, paramContext, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver
 * JD-Core Version:    0.7.0.1
 */