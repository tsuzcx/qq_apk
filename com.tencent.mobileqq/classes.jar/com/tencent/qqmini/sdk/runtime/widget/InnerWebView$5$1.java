package com.tencent.qqmini.sdk.runtime.widget;

import bgrm;
import bhjs;
import com.tencent.qqmini.sdk.log.QMLog;

public class InnerWebView$5$1
  implements Runnable
{
  public InnerWebView$5$1(bhjs parambhjs) {}
  
  public void run()
  {
    QMLog.e("ProgressWebView", "savaPicToAlbum failed, because of picture downloadFailed");
    bgrm.a(InnerWebView.a(this.a.a), 1, "保存失败", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.InnerWebView.5.1
 * JD-Core Version:    0.7.0.1
 */