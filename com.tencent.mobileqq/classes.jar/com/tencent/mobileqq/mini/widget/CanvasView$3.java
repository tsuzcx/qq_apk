package com.tencent.mobileqq.mini.widget;

class CanvasView$3
  implements Runnable
{
  CanvasView$3(CanvasView paramCanvasView) {}
  
  public void run()
  {
    if ((CanvasView.access$200(this.this$0)) && (CanvasView.access$300(this.this$0) <= CanvasView.access$400(this.this$0)))
    {
      CanvasView.access$500(this.this$0);
      this.this$0.postInvalidate();
      CanvasView.access$302(this.this$0, System.currentTimeMillis());
      CanvasView.access$402(this.this$0, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.CanvasView.3
 * JD-Core Version:    0.7.0.1
 */