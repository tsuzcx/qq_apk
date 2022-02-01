package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class BlockAdPlugin$2
  implements Runnable
{
  BlockAdPlugin$2(BlockAdPlugin paramBlockAdPlugin, BlockAdInfo paramBlockAdInfo, int paramInt, JsRuntime paramJsRuntime) {}
  
  public void run()
  {
    boolean bool = ((GameActivity)this.this$0.jsPluginEngine.activityContext).showBlockAd(this.val$adInfo);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "show");
      if (bool) {}
      for (String str = "ok";; str = "error")
      {
        localJSONObject.put("status", str);
        localJSONObject.put("compId", this.val$compId);
        BlockAdPlugin.access$000(this.this$0, this.val$webview, localJSONObject, "onBlockAdShowDone");
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      BlockAdPlugin.access$200(this.this$0, this.val$webview, 1003, (String)BlockAdPlugin.access$100().get(Integer.valueOf(1003)), this.val$compId);
      QLog.i("[minigame] BlockAdPlugin", 2, "handle operateBannerAd show error", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BlockAdPlugin.2
 * JD-Core Version:    0.7.0.1
 */