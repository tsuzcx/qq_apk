package com.tencent.qqmini.sdk.core.plugins;

import bdfz;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class ShareJsPlugin$4
  implements AsyncResult
{
  ShareJsPlugin$4(ShareJsPlugin paramShareJsPlugin, bdfz parambdfz) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramJSONObject.optBoolean("needShareCallback"))
    {
      this.val$req.a();
      return;
    }
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ShareJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */