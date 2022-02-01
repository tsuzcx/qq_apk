package com.tencent.qidian;

import com.tencent.common.app.AppInterface;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.BaseApplication;

class QidianManager$4
  implements Runnable
{
  QidianManager$4(QidianManager paramQidianManager, String paramString) {}
  
  public void run()
  {
    QidianManager localQidianManager = this.this$0;
    localQidianManager.b(localQidianManager.i.getApp().getBaseContext(), new BmqqAccountType(this.a, 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianManager.4
 * JD-Core Version:    0.7.0.1
 */