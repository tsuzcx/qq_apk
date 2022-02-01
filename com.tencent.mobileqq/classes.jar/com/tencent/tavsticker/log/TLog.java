package com.tencent.tavsticker.log;

import android.util.Log;
import com.tencent.tavsticker.TAVStickerHelper;
import java.util.Map;

public class TLog
{
  public static final String TAG_PREFIX = "TAVSticker-";
  
  public static void d(String paramString1, String paramString2)
  {
    if (TAVStickerHelper.isDebug()) {
      Log.d("TAVSticker-" + paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (TAVStickerHelper.isDebug()) {
      Log.e("TAVSticker-" + paramString1, paramString2);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (TAVStickerHelper.isDebug()) {
      Log.i("TAVSticker-" + paramString1, paramString2);
    }
  }
  
  public static void printCallTraces(String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement;
    if (TAVStickerHelper.isDebug())
    {
      arrayOfStackTraceElement = (StackTraceElement[])Thread.getAllStackTraces().get(Thread.currentThread());
      if (arrayOfStackTraceElement != null) {}
    }
    else
    {
      return;
    }
    v("TAVSticker-" + paramString, "======================start============================");
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      v("TAVSticker-" + paramString, localStackTraceElement.toString());
      i += 1;
    }
    v("TAVSticker-" + paramString, "=======================end============================");
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (TAVStickerHelper.isDebug()) {
      Log.v("TAVSticker-" + paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (TAVStickerHelper.isDebug()) {
      Log.w("TAVSticker-" + paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.log.TLog
 * JD-Core Version:    0.7.0.1
 */