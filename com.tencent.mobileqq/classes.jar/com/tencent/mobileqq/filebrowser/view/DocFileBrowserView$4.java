package com.tencent.mobileqq.filebrowser.view;

import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.tbs.reader.TbsReaderView;

class DocFileBrowserView$4
  implements Runnable
{
  DocFileBrowserView$4(DocFileBrowserView paramDocFileBrowserView, String paramString, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback) {}
  
  public void run()
  {
    TbsReaderView localTbsReaderView = LocalTbsViewManager.a().a(this.this$0.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager$LocalTbsViewManagerCallback);
    if ((localTbsReaderView != null) && (DocFileBrowserView.a(this.this$0, localTbsReaderView, localTbsReaderView))) {
      DocFileBrowserView.a(this.this$0, localTbsReaderView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.DocFileBrowserView.4
 * JD-Core Version:    0.7.0.1
 */