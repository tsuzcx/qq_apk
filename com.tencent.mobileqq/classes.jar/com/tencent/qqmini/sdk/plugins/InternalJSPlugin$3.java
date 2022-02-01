package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class InternalJSPlugin$3
  implements InternalJSPlugin.OpenUrlCallback
{
  InternalJSPlugin$3(InternalJSPlugin paramInternalJSPlugin, RequestEvent paramRequestEvent) {}
  
  public void openResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.val$req.ok();
      return;
    }
    this.val$req.fail(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InternalJSPlugin.3
 * JD-Core Version:    0.7.0.1
 */