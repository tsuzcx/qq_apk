package com.tencent.mobileqq.filemanager.app;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QFileAppStorePromoteManager$2$3
  implements Runnable
{
  QFileAppStorePromoteManager$2$3(QFileAppStorePromoteManager.2 param2, int paramInt) {}
  
  public void run()
  {
    this.b.b.a();
    QFileAppStorePromoteManager.IGetAppDetailCallback localIGetAppDetailCallback = (QFileAppStorePromoteManager.IGetAppDetailCallback)QFileAppStorePromoteManager.b(this.b.this$0).remove(Integer.valueOf(this.a));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("request appInfo time limit. remove reqId[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("] result[");
      boolean bool;
      if (localIGetAppDetailCallback != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.2.3
 * JD-Core Version:    0.7.0.1
 */