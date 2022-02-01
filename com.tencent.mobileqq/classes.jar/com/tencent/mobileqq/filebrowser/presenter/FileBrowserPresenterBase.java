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
  protected Activity a;
  protected Context a;
  protected Bundle a;
  protected IFileBrowserData a;
  protected IFileBrowserListener a;
  protected IFileBrowserModel a;
  private FileBrowserViewBase jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase;
  private boolean jdField_a_of_type_Boolean = true;
  protected boolean b = false;
  protected boolean c = false;
  
  public FileBrowserPresenterBase(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel = paramIFileBrowserModel;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData = paramIFileBrowserModel.a();
  }
  
  public FileBrowserViewBase a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but model is null");
      return;
    }
    FileBrowserViewBase localFileBrowserViewBase = this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase;
    if (localFileBrowserViewBase == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but fileViewer is null");
      return;
    }
    localFileBrowserViewBase.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.e();
    f();
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.a(new FileBrowserPresenterBase.1(this));
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c() == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.c(true);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.b(false);
      b(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a());
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.b()) && (this.jdField_a_of_type_Boolean) && (this.c)) {
      ReportController.b(null, "dc00898", "", "", "0X800A687", "0X800A687", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(IFileBrowserListener paramIFileBrowserListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserListener = paramIFileBrowserListener;
  }
  
  protected void a(FileBrowserViewBase paramFileBrowserViewBase)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase = paramFileBrowserViewBase;
  }
  
  public abstract boolean a();
  
  protected void b(float paramFloat)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.b();
    if (i == 1) {
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692748);
    } else if (i == 4) {
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692726);
    } else {
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692707);
    }
    i = (int)((float)this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a() * paramFloat);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("(");
    localStringBuilder.append(FileUtil.a(i));
    localStringBuilder.append("/");
    localStringBuilder.append(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()));
    localStringBuilder.append(")");
    String str = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.b(str);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.c((int)(paramFloat * 100.0F));
  }
  
  protected void f()
  {
    this.c = false;
    this.b = false;
    int i = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c();
    Object localObject1;
    Object localObject2;
    if (i == 6)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.b() == 1)
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692378);
      }
      else
      {
        this.c = true;
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692377);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("(");
      localStringBuilder.append(FileSizeFormat.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()));
      localStringBuilder.append(")");
      ((FileBrowserViewBase)localObject2).a(localStringBuilder.toString(), new FileBrowserPresenterBase.3(this));
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.c(false);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.b(true);
      return;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.a(this.jdField_a_of_type_AndroidContentContext.getString(2131692725), new FileBrowserPresenterBase.4(this));
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.b(true);
      return;
    }
    if (i == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.c(true);
      b(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a());
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.b(false);
      return;
    }
    if (i == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.b(false);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.c() == 9501) && (NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext)))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.f();
    }
    else
    {
      this.c = true;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692704));
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append(FileSizeFormat.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()));
      ((StringBuilder)localObject2).append(")");
      ((FileBrowserViewBase)localObject1).a(((StringBuilder)localObject2).toString(), new FileBrowserPresenterBase.5(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.c(false);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.b(true);
  }
  
  public void i() {}
  
  public void l() {}
  
  public void m() {}
  
  public void o() {}
  
  protected void p()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.b();
    if ((i != 2) && (i != 4))
    {
      if (i == 1) {
        this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.e();
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.g();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.c(false);
    new Handler().postDelayed(new FileBrowserPresenterBase.2(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
 * JD-Core Version:    0.7.0.1
 */