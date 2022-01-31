package dov.com.qq.im.capture.music;

import android.text.TextUtils;
import bdvv;
import blpg;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QQMusicDownloader
{
  public static bdvv a(String paramString1, String paramString2, blpg paramblpg)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("QQMusicDownloader", 1, "invalid downlaod params " + paramString1 + ", " + paramString2);
      return null;
    }
    paramString1 = new bdvv(paramString1, new File(paramString2));
    paramString1.n = true;
    paramString1.b = 2;
    paramString1.a = paramString2;
    paramString1.b(512);
    paramString1.a(paramblpg);
    return paramString1;
  }
  
  public static void a(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicDownloader", 2, "cancel task " + parambdvv.a);
    }
    parambdvv.a(true);
  }
  
  public static void a(bdvv parambdvv, blpg paramblpg)
  {
    ThreadManager.post(new QQMusicDownloader.DownloadMusicTask(parambdvv, paramblpg), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QQMusicDownloader
 * JD-Core Version:    0.7.0.1
 */