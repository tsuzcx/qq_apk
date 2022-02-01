package dov.com.qq.im.capture.music;

import android.os.SystemClock;
import bftf;
import bgoe;
import bgog;
import bmte;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.sveffects.SvEffectSdkInitor.QQSpecialAVFilterResource;
import java.io.File;

class QQMusicDownloader$DownloadMusicTask
  implements Runnable
{
  bgoe jdField_a_of_type_Bgoe;
  bmte jdField_a_of_type_Bmte;
  
  public QQMusicDownloader$DownloadMusicTask(bgoe parambgoe, bmte parambmte)
  {
    this.jdField_a_of_type_Bgoe = parambgoe;
    this.jdField_a_of_type_Bmte = parambmte;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicDownloader", 2, "begin download " + this.jdField_a_of_type_Bgoe.a);
    }
    if ((bftf.a()) && (bftf.b() < 20971520L))
    {
      if (this.jdField_a_of_type_Bmte != null) {
        this.jdField_a_of_type_Bmte.onStart(this.jdField_a_of_type_Bgoe.a, false);
      }
      QLog.e("QQMusicDownloader", 1, "download err no space");
    }
    long l1;
    int i;
    long l2;
    do
    {
      return;
      String str = SvEffectSdkInitor.QQSpecialAVFilterResource.STORAGE_DIR;
      Object localObject = str;
      if (SdkContext.getInstance() != null)
      {
        localObject = str;
        if (SdkContext.getInstance().getResources() != null)
        {
          localObject = str;
          if (SdkContext.getInstance().getResources().getAVFilterResource() != null)
          {
            localObject = str;
            if (SdkContext.getInstance().getResources().getAVFilterResource().getMusicResPath() != null) {
              localObject = SdkContext.getInstance().getResources().getAVFilterResource().getMusicResPath();
            }
          }
        }
      }
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      l1 = SystemClock.uptimeMillis();
      i = bgog.a(this.jdField_a_of_type_Bgoe, null, null);
      l2 = SystemClock.uptimeMillis();
    } while (!QLog.isColorLevel());
    QLog.i("QQMusicDownloader", 2, "download cost " + (l2 - l1) + " result " + i + " key " + this.jdField_a_of_type_Bgoe.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QQMusicDownloader.DownloadMusicTask
 * JD-Core Version:    0.7.0.1
 */