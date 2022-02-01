package com.tencent.mobileqq.filebrowser.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.view.ZipFileBrowserView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ZipFilePresenter$5
  implements View.OnClickListener
{
  ZipFilePresenter$5(ZipFilePresenter paramZipFilePresenter) {}
  
  public void onClick(View paramView)
  {
    ZipFilePresenter.a(this.a, true);
    this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.g(true);
    this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.e(false);
    ZipFilePresenter.a(this.a);
    this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.j();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.ZipFilePresenter.5
 * JD-Core Version:    0.7.0.1
 */