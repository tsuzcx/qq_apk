package com.tencent.qqmini.sdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DisplayUtil;

public class MiniActivity
  extends Activity
{
  private IUIProxy a;
  
  public static void a(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      paramActivity = paramActivity.getWindow();
      if (paramActivity != null) {
        paramActivity.getDecorView().setSystemUiVisibility(23075586);
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      QMLog.e("MiniActivity", "Failed to initUIProxy, intent is null");
    }
    do
    {
      return;
      MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramIntent.getParcelableExtra("KEY_APPINFO");
      this.a = AppLoaderFactory.g().getAppUIProxy(localMiniAppInfo);
      paramIntent = (LoginInfo)paramIntent.getParcelableExtra("KEY_LOGININFO");
    } while (paramIntent == null);
    AppLoaderFactory.g().getMiniAppEnv().setLoginInfo(paramIntent);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.a != null) {
      this.a.onActivityResult(this, paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (this.a != null) {}
    for (boolean bool = this.a.onBackPressed(this);; bool = false)
    {
      if ((!bool) && (!moveTaskToBack(false))) {
        finish();
      }
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    MiniSDK.init(getApplicationContext());
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = (MiniAppInfo)((Intent)localObject).getParcelableExtra("KEY_APPINFO");
      if ((localObject != null) && (((MiniAppInfo)localObject).isEngineTypeMiniGame())) {
        DisplayUtil.setActivityTransparent(this);
      }
    }
    localObject = new RelativeLayout(this);
    setContentView((View)localObject);
    FrameLayout localFrameLayout = new FrameLayout(this);
    ((RelativeLayout)localObject).addView(localFrameLayout, new RelativeLayout.LayoutParams(-1, -1));
    a(getIntent());
    if (this.a == null)
    {
      QMLog.e("MiniActivity", "onCreate(). Failed to start MiniActivity, UIProxy is null!");
      finish();
      return;
    }
    this.a.onCreate(this, paramBundle, localFrameLayout);
  }
  
  protected void onDestroy()
  {
    if (this.a != null) {
      this.a.onDestroy(this);
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    if (paramInt == 4)
    {
      boolean bool1;
      if (this.a != null)
      {
        bool1 = this.a.onBackPressed(this);
        if (!bool1) {
          break label39;
        }
        bool1 = true;
      }
      label39:
      do
      {
        return bool1;
        bool1 = false;
        break;
        bool1 = bool2;
      } while (moveTaskToBack(false));
      finish();
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
    if (this.a == null)
    {
      QMLog.e("MiniActivity", "onNewIntent(). Failed to start MiniActivity, UIProxy is null!");
      finish();
      return;
    }
    this.a.onNewIntent(this, paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.a != null) {
      this.a.onPause(this);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.a != null) {
      this.a.onRequestPermissionsResult(this, paramInt, paramArrayOfString, paramArrayOfInt);
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.onResume(this);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    if (this.a != null) {
      this.a.onStart(this);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.a != null) {
      this.a.onStop(this);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    a(this);
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniActivity
 * JD-Core Version:    0.7.0.1
 */