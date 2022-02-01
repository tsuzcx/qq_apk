package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

class InputAwareWebView$1
  implements Runnable
{
  InputAwareWebView$1(InputAwareWebView paramInputAwareWebView, View paramView) {}
  
  public void run()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.this$0.getContext().getSystemService("input_method");
    this.val$targetView.onWindowFocusChanged(true);
    localInputMethodManager.isActive(InputAwareWebView.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.InputAwareWebView.1
 * JD-Core Version:    0.7.0.1
 */