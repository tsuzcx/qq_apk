package dov.com.tencent.biz.qqstory.takevideo.rmw;

import com.tencent.biz.qqstory.support.logging.SLog;

public class RMWLog
{
  public static String a(String paramString)
  {
    return "Q.qqstory.record.RMW." + paramString;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    SLog.b(a(paramString1), paramString2);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    SLog.c(a(paramString1), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.rmw.RMWLog
 * JD-Core Version:    0.7.0.1
 */