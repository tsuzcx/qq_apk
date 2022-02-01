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
  private List<ZipFilePresenter.FileData> b = new ArrayList();
  private boolean j;
  private boolean k = false;
  private boolean l = false;
  
  public ZipFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
    this.a = new ZipFileViewer(paramActivity);
    a(this.a);
  }
  
  private void b(long paramLong)
  {
    this.a.f(false);
    this.a.d(true);
    i();
    if (FileUtil.b(this.c.y()))
    {
      this.a.a(HardCodeUtil.a(2131889793), new ZipFilePresenter.2(this));
      this.a.a(true);
      return;
    }
    if (paramLong == -1000L) {
      return;
    }
    if ((paramLong != -7003L) && (paramLong != -6101L))
    {
      this.a.e(false);
      return;
    }
    this.c.a(16);
    this.a.f(this.d.getString(2131889341));
    this.a.e(false);
  }
  
  private void j()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new ZipFilePresenter.3(this), 3000L);
  }
  
  private void u()
  {
    int i = this.c.R();
    if (i == 4)
    {
      this.a.b(true);
      this.a.c(false);
      return;
    }
    if (i == 2)
    {
      this.a.c(false);
      return;
    }
    if (i == 6)
    {
      localZipFileViewer = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131913946));
      localStringBuilder.append("(");
      localStringBuilder.append(FileSizeFormat.a(this.c.x()));
      localStringBuilder.append(")");
      localZipFileViewer.a(true, localStringBuilder.toString(), new ZipFilePresenter.6(this));
      return;
    }
    ZipFileViewer localZipFileViewer = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131913943));
    localStringBuilder.append("(");
    localStringBuilder.append(FileSizeFormat.a(this.c.x()));
    localStringBuilder.append(")");
    localZipFileViewer.a(true, localStringBuilder.toString(), new ZipFilePresenter.7(this));
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("ZipFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = zip");
    }
    this.j = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    this.a.h(this.j);
    this.a.c(this.c.v());
    this.a.d(this.c.D());
    ZipFileViewer localZipFileViewer = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131913942));
    localStringBuilder.append(this.b.size());
    localStringBuilder.append(HardCodeUtil.a(2131913947));
    localStringBuilder.append(FileUtil.a(this.c.x()));
    localZipFileViewer.e(localStringBuilder.toString());
    this.c.a(this);
    this.c.a(this);
    if (!NetworkUtil.isNetworkAvailable(this.d))
    {
      b(-1000L);
    }
    else if (!this.k)
    {
      this.c.M();
      this.k = true;
      this.a.f(true);
      this.l = true;
      j();
    }
    if ((!FileUtil.b(this.c.y())) && (this.c.P()) && (this.c.f() != null))
    {
      b(this.c.J());
      this.a.b(true);
      this.a.c(false);
      this.a.a(false);
      this.c.f().a();
    }
    this.c.a(this);
  }
  
  public void a(float paramFloat)
  {
    this.a.c(false);
    this.a.b(true);
    b(paramFloat);
  }
  
  public void a(long paramLong)
  {
    ThreadManagerV2.getUIHandlerV2().post(new ZipFilePresenter.1(this, paramLong));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.b(paramString1, paramString2);
  }
  
  public void a(List<ZipFilePresenter.FileData> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort)
  {
    if (!this.l) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.b = paramList;
      this.a.a(paramList, this.c.y(), this.c.C(), this.c.r(), paramString2, paramString3, paramString4, paramString1, paramBoolean, paramString5, paramShort);
      paramList = this.a;
      paramString1 = new StringBuilder();
      paramString1.append(HardCodeUtil.a(2131913944));
      paramString1.append(this.b.size());
      paramString1.append(HardCodeUtil.a(2131913945));
      paramString1.append(FileUtil.a(this.c.x()));
      paramList.e(paramString1.toString());
      u();
    }
    else
    {
      QLog.e("ZipFilePresenter<QFile>", 1, "onGetZipFileList, mFiles is null");
      b(-1000L);
    }
    this.l = false;
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.a.a(paramString1, paramString2);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d()
  {
    this.a.c(false);
    this.a.a(false);
    this.a.b(true);
    b(this.c.J());
  }
  
  public void e()
  {
    this.a.c(true);
    this.a.b(false);
    u();
    h();
    i();
  }
  
  public void f()
  {
    this.a.e();
    this.a.b(false);
    if (this.e != null) {
      this.e.b();
    }
    h();
    i();
  }
  
  public void g()
  {
    p();
    h();
    i();
  }
  
  protected void i()
  {
    String str;
    if (FileUtils.fileExistsAndNotEmpty(this.c.y()))
    {
      if (QbSdk.isSuportOpenFile(FileManagerUtil.t(this.c.v()), 2))
      {
        str = this.d.getString(2131892336);
        this.a.b(str, new ZipFilePresenter.4(this));
      }
    }
    else
    {
      str = this.d.getString(2131889789);
      this.a.b(str, new ZipFilePresenter.5(this));
    }
    if (this.c.R() == 4) {
      this.a.e(false);
    }
  }
  
  public void l()
  {
    super.l();
  }
  
  public void m()
  {
    if (this.k) {
      this.a.b("", "");
    }
  }
  
  protected void p()
  {
    int i = this.c.O();
    if ((i != 2) && (i != 3))
    {
      if (i == 1)
      {
        if (this.c.e() != null) {
          this.c.e().b();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("ZipFilePresenter<QFile>", 2, "zip file stop trans, but can not handle trans type");
      }
    }
    else if (this.c.f() != null) {
      this.c.f().b();
    }
    this.a.b(false);
    u();
    h();
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter
 * JD-Core Version:    0.7.0.1
 */