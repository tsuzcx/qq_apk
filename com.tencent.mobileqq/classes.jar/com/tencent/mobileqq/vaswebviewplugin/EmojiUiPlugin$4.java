package com.tencent.mobileqq.vaswebviewplugin;

import bioy;
import bjbs;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class EmojiUiPlugin$4
  implements Runnable
{
  EmojiUiPlugin$4(EmojiUiPlugin paramEmojiUiPlugin) {}
  
  public void run()
  {
    this.this$0.progressDialog = new bjbs(this.this$0.mRuntime.a(), ((QQBrowserActivity)this.this$0.mRuntime.a()).getTitleBarHeight());
    this.this$0.progressDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin.4
 * JD-Core Version:    0.7.0.1
 */