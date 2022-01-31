package com.tencent.qqmini.sdk.runtime.plugin;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import bghl;
import bgho;
import bgkd;
import bhab;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.runtime.widget.media.CoverLiveView;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class LivePlayerJsPlugin$1
  implements Runnable
{
  LivePlayerJsPlugin$1(LivePlayerJsPlugin paramLivePlayerJsPlugin, int paramInt, JSONObject paramJSONObject1, bgkd parambgkd, JSONObject paramJSONObject2) {}
  
  public void run()
  {
    Object localObject2 = bhab.a(LivePlayerJsPlugin.access$000(this.this$0)).a(this.val$livePlayerId);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new CoverLiveView(LivePlayerJsPlugin.access$100(this.this$0));
      ((CoverLiveView)localObject1).setAtyRef(new WeakReference(LivePlayerJsPlugin.access$200(this.this$0).a()));
      ((CoverLiveView)localObject1).setData(this.val$jsonObject.optString("data"));
      ((CoverLiveView)localObject1).setBaseRuntime((bghl)LivePlayerJsPlugin.access$300(this.this$0));
      ((CoverLiveView)localObject1).setPageWebviewId(LivePlayerJsPlugin.access$400(this.this$0));
      ((CoverLiveView)localObject1).setLivePlayerId(this.val$livePlayerId);
      bhab.a(LivePlayerJsPlugin.access$500(this.this$0)).a(0, this.val$livePlayerId, (CoverView)localObject1, false);
    }
    if ((localObject1 instanceof CoverLiveView))
    {
      localObject1 = (CoverLiveView)localObject1;
      ((CoverLiveView)localObject1).a(this.val$req, this.val$jsonObject);
      localObject2 = this.val$jsonObject.optJSONObject("position");
      float f = DisplayUtil.getDensity(LivePlayerJsPlugin.access$600(this.this$0));
      if (localObject2 != null)
      {
        int k = ((JSONObject)localObject2).optInt("left");
        int i = ((JSONObject)localObject2).optInt("top");
        int j = ((JSONObject)localObject2).optInt("width");
        int m = ((JSONObject)localObject2).optInt("height");
        j = (int)(j * f + 0.5F);
        m = (int)(m * f + 0.5F);
        k = (int)(k * f + 0.5F);
        i = (int)(f * i + 0.5F);
        localObject2 = new FrameLayout.LayoutParams(j, m);
        ((FrameLayout.LayoutParams)localObject2).leftMargin = k;
        ((FrameLayout.LayoutParams)localObject2).topMargin = i;
        ((CoverLiveView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if (this.val$jsonObject.optBoolean("hide")) {
        ((CoverLiveView)localObject1).setVisibility(8);
      }
    }
    this.val$req.a(this.val$result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.LivePlayerJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */