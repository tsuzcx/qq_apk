package com.tencent.mobileqq.troopreward;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class OrientationAdapterImageView
  extends View
{
  protected int a = 1;
  protected Paint b = null;
  protected RectF c = new RectF();
  protected Bitmap d = null;
  protected Handler e = new OrientationAdapterImageView.1(this);
  
  public OrientationAdapterImageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public OrientationAdapterImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  protected void a(Context paramContext)
  {
    this.b = new Paint();
    this.b.setFilterBitmap(true);
    this.b.setAntiAlias(true);
    this.b.setDither(true);
    setBackgroundColor(-16777216);
  }
  
  protected void a(RectF paramRectF, Bitmap paramBitmap, View paramView)
  {
    int m = paramView.getHeight();
    int n = paramView.getWidth();
    int i = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    float f1 = n;
    float f2 = m;
    paramRectF.set(0.0F, 0.0F, f1, f2);
    float f3 = f1 * 1.0F / f2;
    float f4 = j;
    float f5 = f4 * 1.0F;
    float f6 = i;
    float f7 = f5 / f6;
    if (QLog.isColorLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("getTargetRectF,  viewRatio:");
      paramBitmap.append(f3);
      paramBitmap.append(", bmpRatio:");
      paramBitmap.append(f7);
      paramBitmap.append(", mOrientation:");
      paramBitmap.append(this.a);
      QLog.d("OrientationAdapterImageView", 2, paramBitmap.toString());
    }
    i = this.a;
    int k;
    if ((i != 0) && (i != 180))
    {
      if (f3 > f7)
      {
        k = (int)(f1 * f7);
        i = (n - k) / 2;
        j = (m - n) / 2;
        k += i;
      }
      else
      {
        i = -((int)(f1 * f7) - n) / 2;
        j = (m - n) / 2;
        k = n - i;
      }
      m = n + j;
    }
    else if (f3 > f7)
    {
      j = (int)(f5 * f2 / f6);
      i = (n - j) / 2;
      k = i + j;
      j = 0;
    }
    else
    {
      i = (int)(f6 * 1.0F * f1 / f4);
      j = (m - i) / 2;
      m = j + i;
      i = 0;
      k = n;
    }
    paramRectF.set(i, j, k, m);
    if (QLog.isColorLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("getTargetRectF:");
      paramBitmap.append(paramRectF.toString());
      QLog.d("OrientationAdapterImageView", 2, paramBitmap.toString());
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Bitmap localBitmap = this.d;
    if (localBitmap != null)
    {
      a(this.c, localBitmap, this);
      paramCanvas.save();
      paramCanvas.rotate(this.a, getWidth() / 2, getHeight() / 2);
      paramCanvas.drawBitmap(this.d, null, this.c, this.b);
      paramCanvas.restore();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.d = paramBitmap;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopreward.OrientationAdapterImageView
 * JD-Core Version:    0.7.0.1
 */