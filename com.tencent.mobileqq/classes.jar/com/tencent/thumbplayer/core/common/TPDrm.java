package com.tencent.thumbplayer.core.common;

public final class TPDrm
{
  private static final String TAG = "TPDrm";
  private static boolean mIsLibLoaded;
  
  static
  {
    try
    {
      TPNativeLibraryLoader.loadLibIfNeeded(null);
      mIsLibLoaded = true;
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      TPNativeLog.printLog(4, localUnsupportedOperationException.getMessage());
      mIsLibLoaded = false;
    }
  }
  
  public static int[] getDRMCapabilities()
  {
    if (isLibLoaded()) {
      try
      {
        int[] arrayOfInt2 = native_getDRMCapabilities();
        int[] arrayOfInt1 = arrayOfInt2;
        if (arrayOfInt2 == null) {
          arrayOfInt1 = new int[0];
        }
        return arrayOfInt1;
      }
      catch (Throwable localThrowable)
      {
        TPNativeLog.printLog(4, localThrowable.toString());
        throw new TPNativeLibraryException("Failed to call native func.");
      }
    }
    throw new TPNativeLibraryException("Failed to load native library.");
  }
  
  private static boolean isLibLoaded()
  {
    return mIsLibLoaded;
  }
  
  static native int[] native_getDRMCapabilities();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPDrm
 * JD-Core Version:    0.7.0.1
 */