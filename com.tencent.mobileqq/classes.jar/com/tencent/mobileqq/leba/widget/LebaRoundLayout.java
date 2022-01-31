package com.tencent.mobileqq.leba.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class LebaRoundLayout
  extends RelativeLayout
{
  public static final int[] a;
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  public Path a;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[8];
  public int b = 15;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 2, 4, 8 };
  }
  
  public LebaRoundLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LebaRoundLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public LebaRoundLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a(Canvas paramCanvas)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfFloat.length)
    {
      if ((jdField_a_of_type_ArrayOfInt[(i / 2)] & this.b) != 0) {
        this.jdField_a_of_type_ArrayOfFloat[i] = this.jdField_a_of_type_Int;
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfFloat[i] = 0.0F;
      }
    }
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.INVERSE_WINDING);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.b == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaRoundLayout", 2, "dispatchDraw ignore");
      }
      super.dispatchDraw(paramCanvas);
    }
    do
    {
      return;
      int i = getMeasuredWidth();
      int j = getMeasuredHeight();
      i = paramCanvas.saveLayer(0.0F, 0.0F, i, j, null, 31);
      super.dispatchDraw(paramCanvas);
      try
      {
        a(paramCanvas);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.i("LebaRoundLayout", 1, "checkPathChanged", localException);
          paramCanvas.restoreToCount(i);
        }
      }
      finally
      {
        paramCanvas.restoreToCount(i);
      }
    } while (!QLog.isColorLevel());
    QLog.i("LebaRoundLayout", 2, "dispatchDraw saveLayer");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.widget.LebaRoundLayout
 * JD-Core Version:    0.7.0.1
 */