package com.tencent.mobileqq.filebrowser.presenter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView;
import com.tencent.mobileqq.filemanager.util.QBrowserUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AppStoreApkFilePresenter$2
  implements View.OnClickListener
{
  AppStoreApkFilePresenter$2(AppStoreApkFilePresenter paramAppStoreApkFilePresenter) {}
  
  public void onClick(View paramView)
  {
    if ((TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.g())) || (!this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(this.a.jdField_a_of_type_AndroidAppActivity, AppStoreApkFilePresenter.a(this.a))))
    {
      int i = QBrowserUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      ReportController.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, localStringBuilder.toString(), "", "", "");
      this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.f();
      this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.f(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.AppStoreApkFilePresenter.2
 * JD-Core Version:    0.7.0.1
 */