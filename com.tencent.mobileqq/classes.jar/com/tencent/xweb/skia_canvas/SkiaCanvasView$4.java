package com.tencent.xweb.skia_canvas;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;

class SkiaCanvasView$4
  implements Runnable
{
  SkiaCanvasView$4(SkiaCanvasView paramSkiaCanvasView, SurfaceTexture paramSurfaceTexture) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SkiaCanvasView swapSurface ");
    ((StringBuilder)localObject).append(this.this$0);
    Log.d("SkiaCanvasView", ((StringBuilder)localObject).toString());
    if (this.val$surfaceTexture != SkiaCanvasView.access$000(this.this$0))
    {
      SkiaCanvasView.access$002(this.this$0, this.val$surfaceTexture);
      SkiaCanvasView.access$102(this.this$0, new Surface(this.val$surfaceTexture));
      localObject = this.this$0;
      SkiaCanvasView.access$700((SkiaCanvasView)localObject, SkiaCanvasView.access$300((SkiaCanvasView)localObject), SkiaCanvasView.access$100(this.this$0));
      return;
    }
    Log.e("SkiaCanvasView", "SkiaCanvasView swapSurface use the same surface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.SkiaCanvasView.4
 * JD-Core Version:    0.7.0.1
 */