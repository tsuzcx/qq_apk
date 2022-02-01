package com.tencent.qqmini.miniapp.plugin;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.miniapp.widget.media.CoverLiveView;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import org.json.JSONObject;

class LivePlayerJsPlugin$2
  implements Runnable
{
  LivePlayerJsPlugin$2(LivePlayerJsPlugin paramLivePlayerJsPlugin, int paramInt, JSONObject paramJSONObject, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    Object localObject1 = CoverViewAction.obtain(LivePlayerJsPlugin.access$800(this.this$0)).get(this.val$livePlayerId);
    if (!(localObject1 instanceof CoverLiveView)) {
      return;
    }
    localObject1 = (CoverLiveView)localObject1;
    ((CoverLiveView)localObject1).updateLivePlayerSettings(this.val$jsonObject);
    if (!((CoverLiveView)localObject1).isFullScreen())
    {
      Object localObject2 = this.val$jsonObject.optJSONObject("position");
      if (localObject2 == null) {
        return;
      }
      float f = DisplayUtil.getDensity(LivePlayerJsPlugin.access$900(this.this$0));
      int k = ((JSONObject)localObject2).optInt("left");
      int i = ((JSONObject)localObject2).optInt("top");
      int j = ((JSONObject)localObject2).optInt("width");
      int m = ((JSONObject)localObject2).optInt("height");
      j = (int)(j * f + 0.5F);
      m = (int)(m * f + 0.5F);
      k = (int)(k * f + 0.5F);
      i = (int)(f * i + 0.5F);
      localObject2 = (FrameLayout.LayoutParams)((CoverLiveView)localObject1).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject2).width = j;
      ((FrameLayout.LayoutParams)localObject2).height = m;
      ((FrameLayout.LayoutParams)localObject2).leftMargin = k;
      ((FrameLayout.LayoutParams)localObject2).topMargin = i;
      ((CoverLiveView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePlayerJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */