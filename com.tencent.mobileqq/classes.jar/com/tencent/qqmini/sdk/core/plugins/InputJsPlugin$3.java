package com.tencent.qqmini.sdk.core.plugins;

import bgok;
import com.tencent.qqmini.sdk.core.widget.KeyboardLayout;

class InputJsPlugin$3
  implements Runnable
{
  InputJsPlugin$3(InputJsPlugin paramInputJsPlugin, bgok parambgok) {}
  
  public void run()
  {
    KeyboardLayout localKeyboardLayout = this.this$0.getKeyboard();
    if (localKeyboardLayout == null)
    {
      this.val$req.b();
      return;
    }
    InputJsPlugin.access$200(this.this$0, this.val$req, localKeyboardLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InputJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */