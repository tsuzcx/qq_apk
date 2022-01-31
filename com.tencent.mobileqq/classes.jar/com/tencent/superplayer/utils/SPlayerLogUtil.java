package com.tencent.superplayer.utils;

import com.tencent.superplayer.api.SuperPlayerMgr;
import com.tencent.superplayer.api.SuperPlayerMgr.ILogListener;

public class SPlayerLogUtil
{
  public static final String TAG = "MediaPlayerMgr";
  
  public static void d(String paramString1, String paramString2)
  {
    if (SuperPlayerMgr.getLogListener() != null) {
      SuperPlayerMgr.getLogListener().d(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (SuperPlayerMgr.getLogListener() != null) {
      SuperPlayerMgr.getLogListener().e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    if (SuperPlayerMgr.getLogListener() != null) {
      SuperPlayerMgr.getLogListener().e(paramString, paramThrowable.getMessage());
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (SuperPlayerMgr.getLogListener() != null) {
      SuperPlayerMgr.getLogListener().i(paramString1, paramString2);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (SuperPlayerMgr.getLogListener() != null) {
      SuperPlayerMgr.getLogListener().v(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (SuperPlayerMgr.getLogListener() != null) {
      SuperPlayerMgr.getLogListener().w(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.utils.SPlayerLogUtil
 * JD-Core Version:    0.7.0.1
 */