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
    QFileAssistantForwardManager localQFileAssistantForwardManager = new QFileAssistantForwardManager(this.c.a);
    localQFileAssistantForwardManager.a(true);
    localQFileAssistantForwardManager.a(this.a);
  }
  
  public void b()
  {
    QFileUtils.a(this.c.a, this.b, this.a);
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.MediaFileBrowseProcessorBase.3
 * JD-Core Version:    0.7.0.1
 */