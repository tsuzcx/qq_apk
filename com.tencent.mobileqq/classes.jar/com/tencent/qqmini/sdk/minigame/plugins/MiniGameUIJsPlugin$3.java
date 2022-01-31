package com.tencent.qqmini.sdk.minigame.plugins;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import bglv;
import bgok;
import bgsd;
import org.json.JSONException;
import org.json.JSONObject;

class MiniGameUIJsPlugin$3
  implements Runnable
{
  MiniGameUIJsPlugin$3(MiniGameUIJsPlugin paramMiniGameUIJsPlugin, bgok parambgok) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject(this.val$req.b);
      String str = ((JSONObject)localObject).optString("title", "");
      boolean bool = ((JSONObject)localObject).optBoolean("mask", false);
      localObject = MiniGameUIJsPlugin.access$300(this.this$0).a();
      if (localObject != null)
      {
        if (MiniGameUIJsPlugin.access$100(this.this$0) != null) {
          break label110;
        }
        MiniGameUIJsPlugin.access$102(this.this$0, new bgsd((Context)localObject, (ViewGroup)((Activity)localObject).findViewById(16908290)));
      }
      for (;;)
      {
        MiniGameUIJsPlugin.access$100(this.this$0).a(1, "loading", null, str, -1, bool);
        this.val$req.a();
        return;
        label110:
        MiniGameUIJsPlugin.access$100(this.this$0).a();
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MiniGameUIJsPlugin", localJSONException.getMessage(), localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.MiniGameUIJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */