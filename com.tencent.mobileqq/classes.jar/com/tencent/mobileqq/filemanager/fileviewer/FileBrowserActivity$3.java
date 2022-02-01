package com.tencent.mobileqq.filemanager.fileviewer;

import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

class FileBrowserActivity$3
  implements Runnable
{
  FileBrowserActivity$3(FileBrowserActivity paramFileBrowserActivity) {}
  
  public void run()
  {
    this.this$0.a.a(this.this$0.a(), new ViewGroup.LayoutParams(-1, -1));
    FileBrowserActivity.b(this.this$0);
    if (this.this$0.a.f())
    {
      FileBrowserActivity.a(this.this$0).setVisibility(0);
      return;
    }
    FileBrowserActivity.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity.3
 * JD-Core Version:    0.7.0.1
 */