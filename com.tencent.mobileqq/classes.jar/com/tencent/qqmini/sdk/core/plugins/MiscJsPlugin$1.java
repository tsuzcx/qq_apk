package com.tencent.qqmini.sdk.core.plugins;

import beka;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class MiscJsPlugin$1
  implements AsyncResult
{
  MiscJsPlugin$1(MiscJsPlugin paramMiscJsPlugin, beka parambeka) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      this.val$req.a();
      return;
    }
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.MiscJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */