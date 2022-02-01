package com.tencent.mobileqq.statistics;

import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;

public class MultiVideoRichActionReportCollection
{
  static boolean a = false;
  static String b = "";
  static int c = 0;
  public static int d = 1;
  public static int e = 2;
  public static int f = 3;
  private static String g = "MultiVideoRichActionReportCollection";
  private static long h = 0L;
  private static String i = "";
  private static long j = 0L;
  private static String k = "";
  private static long l = 0L;
  private static String m = "";
  private static long n = 0L;
  private static String o = "";
  private static int p;
  
  public static void a(int paramInt, String paramString)
  {
    AVLog.printDebugLog(g, String.format("onConnected sessionType = %s, roomid = %s", new Object[] { Integer.valueOf(paramInt), paramString }));
    a = true;
    b = paramString;
    c = paramInt;
    b = paramString;
    paramInt = c;
    if ((paramInt != 4) && (paramInt != 3))
    {
      if ((paramInt == 2) || (paramInt == 1)) {
        p = e;
      }
    }
    else {
      p = f;
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface != null) {
      i1 = paramVideoAppInterface.n("BEAUTY_SKIN");
    } else {
      i1 = 0;
    }
    if (i1 > 0)
    {
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append(i1);
      paramVideoAppInterface.append("");
      c(paramVideoAppInterface.toString());
    }
    int i1 = p;
    if (i1 == e)
    {
      if (h == 0L) {
        a("0X8007F32");
      }
      if (j == 0L) {
        a("0X8007F34");
      }
      if (l == 0L) {
        a("0X8007F36");
      }
      if (n == 0L) {
        a("0X8007E69");
      }
    }
    else if (i1 == f)
    {
      if (h == 0L) {
        a("0X8007F38");
      }
      if (j == 0L) {
        a("0X8007F3A");
      }
      if (l == 0L) {
        a("0X8007F3C");
      }
      if (n == 0L) {
        a("0X8007E65");
      }
    }
  }
  
  public static void a(String paramString)
  {
    AVLog.printDebugLog(g, String.format("reportClickEvent key = %s, type = %s, roomid = %s", new Object[] { paramString, "", b }));
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", b, "");
  }
  
  public static void a(String paramString1, String paramString2)
  {
    AVLog.printDebugLog(g, String.format("reportClickEvent id = %s, type = %s, roomid = %s", new Object[] { paramString1, paramString2, b }));
    ReportController.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "", "", b, paramString2);
  }
  
  public static void b(String paramString)
  {
    i = paramString;
    h = System.currentTimeMillis();
  }
  
  public static void c(String paramString)
  {
    int i1 = p;
    if (i1 == e) {
      a("0X8007F35", paramString);
    } else if (i1 == f) {
      a("0X8007F3B", paramString);
    }
    m = paramString;
    l = System.currentTimeMillis();
  }
  
  public static void d(String paramString)
  {
    int i1 = p;
    if (i1 == e) {
      a("0X8007E6A", paramString);
    } else if (i1 == f) {
      a("0X8007E66", paramString);
    }
    o = paramString;
    n = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection
 * JD-Core Version:    0.7.0.1
 */