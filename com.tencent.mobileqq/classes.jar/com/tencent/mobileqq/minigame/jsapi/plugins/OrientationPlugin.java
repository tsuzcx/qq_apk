package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.view.OrientationEventListener;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPlugin;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Set;

public class OrientationPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_ORIENTATION_CHANGE = "onDeviceOrientationChange";
  private static final String TAG = "[minigame] OrientationPlugin";
  private String lastOrientation;
  private OrientationEventListener mOrientationListener;
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    if (paramBaseJsPluginEngine.getActivityContext() != null)
    {
      this.mOrientationListener = new OrientationPlugin.GameOrientationListener(this, paramBaseJsPluginEngine.getActivityContext(), 3);
      if (this.mOrientationListener.canDetectOrientation())
      {
        QLog.i("[minigame] OrientationPlugin", 1, "can detect orientation, start listening Orientation change");
        this.mOrientationListener.enable();
      }
    }
    else
    {
      return;
    }
    QLog.i("[minigame] OrientationPlugin", 1, "can not detect orientation");
    this.mOrientationListener.disable();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mOrientationListener != null) {
      this.mOrientationListener.disable();
    }
  }
  
  public Set<String> supportedEvents()
  {
    return Collections.emptySet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.OrientationPlugin
 * JD-Core Version:    0.7.0.1
 */