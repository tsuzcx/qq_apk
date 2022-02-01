package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnTransEventListener;
import com.tencent.mobileqq.filebrowser.view.DocFileBrowserView;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import mqq.os.MqqHandler;

public class DocExportFilePresenter
  extends FileBrowserPresenterBase
  implements IFileBrowserModel.OnTransEventListener
{
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  protected DocFileBrowserView a;
  private LocalTbsViewManager.LocalTbsViewManagerCallback jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager$LocalTbsViewManagerCallback = new DocExportFilePresenter.3(this);
  protected boolean a;
  private boolean d = false;
  
  public DocExportFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView = new DocFileBrowserView(this.jdField_a_of_type_AndroidAppActivity);
    a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView);
  }
  
  private void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("docs_export_file_is_first_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.apply();
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("docs_export_file_is_first_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), true);
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = simple");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.e(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a());
    if (FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b())) {
      g();
    } else {
      h();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(this);
    View localView1 = this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.b();
    if (localView1 != null)
    {
      View localView2 = localView1.findViewById(2131379078);
      if (localView2 != null) {
        localView2.setVisibility(8);
      }
      localView2 = localView1.findViewById(2131366798);
      if (localView2 != null) {
        localView2.setVisibility(8);
      }
      localView1 = localView1.findViewById(2131366789);
      if (localView1 != null) {
        localView1.setVisibility(8);
      }
    }
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.b(false);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.c(true);
    b(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a());
  }
  
  protected void b(float paramFloat)
  {
    DocFileBrowserView localDocFileBrowserView = this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getString(2131692281));
    int i = (int)paramFloat;
    localStringBuilder.append(i);
    localStringBuilder.append("%");
    localDocFileBrowserView.b(localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.c(i);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.b(true);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.c(false);
    f();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.b(true);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.c(false);
    f();
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserListener.a();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.c(false);
    f();
  }
  
  protected void g()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SimpleFilePresenter handleLocalFile: fileName[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a());
      ((StringBuilder)localObject).append("] filePath[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b());
      ((StringBuilder)localObject).append("]");
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.b();
    if ((localObject != null) && (((View)localObject).getParent() != null) && (((View)localObject).getParent().getParent() != null) && (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a() != null) && (a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a())) && (((View)localObject).getParent() != null) && (((View)localObject).getParent().getParent() != null))
    {
      localObject = ((ViewGroup)((View)localObject).getParent().getParent()).findViewById(2131377162);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(), false);
        new MqqHandler().postDelayed(new DocExportFilePresenter.1(this, (View)localObject), 5000L);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c() == 2) {
      LocalTbsViewManager.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager$LocalTbsViewManagerCallback, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.d(QQFileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()));
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.h(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.b());
    this.jdField_a_of_type_AndroidContentContext.getString(2131692353);
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.d() == 16)
    {
      localObject = BaseApplication.getContext().getString(2131692353);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.d((String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.e(true);
      return;
    }
    if (QbSdk.isSuportOpenFile(QQFileManagerUtil.h(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()), 2))
    {
      this.jdField_a_of_type_AndroidTextSpannableString = QQFileManagerUtil.a(BaseApplication.getContext().getString(2131692716), BaseApplication.getContext().getString(2131694650), new DocExportFilePresenter.2(this));
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.a(this.jdField_a_of_type_AndroidTextSpannableString);
    }
    else
    {
      localObject = BaseApplication.getContext().getString(2131692715);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.d((String)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.e(true);
  }
  
  protected void h()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SimpleFilePresenter handleCloudFile: fileName[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a());
      localStringBuilder.append("]");
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, localStringBuilder.toString());
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a();
    if (i == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.e(2130844325);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.f(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.e());
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.d(QQFileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()));
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c())) && (16 != this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.d())) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.h(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c());
    } else {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.g(false);
    }
    if (i == 1) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.d(BaseApplication.getContext().getString(2131692696));
    } else {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.d(BaseApplication.getContext().getString(2131692697));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.d() == 16)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.d(BaseApplication.getContext().getString(2131692353));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.d())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.d(BaseApplication.getContext().getString(2131692559));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.d(BaseApplication.getContext().getString(2131692353));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.f();
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.c(true);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.b(false);
      b(0.0F);
    }
  }
  
  public void i()
  {
    DocFileBrowserView localDocFileBrowserView = this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView;
    if (localDocFileBrowserView != null) {
      localDocFileBrowserView.d();
    }
    super.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.DocExportFilePresenter
 * JD-Core Version:    0.7.0.1
 */