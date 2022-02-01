package com.tencent.qqmini.miniapp.widget;

class CanvasView$ShadowLayer
{
  public int color;
  public float dx;
  public float dy;
  public float radius;
  
  public CanvasView$ShadowLayer(CanvasView paramCanvasView) {}
  
  public CanvasView$ShadowLayer(CanvasView paramCanvasView, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.radius = paramFloat1;
    this.dx = paramFloat2;
    this.dy = paramFloat3;
    this.color = paramInt;
  }
  
  public ShadowLayer copy()
  {
    return new ShadowLayer(this.this$0, this.radius, this.dx, this.dy, this.color);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.ShadowLayer
 * JD-Core Version:    0.7.0.1
 */