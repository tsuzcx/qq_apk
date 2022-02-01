package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONException;
import org.json.JSONObject;

class RewardedVideoAdPlugin$2
  implements Runnable
{
  RewardedVideoAdPlugin$2(RewardedVideoAdPlugin paramRewardedVideoAdPlugin, String paramString, boolean paramBoolean, RequestEvent paramRequestEvent) {}
  
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
        RewardedVideoAdPlugin.access$1600(this.this$0, this.val$req, localJSONObject, "onRewardedVideoShowDone");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RewardedVideoAdPlugin.2
 * JD-Core Version:    0.7.0.1
 */