package com.tencent.mobileqq.filemanager.app;

import aqpu;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QFileConfigManager$1
  implements Runnable
{
  public QFileConfigManager$1(aqpu paramaqpu, HashMap paramHashMap) {}
  
  public void run()
  {
    if (this.a != null)
    {
      aqpu.a(this.this$0).clear();
      aqpu.a(this.this$0).putAll(this.a);
      QLog.i("QFileConfigManager", 1, "setFileDownloadConfig: set download config. ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager.1
 * JD-Core Version:    0.7.0.1
 */