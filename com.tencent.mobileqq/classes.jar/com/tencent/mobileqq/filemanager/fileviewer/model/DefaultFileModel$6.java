package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.forward.QFileAssistantForwardManager;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel.DeviceChooseInterface;
import com.tencent.mobileqq.filemanager.util.QFileUtils;

class DefaultFileModel$6
  implements DatalineDeviceChooseModel.DeviceChooseInterface
{
  DefaultFileModel$6(DefaultFileModel paramDefaultFileModel, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    QFileAssistantForwardManager localQFileAssistantForwardManager = new QFileAssistantForwardManager(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localQFileAssistantForwardManager.a(true);
    localQFileAssistantForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public void b()
  {
    QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel.6
 * JD-Core Version:    0.7.0.1
 */