package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.res.Resources;
import bgho;
import bgkd;
import bgnf;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class DataJsPlugin$2
  implements AsyncResult
{
  DataJsPlugin$2(DataJsPlugin paramDataJsPlugin, bgkd parambgkd) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (!paramBoolean)
    {
      this.val$req.b();
      bgnf.a(this.this$0.mMiniAppContext.a(), 0, "网络异常，请检查网络", 1).b(this.this$0.mMiniAppContext.a().getResources().getDimensionPixelSize(2131297248));
      return;
    }
    this.val$req.a();
    bgnf.a(this.this$0.mMiniAppContext.a(), 0, "关注公众号成功", 1).b(this.this$0.mMiniAppContext.a().getResources().getDimensionPixelSize(2131297248));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */