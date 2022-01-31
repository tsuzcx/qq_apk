package com.tencent.mobileqq.mini;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import aukq;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.MiniAppSubProcessorInfo;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.report.MiniGamePerformanceStatics;
import com.tencent.mobileqq.startup.step.InitMemoryCache;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class MiniAppInterface
  extends AppInterface
{
  private static final String ACTION_PROCESS_EXIT = "com.tencent.process.exit";
  static final String TAG = "MiniAppInterface";
  private BroadcastReceiver accountReceiver = new MiniAppInterface.2(this);
  private HashMap<String, AuthorizeCenter> authorizeMap = new HashMap();
  private aukq mFactory;
  private List<Activity> mForegroundActivitys = new ArrayList();
  
  public MiniAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  private boolean finishAndRemoveAllTasks()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    try
    {
      Object localObject1 = (ActivityManager)this.app.getBaseContext().getSystemService("activity");
      if (localObject1 == null) {
        return false;
      }
      Object localObject2 = ((ActivityManager)localObject1).getAppTasks();
      if (localObject2 == null) {
        return false;
      }
      localObject1 = getCurrentProcessorInfo();
      if (localObject1 == null)
      {
        QLog.e("miniapp", 1, "当前进程信息为空");
        return false;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ActivityManager.AppTask localAppTask = (ActivityManager.AppTask)((Iterator)localObject2).next();
        if ((localAppTask != null) && (localAppTask.getTaskInfo() != null) && (localAppTask.getTaskInfo().baseIntent != null) && (localAppTask.getTaskInfo().baseIntent.getComponent() != null))
        {
          QLog.e("miniapp", 1, "will finish and remove task: id=" + localAppTask.getTaskInfo().id);
          if ((localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().equals(((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject1).appBrandUIClass)) || (localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().equals(((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject1).gameUIClass))) {
            localAppTask.finishAndRemoveTask();
          }
        }
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp", 1, "finishAndRemoveAllTasks exception.");
    }
    return false;
  }
  
  private AppBrandLaunchManager.MiniAppSubProcessorInfo getCurrentProcessorInfo()
  {
    String str = BaseApplicationImpl.getApplication().getQQProcessName();
    if (str != null) {
      return (AppBrandLaunchManager.MiniAppSubProcessorInfo)AppBrandLaunchManager.subProcessorInfoMap.get(str);
    }
    return null;
  }
  
  private void registerAccountReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + this.app.getPackageName());
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("com.tencent.process.exit");
    this.app.registerReceiver(this.accountReceiver, localIntentFilter);
  }
  
  public void exitApp(boolean paramBoolean)
  {
    do
    {
      try
      {
        if (finishAndRemoveAllTasks())
        {
          continue;
          System.exit(0);
          Process.killProcess(Process.myPid());
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        System.exit(-1);
        return;
      }
    } while (paramBoolean);
  }
  
  public void exitProcess()
  {
    MiniAppStateManager.getInstance().notifyChange("hideInput");
    AppBrandProxy.g().onAppStop(BaseApplicationImpl.getApplication().getQQProcessName(), null, null);
    try
    {
      this.app.unregisterReceiver(this.accountReceiver);
      QLog.d("MiniAppInterface", 1, "Kill process " + this.app.getPackageName());
      finishAndRemoveAllTasks();
      Process.killProcess(Process.myPid());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public AuthorizeCenter getAuthorizeCenter(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!this.authorizeMap.containsKey(paramString)) {}
    synchronized (this.authorizeMap)
    {
      if (!this.authorizeMap.containsKey(paramString))
      {
        AuthorizeCenter localAuthorizeCenter = new AuthorizeCenter(this.app, paramString, getCurrentAccountUin());
        this.authorizeMap.put(paramString, localAuthorizeCenter);
      }
      return (AuthorizeCenter)this.authorizeMap.get(paramString);
    }
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public aukq getEntityManagerFactory(String paramString)
  {
    if (this.mFactory == null) {
      this.mFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.mFactory;
  }
  
  public String getModuleId()
  {
    return "mini";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.i("miniapp-start", 1, "MiniAppInterface onCreate");
    Thread.setDefaultUncaughtExceptionHandler(new MiniCrashHandler());
    new InitMemoryCache().step();
    new InitUrlDrawable().step();
    AppLoaderFactory.getAppLoaderManager().setMiniAppInterface(this);
    registerAccountReceiver();
    MiniGamePerformanceStatics.getInstance().recordInitialMemory();
    if (Build.VERSION.SDK_INT >= 15) {
      getApp().registerActivityLifecycleCallbacks(new MiniAppInterface.1(this));
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInterface", 2, "Application OnCreate complete");
    }
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 390	com/tencent/common/app/AppInterface:onDestroy	()V
    //   4: invokestatic 258	com/tencent/mobileqq/mini/launch/AppBrandProxy:g	()Lcom/tencent/mobileqq/mini/launch/AppBrandProxy;
    //   7: invokestatic 178	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   10: invokevirtual 181	com/tencent/common/app/BaseApplicationImpl:getQQProcessName	()Ljava/lang/String;
    //   13: aconst_null
    //   14: aconst_null
    //   15: invokevirtual 262	com/tencent/mobileqq/mini/launch/AppBrandProxy:onAppStop	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Landroid/os/Bundle;)V
    //   18: invokestatic 395	com/tencent/mobileqq/mini/sdk/MiniAppController:getInstance	()Lcom/tencent/mobileqq/mini/sdk/MiniAppController;
    //   21: invokevirtual 398	com/tencent/mobileqq/mini/sdk/MiniAppController:onDestory	()V
    //   24: invokestatic 403	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   27: invokevirtual 407	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   30: ifnull +15 -> 45
    //   33: invokestatic 403	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   36: invokevirtual 407	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   39: invokestatic 413	com/tencent/mobileqq/mini/app/MiniAppClientQIPCModule:getQIPCModule	()Lcom/tencent/mobileqq/mini/app/MiniAppClientQIPCModule;
    //   42: invokevirtual 419	eipc/EIPCClient:unRegisterModule	(Leipc/EIPCModule;)V
    //   45: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   48: ifeq +12 -> 60
    //   51: ldc 11
    //   53: iconst_2
    //   54: ldc_w 420
    //   57: invokestatic 271	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aload_0
    //   61: getfield 32	com/tencent/mobileqq/mini/MiniAppInterface:authorizeMap	Ljava/util/HashMap;
    //   64: astore_1
    //   65: aload_1
    //   66: monitorenter
    //   67: aload_0
    //   68: getfield 32	com/tencent/mobileqq/mini/MiniAppInterface:authorizeMap	Ljava/util/HashMap;
    //   71: invokevirtual 423	java/util/HashMap:clear	()V
    //   74: aload_1
    //   75: monitorexit
    //   76: return
    //   77: astore_1
    //   78: ldc 11
    //   80: iconst_1
    //   81: new 132	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 425
    //   91: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_1
    //   95: invokevirtual 428	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: goto -59 -> 45
    //   107: astore_2
    //   108: aload_1
    //   109: monitorexit
    //   110: aload_2
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	MiniAppInterface
    //   77	32	1	localException	Exception
    //   107	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   24	45	77	java/lang/Exception
    //   67	76	107	finally
    //   108	110	107	finally
  }
  
  protected void onEnterBackground()
  {
    QLog.e("miniapp-start", 1, "onEnterBackground ");
    AppBrandProxy.g().onAppBackground(BaseApplicationImpl.getApplication().getQQProcessName());
  }
  
  protected void onEnterForeground()
  {
    QLog.e("miniapp-start", 1, "onEnterForeground ");
    AppBrandProxy.g().onAppForeground(BaseApplicationImpl.getApplication().getQQProcessName());
  }
  
  public void onRunningBackground()
  {
    super.onRunningBackground();
    LpReportManager.getInstance().startReportImediately(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.MiniAppInterface
 * JD-Core Version:    0.7.0.1
 */