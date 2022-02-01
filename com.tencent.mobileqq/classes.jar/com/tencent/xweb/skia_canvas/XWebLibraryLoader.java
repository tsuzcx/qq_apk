package com.tencent.xweb.skia_canvas;

public class XWebLibraryLoader
{
  private static IXWebLibraryLoader DEFAULT = new XWebLibraryLoader.1();
  private static IXWebLibraryLoader sXWebLibraryLoader = DEFAULT;
  
  public static void afetrLoad()
  {
    sXWebLibraryLoader.afterLoad();
  }
  
  public static void beforeLoad()
  {
    sXWebLibraryLoader.beforeLoad();
  }
  
  public static void initXWebLibraryLoader(IXWebLibraryLoader paramIXWebLibraryLoader)
  {
    sXWebLibraryLoader = paramIXWebLibraryLoader;
  }
  
  public static boolean load(String paramString)
  {
    return sXWebLibraryLoader.load(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.XWebLibraryLoader
 * JD-Core Version:    0.7.0.1
 */