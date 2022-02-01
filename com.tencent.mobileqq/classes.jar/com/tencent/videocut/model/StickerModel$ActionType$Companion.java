package com.tencent.videocut.model;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/StickerModel$ActionType$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/StickerModel$ActionType;", "fromValue", "value", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class StickerModel$ActionType$Companion
{
  @JvmStatic
  @Nullable
  public final StickerModel.ActionType a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return null;
      }
      return StickerModel.ActionType.REPLACE_ALL;
    }
    return StickerModel.ActionType.NONE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.StickerModel.ActionType.Companion
 * JD-Core Version:    0.7.0.1
 */