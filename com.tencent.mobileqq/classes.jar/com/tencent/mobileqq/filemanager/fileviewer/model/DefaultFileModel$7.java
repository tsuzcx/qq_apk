package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.forward.QFileAssistantForwardManager;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel.DeviceChooseInterface;
import com.tencent.mobileqq.filemanager.util.QFileUtils;

class DefaultFileModel$7
  implements DatalineDeviceChooseModel.DeviceChooseInterface
{
  DefaultFileModel$7(DefaultFileModel paramDefaultFileModel, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    QFileAssistantForwardManager localQFileAssistantForwardManager = new QFileAssistantForwardManager(this.b.a);
    localQFileAssistantForwardManager.a(true);
    localQFileAssistantForwardManager.a(this.a);
  }
  
  public void b()
  {
    QFileUtils.a(this.b.a, this.b.i, this.a);
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel.7
 * JD-Core Version:    0.7.0.1
 */