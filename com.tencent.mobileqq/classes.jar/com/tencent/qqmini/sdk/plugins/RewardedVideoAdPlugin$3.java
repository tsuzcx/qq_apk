package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONException;
import org.json.JSONObject;

class RewardedVideoAdPlugin$3
  implements Runnable
{
  RewardedVideoAdPlugin$3(RewardedVideoAdPlugin paramRewardedVideoAdPlugin, String paramString, boolean paramBoolean, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("state", "load");
        if (!TextUtils.isEmpty(this.val$compId)) {
          localJSONObject.put("compId", this.val$compId);
        }
        if (this.val$isSucc)
        {
          String str1 = "ok";
          localJSONObject.put("status", str1);
          RewardedVideoAdPlugin.access$1800(this.this$0, this.val$req, localJSONObject, "onRewardedVideoShowDone");
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      String str2 = "error";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RewardedVideoAdPlugin.3
 * JD-Core Version:    0.7.0.1
 */