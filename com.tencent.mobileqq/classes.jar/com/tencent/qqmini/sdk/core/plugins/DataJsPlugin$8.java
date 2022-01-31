package com.tencent.qqmini.sdk.core.plugins;

import bgkd;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class DataJsPlugin$8
  implements AsyncResult
{
  DataJsPlugin$8(DataJsPlugin paramDataJsPlugin, bgkd parambgkd) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null)) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (this.this$0.mIsMiniGame) {
          localJSONObject.put("data", paramJSONObject);
        }
        for (;;)
        {
          this.val$req.a(localJSONObject);
          return;
          localJSONObject.put("data", paramJSONObject.toString());
        }
        this.val$req.b();
      }
      catch (Throwable paramJSONObject) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */