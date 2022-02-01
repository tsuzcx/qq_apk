package com.tencent.xweb.skia_canvas;

class SkiaCanvasView$2
  implements Runnable
{
  SkiaCanvasView$2(SkiaCanvasView paramSkiaCanvasView) {}
  
  public void run()
  {
    VSyncRenderer.getInstance().triggerNextVSync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.SkiaCanvasView.2
 * JD-Core Version:    0.7.0.1
 */