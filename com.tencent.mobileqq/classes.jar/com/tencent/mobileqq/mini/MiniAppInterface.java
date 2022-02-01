package com.tencent.mobileqq.mini;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.network.RequestStrategy;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.startup.step.InitMemoryCache;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MiniAppInterface
  extends AppInterface
{
  public static final String ACTION_MINI_PROCESS_EXIT = "com.tencent.mobile.mini.process.exit";
  private static final String ACTION_PROCESS_EXIT = "com.tencent.process.exit";
  static final String TAG = "MiniAppInterface";
  private BroadcastReceiver accountReceiver = new MiniAppInterface.2(this);
  private HashMap<String, AuthorizeCenter> authorizeMap = new HashMap();
  private EntityManagerFactory mFactory;
  private List<Activity> mForegroundActivitys = new ArrayList();
  
  public MiniAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
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
    localIntentFilter.addAction("com.tencent.mobile.mini.process.exit");
    this.app.registerReceiver(this.accountReceiver, localIntentFilter);
  }
  
  public void exitApp(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    try
    {
      System.exit(0);
      Process.killProcess(Process.myPid());
      return;
    }
    catch (Throwable localThrowable)
    {
      System.exit(-1);
    }
  }
  
  public void exitProcess()
  {
    try
    {
      this.app.unregisterReceiver(this.accountReceiver);
      QLog.d("MiniAppInterface", 1, "Kill process " + this.app.getPackageName());
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
        AuthorizeCenter localAuthorizeCenter = new AuthorizeCenter(paramString, getCurrentAccountUin());
        this.authorizeMap.put(paramString, localAuthorizeCenter);
      }
      return (AuthorizeCenter)this.authorizeMap.get(paramString);
    }
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
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
    AppLoaderFactory.setMiniAppInterface(this);
    registerAccountReceiver();
    if (Build.VERSION.SDK_INT >= 15) {
      getApp().registerActivityLifecycleCallbacks(new MiniAppInterface.1(this));
    }
    RequestStrategy.g.notifyNetWorkStatusChange();
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInterface", 2, "Application OnCreate complete");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    MiniAppController.getInstance().onDestory();
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInterface", 2, "onDestroy");
    }
    synchronized (this.authorizeMap)
    {
      this.authorizeMap.clear();
      return;
    }
  }
  
  protected void onEnterBackground()
  {
    QLog.e("miniapp-start", 1, "onEnterBackground ");
  }
  
  protected void onEnterForeground()
  {
    QLog.e("miniapp-start", 1, "onEnterForeground ");
  }
  
  public void onRunningBackground()
  {
    super.onRunningBackground();
    LpReportManager.getInstance().startReportImediately(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.MiniAppInterface
 * JD-Core Version:    0.7.0.1
 */