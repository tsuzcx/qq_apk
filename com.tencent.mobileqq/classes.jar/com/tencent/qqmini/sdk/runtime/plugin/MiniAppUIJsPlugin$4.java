package com.tencent.qqmini.sdk.runtime.plugin;

import bgok;
import com.tencent.qqmini.sdk.runtime.util.ToastMessage;

class MiniAppUIJsPlugin$4
  implements Runnable
{
  MiniAppUIJsPlugin$4(MiniAppUIJsPlugin paramMiniAppUIJsPlugin, bgok parambgok) {}
  
  public void run()
  {
    if (MiniAppUIJsPlugin.access$100(this.this$0) != null)
    {
      ToastMessage localToastMessage = ToastMessage.a();
      if (localToastMessage.c(MiniAppUIJsPlugin.access$800(this.this$0)))
      {
        localToastMessage.b(MiniAppUIJsPlugin.access$900(this.this$0));
        this.val$req.a();
        return;
      }
      this.val$req.a("toast can't be found");
      return;
    }
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.MiniAppUIJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */