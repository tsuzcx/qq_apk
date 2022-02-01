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
    if (LogUtils.isLogEnable())
    {
      paramString = new StringBuilder();
      paramString.append("after hookSurfaceCallback size:");
      paramString.append(mHoldCallbackMap.size());
      paramString.append(" mHoldCallbackMap:");
      paramString.append(mHoldCallbackMap);
      LogUtils.d("HookManager", paramString.toString());
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
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("realReleaseSurfaceTexture surfaceTexture:");
      localStringBuilder1.append(paramSurfaceTexture);
      LogUtils.w("HookManager", localStringBuilder1.toString());
      unHookSurfaceCallback(paramSurfaceTexture.toString());
      paramSurfaceTexture.release();
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("realReleaseSurfaceTexture surfaceTexture:");
      localStringBuilder2.append(paramSurfaceTexture);
      localStringBuilder2.append(" ignoreThrowable");
      LogUtils.w("HookManager", localStringBuilder2.toString(), localThrowable);
    }
  }
  
  public static void unHookSurfaceCallback(@NonNull String paramString)
  {
    mHoldCallbackMap.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.HookManager
 * JD-Core Version:    0.7.0.1
 */