package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/hook/THookTextureView$SurfaceTextureHookCallback;", "", "onSurfaceTextureDestroyedCalled", "", "surface", "Landroid/graphics/SurfaceTexture;", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public abstract interface THookTextureView$SurfaceTextureHookCallback
{
  public abstract boolean onSurfaceTextureDestroyedCalled(@Nullable SurfaceTexture paramSurfaceTexture);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.THookTextureView.SurfaceTextureHookCallback
 * JD-Core Version:    0.7.0.1
 */