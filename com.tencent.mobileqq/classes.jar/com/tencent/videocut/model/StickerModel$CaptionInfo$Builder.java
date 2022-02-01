package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/StickerModel$CaptionInfo$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/StickerModel$CaptionInfo;", "()V", "source", "Lcom/tencent/videocut/model/StickerModel$CaptionSource;", "build", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class StickerModel$CaptionInfo$Builder
  extends Message.Builder<StickerModel.CaptionInfo, Builder>
{
  @JvmField
  @Nullable
  public StickerModel.CaptionSource a;
  
  @NotNull
  public StickerModel.CaptionInfo a()
  {
    return new StickerModel.CaptionInfo(this.a, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.StickerModel.CaptionInfo.Builder
 * JD-Core Version:    0.7.0.1
 */