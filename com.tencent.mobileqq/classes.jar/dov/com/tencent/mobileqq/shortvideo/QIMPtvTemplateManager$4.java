package dov.com.tencent.mobileqq.shortvideo;

import ayrx;
import aysa;
import ayta;
import bbdx;
import bbfj;
import bjal;
import bkzp;
import bkzq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QIMPtvTemplateManager$4
  implements Runnable
{
  public QIMPtvTemplateManager$4(bkzp parambkzp, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void run()
  {
    if (this.this$0.a(this.a)) {
      this.a.usable = true;
    }
    for (;;)
    {
      return;
      this.a.usable = false;
      int i = (int)(bbdx.a() / 1024.0F / 1024.0F);
      int j = (int)(this.a.sizeFree * 1024.0D);
      if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "preDownloadTemplates getAvailableInnernalMemorySize: " + i + " mSizeFree: " + j);
      }
      if (i < j)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QIMPtvTemplateManager", 2, "preDownloadTemplates return getAvailableInnernalMemorySize: " + i + " mSizeFree: " + j);
        }
      }
      else
      {
        ayrx localayrx = new ayrx();
        localayrx.jdField_a_of_type_Aysc = new bkzq(this);
        localayrx.jdField_a_of_type_JavaLangString = this.a.resurl;
        localayrx.jdField_a_of_type_Int = 0;
        localayrx.jdField_c_of_type_JavaLangString = new File(bkzp.a(), this.a.name).getPath();
        localayrx.jdField_c_of_type_Int = bbfj.a(ayta.a().a());
        try
        {
          AppInterface localAppInterface = bjal.a();
          if (localAppInterface != null)
          {
            ((PeakAppInterface)localAppInterface).getNetEngine(0).a(localayrx);
            if (QLog.isColorLevel())
            {
              QLog.i("QIMPtvTemplateManager", 2, "startDownloadFilterConfigZip, url: " + this.a.resurl);
              return;
            }
          }
        }
        catch (Exception localException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.4
 * JD-Core Version:    0.7.0.1
 */