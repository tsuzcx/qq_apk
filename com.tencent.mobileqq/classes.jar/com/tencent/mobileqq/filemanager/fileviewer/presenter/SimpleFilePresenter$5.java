package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import android.text.TextUtils;
import arfz;
import arin;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;

public class SimpleFilePresenter$5
  implements Runnable
{
  public SimpleFilePresenter$5(arin paramarin) {}
  
  public void run()
  {
    String str = this.this$0.jdField_a_of_type_Arfz.i();
    if ((TextUtils.isEmpty(str)) || (arin.c(this.this$0)))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(8);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(0);
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(str);
    arin.a(this.this$0).postDelayed(arin.a(this.this$0), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.5
 * JD-Core Version:    0.7.0.1
 */