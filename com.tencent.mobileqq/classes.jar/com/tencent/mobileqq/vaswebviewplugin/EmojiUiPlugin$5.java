package com.tencent.mobileqq.vaswebviewplugin;

import bjbs;

class EmojiUiPlugin$5
  implements Runnable
{
  EmojiUiPlugin$5(EmojiUiPlugin paramEmojiUiPlugin) {}
  
  public void run()
  {
    if (this.this$0.progressDialog != null)
    {
      this.this$0.progressDialog.cancel();
      this.this$0.progressDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin.5
 * JD-Core Version:    0.7.0.1
 */