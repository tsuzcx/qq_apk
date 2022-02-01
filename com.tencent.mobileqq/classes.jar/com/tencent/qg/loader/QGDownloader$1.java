package com.tencent.qg.loader;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

class QGDownloader$1
  implements Runnable
{
  QGDownloader$1(QGDownloader paramQGDownloader, String paramString) {}
  
  public void run()
  {
    boolean bool = QGLoader.a("QGDownloader.onSuccess");
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QGDownloader", 2, "onSoDownload. loadSo fail. set status to fail.");
      }
      this.this$0.a = 2;
    }
    ThreadManagerV2.getUIHandlerV2().post(new QGDownloader.1.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.loader.QGDownloader.1
 * JD-Core Version:    0.7.0.1
 */