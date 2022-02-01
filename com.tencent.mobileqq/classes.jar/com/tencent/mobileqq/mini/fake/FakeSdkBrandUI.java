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
import bjjo;
import bjsu;
import bjsv;
import bkyl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.app.IAppUIProxy;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class FakeSdkBrandUI
  implements IFakeBrandUI
{
  private static final String COOKIE_DOMAIN = "qzone.qq.com";
  private static final String TAG = "minisdk-start_FakeSdkBrandUI";
  private static volatile boolean mHasOKHttpClientInit;
  public static volatile boolean mHasOnCreate;
  private Intent mIntent;
  private IUIProxy mUIProxy;
  
  private boolean finishAndRemoveTask(Activity paramActivity)
  {
    if ((paramActivity == null) || (Build.VERSION.SDK_INT < 21)) {
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
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.AppTask localAppTask = (ActivityManager.AppTask)((Iterator)localObject).next();
        if ((localAppTask != null) && (localAppTask.getTaskInfo() != null) && (localAppTask.getTaskInfo().baseIntent != null) && (localAppTask.getTaskInfo().baseIntent.getComponent() != null))
        {
          String str = localAppTask.getTaskInfo().baseIntent.getComponent().getClassName();
          QLog.i("minisdk-start_FakeSdkBrandUI", 1, "finishAndRemoveTask try finish and remove task: id=" + localAppTask.getTaskInfo().id + ", componentName:" + str);
          if ((!TextUtils.isEmpty(str)) && (str.equals(paramActivity.getClass().getName())))
          {
            QLog.i("minisdk-start_FakeSdkBrandUI", 1, "finishAndRemoveTask finish and remove task: id=" + localAppTask.getTaskInfo().id);
            localAppTask.finishAndRemoveTask();
          }
        }
      }
      return true;
    }
    catch (Throwable paramActivity)
    {
      QLog.e("minisdk-start_FakeSdkBrandUI", 1, "finishAndRemoveTask exception.", paramActivity);
    }
    return false;
  }
  
  public static void initOKHttpClient()
  {
    if (!mHasOKHttpClientInit)
    {
      mHasOKHttpClientInit = true;
      MiniOkHttpClientFactory.init(30000L, 30000L, 30000L);
    }
  }
  
  /* Error */
  private void recoveryIntent(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: ldc 164
    //   8: invokevirtual 168	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   11: checkcast 170	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo
    //   14: astore 5
    //   16: aload 5
    //   18: ifnonnull -14 -> 4
    //   21: aload 5
    //   23: astore 4
    //   25: aload_2
    //   26: ldc 172
    //   28: invokevirtual 168	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   31: checkcast 174	com/tencent/mobileqq/mini/apkg/MiniAppConfig
    //   34: astore 6
    //   36: aload 5
    //   38: astore 4
    //   40: aload 6
    //   42: ifnull +43 -> 85
    //   45: aload 5
    //   47: astore 4
    //   49: aload 6
    //   51: invokestatic 180	com/tencent/mobileqq/mini/launch/MiniSdkLauncher:convert	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;)Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   54: astore 5
    //   56: aload 5
    //   58: astore 4
    //   60: aload_2
    //   61: ldc 164
    //   63: aload 5
    //   65: invokevirtual 184	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   68: pop
    //   69: aload 5
    //   71: astore 4
    //   73: ldc 13
    //   75: iconst_1
    //   76: ldc 186
    //   78: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload 5
    //   83: astore 4
    //   85: invokestatic 194	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   88: ldc 196
    //   90: ldc 198
    //   92: iconst_1
    //   93: invokevirtual 202	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   96: ifle +75 -> 171
    //   99: iconst_1
    //   100: istore_3
    //   101: aload 4
    //   103: ifnonnull -99 -> 4
    //   106: iload_3
    //   107: ifeq -103 -> 4
    //   110: ldc 13
    //   112: iconst_1
    //   113: ldc 204
    //   115: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload_1
    //   119: ifnull +16 -> 135
    //   122: aload_1
    //   123: invokevirtual 210	com/tencent/mobileqq/app/BaseActivity:getApplicationContext	()Landroid/content/Context;
    //   126: ldc 212
    //   128: iconst_1
    //   129: invokestatic 218	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   132: invokevirtual 221	android/widget/Toast:show	()V
    //   135: invokestatic 227	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   138: new 229	com/tencent/mobileqq/mini/fake/FakeSdkBrandUI$2
    //   141: dup
    //   142: aload_0
    //   143: aload_1
    //   144: invokespecial 232	com/tencent/mobileqq/mini/fake/FakeSdkBrandUI$2:<init>	(Lcom/tencent/mobileqq/mini/fake/FakeSdkBrandUI;Lcom/tencent/mobileqq/app/BaseActivity;)V
    //   147: ldc2_w 233
    //   150: invokevirtual 240	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   153: pop
    //   154: return
    //   155: astore_2
    //   156: aconst_null
    //   157: astore 4
    //   159: ldc 13
    //   161: iconst_1
    //   162: ldc 242
    //   164: aload_2
    //   165: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   168: goto -83 -> 85
    //   171: iconst_0
    //   172: istore_3
    //   173: goto -72 -> 101
    //   176: astore_2
    //   177: goto -18 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	FakeSdkBrandUI
    //   0	180	1	paramBaseActivity	BaseActivity
    //   0	180	2	paramIntent	Intent
    //   100	73	3	i	int
    //   23	135	4	localMiniAppInfo1	MiniAppInfo
    //   14	68	5	localMiniAppInfo2	MiniAppInfo
    //   34	16	6	localMiniAppConfig	MiniAppConfig
    // Exception table:
    //   from	to	target	type
    //   5	16	155	java/lang/Throwable
    //   25	36	176	java/lang/Throwable
    //   49	56	176	java/lang/Throwable
    //   60	69	176	java/lang/Throwable
    //   73	81	176	java/lang/Throwable
  }
  
  public static void setCookie()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      bjsv localbjsv = new bjsv(bjjo.a().a());
      bjsu localbjsu = new bjsu();
      localbjsu.a(true);
      long l2 = bjjo.a().a();
      Object localObject = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
      String str = ((TicketManager)localObject).getSkey(String.valueOf(l2));
      localObject = ((TicketManager)localObject).getPskey(String.valueOf(l2), "qzone.qq.com");
      localbjsu.a("qzone.qq.com/", "uin=" + l2 + "; path=/; domain=." + "qzone.qq.com" + ";");
      localbjsu.a("qzone.qq.com/", "p_uin=" + l2 + "; path=/; domain=." + "qzone.qq.com" + ";");
      localbjsu.a("qzone.qq.com/", "skey=" + str + "; path=/; domain=." + "qzone.qq.com" + ";");
      localbjsu.a("qzone.qq.com/", "p_skey=" + (String)localObject + "; path=/; domain=." + "qzone.qq.com" + ";");
      localbjsv.a();
      l2 = System.currentTimeMillis();
      QLog.e(AppBrandUI3.class.getSimpleName(), 1, "setCookie cost:" + (l2 - l1));
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
  
  public boolean doBeforeOnCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doBeforeOnCreate");
    mHasOnCreate = true;
    MiniSDK.init(paramBaseActivity.getApplicationContext());
    ThreadManager.executeOnSubThread(new FakeSdkBrandUI.1(this));
    Object localObject1 = new RelativeLayout(paramBaseActivity);
    paramBaseActivity.setContentView((View)localObject1);
    FrameLayout localFrameLayout = new FrameLayout(paramBaseActivity);
    ((RelativeLayout)localObject1).addView(localFrameLayout, new RelativeLayout.LayoutParams(-1, -1));
    Intent localIntent = paramBaseActivity.getIntent();
    for (;;)
    {
      try
      {
        recoveryIntent(paramBaseActivity, localIntent);
        localObject1 = (MiniAppInfo)paramBaseActivity.getIntent().getParcelableExtra("KEY_APPINFO");
        Object localObject2 = localObject1;
        if (localObject1 != null) {}
        QLog.e("minisdk-start_FakeSdkBrandUI", 1, "", localThrowable1);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          MiniAppStartState.setBaseLibLoad(((MiniAppInfo)localObject1).appId, MiniAppStartState.isBaseLibLoaded);
          QLog.w("minisdk-start", 1, "AppBrandUI3.onCreate baseLib pre load:" + MiniAppStartState.isBaseLibLoaded + " appid:" + ((MiniAppInfo)localObject1).appId);
          localObject2 = new MiniAppConfig(MiniSdkLauncher.convert((MiniAppInfo)localObject1));
          AppBrandProxy.g().setMiniAppConfig((MiniAppConfig)localObject2);
          localObject2 = localObject1;
          this.mIntent = localIntent;
          this.mUIProxy = AppLoaderFactory.g().getMiniAppEnv().getUIProxy((MiniAppInfo)localObject2);
          if (this.mUIProxy != null)
          {
            QLog.i("minisdk-start_FakeSdkBrandUI", 1, "UIProxy completed");
            this.mUIProxy.onAttachActivity(paramBaseActivity, paramBundle, localFrameLayout);
          }
          bkyl.a();
          return true;
        }
        catch (Throwable localThrowable2)
        {
          Object localObject3;
          break label240;
        }
        localThrowable1 = localThrowable1;
        localObject1 = null;
      }
      label240:
      localObject3 = localObject1;
    }
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return this.mUIProxy.doDispatchKeyEvent(paramKeyEvent);
  }
  
  public void doOnActivityResult(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mUIProxy != null) {
      this.mUIProxy.onActivityResult(paramBaseActivity, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if (this.mUIProxy != null)
    {
      paramBoolean = this.mUIProxy.onBackPressed(paramBaseActivity);
      if (!paramBoolean) {
        break label28;
      }
    }
    label28:
    while (paramBaseActivity.moveTaskToBack(false))
    {
      return;
      paramBoolean = false;
      break;
    }
    paramBaseActivity.finish();
  }
  
  public boolean doOnCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    return true;
  }
  
  public void doOnDestroy(BaseActivity paramBaseActivity)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doOnDestroy");
    if (this.mUIProxy != null) {
      this.mUIProxy.onDetachActivity(paramBaseActivity);
    }
    bkyl.b();
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
      paramBaseActivity = new MiniAppConfig(MiniSdkLauncher.convert(paramBaseActivity));
      AppBrandProxy.g().setMiniAppConfig(paramBaseActivity);
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
    if (this.mUIProxy != null) {
      this.mUIProxy.onMiniPause();
    }
  }
  
  public void doOnResume(BaseActivity paramBaseActivity)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doOnResume");
    if (this.mUIProxy != null)
    {
      if (this.mIntent != null)
      {
        this.mUIProxy.onIntentUpdate(this.mIntent);
        this.mIntent = null;
      }
      this.mUIProxy.onMiniResume();
    }
    ImmersiveUtils.a(true, paramBaseActivity.getWindow());
  }
  
  public void doOnStart(BaseActivity paramBaseActivity)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doOnStart");
    if (this.mUIProxy != null) {
      this.mUIProxy.onMiniStart();
    }
  }
  
  public void doOnStop(BaseActivity paramBaseActivity)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doOnStop");
    if (this.mUIProxy != null) {
      this.mUIProxy.onMiniStop();
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
  
  public IAppUIProxy getAppUIProxy()
  {
    return null;
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.fake.FakeSdkBrandUI
 * JD-Core Version:    0.7.0.1
 */