package com.tencent.mobileqq.richmedia.capture.data;

import axoc;
import bdhb;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class CapturePtvTemplateManager$2
  implements Runnable
{
  public CapturePtvTemplateManager$2(String paramString1, String paramString2) {}
  
  public void run()
  {
    bdhb.a(axoc.a.getPath() + File.separator, this.a, this.b);
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "save Config to file finish.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.2
 * JD-Core Version:    0.7.0.1
 */