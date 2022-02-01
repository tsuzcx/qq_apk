package com.tencent.qqmini.sdk.plugins.engine;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Method;

class MiniGameJsPluginEngine$1
  implements Runnable
{
  MiniGameJsPluginEngine$1(MiniGameJsPluginEngine paramMiniGameJsPluginEngine, RequestEvent paramRequestEvent, Method paramMethod, IJsPlugin paramIJsPlugin) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatchEvent: handle async, event=");
    localStringBuilder.append(this.a.event);
    QMLog.d("JsPluginEngine[Dispatcher]", localStringBuilder.toString());
    if (MiniGameJsPluginEngine.a(this.this$0, this.b, this.c, this.a) == MiniGameJsPluginEngine.a()) {
      this.a.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.MiniGameJsPluginEngine.1
 * JD-Core Version:    0.7.0.1
 */