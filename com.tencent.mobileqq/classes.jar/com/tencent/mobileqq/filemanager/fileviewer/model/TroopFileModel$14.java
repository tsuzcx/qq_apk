package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;

class TroopFileModel$14
  implements Runnable
{
  TroopFileModel$14(TroopFileModel paramTroopFileModel, FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener) {}
  
  public void run()
  {
    FileManagerEntity localFileManagerEntity = this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity.isZipInnerFile)
    {
      TroopFileProtocol.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localFileManagerEntity.zipFilePath, localFileManagerEntity.busId, TroopFileModel.a(this.this$0));
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(localFileManagerEntity.TroopUin);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl error: " + localFileManagerEntity.TroopUin);
      this.a.c();
      return;
    }
    localTroopFileTransferManager.a(localFileManagerEntity.strTroopFilePath, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.busId, TroopFileModel.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.14
 * JD-Core Version:    0.7.0.1
 */