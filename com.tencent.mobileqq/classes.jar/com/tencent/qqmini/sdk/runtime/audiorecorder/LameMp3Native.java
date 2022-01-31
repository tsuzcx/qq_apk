package com.tencent.qqmini.sdk.runtime.audiorecorder;

import bhdy;
import com.tencent.qqmini.sdk.log.QMLog;

public class LameMp3Native
{
  public static volatile boolean a = bhdy.a().b();
  
  static
  {
    QMLog.e("[miniapp]-LameMp3Native", "mNativeLoaded : " + a);
    if (!a) {}
    try
    {
      a = bhdy.a().a();
      if (a) {}
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          System.loadLibrary("native_lame_mp3");
          a = true;
          QMLog.i("[miniapp]-LameMp3Native", "load so exception, load local libnative_lame_mp3.so success!");
          return;
        }
        catch (Throwable localThrowable2)
        {
          a = false;
          QMLog.i("[miniapp]-LameMp3Native", "load so exception, fail to load local libnative_lame_mp3.so:" + a, localThrowable2);
        }
        localThrowable1 = localThrowable1;
        QMLog.e("[miniapp]-LameMp3Native", "load so exception, fail to load network libnative_lame_mp3.so:" + a, localThrowable1);
      }
    }
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    if (a) {
      return flush(paramArrayOfByte);
    }
    return -99999;
  }
  
  public static int a(short[] paramArrayOfShort1, short[] paramArrayOfShort2, int paramInt, byte[] paramArrayOfByte)
  {
    if (a) {
      return encode(paramArrayOfShort1, paramArrayOfShort2, paramInt, paramArrayOfByte);
    }
    return -99999;
  }
  
  public static void a() {}
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (a) {
      init(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public static native void close();
  
  public static native int encode(short[] paramArrayOfShort1, short[] paramArrayOfShort2, int paramInt, byte[] paramArrayOfByte);
  
  public static native int flush(byte[] paramArrayOfByte);
  
  public static native void init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.audiorecorder.LameMp3Native
 * JD-Core Version:    0.7.0.1
 */