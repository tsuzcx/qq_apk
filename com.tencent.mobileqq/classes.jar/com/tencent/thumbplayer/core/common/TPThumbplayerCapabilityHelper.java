package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.os.Build.VERSION;
import java.util.HashMap;

public class TPThumbplayerCapabilityHelper
{
  public static boolean addVCodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    return TPPlayerDecoderCapability.addVCodecBlacklist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
  }
  
  public static boolean addVCodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    return TPPlayerDecoderCapability.addVCodecWhitelist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
  }
  
  public static int[] getDRMCapabilities()
  {
    return TPDrm.getDRMCapabilities();
  }
  
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecDecoderMaxCapabilityMap(int paramInt)
  {
    return TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(paramInt);
  }
  
  public static TPCodecCapability.TPVCodecMaxCapability getVCodecMaxCapability(int paramInt)
  {
    TPCodecCapability.TPVCodecMaxCapability localTPVCodecMaxCapability2 = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0);
    HashMap localHashMap1 = TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(TPDecoderType.TP_VIDEO_DECODER_MEDIACODEC);
    HashMap localHashMap2 = TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(TPDecoderType.TP_VIDEO_DECODER_FFMPEG);
    TPCodecCapability.TPVCodecMaxCapability localTPVCodecMaxCapability1;
    if ((localHashMap1 != null) && (localHashMap2 != null))
    {
      localTPVCodecMaxCapability1 = localTPVCodecMaxCapability2;
      if (localHashMap1.containsKey(Integer.valueOf(paramInt)))
      {
        localTPVCodecMaxCapability1 = localTPVCodecMaxCapability2;
        if (localHashMap2.containsKey(Integer.valueOf(paramInt)))
        {
          if (((TPCodecCapability.TPVCodecMaxCapability)localHashMap1.get(Integer.valueOf(paramInt))).maxLumaSamples < ((TPCodecCapability.TPVCodecMaxCapability)localHashMap2.get(Integer.valueOf(paramInt))).maxLumaSamples) {
            break label108;
          }
          localTPVCodecMaxCapability1 = (TPCodecCapability.TPVCodecMaxCapability)localHashMap1.get(Integer.valueOf(paramInt));
        }
      }
    }
    label108:
    do
    {
      do
      {
        do
        {
          return localTPVCodecMaxCapability1;
          return (TPCodecCapability.TPVCodecMaxCapability)localHashMap2.get(Integer.valueOf(paramInt));
          if (localHashMap1 == null) {
            break;
          }
          localTPVCodecMaxCapability1 = localTPVCodecMaxCapability2;
        } while (!localHashMap1.containsKey(Integer.valueOf(paramInt)));
        return (TPCodecCapability.TPVCodecMaxCapability)localHashMap1.get(Integer.valueOf(paramInt));
        localTPVCodecMaxCapability1 = localTPVCodecMaxCapability2;
      } while (localHashMap2 == null);
      localTPVCodecMaxCapability1 = localTPVCodecMaxCapability2;
    } while (!localHashMap2.containsKey(Integer.valueOf(paramInt)));
    return (TPCodecCapability.TPVCodecMaxCapability)localHashMap2.get(Integer.valueOf(paramInt));
  }
  
  public static void init(Context paramContext, boolean paramBoolean)
  {
    try
    {
      TPPlayerDecoderCapability.init(paramContext, paramBoolean);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static boolean isDDPlusSupported()
  {
    return TPPlayerDecoderCapability.isDDPlusSupported();
  }
  
  public static boolean isDDSupported()
  {
    return TPPlayerDecoderCapability.isDDPlusSupported();
  }
  
  public static boolean isDRMsupport(int paramInt)
  {
    int[] arrayOfInt = getDRMCapabilities();
    if (arrayOfInt.length == 0) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < arrayOfInt.length)
      {
        if (paramInt == arrayOfInt[i]) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean isDolbyDSSupported()
  {
    return TPPlayerDecoderCapability.isDolbyDSSupported();
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    return TPPlayerDecoderCapability.isHDRsupport(paramInt1, paramInt2, paramInt3);
  }
  
  public static boolean isSupportMediaCodecRotateInternal()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  public static boolean isSupportNativeMediaCodec()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  public static boolean isSupportSetOutputSurfaceApi()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  public static boolean isVCodecCapabilityCanSupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (isVCodecCapabilitySupport(TPDecoderType.TP_VIDEO_DECODER_FFMPEG, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5)) {
      return true;
    }
    return isVCodecCapabilitySupport(TPDecoderType.TP_VIDEO_DECODER_MEDIACODEC, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public static boolean isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return TPPlayerDecoderCapability.isVCodecCapabilitySupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper
 * JD-Core Version:    0.7.0.1
 */