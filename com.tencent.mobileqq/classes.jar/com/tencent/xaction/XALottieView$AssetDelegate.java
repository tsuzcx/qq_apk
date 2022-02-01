package com.tencent.xaction;

import android.graphics.Bitmap;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.xaction.api.IMemoryLruCache;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/XALottieView$AssetDelegate;", "Lcom/tencent/mobileqq/dinifly/ImageAssetDelegate;", "()V", "fetchBitmap", "Landroid/graphics/Bitmap;", "lottieImageAsset", "Lcom/tencent/mobileqq/dinifly/LottieImageAsset;", "XALottie_release"}, k=1, mv={1, 1, 16})
public final class XALottieView$AssetDelegate
  implements ImageAssetDelegate
{
  @Nullable
  public Bitmap fetchBitmap(@NotNull LottieImageAsset paramLottieImageAsset)
  {
    Intrinsics.checkParameterIsNotNull(paramLottieImageAsset, "lottieImageAsset");
    IMemoryLruCache localIMemoryLruCache = XAEngine.Companion.a();
    paramLottieImageAsset = paramLottieImageAsset.getKey();
    Intrinsics.checkExpressionValueIsNotNull(paramLottieImageAsset, "lottieImageAsset.key");
    return localIMemoryLruCache.a(paramLottieImageAsset);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.XALottieView.AssetDelegate
 * JD-Core Version:    0.7.0.1
 */