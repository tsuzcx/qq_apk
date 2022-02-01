package com.tencent.xweb.skia_canvas.resource_loader;

import androidx.annotation.NonNull;

class ResourceLoaderJNI
{
  private static final String TAG = "ResourceLoaderJNI";
  
  @NonNull
  static byte[] loadResource(String paramString1, String paramString2)
  {
    if (SkiaCanvasResourceLoader.hasDelegateSet()) {
      return SkiaCanvasResourceLoader.getDelegateWrapperForCurrentThread().loadResource(paramString1, paramString2);
    }
    return new byte[0];
  }
  
  static void loadResourceAsync(int paramInt, String paramString1, String paramString2)
  {
    if (SkiaCanvasResourceLoader.hasDelegateSet()) {
      SkiaCanvasResourceLoader.getDelegateWrapperForCurrentThread().loadResourceAsync(paramInt, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.resource_loader.ResourceLoaderJNI
 * JD-Core Version:    0.7.0.1
 */