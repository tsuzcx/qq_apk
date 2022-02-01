package com.tencent.xweb.skia_canvas;

import android.graphics.SurfaceTexture;
import android.view.Surface;

class SkiaCanvasView$1
  implements Runnable
{
  SkiaCanvasView$1(SkiaCanvasView paramSkiaCanvasView, SurfaceTexture paramSurfaceTexture) {}
  
  public void run()
  {
    SkiaCanvasView.access$002(this.this$0, this.val$surfaceTexture);
    SkiaCanvasView.access$102(this.this$0, new Surface(this.val$surfaceTexture));
    SkiaCanvasView localSkiaCanvasView = this.this$0;
    SkiaCanvasView.access$400(localSkiaCanvasView, SkiaCanvasView.access$200(localSkiaCanvasView), SkiaCanvasView.access$300(this.this$0), SkiaCanvasView.access$100(this.this$0));
    SkiaCanvasView.access$502(this.this$0, true);
    VSyncRenderer.getInstance().addPresentCallback(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.SkiaCanvasView.1
 * JD-Core Version:    0.7.0.1
 */