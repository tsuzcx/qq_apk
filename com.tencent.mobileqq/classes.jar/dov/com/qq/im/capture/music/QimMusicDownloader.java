package dov.com.qq.im.capture.music;

import android.text.TextUtils;
import anus;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class QimMusicDownloader
{
  public static void a(String paramString1, String paramString2, MusicDownloadListener paramMusicDownloadListener)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("MusicProviderView.Downloader", 1, "invalid downlaod params " + paramString1 + ", " + paramString2);
      return;
    }
    ThreadManager.post(new anus(paramString1, paramString2, paramMusicDownloadListener), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QimMusicDownloader
 * JD-Core Version:    0.7.0.1
 */