package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FileBrowserPresenterBase$3
  implements View.OnClickListener
{
  FileBrowserPresenterBase$3(FileBrowserPresenterBase paramFileBrowserPresenterBase) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.a.h();
    if ((i == 2) || (i == 3))
    {
      i = QFileUtils.b(this.a.a.e());
      ReportController.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
      if (this.a.a.a() != null) {
        this.a.a.a().a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((i == 1) && (this.a.a.a() != null)) {
        this.a.a.a().a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase.3
 * JD-Core Version:    0.7.0.1
 */