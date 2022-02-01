package com.tencent.thumbplayer.core.config;

import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;

public class TPPlayerCoreConfig
{
  private static boolean mIsLibLoaded = false;
  
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
      localUnsupportedOperationException.printStackTrace();
      mIsLibLoaded = false;
    }
  }
  
  private static native int _getVideoMediaCodecCoexistMaxCnt();
  
  private static native void _setVideoMediaCodecCoexistMaxCnt(int paramInt);
  
  public static int getVideoMediaCodecCoexistMaxCnt()
  {
    if (!mIsLibLoaded) {
      return -1;
    }
    return _getVideoMediaCodecCoexistMaxCnt();
  }
  
  public static void setVideoMediaCodecCoexistMaxCnt(int paramInt)
  {
    if (!mIsLibLoaded) {
      return;
    }
    _setVideoMediaCodecCoexistMaxCnt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.config.TPPlayerCoreConfig
 * JD-Core Version:    0.7.0.1
 */