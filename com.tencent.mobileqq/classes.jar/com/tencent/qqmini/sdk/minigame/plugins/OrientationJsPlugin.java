package com.tencent.qqmini.sdk.minigame.plugins;

import android.view.OrientationEventListener;
import bglv;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;

public class OrientationJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_ORIENTATION_CHANGE = "onDeviceOrientationChange";
  private static final String TAG = "OrientationJsPlugin";
  private String lastOrientation;
  private OrientationEventListener mOrientationListener;
  
  public void onCreate(bglv parambglv)
  {
    super.onCreate(parambglv);
    if (this.mMiniAppContext.a() != null)
    {
      this.mOrientationListener = new OrientationJsPlugin.GameOrientationListener(this, parambglv.a(), 3);
      if (this.mOrientationListener.canDetectOrientation())
      {
        QMLog.i("OrientationJsPlugin", "can detect orientation, start listening Orientation change");
        this.mOrientationListener.enable();
      }
    }
    else
    {
      return;
    }
    QMLog.i("OrientationJsPlugin", "can not detect orientation");
    this.mOrientationListener.disable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OrientationJsPlugin
 * JD-Core Version:    0.7.0.1
 */