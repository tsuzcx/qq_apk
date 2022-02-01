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
  protected int a;
  protected Bitmap a;
  protected Paint a;
  protected RectF a;
  protected Handler a;
  
  public OrientationAdapterImageView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_AndroidOsHandler = new OrientationAdapterImageView.1(this);
    a(paramContext);
  }
  
  public OrientationAdapterImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_AndroidOsHandler = new OrientationAdapterImageView.1(this);
    a(paramContext);
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    setBackgroundColor(-16777216);
  }
  
  protected void a(RectF paramRectF, Bitmap paramBitmap, View paramView)
  {
    int i = paramView.getHeight();
    int j = paramView.getWidth();
    int k = paramBitmap.getHeight();
    int m = paramBitmap.getWidth();
    paramRectF.set(0.0F, 0.0F, j, i);
    float f1 = j * 1.0F / i;
    float f2 = m * 1.0F / k;
    if (QLog.isColorLevel()) {
      QLog.d("OrientationAdapterImageView", 2, "getTargetRectF,  viewRatio:" + f1 + ", bmpRatio:" + f2 + ", mOrientation:" + this.jdField_a_of_type_Int);
    }
    int n;
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 180)) {
      if (f1 > f2)
      {
        n = (int)(m * 1.0F * i / k);
        m = (j - n) / 2;
        k = 0;
        j = n + m;
      }
    }
    for (;;)
    {
      paramRectF.set(m, k, j, i);
      if (QLog.isColorLevel()) {
        QLog.d("OrientationAdapterImageView", 2, "getTargetRectF:" + paramRectF.toString());
      }
      return;
      n = (int)(k * 1.0F * j / m);
      m = 0;
      k = (i - n) / 2;
      i = k + n;
      continue;
      if (f1 > f2)
      {
        n = (int)(j * f2);
        m = (j - n) / 2;
        k = (i - j) / 2;
        n += m;
        i = k + j;
        j = n;
      }
      else
      {
        m = -((int)(j * f2) - j) / 2;
        k = (i - j) / 2;
        n = j - m;
        i = k + j;
        j = n;
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      a(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsBitmap, this);
      paramCanvas.save();
      paramCanvas.rotate(this.jdField_a_of_type_Int, getWidth() / 2, getHeight() / 2);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopreward.OrientationAdapterImageView
 * JD-Core Version:    0.7.0.1
 */