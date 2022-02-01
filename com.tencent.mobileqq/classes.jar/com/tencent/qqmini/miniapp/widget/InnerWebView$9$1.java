package com.tencent.qqmini.miniapp.widget;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.MiniToast;

class InnerWebView$9$1
  implements Runnable
{
  InnerWebView$9$1(InnerWebView.9 param9) {}
  
  public void run()
  {
    QMLog.e("InnerWebView", "savaPicToAlbum failed, because of picture downloadFailed");
    MiniToast.makeText(InnerWebView.access$800(this.this$1.this$0), 1, "保存失败", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.9.1
 * JD-Core Version:    0.7.0.1
 */