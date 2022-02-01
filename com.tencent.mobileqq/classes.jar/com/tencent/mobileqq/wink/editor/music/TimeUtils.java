package com.tencent.mobileqq.wink.editor.music;

import android.support.annotation.NonNull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TimeUtils
{
  public static final DateFormat a = new SimpleDateFormat("mm:ss", Locale.CHINA);
  
  public static String a(long paramLong)
  {
    paramLong = b(paramLong);
    long l = paramLong % 3600000L;
    int n = Math.round((float)(l % 60000L) / 1000.0F);
    int i1 = (int)l / 60000;
    int k = (int)(paramLong / 3600000L);
    int m = 0;
    int i = i1;
    int j = n;
    if (n == 60)
    {
      i = i1 + 1;
      j = 0;
    }
    if (i == 60)
    {
      k += 1;
      i = m;
    }
    Object localObject4 = "";
    Object localObject1;
    if (j < 10)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(j);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(j);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2;
    if (i < 10)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("0");
      ((StringBuilder)localObject2).append(i);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(i);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    if (k < 10)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("0");
      ((StringBuilder)localObject3).append(k);
      localObject3 = ((StringBuilder)localObject3).toString();
    }
    else
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(k);
      localObject3 = ((StringBuilder)localObject3).toString();
    }
    if (k > 0)
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append(":");
      localObject4 = ((StringBuilder)localObject4).toString();
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject4);
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(":");
    ((StringBuilder)localObject3).append((String)localObject1);
    return ((StringBuilder)localObject3).toString();
  }
  
  public static String a(@NonNull DateFormat paramDateFormat, long paramLong)
  {
    return paramDateFormat.format(Long.valueOf(b(paramLong)));
  }
  
  public static long b(long paramLong)
  {
    return Math.max(paramLong, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.TimeUtils
 * JD-Core Version:    0.7.0.1
 */