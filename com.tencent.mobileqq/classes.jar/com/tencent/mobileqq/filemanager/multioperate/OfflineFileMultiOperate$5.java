package com.tencent.mobileqq.filemanager.multioperate;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wifi.FreeWifiDialogListener;
import java.util.Iterator;
import java.util.List;

class OfflineFileMultiOperate$5
  implements FreeWifiDialogListener
{
  OfflineFileMultiOperate$5(OfflineFileMultiOperate paramOfflineFileMultiOperate, List paramList, FileManagerEngine paramFileManagerEngine, QFileMultiOperateCallback paramQFileMultiOperateCallback) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      FMToastUtil.d(OfflineFileMultiOperate.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateOfflineFileMultiOperate).getString(2131692733));
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)localIterator.next();
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
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateQFileMultiOperateCallback == null)
    {
      Iterator localIterator;
      FileManagerEntity localFileManagerEntity;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateQFileMultiOperateCallback.a(4, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate.5
 * JD-Core Version:    0.7.0.1
 */