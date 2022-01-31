package com.tencent.qqmini.sdk.runtime.widget;

import bgnf;
import bhfl;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.File;

public class InnerWebView$5$2
  implements Runnable
{
  public InnerWebView$5$2(bhfl parambhfl) {}
  
  public void run()
  {
    File localFile = new File(this.a.jdField_a_of_type_JavaLangString);
    if (localFile.exists())
    {
      InnerWebView.c(this.a.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetInnerWebView, localFile.getAbsolutePath());
      return;
    }
    QMLog.e("ProgressWebView", "savaPicToAlbum failed, because of picture downloadFailed");
    bgnf.a(InnerWebView.a(this.a.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetInnerWebView), 1, "保存失败", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.InnerWebView.5.2
 * JD-Core Version:    0.7.0.1
 */