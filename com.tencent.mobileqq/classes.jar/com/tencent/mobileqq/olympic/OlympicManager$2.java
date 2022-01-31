package com.tencent.mobileqq.olympic;

import com.tencent.qphone.base.util.QLog;

class OlympicManager$2
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "refreshUI tryDownloadActResource mTorchbearerFlag is 1 ");
    }
    OlympicManager.a(this.this$0, this.this$0.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicManager.2
 * JD-Core Version:    0.7.0.1
 */