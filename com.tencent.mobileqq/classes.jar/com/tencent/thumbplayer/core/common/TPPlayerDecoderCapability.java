package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.os.Build;
import java.util.HashMap;

public class TPPlayerDecoderCapability
{
  private static String TAG = "TPPlayerDecoderCapability";
  private static boolean mIsLibLoaded;
  private long mNativeContext = 0L;
  
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
  
  private static native boolean _addVCodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange);
  
  private static native boolean _addVCodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange);
  
  private static native HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> _getDecoderMaxCapabilityMap(int paramInt);
  
  private static native boolean _isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  public static boolean addACodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPACodecCapability paramTPACodecCapability)
  {
    return true;
  }
  
  public static boolean addDRMLevel1Blacklist(int paramInt)
  {
    return TPCodecUtils.addDRMLevel1Blacklist(paramInt);
  }
  
  public static boolean addHDRBlackList(int paramInt, TPCodecCapability.TPHdrSupportVersionRange paramTPHdrSupportVersionRange)
  {
    return TPCodecUtils.addHDRBlackList(paramInt, Build.MODEL, paramTPHdrSupportVersionRange);
  }
  
  public static boolean addHDRWhiteList(int paramInt, TPCodecCapability.TPHdrSupportVersionRange paramTPHdrSupportVersionRange)
  {
    return TPCodecUtils.addHDRWhiteList(paramInt, Build.MODEL, paramTPHdrSupportVersionRange);
  }
  
  public static boolean addVCodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    if (isLibLoaded()) {
      try
      {
        boolean bool = _addVCodecBlacklist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
        return bool;
      }
      catch (Throwable paramTPVCodecPropertyRange)
      {
        TPNativeLog.printLog(4, paramTPVCodecPropertyRange.getMessage());
        throw new TPNativeLibraryException("Failed to call _addVCodecBlacklist.");
      }
    }
    throw new TPNativeLibraryException("Failed to load native library.");
  }
  
  public static boolean addVCodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    if (isLibLoaded()) {
      try
      {
        boolean bool = _addVCodecWhitelist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
        return bool;
      }
      catch (Throwable paramTPVCodecPropertyRange)
      {
        TPNativeLog.printLog(4, paramTPVCodecPropertyRange.getMessage());
        throw new TPNativeLibraryException("Failed to call _addVCodecWhitelist.");
      }
    }
    throw new TPNativeLibraryException("Failed to load native library.");
  }
  
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecDecoderMaxCapabilityMap(int paramInt)
  {
    if (isLibLoaded()) {
      try
      {
        HashMap localHashMap = _getDecoderMaxCapabilityMap(paramInt);
        return localHashMap;
      }
      catch (Throwable localThrowable)
      {
        TPNativeLog.printLog(4, localThrowable.getMessage());
        throw new TPNativeLibraryException("Failed to call _getDecoderMaxCapabilityMap.");
      }
    }
    throw new TPNativeLibraryException("Failed to load native library.");
  }
  
  public static void init(Context paramContext, boolean paramBoolean)
  {
    try
    {
      TPCodecUtils.init(paramContext, paramBoolean);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static boolean isACodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return true;
  }
  
  public static boolean isDDPlusSupported()
  {
    return TPCodecUtils.isHwDDPlusSupported();
  }
  
  public static boolean isDolbyDSSupported()
  {
    return TPCodecUtils.isHwDolbyDSSupported();
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    return TPCodecUtils.isHDRsupport(paramInt1, paramInt2, paramInt3);
  }
  
  private static boolean isLibLoaded()
  {
    return mIsLibLoaded;
  }
  
  public static boolean isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (102 == paramInt1)
    {
      String str;
      if (paramInt2 != 26)
      {
        if (paramInt2 != 172) {
          str = "";
        } else {
          str = "video/hevc";
        }
      }
      else {
        str = "video/avc";
      }
      if (TPCodecUtils.isInMediaCodecWhiteList(str, paramInt3, paramInt4)) {
        return true;
      }
      if ((TPCodecUtils.isBlackListModel()) || (TPCodecUtils.isBlackListType(str))) {
        return false;
      }
    }
    if (isLibLoaded()) {
      try
      {
        boolean bool = _isVCodecCapabilitySupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
        return bool;
      }
      catch (Throwable localThrowable)
      {
        TPNativeLog.printLog(4, localThrowable.getMessage());
        throw new TPNativeLibraryException("Failed to call _isVCodecCapabilitySupport.");
      }
    }
    throw new TPNativeLibraryException("Failed to load native library.");
  }
  
  public static boolean probeACodecMaxCapability()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPPlayerDecoderCapability
 * JD-Core Version:    0.7.0.1
 */