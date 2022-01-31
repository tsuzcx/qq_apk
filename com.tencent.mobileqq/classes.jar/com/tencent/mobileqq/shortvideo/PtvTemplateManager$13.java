package com.tencent.mobileqq.shortvideo;

import bace;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class PtvTemplateManager$13
  implements Runnable
{
  PtvTemplateManager$13(PtvTemplateManager paramPtvTemplateManager, String paramString) {}
  
  public void run()
  {
    bace.a(PtvTemplateManager.b.getPath() + File.separator, "doodle_template_new.cfg", this.a);
    if (QLog.isColorLevel()) {
      QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "save Config to file finish.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.13
 * JD-Core Version:    0.7.0.1
 */