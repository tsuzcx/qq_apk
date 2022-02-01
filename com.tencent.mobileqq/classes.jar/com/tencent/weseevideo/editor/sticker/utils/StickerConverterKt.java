package com.tencent.weseevideo.editor.sticker.utils;

import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.editor.sticker.music.WSLyricSticker;
import com.tencent.weseevideo.model.effect.SubtitleModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"convert2TavSticker", "Lcom/tencent/tavsticker/model/TAVSticker;", "Lcom/tencent/weseevideo/model/effect/SubtitleModel;", "libtavcut_debug"}, k=2, mv={1, 1, 16})
public final class StickerConverterKt
{
  @Nullable
  public static final TAVSticker convert2TavSticker(@NotNull SubtitleModel paramSubtitleModel)
  {
    Intrinsics.checkParameterIsNotNull(paramSubtitleModel, "$this$convert2TavSticker");
    if (Intrinsics.areEqual(paramSubtitleModel.getEffectId(), "no_lyric_id")) {
      return null;
    }
    WSLyricSticker localWSLyricSticker = new WSLyricSticker();
    localWSLyricSticker.reloadFromSubtitleModel(paramSubtitleModel);
    return (TAVSticker)localWSLyricSticker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.utils.StickerConverterKt
 * JD-Core Version:    0.7.0.1
 */