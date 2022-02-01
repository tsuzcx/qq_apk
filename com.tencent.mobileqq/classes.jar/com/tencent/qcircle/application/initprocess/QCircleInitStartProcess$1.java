package com.tencent.qcircle.application.initprocess;

import com.tencent.mobileqq.qcircle.api.IQQFrontBackListener;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;

class QCircleInitStartProcess$1
  implements IQQFrontBackListener
{
  QCircleInitStartProcess$1(QCircleInitStartProcess paramQCircleInitStartProcess) {}
  
  public void onQQEnterBackground()
  {
    UploadServiceBuilder.getInstance().setBackgroundMode(true);
  }
  
  public void onQQEnterForeground() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.application.initprocess.QCircleInitStartProcess.1
 * JD-Core Version:    0.7.0.1
 */