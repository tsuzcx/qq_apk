package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

class TroopFileModel$6
  implements IDownloadController
{
  TroopFileModel$6(TroopFileModel paramTroopFileModel) {}
  
  public void a()
  {
    this.a.h();
  }
  
  public void b()
  {
    Object localObject = this.a.c.r();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.a, ((FileManagerEntity)localObject).TroopUin);
    localObject = this.a.e((FileManagerEntity)localObject);
    if ((TextUtils.isEmpty(TroopFileModel.a(this.a))) && (((TroopFileStatusInfo)localObject).a != null)) {
      TroopFileModel.a(this.a, ((TroopFileStatusInfo)localObject).a.toString());
    }
    if (!TextUtils.isEmpty(TroopFileModel.a(this.a)))
    {
      localTroopFileTransferManager.e(UUID.fromString(TroopFileModel.a(this.a)));
      if (QFileUtils.a(this.a.a)) {
        this.a.a("0x8009D61", null);
      }
    }
    TroopFileModel.a(this.a, (TroopFileStatusInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.6
 * JD-Core Version:    0.7.0.1
 */