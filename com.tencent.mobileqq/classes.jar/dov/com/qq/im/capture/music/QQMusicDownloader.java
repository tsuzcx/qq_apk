package dov.com.qq.im.capture.music;

import android.text.TextUtils;
import beae;
import blts;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QQMusicDownloader
{
  public static beae a(String paramString1, String paramString2, blts paramblts)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("QQMusicDownloader", 1, "invalid downlaod params " + paramString1 + ", " + paramString2);
      return null;
    }
    paramString1 = new beae(paramString1, new File(paramString2));
    paramString1.n = true;
    paramString1.b = 2;
    paramString1.a = paramString2;
    paramString1.b(512);
    paramString1.a(paramblts);
    return paramString1;
  }
  
  public static void a(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicDownloader", 2, "cancel task " + parambeae.a);
    }
    parambeae.a(true);
  }
  
  public static void a(beae parambeae, blts paramblts)
  {
    ThreadManager.post(new QQMusicDownloader.DownloadMusicTask(parambeae, paramblts), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QQMusicDownloader
 * JD-Core Version:    0.7.0.1
 */