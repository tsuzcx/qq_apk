package com.tencent.mobileqq.qqlive.view;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

class TPSurfaceView$1
  implements SurfaceHolder.Callback
{
  TPSurfaceView$1(TPSurfaceView paramTPSurfaceView) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (TPSurfaceView.a(this.a) != null) {
      TPSurfaceView.a(this.a).b(paramSurfaceHolder, this.a.getWidth(), this.a.getHeight());
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (TPSurfaceView.a(this.a) != null) {
      TPSurfaceView.a(this.a).a(paramSurfaceHolder, this.a.getWidth(), this.a.getHeight());
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (TPSurfaceView.a(this.a) != null) {
      TPSurfaceView.a(this.a).a(paramSurfaceHolder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.view.TPSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */