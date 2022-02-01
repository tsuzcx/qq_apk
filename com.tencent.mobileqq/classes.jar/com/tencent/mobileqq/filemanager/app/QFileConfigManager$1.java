package com.tencent.mobileqq.filemanager.app;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QFileConfigManager$1
  implements Runnable
{
  QFileConfigManager$1(QFileConfigManager paramQFileConfigManager, HashMap paramHashMap) {}
  
  public void run()
  {
    if (this.a != null)
    {
      QFileConfigManager.a(this.this$0);
      QFileConfigManager.a(this.this$0).clear();
      QFileConfigManager.a(this.this$0).putAll(this.a);
      QLog.i("QFileConfigManager", 1, "setFileDownloadConfig: set download config. ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager.1
 * JD-Core Version:    0.7.0.1
 */