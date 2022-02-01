package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.res.Configuration;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class DocExportFilePresenter
  extends FileBrowserPresenterBase
  implements FileBrowserModelBase.OnTransEventListener
{
  protected boolean a = true;
  protected SimpleFileViewer b = new SimpleFileViewer(this.d);
  private SpannableString j;
  private LocalTbsViewManager.LocalTbsViewManagerCallback k = new DocExportFilePresenter.3(this);
  
  public DocExportFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
    a(this.b);
  }
  
  private String u()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)localAppRuntime).getCurrentUin();
    }
    return localAppRuntime.getAccount();
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = simple");
    }
    this.b.d(this.c.v());
    if (FileManagerUtil.s(this.c.y())) {
      i();
    } else {
      j();
    }
    this.c.a(this);
    View localView1 = this.b.b();
    if (localView1 != null)
    {
      View localView2 = localView1.findViewById(2131447805);
      if (localView2 != null) {
        localView2.setVisibility(8);
      }
      localView2 = localView1.findViewById(2131433120);
      if (localView2 != null) {
        localView2.setVisibility(8);
      }
      localView1 = localView1.findViewById(2131433111);
      if (localView1 != null) {
        localView1.setVisibility(8);
      }
    }
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    paramConfiguration = new DisplayMetrics();
    this.d.getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    int i = paramConfiguration.widthPixels;
    int m = paramConfiguration.heightPixels;
    this.b.a(i, m);
  }
  
  protected void b(float paramFloat)
  {
    SimpleFileViewer localSimpleFileViewer = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131901506));
    int i = (int)paramFloat;
    localStringBuilder.append(i);
    localStringBuilder.append("%");
    localSimpleFileViewer.a(localStringBuilder.toString());
    this.b.a(i);
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  public boolean c()
  {
    if (this.a) {
      this.d.setRequestedOrientation(1);
    }
    return this.a ^ true;
  }
  
  public void d()
  {
    this.b.a(false);
    this.b.b(true);
    b(this.c.J());
  }
  
  public void e()
  {
    this.b.a(true);
    this.b.b(false);
    h();
  }
  
  public void f()
  {
    this.b.a(true);
    this.b.b(false);
    h();
    if (this.e != null) {
      this.e.b();
    }
  }
  
  public void g()
  {
    this.b.b(false);
    h();
  }
  
  protected void i()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SimpleFilePresenter handleLocalFile: fileName[");
      ((StringBuilder)localObject).append(this.c.v());
      ((StringBuilder)localObject).append("] filePath[");
      ((StringBuilder)localObject).append(this.c.y());
      ((StringBuilder)localObject).append("]");
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b.b();
    if ((localObject != null) && (((View)localObject).getParent() != null) && (((View)localObject).getParent().getParent() != null) && (SharedPreUtils.bX(this.d, u())) && (((View)localObject).getParent() != null) && (((View)localObject).getParent().getParent() != null))
    {
      localObject = ((ViewGroup)((View)localObject).getParent().getParent()).findViewById(2131445540);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        SharedPreUtils.o(this.d, u(), false);
        new MqqHandler().postDelayed(new DocExportFilePresenter.1(this, (View)localObject), 5000L);
      }
    }
    if (this.c.R() == 2) {
      LocalTbsViewManager.a().a(this.d, this.c.y(), this.k, true);
    }
    this.b.c(FileManagerUtil.i(this.c.v()));
    this.b.g(this.c.D());
    this.d.getString(2131889341);
    if (this.c.b() == 16)
    {
      localObject = BaseApplicationImpl.getContext().getString(2131889341);
      this.b.c((String)localObject);
      this.b.c(true);
      return;
    }
    if (QbSdk.isSuportOpenFile(FileManagerUtil.t(this.c.v()), 2))
    {
      this.j = FileManagerUtil.a(BaseApplicationImpl.getContext().getString(2131889787), BaseApplicationImpl.getContext().getString(2131892336), new DocExportFilePresenter.2(this));
      this.b.a(this.j);
    }
    else
    {
      localObject = BaseApplicationImpl.getContext().getString(2131889786);
      this.b.c((String)localObject);
    }
    this.b.c(true);
  }
  
  protected void j()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SimpleFilePresenter handleCloudFile: fileName[");
      localStringBuilder.append(this.c.v());
      localStringBuilder.append("]");
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, localStringBuilder.toString());
    }
    int i = this.c.z();
    if (i == 5)
    {
      this.b.d(2130845642);
      this.b.e(this.c.E());
    }
    else
    {
      this.b.c(FileManagerUtil.i(this.c.v()));
    }
    if ((!TextUtils.isEmpty(this.c.I())) && (16 != this.c.b())) {
      this.b.g(this.c.I());
    } else {
      this.b.e(false);
    }
    if (i == 1) {
      this.b.c(BaseApplicationImpl.getContext().getString(2131889767));
    } else if (i == 2) {
      this.b.c(BaseApplicationImpl.getContext().getString(2131889771));
    } else {
      this.b.c(BaseApplicationImpl.getContext().getString(2131889768));
    }
    if (this.c.b() == 16)
    {
      this.b.c(BaseApplicationImpl.getContext().getString(2131889341));
      return;
    }
    if (this.c.F())
    {
      this.b.c(BaseApplicationImpl.getContext().getString(2131889582));
      return;
    }
    if (this.c.G())
    {
      this.b.c(BaseApplicationImpl.getContext().getString(2131889341));
      return;
    }
    if ((this.c.P()) && (this.c.f() != null))
    {
      this.c.f().a();
      this.b.b(true);
      this.b.a(false);
      b(0.0F);
    }
  }
  
  public void k()
  {
    SimpleFileViewer localSimpleFileViewer = this.b;
    if (localSimpleFileViewer != null) {
      localSimpleFileViewer.h();
    }
    super.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.DocExportFilePresenter
 * JD-Core Version:    0.7.0.1
 */