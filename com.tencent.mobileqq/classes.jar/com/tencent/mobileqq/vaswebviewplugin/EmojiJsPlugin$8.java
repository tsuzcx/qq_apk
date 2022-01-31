package com.tencent.mobileqq.vaswebviewplugin;

import bccw;
import bcdp;
import bcii;
import bcqf;

class EmojiJsPlugin$8
  implements Runnable
{
  EmojiJsPlugin$8(EmojiJsPlugin paramEmojiJsPlugin) {}
  
  public void run()
  {
    bccw localbccw = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localbccw != null) && ((localbccw instanceof bcii)))
    {
      this.this$0.progressDialog = new bcqf(this.this$0.mRuntime.a(), ((bcii)localbccw).b());
      this.this$0.progressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */