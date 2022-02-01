package com.tencent.qqmini.minigame.plugins;

import android.view.OrientationEventListener;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;

@JsPlugin(lazyLoad=false)
public class OrientationJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_ORIENTATION_CHANGE = "onDeviceOrientationChange";
  private static final String TAG = "OrientationJsPlugin";
  private String lastOrientation;
  private OrientationEventListener mOrientationListener;
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    ThreadManager.executeOnComputationThreadPool(new OrientationJsPlugin.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.OrientationJsPlugin
 * JD-Core Version:    0.7.0.1
 */