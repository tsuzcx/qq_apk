package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import begz;
import beka;
import bene;
import org.json.JSONException;
import org.json.JSONObject;

class UIJsPlugin$3
  implements Runnable
{
  UIJsPlugin$3(UIJsPlugin paramUIJsPlugin, beka parambeka) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject(this.val$req.b);
      String str = ((JSONObject)localObject).optString("title", "");
      boolean bool = ((JSONObject)localObject).optBoolean("mask", false);
      localObject = this.this$0.mMiniAppContext.a();
      if (UIJsPlugin.access$000(this.this$0) == null) {
        UIJsPlugin.access$002(this.this$0, new bene((Context)localObject, (ViewGroup)((Activity)localObject).findViewById(16908290)));
      }
      for (;;)
      {
        UIJsPlugin.access$000(this.this$0).a(1, "loading", null, str, -1, bool);
        this.val$req.a();
        return;
        UIJsPlugin.access$000(this.this$0).a();
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("UIJsPlugin", localJSONException.getMessage(), localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.UIJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */