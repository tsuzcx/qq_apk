package com.tencent.thumbplayer.core.common;

import android.content.Context;
import java.util.HashMap;

public class TPPlayerDecoderCapability
{
  private static String TAG = "TPPlayerDecoderCapability";
  private long mNativeContext = 0L;
  
  private static native boolean _addVCodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange);
  
  private static native boolean _addVCodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange);
  
  private static native HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> _getDecoderMaxCapabilityMap(int paramInt);
  
  private static native boolean _isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  public static boolean addACodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPACodecCapability paramTPACodecCapability)
  {
    return true;
  }
  
  public static boolean addVCodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    try
    {
      boolean bool = _addVCodecBlacklist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
      return bool;
    }
    catch (Throwable paramTPVCodecPropertyRange)
    {
      TPNativeLog.printLog(4, paramTPVCodecPropertyRange.getMessage());
    }
    return false;
  }
  
  public static boolean addVCodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    try
    {
      boolean bool = _addVCodecWhitelist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
      return bool;
    }
    catch (Throwable paramTPVCodecPropertyRange)
    {
      TPNativeLog.printLog(4, paramTPVCodecPropertyRange.getMessage());
    }
    return false;
  }
  
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecDecoderMaxCapabilityMap(int paramInt)
  {
    try
    {
      HashMap localHashMap = _getDecoderMaxCapabilityMap(paramInt);
      return localHashMap;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return null;
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
  
  public static boolean isBlackListForHdr10(String paramString)
  {
    return TPCodecUtils.isBlackListForHdr10(paramString);
  }
  
  public static boolean isBlackListForHdr10Enhance(String paramString)
  {
    return TPCodecUtils.isBlackListForHdr10Enhance(paramString);
  }
  
  public static boolean isBlackListForVidHdr10Enhance(String paramString1, String paramString2)
  {
    return TPCodecUtils.isBlackListForVidHdr10Enhance(paramString1, paramString2);
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
  
  public static boolean isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (102 == paramInt1)
    {
      String str = "";
      switch (paramInt2)
      {
      }
      while (TPCodecUtils.isInMediaCodecWhiteList(str, paramInt3, paramInt4))
      {
        return true;
        str = "video/avc";
        continue;
        str = "video/hevc";
      }
      if (TPCodecUtils.isBlackListForHardwareDec(str)) {
        return false;
      }
    }
    try
    {
      boolean bool = _isVCodecCapabilitySupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return false;
  }
  
  public static boolean isWhiteListForHdr10(String paramString)
  {
    return TPCodecUtils.isWhiteListForHdr10(paramString);
  }
  
  public static boolean isWhiteListForHdr10Enhance(String paramString)
  {
    return TPCodecUtils.isWhiteListForHdr10Enhance(paramString);
  }
  
  public static boolean probeACodecMaxCapability()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPPlayerDecoderCapability
 * JD-Core Version:    0.7.0.1
 */