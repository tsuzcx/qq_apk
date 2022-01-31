package com.tencent.qqmini.sdk.core.plugins;

import bekr;

class MiscJsPlugin$2
  implements MiscJsPlugin.OpenUrlCallback
{
  MiscJsPlugin$2(MiscJsPlugin paramMiscJsPlugin, bekr parambekr) {}
  
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
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.MiscJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */