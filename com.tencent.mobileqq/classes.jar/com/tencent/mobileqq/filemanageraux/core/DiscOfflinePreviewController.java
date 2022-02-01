package com.tencent.mobileqq.filemanageraux.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class DiscOfflinePreviewController
  extends FilePreViewControllerBase
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  String jdField_a_of_type_JavaLangString = "DiscOfflinePreviewController<FileAssistant>";
  String b;
  String c;
  
  public DiscOfflinePreviewController(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = paramString1;
    this.c = paramString2;
    b();
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.b))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" init OfflinePreviewController error,uuid is null,stack:");
      localStringBuilder.append(FileManagerUtil.a());
      QLog.e(str, 1, localStringBuilder.toString());
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreControlerCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreControlerCallback.a(false, "", "", -100005L, "", "", null, this.b, null);
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().b(this.c, this.b);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new DiscOfflinePreviewController.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.DiscOfflinePreviewController
 * JD-Core Version:    0.7.0.1
 */