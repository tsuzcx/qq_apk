package com.tencent.mobileqq.gallery.picocr;

import avas;
import avat;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class PicOcrManager$2$1
  implements Runnable
{
  public PicOcrManager$2$1(avas paramavas) {}
  
  public void run()
  {
    FileUtils.deleteFile(this.a.a.c);
    if (QLog.isColorLevel()) {
      QLog.d("PicOcrManager", 2, "clear path!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrManager.2.1
 * JD-Core Version:    0.7.0.1
 */