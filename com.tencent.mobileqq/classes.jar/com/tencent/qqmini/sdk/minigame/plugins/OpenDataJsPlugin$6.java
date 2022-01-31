package com.tencent.qqmini.sdk.minigame.plugins;

import beka;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class OpenDataJsPlugin$6
  implements AsyncResult
{
  OpenDataJsPlugin$6(OpenDataJsPlugin paramOpenDataJsPlugin, beka parambeka) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramJSONObject.optBoolean("needShareCallBack"))
    {
      if (paramBoolean) {
        this.val$req.a();
      }
    }
    else {
      return;
    }
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */