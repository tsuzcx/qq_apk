package com.tencent.qqmini.sdk.runtime.widget;

class CanvasView$3
  implements Runnable
{
  CanvasView$3(CanvasView paramCanvasView) {}
  
  public void run()
  {
    if ((CanvasView.a(this.this$0)) && (CanvasView.a(this.this$0) <= CanvasView.b(this.this$0)))
    {
      CanvasView.a(this.this$0);
      this.this$0.postInvalidate();
      CanvasView.a(this.this$0, System.currentTimeMillis());
      CanvasView.b(this.this$0, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.CanvasView.3
 * JD-Core Version:    0.7.0.1
 */