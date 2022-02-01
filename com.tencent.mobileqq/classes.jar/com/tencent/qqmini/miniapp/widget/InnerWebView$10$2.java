package com.tencent.qqmini.miniapp.widget;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.io.File;

class InnerWebView$10$2
  implements Runnable
{
  InnerWebView$10$2(InnerWebView.10 param10) {}
  
  public void run()
  {
    File localFile = new File(this.this$1.val$tmpFilePath);
    if (localFile.exists())
    {
      InnerWebView.access$1600(this.this$1.this$0, localFile.getAbsolutePath());
      return;
    }
    QMLog.e("InnerWebView", "sharePicToQQ failed, because of picture downloadFailed");
    MiniToast.makeText(InnerWebView.access$800(this.this$1.this$0), 1, "分享失败", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.10.2
 * JD-Core Version:    0.7.0.1
 */