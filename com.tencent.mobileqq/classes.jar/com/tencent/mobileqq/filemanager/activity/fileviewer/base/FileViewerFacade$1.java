package com.tencent.mobileqq.filemanager.activity.fileviewer.base;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

final class FileViewerFacade$1
  implements FMDialogUtil.FMDialogInterface
{
  FileViewerFacade$1(String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, Activity paramActivity, IFileBrowser paramIFileBrowser) {}
  
  public void a()
  {
    Object localObject1 = FileManagerUtil.b(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("file maybe resoved ,recreateFilePath[");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("]");
      QLog.i("<FileAssistant>FileViewerFacade", 2, ((StringBuilder)localObject2).toString());
    }
    FileUtils.rename(this.b, (String)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a((String)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath((String)localObject1);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    ((FileManagerEntity)localObject2).nFileType = FileManagerUtil.a(((FileManagerEntity)localObject2).getFilePath());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.b);
    if (localObject2 != null)
    {
      ((FileManagerEntity)localObject2).setFilePath((String)localObject1);
      ((FileManagerEntity)localObject2).fileName = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c((FileManagerEntity)localObject2);
      localObject1 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject2).TroopUin);
      if (localObject1 != null) {
        ((TroopFileTransferManager)localObject1).a(((FileManagerEntity)localObject2).strTroopFileID, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      }
    }
    FileManagerUtil.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser;
    if (localObject1 != null) {
      ((IFileBrowser)localObject1).a();
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.base.FileViewerFacade.1
 * JD-Core Version:    0.7.0.1
 */