package com.tencent.mobileqq.richmedia.capture.data;

import axom;
import com.tencent.qphone.base.util.QLog;

public class CaptureVideoFilterManager$1
  implements Runnable
{
  public CaptureVideoFilterManager$1(axom paramaxom) {}
  
  public void run()
  {
    this.this$0.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("QIMRedDotConfig", 2, "saved to red dot config file");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.1
 * JD-Core Version:    0.7.0.1
 */