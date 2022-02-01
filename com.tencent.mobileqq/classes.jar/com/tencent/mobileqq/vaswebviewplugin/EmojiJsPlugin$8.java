package com.tencent.mobileqq.vaswebviewplugin;

import biod;
import bioy;
import bitr;
import bjbs;

class EmojiJsPlugin$8
  implements Runnable
{
  EmojiJsPlugin$8(EmojiJsPlugin paramEmojiJsPlugin) {}
  
  public void run()
  {
    biod localbiod = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localbiod != null) && ((localbiod instanceof bitr)))
    {
      this.this$0.progressDialog = new bjbs(this.this$0.mRuntime.a(), ((bitr)localbiod).getTitleBarHeight());
      this.this$0.progressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */