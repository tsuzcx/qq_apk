package com.tencent.mobileqq.filebrowser.view;

import android.widget.RelativeLayout;

class SimpleFileBrowserView$2
  implements Runnable
{
  SimpleFileBrowserView$2(SimpleFileBrowserView paramSimpleFileBrowserView) {}
  
  public void run()
  {
    if (this.this$0.a != SimpleFileBrowserView.a(this.this$0))
    {
      SimpleFileBrowserView localSimpleFileBrowserView = this.this$0;
      localSimpleFileBrowserView.a = SimpleFileBrowserView.a(localSimpleFileBrowserView);
    }
    if (SimpleFileBrowserView.a(this.this$0) != null)
    {
      SimpleFileBrowserView.a(this.this$0).removeAllViews();
      SimpleFileBrowserView.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView.2
 * JD-Core Version:    0.7.0.1
 */