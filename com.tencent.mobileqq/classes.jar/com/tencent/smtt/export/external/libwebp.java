package com.tencent.smtt.export.external;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class libwebp
{
  private static final int BITMAP_ALPHA_8 = 1;
  private static final int BITMAP_ARGB_4444 = 3;
  private static final int BITMAP_ARGB_8888 = 4;
  private static final int BITMAP_RGB_565 = 2;
  private static final String LOGTAG = "[image]";
  private static boolean isMultiCore = false;
  private static libwebp mInstance;
  private static boolean mIsLoadLibSuccess = false;
  private int mBitmapType = 4;
  
  public static int checkIsHuaModel()
  {
    String str1 = Build.BRAND.trim().toLowerCase();
    String str2 = Build.MODEL.trim().toLowerCase();
    int i;
    if ((str1 != null) && (str1.length() > 0) && (str1.contains("huawei"))) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i;
    if (str2 != null)
    {
      j = i;
      if (str2.length() > 0)
      {
        j = i;
        if (str2.contains("huawei")) {
          j = 1;
        }
      }
    }
    return j;
  }
  
  private String getCPUinfo()
  {
    String str1 = "";
    String str2 = str1;
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/proc/cpuinfo" }).start().getInputStream();
      str2 = str1;
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        str2 = str1;
        if (localInputStream.read(arrayOfByte) == -1) {
          break;
        }
        str2 = str1;
        StringBuilder localStringBuilder = new StringBuilder();
        str2 = str1;
        localStringBuilder.append(str1);
        str2 = str1;
        localStringBuilder.append(new String(arrayOfByte));
        str2 = str1;
        str1 = localStringBuilder.toString();
      }
      str2 = str1;
      localInputStream.close();
      return str1;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return str2;
  }
  
  public static libwebp getInstance(Context paramContext)
  {
    if (mInstance == null)
    {
      loadWepLibraryIfNeed(paramContext);
      mInstance = new libwebp();
    }
    return mInstance;
  }
  
  private boolean isMultiCore()
  {
    return getCPUinfo().contains("processor");
  }
  
  public static void loadWepLibraryIfNeed(Context paramContext)
  {
    if (!mIsLoadLibSuccess) {}
    try
    {
      LibraryLoader.loadLibrary(paramContext, "webp_base");
      mIsLoadLibSuccess = true;
      return;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      label17:
      break label17;
    }
    Log.e("[image]", "Load WebP Library Error...: libwebp.java - loadWepLibraryIfNeed()");
  }
  
  public static void loadWepLibraryIfNeed(Context paramContext, String paramString)
  {
    if (!mIsLoadLibSuccess) {}
    try
    {
      paramContext = new StringBuilder();
      paramContext.append(paramString);
      paramContext.append(File.separator);
      paramContext.append("libwebp_base.so");
      System.load(paramContext.toString());
      mIsLoadLibSuccess = true;
      return;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      label47:
      break label47;
    }
    Log.e("[image]", "Load WebP Library Error...: libwebp.java - loadWepLibraryIfNeed()");
  }
  
  public int[] decodeBase(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (!mIsLoadLibSuccess)
    {
      Log.e("[image]", "Load WebP Library Error...");
      return null;
    }
    return nativeDecode(paramArrayOfByte, isMultiCore, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public int[] decodeBase_16bit(byte[] paramArrayOfByte, Bitmap.Config paramConfig)
  {
    if (!mIsLoadLibSuccess)
    {
      Log.e("[image]", "Load WebP Library Error...");
      return null;
    }
    if (libwebp.1.$SwitchMap$android$graphics$Bitmap$Config[paramConfig.ordinal()] != 1) {
      this.mBitmapType = 2;
    } else {
      this.mBitmapType = 3;
    }
    return nativeDecode_16bit(paramArrayOfByte, isMultiCore, this.mBitmapType);
  }
  
  public int[] decodeInto(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (!mIsLoadLibSuccess)
    {
      Log.e("[image]", "Load WebP Library Error...");
      return null;
    }
    return nativeDecodeInto(paramArrayOfByte, isMultiCore, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public int getInfo(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (!mIsLoadLibSuccess) {
      return 0;
    }
    return nativeGetInfo(paramArrayOfByte, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public int[] incDecode(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (!mIsLoadLibSuccess)
    {
      Log.e("[image]", "Load WebP Library Error...");
      return null;
    }
    return nativeIDecode(paramArrayOfByte, isMultiCore, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public native int[] nativeDecode(byte[] paramArrayOfByte, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public native int[] nativeDecodeInto(byte[] paramArrayOfByte, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public native int[] nativeDecode_16bit(byte[] paramArrayOfByte, boolean paramBoolean, int paramInt);
  
  public native int nativeGetInfo(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public native int[] nativeIDecode(byte[] paramArrayOfByte, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.export.external.libwebp
 * JD-Core Version:    0.7.0.1
 */