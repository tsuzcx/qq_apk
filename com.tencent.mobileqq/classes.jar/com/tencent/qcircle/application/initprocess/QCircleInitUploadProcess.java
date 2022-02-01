package com.tencent.qcircle.application.initprocess;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IUploadTaskManager;

public class QCircleInitUploadProcess
  extends QCircleBaseInitProcess
{
  private void c()
  {
    RFThreadManager.getSerialThreadHandler().postDelayed(new QCircleInitUploadProcess.2(this), 30000L);
  }
  
  public void b()
  {
    super.b();
    ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).initQFSConfig();
    ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).initUpload();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.application.initprocess.QCircleInitUploadProcess
 * JD-Core Version:    0.7.0.1
 */