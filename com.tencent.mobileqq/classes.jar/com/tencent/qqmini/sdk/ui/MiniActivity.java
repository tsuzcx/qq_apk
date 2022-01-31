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
import bdct;
import bdle;
import bdlu;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class MiniActivity
  extends Activity
{
  private bdlu a;
  
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
      return;
    }
    paramIntent = (MiniAppInfo)paramIntent.getParcelableExtra("KEY_APPINFO");
    this.a = bdle.a().a(paramIntent);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.a.onActivityResult(this, paramInt1, paramInt2, paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.a.onBackPressed(this)) {
      super.onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    bdct.a(getApplicationContext(), null);
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    setContentView(localRelativeLayout);
    FrameLayout localFrameLayout = new FrameLayout(this);
    localRelativeLayout.addView(localFrameLayout, new RelativeLayout.LayoutParams(-1, -1));
    a(getIntent());
    this.a.onCreate(this, paramBundle, localFrameLayout);
  }
  
  protected void onDestroy()
  {
    this.a.onDestroy(this);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.a.onBackPressed(this)) {
        return true;
      }
      super.onBackPressed();
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
    this.a.onNewIntent(this, paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.a.onPause(this);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.onRequestPermissionsResult(this, paramInt, paramArrayOfString, paramArrayOfInt);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.a.onResume(this);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.a.onStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    this.a.onStop(this);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    a(this);
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniActivity
 * JD-Core Version:    0.7.0.1
 */