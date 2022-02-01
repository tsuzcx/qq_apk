package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONException;
import org.json.JSONObject;

class RewardedVideoAdPlugin$4
  implements Runnable
{
  RewardedVideoAdPlugin$4(RewardedVideoAdPlugin paramRewardedVideoAdPlugin, String paramString, boolean paramBoolean, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("state", "show");
        if (!TextUtils.isEmpty(this.a)) {
          localJSONObject.put("compId", this.a);
        }
        if (this.b)
        {
          String str1 = "ok";
          localJSONObject.put("status", str1);
          RewardedVideoAdPlugin.access$1800(this.this$0, this.c, localJSONObject, "onRewardedVideoShowDone");
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
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RewardedVideoAdPlugin.4
 * JD-Core Version:    0.7.0.1
 */