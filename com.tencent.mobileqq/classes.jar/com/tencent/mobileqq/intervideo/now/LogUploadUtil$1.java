package com.tencent.mobileqq.intervideo.now;

import android.util.Log;
import java.io.IOException;

final class LogUploadUtil$1
  implements Runnable
{
  LogUploadUtil$1(String paramString) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      LogUploadUtil.a(LogUploadUtil.a(), LogUploadUtil.b());
      Log.i("FileUtil", "compress time " + (System.currentTimeMillis() - l));
      FileUploadUtil.a(this.a, LogUploadUtil.b());
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("FileUtil", localIOException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.LogUploadUtil.1
 * JD-Core Version:    0.7.0.1
 */