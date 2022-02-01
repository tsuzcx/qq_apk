package dov.com.tencent.mobileqq.shortvideo;

import beum;
import beuo;
import bevn;
import bhmi;
import bhnv;
import bplg;
import brhn;
import brho;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QIMPtvTemplateManager$4
  implements Runnable
{
  public QIMPtvTemplateManager$4(brhn parambrhn, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void run()
  {
    if (this.this$0.a(this.a)) {
      this.a.usable = true;
    }
    for (;;)
    {
      return;
      this.a.usable = false;
      int i = (int)(bhmi.a() / 1024.0F / 1024.0F);
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
        beum localbeum = new beum();
        localbeum.jdField_a_of_type_Beuq = new brho(this);
        localbeum.jdField_a_of_type_JavaLangString = this.a.resurl;
        localbeum.jdField_a_of_type_Int = 0;
        localbeum.c = new File(brhn.a(), this.a.name).getPath();
        localbeum.b = bhnv.a(bevn.a().a());
        try
        {
          AppInterface localAppInterface = bplg.a();
          if (localAppInterface != null)
          {
            ((PeakAppInterface)localAppInterface).getNetEngine(0).a(localbeum);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.4
 * JD-Core Version:    0.7.0.1
 */