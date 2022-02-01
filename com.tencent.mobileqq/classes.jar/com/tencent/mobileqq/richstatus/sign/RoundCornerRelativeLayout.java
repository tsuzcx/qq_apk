package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class RoundCornerRelativeLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private PaintFlagsDrawFilter jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private int b;
  
  public RoundCornerRelativeLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RoundCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RoundCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
    this.jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, 3);
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    if ((this.jdField_a_of_type_Int != getMeasuredWidth()) || (this.b != getMeasuredHeight()))
    {
      this.jdField_a_of_type_Int = getMeasuredWidth();
      this.b = getMeasuredHeight();
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_a_of_type_Int, this.b);
      Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      float f = this.jdField_a_of_type_Float;
      localPath.addRoundRect(localRectF, f, f, Path.Direction.CW);
    }
    paramCanvas.setDrawFilter(this.jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter);
    paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setRadius(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.sign.RoundCornerRelativeLayout
 * JD-Core Version:    0.7.0.1
 */