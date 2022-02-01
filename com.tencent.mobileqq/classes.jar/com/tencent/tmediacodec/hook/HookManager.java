package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import android.support.annotation.NonNull;
import com.tencent.tmediacodec.util.LogUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class HookManager
{
  private static final String TAG = "HookManager";
  private static boolean isSurfaceMethodHooked;
  private static final Map<String, SurfaceCallback> mHoldCallbackMap = new ConcurrentHashMap();
  
  public static void hookSurfaceCallback(@NonNull String paramString, @NonNull SurfaceCallback paramSurfaceCallback)
  {
    mHoldCallbackMap.put(paramString, paramSurfaceCallback);
    if (LogUtils.isLogEnable()) {
      LogUtils.d("HookManager", "after hookSurfaceCallback size:" + mHoldCallbackMap.size() + " mHoldCallbackMap:" + mHoldCallbackMap);
    }
    if (!isSurfaceMethodHooked)
    {
      isSurfaceMethodHooked = true;
      THookTextureView.setHookCallback(new HookManager.1());
    }
  }
  
  public static void realReleaseSurfaceTexture(@NonNull SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      LogUtils.w("HookManager", "realReleaseSurfaceTexture surfaceTexture:" + paramSurfaceTexture);
      unHookSurfaceCallback(paramSurfaceTexture.toString());
      paramSurfaceTexture.release();
      return;
    }
    catch (Throwable localThrowable)
    {
      LogUtils.w("HookManager", "realReleaseSurfaceTexture surfaceTexture:" + paramSurfaceTexture + " ignoreThrowable", localThrowable);
    }
  }
  
  public static void unHookSurfaceCallback(@NonNull String paramString)
  {
    mHoldCallbackMap.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.HookManager
 * JD-Core Version:    0.7.0.1
 */