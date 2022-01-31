package com.tencent.qqmini.sdk.runtime.plugin;

import bgic;
import bgie;
import bgkd;

class MiniAppUIJsPlugin$5
  implements Runnable
{
  MiniAppUIJsPlugin$5(MiniAppUIJsPlugin paramMiniAppUIJsPlugin, bgkd parambgkd) {}
  
  public void run()
  {
    if (bgie.a(MiniAppUIJsPlugin.access$1000(this.this$0)).a() != null)
    {
      bgic.a(MiniAppUIJsPlugin.access$1100(this.this$0)).showRestart = false;
      this.val$req.a();
      return;
    }
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.MiniAppUIJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */