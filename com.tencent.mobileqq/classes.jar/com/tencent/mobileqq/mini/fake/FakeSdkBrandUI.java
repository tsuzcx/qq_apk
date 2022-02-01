package com.tencent.mobileqq.mini.fake;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.manager.MiniAppDetainManager;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appstore.cookie.CookieManagerImpl;
import com.tencent.open.appstore.cookie.CookieSyncManagerImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class FakeSdkBrandUI
  implements IFakeBrandUI
{
  private static final String COOKIE_DOMAIN = "qzone.qq.com";
  private static final String TAG = "minisdk-start_FakeSdkBrandUI";
  private static volatile boolean mHasOKHttpClientInit = false;
  public static volatile boolean mHasOnCreate = false;
  private Intent mIntent;
  private IUIProxy mUIProxy;
  
  public static String changeUin(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() < 10)
      {
        localObject = new StringBuilder("o");
        int i = paramString.length();
        while (i < 10)
        {
          ((StringBuilder)localObject).append("0");
          i += 1;
        }
        ((StringBuilder)localObject).append(paramString);
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("o");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private boolean finishAndRemoveTask(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      if (Build.VERSION.SDK_INT < 21) {
        return false;
      }
      try
      {
        Object localObject = (ActivityManager)paramActivity.getSystemService("activity");
        if (localObject == null) {
          return false;
        }
        localObject = ((ActivityManager)localObject).getAppTasks();
        if (localObject == null) {
          return false;
        }
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          localObject = (ActivityManager.AppTask)localIterator.next();
          if ((localObject != null) && (((ActivityManager.AppTask)localObject).getTaskInfo() != null) && (((ActivityManager.AppTask)localObject).getTaskInfo().baseIntent != null) && (((ActivityManager.AppTask)localObject).getTaskInfo().baseIntent.getComponent() != null))
          {
            String str = ((ActivityManager.AppTask)localObject).getTaskInfo().baseIntent.getComponent().getClassName();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("finishAndRemoveTask try finish and remove task: id=");
            localStringBuilder.append(((ActivityManager.AppTask)localObject).getTaskInfo().id);
            localStringBuilder.append(", componentName:");
            localStringBuilder.append(str);
            QLog.i("minisdk-start_FakeSdkBrandUI", 1, localStringBuilder.toString());
            if ((!TextUtils.isEmpty(str)) && (str.equals(paramActivity.getClass().getName())))
            {
              paramActivity = new StringBuilder();
              paramActivity.append("finishAndRemoveTask finish and remove task: id=");
              paramActivity.append(((ActivityManager.AppTask)localObject).getTaskInfo().id);
              QLog.i("minisdk-start_FakeSdkBrandUI", 1, paramActivity.toString());
              ((ActivityManager.AppTask)localObject).finishAndRemoveTask();
            }
          }
        }
        return true;
      }
      catch (Throwable paramActivity)
      {
        QLog.e("minisdk-start_FakeSdkBrandUI", 1, "finishAndRemoveTask exception.", paramActivity);
      }
    }
    return false;
  }
  
  public static void initOKHttpClient()
  {
    if (!mHasOKHttpClientInit)
    {
      mHasOKHttpClientInit = true;
      MiniOkHttpClientFactory.init(60000L, 60000L, 60000L);
    }
  }
  
  private void recoveryIntent(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    Object localObject = null;
    try
    {
      MiniAppInfo localMiniAppInfo1 = (MiniAppInfo)paramIntent.getParcelableExtra("KEY_APPINFO");
      if (localMiniAppInfo1 != null) {
        return;
      }
      try
      {
        localObject = (MiniAppConfig)paramIntent.getParcelableExtra("CONFIG");
        if (localObject != null)
        {
          MiniAppInfo localMiniAppInfo2 = MiniSdkLauncher.convert((MiniAppConfig)localObject);
          localObject = localMiniAppInfo2;
          paramIntent.putExtra("KEY_APPINFO", localMiniAppInfo2);
          localObject = localMiniAppInfo2;
          QLog.e("minisdk-start_FakeSdkBrandUI", 1, "recoveryIntent from MiniAppConfig succeed!");
          localObject = localMiniAppInfo2;
        }
        else
        {
          localObject = localMiniAppInfo1;
        }
      }
      catch (Throwable paramIntent)
      {
        localObject = localMiniAppInfo1;
      }
      QLog.e("minisdk-start_FakeSdkBrandUI", 1, "recoveryIntent exception!", paramIntent);
    }
    catch (Throwable paramIntent) {}
    int i;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_intent_valid_restart", 1) > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((localObject == null) && (i != 0))
    {
      QLog.e("minisdk-start_FakeSdkBrandUI", 1, "Intent Data is invalid! KillProcess now!");
      if (paramBaseActivity != null) {
        Toast.makeText(paramBaseActivity.getApplicationContext(), "请重新打开小程序", 1).show();
      }
      ThreadManager.getUIHandler().postDelayed(new FakeSdkBrandUI.2(this, paramBaseActivity), 2000L);
    }
  }
  
  public static void setCookie()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      CookieSyncManagerImpl localCookieSyncManagerImpl = new CookieSyncManagerImpl(CommonDataAdapter.a().b());
      localObject1 = new CookieManagerImpl();
      ((CookieManagerImpl)localObject1).a(true);
      l2 = CommonDataAdapter.a().c();
      Object localObject3 = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
      Object localObject2 = ((TicketManager)localObject3).getSkey(String.valueOf(l2));
      localObject3 = ((TicketManager)localObject3).getPskey(String.valueOf(l2), "qzone.qq.com");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=");
      localStringBuilder.append(changeUin(String.valueOf(l2)));
      localStringBuilder.append("; path=/; domain=.");
      localStringBuilder.append("qzone.qq.com");
      localStringBuilder.append(";");
      ((CookieManagerImpl)localObject1).a("qzone.qq.com/", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("p_uin=");
      localStringBuilder.append(changeUin(String.valueOf(l2)));
      localStringBuilder.append("; path=/; domain=.");
      localStringBuilder.append("qzone.qq.com");
      localStringBuilder.append(";");
      ((CookieManagerImpl)localObject1).a("qzone.qq.com/", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("skey=");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("; path=/; domain=.");
      localStringBuilder.append("qzone.qq.com");
      localStringBuilder.append(";");
      ((CookieManagerImpl)localObject1).a("qzone.qq.com/", localStringBuilder.toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("p_skey=");
      ((StringBuilder)localObject2).append((String)localObject3);
      ((StringBuilder)localObject2).append("; path=/; domain=.");
      ((StringBuilder)localObject2).append("qzone.qq.com");
      ((StringBuilder)localObject2).append(";");
      ((CookieManagerImpl)localObject1).a("qzone.qq.com/", ((StringBuilder)localObject2).toString());
      localCookieSyncManagerImpl.a();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    long l2 = System.currentTimeMillis();
    String str = AppBrandUI3.class.getSimpleName();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setCookie cost:");
    ((StringBuilder)localObject1).append(l2 - l1);
    QLog.e(str, 1, ((StringBuilder)localObject1).toString());
  }
  
  public boolean doBeforeOnCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doBeforeOnCreate");
    mHasOnCreate = true;
    MiniSDK.init(paramBaseActivity.getApplicationContext());
    ThreadManager.executeOnSubThread(new FakeSdkBrandUI.1(this));
    Object localObject = new RelativeLayout(paramBaseActivity);
    paramBaseActivity.setContentView((View)localObject);
    FrameLayout localFrameLayout = new FrameLayout(paramBaseActivity);
    ((RelativeLayout)localObject).addView(localFrameLayout, new RelativeLayout.LayoutParams(-1, -1));
    Intent localIntent = paramBaseActivity.getIntent();
    MiniAppInfo localMiniAppInfo;
    try
    {
      recoveryIntent(paramBaseActivity, localIntent);
      localObject = (MiniAppInfo)paramBaseActivity.getIntent().getParcelableExtra("KEY_APPINFO");
    }
    catch (Throwable localThrowable)
    {
      QLog.e("minisdk-start_FakeSdkBrandUI", 1, "", localThrowable);
      localMiniAppInfo = null;
    }
    this.mIntent = localIntent;
    this.mUIProxy = AppLoaderFactory.g().getMiniAppEnv().getUIProxy(localMiniAppInfo);
    if (this.mUIProxy != null)
    {
      QLog.i("minisdk-start_FakeSdkBrandUI", 1, "UIProxy completed");
      this.mUIProxy.onAttachActivity(paramBaseActivity, paramBundle, localFrameLayout);
    }
    MiniSDKClientQIPCModule.b();
    MiniAppDetainManager.INSTANCE.preloadAppDetainRecord(localMiniAppInfo);
    return true;
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return this.mUIProxy.doDispatchKeyEvent(paramKeyEvent);
  }
  
  public void doOnActivityResult(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    IUIProxy localIUIProxy = this.mUIProxy;
    if (localIUIProxy != null) {
      localIUIProxy.onActivityResult(paramBaseActivity, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    IUIProxy localIUIProxy = this.mUIProxy;
    if (localIUIProxy != null) {
      paramBoolean = localIUIProxy.onBackPressed(paramBaseActivity);
    } else {
      paramBoolean = false;
    }
    if (paramBoolean) {
      return;
    }
    if (!paramBaseActivity.moveTaskToBack(false)) {
      paramBaseActivity.finish();
    }
  }
  
  public boolean doOnCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    return true;
  }
  
  public void doOnDestroy(BaseActivity paramBaseActivity)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doOnDestroy");
    IUIProxy localIUIProxy = this.mUIProxy;
    if (localIUIProxy != null) {
      localIUIProxy.onDetachActivity(paramBaseActivity);
    }
    MiniSDKClientQIPCModule.c();
  }
  
  public void doOnNewIntent(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doOnNewIntent");
    try
    {
      this.mIntent = paramIntent;
      recoveryIntent(paramBaseActivity, paramIntent);
      paramBaseActivity = (MiniAppInfo)paramBaseActivity.getIntent().getParcelableExtra("KEY_APPINFO");
      this.mUIProxy = AppLoaderFactory.g().getMiniAppEnv().getUIProxy(paramBaseActivity);
      return;
    }
    catch (Throwable paramBaseActivity)
    {
      QLog.e("minisdk-start_FakeSdkBrandUI", 1, "doOnNewIntent exception!", paramBaseActivity);
    }
  }
  
  public void doOnPause(BaseActivity paramBaseActivity)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doOnPause");
    paramBaseActivity = this.mUIProxy;
    if (paramBaseActivity != null) {
      paramBaseActivity.onMiniPause();
    }
  }
  
  public void doOnResume(BaseActivity paramBaseActivity)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doOnResume");
    IUIProxy localIUIProxy = this.mUIProxy;
    if (localIUIProxy != null)
    {
      Intent localIntent = this.mIntent;
      if (localIntent != null)
      {
        localIUIProxy.onIntentUpdate(localIntent);
        this.mIntent = null;
      }
      this.mUIProxy.onMiniResume();
    }
    ImmersiveUtils.setStatusTextColor(true, paramBaseActivity.getWindow());
  }
  
  public void doOnStart(BaseActivity paramBaseActivity)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doOnStart");
    paramBaseActivity = this.mUIProxy;
    if (paramBaseActivity != null) {
      paramBaseActivity.onMiniStart();
    }
  }
  
  public void doOnStop(BaseActivity paramBaseActivity)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doOnStop");
    paramBaseActivity = this.mUIProxy;
    if (paramBaseActivity != null) {
      paramBaseActivity.onMiniStop();
    }
  }
  
  public void doRefreshMiniBadge(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    if (this.mUIProxy != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_appid", paramBundle.getString("miniAppID"));
      localBundle.putInt("KEY_BADGE_COUNT", paramBundle.getInt("param_proc_badge_count"));
      this.mUIProxy.onRefreshMiniBadge(paramBaseActivity, localBundle);
    }
  }
  
  public void finish(BaseActivity paramBaseActivity) {}
  
  public boolean isWrapContent(BaseActivity paramBaseActivity)
  {
    return false;
  }
  
  public boolean moveTaskToBack(BaseActivity paramBaseActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    PageGestureProxy localPageGestureProxy = (PageGestureProxy)AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
    if (localPageGestureProxy != null) {
      localPageGestureProxy.onMoveTaskToBack(paramBaseActivity);
    }
    return false;
  }
  
  public void onProcessBackground(BaseActivity paramBaseActivity, Bundle paramBundle) {}
  
  public void onProcessForeGround(BaseActivity paramBaseActivity, Bundle paramBundle) {}
  
  public void onRefreshMiniBadge(BaseActivity paramBaseActivity, Bundle paramBundle) {}
  
  public void setColorNoteWithOutMoveTaskToBackThisTime() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.fake.FakeSdkBrandUI
 * JD-Core Version:    0.7.0.1
 */