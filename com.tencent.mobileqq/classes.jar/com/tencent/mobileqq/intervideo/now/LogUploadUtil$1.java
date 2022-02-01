package com.tencent.mobileqq.intervideo.now;

import android.util.Log;
import avum;
import avun;
import java.io.IOException;

public final class LogUploadUtil$1
  implements Runnable
{
  public LogUploadUtil$1(String paramString) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      avun.a(avun.a(), avun.b());
      Log.i("FileUtil", "compress time " + (System.currentTimeMillis() - l));
      avum.a(this.a, avun.b());
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("FileUtil", localIOException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.LogUploadUtil.1
 * JD-Core Version:    0.7.0.1
 */