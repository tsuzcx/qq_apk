package com.tencent.mobileqq.filemanager.multioperate;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class OfflineFileMultiOperate$1
  implements Runnable
{
  OfflineFileMultiOperate$1(OfflineFileMultiOperate paramOfflineFileMultiOperate, List paramList1, List paramList2, QFileMultiOperateCallback paramQFileMultiOperateCallback) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      OfflineFileMultiOperate.a(this.this$0).getMessageFacade().a((MessageRecord)this.jdField_a_of_type_JavaUtilList.get(0), false);
    }
    while ((this.b != null) && (this.b.size() > 0))
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
        localFileManagerEntity.bDelInAio = true;
        if (QLog.isDevelopLevel()) {
          QLog.d("OfflineFileMultiOperate", 1, "ChatHistory entity[" + localFileManagerEntity.getId() + "] del File:" + localFileManagerEntity.nSessionId);
        }
        OfflineFileMultiOperate.a(this.this$0).getFileManagerEngine().b(localFileManagerEntity.nSessionId);
      }
      if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
        OfflineFileMultiOperate.a(this.this$0).getMessageFacade().a(this.jdField_a_of_type_JavaUtilList, false);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateQFileMultiOperateCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateQFileMultiOperateCallback.a(3, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate.1
 * JD-Core Version:    0.7.0.1
 */