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
    paramImageFileInfo = ((DefaultImageInfo)paramImageFileInfo).a();
    if (paramImageFileInfo == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((FileManagerUtil.a(paramImageFileInfo.a()) != 0) || (TextUtils.isEmpty(paramImageFileInfo.a())) || (!TextUtils.isEmpty(paramImageFileInfo.g())));
      FileManagerEntity localFileManagerEntity = paramImageFileInfo.a();
      if (localFileManagerEntity == null)
      {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb : can not get the troop file entity, return.");
        return;
      }
      localObject = TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localFileManagerEntity.strTroopFileID, localFileManagerEntity.strTroopFilePath, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.busId);
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb : troopUin[" + localFileManagerEntity.TroopUin + "] troopFileId[" + localFileManagerEntity.strTroopFileID + "] troopFilePath[" + localFileManagerEntity.strTroopFilePath + "]");
      }
      if (TextUtils.isEmpty(((TroopFileStatusInfo)localObject).c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb :  can not find local thumb file, download.");
        }
        localObject = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin);
        if (localFileManagerEntity.strTroopFileID == null)
        {
          ((TroopFileTransferManager)localObject).a(localFileManagerEntity.strTroopFilePath, paramImageFileInfo.a(), localFileManagerEntity.busId, 640);
          return;
        }
        ((TroopFileTransferManager)localObject).a(UUID.fromString(localFileManagerEntity.strTroopFileID), 640);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb :  can find local thumb file, refresh the picture browser.");
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener == null);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener.a(((TroopFileStatusInfo)localObject).e, ((TroopFileStatusInfo)localObject).c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.3
 * JD-Core Version:    0.7.0.1
 */