package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import android.text.TextUtils;
import apnb;
import appo;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;

public class SimpleFilePresenter$5
  implements Runnable
{
  public SimpleFilePresenter$5(appo paramappo) {}
  
  public void run()
  {
    String str = this.this$0.jdField_a_of_type_Apnb.g();
    if ((TextUtils.isEmpty(str)) || (appo.c(this.this$0)))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(8);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(0);
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(str);
    appo.a(this.this$0).postDelayed(appo.a(this.this$0), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.5
 * JD-Core Version:    0.7.0.1
 */