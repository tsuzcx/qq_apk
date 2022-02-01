package com.tencent.qcircle.weishi.module.publisher.data;

import com.tencent.autotemplate.model.TAVVolumeRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weishi/module/publisher/data/VolumeRange$Companion;", "", "()V", "from", "Lcom/tencent/qcircle/weishi/module/publisher/data/VolumeRange;", "it", "Lcom/tencent/autotemplate/model/TAVVolumeRange;", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class VolumeRange$Companion
{
  @NotNull
  public final VolumeRange from(@NotNull TAVVolumeRange paramTAVVolumeRange)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVVolumeRange, "it");
    return new VolumeRange(paramTAVVolumeRange.start, paramTAVVolumeRange.end);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weishi.module.publisher.data.VolumeRange.Companion
 * JD-Core Version:    0.7.0.1
 */