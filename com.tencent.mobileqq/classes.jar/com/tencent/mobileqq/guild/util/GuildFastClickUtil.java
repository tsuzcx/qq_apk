package com.tencent.mobileqq.guild.util;

import android.util.LruCache;
import androidx.annotation.NonNull;

public class GuildFastClickUtil
{
  private static final LruCache<String, Long> a = new LruCache(10);
  
  public static boolean a(@NonNull String paramString)
  {
    Long localLong1 = (Long)a.get(paramString);
    Long localLong2 = Long.valueOf(System.currentTimeMillis());
    if (localLong1 == null)
    {
      a.put(paramString, localLong2);
      return false;
    }
    if (Math.abs(localLong2.longValue() - localLong1.longValue()) >= 500L)
    {
      a.put(paramString, localLong2);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.GuildFastClickUtil
 * JD-Core Version:    0.7.0.1
 */