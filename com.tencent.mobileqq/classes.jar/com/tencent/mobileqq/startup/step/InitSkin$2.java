package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class InitSkin$2
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("InitSkin", 2, "start asynInitSkin");
    }
    InitSkin.initSkin(BaseApplicationImpl.sApplication);
    InitSkin.sToolProcessInitComplete = true;
    synchronized (InitSkin.sToolInitLock)
    {
      InitSkin.sToolInitLock.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.i("InitSkin", 2, "end asynInitSkin");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin.2
 * JD-Core Version:    0.7.0.1
 */