package com.tencent.qqmini.sdk.core.plugins;

import bekr;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class ShareJsPlugin$1
  implements AsyncResult
{
  ShareJsPlugin$1(ShareJsPlugin paramShareJsPlugin, bekr parambekr) {}
  
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
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ShareJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */