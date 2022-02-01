package com.tencent.weseevideo.model.utils;

import com.tencent.weishi.module.publisher.data.VolumeAutomaticEffect;
import com.tencent.weishi.module.publisher.data.VolumeAutomaticEffect.Companion;
import com.tencent.weseevideo.model.data.MusicMaterialMetaDataBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MusicMaterialMataDataBeanUtils
{
  public static void clearMatchVolumeEffect(List<VolumeAutomaticEffect> paramList, MusicMaterialMataDataBeanUtils.IFilter paramIFilter)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return;
    }
    if (paramIFilter == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (paramIFilter.isMatch((VolumeAutomaticEffect)paramList.next())) {
        paramList.remove();
      }
    }
  }
  
  public static void clearSpecialEditEffect(MusicMaterialMetaDataBean paramMusicMaterialMetaDataBean)
  {
    if (paramMusicMaterialMetaDataBean == null) {
      return;
    }
    paramMusicMaterialMetaDataBean.startInTime = 0L;
    paramMusicMaterialMetaDataBean.endOutTime = 0L;
    paramMusicMaterialMetaDataBean.isEdit = false;
    paramMusicMaterialMetaDataBean.startPlayOffset = 0L;
    clearMatchVolumeEffect(paramMusicMaterialMetaDataBean.mVolumeAutomaticEffectList, new MusicMaterialMataDataBeanUtils.StartInEffectFilter(null));
    clearMatchVolumeEffect(paramMusicMaterialMetaDataBean.mVolumeAutomaticEffectList, new MusicMaterialMataDataBeanUtils.EndOutEffectFilter(null));
  }
  
  public static VolumeAutomaticEffect findMatchEffectFromBean(List<VolumeAutomaticEffect> paramList, MusicMaterialMataDataBeanUtils.IFilter paramIFilter)
  {
    if (paramIFilter == null) {
      return null;
    }
    if (CollectionUtils.isEmpty(paramList)) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VolumeAutomaticEffect localVolumeAutomaticEffect = (VolumeAutomaticEffect)paramList.next();
      if (paramIFilter.isMatch(localVolumeAutomaticEffect)) {
        return localVolumeAutomaticEffect;
      }
    }
    return null;
  }
  
  public static long getEndOutTimeFromBean(MusicMaterialMetaDataBean paramMusicMaterialMetaDataBean)
  {
    if (paramMusicMaterialMetaDataBean == null) {
      return 0L;
    }
    paramMusicMaterialMetaDataBean = findMatchEffectFromBean(paramMusicMaterialMetaDataBean.mVolumeAutomaticEffectList, new MusicMaterialMataDataBeanUtils.EndOutEffectFilter(null));
    if (paramMusicMaterialMetaDataBean == null) {
      return 0L;
    }
    return paramMusicMaterialMetaDataBean.getDuration();
  }
  
  public static long getStartInTimeFromBean(MusicMaterialMetaDataBean paramMusicMaterialMetaDataBean)
  {
    if (paramMusicMaterialMetaDataBean == null) {
      return 0L;
    }
    paramMusicMaterialMetaDataBean = findMatchEffectFromBean(paramMusicMaterialMetaDataBean.mVolumeAutomaticEffectList, new MusicMaterialMataDataBeanUtils.StartInEffectFilter(null));
    if (paramMusicMaterialMetaDataBean == null) {
      return 0L;
    }
    return paramMusicMaterialMetaDataBean.getDuration();
  }
  
  public static void setEndOutTime(MusicMaterialMetaDataBean paramMusicMaterialMetaDataBean, long paramLong)
  {
    if (paramMusicMaterialMetaDataBean == null) {
      return;
    }
    clearMatchVolumeEffect(paramMusicMaterialMetaDataBean.mVolumeAutomaticEffectList, new MusicMaterialMataDataBeanUtils.EndOutEffectFilter(null));
    VolumeAutomaticEffect localVolumeAutomaticEffect = VolumeAutomaticEffect.Companion.genEndOutVolumeAutomaticEffect(paramLong);
    if (paramMusicMaterialMetaDataBean.mVolumeAutomaticEffectList == null) {
      paramMusicMaterialMetaDataBean.mVolumeAutomaticEffectList = new ArrayList();
    }
    paramMusicMaterialMetaDataBean.mVolumeAutomaticEffectList.add(localVolumeAutomaticEffect);
  }
  
  public static void setStartInTime(MusicMaterialMetaDataBean paramMusicMaterialMetaDataBean, long paramLong)
  {
    if (paramMusicMaterialMetaDataBean == null) {
      return;
    }
    clearMatchVolumeEffect(paramMusicMaterialMetaDataBean.mVolumeAutomaticEffectList, new MusicMaterialMataDataBeanUtils.StartInEffectFilter(null));
    VolumeAutomaticEffect localVolumeAutomaticEffect = VolumeAutomaticEffect.Companion.genStartInVolumeAutomaticEffect(paramLong);
    if (paramMusicMaterialMetaDataBean.mVolumeAutomaticEffectList == null) {
      paramMusicMaterialMetaDataBean.mVolumeAutomaticEffectList = new ArrayList();
    }
    paramMusicMaterialMetaDataBean.mVolumeAutomaticEffectList.add(localVolumeAutomaticEffect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.utils.MusicMaterialMataDataBeanUtils
 * JD-Core Version:    0.7.0.1
 */