package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.widget.RelativeLayout;

class SimpleFileViewer$4
  implements Runnable
{
  public void run()
  {
    if (this.this$0.a != SimpleFileViewer.c(this.this$0))
    {
      SimpleFileViewer localSimpleFileViewer = this.this$0;
      localSimpleFileViewer.a = SimpleFileViewer.c(localSimpleFileViewer);
    }
    if (SimpleFileViewer.a(this.this$0) != null)
    {
      SimpleFileViewer.a(this.this$0).removeAllViews();
      SimpleFileViewer.a(this.this$0, null);
    }
    SimpleFileViewer.c(this.this$0, null);
    SimpleFileViewer.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.4
 * JD-Core Version:    0.7.0.1
 */