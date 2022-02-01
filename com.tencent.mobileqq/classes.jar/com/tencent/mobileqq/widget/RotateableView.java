package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

public class RotateableView
  extends View
{
  Handler a = new RotateableView.1(this);
  private float b;
  private int c;
  private Bitmap d;
  private int e;
  private int f;
  private boolean g = false;
  private Context h;
  
  public RotateableView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RotateableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.h = paramContext;
  }
  
  public void a()
  {
    this.g = true;
    invalidate();
  }
  
  public void b()
  {
    this.g = false;
    this.b = 0.0F;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.rotate(this.b, this.e / 2.0F, this.f / 2.0F);
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    Bitmap localBitmap = this.d;
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
    }
    if (this.g)
    {
      this.b += 8.0F;
      float f1 = this.b;
      if (f1 >= 360.0F) {
        this.b = (f1 - 360.0F);
      }
      invalidate();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Bitmap localBitmap = this.d;
    if (localBitmap != null)
    {
      this.f = localBitmap.getHeight();
      this.e = this.d.getWidth();
    }
    setMeasuredDimension(this.e, this.f);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    this.c = paramInt;
    this.d = BitmapFactory.decodeResource(this.h.getResources(), this.c);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RotateableView
 * JD-Core Version:    0.7.0.1
 */