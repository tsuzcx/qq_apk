package dov.com.qq.im.capture.music;

import android.os.SystemClock;
import azzz;
import batm;
import bato;
import bhim;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;

class QimMusicDownloader$DownloadMusicTask
  implements Runnable
{
  bhim jdField_a_of_type_Bhim;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public QimMusicDownloader$DownloadMusicTask(String paramString1, String paramString2, bhim parambhim)
  {
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Bhim = parambhim;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView.Downloader", 2, "begin download " + this.jdField_a_of_type_JavaLangString + " " + this.b);
    }
    if ((azzz.b()) && (azzz.b() < 20971520L))
    {
      if (this.jdField_a_of_type_Bhim != null) {
        this.jdField_a_of_type_Bhim.a(this.b, false);
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
      localObject = new batm(this.b, (File)localObject);
      ((batm)localObject).n = true;
      ((batm)localObject).b = 2;
      ((batm)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((batm)localObject).b(512);
      ((batm)localObject).a(this.jdField_a_of_type_Bhim);
      i = bato.a((batm)localObject, null, null);
      l2 = SystemClock.uptimeMillis();
    } while (!QLog.isColorLevel());
    QLog.i("MusicProviderView.Downloader", 2, "download cost " + (l2 - l1) + " result " + i + " key " + ((batm)localObject).jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QimMusicDownloader.DownloadMusicTask
 * JD-Core Version:    0.7.0.1
 */