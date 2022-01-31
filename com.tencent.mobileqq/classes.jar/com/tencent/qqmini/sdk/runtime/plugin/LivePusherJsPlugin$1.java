package com.tencent.qqmini.sdk.runtime.plugin;

import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import bglv;
import bgml;
import bgok;
import bhei;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.runtime.widget.media.CoverPusherView;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class LivePusherJsPlugin$1
  implements Runnable
{
  LivePusherJsPlugin$1(LivePusherJsPlugin paramLivePusherJsPlugin, JSONObject paramJSONObject1, int paramInt, bgok parambgok, JSONObject paramJSONObject2) {}
  
  public void run()
  {
    Log.i("LivePusherJsPlugin", "insertLivePusher: " + this.val$jsonObject);
    Object localObject2 = bhei.a(LivePusherJsPlugin.access$000(this.this$0)).a(this.val$livePusherId);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new CoverPusherView(LivePusherJsPlugin.access$100(this.this$0));
      ((CoverPusherView)localObject1).setAtyRef(new WeakReference(LivePusherJsPlugin.access$200(this.this$0).a()));
      ((CoverPusherView)localObject1).setData(this.val$jsonObject.optString("data"));
      ((CoverPusherView)localObject1).setPageWebviewId(bgml.a(LivePusherJsPlugin.access$300(this.this$0)).a());
      ((CoverPusherView)localObject1).setLivePusherId(this.val$livePusherId);
      bhei.a(LivePusherJsPlugin.access$400(this.this$0)).a(0, this.val$livePusherId, (CoverView)localObject1, false);
    }
    if ((localObject1 instanceof CoverPusherView))
    {
      localObject1 = (CoverPusherView)localObject1;
      ((CoverPusherView)localObject1).a(this.val$req, this.val$jsonObject);
      localObject2 = this.val$jsonObject.optJSONObject("position");
      float f = DisplayUtil.getDensity(LivePusherJsPlugin.access$500(this.this$0));
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
        ((CoverPusherView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if (this.val$jsonObject.optBoolean("hide")) {
        ((CoverPusherView)localObject1).setVisibility(8);
      }
    }
    this.val$req.a(this.val$result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.LivePusherJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */