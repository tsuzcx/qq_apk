package com.tencent.mobileqq.qqgamepub.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;

public class CornerImageViewWithCircle
  extends CornerImageView
{
  int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  int b;
  int c;
  int d;
  
  public CornerImageViewWithCircle(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public CornerImageViewWithCircle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public CornerImageViewWithCircle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(UIUtils.a(1.0F, getResources()));
  }
  
  /* Error */
  protected void b(android.graphics.Canvas paramCanvas)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 66	android/graphics/Canvas:save	()I
    //   4: istore_2
    //   5: aload_1
    //   6: aload_0
    //   7: getfield 68	com/tencent/mobileqq/qqgamepub/view/CornerImageViewWithCircle:jdField_a_of_type_Int	I
    //   10: i2f
    //   11: aload_0
    //   12: getfield 70	com/tencent/mobileqq/qqgamepub/view/CornerImageViewWithCircle:b	I
    //   15: i2f
    //   16: aload_0
    //   17: getfield 72	com/tencent/mobileqq/qqgamepub/view/CornerImageViewWithCircle:d	I
    //   20: i2f
    //   21: aload_0
    //   22: getfield 30	com/tencent/mobileqq/qqgamepub/view/CornerImageViewWithCircle:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   25: invokevirtual 76	android/graphics/Canvas:drawCircle	(FFFLandroid/graphics/Paint;)V
    //   28: goto +11 -> 39
    //   31: astore_3
    //   32: aload_1
    //   33: iload_2
    //   34: invokevirtual 80	android/graphics/Canvas:restoreToCount	(I)V
    //   37: aload_3
    //   38: athrow
    //   39: aload_1
    //   40: iload_2
    //   41: invokevirtual 80	android/graphics/Canvas:restoreToCount	(I)V
    //   44: return
    //   45: astore_3
    //   46: goto -7 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	CornerImageViewWithCircle
    //   0	49	1	paramCanvas	android.graphics.Canvas
    //   4	37	2	i	int
    //   31	7	3	localObject	java.lang.Object
    //   45	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   5	28	31	finally
    //   5	28	45	java/lang/Exception
  }
  
  public void setCircle(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt4;
    this.d = paramInt3;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.CornerImageViewWithCircle
 * JD-Core Version:    0.7.0.1
 */