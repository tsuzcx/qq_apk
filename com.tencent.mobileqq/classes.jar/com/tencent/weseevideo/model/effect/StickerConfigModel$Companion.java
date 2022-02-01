package com.tencent.weseevideo.model.effect;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/effect/StickerConfigModel$Companion;", "", "()V", "fromJson", "Lcom/tencent/weseevideo/model/effect/StickerConfigModel;", "str", "", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class StickerConfigModel$Companion
{
  @Nullable
  public final StickerConfigModel fromJson(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "str");
    try
    {
      paramString = (StickerConfigModel)new Gson().fromJson(paramString, StickerConfigModel.class);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.StickerConfigModel.Companion
 * JD-Core Version:    0.7.0.1
 */