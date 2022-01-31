package com.tencent.qqmini.sdk.core.plugins;

import bekr;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class DataJsPlugin$1
  implements AsyncResult
{
  DataJsPlugin$1(DataJsPlugin paramDataJsPlugin, bekr parambekr) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      this.val$req.a(paramJSONObject);
      return;
    }
    this.val$req.a("can not use camera");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */