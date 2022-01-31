package com.tencent.wxop.stat;

import android.content.Context;
import java.util.Map;
import java.util.Properties;

public class StatService
{
  public static void commitEvents(Context paramContext, int paramInt)
  {
    StatServiceImpl.commitEvents(paramContext, paramInt);
  }
  
  public static void flushDataToDB(Context paramContext)
  {
    StatServiceImpl.flushDataToDB(paramContext);
  }
  
  public static Properties getCommonKeyValueForKVEvent(String paramString)
  {
    return StatServiceImpl.getCommonKeyValueForKVEvent(paramString);
  }
  
  public static void onLowMemory(Context paramContext)
  {
    StatServiceImpl.onLowMemory(paramContext);
  }
  
  public static void onPause(Context paramContext)
  {
    StatServiceImpl.onPause(paramContext, null);
  }
  
  public static void onResume(Context paramContext)
  {
    StatServiceImpl.onResume(paramContext, null);
  }
  
  public static void onStop(Context paramContext)
  {
    StatServiceImpl.onStop(paramContext, null);
  }
  
  public static void reportAccount(Context paramContext, StatAccount paramStatAccount)
  {
    StatServiceImpl.reportAccount(paramContext, paramStatAccount, null);
  }
  
  public static void reportAppMonitorStat(Context paramContext, StatAppMonitor paramStatAppMonitor)
  {
    StatServiceImpl.reportAppMonitorStat(paramContext, paramStatAppMonitor, null);
  }
  
  public static void reportError(Context paramContext, String paramString)
  {
    StatServiceImpl.reportError(paramContext, paramString, null);
  }
  
  public static void reportException(Context paramContext, Throwable paramThrowable)
  {
    StatServiceImpl.reportException(paramContext, paramThrowable, null);
  }
  
  public static void reportGameUser(Context paramContext, StatGameUser paramStatGameUser)
  {
    StatServiceImpl.reportGameUser(paramContext, paramStatGameUser, null);
  }
  
  public static void reportQQ(Context paramContext, String paramString)
  {
    StatServiceImpl.reportQQ(paramContext, paramString, null);
  }
  
  public static void setCommonKeyValueForKVEvent(String paramString, Properties paramProperties)
  {
    StatServiceImpl.setCommonKeyValueForKVEvent(paramString, paramProperties);
  }
  
  public static void setContext(Context paramContext)
  {
    StatServiceImpl.setContext(paramContext);
  }
  
  public static void setEnvAttributes(Context paramContext, Map<String, String> paramMap)
  {
    StatServiceImpl.setEnvAttributes(paramContext, paramMap);
  }
  
  public static void startNewSession(Context paramContext)
  {
    StatServiceImpl.startNewSession(paramContext, null);
  }
  
  public static boolean startStatService(Context paramContext, String paramString1, String paramString2)
  {
    return StatServiceImpl.startStatService(paramContext, paramString1, paramString2, null);
  }
  
  public static void stopSession() {}
  
  public static void testSpeed(Context paramContext)
  {
    StatServiceImpl.testSpeed(paramContext);
  }
  
  public static void testSpeed(Context paramContext, Map<String, Integer> paramMap)
  {
    StatServiceImpl.testSpeed(paramContext, paramMap, null);
  }
  
  public static void trackBeginPage(Context paramContext, String paramString)
  {
    StatServiceImpl.trackBeginPage(paramContext, paramString, null);
  }
  
  public static void trackCustomBeginEvent(Context paramContext, String paramString, String... paramVarArgs)
  {
    StatServiceImpl.trackCustomBeginEvent(paramContext, paramString, null, paramVarArgs);
  }
  
  public static void trackCustomBeginKVEvent(Context paramContext, String paramString, Properties paramProperties)
  {
    StatServiceImpl.trackCustomBeginKVEvent(paramContext, paramString, paramProperties, null);
  }
  
  public static void trackCustomEndEvent(Context paramContext, String paramString, String... paramVarArgs)
  {
    StatServiceImpl.trackCustomEndEvent(paramContext, paramString, null, paramVarArgs);
  }
  
  public static void trackCustomEndKVEvent(Context paramContext, String paramString, Properties paramProperties)
  {
    StatServiceImpl.trackCustomEndKVEvent(paramContext, paramString, paramProperties, null);
  }
  
  public static void trackCustomEvent(Context paramContext, String paramString, String... paramVarArgs)
  {
    StatServiceImpl.trackCustomEvent(paramContext, paramString, null, paramVarArgs);
  }
  
  public static void trackCustomKVEvent(Context paramContext, String paramString, Properties paramProperties)
  {
    StatServiceImpl.trackCustomKVEvent(paramContext, paramString, paramProperties, null);
  }
  
  public static void trackCustomKVTimeIntervalEvent(Context paramContext, int paramInt, String paramString, Properties paramProperties)
  {
    StatServiceImpl.trackCustomKVTimeIntervalEvent(paramContext, paramString, paramProperties, paramInt, null);
  }
  
  public static void trackEndPage(Context paramContext, String paramString)
  {
    StatServiceImpl.trackEndPage(paramContext, paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.StatService
 * JD-Core Version:    0.7.0.1
 */