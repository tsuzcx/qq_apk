package com.tencent.mobileqq.filemanager.app;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QFileAppStorePromoteManager$2$2
  implements Runnable
{
  QFileAppStorePromoteManager$2$2(QFileAppStorePromoteManager.2 param2, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("request appInfo. add reqId[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]");
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, localStringBuilder.toString());
    }
    QFileAppStorePromoteManager.b(this.b.this$0).put(Integer.valueOf(this.a), this.b.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.2.2
 * JD-Core Version:    0.7.0.1
 */