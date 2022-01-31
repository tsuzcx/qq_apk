package com.tencent.qqmini.sdk.core.plugins;

import bgok;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class MiscJsPlugin$1
  implements AsyncResult
{
  MiscJsPlugin$1(MiscJsPlugin paramMiscJsPlugin, bgok parambgok) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.MiscJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */