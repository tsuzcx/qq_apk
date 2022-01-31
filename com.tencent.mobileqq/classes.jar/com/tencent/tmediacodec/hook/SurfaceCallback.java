package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/hook/SurfaceCallback;", "", "onDestroy", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public abstract interface SurfaceCallback
{
  public abstract void onDestroy(@NotNull SurfaceTexture paramSurfaceTexture);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.SurfaceCallback
 * JD-Core Version:    0.7.0.1
 */