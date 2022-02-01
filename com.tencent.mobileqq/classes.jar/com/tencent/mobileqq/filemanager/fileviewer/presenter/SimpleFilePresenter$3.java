package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;

class SimpleFilePresenter$3
  implements Runnable
{
  SimpleFilePresenter$3(SimpleFilePresenter paramSimpleFilePresenter) {}
  
  public void run()
  {
    String str = this.this$0.c.Y();
    if ((!TextUtils.isEmpty(str)) && (!SimpleFilePresenter.a(this.this$0)))
    {
      this.this$0.k.b(0);
      this.this$0.k.b(str);
      SimpleFilePresenter.c(this.this$0).postDelayed(SimpleFilePresenter.b(this.this$0), 1000L);
      return;
    }
    this.this$0.k.b(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.3
 * JD-Core Version:    0.7.0.1
 */