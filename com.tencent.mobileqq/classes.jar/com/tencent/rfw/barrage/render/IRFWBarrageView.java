package com.tencent.rfw.barrage.render;

import android.graphics.Canvas;
import android.view.View.OnTouchListener;

public abstract interface IRFWBarrageView
{
  public abstract Canvas a();
  
  public abstract void a(Canvas paramCanvas);
  
  public abstract void a(View.OnTouchListener paramOnTouchListener);
  
  public abstract void a(IRFWBarrageView.CallBack paramCallBack);
  
  public abstract float b();
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.render.IRFWBarrageView
 * JD-Core Version:    0.7.0.1
 */