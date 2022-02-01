package com.tencent.mobileqq.filebrowser.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SimpleFilePresenter$1
  implements View.OnClickListener
{
  SimpleFilePresenter$1(SimpleFilePresenter paramSimpleFilePresenter) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter.1
 * JD-Core Version:    0.7.0.1
 */