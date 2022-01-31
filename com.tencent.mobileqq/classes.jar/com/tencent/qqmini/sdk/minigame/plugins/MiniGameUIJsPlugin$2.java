package com.tencent.qqmini.sdk.minigame.plugins;

import bgok;
import bgrm;
import bgsd;

class MiniGameUIJsPlugin$2
  implements Runnable
{
  MiniGameUIJsPlugin$2(MiniGameUIJsPlugin paramMiniGameUIJsPlugin, bgok parambgok) {}
  
  public void run()
  {
    if (((MiniGameUIJsPlugin.access$100(this.this$0) != null) && (MiniGameUIJsPlugin.access$100(this.this$0).a())) || (MiniGameUIJsPlugin.access$200(this.this$0) != null))
    {
      if (MiniGameUIJsPlugin.access$100(this.this$0) != null) {
        MiniGameUIJsPlugin.access$100(this.this$0).a();
      }
      if (MiniGameUIJsPlugin.access$200(this.this$0) != null) {
        MiniGameUIJsPlugin.access$200(this.this$0).a();
      }
      this.val$req.a();
      return;
    }
    this.val$req.a("toast can't be found");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.MiniGameUIJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */