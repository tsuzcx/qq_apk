package com.tencent.mobileqq.shortvideo.filter;

import android.os.SystemClock;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.sveffects.SLog;

public class QQFilterLogManager
{
  public static String TAG = "QQFilterLog";
  public static boolean isEnable = false;
  public static long mFilterStartTime;
  public static long mOnDrawFrameStartTime;
  public static long mOnOldDrawFrameStartTime;
  public static long mPTVStartTime;
  public static long mPrintLogOverTime = 80L;
  public static long mPrintLogSpcingTime = 2000L;
  public static long mSpcingTime;
  public static long mStartTime;
  
  public static boolean isRenderOverTime(long paramLong)
  {
    return paramLong > mPrintLogOverTime;
  }
  
  public static boolean isSpacingOverTime(long paramLong)
  {
    return paramLong > mPrintLogSpcingTime;
  }
  
  public static void setFilterStatus(String paramString, boolean paramBoolean) {}
  
  public static void setLogEnd(String paramString)
  {
    long l = SystemClock.currentThreadTimeMillis() - mStartTime;
    if ((SLog.isEnable()) && (isEnable)) {
      SLog.d(TAG, "QQFilterRenderManager 生命周期结束耗时 [" + paramString + " 毫秒=" + l + "ms 微秒=" + l * 1000L + "us]");
    }
  }
  
  public static void setLogStart(String paramString)
  {
    mStartTime = SystemClock.currentThreadTimeMillis();
    if ((SLog.isEnable()) && (isEnable)) {
      SLog.d(TAG, "QQFilterRenderManager 生命周期开始 [" + paramString + "]");
    }
  }
  
  public static void setOnDrawFilterEnd(String paramString)
  {
    long l = SystemClock.currentThreadTimeMillis() - mFilterStartTime;
    if (((SLog.isEnable()) && (isEnable)) || ((SLog.isEnable()) && (isRenderOverTime(l)))) {
      SLog.d(TAG, "QQFilterRenderManager_渲染item耗时:[" + paramString + " 毫秒=" + l + "ms 微秒=" + l * 1000L + "us]");
    }
  }
  
  public static void setOnDrawFilterStart()
  {
    mFilterStartTime = SystemClock.currentThreadTimeMillis();
  }
  
  public static void setOnDrawFrameEnd()
  {
    long l = SystemClock.currentThreadTimeMillis() - mOnDrawFrameStartTime;
    if ((SLog.isEnable()) && (isEnable)) {
      SLog.w(TAG, "QQFilterRenderManager_一帧结束 总耗时[ 毫秒=" + l + "ms 微秒=" + 1000L * l + "us]");
    }
    if (QmcfManager.getInstance().isQmcfWork()) {
      QmcfManager.getInstance().updateQmcfFrameConsume(l);
    }
  }
  
  public static void setOnDrawFrameStart()
  {
    mOnDrawFrameStartTime = SystemClock.currentThreadTimeMillis();
    if (isSpacingOverTime(mOnDrawFrameStartTime - mSpcingTime))
    {
      isEnable = true;
      mSpcingTime = mOnDrawFrameStartTime;
    }
    for (;;)
    {
      if ((SLog.isEnable()) && (isEnable)) {
        SLog.w(TAG, "QQFilterRenderManager 一帧开始");
      }
      return;
      isEnable = false;
    }
  }
  
  public static void setPTVEnd(String paramString)
  {
    long l = SystemClock.currentThreadTimeMillis() - mPTVStartTime;
    if ((SLog.isEnable()) && (isEnable)) {
      SLog.d(TAG, "QQFilterRenderManager 挂件：  [" + paramString + " 毫秒=" + l + "ms 微秒=" + l * 1000L + "us]");
    }
  }
  
  public static void setPTVStart()
  {
    mPTVStartTime = SystemClock.currentThreadTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQFilterLogManager
 * JD-Core Version:    0.7.0.1
 */