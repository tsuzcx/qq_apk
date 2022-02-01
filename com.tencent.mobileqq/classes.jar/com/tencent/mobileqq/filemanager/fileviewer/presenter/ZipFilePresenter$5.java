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
    this.a.a.f(true);
    this.a.a.d(false);
    ZipFilePresenter.b(this.a);
    this.a.c.M();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.5
 * JD-Core Version:    0.7.0.1
 */