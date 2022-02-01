package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ZipFilePresenter$6
  implements View.OnClickListener
{
  ZipFilePresenter$6(ZipFilePresenter paramZipFilePresenter) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.a() != null) {
      this.a.a.a().a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.6
 * JD-Core Version:    0.7.0.1
 */