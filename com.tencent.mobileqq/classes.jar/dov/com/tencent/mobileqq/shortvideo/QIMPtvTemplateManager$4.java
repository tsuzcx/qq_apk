package dov.com.tencent.mobileqq.shortvideo;

import axro;
import axrr;
import axsr;
import bace;
import badq;
import bhfc;
import bjin;
import bjio;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QIMPtvTemplateManager$4
  implements Runnable
{
  public QIMPtvTemplateManager$4(bjin parambjin, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void run()
  {
    if (this.this$0.a(this.a)) {
      this.a.usable = true;
    }
    for (;;)
    {
      return;
      this.a.usable = false;
      int i = (int)(bace.a() / 1024.0F / 1024.0F);
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
        axro localaxro = new axro();
        localaxro.jdField_a_of_type_Axrt = new bjio(this);
        localaxro.jdField_a_of_type_JavaLangString = this.a.resurl;
        localaxro.jdField_a_of_type_Int = 0;
        localaxro.jdField_c_of_type_JavaLangString = new File(bjin.a(), this.a.name).getPath();
        localaxro.jdField_c_of_type_Int = badq.a(axsr.a().a());
        try
        {
          AppInterface localAppInterface = bhfc.a();
          if (localAppInterface != null)
          {
            ((PeakAppInterface)localAppInterface).getNetEngine(0).a(localaxro);
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