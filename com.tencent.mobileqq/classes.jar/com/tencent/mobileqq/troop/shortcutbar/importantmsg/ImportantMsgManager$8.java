package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import bgbv;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;

public class ImportantMsgManager$8
  implements Runnable
{
  public ImportantMsgManager$8(bgbv parambgbv, Entity paramEntity) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    bgbv.a(this.this$0, this.a);
    if (QLog.isColorLevel()) {
      QLog.i("ImportantMsgManager", 2, "updateEntity costTime" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager.8
 * JD-Core Version:    0.7.0.1
 */