package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ZipFilePresenter$2
  implements View.OnClickListener
{
  ZipFilePresenter$2(ZipFilePresenter paramZipFilePresenter) {}
  
  public void onClick(View paramView)
  {
    FileManagerUtil.a(this.a.d, this.a.c.y());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.2
 * JD-Core Version:    0.7.0.1
 */