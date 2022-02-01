package com.tencent.mobileqq.filebrowser.view;

import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.LocalTbsViewManagerCallback;

class DocFileBrowserView$3
  implements Runnable
{
  DocFileBrowserView$3(DocFileBrowserView paramDocFileBrowserView, String paramString, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback) {}
  
  public void run()
  {
    Object localObject = LocalTbsViewManager.a();
    DocFileBrowserView localDocFileBrowserView = this.this$0;
    DocFileBrowserView.a(localDocFileBrowserView, ((LocalTbsViewManager)localObject).a(localDocFileBrowserView.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager$LocalTbsViewManagerCallback));
    localObject = this.this$0;
    DocFileBrowserView.a((DocFileBrowserView)localObject, null, DocFileBrowserView.a((DocFileBrowserView)localObject));
    DocFileBrowserView.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.DocFileBrowserView.3
 * JD-Core Version:    0.7.0.1
 */