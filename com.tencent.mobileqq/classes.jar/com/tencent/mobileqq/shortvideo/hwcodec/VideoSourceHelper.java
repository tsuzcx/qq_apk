package com.tencent.mobileqq.shortvideo.hwcodec;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class VideoSourceHelper
{
  public static final int STATUS_ERROR = -1;
  public static final int STATUS_SUCCESS = 0;
  public static WeakReference<VideoSourceHelper> sCurrentRef = null;
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
      this.isInited = false;
      this.mVfFilePtr = 0L;
      this.mAfFilePtr = 0L;
      this.mTmpBufferPtr = 0L;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
  }
  
  public int[] getBufferSize()
  {
    return new int[] { this.mVideoBufferSize, this.mAudioBufferSize };
  }
  
  /* Error */
  public int getFirstFrameIndexArray(long paramLong, long[] arg3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:isInited	Z
    //   4: ifne +5 -> 9
    //   7: iconst_m1
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 42	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:mGetFrameBitmapLock	Ljava/lang/Object;
    //   13: astore 5
    //   15: aload 5
    //   17: monitorenter
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 92	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:mVfFilePtr	J
    //   23: lload_1
    //   24: aload_3
    //   25: invokevirtual 109	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:nativeGetFirstFrameIndexArray	(JJ[J)I
    //   28: istore 4
    //   30: aload 5
    //   32: monitorexit
    //   33: iload 4
    //   35: ireturn
    //   36: astore_3
    //   37: aload 5
    //   39: monitorexit
    //   40: aload_3
    //   41: athrow
    //   42: astore_3
    //   43: aload_3
    //   44: invokevirtual 101	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   47: iload 4
    //   49: ireturn
    //   50: astore_3
    //   51: iconst_0
    //   52: istore 4
    //   54: goto -11 -> 43
    //   57: astore_3
    //   58: iconst_0
    //   59: istore 4
    //   61: goto -24 -> 37
    //   64: astore_3
    //   65: goto -28 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	VideoSourceHelper
    //   0	68	1	paramLong	long
    //   28	32	4	i	int
    //   13	25	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	33	36	finally
    //   40	42	42	java/lang/UnsatisfiedLinkError
    //   9	18	50	java/lang/UnsatisfiedLinkError
    //   18	30	57	finally
    //   37	40	64	finally
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
    if ((!this.isInited) || (paramArrayOfLong.length < 1)) {
      return -1;
    }
    return nativeGetNextVideoFrame(paramArrayOfByte, paramArrayOfByte.length, this.mVfFilePtr, paramArrayOfLong, this.mTmpBufferPtr, paramInt);
  }
  
  /* Error */
  public int getNextVideoFrameBitmap(Bitmap arg1)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:isInited	Z
    //   4: ifne +5 -> 9
    //   7: iconst_m1
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 42	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:mGetFrameBitmapLock	Ljava/lang/Object;
    //   13: astore_3
    //   14: aload_3
    //   15: monitorenter
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 92	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:mVfFilePtr	J
    //   21: aload_1
    //   22: aload_0
    //   23: getfield 96	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:mTmpBufferPtr	J
    //   26: invokespecial 124	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:nativeGetNextVideoFrameBitmap	(JLandroid/graphics/Bitmap;J)I
    //   29: istore_2
    //   30: aload_3
    //   31: monitorexit
    //   32: iload_2
    //   33: ireturn
    //   34: astore_1
    //   35: aload_3
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 101	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   44: iload_2
    //   45: ireturn
    //   46: astore_1
    //   47: iconst_0
    //   48: istore_2
    //   49: goto -9 -> 40
    //   52: astore_1
    //   53: iconst_0
    //   54: istore_2
    //   55: goto -20 -> 35
    //   58: astore_1
    //   59: goto -24 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	VideoSourceHelper
    //   29	26	2	i	int
    //   13	23	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	32	34	finally
    //   37	39	39	java/lang/UnsatisfiedLinkError
    //   9	16	46	java/lang/UnsatisfiedLinkError
    //   16	30	52	finally
    //   35	37	58	finally
  }
  
  public int[] getSourceVideoParam()
  {
    return new int[] { this.mDestVideoWidth, this.mDestVideoHeight };
  }
  
  /* Error */
  public int getVideoFrameBitmap(Bitmap arg1, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:isInited	Z
    //   4: ifne +5 -> 9
    //   7: iconst_m1
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 42	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:mGetFrameBitmapLock	Ljava/lang/Object;
    //   13: astore 5
    //   15: aload 5
    //   17: monitorenter
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 92	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:mVfFilePtr	J
    //   23: aload_1
    //   24: aload_0
    //   25: getfield 96	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:mTmpBufferPtr	J
    //   28: lload_2
    //   29: invokevirtual 135	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:nativeGetVideoFrameBitmap	(JLandroid/graphics/Bitmap;JJ)I
    //   32: istore 4
    //   34: aload 5
    //   36: monitorexit
    //   37: iload 4
    //   39: ireturn
    //   40: astore_1
    //   41: aload 5
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    //   46: astore_1
    //   47: aload_1
    //   48: invokevirtual 101	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   51: iload 4
    //   53: ireturn
    //   54: astore_1
    //   55: iconst_0
    //   56: istore 4
    //   58: goto -11 -> 47
    //   61: astore_1
    //   62: iconst_0
    //   63: istore 4
    //   65: goto -24 -> 41
    //   68: astore_1
    //   69: goto -28 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	VideoSourceHelper
    //   0	72	2	paramLong	long
    //   32	32	4	i	int
    //   13	29	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   34	37	40	finally
    //   44	46	46	java/lang/UnsatisfiedLinkError
    //   9	18	54	java/lang/UnsatisfiedLinkError
    //   18	34	61	finally
    //   41	44	68	finally
  }
  
  /* Error */
  public int getVideoFrameByIndex(Bitmap arg1, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:isInited	Z
    //   4: ifne +5 -> 9
    //   7: iconst_m1
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 42	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:mGetFrameBitmapLock	Ljava/lang/Object;
    //   13: astore_3
    //   14: aload_3
    //   15: monitorenter
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 92	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:mVfFilePtr	J
    //   21: aload_1
    //   22: aload_0
    //   23: getfield 96	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:mTmpBufferPtr	J
    //   26: iload_2
    //   27: invokespecial 139	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:nativeGetVideoFrameBitMapByIndex	(JLandroid/graphics/Bitmap;JI)I
    //   30: istore_2
    //   31: aload_3
    //   32: monitorexit
    //   33: iload_2
    //   34: ireturn
    //   35: astore_1
    //   36: aload_3
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    //   40: astore_1
    //   41: aload_1
    //   42: invokevirtual 101	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   45: iload_2
    //   46: ireturn
    //   47: astore_1
    //   48: iconst_0
    //   49: istore_2
    //   50: goto -9 -> 41
    //   53: astore_1
    //   54: iconst_0
    //   55: istore_2
    //   56: goto -20 -> 36
    //   59: astore_1
    //   60: goto -24 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	VideoSourceHelper
    //   0	63	2	paramInt	int
    //   13	24	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   31	33	35	finally
    //   38	40	40	java/lang/UnsatisfiedLinkError
    //   9	16	47	java/lang/UnsatisfiedLinkError
    //   16	31	53	finally
    //   36	38	59	finally
  }
  
  public int initHelperParam()
  {
    long[] arrayOfLong = new long[3];
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[3];
    int[] arrayOfInt3 = new int[3];
    try
    {
      i = nativeInitHelper(this.mVfPath, this.mAfPath, arrayOfLong, arrayOfInt1, arrayOfInt2, arrayOfInt3);
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
        if (arrayOfInt3[1] == 1)
        {
          this.mChannel = 2;
          if (arrayOfInt3[2] != 0) {
            break label160;
          }
          this.mPCMFormat = 3;
          this.isInited = true;
        }
      }
      else
      {
        return i;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        int i = -1;
        continue;
        this.mChannel = 3;
        continue;
        label160:
        this.mPCMFormat = 2;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper
 * JD-Core Version:    0.7.0.1
 */