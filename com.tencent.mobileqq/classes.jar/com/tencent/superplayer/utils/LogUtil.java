package com.tencent.superplayer.utils;

import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener;

public class LogUtil
{
  public static final String TAG = "SuperPlayer-";
  
  public static void d(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null)
    {
      SuperPlayerSDKMgr.ILogListener localILogListener = SuperPlayerSDKMgr.getLogListener();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SuperPlayer-");
      localStringBuilder.append(paramString1);
      localILogListener.d(localStringBuilder.toString(), paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null)
    {
      SuperPlayerSDKMgr.ILogListener localILogListener = SuperPlayerSDKMgr.getLogListener();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SuperPlayer-");
      localStringBuilder.append(paramString1);
      localILogListener.e(localStringBuilder.toString(), paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null)
    {
      SuperPlayerSDKMgr.ILogListener localILogListener = SuperPlayerSDKMgr.getLogListener();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" ,");
      localStringBuilder.append(paramThrowable.getLocalizedMessage());
      localILogListener.e(paramString1, localStringBuilder.toString());
    }
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null)
    {
      SuperPlayerSDKMgr.ILogListener localILogListener = SuperPlayerSDKMgr.getLogListener();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SuperPlayer-");
      localStringBuilder.append(paramString);
      localILogListener.e(localStringBuilder.toString(), paramThrowable.getMessage());
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null)
    {
      SuperPlayerSDKMgr.ILogListener localILogListener = SuperPlayerSDKMgr.getLogListener();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SuperPlayer-");
      localStringBuilder.append(paramString1);
      localILogListener.i(localStringBuilder.toString(), paramString2);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null)
    {
      SuperPlayerSDKMgr.ILogListener localILogListener = SuperPlayerSDKMgr.getLogListener();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SuperPlayer-");
      localStringBuilder.append(paramString1);
      localILogListener.v(localStringBuilder.toString(), paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.getLogListener() != null)
    {
      SuperPlayerSDKMgr.ILogListener localILogListener = SuperPlayerSDKMgr.getLogListener();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SuperPlayer-");
      localStringBuilder.append(paramString1);
      localILogListener.w(localStringBuilder.toString(), paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.utils.LogUtil
 * JD-Core Version:    0.7.0.1
 */