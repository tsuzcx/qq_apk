package com.tencent.superplayer.utils;

import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener;

public class LogUtil
{
  public static final String TAG = "SuperPlayer-";
  
  public static void d(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null) {
      SuperPlayerSDKMgr.getLogListener().d("SuperPlayer-" + paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null) {
      SuperPlayerSDKMgr.getLogListener().e("SuperPlayer-" + paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null) {
      SuperPlayerSDKMgr.getLogListener().e(paramString1, paramString2 + " ," + paramThrowable.getLocalizedMessage());
    }
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null) {
      SuperPlayerSDKMgr.getLogListener().e("SuperPlayer-" + paramString, paramThrowable.getMessage());
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null) {
      SuperPlayerSDKMgr.getLogListener().i("SuperPlayer-" + paramString1, paramString2);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null) {
      SuperPlayerSDKMgr.getLogListener().v("SuperPlayer-" + paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null) {
      SuperPlayerSDKMgr.getLogListener().w("SuperPlayer-" + paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.utils.LogUtil
 * JD-Core Version:    0.7.0.1
 */