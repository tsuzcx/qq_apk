package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ApkForAppStoreFilePresenter$1
  implements View.OnClickListener
{
  ApkForAppStoreFilePresenter$1(ApkForAppStoreFilePresenter paramApkForAppStoreFilePresenter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = ApkForAppStoreFilePresenter.a(this.a);
    String str = this.a.c.ab();
    if ((TextUtils.isEmpty(str)) || (localObject == null) || (!((QFileAppStorePromoteManager)localObject).a(this.a.d, str, ApkForAppStoreFilePresenter.b(this.a))))
    {
      int i = QFileUtils.b(this.a.c.z());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("");
      ReportController.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
      localObject = this.a.c.f();
      if (localObject != null)
      {
        ((IDownloadController)localObject).a();
        this.a.k.d(false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.ApkForAppStoreFilePresenter.1
 * JD-Core Version:    0.7.0.1
 */