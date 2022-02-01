package com.tencent.qqmini.miniapp.plugin;

import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.miniapp.widget.media.CoverPusherView;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class LivePusherJsPlugin$1
  implements Runnable
{
  LivePusherJsPlugin$1(LivePusherJsPlugin paramLivePusherJsPlugin, JSONObject paramJSONObject1, int paramInt, RequestEvent paramRequestEvent, JSONObject paramJSONObject2) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("insertLivePusher: ");
    ((StringBuilder)localObject1).append(this.val$jsonObject);
    Log.i("LivePusherJsPlugin", ((StringBuilder)localObject1).toString());
    Object localObject2 = CoverViewAction.obtain(LivePusherJsPlugin.access$000(this.this$0)).get(this.val$livePusherId);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new CoverPusherView(LivePusherJsPlugin.access$100(this.this$0));
      ((CoverPusherView)localObject1).setAtyRef(new WeakReference(LivePusherJsPlugin.access$200(this.this$0).getAttachedActivity()));
      ((CoverPusherView)localObject1).setData(this.val$jsonObject.optString("data"));
      ((CoverPusherView)localObject1).setPageWebviewId(PageAction.obtain(LivePusherJsPlugin.access$300(this.this$0)).getPageId());
      ((CoverPusherView)localObject1).setLivePusherId(this.val$livePusherId);
      CoverViewAction.obtain(LivePusherJsPlugin.access$400(this.this$0)).add(0, this.val$livePusherId, (CoverView)localObject1, false);
    }
    if ((localObject1 instanceof CoverPusherView))
    {
      localObject1 = (CoverPusherView)localObject1;
      ((CoverPusherView)localObject1).setMiniAppContext(LivePusherJsPlugin.access$500(this.this$0));
      ((CoverPusherView)localObject1).initLivePusherSettings(this.val$req, this.val$jsonObject);
      localObject2 = this.val$jsonObject.optJSONObject("position");
      float f = DisplayUtil.getDensity(LivePusherJsPlugin.access$600(this.this$0));
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
    this.val$req.ok(this.val$result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePusherJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */