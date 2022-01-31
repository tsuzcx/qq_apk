package com.tencent.qqmini.sdk.core.plugins;

import bekr;

class InternalJSPlugin$3
  implements InternalJSPlugin.openUrlCallback
{
  InternalJSPlugin$3(InternalJSPlugin paramInternalJSPlugin, bekr parambekr) {}
  
  public void openResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.val$req.a();
      return;
    }
    this.val$req.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InternalJSPlugin.3
 * JD-Core Version:    0.7.0.1
 */