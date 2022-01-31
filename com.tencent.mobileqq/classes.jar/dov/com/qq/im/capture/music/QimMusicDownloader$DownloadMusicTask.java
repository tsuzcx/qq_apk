package dov.com.qq.im.capture.music;

import android.os.SystemClock;
import bdal;
import bdvv;
import bdvx;
import blpg;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;

class QimMusicDownloader$DownloadMusicTask
  implements Runnable
{
  blpg jdField_a_of_type_Blpg;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public QimMusicDownloader$DownloadMusicTask(String paramString1, String paramString2, blpg paramblpg)
  {
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Blpg = paramblpg;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView.Downloader", 2, "begin download " + this.jdField_a_of_type_JavaLangString + " " + this.b);
    }
    if ((bdal.a()) && (bdal.b() < 20971520L))
    {
      if (this.jdField_a_of_type_Blpg != null) {
        this.jdField_a_of_type_Blpg.a(this.b, false);
      }
      QLog.e("MusicProviderView.Downloader", 1, "download err no space");
    }
    Object localObject;
    long l1;
    int i;
    long l2;
    do
    {
      return;
      localObject = new File(SdkContext.getInstance().getResources().getAVFilterResource().getMusicResPath());
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      l1 = SystemClock.uptimeMillis();
      localObject = new bdvv(this.b, (File)localObject);
      ((bdvv)localObject).n = true;
      ((bdvv)localObject).b = 2;
      ((bdvv)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((bdvv)localObject).b(512);
      ((bdvv)localObject).a(this.jdField_a_of_type_Blpg);
      i = bdvx.a((bdvv)localObject, null, null);
      l2 = SystemClock.uptimeMillis();
    } while (!QLog.isColorLevel());
    QLog.i("MusicProviderView.Downloader", 2, "download cost " + (l2 - l1) + " result " + i + " key " + ((bdvv)localObject).jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QimMusicDownloader.DownloadMusicTask
 * JD-Core Version:    0.7.0.1
 */