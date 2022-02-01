package com.tencent.mobileqq.wink.editor.clipping;

import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbAssetModel;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toThumbAssetModel", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbAssetModel;", "Lcom/tencent/videocut/model/ResourceModel;", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class ResourceModelExtensionKt
{
  @NotNull
  public static final ThumbAssetModel a(@NotNull ResourceModel paramResourceModel)
  {
    Intrinsics.checkParameterIsNotNull(paramResourceModel, "$this$toThumbAssetModel");
    String str = paramResourceModel.path;
    MediaType localMediaType = paramResourceModel.type;
    int i;
    if (localMediaType != null) {
      i = localMediaType.ordinal();
    } else {
      i = 0;
    }
    return new ThumbAssetModel(str, i, paramResourceModel.sourceDuration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.ResourceModelExtensionKt
 * JD-Core Version:    0.7.0.1
 */