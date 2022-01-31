package com.tencent.qqmini.sdk.minigame.plugins;

import behp;
import bekr;
import org.json.JSONException;
import org.json.JSONObject;

class SubpackageJsPlugin$1$2
  implements Runnable
{
  SubpackageJsPlugin$1$2(SubpackageJsPlugin.1 param1, float paramFloat, long paramLong) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("taskId", this.this$1.val$loadTaskId);
      localJSONObject.put("state", "progressUpdate");
      localJSONObject.put("progress", this.val$progress * 100.0F);
      localJSONObject.put("totalBytesWritten", ((float)this.val$totalSize * this.val$progress));
      localJSONObject.put("totalBytesExpectedToWrite", this.val$totalSize);
      this.this$1.val$req.a.a("onLoadSubPackageTaskStateChange", localJSONObject.toString(), -1);
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
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.SubpackageJsPlugin.1.2
 * JD-Core Version:    0.7.0.1
 */