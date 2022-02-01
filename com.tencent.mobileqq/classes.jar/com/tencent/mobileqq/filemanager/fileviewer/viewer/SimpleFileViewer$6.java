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
    TbsReaderView localTbsReaderView = LocalTbsViewManager.a().a(this.this$0.c, this.a, this.b);
    if (SimpleFileViewer.f(this.this$0) != null)
    {
      SimpleFileViewer localSimpleFileViewer = this.this$0;
      if (SimpleFileViewer.a(localSimpleFileViewer, SimpleFileViewer.f(localSimpleFileViewer), localTbsReaderView, true)) {
        SimpleFileViewer.a(this.this$0, localTbsReaderView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.6
 * JD-Core Version:    0.7.0.1
 */