package com.tencent.mobileqq.richmedia.capture.data;

import avrt;
import bbdj;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class CapturePtvTemplateManager$2
  implements Runnable
{
  public CapturePtvTemplateManager$2(String paramString1, String paramString2) {}
  
  public void run()
  {
    bbdj.a(avrt.a.getPath() + File.separator, this.a, this.b);
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "save Config to file finish.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.2
 * JD-Core Version:    0.7.0.1
 */