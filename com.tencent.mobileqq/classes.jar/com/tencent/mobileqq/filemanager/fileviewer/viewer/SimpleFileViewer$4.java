package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.widget.RelativeLayout;

class SimpleFileViewer$4
  implements Runnable
{
  public void run()
  {
    if (this.this$0.b != SimpleFileViewer.e(this.this$0))
    {
      SimpleFileViewer localSimpleFileViewer = this.this$0;
      localSimpleFileViewer.b = SimpleFileViewer.e(localSimpleFileViewer);
    }
    if (SimpleFileViewer.c(this.this$0) != null)
    {
      SimpleFileViewer.c(this.this$0).removeAllViews();
      SimpleFileViewer.a(this.this$0, null);
    }
    SimpleFileViewer.c(this.this$0, null);
    SimpleFileViewer.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.4
 * JD-Core Version:    0.7.0.1
 */