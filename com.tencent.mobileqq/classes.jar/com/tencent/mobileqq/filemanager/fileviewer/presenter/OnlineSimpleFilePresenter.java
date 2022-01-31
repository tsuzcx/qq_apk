package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;

public class OnlineSimpleFilePresenter
  extends SimpleFilePresenter
{
  public OnlineSimpleFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.g();
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b();
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.e())
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131435102));
      switch (i)
      {
      case 0: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.e("SimpleFilePresenter<FileAssistant>", 2, "getFileTips: opType[" + i + "not implemented");
        }
        break;
      }
      break;
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131435103));
      break;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131435104));
      break;
      switch (j)
      {
      case 10: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.e("SimpleFilePresenter<FileAssistant>", 2, "getFileTips: opType[OPERATION_TYPE_OLFILE_BE_PC_HANDLED] status[" + j + "not implemented");
        }
        break;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
        return;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131428262));
        continue;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131428263));
        continue;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131428264));
      }
      switch (j)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.e("SimpleFilePresenter<FileAssistant>", 2, "getFileTips: opType[OPERATION_TYPE_OLFILE_GOTO_UPLOAD] status[" + j + "not implemented");
    return;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131428265));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
    return;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131428264));
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = online simple");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b()));
    c();
  }
  
  protected void b()
  {
    super.b();
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b();
    if ((i == 8) || (i == 9) || (i == 5) || (i == 7) || (i == 12) || (i == 6) || (i == 16)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
    }
  }
  
  public void g()
  {
    k();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.OnlineSimpleFilePresenter
 * JD-Core Version:    0.7.0.1
 */