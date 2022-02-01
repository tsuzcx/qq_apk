package com.tencent.mobileqq.shortvideo;

import bcwk;
import beum;
import beuo;
import bevn;
import bhnv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PtvTemplateManager$5
  implements Runnable
{
  PtvTemplateManager$5(PtvTemplateManager paramPtvTemplateManager, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void run()
  {
    if (this.this$0.a(this.a)) {
      this.a.usable = true;
    }
    do
    {
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        this.a.usable = false;
        localQQAppInterface = this.this$0.a();
        if (localQQAppInterface != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("PtvTemplateManager", 2, "preDownloadTemplates  null!");
      return;
      beum localbeum = new beum();
      localbeum.jdField_a_of_type_Beuq = new bcwk(this);
      localbeum.jdField_a_of_type_JavaLangString = this.a.resurl;
      localbeum.jdField_a_of_type_Int = 0;
      localbeum.c = new File(PtvTemplateManager.a, this.a.name).getPath();
      localbeum.b = bhnv.a(bevn.a().a());
      localQQAppInterface.getNetEngine(0).a(localbeum);
    } while (!QLog.isColorLevel());
    QLog.i("PtvTemplateManager", 2, "startDownloadTemplate, url: " + this.a.resurl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.5
 * JD-Core Version:    0.7.0.1
 */