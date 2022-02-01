package com.tencent.thumbplayer.api.capability;

import com.tencent.thumbplayer.adapter.player.thumbplayer.TPDrmCapability;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapCodecType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapHdrType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapVideoDecoderType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.api.TPCommonEnum.TP_DRM_TYPE;
import com.tencent.thumbplayer.api.TPCommonEnum.TP_HDR_TYPE;
import com.tencent.thumbplayer.api.TPCommonEnum.TP_VIDEO_CODEC_TYPE;
import com.tencent.thumbplayer.api.TPCommonEnum.TP_VIDEO_DECODER_TYPE;
import com.tencent.thumbplayer.api.TPNativeException;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.core.common.TPCodecCapability.TPHdrSupportVersionRange;
import com.tencent.thumbplayer.core.common.TPCodecCapability.TPVCodecMaxCapability;
import com.tencent.thumbplayer.core.common.TPCodecCapability.TPVCodecPropertyRange;
import com.tencent.thumbplayer.core.common.TPNativeLibraryException;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import java.util.HashMap;

public class TPCapability
{
  public static boolean addDRMLevel1Blacklist(@TPCommonEnum.TP_DRM_TYPE int paramInt)
  {
    return TPThumbplayerCapabilityHelper.addDRMLevel1Blacklist(paramInt);
  }
  
  public static boolean addHDRBlackList(@TPCommonEnum.TP_HDR_TYPE int paramInt, TPHDRVersionRange paramTPHDRVersionRange)
  {
    paramTPHDRVersionRange = new TPCodecCapability.TPHdrSupportVersionRange(paramTPHDRVersionRange.upperboundSystemVersion, paramTPHDRVersionRange.lowerboundSystemVersion, paramTPHDRVersionRange.upperboundPatchVersion, paramTPHDRVersionRange.lowerboundPatchVersion);
    return TPThumbplayerCapabilityHelper.addHDRBlackList(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapHdrType.class, paramInt), paramTPHDRVersionRange);
  }
  
  public static boolean addHDRWhiteList(@TPCommonEnum.TP_HDR_TYPE int paramInt, TPHDRVersionRange paramTPHDRVersionRange)
  {
    paramTPHDRVersionRange = new TPCodecCapability.TPHdrSupportVersionRange(paramTPHDRVersionRange.upperboundSystemVersion, paramTPHDRVersionRange.lowerboundSystemVersion, paramTPHDRVersionRange.upperboundPatchVersion, paramTPHDRVersionRange.lowerboundPatchVersion);
    return TPThumbplayerCapabilityHelper.addHDRWhiteList(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapHdrType.class, paramInt), paramTPHDRVersionRange);
  }
  
  public static boolean addVCodecBlacklist(@TPCommonEnum.TP_VIDEO_DECODER_TYPE int paramInt1, @TPCommonEnum.TP_VIDEO_CODEC_TYPE int paramInt2, TPVCodecCapabilityForSet paramTPVCodecCapabilityForSet)
  {
    TPCodecCapability.TPVCodecPropertyRange localTPVCodecPropertyRange = new TPCodecCapability.TPVCodecPropertyRange();
    localTPVCodecPropertyRange.set(paramTPVCodecCapabilityForSet.getUpperboundWidth(), paramTPVCodecCapabilityForSet.getUpperboundHeight(), paramTPVCodecCapabilityForSet.getLowerboundWidth(), paramTPVCodecCapabilityForSet.getLowerboundHeight(), paramTPVCodecCapabilityForSet.getProfile(), paramTPVCodecCapabilityForSet.getLevel());
    try
    {
      boolean bool = TPThumbplayerCapabilityHelper.addVCodecBlacklist(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapVideoDecoderType.class, paramInt1), TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapCodecType.class, paramInt2), localTPVCodecPropertyRange);
      return bool;
    }
    catch (TPNativeLibraryException paramTPVCodecCapabilityForSet)
    {
      throw new TPNativeException(paramTPVCodecCapabilityForSet);
    }
  }
  
  public static boolean addVCodecWhitelist(@TPCommonEnum.TP_VIDEO_DECODER_TYPE int paramInt1, @TPCommonEnum.TP_VIDEO_CODEC_TYPE int paramInt2, TPVCodecCapabilityForSet paramTPVCodecCapabilityForSet)
  {
    TPCodecCapability.TPVCodecPropertyRange localTPVCodecPropertyRange = new TPCodecCapability.TPVCodecPropertyRange();
    localTPVCodecPropertyRange.set(paramTPVCodecCapabilityForSet.getUpperboundWidth(), paramTPVCodecCapabilityForSet.getUpperboundHeight(), paramTPVCodecCapabilityForSet.getLowerboundWidth(), paramTPVCodecCapabilityForSet.getLowerboundHeight(), paramTPVCodecCapabilityForSet.getProfile(), paramTPVCodecCapabilityForSet.getLevel());
    try
    {
      boolean bool = TPThumbplayerCapabilityHelper.addVCodecWhitelist(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapVideoDecoderType.class, paramInt1), TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapCodecType.class, paramInt2), localTPVCodecPropertyRange);
      return bool;
    }
    catch (TPNativeLibraryException paramTPVCodecCapabilityForSet)
    {
      throw new TPNativeException(paramTPVCodecCapabilityForSet);
    }
  }
  
  public static int[] getDRMCapabilities()
  {
    return TPDrmCapability.getDRMCapabilities();
  }
  
  public static TPVCodecCapabilityForGet getThumbPlayerVCodecMaxCapability(@TPCommonEnum.TP_VIDEO_CODEC_TYPE int paramInt)
  {
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return new TPVCodecCapabilityForGet(0, 0, 0, 30);
    }
    try
    {
      TPCodecCapability.TPVCodecMaxCapability localTPVCodecMaxCapability = TPThumbplayerCapabilityHelper.getVCodecMaxCapability(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapCodecType.class, paramInt));
      if (localTPVCodecMaxCapability == null) {
        return new TPVCodecCapabilityForGet(0, 0, 0, 30);
      }
      return new TPVCodecCapabilityForGet(localTPVCodecMaxCapability.maxLumaSamples, localTPVCodecMaxCapability.maxProfile, localTPVCodecMaxCapability.maxLevel, localTPVCodecMaxCapability.maxFramerateFormaxLumaSamples);
    }
    catch (TPNativeLibraryException localTPNativeLibraryException)
    {
      throw new TPNativeException(localTPNativeLibraryException);
    }
  }
  
  public static TPVCodecCapabilityForGet getThumbPlayerVCodecTypeMaxCapability(@TPCommonEnum.TP_VIDEO_CODEC_TYPE int paramInt1, @TPCommonEnum.TP_VIDEO_DECODER_TYPE int paramInt2)
  {
    if (!TPNativeLibraryLoader.isLibLoaded()) {
      return new TPVCodecCapabilityForGet(0, 0, 0, 30);
    }
    try
    {
      HashMap localHashMap = TPThumbplayerCapabilityHelper.getVCodecDecoderMaxCapabilityMap(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapVideoDecoderType.class, paramInt2));
      if ((localHashMap != null) && (!localHashMap.isEmpty()) && (localHashMap.get(Integer.valueOf(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapCodecType.class, paramInt1))) != null))
      {
        paramInt1 = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapCodecType.class, paramInt1);
        return new TPVCodecCapabilityForGet(((TPCodecCapability.TPVCodecMaxCapability)localHashMap.get(Integer.valueOf(paramInt1))).maxLumaSamples, ((TPCodecCapability.TPVCodecMaxCapability)localHashMap.get(Integer.valueOf(paramInt1))).maxProfile, ((TPCodecCapability.TPVCodecMaxCapability)localHashMap.get(Integer.valueOf(paramInt1))).maxLevel, ((TPCodecCapability.TPVCodecMaxCapability)localHashMap.get(Integer.valueOf(paramInt1))).maxFramerateFormaxLumaSamples);
      }
      return new TPVCodecCapabilityForGet(0, 0, 0, 30);
    }
    catch (TPNativeLibraryException localTPNativeLibraryException)
    {
      throw new TPNativeException(localTPNativeLibraryException);
    }
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
  
  public static boolean isDRMsupport(@TPCommonEnum.TP_DRM_TYPE int paramInt)
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
  
  public static boolean isHDRsupport(@TPCommonEnum.TP_HDR_TYPE int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return false;
    }
    return TPThumbplayerCapabilityHelper.isHDRsupport(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapHdrType.class, paramInt1), paramInt2, paramInt3);
  }
  
  public static boolean isVCodecCapabilityCanSupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return false;
    }
    try
    {
      boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilityCanSupport(paramInt1, paramInt2, paramInt3, 0, 0, paramInt6);
      return bool;
    }
    catch (TPNativeLibraryException localTPNativeLibraryException)
    {
      throw new TPNativeException(localTPNativeLibraryException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.capability.TPCapability
 * JD-Core Version:    0.7.0.1
 */