package com.tencent.qqmini.sdk.launcher.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

public class MiniActivity
  extends Activity
{
  protected static final String TAG = "MiniActivity";
  private Intent mIntent;
  private IUIProxy mUIProxy;
  
  private static MiniAppInfo getMiniAppInfoFromIntent(Intent paramIntent)
  {
    try
    {
      paramIntent = (MiniAppInfo)paramIntent.getParcelableExtra("KEY_APPINFO");
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      QMLog.e("MiniActivity", "Failed to getMiniAppInfoFromIntent", paramIntent);
    }
    return null;
  }
  
  private void initUIProxy(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QMLog.e("MiniActivity", "Failed to initUIProxy, intent is null");
      return;
    }
    MiniAppInfo localMiniAppInfo = getMiniAppInfoFromIntent(paramIntent);
    this.mIntent = paramIntent;
    this.mUIProxy = AppLoaderFactory.g().getMiniAppEnv().getUIProxy(localMiniAppInfo);
  }
  
  public static void setActivityFullScreen(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      paramActivity = paramActivity.getWindow();
      if (paramActivity != null) {
        paramActivity.getDecorView().setSystemUiVisibility(23075586);
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    IUIProxy localIUIProxy = this.mUIProxy;
    if (localIUIProxy != null) {
      localIUIProxy.onActivityResult(this, paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    IUIProxy localIUIProxy = this.mUIProxy;
    boolean bool;
    if (localIUIProxy != null) {
      bool = localIUIProxy.onBackPressed(this);
    } else {
      bool = false;
    }
    if ((!bool) && (!moveTaskToBack(false))) {
      finish();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this);
    ((StringBuilder)localObject1).append(" onCreate(). ");
    ((StringBuilder)localObject1).append(getIntent());
    QMLog.i("MiniActivity", ((StringBuilder)localObject1).toString());
    super.onCreate(paramBundle);
    MiniSDK.init(getApplicationContext());
    localObject1 = getIntent();
    if (localObject1 != null)
    {
      localObject2 = getMiniAppInfoFromIntent((Intent)localObject1);
      if ((localObject2 != null) && (((MiniAppInfo)localObject2).isEngineTypeMiniGame()))
      {
        DisplayUtil.setActivityTransparent(this);
      }
      else
      {
        requestWindowFeature(1);
        getWindow().addFlags(1);
        getWindow().addFlags(67108864);
      }
    }
    Object localObject3 = new RelativeLayout(this);
    setContentView((View)localObject3);
    Object localObject2 = new FrameLayout(this);
    ((RelativeLayout)localObject3).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    AppLoaderFactory.g().getMiniAppEnv().setupWithIntent((Intent)localObject1);
    initUIProxy(getIntent());
    localObject3 = this.mUIProxy;
    if (localObject3 == null)
    {
      QMLog.e("MiniActivity", "onCreate(). Failed to start MiniActivity, UIProxy is null!");
      finish();
      return;
    }
    ((IUIProxy)localObject3).onAttachActivity(this, paramBundle, (ViewGroup)localObject2);
    paramBundle = new StringBuilder();
    paramBundle.append(this);
    paramBundle.append(" onCreate(). ");
    paramBundle.append(((Intent)localObject1).getData());
    QMLog.e("MiniActivity", paramBundle.toString());
  }
  
  protected void onDestroy()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" onDestroy(). ");
    ((StringBuilder)localObject).append(getIntent());
    QMLog.i("MiniActivity", ((StringBuilder)localObject).toString());
    localObject = this.mUIProxy;
    if (localObject != null) {
      ((IUIProxy)localObject).onDetachActivity(this);
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = this.mUIProxy;
      boolean bool;
      if (paramKeyEvent != null) {
        bool = paramKeyEvent.onBackPressed(this);
      } else {
        bool = false;
      }
      if (bool) {
        return true;
      }
      if (!moveTaskToBack(false)) {
        finish();
      }
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this);
    localStringBuilder.append(" onNewIntent(). ");
    localStringBuilder.append(paramIntent);
    QMLog.i("MiniActivity", localStringBuilder.toString());
    initUIProxy(paramIntent);
    if (this.mUIProxy == null)
    {
      QMLog.e("MiniActivity", "onNewIntent(). Failed to start MiniActivity, UIProxy is null!");
      finish();
    }
  }
  
  protected void onPause()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" onPause(). ");
    ((StringBuilder)localObject).append(getIntent());
    QMLog.i("MiniActivity", ((StringBuilder)localObject).toString());
    super.onPause();
    localObject = this.mUIProxy;
    if (localObject != null) {
      ((IUIProxy)localObject).onMiniPause();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    IUIProxy localIUIProxy = this.mUIProxy;
    if (localIUIProxy != null) {
      localIUIProxy.onRequestPermissionsResult(this, paramInt, paramArrayOfString, paramArrayOfInt);
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onResume()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" onResume(). ");
    ((StringBuilder)localObject).append(getIntent());
    QMLog.i("MiniActivity", ((StringBuilder)localObject).toString());
    super.onResume();
    localObject = this.mUIProxy;
    if (localObject != null)
    {
      Intent localIntent = this.mIntent;
      if (localIntent != null)
      {
        ((IUIProxy)localObject).onIntentUpdate(localIntent);
        this.mIntent = null;
      }
      this.mUIProxy.onMiniResume();
    }
  }
  
  protected void onStart()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" onStart(). ");
    ((StringBuilder)localObject).append(getIntent());
    QMLog.i("MiniActivity", ((StringBuilder)localObject).toString());
    super.onStart();
    localObject = this.mUIProxy;
    if (localObject != null) {
      ((IUIProxy)localObject).onMiniStart();
    }
  }
  
  protected void onStop()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" onStop(). ");
    ((StringBuilder)localObject).append(getIntent());
    QMLog.i("MiniActivity", ((StringBuilder)localObject).toString());
    super.onStop();
    localObject = this.mUIProxy;
    if (localObject != null) {
      ((IUIProxy)localObject).onMiniStop();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    setActivityFullScreen(this);
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ui.MiniActivity
 * JD-Core Version:    0.7.0.1
 */