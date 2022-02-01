package com.tencent.qqmini.sdk.plugins.engine;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class BaseJsPluginEngine$7
  implements AsyncResult
{
  BaseJsPluginEngine$7(BaseJsPluginEngine paramBaseJsPluginEngine, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    BaseJsPluginEngine.access$1000(this.this$0, this.val$req, paramBoolean, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.7
 * JD-Core Version:    0.7.0.1
 */