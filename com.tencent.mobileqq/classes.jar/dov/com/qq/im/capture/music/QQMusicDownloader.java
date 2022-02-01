package dov.com.qq.im.capture.music;

import android.text.TextUtils;
import bihu;
import bpor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QQMusicDownloader
{
  public static bihu a(String paramString1, String paramString2, bpor parambpor)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("QQMusicDownloader", 1, "invalid downlaod params " + paramString1 + ", " + paramString2);
      return null;
    }
    paramString1 = new bihu(paramString1, new File(paramString2));
    paramString1.n = true;
    paramString1.b = 2;
    paramString1.a = paramString2;
    paramString1.b(512);
    paramString1.a(parambpor);
    return paramString1;
  }
  
  public static void a(bihu parambihu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicDownloader", 2, "cancel task " + parambihu.a);
    }
    parambihu.a(true);
  }
  
  public static void a(bihu parambihu, bpor parambpor)
  {
    ThreadManager.post(new QQMusicDownloader.DownloadMusicTask(parambihu, parambpor), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QQMusicDownloader
 * JD-Core Version:    0.7.0.1
 */