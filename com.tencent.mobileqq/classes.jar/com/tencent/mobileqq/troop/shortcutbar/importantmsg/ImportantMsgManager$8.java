package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;

class ImportantMsgManager$8
  implements Runnable
{
  ImportantMsgManager$8(ImportantMsgManager paramImportantMsgManager, Entity paramEntity) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    ImportantMsgManager.a(this.this$0, this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateEntity costTime");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.i("ImportantMsgManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager.8
 * JD-Core Version:    0.7.0.1
 */