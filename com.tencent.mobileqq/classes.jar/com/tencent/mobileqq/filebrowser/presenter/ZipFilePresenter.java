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
  private List<IFileBrowserModel.ZipFileData> b = new ArrayList();
  private boolean k = false;
  private boolean l = false;
  
  public ZipFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
    this.a = new ZipFileBrowserView(paramActivity);
    a(this.a);
  }
  
  private void b(long paramLong)
  {
    this.a.g(false);
    this.a.e(true);
    h();
    if (FileUtil.b(this.d.c()))
    {
      this.a.a(this.f.getString(2131889796), new ZipFilePresenter.2(this));
      this.a.b(true);
      return;
    }
    if (paramLong == -1000L) {
      return;
    }
    if ((paramLong != -7003L) && (paramLong != -6101L))
    {
      this.a.f(false);
      return;
    }
    this.a.f(this.f.getString(2131889341));
    this.a.f(false);
  }
  
  private void i()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new ZipFilePresenter.3(this), 10000L);
  }
  
  private void k()
  {
    int i = this.c.k();
    if (i == 4)
    {
      this.a.c(true);
      this.a.a(false);
      return;
    }
    if (i == 2)
    {
      this.a.a(false);
      return;
    }
    if (i == 6)
    {
      localZipFileBrowserView = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.f.getString(2131889365));
      localStringBuilder.append("(");
      localStringBuilder.append(FileSizeFormat.a(this.d.b()));
      localStringBuilder.append(")");
      localZipFileBrowserView.a(true, localStringBuilder.toString(), new ZipFilePresenter.6(this));
      return;
    }
    ZipFileBrowserView localZipFileBrowserView = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f.getString(2131889775));
    localStringBuilder.append("(");
    localStringBuilder.append(FileSizeFormat.a(this.d.b()));
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
    this.a.i(bool);
    this.a.a(this.d.a());
    this.a.d(this.c.h());
    ZipFileBrowserView localZipFileBrowserView = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f.getString(2131889465));
    localStringBuilder.append(this.b.size());
    localStringBuilder.append(this.f.getString(2131889464));
    localStringBuilder.append(FileUtil.a(this.d.b()));
    localZipFileBrowserView.e(localStringBuilder.toString());
    this.c.a(this);
    this.c.a(this);
    if (!NetworkUtil.isNetworkAvailable(this.f))
    {
      b(-1000L);
    }
    else if (!this.k)
    {
      this.c.C();
      this.k = true;
      this.a.g(true);
      this.l = true;
      i();
    }
    if ((!FileUtil.b(this.d.c())) && (this.c.n()))
    {
      b(this.c.l());
      this.a.c(true);
      this.a.a(false);
      this.a.b(false);
      this.c.y();
    }
    this.c.a(this);
  }
  
  public void a(float paramFloat)
  {
    this.a.a(false);
    this.a.c(true);
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
  
  public void a(List<IFileBrowserModel.ZipFileData> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort)
  {
    if (!this.l) {
      return;
    }
    this.c.G();
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.b = paramList;
      this.a.a(this.c.G());
      paramList = this.a;
      paramString1 = new StringBuilder();
      paramString1.append(this.f.getString(2131889465));
      paramString1.append(this.b.size());
      paramString1.append(this.f.getString(2131889464));
      paramString1.append(FileUtil.a(this.d.b()));
      paramList.e(paramString1.toString());
      k();
    }
    else
    {
      QLog.e("ZipFilePresenter<QFile>", 1, "onGetZipFileList, mFiles is null");
      b(-1000L);
    }
    this.l = false;
  }
  
  public void b()
  {
    this.a.a(false);
    this.a.b(false);
    this.a.c(true);
    b(this.c.l());
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.a.a(paramString1, paramString2);
  }
  
  public void c()
  {
    this.a.a(true);
    this.a.c(false);
    k();
    f();
    h();
  }
  
  public void d()
  {
    this.a.a(false);
    this.a.c(false);
    if (this.g != null) {
      this.g.a();
    }
    f();
    h();
  }
  
  public void e()
  {
    q();
    f();
    h();
  }
  
  public boolean g()
  {
    return false;
  }
  
  protected void h()
  {
    String str;
    if (FileUtils.fileExistsAndNotEmpty(this.d.c()))
    {
      if (QbSdk.isSuportOpenFile(QQFileManagerUtil.y(this.d.a()), 2))
      {
        str = this.f.getString(2131892336);
        this.a.b(str, new ZipFilePresenter.4(this));
      }
    }
    else
    {
      str = this.f.getString(2131889789);
      this.a.b(str, new ZipFilePresenter.5(this));
    }
    if (this.c.k() == 4) {
      this.a.f(false);
    }
  }
  
  public void l()
  {
    if (this.k) {
      this.a.b("", "");
    }
  }
  
  public void m()
  {
    super.m();
  }
  
  protected void q()
  {
    int i = this.c.g();
    if ((i != 2) && (i != 3))
    {
      if (i == 1) {
        this.c.x();
      } else if (QLog.isColorLevel()) {
        QLog.i("ZipFilePresenter<QFile>", 2, "zip file stop trans, but can not handle trans type");
      }
    }
    else {
      this.c.z();
    }
    this.a.c(false);
    k();
    f();
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.ZipFilePresenter
 * JD-Core Version:    0.7.0.1
 */