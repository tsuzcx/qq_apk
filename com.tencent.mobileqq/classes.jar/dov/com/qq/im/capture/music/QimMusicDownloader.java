package dov.com.qq.im.capture.music;

import android.text.TextUtils;
import blts;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class QimMusicDownloader
{
  public static void a(String paramString1, String paramString2, blts paramblts)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("MusicProviderView.Downloader", 1, "invalid downlaod params " + paramString1 + ", " + paramString2);
      return;
    }
    ThreadManager.post(new QimMusicDownloader.DownloadMusicTask(paramString1, paramString2, paramblts), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QimMusicDownloader
 * JD-Core Version:    0.7.0.1
 */