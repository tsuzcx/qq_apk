package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.FileBrowserViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.FileBrowserViewBase.CloseFileBrowserCallback;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileSizeFormat;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public abstract class FileBrowserPresenterBase
  implements FileBrowserViewBase.CloseFileBrowserCallback
{
  protected Activity a;
  protected Bundle a;
  protected IFileBrowser a;
  protected IFileViewListener a;
  protected FileBrowserModelBase a;
  private FileBrowserViewBase jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase;
  private boolean jdField_a_of_type_Boolean = true;
  protected boolean b = false;
  protected boolean c = false;
  
  public FileBrowserPresenterBase(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase = paramFileBrowserModelBase;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public FileBrowserViewBase a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but model is null");
      return;
    }
    FileBrowserViewBase localFileBrowserViewBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase;
    if (localFileBrowserViewBase == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but fileViewer is null");
      return;
    }
    localFileBrowserViewBase.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a();
    h();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(new FileBrowserPresenterBase.1(this));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i() == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.b(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(false);
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a());
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(this);
    if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i()) && (this.jdField_a_of_type_Boolean) && (this.c)) {
      ReportController.b(null, "dc00898", "", "", "0X800A687", "0X800A687", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(IFileBrowser paramIFileBrowser)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser = paramIFileBrowser;
  }
  
  public void a(IFileViewListener paramIFileViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener = paramIFileViewListener;
  }
  
  protected void a(FileBrowserViewBase paramFileBrowserViewBase)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase = paramFileBrowserViewBase;
  }
  
  public abstract boolean a();
  
  protected void b(float paramFloat)
  {
    int i = (int)((float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c() * paramFloat);
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h();
    FileBrowserViewBase localFileBrowserViewBase;
    StringBuilder localStringBuilder;
    if (j == 1)
    {
      localFileBrowserViewBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getString(2131692748));
      localStringBuilder.append("(");
      localStringBuilder.append(FileUtil.a(i));
      localStringBuilder.append("/");
      localStringBuilder.append(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()));
      localStringBuilder.append(")");
      localFileBrowserViewBase.a(localStringBuilder.toString());
    }
    else if (j == 4)
    {
      localFileBrowserViewBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getString(2131692726));
      localStringBuilder.append("(");
      localStringBuilder.append(FileUtil.a(i));
      localStringBuilder.append("/");
      localStringBuilder.append(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()));
      localStringBuilder.append(")");
      localFileBrowserViewBase.a(localStringBuilder.toString());
    }
    else
    {
      localFileBrowserViewBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getString(2131692707));
      localStringBuilder.append("(");
      localStringBuilder.append(FileUtil.a(i));
      localStringBuilder.append("/");
      localStringBuilder.append(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()));
      localStringBuilder.append(")");
      localFileBrowserViewBase.a(localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a((int)(paramFloat * 100.0F));
  }
  
  public abstract boolean b();
  
  protected void h()
  {
    this.c = false;
    this.b = false;
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i();
    Object localObject1;
    Object localObject2;
    if (i == 6)
    {
      this.jdField_a_of_type_AndroidAppActivity.getString(2131692377);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h() == 1)
      {
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131692378);
      }
      else
      {
        this.c = true;
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131692377);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("(");
      localStringBuilder.append(FileSizeFormat.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()));
      localStringBuilder.append(")");
      ((FileBrowserViewBase)localObject2).a(localStringBuilder.toString(), new FileBrowserPresenterBase.3(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.b(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(true);
      return;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(HardCodeUtil.a(2131704604), new FileBrowserPresenterBase.4(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(true);
      return;
    }
    if (i == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.b(true);
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(false);
      return;
    }
    if (i == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(false);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.f() == 9501) && (NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidAppActivity)))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
      if (localObject1 != null) {
        ((IDownloadController)localObject1).a();
      }
    }
    else
    {
      this.c = true;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131704601));
      ((StringBuilder)localObject2).append(FileSizeFormat.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()));
      ((StringBuilder)localObject2).append(")");
      ((FileBrowserViewBase)localObject1).a(((StringBuilder)localObject2).toString(), new FileBrowserPresenterBase.5(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.b(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(true);
  }
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
  
  protected void m()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h();
    if ((i != 2) && (i != 4))
    {
      if ((i == 1) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().b();
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().b();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.b(false);
    new Handler().postDelayed(new FileBrowserPresenterBase.2(this), 100L);
  }
  
  protected void n()
  {
    this.jdField_a_of_type_AndroidAppActivity.finish();
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
  
  public void o()
  {
    n();
  }
  
  public void p() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
 * JD-Core Version:    0.7.0.1
 */