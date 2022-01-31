package dov.com.tencent.mobileqq.shortvideo;

import bdhb;
import bnpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class QIMPtvTemplateManager$2
  implements Runnable
{
  public QIMPtvTemplateManager$2(String paramString1, String paramString2) {}
  
  public void run()
  {
    bdhb.a(bnpl.a().getPath() + File.separator, this.a, this.b);
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "save Config to file finish.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.2
 * JD-Core Version:    0.7.0.1
 */