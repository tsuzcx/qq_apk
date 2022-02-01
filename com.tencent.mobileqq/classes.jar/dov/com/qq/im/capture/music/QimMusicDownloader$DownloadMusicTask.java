package dov.com.qq.im.capture.music;

import android.os.SystemClock;
import bhjx;
import bihu;
import bihw;
import bpor;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;

class QimMusicDownloader$DownloadMusicTask
  implements Runnable
{
  bpor jdField_a_of_type_Bpor;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public QimMusicDownloader$DownloadMusicTask(String paramString1, String paramString2, bpor parambpor)
  {
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Bpor = parambpor;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView.Downloader", 2, "begin download " + this.jdField_a_of_type_JavaLangString + " " + this.b);
    }
    if ((bhjx.a()) && (bhjx.b() < 20971520L))
    {
      if (this.jdField_a_of_type_Bpor != null) {
        this.jdField_a_of_type_Bpor.a(this.b, false);
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
      localObject = new bihu(this.b, (File)localObject);
      ((bihu)localObject).n = true;
      ((bihu)localObject).b = 2;
      ((bihu)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((bihu)localObject).b(512);
      ((bihu)localObject).a(this.jdField_a_of_type_Bpor);
      i = bihw.a((bihu)localObject, null, null);
      l2 = SystemClock.uptimeMillis();
    } while (!QLog.isColorLevel());
    QLog.i("MusicProviderView.Downloader", 2, "download cost " + (l2 - l1) + " result " + i + " key " + ((bihu)localObject).jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QimMusicDownloader.DownloadMusicTask
 * JD-Core Version:    0.7.0.1
 */