package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.ToastView;

class UIJsPlugin$1
  implements Runnable
{
  UIJsPlugin$1(UIJsPlugin paramUIJsPlugin, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    Object localObject = UIJsPlugin.access$000(this.this$0).getAttachedActivity();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      UIJsPlugin localUIJsPlugin = this.this$0;
      if (UIJsPlugin.access$200(localUIJsPlugin, UIJsPlugin.access$100(localUIJsPlugin))) {
        UIJsPlugin.access$300(this.this$0);
      }
      localUIJsPlugin = this.this$0;
      UIJsPlugin.access$102(localUIJsPlugin, PageAction.obtain(UIJsPlugin.access$400(localUIJsPlugin)).getPageUrl());
      localUIJsPlugin = this.this$0;
      if (UIJsPlugin.access$200(localUIJsPlugin, UIJsPlugin.access$100(localUIJsPlugin)))
      {
        UIJsPlugin.access$502(this.this$0, new ToastView((Context)localObject, (ViewGroup)((Activity)localObject).findViewById(16908290)));
        UIJsPlugin.access$500(this.this$0).show(0, this.val$icon, this.val$imagePath, this.val$title, this.val$duration, this.val$mask);
        this.val$req.ok();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showToast event=");
      ((StringBuilder)localObject).append(this.val$req.event);
      ((StringBuilder)localObject).append("， top page not found");
      QMLog.w("UIJsPlugin", ((StringBuilder)localObject).toString());
      this.val$req.fail();
      return;
    }
    QMLog.w("UIJsPlugin", "showToast(). Do nothing, activity is null or finishing");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.UIJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */