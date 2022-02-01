package com.tencent.qidian;

import com.tencent.common.app.AppInterface;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class QidianManager$7
  implements Runnable
{
  QidianManager$7(QidianManager paramQidianManager, String paramString) {}
  
  public void run()
  {
    QidianManager localQidianManager = this.this$0;
    localQidianManager.b(localQidianManager.i.getApp().getBaseContext(), new BmqqAccountType(this.a, 6));
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "isQidianMaster get user detail in main thread");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianManager.7
 * JD-Core Version:    0.7.0.1
 */