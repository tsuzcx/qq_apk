package com.tencent.mobileqq.richmedia;

import avrk;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;

public class RichmediaService$IncomingHandler$1
  implements Runnable
{
  public RichmediaService$IncomingHandler$1(avrk paramavrk) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RichmediaService", 2, " PTV_LONG_FIRST_START RichMediaServiceCall");
    }
    AIOLongCaptureCtrl.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaService.IncomingHandler.1
 * JD-Core Version:    0.7.0.1
 */