package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import org.json.JSONException;
import org.json.JSONObject;

class UIJsPlugin$4
  implements Runnable
{
  UIJsPlugin$4(UIJsPlugin paramUIJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      Object localObject = UIJsPlugin.access$700(this.this$0).getAttachedActivity();
      if ((localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        JSONObject localJSONObject = new JSONObject(this.val$req.jsonParams);
        String str = localJSONObject.optString("title", "");
        boolean bool = localJSONObject.optBoolean("mask", false);
        if (UIJsPlugin.access$200(this.this$0, UIJsPlugin.access$100(this.this$0))) {
          UIJsPlugin.access$800(this.this$0);
        }
        UIJsPlugin.access$102(this.this$0, PageAction.obtain(UIJsPlugin.access$900(this.this$0)).getPageUrl());
        if (UIJsPlugin.access$200(this.this$0, UIJsPlugin.access$100(this.this$0)))
        {
          UIJsPlugin.access$602(this.this$0, new ToastView((Context)localObject, (ViewGroup)((Activity)localObject).findViewById(16908290)));
          UIJsPlugin.access$600(this.this$0).show(1, "loading", null, str, -1, bool);
          this.val$req.ok();
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showLoading event=");
        ((StringBuilder)localObject).append(this.val$req.event);
        ((StringBuilder)localObject).append("， top page not found");
        QMLog.w("UIJsPlugin", ((StringBuilder)localObject).toString());
        this.val$req.fail();
        return;
      }
      QMLog.w("UIJsPlugin", "showLoading(). Do nothing, activity is null or finishing");
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("UIJsPlugin", localJSONException.getMessage(), localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.UIJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */