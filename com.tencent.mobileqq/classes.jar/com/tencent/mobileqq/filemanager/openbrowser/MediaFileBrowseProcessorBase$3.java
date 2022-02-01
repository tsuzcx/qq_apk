package com.tencent.mobileqq.filemanager.openbrowser;

import android.content.Context;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.forward.QFileAssistantForwardManager;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel.DeviceChooseInterface;
import com.tencent.mobileqq.filemanager.util.QFileUtils;

class MediaFileBrowseProcessorBase$3
  implements DatalineDeviceChooseModel.DeviceChooseInterface
{
  MediaFileBrowseProcessorBase$3(MediaFileBrowseProcessorBase paramMediaFileBrowseProcessorBase, FileManagerEntity paramFileManagerEntity, Context paramContext) {}
  
  public void a()
  {
    QFileAssistantForwardManager localQFileAssistantForwardManager = new QFileAssistantForwardManager(this.jdField_a_of_type_ComTencentMobileqqFilemanagerOpenbrowserMediaFileBrowseProcessorBase.a);
    localQFileAssistantForwardManager.a(true);
    localQFileAssistantForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public void b()
  {
    QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerOpenbrowserMediaFileBrowseProcessorBase.a, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.MediaFileBrowseProcessorBase.3
 * JD-Core Version:    0.7.0.1
 */