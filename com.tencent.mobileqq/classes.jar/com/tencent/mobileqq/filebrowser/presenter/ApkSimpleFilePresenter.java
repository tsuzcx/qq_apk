package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnMMApkSafeCheckListener;
import com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ApkSimpleFilePresenter
  extends SimpleFilePresenter
  implements IFileBrowserModel.OnMMApkSafeCheckListener
{
  public ApkSimpleFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
    a(new SimpleFileBrowserView(paramActivity));
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt != 0) && (paramInt != 4) && (!TextUtils.isEmpty(paramString1)))
    {
      String str = BaseApplication.getContext().getString(2131692714);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.a(str, false);
      if (!TextUtils.isEmpty(paramString2))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.a(paramString1, 0, new ApkSimpleFilePresenter.2(this, paramString2));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.a(paramString1, 0, null);
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = apk simple");
    }
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131692714);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.a(str, true);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.e(false);
    a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.e(), this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.f(), this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.g());
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.e(2130844325);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.f(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.e());
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(this);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    a(paramInt, paramString1, paramString2);
  }
  
  protected void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c() == 2) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131692710), new ApkSimpleFilePresenter.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.ApkSimpleFilePresenter
 * JD-Core Version:    0.7.0.1
 */