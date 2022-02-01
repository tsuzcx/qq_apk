package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import android.text.TextUtils;
import atxa;
import atzu;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;

public class SimpleFilePresenter$3
  implements Runnable
{
  public SimpleFilePresenter$3(atzu paramatzu) {}
  
  public void run()
  {
    String str = this.this$0.jdField_a_of_type_Atxa.i();
    if ((TextUtils.isEmpty(str)) || (atzu.a(this.this$0)))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(8);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(0);
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(str);
    atzu.a(this.this$0).postDelayed(atzu.a(this.this$0), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.3
 * JD-Core Version:    0.7.0.1
 */