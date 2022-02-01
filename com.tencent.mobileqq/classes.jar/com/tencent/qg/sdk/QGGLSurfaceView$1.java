package com.tencent.qg.sdk;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class QGGLSurfaceView$1
  implements View.OnTouchListener
{
  QGGLSurfaceView$1(QGGLSurfaceView paramQGGLSurfaceView, float paramFloat1, float paramFloat2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = (int)(paramMotionEvent.getX() * this.val$xPosScaleRate);
    int j = (int)(paramMotionEvent.getY() * this.val$yPosScaleRate);
    int k = paramMotionEvent.getAction() & 0xFF;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2) {
          return true;
        }
        this.this$0.mRenderer.nativeTouch(paramMotionEvent.getAction(), i, j, paramMotionEvent.getPointerId(0));
        return true;
      }
      this.this$0.mRenderer.nativeTouch(paramMotionEvent.getAction(), i, j, paramMotionEvent.getPointerId(0));
      return true;
    }
    this.this$0.mRenderer.nativeTouch(paramMotionEvent.getAction(), i, j, paramMotionEvent.getPointerId(0));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.sdk.QGGLSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */