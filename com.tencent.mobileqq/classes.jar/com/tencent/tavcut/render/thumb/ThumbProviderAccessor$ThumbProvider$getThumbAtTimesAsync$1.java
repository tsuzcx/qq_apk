package com.tencent.tavcut.render.thumb;

import android.graphics.Bitmap;
import com.tencent.tav.core.AssetImageGenerator.AssetImageGeneratorResult;
import com.tencent.tav.core.AssetImageGenerator.ImageGeneratorListener;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TimeUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/tav/coremedia/CMTime;", "bitmap", "Landroid/graphics/Bitmap;", "actualTime", "<anonymous parameter 3>", "Lcom/tencent/tav/core/AssetImageGenerator$AssetImageGeneratorResult;", "onCompletion"}, k=3, mv={1, 1, 16})
final class ThumbProviderAccessor$ThumbProvider$getThumbAtTimesAsync$1
  implements AssetImageGenerator.ImageGeneratorListener
{
  public final void onCompletion(@NotNull CMTime paramCMTime1, @Nullable Bitmap paramBitmap, @Nullable CMTime paramCMTime2, @NotNull AssetImageGenerator.AssetImageGeneratorResult paramAssetImageGeneratorResult)
  {
    Intrinsics.checkParameterIsNotNull(paramCMTime1, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(paramAssetImageGeneratorResult, "<anonymous parameter 3>");
    paramCMTime1 = this.a;
    long l;
    if (paramCMTime2 != null) {
      l = paramCMTime2.getTimeUs();
    } else {
      l = 0L;
    }
    paramCMTime1.invoke(paramBitmap, Long.valueOf(TimeUtil.us2Milli(l)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.thumb.ThumbProviderAccessor.ThumbProvider.getThumbAtTimesAsync.1
 * JD-Core Version:    0.7.0.1
 */