package com.tencent.mobileqq.shortvideo;

import azct;
import baub;
import baue;
import bavg;
import bdin;
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
      baub localbaub = new baub();
      localbaub.jdField_a_of_type_Baug = new azct(this);
      localbaub.jdField_a_of_type_JavaLangString = this.a.resurl;
      localbaub.jdField_a_of_type_Int = 0;
      localbaub.jdField_c_of_type_JavaLangString = new File(PtvTemplateManager.a, this.a.name).getPath();
      localbaub.jdField_c_of_type_Int = bdin.a(bavg.a().a());
      localQQAppInterface.getNetEngine(0).a(localbaub);
    } while (!QLog.isColorLevel());
    QLog.i("PtvTemplateManager", 2, "startDownloadTemplate, url: " + this.a.resurl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.5
 * JD-Core Version:    0.7.0.1
 */