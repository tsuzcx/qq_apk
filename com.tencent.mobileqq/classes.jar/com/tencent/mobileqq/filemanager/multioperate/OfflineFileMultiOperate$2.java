package com.tencent.mobileqq.filemanager.multioperate;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class OfflineFileMultiOperate$2
  implements Runnable
{
  OfflineFileMultiOperate$2(OfflineFileMultiOperate paramOfflineFileMultiOperate, List paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      QLog.d("OfflineFileMultiOperate", 1, "doFileMutiDelete: can not find any msg,but delete.");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
        localFileManagerEntity.bDelInAio = true;
        if (QLog.isDevelopLevel()) {
          QLog.d("OfflineFileMultiOperate", 1, "ChatHistory entity[" + localFileManagerEntity.getId() + "] del File:" + localFileManagerEntity.nSessionId);
        }
        OfflineFileMultiOperate.a(this.this$0).getFileManagerEngine().b(localFileManagerEntity.nSessionId);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateQFileMultiOperateCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateQFileMultiOperateCallback.a(3, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate.2
 * JD-Core Version:    0.7.0.1
 */