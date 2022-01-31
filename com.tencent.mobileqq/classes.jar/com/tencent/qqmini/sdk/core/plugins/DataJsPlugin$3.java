package com.tencent.qqmini.sdk.core.plugins;

import bekr;
import betc;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class DataJsPlugin$3
  implements AsyncResult
{
  DataJsPlugin$3(DataJsPlugin paramDataJsPlugin, bekr parambekr) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    betc.a("DataJsPlugin", "onCmdListener() called with: isSuc = [" + paramBoolean + "], ret = [" + paramJSONObject + "]");
    if (paramBoolean)
    {
      this.val$req.a(paramJSONObject);
      return;
    }
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */