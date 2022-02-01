package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class PtvTemplateManager$1
  implements Runnable
{
  PtvTemplateManager$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PtvTemplateManager.a.getPath());
    localStringBuilder.append(File.separator);
    FileUtils.writeFile(localStringBuilder.toString(), this.a, this.b);
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "save Config to file finish.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.1
 * JD-Core Version:    0.7.0.1
 */