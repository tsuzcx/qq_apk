package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.widget.QQProgressDialog;

class EmojiJsPlugin$9
  implements Runnable
{
  EmojiJsPlugin$9(EmojiJsPlugin paramEmojiJsPlugin) {}
  
  public void run()
  {
    if (this.this$0.progressDialog != null)
    {
      this.this$0.progressDialog.cancel();
      this.this$0.progressDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */