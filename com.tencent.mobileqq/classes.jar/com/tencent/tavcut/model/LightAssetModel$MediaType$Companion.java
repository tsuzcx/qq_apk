package com.tencent.tavcut.model;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/LightAssetModel$MediaType$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/model/LightAssetModel$MediaType;", "fromValue", "value", "", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LightAssetModel$MediaType$Companion
{
  @JvmStatic
  @Nullable
  public final LightAssetModel.MediaType fromValue(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return null;
        }
        return LightAssetModel.MediaType.MULTI_MEDIA;
      }
      return LightAssetModel.MediaType.PHOTO_ONLY;
    }
    return LightAssetModel.MediaType.VIDEO_ONLY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.LightAssetModel.MediaType.Companion
 * JD-Core Version:    0.7.0.1
 */