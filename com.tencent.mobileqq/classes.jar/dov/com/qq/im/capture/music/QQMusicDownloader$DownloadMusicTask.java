package dov.com.qq.im.capture.music;

import android.os.SystemClock;
import bbbd;
import bbwg;
import bbwi;
import bflw;
import bjde;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;

class QQMusicDownloader$DownloadMusicTask
  implements Runnable
{
  bbwg jdField_a_of_type_Bbwg;
  bjde jdField_a_of_type_Bjde;
  
  public QQMusicDownloader$DownloadMusicTask(bbwg parambbwg, bjde parambjde)
  {
    this.jdField_a_of_type_Bbwg = parambbwg;
    this.jdField_a_of_type_Bjde = parambjde;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicDownloader", 2, "begin download " + this.jdField_a_of_type_Bbwg.a);
    }
    if ((bbbd.a()) && (bbbd.b() < 20971520L))
    {
      if (this.jdField_a_of_type_Bjde != null) {
        this.jdField_a_of_type_Bjde.a(this.jdField_a_of_type_Bbwg.a, false);
      }
      QLog.e("QQMusicDownloader", 1, "download err no space");
    }
    long l1;
    int i;
    long l2;
    do
    {
      return;
      String str = bflw.a;
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
      i = bbwi.a(this.jdField_a_of_type_Bbwg, null, null);
      l2 = SystemClock.uptimeMillis();
    } while (!QLog.isColorLevel());
    QLog.i("QQMusicDownloader", 2, "download cost " + (l2 - l1) + " result " + i + " key " + this.jdField_a_of_type_Bbwg.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QQMusicDownloader.DownloadMusicTask
 * JD-Core Version:    0.7.0.1
 */