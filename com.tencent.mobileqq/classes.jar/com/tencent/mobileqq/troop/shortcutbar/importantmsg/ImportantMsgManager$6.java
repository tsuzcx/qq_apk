package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ImportantMsgManager$6
  implements Runnable
{
  ImportantMsgManager$6(ImportantMsgManager paramImportantMsgManager, long paramLong, ImportantMsgManager.callbackInMainThread paramcallbackInMainThread) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    ImportantMsgItem localImportantMsgItem = this.this$0.b(this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readEntity costTime");
      localStringBuilder.append(System.currentTimeMillis() - l);
      localStringBuilder.append(" msgItem:");
      localStringBuilder.append(localImportantMsgItem.toString());
      QLog.i("ImportantMsgManager", 2, localStringBuilder.toString());
    }
    ThreadManager.getUIHandler().post(new ImportantMsgManager.6.1(this, localImportantMsgItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager.6
 * JD-Core Version:    0.7.0.1
 */