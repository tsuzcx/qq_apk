package com.tencent.mqq.shared_file_accessor;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

public class LogUtil
{
  private static final String CP_URI_BASE = "content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/log";
  private static final Uri LOG_URI = Uri.parse("content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/log");
  static final boolean mTimeLogEnabled = false;
  static final boolean mTimeLogIntoLogcat = true;
  static final boolean sLogcatLogEnabled = false;
  
  public static void d(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public static LogUtil.LogTicket timeLogBegin()
  {
    return new LogUtil.LogTicket();
  }
  
  public static void timeLogEnd(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, CommonConstants.ValueType paramValueType, boolean paramBoolean, LogUtil.LogTicket paramLogTicket) {}
  
  public static void timeLogEnd(String paramString, LogUtil.LogTicket paramLogTicket) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.LogUtil
 * JD-Core Version:    0.7.0.1
 */