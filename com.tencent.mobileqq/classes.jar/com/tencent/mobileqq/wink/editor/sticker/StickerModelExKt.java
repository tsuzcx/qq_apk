package com.tencent.mobileqq.wink.editor.sticker;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"copyAndUpdateCenter", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "curX", "", "curY", "copyAndUpdateRotation", "Rotation", "scaleFactor", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class StickerModelExKt
{
  @NotNull
  public static final WinkStickerModel a(@NotNull WinkStickerModel paramWinkStickerModel, float paramFloat1, float paramFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkStickerModel, "$this$copyAndUpdateRotation");
    return WinkStickerModel.copyAndUpdate$default(paramWinkStickerModel, null, null, 0L, 0L, 0, paramFloat2, paramFloat1, 0.0F, 0.0F, false, 0, 0, 0.0F, 0.0F, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, null, paramWinkStickerModel.getInitStickerScale(), paramWinkStickerModel.getDownScaleRecord(), null, null, null, null, null, null, -1610612833, 31, null);
  }
  
  @NotNull
  public static final WinkStickerModel b(@NotNull WinkStickerModel paramWinkStickerModel, float paramFloat1, float paramFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkStickerModel, "$this$copyAndUpdateCenter");
    return WinkStickerModel.copyAndUpdate$default(paramWinkStickerModel, null, null, 0L, 0L, 0, 0.0F, 0.0F, paramFloat1, paramFloat2, false, 0, 0, 0.0F, 0.0F, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, null, paramWinkStickerModel.getInitStickerScale(), paramWinkStickerModel.getDownScaleRecord(), null, null, null, null, null, null, -1610613121, 31, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.sticker.StickerModelExKt
 * JD-Core Version:    0.7.0.1
 */