package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.tbs.reader.TbsReaderView;

class SimpleFileViewer$6
  implements Runnable
{
  SimpleFileViewer$6(SimpleFileViewer paramSimpleFileViewer, String paramString, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback) {}
  
  public void run()
  {
    TbsReaderView localTbsReaderView = LocalTbsViewManager.a().a(this.this$0.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager$LocalTbsViewManagerCallback);
    if ((SimpleFileViewer.a(this.this$0) != null) && (SimpleFileViewer.a(this.this$0, SimpleFileViewer.a(this.this$0), localTbsReaderView, true))) {
      SimpleFileViewer.a(this.this$0, localTbsReaderView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.6
 * JD-Core Version:    0.7.0.1
 */