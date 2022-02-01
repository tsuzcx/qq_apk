package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;

public class OnlineSimpleFilePresenter
  extends SimpleFilePresenter
{
  public OnlineSimpleFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
    a(new SimpleFileBrowserView(paramActivity));
  }
  
  private void a(int paramInt)
  {
    if (paramInt != 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131692474));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131692473));
  }
  
  private void b(int paramInt)
  {
    if ((paramInt != -1) && (paramInt != 1)) {
      switch (paramInt)
      {
      default: 
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFileTips: opType[");
          localStringBuilder.append(paramInt);
          localStringBuilder.append("not implemented");
          QLog.e("SimpleFilePresenter<FileAssistant>", 2, localStringBuilder.toString());
          return;
        }
        break;
      case 11: 
        c(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.d());
        return;
      case 10: 
        this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.c(false);
        this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.b(false);
        this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131694603));
        return;
      case 9: 
        d(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.d());
      }
    }
  }
  
  private void c(int paramInt)
  {
    switch (paramInt)
    {
    case 10: 
    default: 
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFileTips: opType[OPERATION_TYPE_OLFILE_BE_PC_HANDLED] status[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("not implemented");
        QLog.e("SimpleFilePresenter<FileAssistant>", 2, localStringBuilder.toString());
      }
      break;
    case 8: 
    case 9: 
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131694603));
      break;
    case 6: 
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131694602));
      break;
    case 5: 
    case 7: 
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131694599));
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.e(true);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.b(false);
  }
  
  private void d(int paramInt)
  {
    switch (paramInt)
    {
    case 13: 
    default: 
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFileTips: opType[OPERATION_TYPE_OLFILE_GOTO_UPLOAD] status[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("not implemented");
        QLog.e("SimpleFilePresenter<FileAssistant>", 2, localStringBuilder.toString());
        return;
      }
      break;
    case 10: 
    case 11: 
    case 12: 
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131694598));
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.b(false);
    }
  }
  
  private void j()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b();
    a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a());
    b(i);
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = online simple");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.h(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()));
    j();
  }
  
  public void e()
  {
    p();
    j();
  }
  
  protected void f()
  {
    super.f();
    int i = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.d();
    if ((i == 8) || (i == 9) || (i == 5) || (i == 7) || (i == 12) || (i == 6) || (i == 16)) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.OnlineSimpleFilePresenter
 * JD-Core Version:    0.7.0.1
 */