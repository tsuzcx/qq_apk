package com.tencent.qcircle.weseevideo.model.utils;

import android.support.annotation.NonNull;
import com.tencent.qcircle.weishi.module.publisher.data.VolumeAutomaticEffect;

class MusicMaterialMataDataBeanUtils$StartInEffectFilter
  implements MusicMaterialMataDataBeanUtils.IFilter
{
  public boolean isMatch(@NonNull VolumeAutomaticEffect paramVolumeAutomaticEffect)
  {
    return paramVolumeAutomaticEffect.getStartOffset() == 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.utils.MusicMaterialMataDataBeanUtils.StartInEffectFilter
 * JD-Core Version:    0.7.0.1
 */