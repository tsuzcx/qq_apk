package com.tencent.qqmini.sdk.core.plugins;

import behq;
import belx;
import bfgl;
import com.tencent.qqmini.sdk.core.widget.KeyboardLayout;

class InputJsPlugin$4
  implements belx
{
  InputJsPlugin$4(InputJsPlugin paramInputJsPlugin) {}
  
  public void onSoftKeyboardClosed()
  {
    if ((InputJsPlugin.access$300(this.this$0) != null) && (InputJsPlugin.access$300(this.this$0).getVisibility() == 0)) {
      InputJsPlugin.access$300(this.this$0).setVisibility(8);
    }
    if ((this.this$0.mMiniAppContext != null) && (this.this$0.mMiniAppContext.a() != null)) {
      bfgl.a(this.this$0.mMiniAppContext.a());
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if ((InputJsPlugin.access$300(this.this$0) != null) && (InputJsPlugin.access$300(this.this$0).getVisibility() == 0)) {
      InputJsPlugin.access$300(this.this$0).setPaddingBottom(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InputJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */