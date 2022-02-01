package com.tencent.weseevideo.model.utils;

import android.support.annotation.NonNull;
import com.tencent.weishi.module.publisher.data.VolumeAutomaticEffect;

class MusicMaterialMataDataBeanUtils$StartInEffectFilter
  implements MusicMaterialMataDataBeanUtils.IFilter
{
  public boolean isMatch(@NonNull VolumeAutomaticEffect paramVolumeAutomaticEffect)
  {
    return paramVolumeAutomaticEffect.getStartOffset() == 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.utils.MusicMaterialMataDataBeanUtils.StartInEffectFilter
 * JD-Core Version:    0.7.0.1
 */