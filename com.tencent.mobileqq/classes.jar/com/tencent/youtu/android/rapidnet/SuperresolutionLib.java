package com.tencent.youtu.android.rapidnet;

import android.graphics.Bitmap;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

public class SuperresolutionLib
{
  public static boolean sLoadSuccess = false;
  private static boolean sOpenClSoLoad = false;
  private long nativePtr;
  
  static
  {
    loadLibrary();
  }
  
  public SuperresolutionLib(String paramString1, String paramString2)
  {
    if (!sLoadSuccess) {
      return;
    }
    try
    {
      initWithProto(paramString1, paramString2);
      return;
    }
    catch (Throwable paramString1)
    {
      sLoadSuccess = false;
    }
  }
  
  private native boolean getGPUSupportOpencl();
  
  private native boolean initWithProto(String paramString1, String paramString2);
  
  private static void loadLibrary()
  {
    int i;
    if (!sLoadSuccess)
    {
      i = ImageManagerEnv.g().loadSuperResolutionLibrary();
      if (i != 1) {
        break label27;
      }
      sLoadSuccess = true;
      sOpenClSoLoad = true;
    }
    label27:
    while (i != 2) {
      return;
    }
    sLoadSuccess = true;
  }
  
  public native void destroy();
  
  public boolean isGPUSupportOpenCL()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (sLoadSuccess)
    {
      bool1 = bool2;
      if (!sOpenClSoLoad) {}
    }
    try
    {
      bool1 = getGPUSupportOpencl();
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      ImageManagerEnv.getLogger().w("SuperresolutionLib", new Object[] { "call isGPUSupportOpenCL failed:" + localThrowable.getMessage() });
    }
    return false;
  }
  
  public native Bitmap superResolution(Bitmap paramBitmap, float paramFloat1, float paramFloat2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.android.rapidnet.SuperresolutionLib
 * JD-Core Version:    0.7.0.1
 */