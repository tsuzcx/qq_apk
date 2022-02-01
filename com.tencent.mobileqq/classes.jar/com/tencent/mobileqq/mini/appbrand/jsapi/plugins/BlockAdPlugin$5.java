package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.manager.BlockAdManager;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.widget.BlockAdView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class BlockAdPlugin$5
  implements Runnable
{
  BlockAdPlugin$5(BlockAdPlugin paramBlockAdPlugin, int paramInt1, BlockAdInfo paramBlockAdInfo, JsRuntime paramJsRuntime, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    Object localObject = BlockAdManager.getInstance().getBlockAdView(this.val$compId);
    if (localObject != null)
    {
      ((BlockAdView)localObject).setData(this.val$currentPosInfo);
      if (((BlockAdView)localObject).getRealAdNum() < 1)
      {
        BlockAdPlugin.access$200(this.this$0, this.val$webview, 1009, (String)BlockAdPlugin.access$100().get(Integer.valueOf(1009)), this.val$currentPosInfo.getCompId());
        return;
      }
    }
    for (boolean bool = ((GameActivity)this.this$0.jsPluginEngine.activityContext).updateBlockAdPosition(this.val$replaceLeft, this.val$replaceTop, this.val$compId);; bool = false)
    {
      if (bool) {
        ((BlockAdView)localObject).startBlockAnimation();
      }
      for (;;)
      {
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("state", "resize");
          ((JSONObject)localObject).put("compId", this.val$currentPosInfo.getCompId());
          ((JSONObject)localObject).put("width", this.val$currentPosInfo.getRealWidth());
          ((JSONObject)localObject).put("height", this.val$currentPosInfo.getRealHeight());
          BlockAdPlugin.access$000(this.this$0, this.val$webview, (JSONObject)localObject, "onBlockAdStateChange");
          QLog.i("[minigame] BlockAdPlugin", 1, "updateBlockAd " + bool + ", replaceLeft = " + this.val$replaceLeft + ", replaceTop = " + this.val$replaceTop);
          return;
        }
        catch (JSONException localJSONException)
        {
          QLog.e("[minigame] BlockAdPlugin", 1, "updateBannerAd informJs error", localJSONException);
          continue;
        }
        BlockAdPlugin.access$200(this.this$0, this.val$webview, 1003, (String)BlockAdPlugin.access$100().get(Integer.valueOf(1003)), this.val$currentPosInfo.getCompId());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BlockAdPlugin.5
 * JD-Core Version:    0.7.0.1
 */