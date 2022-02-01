package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class PtvTemplateManager$12
  implements Runnable
{
  PtvTemplateManager$12(PtvTemplateManager paramPtvTemplateManager, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PtvTemplateManager.f.getPath());
    localStringBuilder.append(File.separator);
    FileUtils.writeFile(localStringBuilder.toString(), "doodle_template_new.cfg", this.a);
    if (QLog.isColorLevel()) {
      QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "save Config to file finish.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.12
 * JD-Core Version:    0.7.0.1
 */