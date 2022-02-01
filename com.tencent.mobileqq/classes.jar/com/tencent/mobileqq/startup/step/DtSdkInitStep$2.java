package com.tencent.mobileqq.startup.step;

import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class DtSdkInitStep$2
  implements Runnable
{
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null)
    {
      long l = System.currentTimeMillis();
      UserAction.initUserAction(localBaseApplicationImpl, false);
      DtSdkInitStep.d();
      UserAction.setLogAble(false, false);
      com.tencent.beacon.upload.UploadStrategy.DEFAULT_SENSOR_ENABLE = false;
      QLog.d("DtSdkInitStep", 1, "init beacon-dt success ! cost : " + (System.currentTimeMillis() - l) + " ms");
      return;
    }
    QLog.d("DtSdkInitStep", 1, "init beacon-dt error ! app is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.DtSdkInitStep.2
 * JD-Core Version:    0.7.0.1
 */