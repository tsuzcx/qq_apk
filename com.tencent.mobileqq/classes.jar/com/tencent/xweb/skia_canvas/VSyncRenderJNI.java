package com.tencent.xweb.skia_canvas;

class VSyncRenderJNI
{
  private static long addAnimationCallback(long paramLong)
  {
    VSyncRenderer localVSyncRenderer = VSyncRenderer.getInstance();
    if (localVSyncRenderer != null) {
      return localVSyncRenderer.addAnimationCallback(new VSyncRenderJNI.1(paramLong));
    }
    throw new IllegalStateException("VSyncRendererCallback is not init in current thread.");
  }
  
  private static native void nativeOnAnimation(long paramLong1, long paramLong2);
  
  private static void removeAnimationCallback(long paramLong)
  {
    VSyncRenderer localVSyncRenderer = VSyncRenderer.getInstance();
    if (localVSyncRenderer != null)
    {
      localVSyncRenderer.removeAnimationCallback(paramLong);
      return;
    }
    throw new IllegalStateException("VSyncRendererCallback is not init in current thread.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.VSyncRenderJNI
 * JD-Core Version:    0.7.0.1
 */