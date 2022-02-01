package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
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
import com.tencent.mobileqq.utils.FileSizeFormat;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;
import java.util.List;

public class ZipFilePresenter
  extends FileBrowserPresenterBase
  implements FileBrowserModelBase.OnThumbEventListener, FileBrowserModelBase.OnTransEventListener, FileBrowserModelBase.OnZipEventListener
{
  protected ZipFileViewer a;
  private List<ZipFilePresenter.FileData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean d = false;
  private boolean e = false;
  
  public ZipFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer = new ZipFileViewer(paramActivity);
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer);
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.f(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.d(true);
    b();
    if (FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.a(HardCodeUtil.a(2131692722), new ZipFilePresenter.2(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.a(true);
      return;
    }
    if (paramLong == -1000L) {
      return;
    }
    if ((paramLong != -7003L) && (paramLong != -6101L))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.e(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(16);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.f(this.jdField_a_of_type_AndroidAppActivity.getString(2131692353));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.e(false);
  }
  
  private void c()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new ZipFilePresenter.3(this), 3000L);
  }
  
  private void q()
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
      localZipFileViewer = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131716513));
      localStringBuilder.append("(");
      localStringBuilder.append(FileSizeFormat.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()));
      localStringBuilder.append(")");
      localZipFileViewer.a(true, localStringBuilder.toString(), new ZipFilePresenter.6(this));
      return;
    }
    ZipFileViewer localZipFileViewer = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131716510));
    localStringBuilder.append("(");
    localStringBuilder.append(FileSizeFormat.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()));
    localStringBuilder.append(")");
    localZipFileViewer.a(true, localStringBuilder.toString(), new ZipFilePresenter.7(this));
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("ZipFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = zip");
    }
    this.jdField_a_of_type_Boolean = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.h(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.f());
    ZipFileViewer localZipFileViewer = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131716509));
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
    localStringBuilder.append(HardCodeUtil.a(2131716514));
    localStringBuilder.append(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()));
    localZipFileViewer.e(localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this);
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
    {
      b(-1000L);
    }
    else if (!this.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.g();
      this.d = true;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.f(true);
      this.e = true;
      c();
    }
    if ((!FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d())) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i()) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() != null))
    {
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.c(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.a(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.c(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(true);
    b(paramFloat);
  }
  
  public void a(long paramLong)
  {
    ThreadManagerV2.getUIHandlerV2().post(new ZipFilePresenter.1(this, paramLong));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(paramString1, paramString2);
  }
  
  public void a(List<ZipFilePresenter.FileData> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort)
  {
    if (!this.e) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.a(paramList, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b(), paramString2, paramString3, paramString4, paramString1, paramBoolean, paramString5, paramShort);
      paramList = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer;
      paramString1 = new StringBuilder();
      paramString1.append(HardCodeUtil.a(2131716511));
      paramString1.append(this.jdField_a_of_type_JavaUtilList.size());
      paramString1.append(HardCodeUtil.a(2131716512));
      paramString1.append(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()));
      paramList.e(paramString1.toString());
      q();
    }
    else
    {
      QLog.e("ZipFilePresenter<QFile>", 1, "onGetZipFileList, mFiles is null");
      b(-1000L);
    }
    this.e = false;
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void b()
  {
    String str;
    if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d()))
    {
      if (QbSdk.isSuportOpenFile(FileManagerUtil.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()), 2))
      {
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131694650);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(str, new ZipFilePresenter.4(this));
      }
    }
    else
    {
      str = this.jdField_a_of_type_AndroidAppActivity.getString(2131692718);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(str, new ZipFilePresenter.5(this));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i() == 4) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.e(false);
    }
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.a(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(true);
    b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.c(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(false);
    q();
    h();
    b();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.c();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(false);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    }
    h();
    b();
  }
  
  public void g()
  {
    m();
    h();
    b();
  }
  
  public void j()
  {
    super.j();
  }
  
  public void k()
  {
    if (this.d) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b("", "");
    }
  }
  
  protected void m()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h();
    if ((i != 2) && (i != 3))
    {
      if (i == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().b();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("ZipFilePresenter<QFile>", 2, "zip file stop trans, but can not handle trans type");
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().b();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerZipFileViewer.b(false);
    q();
    h();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter
 * JD-Core Version:    0.7.0.1
 */