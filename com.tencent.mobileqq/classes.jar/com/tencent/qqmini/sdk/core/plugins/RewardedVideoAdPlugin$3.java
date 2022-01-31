package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import beka;
import org.json.JSONException;
import org.json.JSONObject;

class RewardedVideoAdPlugin$3
  implements Runnable
{
  RewardedVideoAdPlugin$3(RewardedVideoAdPlugin paramRewardedVideoAdPlugin, String paramString, boolean paramBoolean, beka parambeka) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "show");
      if (!TextUtils.isEmpty(this.val$compId)) {
        localJSONObject.put("compId", this.val$compId);
      }
      if (this.val$isSucc) {}
      for (String str = "ok";; str = "error")
      {
        localJSONObject.put("status", str);
        RewardedVideoAdPlugin.access$800(this.this$0, this.val$req, localJSONObject, "onRewardedVideoShowDone");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RewardedVideoAdPlugin.3
 * JD-Core Version:    0.7.0.1
 */