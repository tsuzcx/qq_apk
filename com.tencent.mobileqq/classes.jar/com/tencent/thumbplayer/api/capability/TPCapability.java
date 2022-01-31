package com.tencent.thumbplayer.api.capability;

import com.tencent.thumbplayer.adapter.player.thumbplayer.TPDrmCapability;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.core.common.TPCodecCapability.TPVCodecMaxCapability;
import com.tencent.thumbplayer.core.common.TPCodecCapability.TPVCodecPropertyRange;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.utils.TPEnumUtils;
import java.util.HashMap;

public class TPCapability
{
  public static boolean addVCodecBlacklist(int paramInt1, int paramInt2, TPVCodecCapabilityForSet paramTPVCodecCapabilityForSet)
  {
    TPCodecCapability.TPVCodecPropertyRange localTPVCodecPropertyRange = new TPCodecCapability.TPVCodecPropertyRange();
    localTPVCodecPropertyRange.set(paramTPVCodecCapabilityForSet.getUpperboundWidth(), paramTPVCodecCapabilityForSet.getUpperboundHeight(), paramTPVCodecCapabilityForSet.getLowerboundWidth(), paramTPVCodecCapabilityForSet.getLowerboundHeight(), paramTPVCodecCapabilityForSet.getProfile(), paramTPVCodecCapabilityForSet.getLevel());
    return TPThumbplayerCapabilityHelper.addVCodecBlacklist(TPEnumUtils.convertDecoderType2Inner(paramInt1), TPEnumUtils.convertCodecType2Inner(paramInt2), localTPVCodecPropertyRange);
  }
  
  public static int[] getDRMCapabilities()
  {
    return TPDrmCapability.getDRMCapabilities();
  }
  
  public static TPVCodecCapabilityForGet getThumbPlayerVCodecMaxCapability(int paramInt)
  {
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return new TPVCodecCapabilityForGet(0, 0, 0);
    }
    TPCodecCapability.TPVCodecMaxCapability localTPVCodecMaxCapability = TPThumbplayerCapabilityHelper.getVCodecMaxCapability(TPEnumUtils.convertCodecType2Inner(paramInt));
    if (localTPVCodecMaxCapability == null) {
      return new TPVCodecCapabilityForGet(0, 0, 0);
    }
    return new TPVCodecCapabilityForGet(localTPVCodecMaxCapability.maxLumaSamples, localTPVCodecMaxCapability.maxProfile, localTPVCodecMaxCapability.maxLevel);
  }
  
  public static TPVCodecCapabilityForGet getThumbPlayerVCodecTypeMaxCapability(int paramInt1, int paramInt2)
  {
    if (!TPNativeLibraryLoader.isLibLoaded()) {
      return new TPVCodecCapabilityForGet(0, 0, 0);
    }
    HashMap localHashMap = TPThumbplayerCapabilityHelper.getVCodecDecoderMaxCapabilityMap(TPEnumUtils.convertDecType2Inner(paramInt2));
    if ((localHashMap == null) || (localHashMap.isEmpty()) || (localHashMap.get(Integer.valueOf(TPEnumUtils.convertCodecType2Inner(paramInt1))) == null)) {
      return new TPVCodecCapabilityForGet(0, 0, 0);
    }
    return new TPVCodecCapabilityForGet(((TPCodecCapability.TPVCodecMaxCapability)localHashMap.get(Integer.valueOf(TPEnumUtils.convertCodecType2Inner(paramInt1)))).maxLumaSamples, ((TPCodecCapability.TPVCodecMaxCapability)localHashMap.get(Integer.valueOf(TPEnumUtils.convertCodecType2Inner(paramInt1)))).maxProfile, ((TPCodecCapability.TPVCodecMaxCapability)localHashMap.get(Integer.valueOf(TPEnumUtils.convertCodecType2Inner(paramInt1)))).maxLevel);
  }
  
  public static boolean isDDPlusSupported()
  {
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return false;
    }
    return TPThumbplayerCapabilityHelper.isDDPlusSupported();
  }
  
  public static boolean isDDSupported()
  {
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return false;
    }
    return TPThumbplayerCapabilityHelper.isDDSupported();
  }
  
  public static boolean isDRMsupport(int paramInt)
  {
    return TPDrmCapability.isDRMSupport(paramInt);
  }
  
  public static boolean isDolbyDSSupported()
  {
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return false;
    }
    return TPThumbplayerCapabilityHelper.isDolbyDSSupported();
  }
  
  public static boolean isDolbyVisionSupported()
  {
    return false;
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return false;
    }
    return TPThumbplayerCapabilityHelper.isHDRsupport(TPEnumUtils.convertHDRType2Inner(paramInt1), paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.api.capability.TPCapability
 * JD-Core Version:    0.7.0.1
 */