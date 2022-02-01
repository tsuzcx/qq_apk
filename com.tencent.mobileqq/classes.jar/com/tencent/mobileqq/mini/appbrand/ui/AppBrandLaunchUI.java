package com.tencent.mobileqq.mini.appbrand.ui;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.MotionEvent;
import bhmr;
import bhni;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.launch.MiniAppStartUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class AppBrandLaunchUI
  extends BaseActivity
{
  public static final int ACTIVITY_CODE_LOGIN = 100001;
  public static final String TAG = "miniapp-start_AppBrandLaunchUI";
  private Handler mUIHandler;
  
  private void doRequestByAppid(String paramString1, String paramString2, String paramString3, LaunchParam paramLaunchParam)
  {
    MiniAppCmdUtil.getInstance().getAppInfoById(null, paramString1, paramString2, paramString3, new AppBrandLaunchUI.1(this, paramLaunchParam));
  }
  
  private void doStartMiniApp(MiniAppConfig paramMiniAppConfig)
  {
    try
    {
      MiniAppController.startApp(this, paramMiniAppConfig, null);
      return;
    }
    catch (Throwable paramMiniAppConfig)
    {
      QLog.e("miniapp", 1, "startAppByAppid exception! ", paramMiniAppConfig);
    }
  }
  
  private void initData()
  {
    QLog.i("miniapp-start", 1, "LoadingFragment doTask");
    Object localObject3 = getIntent();
    if (localObject3 == null)
    {
      finish();
      return;
    }
    Object localObject1 = ((Intent)localObject3).getStringExtra("from");
    Object localObject4;
    int i;
    int j;
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ("SchemeJsPlugin".equals(localObject1)))
    {
      localObject1 = ((Intent)localObject3).getStringExtra("scheme");
      localObject2 = (ResultReceiver)((Intent)localObject3).getParcelableExtra("result_receiver");
      localObject3 = bhni.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this, (String)localObject1);
      localObject4 = new Bundle();
      if (localObject3 != null)
      {
        boolean bool = ((bhmr)localObject3).a();
        if (bool)
        {
          i = 1;
          j = i;
          if (!bool) {
            ((Bundle)localObject4).putString("errMsg", "can not find scheme : " + (String)localObject1);
          }
        }
      }
      for (j = i;; j = 0)
      {
        if (localObject2 != null) {
          ((ResultReceiver)localObject2).send(j, (Bundle)localObject4);
        }
        finish();
        return;
        i = 0;
        break;
        ((Bundle)localObject4).putString("errMsg", "parse scheme error : " + (String)localObject1);
      }
    }
    if (!BaseApplicationImpl.getApplication().getRuntime().isLogin())
    {
      localObject1 = new Intent(this, LoginActivity.class);
      ((Intent)localObject1).putExtra("MINI_SHORTCUT_JUMP_KEY", (Parcelable)localObject3);
      startActivity((Intent)localObject1);
      finish();
      return;
    }
    Object localObject2 = MiniAppStartUtils.parserStringToMiniAppInfo(((Intent)localObject3).getStringExtra("CONFIG_base64"));
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject4 = ((Intent)localObject3).getStringExtra("CONFIG_APPID");
      String str1 = ((Intent)localObject3).getStringExtra("CONFIG_APPNAME");
      String str2 = ((Intent)localObject3).getStringExtra("CONFIG_APPICON");
      i = ((Intent)localObject3).getIntExtra("CONFIG_REPORTTYPE", 0);
      j = ((Intent)localObject3).getIntExtra("CONFIG_ENGINETYPE", 0);
      int k = ((Intent)localObject3).getIntExtra("MINI_CONFIG_SCENE", 10086);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(str1))
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(str2))
          {
            localObject1 = new MiniAppInfo();
            ((MiniAppInfo)localObject1).appId = ((String)localObject4);
            ((MiniAppInfo)localObject1).name = str1;
            ((MiniAppInfo)localObject1).iconUrl = str2;
            ((MiniAppInfo)localObject1).setEngineType(j);
            ((MiniAppInfo)localObject1).setReportType(i);
            localObject1 = new MiniAppConfig((MiniAppInfo)localObject1);
            ((MiniAppConfig)localObject1).launchParam = new LaunchParam();
            ((MiniAppConfig)localObject1).launchParam.miniAppId = ((String)localObject4);
            ((MiniAppConfig)localObject1).launchParam.scene = k;
          }
        }
      }
    }
    if (localObject1 != null) {
      doStartMiniApp((MiniAppConfig)localObject1);
    }
    finish();
  }
  
  private boolean isMiniAppInfoValid(MiniAppConfig paramMiniAppConfig)
  {
    return (paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)) && (!TextUtils.isEmpty(paramMiniAppConfig.config.downloadUrl));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.i("miniapp-start_AppBrandLaunchUI", 1, "doOnActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (paramInt2 == -1)
    {
      paramIntent = MiniAppStartUtils.parserStringToMiniAppInfo(getIntent().getStringExtra("CONFIG_base64"));
      if (paramIntent != null) {
        doStartMiniApp(paramIntent);
      }
      moveTaskToBack(true);
      finish();
      return;
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.mUIHandler = new Handler(Looper.getMainLooper());
    return true;
  }
  
  public void doOnDestroy()
  {
    QLog.i("miniapp-start_AppBrandLaunchUI", 1, "doOnDestroy");
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    QLog.i("miniapp-start_AppBrandLaunchUI", 1, "doOnResume");
    super.doOnNewIntent(paramIntent);
  }
  
  public void doOnPause()
  {
    QLog.i("miniapp-start_AppBrandLaunchUI", 1, "doOnPause");
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    QLog.i("miniapp-start_AppBrandLaunchUI", 1, "doOnResume");
    super.doOnResume();
    initData();
  }
  
  public void doOnStop()
  {
    QLog.i("miniapp-start_AppBrandLaunchUI", 1, "doOnStop");
    super.doOnStop();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI
 * JD-Core Version:    0.7.0.1
 */