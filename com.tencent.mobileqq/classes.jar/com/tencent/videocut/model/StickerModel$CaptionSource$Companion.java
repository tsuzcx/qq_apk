package com.tencent.videocut.model;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/StickerModel$CaptionSource$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/StickerModel$CaptionSource;", "fromValue", "value", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class StickerModel$CaptionSource$Companion
{
  @JvmStatic
  @Nullable
  public final StickerModel.CaptionSource a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return null;
          }
          return StickerModel.CaptionSource.SEPARATE;
        }
        return StickerModel.CaptionSource.RECORD;
      }
      return StickerModel.CaptionSource.MUSIC;
    }
    return StickerModel.CaptionSource.VIDEO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.StickerModel.CaptionSource.Companion
 * JD-Core Version:    0.7.0.1
 */