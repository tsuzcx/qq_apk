package com.tencent.qqprotect.singleupdate;

import bfka;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class QPSingleUpdTimerTask$1
  implements Runnable
{
  QPSingleUpdTimerTask$1(QPSingleUpdTimerTask paramQPSingleUpdTimerTask) {}
  
  public void run()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sMobileQQ.waitAppRuntime(null);
      if (localQQAppInterface != null)
      {
        ((bfka)localQQAppInterface.getManager(194)).a();
        return;
      }
      QLog.w("QPUpdate", 1, "qqprotect failed to start update because QQAppInterface is null");
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSingleUpdTimerTask.1
 * JD-Core Version:    0.7.0.1
 */