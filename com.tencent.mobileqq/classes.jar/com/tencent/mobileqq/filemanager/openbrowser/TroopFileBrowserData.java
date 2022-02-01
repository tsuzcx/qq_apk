package com.tencent.mobileqq.filemanager.openbrowser;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import mqq.app.MobileQQ;

public class TroopFileBrowserData
  extends EntityFileBrowserData
{
  private TroopFileStatusInfo a;
  
  public TroopFileBrowserData(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
    boolean bool1 = paramFileManagerEntity.isZipInnerFile;
    boolean bool2 = true;
    if ((bool1) && (FileUtil.a(paramFileManagerEntity.getFilePath()))) {
      paramFileManagerEntity.status = 1;
    }
    if ((paramFileManagerEntity.isZipInnerFile) && (FileManagerUtil.a(paramQQAppInterface, paramFileManagerEntity.fileName, paramFileManagerEntity.status, true))) {
      this.jdField_a_of_type_Boolean = false;
    } else {
      this.jdField_a_of_type_Boolean = FileManagerUtil.a(paramQQAppInterface.getApplication().getBaseContext(), paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo = TroopFileUtils.a(paramQQAppInterface, paramFileManagerEntity);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.b == 2) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.b == 3))
    {
      int i;
      if (FileUtil.a(paramFileManagerEntity.getFilePath())) {
        i = 3;
      } else {
        i = paramFileManagerEntity.getCloudType();
      }
      if (i != 3) {
        return;
      }
      if (paramFileManagerEntity.status == 1)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramFileManagerEntity.Uuid)) {
          break label195;
        }
        if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId))
        {
          bool1 = bool2;
          break label195;
        }
      }
      bool1 = false;
      label195:
      this.jdField_a_of_type_Boolean = bool1;
    }
  }
  
  public int d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 6) && (b() == 31)) {
      return super.d();
    }
    TroopFileStatusInfo localTroopFileStatusInfo = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo;
    if (localTroopFileStatusInfo != null) {
      return localTroopFileStatusInfo.b;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.TroopFileBrowserData
 * JD-Core Version:    0.7.0.1
 */