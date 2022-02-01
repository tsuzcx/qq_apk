package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FileBrowserPresenterBase$4
  implements View.OnClickListener
{
  FileBrowserPresenterBase$4(FileBrowserPresenterBase paramFileBrowserPresenterBase) {}
  
  public void onClick(View paramView)
  {
    FileManagerUtil.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d());
    this.a.b = true;
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase.4
 * JD-Core Version:    0.7.0.1
 */