package com.tencent.mobileqq.filemanager.multioperate;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.Iterator;
import java.util.List;

class OfflineFileMultiOperate$6
  implements FMDialogUtil.FMDialogInterface
{
  OfflineFileMultiOperate$6(OfflineFileMultiOperate paramOfflineFileMultiOperate, List paramList, FileManagerEngine paramFileManagerEngine, QFileMultiOperateCallback paramQFileMultiOperateCallback) {}
  
  public void a()
  {
    FMToastUtil.d(OfflineFileMultiOperate.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateOfflineFileMultiOperate).getString(2131692733));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        if (FileUtils.b(localFileManagerEntity.getFilePath())) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine.a(localFileManagerEntity.getFilePath(), "", OfflineFileMultiOperate.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateOfflineFileMultiOperate).getCurrentAccountUin(), 0, false);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateQFileMultiOperateCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateQFileMultiOperateCallback.a(4, 0);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateQFileMultiOperateCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateQFileMultiOperateCallback.a(4, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate.6
 * JD-Core Version:    0.7.0.1
 */