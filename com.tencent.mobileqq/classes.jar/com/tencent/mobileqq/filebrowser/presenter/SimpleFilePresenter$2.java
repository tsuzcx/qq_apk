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
    String str = this.this$0.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.d();
    if ((!TextUtils.isEmpty(str)) && (!SimpleFilePresenter.a(this.this$0)))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d(true);
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.c(str);
      SimpleFilePresenter.a(this.this$0).postDelayed(SimpleFilePresenter.a(this.this$0), 1000L);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter.2
 * JD-Core Version:    0.7.0.1
 */