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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but fileViewer is null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(this.jdField_a_of_type_AndroidOsBundle);
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
    if (j == 1) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692790) + "(" + FileUtil.a(i) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()) + ")");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a((int)(100.0F * paramFloat));
      return;
      if (j == 4) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692768) + "(" + FileUtil.a(i) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()) + ")");
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692750) + "(" + FileUtil.a(i) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()) + ")");
      }
    }
  }
  
  public abstract boolean b();
  
  protected void h()
  {
    this.c = false;
    this.b = false;
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i();
    Object localObject;
    if (i == 6)
    {
      this.jdField_a_of_type_AndroidAppActivity.getString(2131692441);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h() == 1) {}
      for (localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692442);; localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692441))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a((String)localObject + "(" + FileSizeFormat.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()) + ")", new FileBrowserPresenterBase.3(this));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.b(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(true);
        return;
        this.c = true;
      }
    }
    if (i == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(HardCodeUtil.a(2131704517), new FileBrowserPresenterBase.4(this));
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
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.f() == 9501) && (NetworkUtil.h(this.jdField_a_of_type_AndroidAppActivity)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
      if (localObject != null) {
        ((IDownloadController)localObject).a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.b(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(true);
      return;
      this.c = true;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(HardCodeUtil.a(2131704514) + FileSizeFormat.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()) + ")", new FileBrowserPresenterBase.5(this));
    }
  }
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
  
  protected void m()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h();
    if ((i == 2) || (i == 4)) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.b(false);
      new Handler().postDelayed(new FileBrowserPresenterBase.2(this), 100L);
      return;
      if ((i == 1) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().b();
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
 * JD-Core Version:    0.7.0.1
 */