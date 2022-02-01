package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.ToastView;

class UIJsPlugin$2
  implements Runnable
{
  UIJsPlugin$2(UIJsPlugin paramUIJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if ((UIJsPlugin.access$500(this.this$0) != null) && (UIJsPlugin.access$500(this.this$0).shown()))
    {
      if (UIJsPlugin.access$500(this.this$0) != null) {
        UIJsPlugin.access$500(this.this$0).hide();
      }
      this.val$req.ok();
      return;
    }
    this.val$req.fail("toast can't be found");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.UIJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */