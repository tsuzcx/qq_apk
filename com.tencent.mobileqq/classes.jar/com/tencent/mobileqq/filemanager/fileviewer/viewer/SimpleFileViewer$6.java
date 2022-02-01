package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.tbs.reader.TbsReaderView;

class SimpleFileViewer$6
  implements Runnable
{
  SimpleFileViewer$6(SimpleFileViewer paramSimpleFileViewer, String paramString, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback) {}
  
  public void run()
  {
    TbsReaderView localTbsReaderView = LocalTbsViewManager.a().a(this.this$0.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager$LocalTbsViewManagerCallback);
    if (SimpleFileViewer.a(this.this$0) != null)
    {
      SimpleFileViewer localSimpleFileViewer = this.this$0;
      if (SimpleFileViewer.a(localSimpleFileViewer, SimpleFileViewer.a(localSimpleFileViewer), localTbsReaderView, true)) {
        SimpleFileViewer.a(this.this$0, localTbsReaderView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.6
 * JD-Core Version:    0.7.0.1
 */