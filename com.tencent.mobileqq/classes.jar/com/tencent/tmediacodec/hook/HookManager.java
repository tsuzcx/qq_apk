package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import com.tencent.tmediacodec.util.LogUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/hook/HookManager;", "", "()V", "TAG", "", "isSurfaceMethodHooked", "", "mHoldCallbackMap", "Ljava/util/HashMap;", "Lcom/tencent/tmediacodec/hook/SurfaceCallback;", "Lkotlin/collections/HashMap;", "hookSurfaceCallback", "", "name", "callback", "realReleaseSurfaceTexture", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "unHookSurfaceCallback", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class HookManager
{
  public static final HookManager INSTANCE = new HookManager();
  private static final String TAG = "HookManager";
  private static boolean isSurfaceMethodHooked;
  private static final HashMap<String, SurfaceCallback> mHoldCallbackMap = new HashMap();
  
  public final void hookSurfaceCallback(@NotNull String paramString, @NotNull SurfaceCallback paramSurfaceCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramSurfaceCallback, "callback");
    ((Map)mHoldCallbackMap).put(paramString, paramSurfaceCallback);
    LogUtils.INSTANCE.d(TAG, "after hookSurfaceCallback mHoldCallbackMap:" + mHoldCallbackMap);
    if (isSurfaceMethodHooked) {
      return;
    }
    isSurfaceMethodHooked = true;
    THookTextureView.Companion.setHookCallback((THookTextureView.SurfaceTextureHookCallback)new HookManager.hookSurfaceCallback.1());
  }
  
  public final void realReleaseSurfaceTexture(@NotNull SurfaceTexture paramSurfaceTexture)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceTexture, "surfaceTexture");
    try
    {
      LogUtils.w$default(LogUtils.INSTANCE, "ReuseCodecWrapper", "realReleaseSurfaceTexture surfaceTexture:" + paramSurfaceTexture, null, 4, null);
      unHookSurfaceCallback(paramSurfaceTexture.toString());
      paramSurfaceTexture.release();
      return;
    }
    catch (Throwable localThrowable)
    {
      LogUtils.INSTANCE.w(TAG, "realReleaseSurfaceTexture surfaceTexture:" + paramSurfaceTexture + " ignoreThrowable", localThrowable);
    }
  }
  
  public final void unHookSurfaceCallback(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    mHoldCallbackMap.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.HookManager
 * JD-Core Version:    0.7.0.1
 */