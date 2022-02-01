package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileSizeFormat;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public abstract class FileBrowserPresenterBase
{
  private FileBrowserViewBase a;
  private boolean b = true;
  protected IFileBrowserModel c;
  protected IFileBrowserData d;
  protected Activity e;
  protected Context f;
  protected IFileBrowserListener g;
  protected boolean h = false;
  protected boolean i = false;
  protected Bundle j;
  
  public FileBrowserPresenterBase(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    this.c = paramIFileBrowserModel;
    this.e = paramActivity;
    this.f = BaseApplication.getContext();
    this.d = paramIFileBrowserModel.a();
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
    localFileBrowserViewBase.a(this.j);
    this.a.g();
    f();
    this.a.a(new FileBrowserPresenterBase.1(this));
    if (this.c.k() == 4)
    {
      this.a.c(true);
      this.a.b(false);
      b(this.c.l());
    }
    if ((!this.c.n()) && (this.b) && (this.i)) {
      ReportController.b(null, "dc00898", "", "", "0X800A687", "0X800A687", 0, 0, "", "", "", "");
    }
    this.b = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Bundle paramBundle)
  {
    this.j = paramBundle;
  }
  
  public void a(IFileBrowserListener paramIFileBrowserListener)
  {
    this.g = paramIFileBrowserListener;
  }
  
  protected void a(FileBrowserViewBase paramFileBrowserViewBase)
  {
    this.a = paramFileBrowserViewBase;
  }
  
  protected void b(float paramFloat)
  {
    int k = this.c.g();
    if (k == 1) {
      str = this.f.getString(2131889819);
    } else if (k == 4) {
      str = this.f.getString(2131889797);
    } else {
      str = this.f.getString(2131889778);
    }
    k = (int)((float)this.d.b() * paramFloat);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("(");
    localStringBuilder.append(FileUtil.a(k));
    localStringBuilder.append("/");
    localStringBuilder.append(FileUtil.a(this.d.b()));
    localStringBuilder.append(")");
    String str = localStringBuilder.toString();
    this.a.b(str);
    this.a.c((int)(paramFloat * 100.0F));
  }
  
  protected void f()
  {
    this.i = false;
    this.h = false;
    int k = this.c.k();
    Object localObject1;
    Object localObject2;
    if (k == 6)
    {
      if (this.c.g() == 1)
      {
        localObject1 = this.f.getString(2131889366);
      }
      else
      {
        this.i = true;
        localObject1 = this.f.getString(2131889365);
      }
      localObject2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("(");
      localStringBuilder.append(FileSizeFormat.a(this.d.b()));
      localStringBuilder.append(")");
      ((FileBrowserViewBase)localObject2).a(localStringBuilder.toString(), new FileBrowserPresenterBase.3(this));
      this.a.c(false);
      this.a.b(true);
      return;
    }
    if (k == 2)
    {
      this.a.a(this.f.getString(2131889796), new FileBrowserPresenterBase.4(this));
      this.a.b(true);
      return;
    }
    if (k == 4)
    {
      this.a.c(true);
      b(this.c.l());
      this.a.b(false);
      return;
    }
    if (k == 5)
    {
      this.a.b(false);
      return;
    }
    if ((this.d.f() == 9501) && (NetworkUtil.isWifiConnected(this.f)))
    {
      this.c.y();
    }
    else
    {
      this.i = true;
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.f.getString(2131889775));
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append(FileSizeFormat.a(this.d.b()));
      ((StringBuilder)localObject2).append(")");
      ((FileBrowserViewBase)localObject1).a(((StringBuilder)localObject2).toString(), new FileBrowserPresenterBase.5(this));
    }
    this.a.c(false);
    this.a.b(true);
  }
  
  public abstract boolean g();
  
  public void j() {}
  
  public void l() {}
  
  public void m() {}
  
  public void o() {}
  
  public FileBrowserViewBase p()
  {
    return this.a;
  }
  
  protected void q()
  {
    int k = this.c.g();
    if ((k != 2) && (k != 4))
    {
      if (k == 1) {
        this.c.x();
      }
    }
    else {
      this.c.z();
    }
    this.a.c(false);
    new Handler().postDelayed(new FileBrowserPresenterBase.2(this), 100L);
  }
  
  public String r()
  {
    return this.d.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
 * JD-Core Version:    0.7.0.1
 */