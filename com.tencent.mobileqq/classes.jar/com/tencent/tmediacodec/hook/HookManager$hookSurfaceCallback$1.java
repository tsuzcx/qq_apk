package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tmediacodec/hook/HookManager$hookSurfaceCallback$1", "Lcom/tencent/tmediacodec/hook/THookTextureView$SurfaceTextureHookCallback;", "onSurfaceTextureDestroyedCalled", "", "surface", "Landroid/graphics/SurfaceTexture;", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class HookManager$hookSurfaceCallback$1
  implements THookTextureView.SurfaceTextureHookCallback
{
  public boolean onSurfaceTextureDestroyedCalled(@Nullable SurfaceTexture paramSurfaceTexture)
  {
    if (paramSurfaceTexture == null) {
      return true;
    }
    Object localObject1 = paramSurfaceTexture.toString();
    Object localObject2 = HookManager.access$getMHoldCallbackMap$p(HookManager.INSTANCE).keySet();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "mHoldCallbackMap.keys");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if (Intrinsics.areEqual(str, localObject1))
      {
        localObject1 = (SurfaceCallback)HookManager.access$getMHoldCallbackMap$p(HookManager.INSTANCE).get(str);
        if (localObject1 != null) {
          ((SurfaceCallback)localObject1).onDestroy(paramSurfaceTexture);
        }
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.HookManager.hookSurfaceCallback.1
 * JD-Core Version:    0.7.0.1
 */