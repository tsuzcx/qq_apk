package com.tencent.xweb.extension.video;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

class e$1
  implements SurfaceHolder.Callback
{
  e$1(e parame) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    Canvas localCanvas = paramSurfaceHolder.lockCanvas();
    localCanvas.drawColor(-16777216);
    paramSurfaceHolder.unlockCanvasAndPost(localCanvas);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    Canvas localCanvas = paramSurfaceHolder.lockCanvas();
    localCanvas.drawColor(-16777216);
    paramSurfaceHolder.unlockCanvasAndPost(localCanvas);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.extension.video.e.1
 * JD-Core Version:    0.7.0.1
 */