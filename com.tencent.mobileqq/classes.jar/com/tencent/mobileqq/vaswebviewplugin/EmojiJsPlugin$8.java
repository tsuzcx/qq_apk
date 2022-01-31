package com.tencent.mobileqq.vaswebviewplugin;

import bazo;
import bbac;
import bbeu;
import bbms;

class EmojiJsPlugin$8
  implements Runnable
{
  EmojiJsPlugin$8(EmojiJsPlugin paramEmojiJsPlugin) {}
  
  public void run()
  {
    bazo localbazo = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localbazo != null) && ((localbazo instanceof bbeu)))
    {
      this.this$0.progressDialog = new bbms(this.this$0.mRuntime.a(), ((bbeu)localbazo).b());
      this.this$0.progressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */