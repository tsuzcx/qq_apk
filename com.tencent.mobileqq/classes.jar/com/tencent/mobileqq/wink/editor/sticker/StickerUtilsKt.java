package com.tencent.mobileqq.wink.editor.sticker;

import com.tencent.mobileqq.wink.editor.model.PointF;
import com.tencent.videocut.model.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"calculateOriginPoint", "Lcom/tencent/mobileqq/wink/editor/model/PointF;", "renderSize", "Lcom/tencent/videocut/model/Size;", "playerContainerSize", "center2Anchor", "", "center", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class StickerUtilsKt
{
  @NotNull
  public static final PointF a(@NotNull Size paramSize1, @NotNull Size paramSize2)
  {
    Intrinsics.checkParameterIsNotNull(paramSize1, "renderSize");
    Intrinsics.checkParameterIsNotNull(paramSize2, "playerContainerSize");
    Integer localInteger = paramSize2.width;
    int m = 0;
    int i;
    if (localInteger != null) {
      i = localInteger.intValue();
    } else {
      i = 0;
    }
    localInteger = paramSize1.width;
    int j;
    if (localInteger != null) {
      j = localInteger.intValue();
    } else {
      j = 0;
    }
    paramSize2 = paramSize2.height;
    int k;
    if (paramSize2 != null) {
      k = paramSize2.intValue();
    } else {
      k = 0;
    }
    paramSize1 = paramSize1.height;
    if (paramSize1 != null) {
      m = paramSize1.intValue();
    }
    return new PointF((i - j) / 2, (k - m) / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.sticker.StickerUtilsKt
 * JD-Core Version:    0.7.0.1
 */