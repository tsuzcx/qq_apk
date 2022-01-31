package com.tencent.mobileqq.mini.audiorecorder;

import aues;
import com.tencent.qphone.base.util.QLog;

public class LameMp3Native
{
  public static final int ERR_NATIVE_LOAD = -99999;
  public static volatile boolean mNativeLoaded = aues.a().c();
  
  static
  {
    QLog.e("[miniapp]-LameMp3Native", 1, "mNativeLoaded : " + mNativeLoaded);
    if (!mNativeLoaded) {}
    try
    {
      mNativeLoaded = aues.a().b();
      if (mNativeLoaded) {}
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          System.loadLibrary("native_lame_mp3");
          mNativeLoaded = true;
          QLog.i("[miniapp]-LameMp3Native", 1, "load so exception, load local libnative_lame_mp3.so success!");
          return;
        }
        catch (Throwable localThrowable2)
        {
          mNativeLoaded = false;
          QLog.i("[miniapp]-LameMp3Native", 1, "load so exception, fail to load local libnative_lame_mp3.so:" + mNativeLoaded, localThrowable2);
        }
        localThrowable1 = localThrowable1;
        QLog.e("[miniapp]-LameMp3Native", 1, "load so exception, fail to load network libnative_lame_mp3.so:" + mNativeLoaded, localThrowable1);
      }
    }
  }
  
  public static native void close();
  
  public static native int encode(short[] paramArrayOfShort1, short[] paramArrayOfShort2, int paramInt, byte[] paramArrayOfByte);
  
  public static native int flush(byte[] paramArrayOfByte);
  
  public static void init(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    init(paramInt1, paramInt2, paramInt3, paramInt4, 7);
  }
  
  public static native void init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static void jniClose() {}
  
  public static int jniEncode(short[] paramArrayOfShort1, short[] paramArrayOfShort2, int paramInt, byte[] paramArrayOfByte)
  {
    if (mNativeLoaded) {
      return encode(paramArrayOfShort1, paramArrayOfShort2, paramInt, paramArrayOfByte);
    }
    return -99999;
  }
  
  public static int jniFlush(byte[] paramArrayOfByte)
  {
    if (mNativeLoaded) {
      return flush(paramArrayOfByte);
    }
    return -99999;
  }
  
  public static void jniInit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (mNativeLoaded) {
      init(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.audiorecorder.LameMp3Native
 * JD-Core Version:    0.7.0.1
 */