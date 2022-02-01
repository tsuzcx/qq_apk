package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class ImportantMsgManager$7
  implements ImportantMsgManager.callbackInMainThread
{
  ImportantMsgManager$7(ImportantMsgManager paramImportantMsgManager, ArrayList paramArrayList) {}
  
  public void a(long paramLong, ImportantMsgItem paramImportantMsgItem)
  {
    if (paramImportantMsgItem == null) {
      return;
    }
    paramImportantMsgItem.addMsgInfos(this.a);
    if ((ImportantMsgManager.b(this.b).containsKey(Long.valueOf(paramLong))) && (paramImportantMsgItem.maxImportantMsgSeq >= ((Integer)ImportantMsgManager.b(this.b).get(Long.valueOf(paramLong))).intValue()))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handlerPushImportantMsg updateMaxMsgSeq: maxImportantMsgSeq:");
        localStringBuilder.append(paramImportantMsgItem.maxImportantMsgSeq);
        localStringBuilder.append(" registerProxy lastSeq:");
        localStringBuilder.append(ImportantMsgManager.b(this.b).get(Long.valueOf(paramLong)));
        QLog.i("ImportantMsgManager", 2, localStringBuilder.toString());
      }
      paramImportantMsgItem.updateMaxMsgSeq();
    }
    this.b.a(paramImportantMsgItem.clone());
    ImportantMsgManager.a(this.b, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager.7
 * JD-Core Version:    0.7.0.1
 */