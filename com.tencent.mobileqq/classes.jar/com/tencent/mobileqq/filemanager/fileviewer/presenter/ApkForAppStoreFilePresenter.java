package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.IAppStoreRemindCallback;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileSizeFormat;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class ApkForAppStoreFilePresenter
  extends SimpleFilePresenter
  implements View.OnClickListener
{
  private QFileAppStorePromoteManager.IAppStoreRemindCallback a = new ApkForAppStoreFilePresenter.3(this);
  
  public ApkForAppStoreFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
  }
  
  private void v()
  {
    this.h = true;
    SimpleFileViewer localSimpleFileViewer = this.k;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131902506));
    localStringBuilder.append(FileSizeFormat.a(this.c.x()));
    localStringBuilder.append(")");
    localSimpleFileViewer.a(localStringBuilder.toString(), new ApkForAppStoreFilePresenter.2(this));
    this.k.b(false);
    this.k.a(true);
  }
  
  private QFileAppStorePromoteManager w()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return ((QQAppInterface)localAppRuntime).getFileManagerEngine().f();
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("ApkForAppStoreFilePresenter", 1, "FileBrowserPresenter init: type = preview simple");
    }
    String str = this.c.ac();
    this.k.d(2130845642);
    if (!TextUtils.isEmpty(str)) {
      this.k.f(str);
    } else {
      this.k.e(this.c.E());
    }
    if ((!TextUtils.isEmpty(this.c.I())) && (16 != this.c.b())) {
      this.k.g(this.c.I());
    } else {
      this.k.e(false);
    }
    if ((!TextUtils.isEmpty(this.c.I())) && (16 != this.c.b())) {
      this.k.g(this.c.I());
    } else {
      this.k.e(false);
    }
    if (this.c.b() == 16) {
      this.k.c(this.d.getString(2131889341));
    } else if (this.c.F()) {
      this.k.c(this.d.getString(2131889582));
    }
    this.k.c(true ^ this.c.P());
    str = this.c.ab();
    if (!TextUtils.isEmpty(str)) {
      this.k.d(str);
    }
    if (!FileUtils.fileExistsAndNotEmpty(this.c.y())) {
      cn_();
    }
  }
  
  protected void cm_() {}
  
  protected void cn_()
  {
    Object localObject = w();
    if (localObject == null) {
      return;
    }
    if (!this.c.Z()) {
      return;
    }
    if (!((QFileAppStorePromoteManager)localObject).g()) {
      return;
    }
    if (TextUtils.isEmpty(this.c.aa())) {
      return;
    }
    int i = this.c.R();
    if ((i != 6) && (i != 2) && (i != 4) && (i != 5))
    {
      localObject = ((QFileAppStorePromoteManager)localObject).a(this.d);
      this.k.b((String)localObject, this);
      ReportController.b(null, "dc00898", "", "", "0X800AE3B", "0X800AE3B", 0, 0, "", "", "", "");
    }
  }
  
  protected void h()
  {
    super.h();
    int i = this.c.R();
    if ((i != 6) && (i != 2) && (i != 4) && (i != 5))
    {
      if (w() == null)
      {
        v();
        return;
      }
      this.h = true;
      SimpleFileViewer localSimpleFileViewer = this.k;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131902506));
      localStringBuilder.append(FileSizeFormat.a(this.c.x()));
      localStringBuilder.append(")");
      localSimpleFileViewer.a(localStringBuilder.toString(), new ApkForAppStoreFilePresenter.1(this));
    }
  }
  
  protected void i()
  {
    Object localObject = w();
    if (localObject == null) {
      return;
    }
    if (!this.c.Z()) {
      return;
    }
    if (!((QFileAppStorePromoteManager)localObject).g()) {
      return;
    }
    if (TextUtils.isEmpty(this.c.aa())) {
      return;
    }
    int i = this.c.R();
    if ((i != 6) && (i != 2) && (i != 4) && (i != 5))
    {
      localObject = ((QFileAppStorePromoteManager)localObject).a(this.d);
      this.k.b((String)localObject, this);
    }
  }
  
  public void onClick(View paramView)
  {
    QFileAppStorePromoteManager localQFileAppStorePromoteManager = w();
    if (localQFileAppStorePromoteManager != null)
    {
      ReportController.b(null, "dc00898", "", "", "0X800AE3C", "0X800AE3C", 0, 0, "", "", "", "");
      String str = this.c.aa();
      if (localQFileAppStorePromoteManager.b())
      {
        if (!TextUtils.isEmpty(str)) {
          QFileAppStorePromoteManager.a(str, 1);
        } else {
          QLog.i("ApkForAppStoreFilePresenter", 1, "app store has installed, but apk package name is null!");
        }
      }
      else {
        localQFileAppStorePromoteManager.b(this.d, str);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.ApkForAppStoreFilePresenter
 * JD-Core Version:    0.7.0.1
 */