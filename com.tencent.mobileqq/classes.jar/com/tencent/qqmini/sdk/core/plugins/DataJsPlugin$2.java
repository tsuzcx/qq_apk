package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.res.Resources;
import begz;
import beka;
import bemw;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class DataJsPlugin$2
  implements AsyncResult
{
  DataJsPlugin$2(DataJsPlugin paramDataJsPlugin, beka parambeka) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (!paramBoolean)
    {
      this.val$req.b();
      bemw.a(this.this$0.mMiniAppContext.a(), 0, "网络异常，请检查网络", 1).b(this.this$0.mMiniAppContext.a().getResources().getDimensionPixelSize(2131297229));
      return;
    }
    this.val$req.a();
    bemw.a(this.this$0.mMiniAppContext.a(), 0, "关注公众号成功", 1).b(this.this$0.mMiniAppContext.a().getResources().getDimensionPixelSize(2131297229));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */