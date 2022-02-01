package com.vivo.push.util;

import android.os.Looper;
import android.util.Log;

public final class g
{
  public static void a(String paramString)
  {
    if ((o.a()) && (Looper.myLooper() == Looper.getMainLooper()))
    {
      StringBuilder localStringBuilder = new StringBuilder("Operation: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" in main thread!");
      Log.w("DebugUtil", localStringBuilder.toString(), new Throwable());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.g
 * JD-Core Version:    0.7.0.1
 */