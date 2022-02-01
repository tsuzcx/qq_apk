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
  private FileBrowserViewBase a;
  private boolean b = true;
  protected FileBrowserModelBase c;
  protected Activity d;
  protected IFileBrowser e;
  protected IFileViewListener f;
  protected boolean g = false;
  protected boolean h = false;
  protected Bundle i;
  
  public FileBrowserPresenterBase(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    this.c = paramFileBrowserModelBase;
    this.d = paramActivity;
  }
  
  public void a()
  {
    if (this.c == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but model is null");
      return;
    }
    FileBrowserViewBase localFileBrowserViewBase = this.a;
    if (localFileBrowserViewBase == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but fileViewer is null");
      return;
    }
    localFileBrowserViewBase.a(this.i);
    this.a.a();
    h();
    this.a.a(new FileBrowserPresenterBase.1(this));
    if (this.c.R() == 4)
    {
      this.a.b(true);
      this.a.a(false);
      b(this.c.J());
    }
    this.a.a(this);
    if ((!this.c.P()) && (this.b) && (this.h)) {
      ReportController.b(null, "dc00898", "", "", "0X800A687", "0X800A687", 0, 0, "", "", "", "");
    }
    this.b = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(Bundle paramBundle)
  {
    this.i = paramBundle;
  }
  
  public void a(IFileBrowser paramIFileBrowser)
  {
    this.e = paramIFileBrowser;
  }
  
  public void a(IFileViewListener paramIFileViewListener)
  {
    this.f = paramIFileViewListener;
  }
  
  protected void a(FileBrowserViewBase paramFileBrowserViewBase)
  {
    this.a = paramFileBrowserViewBase;
  }
  
  protected void b(float paramFloat)
  {
    int j = (int)((float)this.c.x() * paramFloat);
    int k = this.c.O();
    FileBrowserViewBase localFileBrowserViewBase;
    StringBuilder localStringBuilder;
    if (k == 1)
    {
      localFileBrowserViewBase = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d.getString(2131889819));
      localStringBuilder.append("(");
      localStringBuilder.append(FileUtil.a(j));
      localStringBuilder.append("/");
      localStringBuilder.append(FileUtil.a(this.c.x()));
      localStringBuilder.append(")");
      localFileBrowserViewBase.a(localStringBuilder.toString());
    }
    else if (k == 4)
    {
      localFileBrowserViewBase = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d.getString(2131889797));
      localStringBuilder.append("(");
      localStringBuilder.append(FileUtil.a(j));
      localStringBuilder.append("/");
      localStringBuilder.append(FileUtil.a(this.c.x()));
      localStringBuilder.append(")");
      localFileBrowserViewBase.a(localStringBuilder.toString());
    }
    else
    {
      localFileBrowserViewBase = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d.getString(2131889778));
      localStringBuilder.append("(");
      localStringBuilder.append(FileUtil.a(j));
      localStringBuilder.append("/");
      localStringBuilder.append(FileUtil.a(this.c.x()));
      localStringBuilder.append(")");
      localFileBrowserViewBase.a(localStringBuilder.toString());
    }
    this.a.a((int)(paramFloat * 100.0F));
  }
  
  public abstract boolean b();
  
  public abstract boolean c();
  
  protected void h()
  {
    this.h = false;
    this.g = false;
    int j = this.c.R();
    Object localObject1;
    Object localObject2;
    if (j == 6)
    {
      this.d.getString(2131889365);
      if (this.c.O() == 1)
      {
        localObject1 = this.d.getString(2131889366);
      }
      else
      {
        this.h = true;
        localObject1 = this.d.getString(2131889365);
      }
      localObject2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("(");
      localStringBuilder.append(FileSizeFormat.a(this.c.x()));
      localStringBuilder.append(")");
      ((FileBrowserViewBase)localObject2).a(localStringBuilder.toString(), new FileBrowserPresenterBase.3(this));
      this.a.b(false);
      this.a.a(true);
      return;
    }
    if (j == 2)
    {
      this.a.a(HardCodeUtil.a(2131902509), new FileBrowserPresenterBase.4(this));
      this.a.a(true);
      return;
    }
    if (j == 4)
    {
      this.a.b(true);
      b(this.c.J());
      this.a.a(false);
      return;
    }
    if (j == 5)
    {
      this.a.a(false);
      return;
    }
    if ((this.c.B() == 9501) && (NetworkUtil.isWifiConnected(this.d)))
    {
      localObject1 = this.c.f();
      if (localObject1 != null) {
        ((IDownloadController)localObject1).a();
      }
    }
    else
    {
      this.h = true;
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131902506));
      ((StringBuilder)localObject2).append(FileSizeFormat.a(this.c.x()));
      ((StringBuilder)localObject2).append(")");
      ((FileBrowserViewBase)localObject1).a(((StringBuilder)localObject2).toString(), new FileBrowserPresenterBase.5(this));
    }
    this.a.b(false);
    this.a.a(true);
  }
  
  public void k() {}
  
  public void l() {}
  
  public void m() {}
  
  public void n() {}
  
  public FileBrowserViewBase o()
  {
    return this.a;
  }
  
  protected void p()
  {
    int j = this.c.O();
    if ((j != 2) && (j != 4))
    {
      if ((j == 1) && (this.c.e() != null)) {
        this.c.e().b();
      }
    }
    else if (this.c.f() != null) {
      this.c.f().b();
    }
    this.a.b(false);
    new Handler().postDelayed(new FileBrowserPresenterBase.2(this), 100L);
  }
  
  public String q()
  {
    return this.c.v();
  }
  
  protected void r()
  {
    this.d.finish();
    this.d.overridePendingTransition(0, 0);
  }
  
  public void s()
  {
    r();
  }
  
  public void t() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
 * JD-Core Version:    0.7.0.1
 */