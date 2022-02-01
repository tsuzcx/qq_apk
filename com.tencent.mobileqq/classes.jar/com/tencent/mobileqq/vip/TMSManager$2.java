package com.tencent.mobileqq.vip;

import com.tencent.qphone.base.util.QLog;

class TMSManager$2
  implements Runnable
{
  TMSManager$2(TMSManager paramTMSManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("KC.TMSManager", 2, "no file and requestDownloadDepends");
    }
    TMSManager.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.TMSManager.2
 * JD-Core Version:    0.7.0.1
 */