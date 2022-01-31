package com.tencent.qqmini.sdk.core.plugins;

import bgkd;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class DataJsPlugin$9
  implements AsyncResult
{
  DataJsPlugin$9(DataJsPlugin paramDataJsPlugin, bgkd parambgkd) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      this.val$req.a(paramJSONObject);
      return;
    }
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */