package com.tencent.mobileqq.shortvideo;

import bcwj;
import beum;
import beuo;
import bevn;
import bhnv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PtvTemplateManager$15
  implements Runnable
{
  PtvTemplateManager$15(PtvTemplateManager paramPtvTemplateManager, PtvTemplateManager.DoodleInfo paramDoodleInfo) {}
  
  public void run()
  {
    if (this.this$0.a(this.a, true)) {
      this.a.doodleUsable = true;
    }
    do
    {
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        localQQAppInterface = this.this$0.a();
        if (localQQAppInterface != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "reqApp:" + localQQAppInterface);
      return;
      beum localbeum = new beum();
      localbeum.jdField_a_of_type_Beuq = new bcwj(this);
      localbeum.jdField_a_of_type_JavaLangString = this.a.doodleUrl;
      localbeum.jdField_a_of_type_Int = 0;
      localbeum.c = new File(PtvTemplateManager.b, this.a.doodleName).getPath();
      localbeum.b = bhnv.a(bevn.a().a());
      localQQAppInterface.getNetEngine(0).a(localbeum);
    } while (!QLog.isColorLevel());
    QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "startDownloadTemplate, url: " + this.a.doodleUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.15
 * JD-Core Version:    0.7.0.1
 */