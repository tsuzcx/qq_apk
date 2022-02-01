package com.tencent.qqmini.miniapp.widget;

class CanvasView$26
  implements Runnable
{
  CanvasView$26(CanvasView paramCanvasView) {}
  
  public void run()
  {
    if ((CanvasView.access$4100(this.this$0)) && (CanvasView.access$4200(this.this$0) <= CanvasView.access$4300(this.this$0)))
    {
      CanvasView.access$4400(this.this$0);
      this.this$0.postInvalidate();
      CanvasView.access$4202(this.this$0, System.currentTimeMillis());
      CanvasView.access$4302(this.this$0, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.26
 * JD-Core Version:    0.7.0.1
 */