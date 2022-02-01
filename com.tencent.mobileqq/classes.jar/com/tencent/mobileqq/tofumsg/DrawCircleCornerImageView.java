package com.tencent.mobileqq.tofumsg;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

public class DrawCircleCornerImageView
  extends CornerImageView
{
  int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  int b;
  int c;
  int d;
  
  public DrawCircleCornerImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DrawCircleCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DrawCircleCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  /* Error */
  protected void b(android.graphics.Canvas paramCanvas)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/tencent/mobileqq/tofumsg/DrawCircleCornerImageView:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   4: ifnonnull +25 -> 29
    //   7: aload_0
    //   8: new 28	android/graphics/Paint
    //   11: dup
    //   12: invokespecial 31	android/graphics/Paint:<init>	()V
    //   15: putfield 26	com/tencent/mobileqq/tofumsg/DrawCircleCornerImageView:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   18: aload_0
    //   19: getfield 26	com/tencent/mobileqq/tofumsg/DrawCircleCornerImageView:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   22: aload_0
    //   23: getfield 33	com/tencent/mobileqq/tofumsg/DrawCircleCornerImageView:c	I
    //   26: invokevirtual 37	android/graphics/Paint:setColor	(I)V
    //   29: aload_1
    //   30: invokevirtual 43	android/graphics/Canvas:save	()I
    //   33: istore_2
    //   34: aload_1
    //   35: aload_0
    //   36: getfield 45	com/tencent/mobileqq/tofumsg/DrawCircleCornerImageView:jdField_a_of_type_Int	I
    //   39: i2f
    //   40: aload_0
    //   41: getfield 47	com/tencent/mobileqq/tofumsg/DrawCircleCornerImageView:b	I
    //   44: i2f
    //   45: aload_0
    //   46: getfield 49	com/tencent/mobileqq/tofumsg/DrawCircleCornerImageView:d	I
    //   49: i2f
    //   50: aload_0
    //   51: getfield 26	com/tencent/mobileqq/tofumsg/DrawCircleCornerImageView:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   54: invokevirtual 53	android/graphics/Canvas:drawCircle	(FFFLandroid/graphics/Paint;)V
    //   57: goto +11 -> 68
    //   60: astore_3
    //   61: aload_1
    //   62: iload_2
    //   63: invokevirtual 56	android/graphics/Canvas:restoreToCount	(I)V
    //   66: aload_3
    //   67: athrow
    //   68: aload_1
    //   69: iload_2
    //   70: invokevirtual 56	android/graphics/Canvas:restoreToCount	(I)V
    //   73: return
    //   74: astore_3
    //   75: goto -7 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	DrawCircleCornerImageView
    //   0	78	1	paramCanvas	android.graphics.Canvas
    //   33	37	2	i	int
    //   60	7	3	localObject	java.lang.Object
    //   74	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   34	57	60	finally
    //   34	57	74	java/lang/Exception
  }
  
  public void setCircle(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt4;
    this.d = paramInt3;
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    if (localPaint != null) {
      localPaint.setColor(paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.DrawCircleCornerImageView
 * JD-Core Version:    0.7.0.1
 */