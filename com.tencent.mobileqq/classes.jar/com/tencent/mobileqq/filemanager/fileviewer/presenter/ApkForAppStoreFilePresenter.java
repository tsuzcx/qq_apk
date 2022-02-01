package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.IAppStoreRemindCallback;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileSizeFormat;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class ApkForAppStoreFilePresenter
  extends SimpleFilePresenter
  implements View.OnClickListener
{
  private QFileAppStorePromoteManager.IAppStoreRemindCallback a;
  
  public ApkForAppStoreFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileAppStorePromoteManager$IAppStoreRemindCallback = new ApkForAppStoreFilePresenter.3(this);
  }
  
  private QFileAppStorePromoteManager a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface))) {
      return null;
    }
    return ((QQAppInterface)localAppRuntime).getFileManagerEngine().a();
  }
  
  private void s()
  {
    this.c = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(HardCodeUtil.a(2131704514) + FileSizeFormat.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()) + ")", new ApkForAppStoreFilePresenter.2(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true);
  }
  
  public void a()
  {
    boolean bool = true;
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("ApkForAppStoreFilePresenter", 1, "FileBrowserPresenter init: type = preview simple");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.l();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(2130844419);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f((String)localObject);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h())) && (16 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b())) {
        break label224;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      label85:
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h())) && (16 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b())) {
        break label241;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      label118:
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b() != 16) {
        break label258;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692421));
      label146:
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i()) {
        break label287;
      }
    }
    for (;;)
    {
      ((SimpleFileViewer)localObject).c(bool);
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.k();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d((String)localObject);
      }
      if (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d())) {
        c();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.g());
      break;
      label224:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h());
      break label85;
      label241:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h());
      break label118;
      label258:
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d()) {
        break label146;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692607));
      break label146;
      label287:
      bool = false;
    }
  }
  
  protected void as_()
  {
    Object localObject = a();
    if (localObject == null) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a()) || (!((QFileAppStorePromoteManager)localObject).b()) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.j())));
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i();
    } while ((i == 6) || (i == 2) || (i == 4) || (i == 5));
    localObject = ((QFileAppStorePromoteManager)localObject).a(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b((String)localObject, this);
  }
  
  protected void b() {}
  
  protected void c()
  {
    Object localObject = a();
    if (localObject == null) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a()) || (!((QFileAppStorePromoteManager)localObject).b()) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.j())));
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i();
    } while ((i == 6) || (i == 2) || (i == 4) || (i == 5));
    localObject = ((QFileAppStorePromoteManager)localObject).a(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b((String)localObject, this);
    ReportController.b(null, "dc00898", "", "", "0X800AE3B", "0X800AE3B", 0, 0, "", "", "", "");
  }
  
  protected void h()
  {
    super.h();
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i();
    if ((i != 6) && (i != 2) && (i != 4) && (i != 5))
    {
      if (a() == null) {
        s();
      }
    }
    else {
      return;
    }
    this.c = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(HardCodeUtil.a(2131704514) + FileSizeFormat.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()) + ")", new ApkForAppStoreFilePresenter.1(this));
  }
  
  public void onClick(View paramView)
  {
    QFileAppStorePromoteManager localQFileAppStorePromoteManager = a();
    if (localQFileAppStorePromoteManager == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReportController.b(null, "dc00898", "", "", "0X800AE3C", "0X800AE3C", 0, 0, "", "", "", "");
      String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.j();
      if (localQFileAppStorePromoteManager.a())
      {
        if (!TextUtils.isEmpty(str)) {
          QFileAppStorePromoteManager.a(str, 1);
        } else {
          QLog.i("ApkForAppStoreFilePresenter", 1, "app store has installed, but apk package name is null!");
        }
      }
      else {
        localQFileAppStorePromoteManager.b(this.jdField_a_of_type_AndroidAppActivity, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.ApkForAppStoreFilePresenter
 * JD-Core Version:    0.7.0.1
 */