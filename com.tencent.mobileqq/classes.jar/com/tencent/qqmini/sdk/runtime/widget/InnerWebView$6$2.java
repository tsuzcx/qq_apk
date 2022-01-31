package com.tencent.qqmini.sdk.runtime.widget;

import bgrm;
import bhjt;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.File;

public class InnerWebView$6$2
  implements Runnable
{
  public InnerWebView$6$2(bhjt parambhjt) {}
  
  public void run()
  {
    if (new File(this.a.jdField_a_of_type_JavaLangString).exists()) {
      return;
    }
    QMLog.e("ProgressWebView", "sharePicToQQ failed, because of picture downloadFailed");
    bgrm.a(InnerWebView.a(this.a.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetInnerWebView), 1, "分享失败", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.InnerWebView.6.2
 * JD-Core Version:    0.7.0.1
 */