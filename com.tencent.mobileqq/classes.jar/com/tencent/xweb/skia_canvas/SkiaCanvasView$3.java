package com.tencent.xweb.skia_canvas;

import android.util.Log;

class SkiaCanvasView$3
  implements Runnable
{
  SkiaCanvasView$3(SkiaCanvasView paramSkiaCanvasView) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SkiaCanvasView recycle ");
    ((StringBuilder)localObject).append(this.this$0);
    Log.d("SkiaCanvasView", ((StringBuilder)localObject).toString());
    localObject = this.this$0;
    SkiaCanvasView.access$600((SkiaCanvasView)localObject, SkiaCanvasView.access$300((SkiaCanvasView)localObject));
    VSyncRenderer.getInstance().removePresentCallback(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.SkiaCanvasView.3
 * JD-Core Version:    0.7.0.1
 */