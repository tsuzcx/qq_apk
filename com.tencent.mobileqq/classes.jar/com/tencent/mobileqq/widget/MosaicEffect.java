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
  private static boolean b = false;
  private int jdField_a_of_type_Int = 10;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(5);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private View jdField_a_of_type_AndroidViewView;
  private boolean jdField_a_of_type_Boolean;
  
  public MosaicEffect(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Canvas paramCanvas)
  {
    long l = SystemClock.uptimeMillis();
    int j = this.jdField_a_of_type_AndroidViewView.getWidth() / this.jdField_a_of_type_Int;
    int k = this.jdField_a_of_type_AndroidViewView.getHeight() / this.jdField_a_of_type_Int;
    Object localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject1 == null) || (((Bitmap)localObject1).getWidth() != j) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() != k))
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
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      }
      catch (Exception localException1)
      {
        QLog.e("MosaicEffect", 1, "draw: createBitmap failed ", localException1);
        try
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.RGB_565);
        }
        catch (Exception localException2)
        {
          QLog.e("MosaicEffect", 1, "draw: alloc memory failed, do nothing", localException2);
        }
      }
    }
    Object localObject2 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject2 == null)
    {
      QLog.e("MosaicEffect", 1, "draw: Bitmap is NULL");
      return;
    }
    ((Bitmap)localObject2).eraseColor(0);
    this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_AndroidViewView.computeScroll();
    int i = this.jdField_a_of_type_AndroidGraphicsCanvas.save();
    float f = 1.0F / this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsCanvas.scale(f, f);
    this.jdField_a_of_type_AndroidGraphicsCanvas.translate(-this.jdField_a_of_type_AndroidViewView.getScrollX(), -this.jdField_a_of_type_AndroidViewView.getScrollY());
    this.jdField_a_of_type_Boolean = false;
    localObject2 = this.jdField_a_of_type_AndroidViewView;
    if ((localObject2 instanceof MosaicEffect.IMosaicEffect)) {
      ((MosaicEffect.IMosaicEffect)localObject2).superDrawMosaic(this.jdField_a_of_type_AndroidGraphicsCanvas);
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.restoreToCount(i);
    this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(null);
    this.jdField_a_of_type_Boolean = true;
    localObject2 = this.jdField_a_of_type_AndroidViewView;
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
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void b(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(false);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        if (paramCanvas.getClipBounds(this.jdField_a_of_type_AndroidGraphicsRect))
        {
          if (!paramCanvas.isHardwareAccelerated())
          {
            View localView = this.jdField_a_of_type_AndroidViewView;
            if ((localView != null) && ((localView.getWidth() < this.jdField_a_of_type_AndroidGraphicsRect.width()) || (this.jdField_a_of_type_AndroidViewView.getHeight() < this.jdField_a_of_type_AndroidGraphicsRect.height()))) {
              this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_a_of_type_AndroidViewView.getWidth(), this.jdField_a_of_type_AndroidViewView.getHeight());
            }
          }
          if (b)
          {
            this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
            paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          }
          paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          return;
        }
        paramCanvas = new StringBuilder();
        paramCanvas.append("onDraw: clipBound is empty ");
        paramCanvas.append(this.jdField_a_of_type_AndroidGraphicsRect);
        QLog.e("MosaicEffect", 1, paramCanvas.toString());
      }
    }
    else
    {
      paramCanvas = this.jdField_a_of_type_AndroidViewView;
      if ((paramCanvas instanceof MosaicEffect.IMosaicEffect)) {
        ((MosaicEffect.IMosaicEffect)paramCanvas).superOnDrawMosaic(this.jdField_a_of_type_AndroidGraphicsCanvas);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MosaicEffect
 * JD-Core Version:    0.7.0.1
 */