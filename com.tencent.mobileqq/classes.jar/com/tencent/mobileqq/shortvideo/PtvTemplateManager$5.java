package com.tencent.mobileqq.shortvideo;

import ayyk;
import baps;
import bapv;
import baqx;
import bdee;
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
      baps localbaps = new baps();
      localbaps.jdField_a_of_type_Bapx = new ayyk(this);
      localbaps.jdField_a_of_type_JavaLangString = this.a.resurl;
      localbaps.jdField_a_of_type_Int = 0;
      localbaps.jdField_c_of_type_JavaLangString = new File(PtvTemplateManager.a, this.a.name).getPath();
      localbaps.jdField_c_of_type_Int = bdee.a(baqx.a().a());
      localQQAppInterface.getNetEngine(0).a(localbaps);
    } while (!QLog.isColorLevel());
    QLog.i("PtvTemplateManager", 2, "startDownloadTemplate, url: " + this.a.resurl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.5
 * JD-Core Version:    0.7.0.1
 */