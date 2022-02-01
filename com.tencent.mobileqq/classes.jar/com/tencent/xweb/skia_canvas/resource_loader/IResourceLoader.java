package com.tencent.xweb.skia_canvas.resource_loader;

public abstract interface IResourceLoader
{
  public abstract byte[] loadResource(String paramString1, String paramString2);
  
  public abstract void loadResourceAsync(String paramString1, String paramString2, IResourceLoader.ResourceLoadCallback paramResourceLoadCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.resource_loader.IResourceLoader
 * JD-Core Version:    0.7.0.1
 */