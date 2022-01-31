package com.tencent.tmediacodec.hook;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/hook/THookTextureView$Companion;", "", "()V", "hookCallback", "Lcom/tencent/tmediacodec/hook/THookTextureView$SurfaceTextureHookCallback;", "getHookCallback", "()Lcom/tencent/tmediacodec/hook/THookTextureView$SurfaceTextureHookCallback;", "setHookCallback", "(Lcom/tencent/tmediacodec/hook/THookTextureView$SurfaceTextureHookCallback;)V", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class THookTextureView$Companion
{
  @Nullable
  public final THookTextureView.SurfaceTextureHookCallback getHookCallback()
  {
    return THookTextureView.access$getHookCallback$cp();
  }
  
  public final void setHookCallback(@Nullable THookTextureView.SurfaceTextureHookCallback paramSurfaceTextureHookCallback)
  {
    THookTextureView.access$setHookCallback$cp(paramSurfaceTextureHookCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.THookTextureView.Companion
 * JD-Core Version:    0.7.0.1
 */