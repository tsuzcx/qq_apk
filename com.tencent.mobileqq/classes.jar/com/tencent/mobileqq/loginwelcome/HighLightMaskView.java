package com.tencent.mobileqq.loginwelcome;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import bfnz;

public class HighLightMaskView
  extends View
{
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Path jdField_a_of_type_AndroidGraphicsPath;
  PorterDuffXfermode jdField_a_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
  
  public HighLightMaskView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HighLightMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    }
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    if (bfnz.e()) {
      setLayerType(1, null);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(-1728053248);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
  }
  
  public void setCircleSrc(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a();
    this.jdField_a_of_type_AndroidGraphicsPath.addCircle(paramFloat1, paramFloat2, paramFloat3, Path.Direction.CW);
  }
  
  public void setRoundSrc(RectF paramRectF, float[] paramArrayOfFloat)
  {
    a();
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(paramRectF, paramArrayOfFloat, Path.Direction.CW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.HighLightMaskView
 * JD-Core Version:    0.7.0.1
 */