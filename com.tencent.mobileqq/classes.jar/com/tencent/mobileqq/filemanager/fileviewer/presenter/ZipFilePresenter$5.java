package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.ZipFileViewer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ZipFilePresenter$5
  implements View.OnClickListener
{
  ZipFilePresenter$5(ZipFilePresenter paramZipFilePresenter) {}
  
  public void onClick(View paramView)
  {
    ZipFilePresenter.a(this.a, true);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.f(true);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.d(false);
    ZipFilePresenter.a(this.a);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.g();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.5
 * JD-Core Version:    0.7.0.1
 */