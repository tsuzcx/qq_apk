package com.tencent.mobileqq.richmedia.capture.data;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class CapturePtvTemplateManager$2
  implements Runnable
{
  CapturePtvTemplateManager$2(String paramString1, String paramString2) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CapturePtvTemplateManager.d.getPath());
    localStringBuilder.append(File.separator);
    FileUtils.writeFile(localStringBuilder.toString(), this.a, this.b);
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "save Config to file finish.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.2
 * JD-Core Version:    0.7.0.1
 */