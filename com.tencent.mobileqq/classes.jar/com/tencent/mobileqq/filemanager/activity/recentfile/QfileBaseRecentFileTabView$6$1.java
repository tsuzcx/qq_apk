package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.qroute.QRoute;

class QfileBaseRecentFileTabView$6$1
  implements FMDialogUtil.FMDialogInterface
{
  QfileBaseRecentFileTabView$6$1(QfileBaseRecentFileTabView.6 param6, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView$6.a.a.a().aa();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 0)
    {
      ((IQQFileEngine)QfileBaseRecentFileTabView.j(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView$6.a).getRuntimeService(IQQFileEngine.class)).recvOnLineFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 6)
    {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).downloadDatalineFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
    }
    ((IQQFileEngine)QfileBaseRecentFileTabView.k(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView$6.a).getRuntimeService(IQQFileEngine.class)).reviceFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.6.1
 * JD-Core Version:    0.7.0.1
 */