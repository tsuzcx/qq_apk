package com.tencent.xweb.skia_canvas.resource_loader;

public class SkiaCanvasResourceLoader
{
  private static final String TAG = "SkiaCanvasResourceLoader";
  private static ThreadLocal<ResourceLoaderDelegateWrapper> sThreadLocalLoader = new ThreadLocal();
  
  static ResourceLoaderDelegateWrapper getDelegateWrapperForCurrentThread()
  {
    return (ResourceLoaderDelegateWrapper)sThreadLocalLoader.get();
  }
  
  public static boolean hasDelegateSet()
  {
    return sThreadLocalLoader.get() != null;
  }
  
  public static void setDelegate(IResourceLoader paramIResourceLoader)
  {
    sThreadLocalLoader.set(new ResourceLoaderDelegateWrapper(paramIResourceLoader));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.resource_loader.SkiaCanvasResourceLoader
 * JD-Core Version:    0.7.0.1
 */