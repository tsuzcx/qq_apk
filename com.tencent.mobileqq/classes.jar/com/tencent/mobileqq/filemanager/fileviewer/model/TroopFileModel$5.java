package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

class TroopFileModel$5
  implements IUploadController
{
  TroopFileModel$5(TroopFileModel paramTroopFileModel) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.c.r();
    TroopFileStatusInfo localTroopFileStatusInfo = this.a.e(localFileManagerEntity);
    if ((TextUtils.isEmpty(TroopFileModel.a(this.a))) && (localTroopFileStatusInfo.a != null)) {
      TroopFileModel.a(this.a, localTroopFileStatusInfo.a.toString());
    }
    TroopFileItemOperation localTroopFileItemOperation = new TroopFileItemOperation(localFileManagerEntity.TroopUin, this.a.a, this.a.i);
    if (((localTroopFileStatusInfo.e == 3) || (localTroopFileStatusInfo.e == 2)) && (localTroopFileStatusInfo.a != null)) {
      localTroopFileItemOperation.a(localTroopFileStatusInfo.a);
    }
    localFileManagerEntity.status = 2;
  }
  
  public void b()
  {
    Object localObject = this.a.c.r();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.a, ((FileManagerEntity)localObject).TroopUin);
    localObject = this.a.e((FileManagerEntity)localObject);
    if (!TextUtils.isEmpty(TroopFileModel.a(this.a)))
    {
      localTroopFileTransferManager.b(UUID.fromString(TroopFileModel.a(this.a)));
      TroopFileModel.a(this.a, (TroopFileStatusInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.5
 * JD-Core Version:    0.7.0.1
 */