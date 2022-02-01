package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.forward.QFileAssistantForwardManager;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel.DeviceChooseInterface;
import com.tencent.mobileqq.filemanager.util.QFileUtils;

class TroopFileModel$12
  implements DatalineDeviceChooseModel.DeviceChooseInterface
{
  TroopFileModel$12(TroopFileModel paramTroopFileModel, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    QFileAssistantForwardManager localQFileAssistantForwardManager = new QFileAssistantForwardManager(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localQFileAssistantForwardManager.a(true);
    localQFileAssistantForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public void b()
  {
    QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFileID, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.busId);
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.12
 * JD-Core Version:    0.7.0.1
 */