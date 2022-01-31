package com.tencent.mobileqq.vaswebviewplugin;

import begg;
import begz;
import bels;
import bety;

class EmojiJsPlugin$8
  implements Runnable
{
  EmojiJsPlugin$8(EmojiJsPlugin paramEmojiJsPlugin) {}
  
  public void run()
  {
    begg localbegg = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localbegg != null) && ((localbegg instanceof bels)))
    {
      this.this$0.progressDialog = new bety(this.this$0.mRuntime.a(), ((bels)localbegg).b());
      this.this$0.progressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */