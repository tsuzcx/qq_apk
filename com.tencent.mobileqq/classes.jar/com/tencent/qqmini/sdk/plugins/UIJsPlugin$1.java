package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
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
    Activity localActivity = UIJsPlugin.access$000(this.this$0).getAttachedActivity();
    if ((localActivity == null) || (localActivity.isFinishing()))
    {
      QMLog.w("UIJsPlugin", "showToast(). Do nothing, activity is null or finishing");
      return;
    }
    if (UIJsPlugin.access$200(this.this$0, UIJsPlugin.access$100(this.this$0))) {
      UIJsPlugin.access$300(this.this$0);
    }
    UIJsPlugin.access$102(this.this$0, PageAction.obtain(UIJsPlugin.access$400(this.this$0)).getPageUrl());
    if (UIJsPlugin.access$200(this.this$0, UIJsPlugin.access$100(this.this$0)))
    {
      UIJsPlugin.access$502(this.this$0, new ToastView(localActivity, (ViewGroup)localActivity.findViewById(16908290)));
      UIJsPlugin.access$500(this.this$0).show(0, this.val$icon, this.val$imagePath, this.val$title, this.val$duration, this.val$mask);
      this.val$req.ok();
      return;
    }
    QMLog.w("UIJsPlugin", "showToast event=" + this.val$req.event + "， top page not found");
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.UIJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */