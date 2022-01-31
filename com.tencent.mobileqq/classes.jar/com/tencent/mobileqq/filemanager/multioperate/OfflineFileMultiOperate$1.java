package com.tencent.mobileqq.filemanager.multioperate;

import aqsb;
import arph;
import arpm;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class OfflineFileMultiOperate$1
  implements Runnable
{
  public OfflineFileMultiOperate$1(arph paramarph, List paramList1, List paramList2, arpm paramarpm) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      arph.a(this.this$0).a().a((MessageRecord)this.jdField_a_of_type_JavaUtilList.get(0), false);
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
        arph.a(this.this$0).a().b(localFileManagerEntity.nSessionId);
      }
      if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
        arph.a(this.this$0).a().a(this.jdField_a_of_type_JavaUtilList, false);
      }
    }
    if (this.jdField_a_of_type_Arpm != null) {
      this.jdField_a_of_type_Arpm.a(3, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate.1
 * JD-Core Version:    0.7.0.1
 */