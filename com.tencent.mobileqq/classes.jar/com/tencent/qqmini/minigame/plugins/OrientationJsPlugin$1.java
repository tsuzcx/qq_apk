package com.tencent.qqmini.minigame.plugins;

import android.view.OrientationEventListener;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class OrientationJsPlugin$1
  implements Runnable
{
  OrientationJsPlugin$1(OrientationJsPlugin paramOrientationJsPlugin) {}
  
  public void run()
  {
    if (OrientationJsPlugin.access$000(this.this$0).getAttachedActivity() != null)
    {
      OrientationJsPlugin localOrientationJsPlugin = this.this$0;
      OrientationJsPlugin.access$102(localOrientationJsPlugin, new OrientationJsPlugin.GameOrientationListener(localOrientationJsPlugin, OrientationJsPlugin.access$200(localOrientationJsPlugin).getAttachedActivity(), 3));
      if (OrientationJsPlugin.access$100(this.this$0).canDetectOrientation())
      {
        QMLog.i("OrientationJsPlugin", "can detect orientation, start listening Orientation change");
        OrientationJsPlugin.access$100(this.this$0).enable();
        return;
      }
      QMLog.i("OrientationJsPlugin", "can not detect orientation");
      OrientationJsPlugin.access$100(this.this$0).disable();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.OrientationJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */