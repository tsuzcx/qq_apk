package com.tencent.mobileqq.vaswebviewplugin;

import bhni;
import bhod;
import bhsw;
import biau;

class EmojiJsPlugin$8
  implements Runnable
{
  EmojiJsPlugin$8(EmojiJsPlugin paramEmojiJsPlugin) {}
  
  public void run()
  {
    bhni localbhni = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localbhni != null) && ((localbhni instanceof bhsw)))
    {
      this.this$0.progressDialog = new biau(this.this$0.mRuntime.a(), ((bhsw)localbhni).getTitleBarHeight());
      this.this$0.progressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */