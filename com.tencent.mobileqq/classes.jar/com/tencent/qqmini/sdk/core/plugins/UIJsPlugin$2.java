package com.tencent.qqmini.sdk.core.plugins;

import beka;
import bemw;
import bene;

class UIJsPlugin$2
  implements Runnable
{
  UIJsPlugin$2(UIJsPlugin paramUIJsPlugin, beka parambeka) {}
  
  public void run()
  {
    if (((UIJsPlugin.access$000(this.this$0) != null) && (UIJsPlugin.access$000(this.this$0).a())) || (UIJsPlugin.access$100(this.this$0) != null))
    {
      if (UIJsPlugin.access$000(this.this$0) != null) {
        UIJsPlugin.access$000(this.this$0).a();
      }
      if (UIJsPlugin.access$100(this.this$0) != null) {
        UIJsPlugin.access$100(this.this$0).a();
      }
      this.val$req.a();
      return;
    }
    this.val$req.a("toast can't be found");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.UIJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */