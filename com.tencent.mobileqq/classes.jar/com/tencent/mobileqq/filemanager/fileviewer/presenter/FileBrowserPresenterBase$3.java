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
    int i = this.a.c.O();
    if ((i != 2) && (i != 3))
    {
      if ((i == 1) && (this.a.c.e() != null)) {
        this.a.c.e().a();
      }
    }
    else
    {
      i = QFileUtils.b(this.a.c.z());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      ReportController.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, localStringBuilder.toString(), "", "", "");
      if (this.a.c.f() != null) {
        this.a.c.f().a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase.3
 * JD-Core Version:    0.7.0.1
 */