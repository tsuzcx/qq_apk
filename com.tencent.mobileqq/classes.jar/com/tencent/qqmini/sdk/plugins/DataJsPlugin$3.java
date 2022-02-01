package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.qqmini.sdk.R.dimen;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.widget.MiniToast;
import org.json.JSONObject;

class DataJsPlugin$3
  implements AsyncResult
{
  DataJsPlugin$3(DataJsPlugin paramDataJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (!paramBoolean)
    {
      this.val$req.fail();
      MiniToast.makeText(DataJsPlugin.access$100(this.this$0).getAttachedActivity(), 0, "网络异常，请检查网络", 1).show(DataJsPlugin.access$000(this.this$0).getAttachedActivity().getResources().getDimensionPixelSize(R.dimen.mini_sdk_title_bar_height));
      return;
    }
    this.val$req.ok();
    MiniToast.makeText(DataJsPlugin.access$300(this.this$0).getAttachedActivity(), 0, "关注公众号成功", 1).show(DataJsPlugin.access$200(this.this$0).getAttachedActivity().getResources().getDimensionPixelSize(R.dimen.mini_sdk_title_bar_height));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */