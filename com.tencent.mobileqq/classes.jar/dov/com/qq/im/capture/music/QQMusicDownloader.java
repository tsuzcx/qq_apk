package dov.com.qq.im.capture.music;

import android.text.TextUtils;
import anup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QQMusicDownloader
{
  public static DownloadTask a(String paramString1, String paramString2, MusicDownloadListener paramMusicDownloadListener)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("QQMusicDownloader", 1, "invalid downlaod params " + paramString1 + ", " + paramString2);
      return null;
    }
    paramString1 = new DownloadTask(paramString1, new File(paramString2));
    paramString1.l = true;
    paramString1.b = 2;
    paramString1.a = paramString2;
    paramString1.b(512);
    paramString1.a(paramMusicDownloadListener);
    return paramString1;
  }
  
  public static void a(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicDownloader", 2, "cancel task " + paramDownloadTask.a);
    }
    paramDownloadTask.a(true);
  }
  
  public static void a(DownloadTask paramDownloadTask, MusicDownloadListener paramMusicDownloadListener)
  {
    ThreadManager.post(new anup(paramDownloadTask, paramMusicDownloadListener), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QQMusicDownloader
 * JD-Core Version:    0.7.0.1
 */