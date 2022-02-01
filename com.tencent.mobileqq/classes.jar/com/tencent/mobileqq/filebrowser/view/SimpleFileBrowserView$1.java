package com.tencent.mobileqq.filebrowser.view;

import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;

class SimpleFileBrowserView$1
  implements Runnable
{
  SimpleFileBrowserView$1(SimpleFileBrowserView paramSimpleFileBrowserView, String paramString) {}
  
  public void run()
  {
    SimpleFileBrowserView.a(this.this$0).setText(QQFileManagerUtil.a(this.a, false, SimpleFileBrowserView.a(this.this$0).getMeasuredWidth(), SimpleFileBrowserView.a(this.this$0).getPaint(), 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView.1
 * JD-Core Version:    0.7.0.1
 */