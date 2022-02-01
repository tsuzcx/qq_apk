package com.tencent.mobileqq.vaswebviewplugin;

import bifb;
import bifw;
import bikl;
import bisl;

class EmojiJsPlugin$8
  implements Runnable
{
  EmojiJsPlugin$8(EmojiJsPlugin paramEmojiJsPlugin) {}
  
  public void run()
  {
    bifb localbifb = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localbifb != null) && ((localbifb instanceof bikl)))
    {
      this.this$0.progressDialog = new bisl(this.this$0.mRuntime.a(), ((bikl)localbifb).getTitleBarHeight());
      this.this$0.progressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */