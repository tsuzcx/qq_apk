package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigProcessor;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class PreviewSimpleFilePresenter
  extends DocFilePresenter
{
  public PreviewSimpleFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
  }
  
  private boolean a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = ((IFMConfig)QRoute.api(IFMConfig.class)).getPreviewConfig(paramContext, paramString, "FileMaxSize");
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    if (Integer.parseInt(paramContext) * 1048576 >= paramLong) {
      bool = true;
    }
    return bool;
  }
  
  private boolean b()
  {
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a(), this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a())) || (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).supportTencentDoc(TencentDocPreviewConfigProcessor.a().a(), this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b(), this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a(), this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("DocFilePresenter", 1, "FileBrowserPresenter init: type = preview simple");
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
    h();
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.e(true ^ this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.b());
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.d() != 16)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.d()) {
        return;
      }
      if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b()))
      {
        super.h();
        return;
      }
      if ((NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext)) && (b()))
      {
        String str = this.jdField_a_of_type_AndroidContentContext.getString(2131692718);
        this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.b(str, new PreviewSimpleFilePresenter.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.PreviewSimpleFilePresenter
 * JD-Core Version:    0.7.0.1
 */