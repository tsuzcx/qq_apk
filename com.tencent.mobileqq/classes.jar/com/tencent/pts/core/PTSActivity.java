package com.tencent.pts.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.bridge.PTSJSBridgeManager;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSTimeCostUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PTSActivity
  extends Activity
{
  public static final String ANIMATION_JS_KEY = "com.tencent.pts.core.AnimationJs";
  public static final String BIND_DATA_JS_KEY = "com.tencent.pts.core.BindDataJs";
  public static final String FRAME_TREE_JSON_KEY = "com.tencent.pts.core.FrameTreeJson";
  public static final String PAGE_JS_KEY = "com.tencent.pts.core.PageJs";
  public static final String PAGE_NAME_KEY = "com.tencent.pts.core.PageName";
  public static final String TAG = "PTSActivity";
  public static final String[] parameters = { "com.tencent.pts.core.PageName", "com.tencent.pts.core.FrameTreeJson", "com.tencent.pts.core.PageJs", "com.tencent.pts.core.BindDataJs", "com.tencent.pts.core.AnimationJs" };
  PTSAppInstance mPTSAppInstance;
  
  static
  {
    System.loadLibrary("pts");
  }
  
  private String getParameter(String paramString)
  {
    if (getIntent() == null) {
      return "";
    }
    return getIntent().getStringExtra(paramString);
  }
  
  private boolean isParametersAvailable()
  {
    String[] arrayOfString = parameters;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (TextUtils.isEmpty(getParameter(str)))
      {
        PTSLog.e("PTSActivity", "[isParametersAvailable], key = " + str + ", is null.");
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static void startNewPage(Context paramContext, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramBundle == null)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, PTSActivity.class);
    String[] arrayOfString = parameters;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      localIntent.putExtra(str, paramBundle.getString(str, ""));
      i += 1;
    }
    localIntent.setFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    PTSTimeCostUtil.start("PTSActivity-onCreate");
    super.onCreate(paramBundle);
    if (!isParametersAvailable())
    {
      PTSTimeCostUtil.end("PTSActivity-onCreate");
      return;
    }
    paramBundle = new LinearLayout(this);
    paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramBundle.setOrientation(1);
    setContentView(paramBundle);
    PTSJSBridge localPTSJSBridge = PTSJSBridgeManager.getInstance().getJSBridge(this, getParameter("com.tencent.pts.core.BindDataJs"), getParameter("com.tencent.pts.core.AnimationJs"));
    this.mPTSAppInstance = new PTSAppInstance.Builder().withContext(this).withRootView(paramBundle).withRootNodeType(0).withPTSJSBridge(localPTSJSBridge).withPageName(getParameter("com.tencent.pts.core.PageName")).withFrameTreeJson(getParameter("com.tencent.pts.core.FrameTreeJson")).withPageJs(getParameter("com.tencent.pts.core.PageJs")).build();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pts.core.PTSActivity
 * JD-Core Version:    0.7.0.1
 */