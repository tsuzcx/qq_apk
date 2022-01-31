package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ProgressView
  extends View
{
  private Paint a;
  private int b;
  private int c;
  private int d;
  
  public ProgressView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new Paint();
    this.a.setDither(true);
    this.a.setAntiAlias(true);
    this.a.setStrokeWidth(10.0F);
    this.a.setColor(-65536);
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    invalidate();
  }
  
  public void b(int paramInt)
  {
    this.a.setColor(paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawRect(0.0F, 0.0F, this.b * this.d / 100, this.c, this.a);
    super.onDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.ProgressView
 * JD-Core Version:    0.7.0.1
 */