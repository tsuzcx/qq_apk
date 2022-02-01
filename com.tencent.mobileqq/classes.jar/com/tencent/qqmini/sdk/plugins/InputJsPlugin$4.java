package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.KeyboardLayout;

class InputJsPlugin$4
  implements Runnable
{
  InputJsPlugin$4(InputJsPlugin paramInputJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    KeyboardLayout localKeyboardLayout = this.this$0.getKeyboard();
    if (localKeyboardLayout == null)
    {
      this.val$req.fail();
      return;
    }
    InputJsPlugin.access$600(this.this$0, this.val$req, localKeyboardLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InputJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */