package com.tencent.nativecrash;

import androidx.annotation.Keep;
import java.nio.charset.Charset;

public final class NativeCrash
{
  public static final int DEFAULT_FULL_FLAGS = -1;
  public static final int DEFAULT_SHORT_FLAGS = 1867;
  public static final int DUMP_ABORT_MESSAGE = 1024;
  public static final int DUMP_FILE_DESCRIPTORS = 2048;
  public static final int DUMP_JAVA_STACK = 64;
  public static final int DUMP_MAPPINGS = 32;
  public static final int DUMP_OTHER_THREADS = 128;
  public static final int DUMP_PRESET_CUSTOM = 256;
  public static final int DUMP_PROCESS = 1;
  public static final int DUMP_REALTIME_CUSTOM = 512;
  public static final int DUMP_REGISTER = 4;
  public static final int DUMP_SIGNAL = 2;
  public static final int DUMP_STACK = 8;
  public static final int DUMP_STACK_MEMORY = 16;
  private static final Charset UTF8 = Charset.forName("UTF-8");
  private static NativeCrash.a mANRCallback;
  private static NativeCrash.c mCrashCallback;
  
  public static NativeCrash.a anrCallback()
  {
    return mANRCallback;
  }
  
  public static NativeCrash.a anrCallback(NativeCrash.a parama)
  {
    NativeCrash.a locala = mANRCallback;
    mANRCallback = parama;
    return locala;
  }
  
  public static NativeCrash.c crashCallback()
  {
    return mCrashCallback;
  }
  
  public static NativeCrash.c crashCallback(NativeCrash.c paramc)
  {
    NativeCrash.c localc = mCrashCallback;
    mCrashCallback = paramc;
    return localc;
  }
  
  public static void customInfo(String paramString)
  {
    if (paramString == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (!paramString.endsWith("\n"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("");
      paramString = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append('\000');
      paramString = localStringBuilder.toString();
    }
    nativeCustomInfo(paramString.getBytes(UTF8));
  }
  
  public static void init(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!InitializationProbe.libLoaded) {
      System.loadLibrary("wechatcrash");
    }
    nativeInit(paramString, paramInt1, paramInt2, paramBoolean);
  }
  
  private static native void nativeCustomInfo(byte[] paramArrayOfByte);
  
  private static native void nativeInit(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  private static native void nativeResetCustomInfo();
  
  @Keep
  private static boolean onANRDumped(int paramInt, String paramString)
  {
    return new NativeCrash.b(true, paramInt, null, paramString).a();
  }
  
  @Keep
  private static boolean onCrashDumped(int paramInt, String paramString1, String paramString2)
  {
    return new NativeCrash.b(false, paramInt, paramString1, paramString2).a();
  }
  
  public static void resetCustomInfo() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.nativecrash.NativeCrash
 * JD-Core Version:    0.7.0.1
 */