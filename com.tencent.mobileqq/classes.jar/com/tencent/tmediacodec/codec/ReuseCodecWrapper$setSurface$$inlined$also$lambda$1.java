package com.tencent.tmediacodec.codec;

import android.graphics.SurfaceTexture;
import com.tencent.tmediacodec.hook.SurfaceCallback;
import com.tencent.tmediacodec.util.LogUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tmediacodec/codec/ReuseCodecWrapper$setSurface$1$1", "Lcom/tencent/tmediacodec/hook/SurfaceCallback;", "onDestroy", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class ReuseCodecWrapper$setSurface$$inlined$also$lambda$1
  implements SurfaceCallback
{
  ReuseCodecWrapper$setSurface$$inlined$also$lambda$1(ReuseCodecWrapper paramReuseCodecWrapper) {}
  
  public void onDestroy(@NotNull SurfaceTexture paramSurfaceTexture)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceTexture, "surfaceTexture");
    if (Intrinsics.areEqual(ReuseCodecWrapper.access$getMSurfaceTextureName$p(this.this$0), paramSurfaceTexture.toString()))
    {
      ReuseCodecWrapper.access$getMStoreToRelease$p(this.this$0).add(paramSurfaceTexture);
      LogUtils.w$default(LogUtils.INSTANCE, "ReuseCodecWrapper", "surfaceDestroyed ... surfaceTexture:" + paramSurfaceTexture + " mStoreToRelease.size:" + ReuseCodecWrapper.access$getMStoreToRelease$p(this.this$0).size(), null, 4, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.ReuseCodecWrapper.setSurface..inlined.also.lambda.1
 * JD-Core Version:    0.7.0.1
 */