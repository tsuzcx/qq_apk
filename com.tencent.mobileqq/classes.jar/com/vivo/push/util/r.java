package com.vivo.push.util;

import com.vivo.push.b.c;

public final class r
{
  public static int a(c paramc)
  {
    w localw = w.b();
    int i = paramc.b();
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder("com.vivo.push_preferences.operate.");
    localStringBuilder.append(i);
    localStringBuilder.append("OPERATE_COUNT");
    int j = localw.a(localStringBuilder.toString());
    localStringBuilder = new StringBuilder("com.vivo.push_preferences.operate.");
    localStringBuilder.append(i);
    localStringBuilder.append("START_TIME");
    l -= localw.b(localStringBuilder.toString(), 0L);
    if ((l <= 86400000L) && (l >= 0L))
    {
      if (j >= paramc.f()) {
        return 1001;
      }
      paramc = new StringBuilder("com.vivo.push_preferences.operate.");
      paramc.append(i);
      paramc.append("OPERATE_COUNT");
      localw.a(paramc.toString(), j + 1);
    }
    else
    {
      paramc = new StringBuilder("com.vivo.push_preferences.operate.");
      paramc.append(i);
      paramc.append("START_TIME");
      localw.a(paramc.toString(), System.currentTimeMillis());
      paramc = new StringBuilder("com.vivo.push_preferences.operate.");
      paramc.append(i);
      paramc.append("OPERATE_COUNT");
      localw.a(paramc.toString(), 1);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.r
 * JD-Core Version:    0.7.0.1
 */