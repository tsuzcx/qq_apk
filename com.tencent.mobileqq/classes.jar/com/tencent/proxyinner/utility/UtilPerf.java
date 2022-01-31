package com.tencent.proxyinner.utility;

import com.tencent.proxyinner.log.XLog;

public class UtilPerf
{
  private static final String TAG = "UtilPerf";
  private static long mBeforeCheckVersionTimeSpan;
  private static long mBetweenCheckAndLoadTimeSpan;
  private static long mCheckVersionTimeSpan;
  private static long mFinishCheckVersionTime;
  private static long mFinishLoadTime;
  private static long mFinishStartActivityTime;
  private static long mInitTime;
  private static long mInitTimeSpan;
  private static long mLoadTimeSpan;
  private static long mStartActivityTime;
  private static long mStartActivityTimeSpan;
  private static long mStartCheckVersionTime;
  private static long mStartLoadTime;
  private static long mStartRunTime;
  private static long mTimeSpanAll;
  
  public static void finishCheckVersion()
  {
    mFinishCheckVersionTime = System.currentTimeMillis();
    mCheckVersionTimeSpan = mFinishCheckVersionTime - mStartCheckVersionTime;
  }
  
  public static void finishInit()
  {
    mInitTimeSpan = System.currentTimeMillis() - mInitTime;
  }
  
  public static void finishLoad()
  {
    mFinishLoadTime = System.currentTimeMillis();
    mLoadTimeSpan = mFinishLoadTime - mStartLoadTime;
  }
  
  public static void finishStartActivity()
  {
    mFinishStartActivityTime = System.currentTimeMillis();
    mStartActivityTimeSpan = mFinishStartActivityTime - mStartActivityTime;
    mTimeSpanAll = mFinishStartActivityTime - mStartRunTime;
    XLog.e("UtilPerf", "xproxy runplugin finish timeAll = " + mTimeSpanAll + " mInitTimeSpan = " + mInitTimeSpan + " mBeforeCheckVersionTimeSpan = " + mBeforeCheckVersionTimeSpan + " mCheckVersionTimeSpan = " + mCheckVersionTimeSpan + " mBetweenCheckAndLoadTimeSpan = " + mBetweenCheckAndLoadTimeSpan + " mLoadTimeSpan = " + mLoadTimeSpan + " mStartActivityTimeSpan = " + mStartActivityTimeSpan);
  }
  
  public static void init()
  {
    mInitTime = System.currentTimeMillis();
  }
  
  public static void startActivity()
  {
    mStartActivityTime = System.currentTimeMillis();
  }
  
  public static void startCheckVersion()
  {
    mStartCheckVersionTime = System.currentTimeMillis();
    mBeforeCheckVersionTimeSpan = mStartCheckVersionTime - mStartRunTime;
  }
  
  public static void startLoad()
  {
    mStartLoadTime = System.currentTimeMillis();
    mBetweenCheckAndLoadTimeSpan = mStartLoadTime - mFinishCheckVersionTime;
  }
  
  public static void startRun()
  {
    mStartRunTime = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.utility.UtilPerf
 * JD-Core Version:    0.7.0.1
 */