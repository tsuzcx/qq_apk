package com.tencent.mobileqq.winkpublish.api.impl;

import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.winkpublish.uploader.AUploadConfig;
import com.tencent.mobileqq.winkpublish.uploader.AUploadEnv;
import com.tencent.mobileqq.winkpublish.uploader.AUploadLog;
import com.tencent.mobileqq.winkpublish.uploader.AUploadReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.UploadServiceBuilder;

class UploadTaskManagerImpl$1
  implements Runnable
{
  UploadTaskManagerImpl$1(UploadTaskManagerImpl paramUploadTaskManagerImpl) {}
  
  public void run()
  {
    QLog.d("[upload2][PublishUpload]UploadTaskManagerImpl", 1, "initUploadJar...");
    AUploadEnv localAUploadEnv = new AUploadEnv();
    UploadServiceBuilder.init(RFApplication.getApplication(), new AUploadConfig(), new AUploadLog(), new AUploadReport(), localAUploadEnv, localAUploadEnv, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.api.impl.UploadTaskManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */