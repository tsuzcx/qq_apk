package com.tencent.qqmini.sdk.runtime.plugin;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import bgkd;
import bhab;
import com.tencent.qqmini.sdk.runtime.widget.media.CoverPusherView;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import org.json.JSONObject;

class LivePusherJsPlugin$2
  implements Runnable
{
  LivePusherJsPlugin$2(LivePusherJsPlugin paramLivePusherJsPlugin, int paramInt, JSONObject paramJSONObject, bgkd parambgkd) {}
  
  public void run()
  {
    Object localObject1 = bhab.a(LivePusherJsPlugin.access$600(this.this$0)).a(this.val$livePusherId);
    if (!(localObject1 instanceof CoverPusherView)) {}
    do
    {
      return;
      localObject1 = (CoverPusherView)localObject1;
      ((CoverPusherView)localObject1).a(this.val$jsonObject);
      localObject2 = this.val$jsonObject.optJSONObject("position");
    } while (localObject2 == null);
    float f = DisplayUtil.getDensity(LivePusherJsPlugin.access$700(this.this$0));
    int k = ((JSONObject)localObject2).optInt("left");
    int i = ((JSONObject)localObject2).optInt("top");
    int j = ((JSONObject)localObject2).optInt("width");
    int m = ((JSONObject)localObject2).optInt("height");
    j = (int)(j * f + 0.5F);
    m = (int)(m * f + 0.5F);
    k = (int)(k * f + 0.5F);
    i = (int)(i * f + 0.5F);
    Object localObject2 = (FrameLayout.LayoutParams)((CoverPusherView)localObject1).getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).width = j;
    ((FrameLayout.LayoutParams)localObject2).height = m;
    ((FrameLayout.LayoutParams)localObject2).leftMargin = k;
    ((FrameLayout.LayoutParams)localObject2).topMargin = i;
    ((CoverPusherView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.val$req.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.LivePusherJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */