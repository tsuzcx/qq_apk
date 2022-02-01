package com.tencent.mobileqq.vaswebviewplugin;

import bguj;
import bgve;
import bgzt;
import bhht;

class EmojiJsPlugin$8
  implements Runnable
{
  EmojiJsPlugin$8(EmojiJsPlugin paramEmojiJsPlugin) {}
  
  public void run()
  {
    bguj localbguj = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localbguj != null) && ((localbguj instanceof bgzt)))
    {
      this.this$0.progressDialog = new bhht(this.this$0.mRuntime.a(), ((bgzt)localbguj).getTitleBarHeight());
      this.this$0.progressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */