package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FileBrowserPresenterBase$5
  implements View.OnClickListener
{
  FileBrowserPresenterBase$5(FileBrowserPresenterBase paramFileBrowserPresenterBase) {}
  
  public void onClick(View paramView)
  {
    int i = QFileUtils.b(this.a.a.e());
    ReportController.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
    IDownloadController localIDownloadController = this.a.a.a();
    if (localIDownloadController != null) {
      localIDownloadController.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase.5
 * JD-Core Version:    0.7.0.1
 */