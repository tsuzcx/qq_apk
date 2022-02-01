package com.tencent.xweb.skia_canvas;

public class SkiaCanvasLogic
{
  private static boolean sInit = false;
  
  static void init()
  {
    if (!sInit)
    {
      sInit = true;
      XWebLibraryLoader.beforeLoad();
      XWebLibraryLoader.load("c++_shared");
      XWebLibraryLoader.load("mmskia");
      XWebLibraryLoader.load("canvas");
      XWebLibraryLoader.load("skia-canvas");
      XWebLibraryLoader.afetrLoad();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.SkiaCanvasLogic
 * JD-Core Version:    0.7.0.1
 */