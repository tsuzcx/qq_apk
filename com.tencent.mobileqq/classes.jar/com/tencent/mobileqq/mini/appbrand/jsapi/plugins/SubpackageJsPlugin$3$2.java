package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class SubpackageJsPlugin$3$2
  implements Runnable
{
  SubpackageJsPlugin$3$2(SubpackageJsPlugin.3 param3, float paramFloat, long paramLong) {}
  
  public void run()
  {
    JsRuntime localJsRuntime = (JsRuntime)this.this$1.val$webviewRef.get();
    if (localJsRuntime == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("taskId", this.this$1.val$taskId);
      localJSONObject.put("state", "progressUpdate");
      localJSONObject.put("progress", this.val$progress * 100.0F);
      localJSONObject.put("totalBytesWritten", ((float)this.val$totalSize * this.val$progress));
      localJSONObject.put("totalBytesExpectedToWrite", this.val$totalSize);
      localJsRuntime.evaluateSubcribeJS("onLoadSubPackageTaskStateChange", localJSONObject.toString(), -1);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SubpackageJsPlugin.3.2
 * JD-Core Version:    0.7.0.1
 */