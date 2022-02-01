package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;

public class PttBallImageView
  extends ImageView
{
  private Bitmap a;
  private int b;
  private int c;
  private float d;
  private float e;
  private Matrix f = new Matrix();
  
  public PttBallImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PttBallImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PttBallImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Bitmap localBitmap = this.a;
    if (localBitmap != null)
    {
      this.f.setScale(this.d / localBitmap.getWidth(), this.e / this.a.getHeight());
      float f1 = this.b;
      float f2 = this.d / 2.0F;
      float f3 = this.c;
      float f4 = this.e / 2.0F;
      this.f.postTranslate(f1 - f2, f3 - f4);
      paramCanvas.drawBitmap(this.a, this.f, null);
    }
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
  }
  
  public void setBitmapWH(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void setPos(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PttBallImageView
 * JD-Core Version:    0.7.0.1
 */