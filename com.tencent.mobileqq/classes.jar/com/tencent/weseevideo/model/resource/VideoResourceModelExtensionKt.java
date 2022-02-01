package com.tencent.weseevideo.model.resource;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"value", "", "speed", "Lcom/tencent/weseevideo/model/resource/VideoResourceModel;", "getSpeed", "(Lcom/tencent/weseevideo/model/resource/VideoResourceModel;)F", "setSpeed", "(Lcom/tencent/weseevideo/model/resource/VideoResourceModel;F)V", "libtavcut_debug"}, k=2, mv={1, 1, 16})
public final class VideoResourceModelExtensionKt
{
  public static final float getSpeed(@NotNull VideoResourceModel paramVideoResourceModel)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoResourceModel, "$this$speed");
    if (paramVideoResourceModel.getScaleDuration() == 0L) {
      return 1.0F;
    }
    return (float)paramVideoResourceModel.getSelectTimeDuration() / (float)paramVideoResourceModel.getScaleDuration();
  }
  
  public static final void setSpeed(@NotNull VideoResourceModel paramVideoResourceModel, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoResourceModel, "$this$speed");
    paramVideoResourceModel.setScaleDuration(((float)paramVideoResourceModel.getSelectTimeDuration() / paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.resource.VideoResourceModelExtensionKt
 * JD-Core Version:    0.7.0.1
 */