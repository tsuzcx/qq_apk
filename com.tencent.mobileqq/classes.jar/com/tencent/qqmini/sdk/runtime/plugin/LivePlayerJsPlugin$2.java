package com.tencent.qqmini.sdk.runtime.plugin;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import bgok;
import bhei;
import com.tencent.qqmini.sdk.runtime.widget.media.CoverLiveView;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import org.json.JSONObject;

class LivePlayerJsPlugin$2
  implements Runnable
{
  LivePlayerJsPlugin$2(LivePlayerJsPlugin paramLivePlayerJsPlugin, int paramInt, JSONObject paramJSONObject, bgok parambgok) {}
  
  public void run()
  {
    Object localObject1 = bhei.a(LivePlayerJsPlugin.access$700(this.this$0)).a(this.val$livePlayerId);
    if (!(localObject1 instanceof CoverLiveView)) {}
    do
    {
      do
      {
        return;
        localObject1 = (CoverLiveView)localObject1;
      } while (((CoverLiveView)localObject1).b());
      ((CoverLiveView)localObject1).a(this.val$jsonObject);
      localObject2 = this.val$jsonObject.optJSONObject("position");
    } while (localObject2 == null);
    float f = DisplayUtil.getDensity(LivePlayerJsPlugin.access$800(this.this$0));
    int k = ((JSONObject)localObject2).optInt("left");
    int i = ((JSONObject)localObject2).optInt("top");
    int j = ((JSONObject)localObject2).optInt("width");
    int m = ((JSONObject)localObject2).optInt("height");
    j = (int)(j * f + 0.5F);
    m = (int)(m * f + 0.5F);
    k = (int)(k * f + 0.5F);
    i = (int)(i * f + 0.5F);
    Object localObject2 = (FrameLayout.LayoutParams)((CoverLiveView)localObject1).getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).width = j;
    ((FrameLayout.LayoutParams)localObject2).height = m;
    ((FrameLayout.LayoutParams)localObject2).leftMargin = k;
    ((FrameLayout.LayoutParams)localObject2).topMargin = i;
    ((CoverLiveView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.val$req.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.LivePlayerJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */