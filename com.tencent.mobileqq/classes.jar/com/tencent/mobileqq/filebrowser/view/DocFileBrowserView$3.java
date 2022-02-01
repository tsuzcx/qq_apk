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
    DocFileBrowserView.a(localDocFileBrowserView, ((LocalTbsViewManager)localObject).a(localDocFileBrowserView.e, this.a, this.b));
    localObject = this.this$0;
    DocFileBrowserView.a((DocFileBrowserView)localObject, null, DocFileBrowserView.b((DocFileBrowserView)localObject));
    DocFileBrowserView.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.DocFileBrowserView.3
 * JD-Core Version:    0.7.0.1
 */