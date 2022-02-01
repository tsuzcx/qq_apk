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
    if (this.a.size() == 1) {
      OfflineFileMultiOperate.a(this.this$0).getMessageFacade().a((MessageRecord)this.a.get(0), false);
    } else if (this.a.size() > 1) {
      OfflineFileMultiOperate.a(this.this$0).getMessageFacade().a(this.a, false);
    }
    Object localObject = this.b;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        localFileManagerEntity.bDelInAio = true;
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("ChatHistory entity[");
          localStringBuilder.append(localFileManagerEntity.getId());
          localStringBuilder.append("] del File:");
          localStringBuilder.append(localFileManagerEntity.nSessionId);
          QLog.d("OfflineFileMultiOperate", 1, localStringBuilder.toString());
        }
        OfflineFileMultiOperate.a(this.this$0).getFileManagerEngine().c(localFileManagerEntity.nSessionId);
      }
    }
    localObject = this.c;
    if (localObject != null) {
      ((QFileMultiOperateCallback)localObject).a(3, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate.1
 * JD-Core Version:    0.7.0.1
 */