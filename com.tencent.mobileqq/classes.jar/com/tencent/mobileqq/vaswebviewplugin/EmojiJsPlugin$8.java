package com.tencent.mobileqq.vaswebviewplugin;

import bcci;
import bcdb;
import bchu;
import bcpq;

class EmojiJsPlugin$8
  implements Runnable
{
  EmojiJsPlugin$8(EmojiJsPlugin paramEmojiJsPlugin) {}
  
  public void run()
  {
    bcci localbcci = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localbcci != null) && ((localbcci instanceof bchu)))
    {
      this.this$0.progressDialog = new bcpq(this.this$0.mRuntime.a(), ((bchu)localbcci).b());
      this.this$0.progressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */