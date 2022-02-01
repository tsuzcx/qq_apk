package com.tencent.qcircle.application.initprocess;

import com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskQueue;
import com.tencent.qphone.base.util.QLog;

class QCircleInitUploadProcess$2
  implements Runnable
{
  QCircleInitUploadProcess$2(QCircleInitUploadProcess paramQCircleInitUploadProcess) {}
  
  public void run()
  {
    QLog.d("QCircleOutboxTaskQueue", 1, "initOutbox...");
    QCircleOutboxTaskQueue.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.application.initprocess.QCircleInitUploadProcess.2
 * JD-Core Version:    0.7.0.1
 */