package com.tencent.vtool;

import android.util.AndroidRuntimeException;
import android.util.Log;

public class SoftVideoDecoder
{
  private static final String TAG = SoftVideoDecoder.class.getSimpleName();
  private long mDuration;
  private long mHandler;
  private int mHeight;
  private long mLastTime;
  private int mRotation;
  private int mWidth;
  
  public SoftVideoDecoder(String paramString)
  {
    Log.i(TAG, "file name: " + paramString);
    int[] arrayOfInt = new int[2];
    this.mHandler = initDecoder(paramString, arrayOfInt);
    this.mWidth = arrayOfInt[0];
    this.mHeight = arrayOfInt[1];
    if (this.mHandler != -1L)
    {
      this.mDuration = getDuration(this.mHandler);
      this.mRotation = getRotation(this.mHandler);
    }
  }
  
  private static native long getDuration(long paramLong);
  
  private static native int getFrameAtTime(long paramLong1, byte[] paramArrayOfByte, long paramLong2);
  
  private static native int getRotation(long paramLong);
  
  private static native long initDecoder(String paramString, int[] paramArrayOfInt);
  
  public static boolean isVideoValid(String paramString)
  {
    long l = initDecoder(paramString, new int[2]);
    if (l == -1L) {
      return false;
    }
    releaseDecoder(l);
    return true;
  }
  
  private static native int releaseDecoder(long paramLong);
  
  private static native int seek(long paramLong1, long paramLong2);
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getRGBFrame(byte[] paramArrayOfByte, long paramLong)
  {
    try
    {
      if (paramArrayOfByte.length != this.mWidth * this.mHeight * 4)
      {
        Log.e(TAG, "rgb buffer size wrong");
        throw new AndroidRuntimeException("rgb buffer size wrong exception");
      }
    }
    finally {}
    int i;
    if (paramLong < 0L)
    {
      Log.e(TAG, "can't get frame at time less than zero");
      i = -1;
      return i;
    }
    if (paramLong < this.mDuration) {}
    for (;;)
    {
      if (paramLong < this.mLastTime) {
        seek(paramLong);
      }
      this.mLastTime = paramLong;
      i = getFrameAtTime(this.mHandler, paramArrayOfByte, paramLong);
      break;
      paramLong = this.mDuration;
      paramLong -= 1L;
    }
  }
  
  public int getRotation()
  {
    return this.mRotation;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public boolean isLive()
  {
    return this.mHandler != -1L;
  }
  
  public void release()
  {
    if (this.mHandler != -1L) {
      releaseDecoder(this.mHandler);
    }
  }
  
  public int seek(long paramLong)
  {
    try
    {
      Log.i(TAG, "seek to " + paramLong);
      this.mLastTime = paramLong;
      int i = seek(this.mHandler, paramLong);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.vtool.SoftVideoDecoder
 * JD-Core Version:    0.7.0.1
 */