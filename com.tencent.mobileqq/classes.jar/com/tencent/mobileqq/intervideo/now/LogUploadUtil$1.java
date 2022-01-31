package com.tencent.mobileqq.intervideo.now;

import android.util.Log;
import asyn;
import asyo;
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
      asyo.a(asyo.a(), asyo.b());
      Log.i("FileUtil", "compress time " + (System.currentTimeMillis() - l));
      asyn.a(this.a, asyo.b());
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