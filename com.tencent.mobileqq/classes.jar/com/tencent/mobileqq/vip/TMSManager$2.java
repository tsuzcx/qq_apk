package com.tencent.mobileqq.vip;

import baud;
import bauf;
import com.tencent.qphone.base.util.QLog;

public class TMSManager$2
  implements Runnable
{
  public TMSManager$2(baud parambaud) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("KC.TMSManager", 2, "no file and requestDownloadDepends");
    }
    baud.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vip.TMSManager.2
 * JD-Core Version:    0.7.0.1
 */