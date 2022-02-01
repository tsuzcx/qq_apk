package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.LocalTbsViewManagerCallback;

class SimpleFileViewer$5
  implements Runnable
{
  SimpleFileViewer$5(SimpleFileViewer paramSimpleFileViewer, String paramString, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback) {}
  
  public void run()
  {
    Object localObject = LocalTbsViewManager.a();
    SimpleFileViewer localSimpleFileViewer = this.this$0;
    SimpleFileViewer.a(localSimpleFileViewer, ((LocalTbsViewManager)localObject).a(localSimpleFileViewer.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager$LocalTbsViewManagerCallback));
    localObject = this.this$0;
    SimpleFileViewer.a((SimpleFileViewer)localObject, null, SimpleFileViewer.a((SimpleFileViewer)localObject), true);
    SimpleFileViewer.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.5
 * JD-Core Version:    0.7.0.1
 */