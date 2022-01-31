package com.tencent.superplayer.utils;

import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener;

public class LogUtil
{
  public static final String TAG = "MediaPlayerMgr";
  
  public static void d(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null) {
      SuperPlayerSDKMgr.getLogListener().d(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null) {
      SuperPlayerSDKMgr.getLogListener().e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null) {
      SuperPlayerSDKMgr.getLogListener().e(paramString, paramThrowable.getMessage());
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null) {
      SuperPlayerSDKMgr.getLogListener().i(paramString1, paramString2);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null) {
      SuperPlayerSDKMgr.getLogListener().v(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null) {
      SuperPlayerSDKMgr.getLogListener().w(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.utils.LogUtil
 * JD-Core Version:    0.7.0.1
 */