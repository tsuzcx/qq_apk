package dov.com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class QIMPtvTemplateManager$2
  implements Runnable
{
  QIMPtvTemplateManager$2(String paramString1, String paramString2) {}
  
  public void run()
  {
    FileUtils.a(QIMPtvTemplateManager.a().getPath() + File.separator, this.a, this.b);
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "save Config to file finish.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.2
 * JD-Core Version:    0.7.0.1
 */