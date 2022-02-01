package com.tencent.mobileqq.filemanager.fileviewer.model;

import asqs;
import assx;
import astk;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import zrj;

public class TroopFileModel$16
  implements Runnable
{
  public TroopFileModel$16(astk paramastk, assx paramassx) {}
  
  public void run()
  {
    FileManagerEntity localFileManagerEntity = this.this$0.jdField_a_of_type_Asqs.a();
    if (localFileManagerEntity.isZipInnerFile)
    {
      zrj.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localFileManagerEntity.zipFilePath, localFileManagerEntity.busId, astk.a(this.this$0));
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(localFileManagerEntity.TroopUin);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl error: " + localFileManagerEntity.TroopUin);
      this.a.c();
      return;
    }
    localTroopFileTransferManager.a(localFileManagerEntity.strTroopFilePath, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.busId, astk.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.16
 * JD-Core Version:    0.7.0.1
 */