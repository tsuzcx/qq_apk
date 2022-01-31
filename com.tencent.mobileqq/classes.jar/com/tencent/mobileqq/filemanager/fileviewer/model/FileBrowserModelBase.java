package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IThumbController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class FileBrowserModelBase
{
  protected int a;
  public Activity a;
  protected FilePreviewActivity.ControlerCallback a;
  protected FilePreViewControllerBase a;
  public IFileBrowser a;
  public IDownloadController a;
  public IThumbController a;
  protected IUploadController a;
  public FileBrowserModelBase.OnThumbEventListener a;
  public FileBrowserModelBase.OnTransEventListener a;
  public FileBrowserModelBase.OnZipEventListener a;
  
  public FileBrowserModelBase(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public abstract float a();
  
  public int a()
  {
    int i = 3;
    int j = e();
    if ((d() == 3) && (FileManagerUtil.c(b())) && (b() != 16))
    {
      switch (j)
      {
      case 3: 
      default: 
        i = 1;
      case 5: 
        return i;
      case 1: 
        return 4;
      case 2: 
        return 2;
      case 0: 
        return 6;
      }
      if (g()) {
        return 5;
      }
      return 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelBase", 2, "getCreateFileType error : this is a local file, but is invalid, may be can not find file path");
    }
    return 0;
  }
  
  public abstract long a();
  
  public abstract IDownloadController a();
  
  public abstract IThumbController a();
  
  public abstract IUploadController a();
  
  public abstract TeamWorkFileImportInfo a();
  
  public abstract String a();
  
  public abstract ArrayList a();
  
  public abstract List a();
  
  public void a()
  {
    b();
  }
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, FileBrowserModelBase.ImageFileInfo paramImageFileInfo);
  
  public abstract void a(int paramInt, String paramString);
  
  public void a(IFileBrowser paramIFileBrowser)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser = paramIFileBrowser;
  }
  
  public abstract void a(FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener);
  
  public void a(FileBrowserModelBase.OnThumbEventListener paramOnThumbEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener = paramOnThumbEventListener;
  }
  
  public void a(FileBrowserModelBase.OnTransEventListener paramOnTransEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener = paramOnTransEventListener;
  }
  
  public abstract void a(FileBrowserModelBase.OnVideoDataEventListener paramOnVideoDataEventListener);
  
  public void a(FileBrowserModelBase.OnZipEventListener paramOnZipEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener = paramOnZipEventListener;
  }
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public boolean a(FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener)
  {
    if (paramOnPreviewVideoOnlineListener != null) {
      paramOnPreviewVideoOnlineListener.ad_();
    }
    return false;
  }
  
  public abstract int b();
  
  public abstract long b();
  
  public abstract String b();
  
  public abstract ArrayList b();
  
  public abstract void b();
  
  public abstract void b(int paramInt);
  
  public abstract boolean b();
  
  public int c()
  {
    if (this.jdField_a_of_type_Int < 0) {
      return 0;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public abstract long c();
  
  public abstract String c();
  
  public abstract void c();
  
  public abstract void c(int paramInt);
  
  public abstract boolean c();
  
  public abstract int d();
  
  public abstract String d();
  
  public abstract void d();
  
  public abstract boolean d();
  
  public abstract int e();
  
  public abstract String e();
  
  public abstract void e();
  
  public abstract boolean e();
  
  public abstract int f();
  
  public abstract void f();
  
  public abstract boolean f();
  
  public abstract int g();
  
  public abstract void g();
  
  public abstract boolean g();
  
  public abstract int h();
  
  public void h()
  {
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener = null;
    }
  }
  
  public abstract boolean h();
  
  public abstract int i();
  
  public abstract boolean i();
  
  public int j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    }
    return 0;
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener = null;
    }
  }
  
  public boolean j()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
 * JD-Core Version:    0.7.0.1
 */