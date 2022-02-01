package com.tencent.qqmini.minigame.plugins;

import android.view.OrientationEventListener;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

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
    if (this.mMiniAppContext.getAttachedActivity() != null)
    {
      this.mOrientationListener = new OrientationJsPlugin.GameOrientationListener(this, paramIMiniAppContext.getAttachedActivity(), 3);
      if (this.mOrientationListener.canDetectOrientation())
      {
        QMLog.i("OrientationJsPlugin", "can detect orientation, start listening Orientation change");
        this.mOrientationListener.enable();
        return;
      }
      QMLog.i("OrientationJsPlugin", "can not detect orientation");
      this.mOrientationListener.disable();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.OrientationJsPlugin
 * JD-Core Version:    0.7.0.1
 */