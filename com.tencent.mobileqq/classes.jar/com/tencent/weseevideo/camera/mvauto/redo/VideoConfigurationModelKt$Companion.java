package com.tencent.weseevideo.camera.mvauto.redo;

import com.tencent.weseevideo.model.resource.EditorPointF;
import com.tencent.weseevideo.model.resource.VideoConfigurationModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/camera/mvauto/redo/VideoConfigurationModelKt$Companion;", "", "()V", "from", "Lcom/tencent/weseevideo/camera/mvauto/redo/VideoConfigurationModelKt;", "it", "Lcom/tencent/weseevideo/model/resource/VideoConfigurationModel;", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class VideoConfigurationModelKt$Companion
{
  @NotNull
  public final VideoConfigurationModelKt from(@NotNull VideoConfigurationModel paramVideoConfigurationModel)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoConfigurationModel, "it");
    int i = paramVideoConfigurationModel.getContentMode();
    float f1 = paramVideoConfigurationModel.getFrameHeight();
    EditorPointF localEditorPointF = paramVideoConfigurationModel.getFrameOrigin();
    float f2 = paramVideoConfigurationModel.getFrameWidth();
    List localList = paramVideoConfigurationModel.getEffects();
    return new VideoConfigurationModelKt(i, localEditorPointF, f2, f1, paramVideoConfigurationModel.getMatrix(), localList, paramVideoConfigurationModel.getRotate());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.camera.mvauto.redo.VideoConfigurationModelKt.Companion
 * JD-Core Version:    0.7.0.1
 */