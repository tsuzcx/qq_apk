package com.tencent.mobileqq.vaswebviewplugin;

import bebx;
import becq;
import behj;
import bepp;

class EmojiJsPlugin$8
  implements Runnable
{
  EmojiJsPlugin$8(EmojiJsPlugin paramEmojiJsPlugin) {}
  
  public void run()
  {
    bebx localbebx = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localbebx != null) && ((localbebx instanceof behj)))
    {
      this.this$0.progressDialog = new bepp(this.this$0.mRuntime.a(), ((behj)localbebx).b());
      this.this$0.progressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */