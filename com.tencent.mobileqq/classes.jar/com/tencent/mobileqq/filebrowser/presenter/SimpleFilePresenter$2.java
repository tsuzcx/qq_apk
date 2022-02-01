package com.tencent.mobileqq.filebrowser.presenter;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView;

class SimpleFilePresenter$2
  implements Runnable
{
  SimpleFilePresenter$2(SimpleFilePresenter paramSimpleFilePresenter) {}
  
  public void run()
  {
    String str = this.this$0.c.m();
    if ((!TextUtils.isEmpty(str)) && (!SimpleFilePresenter.a(this.this$0)))
    {
      this.this$0.b.d(true);
      this.this$0.b.c(str);
      SimpleFilePresenter.c(this.this$0).postDelayed(SimpleFilePresenter.b(this.this$0), 1000L);
      return;
    }
    this.this$0.b.d(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter.2
 * JD-Core Version:    0.7.0.1
 */