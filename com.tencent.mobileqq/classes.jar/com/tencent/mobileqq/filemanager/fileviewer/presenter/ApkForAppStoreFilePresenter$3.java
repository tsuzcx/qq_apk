package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.IAppStoreRemindCallback;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class ApkForAppStoreFilePresenter$3
  implements QFileAppStorePromoteManager.IAppStoreRemindCallback
{
  ApkForAppStoreFilePresenter$3(ApkForAppStoreFilePresenter paramApkForAppStoreFilePresenter) {}
  
  public void a()
  {
    int i = QFileUtils.b(this.a.c.z());
    Object localObject = new StringBuilder();
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
  
  public void b()
  {
    QFileAppStorePromoteManager localQFileAppStorePromoteManager = ApkForAppStoreFilePresenter.a(this.a);
    if (localQFileAppStorePromoteManager == null) {
      return;
    }
    String str = this.a.c.aa();
    if (localQFileAppStorePromoteManager.b())
    {
      if (!TextUtils.isEmpty(str))
      {
        QFileAppStorePromoteManager.a(str, 1);
        return;
      }
      QLog.i("ApkForAppStoreFilePresenter", 1, "app store has installed, but apk package name is null!");
      return;
    }
    localQFileAppStorePromoteManager.b(this.a.d, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.ApkForAppStoreFilePresenter.3
 * JD-Core Version:    0.7.0.1
 */