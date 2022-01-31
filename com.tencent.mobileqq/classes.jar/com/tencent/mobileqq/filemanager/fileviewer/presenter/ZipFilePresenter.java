package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import adnv;
import adnw;
import adnx;
import adny;
import adnz;
import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnThumbEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnZipEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.ZipFileViewer;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.FileSizeFormat;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ZipFilePresenter
  extends FileBrowserPresenterBase
  implements FileBrowserModelBase.OnThumbEventListener, FileBrowserModelBase.OnTransEventListener, FileBrowserModelBase.OnZipEventListener
{
  protected ZipFileViewer a;
  private List a;
  private boolean b;
  private boolean c;
  
  public ZipFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer = new ZipFileViewer(paramActivity);
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer);
  }
  
  private void b(long paramLong)
  {
    if (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.a(true, new adnv(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.a("用其他应用打开", new adnw(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.a(true);
      SpannableString localSpannableString = FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131428223), "用QQ浏览器打开", new adnx(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.a(localSpannableString, LinkMovementMethod.getInstance());
      return;
    }
    if ((paramLong == -7003L) || (paramLong == -6101L))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b(16);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131428256), null);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.a(false, null);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131428283), null);
    }
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i();
    if (i == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.c(false);
      return;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.c(false);
      return;
    }
    if (i == 6)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.a(true, "继续下载(" + FileSizeFormat.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b()) + ")", new adny(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.a(true, "下载(" + FileSizeFormat.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b()) + ")", new adnz(this));
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = zip");
    }
    boolean bool;
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      bool = true;
      this.b = bool;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.c("共" + this.jdField_a_of_type_JavaUtilList.size() + "项  " + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b()));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.d(this.b);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this);
      c();
      if (NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity)) {
        break label278;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131433023), 1).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.j());
    }
    for (;;)
    {
      if (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b()))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.c();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h()) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() != null))
      {
        b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a());
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(true);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.c(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().a();
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this);
      return;
      bool = false;
      break;
      label278:
      if (!this.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.f();
        this.c = true;
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.c(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(true);
    b(paramFloat);
  }
  
  public void a(long paramLong)
  {
    b(paramLong);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(paramString1, paramString2);
  }
  
  public void a(List paramList, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.a(paramList, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(), paramString2, paramString3, paramString4, paramString1);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.c("共" + this.jdField_a_of_type_JavaUtilList.size() + "项  " + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b()));
      return;
    }
    QLog.e("FileBrowserPresenter<FileAssistant>", 1, "onGetZipFileList, mFiles is null");
    b(1L);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.a(paramString1, paramString2);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.c(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(true);
    b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.c(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(false);
    c();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.c();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(false);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    }
  }
  
  public void g()
  {
    k();
  }
  
  public void h()
  {
    super.h();
  }
  
  public void i()
  {
    if (this.c) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b("", "");
    }
  }
  
  protected void k()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h();
    if ((i == 2) || (i == 3)) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(false);
      c();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().b();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserPresenter<FileAssistant>", 2, "zip file stop trans, but can not handle trans type");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter
 * JD-Core Version:    0.7.0.1
 */