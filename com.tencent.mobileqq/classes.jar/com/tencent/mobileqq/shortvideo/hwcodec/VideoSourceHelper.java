package com.tencent.mobileqq.shortvideo.hwcodec;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class VideoSourceHelper
{
  public static final int STATUS_ERROR = -1;
  public static final int STATUS_SUCCESS = 0;
  public static WeakReference<VideoSourceHelper> sCurrentRef;
  private boolean isInited = false;
  private long mAfFilePtr;
  private String mAfPath;
  private int mAudioBufferSize = 0;
  public int mChannel;
  private int mDestVideoHeight;
  private int mDestVideoWidth;
  private final Object mGetFrameBitmapLock = new Object();
  public int mOrientationDegree = 0;
  public int mPCMFormat;
  public int mSampleRate;
  private long mTmpBufferPtr;
  private long mVfFilePtr;
  private String mVfPath;
  private int mVideoBufferSize = 0;
  
  public VideoSourceHelper(String paramString1, String paramString2)
  {
    this.mVfPath = paramString1;
    this.mAfPath = paramString2;
    this.isInited = false;
    this.mOrientationDegree = 0;
    sCurrentRef = new WeakReference(this);
  }
  
  private native int nativeCloseHelper(long paramLong1, long paramLong2, long paramLong3);
  
  private native int nativeGetNextAudioFrame(byte[] paramArrayOfByte, int paramInt, long paramLong);
  
  private native int nativeGetNextVideoFrame(byte[] paramArrayOfByte, int paramInt1, long paramLong1, long[] paramArrayOfLong, long paramLong2, int paramInt2);
  
  private native int nativeGetNextVideoFrameBitmap(long paramLong1, Bitmap paramBitmap, long paramLong2);
  
  private native int nativeGetNextVideoFrameCache(long paramLong, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, boolean paramBoolean);
  
  private native int nativeGetVideoFrameBitMapByIndex(long paramLong1, Bitmap paramBitmap, long paramLong2, int paramInt);
  
  private native int nativeInitHelper(String paramString1, String paramString2, long[] paramArrayOfLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3);
  
  private native int nativeResetSource(long paramLong1, long paramLong2);
  
  public static native int nativeSetMaxPhotoFrameCount(int paramInt);
  
  public static native int nativeSetMosaic(int paramInt, byte[] paramArrayOfByte);
  
  public static native int nativeSetPlayAFMute(boolean paramBoolean);
  
  public static native void nativeSetPlayGapFrameCount(int paramInt);
  
  public static native void nativeSetPlayMode(int paramInt);
  
  public static native void nativeSetPlayStepFrameCount(int paramInt);
  
  public static native int nativeSetSlideMode(int paramInt, float paramFloat);
  
  public void closeHelper()
  {
    if (!this.isInited) {
      return;
    }
    try
    {
      nativeCloseHelper(this.mVfFilePtr, this.mAfFilePtr, this.mTmpBufferPtr);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    this.isInited = false;
    this.mVfFilePtr = 0L;
    this.mAfFilePtr = 0L;
    this.mTmpBufferPtr = 0L;
  }
  
  public int[] getBufferSize()
  {
    return new int[] { this.mVideoBufferSize, this.mAudioBufferSize };
  }
  
  public int getFirstFrameIndexArray(long paramLong, long[] paramArrayOfLong)
  {
    if (!this.isInited) {
      return -1;
    }
    int k = 0;
    int j = 0;
    i = k;
    try
    {
      Object localObject = this.mGetFrameBitmapLock;
      i = k;
      i = j;
      try
      {
        j = nativeGetFirstFrameIndexArray(this.mVfFilePtr, paramLong, paramArrayOfLong);
        i = j;
        return j;
      }
      finally {}
      return i;
    }
    catch (UnsatisfiedLinkError paramArrayOfLong)
    {
      paramArrayOfLong.printStackTrace();
    }
  }
  
  public int getNextAudioFrame(byte[] paramArrayOfByte)
  {
    if (!this.isInited) {
      return -1;
    }
    return nativeGetNextAudioFrame(paramArrayOfByte, paramArrayOfByte.length, this.mAfFilePtr);
  }
  
  public int getNextVideoFrame(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, boolean paramBoolean)
  {
    if (!this.isInited) {
      return -1;
    }
    try
    {
      int i = nativeGetNextVideoFrameCache(this.mVfFilePtr, paramByteBuffer1, paramByteBuffer2, paramByteBuffer3, paramBoolean);
      return i;
    }
    catch (UnsatisfiedLinkError paramByteBuffer1)
    {
      paramByteBuffer1.printStackTrace();
    }
    return 0;
  }
  
  public int getNextVideoFrame(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    if ((this.isInited) && (paramArrayOfLong.length >= 1)) {
      return nativeGetNextVideoFrame(paramArrayOfByte, paramArrayOfByte.length, this.mVfFilePtr, paramArrayOfLong, this.mTmpBufferPtr, paramInt);
    }
    return -1;
  }
  
  public int getNextVideoFrameBitmap(Bitmap paramBitmap)
  {
    if (!this.isInited) {
      return -1;
    }
    int k = 0;
    int j = 0;
    i = k;
    try
    {
      Object localObject = this.mGetFrameBitmapLock;
      i = k;
      i = j;
      try
      {
        j = nativeGetNextVideoFrameBitmap(this.mVfFilePtr, paramBitmap, this.mTmpBufferPtr);
        i = j;
        return j;
      }
      finally {}
      return i;
    }
    catch (UnsatisfiedLinkError paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public int[] getSourceVideoParam()
  {
    return new int[] { this.mDestVideoWidth, this.mDestVideoHeight };
  }
  
  public int getVideoFrameBitmap(Bitmap paramBitmap, long paramLong)
  {
    if (!this.isInited) {
      return -1;
    }
    int k = 0;
    int j = 0;
    i = k;
    try
    {
      Object localObject = this.mGetFrameBitmapLock;
      i = k;
      i = j;
      try
      {
        j = nativeGetVideoFrameBitmap(this.mVfFilePtr, paramBitmap, this.mTmpBufferPtr, paramLong);
        i = j;
        return j;
      }
      finally {}
      return i;
    }
    catch (UnsatisfiedLinkError paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public int getVideoFrameByIndex(Bitmap paramBitmap, int paramInt)
  {
    if (!this.isInited) {
      return -1;
    }
    int k = 0;
    int j = 0;
    i = k;
    try
    {
      Object localObject = this.mGetFrameBitmapLock;
      i = k;
      i = j;
      try
      {
        paramInt = nativeGetVideoFrameBitMapByIndex(this.mVfFilePtr, paramBitmap, this.mTmpBufferPtr, paramInt);
        i = paramInt;
        return paramInt;
      }
      finally {}
      return i;
    }
    catch (UnsatisfiedLinkError paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public int initHelperParam()
  {
    long[] arrayOfLong = new long[3];
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[3];
    int[] arrayOfInt3 = new int[3];
    int i;
    try
    {
      i = nativeInitHelper(this.mVfPath, this.mAfPath, arrayOfLong, arrayOfInt1, arrayOfInt2, arrayOfInt3);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      i = -1;
    }
    if (i == 0)
    {
      this.mVfFilePtr = arrayOfLong[0];
      this.mAfFilePtr = arrayOfLong[1];
      this.mTmpBufferPtr = arrayOfLong[2];
      this.mVideoBufferSize = arrayOfInt1[0];
      this.mAudioBufferSize = 4000;
      this.mDestVideoWidth = arrayOfInt2[0];
      this.mDestVideoHeight = arrayOfInt2[1];
      this.mOrientationDegree = arrayOfInt2[2];
      this.mSampleRate = arrayOfInt3[0];
      if (arrayOfInt3[1] == 1) {
        this.mChannel = 2;
      } else {
        this.mChannel = 3;
      }
      if (arrayOfInt3[2] == 0) {
        this.mPCMFormat = 3;
      } else {
        this.mPCMFormat = 2;
      }
      this.isInited = true;
    }
    return i;
  }
  
  public native int nativeGetFirstFrameIndexArray(long paramLong1, long paramLong2, long[] paramArrayOfLong);
  
  public native int nativeGetVideoFrameBitmap(long paramLong1, Bitmap paramBitmap, long paramLong2, long paramLong3);
  
  public native int nativeSetCurrentVideoFrameRange(long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
  
  public int resetDataSource()
  {
    if (!this.isInited) {
      return -1;
    }
    try
    {
      int i = nativeResetSource(this.mVfFilePtr, this.mAfFilePtr);
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    return -1;
  }
  
  public int setCurrentVideoFrameRange(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (!this.isInited) {
      return -1;
    }
    try
    {
      int i = nativeSetCurrentVideoFrameRange(this.mVfFilePtr, paramBoolean, paramLong1, paramLong2, paramLong3, paramLong4);
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper
 * JD-Core Version:    0.7.0.1
 */