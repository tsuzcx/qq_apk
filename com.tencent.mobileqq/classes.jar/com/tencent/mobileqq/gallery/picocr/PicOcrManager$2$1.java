package com.tencent.mobileqq.gallery.picocr;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class PicOcrManager$2$1
  implements Runnable
{
  PicOcrManager$2$1(PicOcrManager.2 param2) {}
  
  public void run()
  {
    FileUtils.e(this.a.a.c);
    if (QLog.isColorLevel()) {
      QLog.d("PicOcrManager", 2, "clear path!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrManager.2.1
 * JD-Core Version:    0.7.0.1
 */