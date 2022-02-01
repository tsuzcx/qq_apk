package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnAppStorePromoteListener;
import com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileSizeFormat;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AppStoreApkFilePresenter
  extends SimpleFilePresenter
  implements View.OnClickListener
{
  private final IFileBrowserModel.OnAppStorePromoteListener a;
  
  public AppStoreApkFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel$OnAppStorePromoteListener = new AppStoreApkFilePresenter.1(this);
    a(new SimpleFileBrowserView(paramActivity));
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("AppStoreApkFilePresenter", 1, "FileBrowserPresenter init: type = preview simple");
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.e();
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.e(2130844325);
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.g(str);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.f(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.e());
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c())) && (16 != this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.d())) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.h(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c());
    } else {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.g(false);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c())) && (16 != this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.d())) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.h(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c());
    } else {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.g(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.d() == 16) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131692353));
    } else if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.d()) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131692559));
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.e(true ^ this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.b());
    str = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.g();
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.e(str);
    }
  }
  
  protected void f()
  {
    super.f();
    int i = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c();
    if ((i != 6) && (i != 2) && (i != 4) && (i != 5))
    {
      this.c = true;
      SimpleFileBrowserView localSimpleFileBrowserView = this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131692704));
      localStringBuilder.append("(");
      localStringBuilder.append(FileSizeFormat.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()));
      localStringBuilder.append(")");
      localSimpleFileBrowserView.a(localStringBuilder.toString(), new AppStoreApkFilePresenter.2(this));
    }
  }
  
  protected void g()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(this.jdField_a_of_type_AndroidContentContext);
    if (str != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.b(str, this);
      ReportController.b(null, "dc00898", "", "", "0X800AE3B", "0X800AE3B", 0, 0, "", "", "", "");
    }
  }
  
  protected void h() {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800AE3C", "0X800AE3C", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(this.jdField_a_of_type_AndroidAppActivity);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.AppStoreApkFilePresenter
 * JD-Core Version:    0.7.0.1
 */