package com.tencent.pts.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.LinearLayout;
import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.bridge.PTSJSBridgeManager;
import com.tencent.pts.utils.PTSTimeCostUtil;

public class PTSActivity
  extends Activity
{
  private static Context sApplicationContext;
  private String mAppName = "daily_feeds";
  PTSAppInstance mPTSAppInstance;
  
  static
  {
    System.loadLibrary("pts");
  }
  
  public static Context getPTSApplicationContext()
  {
    return sApplicationContext;
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    PTSTimeCostUtil.start("PTSActivity-onCreate");
    super.onCreate(paramBundle);
    sApplicationContext = getApplicationContext();
    getWindow().getDecorView().setSystemUiVisibility(8192);
    if (getIntent() != null)
    {
      paramBundle = getIntent().getStringExtra("packageName");
      if (!TextUtils.isEmpty(paramBundle)) {
        this.mAppName = paramBundle;
      }
    }
    paramBundle = new LinearLayout(this);
    paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramBundle.setOrientation(1);
    setContentView(paramBundle);
    PTSJSBridge localPTSJSBridge = PTSJSBridgeManager.getInstance().getJSBridge(this);
    this.mPTSAppInstance = new PTSAppInstance.Builder().withActivity(this).withRootView(paramBundle).withRootNodeType(0).withPTSJSBridge(localPTSJSBridge).withAppName(this.mAppName).withAppPath("").build();
    this.mPTSAppInstance.onCreate();
    PTSTimeCostUtil.end("PTSActivity-onCreate");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mPTSAppInstance.onDestroy();
    PTSJSBridgeManager.getInstance().destroyJSBridge(this);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.mPTSAppInstance.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mPTSAppInstance.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.core.PTSActivity
 * JD-Core Version:    0.7.0.1
 */