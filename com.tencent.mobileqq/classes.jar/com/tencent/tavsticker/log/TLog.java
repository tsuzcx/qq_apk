package com.tencent.tavsticker.log;

import android.util.Log;
import com.tencent.tavsticker.TAVStickerHelper;
import java.util.Map;

public class TLog
{
  public static final String TAG_PREFIX = "TAVSticker-";
  
  public static void d(String paramString1, String paramString2)
  {
    if (TAVStickerHelper.isDebug())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TAVSticker-");
      localStringBuilder.append(paramString1);
      Log.d(localStringBuilder.toString(), paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (TAVStickerHelper.isDebug())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TAVSticker-");
      localStringBuilder.append(paramString1);
      Log.e(localStringBuilder.toString(), paramString2);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (TAVStickerHelper.isDebug())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TAVSticker-");
      localStringBuilder.append(paramString1);
      Log.i(localStringBuilder.toString(), paramString2);
    }
  }
  
  public static void printCallTraces(String paramString)
  {
    if (TAVStickerHelper.isDebug())
    {
      Object localObject = (StackTraceElement[])Thread.getAllStackTraces().get(Thread.currentThread());
      if (localObject == null) {
        return;
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("TAVSticker-");
      localStringBuilder1.append(paramString);
      v(localStringBuilder1.toString(), "======================start============================");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder1 = localObject[i];
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("TAVSticker-");
        localStringBuilder2.append(paramString);
        v(localStringBuilder2.toString(), localStringBuilder1.toString());
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TAVSticker-");
      ((StringBuilder)localObject).append(paramString);
      v(((StringBuilder)localObject).toString(), "=======================end============================");
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (TAVStickerHelper.isDebug())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TAVSticker-");
      localStringBuilder.append(paramString1);
      Log.v(localStringBuilder.toString(), paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (TAVStickerHelper.isDebug())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TAVSticker-");
      localStringBuilder.append(paramString1);
      Log.w(localStringBuilder.toString(), paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.log.TLog
 * JD-Core Version:    0.7.0.1
 */