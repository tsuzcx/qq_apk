package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class RewardedVideoAdPlugin$5
  implements Runnable
{
  RewardedVideoAdPlugin$5(RewardedVideoAdPlugin paramRewardedVideoAdPlugin, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "load");
      if (!TextUtils.isEmpty(this.val$compId)) {
        localJSONObject.put("compId", this.val$compId);
      }
      if (this.val$isSucc) {}
      for (String str = "ok";; str = "error")
      {
        localJSONObject.put("status", str);
        RewardedVideoAdPlugin.access$1600(this.this$0, localJSONObject, "onRewardedVideoShowDone");
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RewardedVideoAdPlugin.5
 * JD-Core Version:    0.7.0.1
 */