package com.tencent.weseevideo.camera.mvauto.redo;

import com.tencent.weseevideo.model.resource.VideoResourceModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/camera/mvauto/redo/VideoResourceModelKt$Companion;", "", "()V", "from", "Lcom/tencent/weseevideo/camera/mvauto/redo/VideoResourceModelKt;", "it", "Lcom/tencent/weseevideo/model/resource/VideoResourceModel;", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class VideoResourceModelKt$Companion
{
  @NotNull
  public final VideoResourceModelKt from(@NotNull VideoResourceModel paramVideoResourceModel)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoResourceModel, "it");
    String str = paramVideoResourceModel.getPath();
    Intrinsics.checkExpressionValueIsNotNull(str, "it.path");
    int i = paramVideoResourceModel.getType();
    long l1 = paramVideoResourceModel.getScaleDuration();
    long l2 = paramVideoResourceModel.getSourceTimeStart();
    long l3 = paramVideoResourceModel.getSourceTimeStartUs();
    long l4 = paramVideoResourceModel.getSourceTimeDuration();
    long l5 = paramVideoResourceModel.getSourceTimeDurationUs();
    long l6 = paramVideoResourceModel.getSelectTimeStart();
    long l7 = paramVideoResourceModel.getSelectTimeStartUs();
    return new VideoResourceModelKt(str, i, l1, l2, l4, l3, l5, l6, paramVideoResourceModel.getSelectTimeDuration(), l7, paramVideoResourceModel.getSelectTimeDurationUs(), paramVideoResourceModel.getCutTimeStart(), paramVideoResourceModel.getCutTimeDuration(), paramVideoResourceModel.getWidth(), paramVideoResourceModel.getHeight(), paramVideoResourceModel.getRotate());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt.Companion
 * JD-Core Version:    0.7.0.1
 */