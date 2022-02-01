package com.tencent.weishi.module.publisher.data;

import com.tencent.autotemplate.model.TAVVolumeAutomaticEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weishi/module/publisher/data/VolumeAutomaticEffect$Companion;", "", "()V", "TAG", "", "from", "Lcom/tencent/weishi/module/publisher/data/VolumeAutomaticEffect;", "it", "Lcom/tencent/autotemplate/model/TAVVolumeAutomaticEffect;", "genEndOutVolumeAutomaticEffect", "duration", "", "genStartInVolumeAutomaticEffect", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class VolumeAutomaticEffect$Companion
{
  @NotNull
  public final VolumeAutomaticEffect from(@NotNull TAVVolumeAutomaticEffect paramTAVVolumeAutomaticEffect)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVVolumeAutomaticEffect, "it");
    return new VolumeAutomaticEffect(paramTAVVolumeAutomaticEffect.getStartOffset(), paramTAVVolumeAutomaticEffect.getEndOffset(), paramTAVVolumeAutomaticEffect.getDuration(), new VolumeRange(paramTAVVolumeAutomaticEffect.getStartVolume(), paramTAVVolumeAutomaticEffect.getEndVolume()));
  }
  
  @NotNull
  public final VolumeAutomaticEffect genEndOutVolumeAutomaticEffect(long paramLong)
  {
    return new VolumeAutomaticEffect(-1L, 0L, paramLong, new VolumeRange(1.0F, 0.0F));
  }
  
  @NotNull
  public final VolumeAutomaticEffect genStartInVolumeAutomaticEffect(long paramLong)
  {
    return new VolumeAutomaticEffect(0L, -1L, paramLong, new VolumeRange(0.0F, 1.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weishi.module.publisher.data.VolumeAutomaticEffect.Companion
 * JD-Core Version:    0.7.0.1
 */