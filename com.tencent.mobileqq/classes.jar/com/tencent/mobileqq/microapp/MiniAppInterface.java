package com.tencent.mobileqq.microapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.microapp.appbrand.b.h;
import com.tencent.mobileqq.microapp.out.plugins.OtherJsPlugin;
import com.tencent.mobileqq.microapp.sdk.MiniAppController;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.startup.step.InitMemoryCache;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MiniAppInterface
  extends AppInterface
{
  private static final String ACTION_PROCESS_EXIT = "com.tencent.process.exit";
  static final String TAG = "MiniAppInterface";
  private BroadcastReceiver accountReceiver = new b(this);
  private HashMap authorizeMap = new HashMap();
  private EntityManagerFactory mFactory;
  
  public MiniAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  private void registerAccountReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqq.intent.action.EXIT_");
    localStringBuilder.append(this.app.getPackageName());
    localIntentFilter.addAction(localStringBuilder.toString());
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("com.tencent.process.exit");
    this.app.registerReceiver(this.accountReceiver, localIntentFilter);
  }
  
  public void exitProcess()
  {
    try
    {
      this.app.unregisterReceiver(this.accountReceiver);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    ThreadManagerV2.excute(new a(this), 16, null, true);
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public com.tencent.mobileqq.microapp.app.a getAuthorizeCenter(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!this.authorizeMap.containsKey(paramString)) {
      synchronized (this.authorizeMap)
      {
        if (!this.authorizeMap.containsKey(paramString))
        {
          Object localObject = this.app;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("_");
          localStringBuilder.append(getCurrentAccountUin());
          localObject = new com.tencent.mobileqq.microapp.app.a((Context)localObject, localStringBuilder.toString());
          this.authorizeMap.put(paramString, localObject);
        }
      }
    }
    return (com.tencent.mobileqq.microapp.app.a)this.authorizeMap.get(paramString);
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
    return "miniapp";
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    new InitMemoryCache().step();
    new InitUrlDrawable().step();
    paramBundle = new ArrayList();
    paramBundle.add(new OtherJsPlugin(this));
    MiniAppController.getInstance().registeJsPlugin(paramBundle);
    registerAccountReceiver();
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInterface", 2, "Application OnCreate complete");
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    MiniAppController.getInstance().onDestory();
    h.a().b();
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInterface", 2, "onDestroy");
    }
    synchronized (this.authorizeMap)
    {
      this.authorizeMap.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.MiniAppInterface
 * JD-Core Version:    0.7.0.1
 */