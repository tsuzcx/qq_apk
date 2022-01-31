package com.tencent.qg.sdk;

class QGGLSurfaceView$3
  implements QGRenderer.QGEventListener
{
  QGGLSurfaceView$3(QGGLSurfaceView paramQGGLSurfaceView, QGRenderer.QGEventListener paramQGEventListener) {}
  
  public void onCanvasCreated()
  {
    this.this$0.mQGBridge.nativeAttach();
    this.val$eventListener.onCanvasCreated();
  }
  
  public void onDrawFrame()
  {
    this.val$eventListener.onDrawFrame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qg.sdk.QGGLSurfaceView.3
 * JD-Core Version:    0.7.0.1
 */