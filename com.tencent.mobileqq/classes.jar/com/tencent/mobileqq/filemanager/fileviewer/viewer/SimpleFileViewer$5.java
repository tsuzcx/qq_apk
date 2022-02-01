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
    SimpleFileViewer.a(localSimpleFileViewer, ((LocalTbsViewManager)localObject).a(localSimpleFileViewer.c, this.a, this.b));
    localObject = this.this$0;
    SimpleFileViewer.a((SimpleFileViewer)localObject, null, SimpleFileViewer.f((SimpleFileViewer)localObject), true);
    SimpleFileViewer.g(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.5
 * JD-Core Version:    0.7.0.1
 */