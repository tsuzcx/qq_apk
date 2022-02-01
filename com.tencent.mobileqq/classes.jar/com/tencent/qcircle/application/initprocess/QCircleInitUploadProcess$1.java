package com.tencent.qcircle.application.initprocess;

import com.tencent.biz.qqcircle.publish.uploader.QcircleUploadConfig;
import com.tencent.biz.qqcircle.publish.uploader.QcircleUploadEnv;
import com.tencent.biz.qqcircle.publish.uploader.QcircleUploadLog;
import com.tencent.biz.qqcircle.publish.uploader.QcircleUploadReport;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.upload.uinterface.UploadServiceBuilder;

class QCircleInitUploadProcess$1
  implements Runnable
{
  public void run()
  {
    QcircleUploadEnv localQcircleUploadEnv = new QcircleUploadEnv();
    UploadServiceBuilder.init(QCircleApplication.APP, new QcircleUploadConfig(), new QcircleUploadLog(), new QcircleUploadReport(), localQcircleUploadEnv, localQcircleUploadEnv, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.application.initprocess.QCircleInitUploadProcess.1
 * JD-Core Version:    0.7.0.1
 */