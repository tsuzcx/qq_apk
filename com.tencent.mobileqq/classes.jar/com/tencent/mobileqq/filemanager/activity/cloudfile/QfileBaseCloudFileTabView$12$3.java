package com.tencent.mobileqq.filemanager.activity.cloudfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;

class QfileBaseCloudFileTabView$12$3
  implements FMDialogUtil.FMDialogInterface
{
  QfileBaseCloudFileTabView$12$3(QfileBaseCloudFileTabView.12 param12, WeiYunFileInfo paramWeiYunFileInfo) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo);
    QfileBaseCloudFileTabView.j(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileBaseCloudFileTabView$12.a).getFileManagerEngine().c(localFileManagerEntity);
    QfileBaseCloudFileTabView.k(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileBaseCloudFileTabView$12.a).getFileManagerDataCenter().a(localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileBaseCloudFileTabView$12.a.a(localFileManagerEntity);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.12.3
 * JD-Core Version:    0.7.0.1
 */