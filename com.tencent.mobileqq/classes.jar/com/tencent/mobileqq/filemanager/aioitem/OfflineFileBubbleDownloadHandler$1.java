package com.tencent.mobileqq.filemanager.aioitem;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

class OfflineFileBubbleDownloadHandler$1
  implements FMDialogUtil.FMDialogInterface
{
  OfflineFileBubbleDownloadHandler$1(OfflineFileBubbleDownloadHandler paramOfflineFileBubbleDownloadHandler, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 3) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemOfflineFileBubbleDownloadHandler.a.getOnlineFileSessionCenter().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemOfflineFileBubbleDownloadHandler.a.getFileManagerEngine().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemOfflineFileBubbleDownloadHandler.a.getOnlineFileSessionCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemOfflineFileBubbleDownloadHandler.a.getFileManagerEngine().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.OfflineFileBubbleDownloadHandler.1
 * JD-Core Version:    0.7.0.1
 */