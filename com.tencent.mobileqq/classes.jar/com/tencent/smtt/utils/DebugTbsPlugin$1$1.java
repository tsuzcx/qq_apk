package com.tencent.smtt.utils;

import android.widget.RelativeLayout;
import android.widget.Toast;

class DebugTbsPlugin$1$1
  implements Runnable
{
  DebugTbsPlugin$1$1(DebugTbsPlugin.1 param1) {}
  
  public void run()
  {
    Toast.makeText(this.this$1.val$context, "下载成功", 0).show();
    this.this$1.val$layout.setVisibility(4);
    this.this$1.this$0.showPluginView(this.this$1.val$url, this.this$1.val$webview, this.this$1.val$context, DebugTbsPlugin.access$000());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.utils.DebugTbsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */