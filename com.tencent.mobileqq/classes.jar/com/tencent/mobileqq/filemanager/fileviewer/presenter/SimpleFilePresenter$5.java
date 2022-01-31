package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import android.text.TextUtils;
import aovk;
import aoxw;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;

public class SimpleFilePresenter$5
  implements Runnable
{
  public SimpleFilePresenter$5(aoxw paramaoxw) {}
  
  public void run()
  {
    String str = this.this$0.jdField_a_of_type_Aovk.g();
    if ((TextUtils.isEmpty(str)) || (aoxw.b(this.this$0)))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(8);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(0);
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(str);
    aoxw.a(this.this$0).postDelayed(aoxw.a(this.this$0), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.5
 * JD-Core Version:    0.7.0.1
 */