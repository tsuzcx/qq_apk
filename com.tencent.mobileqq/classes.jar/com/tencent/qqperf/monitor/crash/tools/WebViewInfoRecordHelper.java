package com.tencent.qqperf.monitor.crash.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class WebViewInfoRecordHelper
{
  private static int e;
  private static LinkedList<WebViewInfoRecordHelper> f = new LinkedList();
  public long a;
  public String b;
  public String c;
  public int d;
  private SimpleDateFormat g = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
  
  public WebViewInfoRecordHelper(long paramLong, String paramString1, String paramString2)
  {
    int j = 0;
    this.d = 0;
    this.a = paramLong;
    this.b = paramString1;
    this.c = paramString2;
    int i;
    if (paramString1 == null) {
      i = 0;
    } else {
      i = paramString1.getBytes().length;
    }
    if (paramString2 != null) {
      j = paramString2.getBytes().length;
    }
    this.d = (i + 19 + 1 + j + 1);
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(10);
    while (f.size() > 0) {
      localStringBuilder.append(((WebViewInfoRecordHelper)f.removeLast()).toString());
    }
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return;
      }
      paramString1 = new WebViewInfoRecordHelper(System.currentTimeMillis(), paramString1, paramString2);
      f.add(paramString1);
      for (e += paramString1.d; (e > 15360L) && (f.size() > 1); e -= paramString1.d) {
        paramString1 = (WebViewInfoRecordHelper)f.removeLast();
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    Date localDate = new Date(this.a);
    localStringBuilder.append(this.g.format(localDate));
    localStringBuilder.append(" ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.tools.WebViewInfoRecordHelper
 * JD-Core Version:    0.7.0.1
 */