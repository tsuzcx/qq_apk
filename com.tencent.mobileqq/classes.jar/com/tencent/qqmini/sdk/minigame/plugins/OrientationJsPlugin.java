package com.tencent.qqmini.sdk.minigame.plugins;

import android.view.OrientationEventListener;
import bdcz;
import bdnw;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;

public class OrientationJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_ORIENTATION_CHANGE = "onDeviceOrientationChange";
  private static final String TAG = "OrientationJsPlugin";
  private String lastOrientation;
  private OrientationEventListener mOrientationListener;
  
  public void onCreate(bdcz parambdcz)
  {
    super.onCreate(parambdcz);
    if (this.mMiniAppContext.a() != null)
    {
      this.mOrientationListener = new OrientationJsPlugin.GameOrientationListener(this, parambdcz.a(), 3);
      if (this.mOrientationListener.canDetectOrientation())
      {
        bdnw.b("OrientationJsPlugin", "can detect orientation, start listening Orientation change");
        this.mOrientationListener.enable();
      }
    }
    else
    {
      return;
    }
    bdnw.b("OrientationJsPlugin", "can not detect orientation");
    this.mOrientationListener.disable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OrientationJsPlugin
 * JD-Core Version:    0.7.0.1
 */