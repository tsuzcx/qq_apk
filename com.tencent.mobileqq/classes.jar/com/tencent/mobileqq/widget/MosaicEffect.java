package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class MosaicEffect
{
  private static boolean h = false;
  private View a;
  private Bitmap b;
  private boolean c;
  private Rect d = new Rect();
  private Paint e = new Paint(5);
  private int f = 10;
  private Canvas g = new Canvas();
  
  public MosaicEffect(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(Canvas paramCanvas)
  {
    long l = SystemClock.uptimeMillis();
    int j = this.a.getWidth() / this.f;
    int k = this.a.getHeight() / this.f;
    Object localObject1 = this.b;
    if ((localObject1 == null) || (((Bitmap)localObject1).getWidth() != j) || (this.b.getHeight() != k))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("draw: try to alloc bitmap w x h=[");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append("x");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append("]");
        QLog.i("MosaicEffect", 2, ((StringBuilder)localObject1).toString());
      }
      i = j;
      if (j <= 0)
      {
        QLog.e("MosaicEffect", 1, "draw: mosaicWidth <= 0");
        i = 1;
      }
      j = k;
      if (k <= 0)
      {
        QLog.e("MosaicEffect", 1, "draw: mosaicHeight <= 0");
        j = 1;
      }
      try
      {
        this.b = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      }
      catch (Exception localException1)
      {
        QLog.e("MosaicEffect", 1, "draw: createBitmap failed ", localException1);
        try
        {
          this.b = Bitmap.createBitmap(i, j, Bitmap.Config.RGB_565);
        }
        catch (Exception localException2)
        {
          QLog.e("MosaicEffect", 1, "draw: alloc memory failed, do nothing", localException2);
        }
      }
    }
    Object localObject2 = this.b;
    if (localObject2 == null)
    {
      QLog.e("MosaicEffect", 1, "draw: Bitmap is NULL");
      return;
    }
    ((Bitmap)localObject2).eraseColor(0);
    this.g.setBitmap(this.b);
    this.a.computeScroll();
    int i = this.g.save();
    float f1 = 1.0F / this.f;
    this.g.scale(f1, f1);
    this.g.translate(-this.a.getScrollX(), -this.a.getScrollY());
    this.c = false;
    localObject2 = this.a;
    if ((localObject2 instanceof MosaicEffect.IMosaicEffect)) {
      ((MosaicEffect.IMosaicEffect)localObject2).superDrawMosaic(this.g);
    }
    this.g.restoreToCount(i);
    this.g.setBitmap(null);
    this.c = true;
    localObject2 = this.a;
    if ((localObject2 instanceof MosaicEffect.IMosaicEffect)) {
      ((MosaicEffect.IMosaicEffect)localObject2).superDrawMosaic(paramCanvas);
    }
    if (QLog.isColorLevel())
    {
      paramCanvas = new StringBuilder();
      paramCanvas.append("draw: ");
      paramCanvas.append(SystemClock.uptimeMillis() - l);
      paramCanvas.append(" ms");
      QLog.i("MosaicEffect", 2, paramCanvas.toString());
    }
  }
  
  public void a(View paramView)
  {
    this.a = paramView;
  }
  
  public void b(Canvas paramCanvas)
  {
    if (this.c)
    {
      this.e.setFilterBitmap(false);
      if (this.b != null)
      {
        if (paramCanvas.getClipBounds(this.d))
        {
          if (!paramCanvas.isHardwareAccelerated())
          {
            View localView = this.a;
            if ((localView != null) && ((localView.getWidth() < this.d.width()) || (this.a.getHeight() < this.d.height()))) {
              this.d.set(0, 0, this.a.getWidth(), this.a.getHeight());
            }
          }
          if (h)
          {
            this.e.setStyle(Paint.Style.FILL);
            this.e.setColor(-65536);
            paramCanvas.drawRect(this.d, this.e);
          }
          paramCanvas.drawBitmap(this.b, null, this.d, this.e);
          return;
        }
        paramCanvas = new StringBuilder();
        paramCanvas.append("onDraw: clipBound is empty ");
        paramCanvas.append(this.d);
        QLog.e("MosaicEffect", 1, paramCanvas.toString());
      }
    }
    else
    {
      paramCanvas = this.a;
      if ((paramCanvas instanceof MosaicEffect.IMosaicEffect)) {
        ((MosaicEffect.IMosaicEffect)paramCanvas).superOnDrawMosaic(this.g);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MosaicEffect
 * JD-Core Version:    0.7.0.1
 */