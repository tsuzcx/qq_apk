package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class InitSkin$1
  implements Runnable
{
  InitSkin$1(InitSkin paramInitSkin) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("InitSkin", 2, "start asynInitSkin");
    }
    InitSkin.initSkin(BaseApplicationImpl.sApplication);
    InitSkin.c = true;
    synchronized (InitSkin.a)
    {
      InitSkin.a.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.i("InitSkin", 2, "end asynInitSkin");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin.1
 * JD-Core Version:    0.7.0.1
 */