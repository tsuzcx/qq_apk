package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class OfflinePreviewController
  extends FilePreViewControllerBase
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public OfflinePreviewController(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("OfflinePreviewController<FileAssistant>", 1, " init OfflinePreviewController error,uuid is null,stack:" + FileManagerUtil.a());
    }
    b();
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.e("OfflinePreviewController<FileAssistant>", 1, " init OfflinePreviewController error,uuid is null,stack:" + FileManagerUtil.a());
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback.a(false, "", "", -100005L, "", "", null, this.jdField_a_of_type_JavaLangString, null);
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(this.jdField_a_of_type_JavaLangString, this.b);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new OfflinePreviewController.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OfflinePreviewController
 * JD-Core Version:    0.7.0.1
 */