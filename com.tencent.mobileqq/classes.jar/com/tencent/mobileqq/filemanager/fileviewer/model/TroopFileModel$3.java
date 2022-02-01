package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IThumbController;
import com.tencent.mobileqq.filemanager.fileviewer.data.DefaultImageInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class TroopFileModel$3
  implements IThumbController
{
  TroopFileModel$3(TroopFileModel paramTroopFileModel) {}
  
  public void a(FileBrowserModelBase.ImageFileInfo paramImageFileInfo)
  {
    paramImageFileInfo = ((DefaultImageInfo)paramImageFileInfo).h();
    if (paramImageFileInfo == null) {
      return;
    }
    if ((FileManagerUtil.c(paramImageFileInfo.b()) == 0) && (!TextUtils.isEmpty(paramImageFileInfo.b())) && (TextUtils.isEmpty(paramImageFileInfo.o())))
    {
      FileManagerEntity localFileManagerEntity = paramImageFileInfo.r();
      if (localFileManagerEntity == null)
      {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb : can not get the troop file entity, return.");
        return;
      }
      Object localObject = TroopFileUtils.a(this.a.a, localFileManagerEntity.TroopUin, localFileManagerEntity.strTroopFileID, localFileManagerEntity.strTroopFilePath, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.busId);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("downloadThumb : troopUin[");
        localStringBuilder.append(localFileManagerEntity.TroopUin);
        localStringBuilder.append("] troopFileId[");
        localStringBuilder.append(localFileManagerEntity.strTroopFileID);
        localStringBuilder.append("] troopFilePath[");
        localStringBuilder.append(localFileManagerEntity.strTroopFilePath);
        localStringBuilder.append("]");
        QLog.i("TroopFileModel<FileAssistant>", 2, localStringBuilder.toString());
      }
      if (TextUtils.isEmpty(((TroopFileStatusInfo)localObject).m))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb :  can not find local thumb file, download.");
        }
        localObject = TroopFileTransferManager.a(this.a.a, localFileManagerEntity.TroopUin);
        if (localFileManagerEntity.strTroopFileID == null)
        {
          ((TroopFileTransferManager)localObject).a(localFileManagerEntity.strTroopFilePath, paramImageFileInfo.b(), localFileManagerEntity.busId, 640);
          return;
        }
        ((TroopFileTransferManager)localObject).a(UUID.fromString(localFileManagerEntity.strTroopFileID), 640);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb :  can find local thumb file, refresh the picture browser.");
      }
      if (this.a.s != null) {
        this.a.s.a(((TroopFileStatusInfo)localObject).r, ((TroopFileStatusInfo)localObject).m);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.3
 * JD-Core Version:    0.7.0.1
 */