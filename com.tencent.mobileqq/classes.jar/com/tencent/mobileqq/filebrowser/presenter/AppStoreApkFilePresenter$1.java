package com.tencent.mobileqq.filebrowser.presenter;

import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnAppStorePromoteListener;
import com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView;
import com.tencent.mobileqq.filemanager.util.QBrowserUtils;
import com.tencent.mobileqq.statistics.ReportController;

class AppStoreApkFilePresenter$1
  implements IFileBrowserModel.OnAppStorePromoteListener
{
  AppStoreApkFilePresenter$1(AppStoreApkFilePresenter paramAppStoreApkFilePresenter) {}
  
  public void a()
  {
    int i = QBrowserUtils.a(this.a.d.d());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    ReportController.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, localStringBuilder.toString(), "", "", "");
    this.a.c.y();
    this.a.b.f(false);
  }
  
  public void b()
  {
    this.a.c.b(this.a.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.AppStoreApkFilePresenter.1
 * JD-Core Version:    0.7.0.1
 */