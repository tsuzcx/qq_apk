package com.tencent.mobileqq.hotchat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HotChatNote
{
  static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  static SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  public String c;
  public String d;
  public long e;
  public long f;
  public boolean g;
  
  public static long a(String paramString)
  {
    try
    {
      l = a.parse(paramString).getTime();
      return l;
    }
    catch (Exception localException)
    {
      long l;
      localException.printStackTrace();
      try
      {
        l = b.parse(paramString).getTime();
        return l;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return 0L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",");
    localStringBuilder.append(this.f);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.HotChatNote
 * JD-Core Version:    0.7.0.1
 */