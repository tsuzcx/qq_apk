package dov.com.qq.im.capture.music;

import android.text.TextUtils;
import bhyo;
import boiw;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QQMusicDownloader
{
  public static bhyo a(String paramString1, String paramString2, boiw paramboiw)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("QQMusicDownloader", 1, "invalid downlaod params " + paramString1 + ", " + paramString2);
      return null;
    }
    paramString1 = new bhyo(paramString1, new File(paramString2));
    paramString1.n = true;
    paramString1.b = 2;
    paramString1.a = paramString2;
    paramString1.b(512);
    paramString1.a(paramboiw);
    return paramString1;
  }
  
  public static void a(bhyo parambhyo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicDownloader", 2, "cancel task " + parambhyo.a);
    }
    parambhyo.a(true);
  }
  
  public static void a(bhyo parambhyo, boiw paramboiw)
  {
    ThreadManager.post(new QQMusicDownloader.DownloadMusicTask(parambhyo, paramboiw), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QQMusicDownloader
 * JD-Core Version:    0.7.0.1
 */