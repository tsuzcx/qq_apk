package dov.com.tencent.mobileqq.shortvideo;

import bbdx;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class PtvTemplateManager$2
  implements Runnable
{
  public void run()
  {
    bbdx.a(PtvTemplateManager.a.getPath() + File.separator, this.a, this.b);
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "save Config to file finish.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.2
 * JD-Core Version:    0.7.0.1
 */