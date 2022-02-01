package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class SimpleFileViewer$1
  implements Runnable
{
  SimpleFileViewer$1(SimpleFileViewer paramSimpleFileViewer, String paramString) {}
  
  public void run()
  {
    SimpleFileViewer.a(this.this$0).setText(FileManagerUtil.a(this.a, false, SimpleFileViewer.a(this.this$0).getMeasuredWidth(), SimpleFileViewer.a(this.this$0).getPaint(), 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.1
 * JD-Core Version:    0.7.0.1
 */