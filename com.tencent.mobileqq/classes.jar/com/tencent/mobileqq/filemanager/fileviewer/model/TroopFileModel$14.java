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
    FileManagerEntity localFileManagerEntity = this.this$0.c.r();
    if (localFileManagerEntity.isZipInnerFile)
    {
      TroopFileProtocol.a(this.this$0.a, localFileManagerEntity.TroopUin, localFileManagerEntity.zipFilePath, localFileManagerEntity.busId, TroopFileModel.c(this.this$0));
      return;
    }
    Object localObject = TroopFileTransferManager.a(localFileManagerEntity.TroopUin);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestOnlinePreviewDownloadUrl error: ");
      ((StringBuilder)localObject).append(localFileManagerEntity.TroopUin);
      QLog.e("TroopFileModel<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      this.a.cq_();
      return;
    }
    ((TroopFileTransferManager)localObject).a(localFileManagerEntity.strTroopFilePath, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.busId, TroopFileModel.d(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.14
 * JD-Core Version:    0.7.0.1
 */