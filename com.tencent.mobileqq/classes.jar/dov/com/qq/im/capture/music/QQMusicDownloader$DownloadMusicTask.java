package dov.com.qq.im.capture.music;

import android.os.SystemClock;
import bdal;
import bdvv;
import bdvx;
import bhnh;
import blpg;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;

class QQMusicDownloader$DownloadMusicTask
  implements Runnable
{
  bdvv jdField_a_of_type_Bdvv;
  blpg jdField_a_of_type_Blpg;
  
  public QQMusicDownloader$DownloadMusicTask(bdvv parambdvv, blpg paramblpg)
  {
    this.jdField_a_of_type_Bdvv = parambdvv;
    this.jdField_a_of_type_Blpg = paramblpg;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicDownloader", 2, "begin download " + this.jdField_a_of_type_Bdvv.a);
    }
    if ((bdal.a()) && (bdal.b() < 20971520L))
    {
      if (this.jdField_a_of_type_Blpg != null) {
        this.jdField_a_of_type_Blpg.a(this.jdField_a_of_type_Bdvv.a, false);
      }
      QLog.e("QQMusicDownloader", 1, "download err no space");
    }
    long l1;
    int i;
    long l2;
    do
    {
      return;
      String str = bhnh.a;
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
      i = bdvx.a(this.jdField_a_of_type_Bdvv, null, null);
      l2 = SystemClock.uptimeMillis();
    } while (!QLog.isColorLevel());
    QLog.i("QQMusicDownloader", 2, "download cost " + (l2 - l1) + " result " + i + " key " + this.jdField_a_of_type_Bdvv.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QQMusicDownloader.DownloadMusicTask
 * JD-Core Version:    0.7.0.1
 */