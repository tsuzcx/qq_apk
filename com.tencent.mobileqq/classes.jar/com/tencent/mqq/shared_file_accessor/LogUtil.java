package com.tencent.mqq.shared_file_accessor;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

public class LogUtil
{
  static
  {
    Uri.parse("content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/log");
  }
  
  public static void d(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public static d timeLogBegin()
  {
    return new d();
  }
  
  public static void timeLogEnd(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, c paramc, boolean paramBoolean, d paramd) {}
  
  public static void timeLogEnd(String paramString, d paramd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.LogUtil
 * JD-Core Version:    0.7.0.1
 */