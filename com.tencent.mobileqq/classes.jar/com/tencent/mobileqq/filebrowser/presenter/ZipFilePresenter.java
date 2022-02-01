package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnThumbEventListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnTransEventListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnZipEventListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.ZipFileData;
import com.tencent.mobileqq.filebrowser.view.ZipFileBrowserView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
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
  implements IFileBrowserModel.OnThumbEventListener, IFileBrowserModel.OnTransEventListener, IFileBrowserModel.OnZipEventListener
{
  protected ZipFileBrowserView a;
  private List<IFileBrowserModel.ZipFileData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean d = false;
  
  public ZipFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView = new ZipFileBrowserView(paramActivity);
    a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView);
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.g(false);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.e(true);
    g();
    if (FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131692725), new ZipFilePresenter.2(this));
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.b(true);
      return;
    }
    if (paramLong == -1000L) {
      return;
    }
    if ((paramLong != -7003L) && (paramLong != -6101L))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.f(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.f(this.jdField_a_of_type_AndroidContentContext.getString(2131692353));
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.f(false);
  }
  
  private void h()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new ZipFilePresenter.3(this), 10000L);
  }
  
  private void j()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c();
    if (i == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.c(true);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.a(false);
      return;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.a(false);
      return;
    }
    if (i == 6)
    {
      localZipFileBrowserView = this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131692377));
      localStringBuilder.append("(");
      localStringBuilder.append(FileSizeFormat.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()));
      localStringBuilder.append(")");
      localZipFileBrowserView.a(true, localStringBuilder.toString(), new ZipFilePresenter.6(this));
      return;
    }
    ZipFileBrowserView localZipFileBrowserView = this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131692704));
    localStringBuilder.append("(");
    localStringBuilder.append(FileSizeFormat.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()));
    localStringBuilder.append(")");
    localZipFileBrowserView.a(true, localStringBuilder.toString(), new ZipFilePresenter.7(this));
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("ZipFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = zip");
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, null);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.i(bool);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a());
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.d(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.b());
    ZipFileBrowserView localZipFileBrowserView = this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131692477));
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
    localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131692476));
    localStringBuilder.append(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()));
    localZipFileBrowserView.e(localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(this);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(this);
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      b(-1000L);
    }
    else if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.j();
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.g(true);
      this.d = true;
      h();
    }
    if ((!FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b())) && (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.b()))
    {
      b(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a());
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.c(true);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.a(false);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.b(false);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.f();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(this);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.a(false);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.c(true);
    b(paramFloat);
  }
  
  public void a(long paramLong)
  {
    ThreadManagerV2.getUIHandlerV2().post(new ZipFilePresenter.1(this, paramLong));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.b(paramString1, paramString2);
  }
  
  public void a(List<IFileBrowserModel.ZipFileData> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort)
  {
    if (!this.d) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a();
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a());
      paramList = this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView;
      paramString1 = new StringBuilder();
      paramString1.append(this.jdField_a_of_type_AndroidContentContext.getString(2131692477));
      paramString1.append(this.jdField_a_of_type_JavaUtilList.size());
      paramString1.append(this.jdField_a_of_type_AndroidContentContext.getString(2131692476));
      paramString1.append(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()));
      paramList.e(paramString1.toString());
      j();
    }
    else
    {
      QLog.e("ZipFilePresenter<QFile>", 1, "onGetZipFileList, mFiles is null");
      b(-1000L);
    }
    this.d = false;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.a(false);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.b(false);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.c(true);
    b(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a());
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.a(paramString1, paramString2);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.c(false);
    j();
    f();
    g();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.a(false);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.c(false);
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserListener.a();
    }
    f();
    g();
  }
  
  public void e()
  {
    p();
    f();
    g();
  }
  
  protected void g()
  {
    String str;
    if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b()))
    {
      if (QbSdk.isSuportOpenFile(QQFileManagerUtil.h(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()), 2))
      {
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131694650);
        this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.b(str, new ZipFilePresenter.4(this));
      }
    }
    else
    {
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692718);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.b(str, new ZipFilePresenter.5(this));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c() == 4) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.f(false);
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.b("", "");
    }
  }
  
  public void m()
  {
    super.m();
  }
  
  protected void p()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.b();
    if ((i != 2) && (i != 3))
    {
      if (i == 1) {
        this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.e();
      } else if (QLog.isColorLevel()) {
        QLog.i("ZipFilePresenter<QFile>", 2, "zip file stop trans, but can not handle trans type");
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.g();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewZipFileBrowserView.c(false);
    j();
    f();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.ZipFilePresenter
 * JD-Core Version:    0.7.0.1
 */