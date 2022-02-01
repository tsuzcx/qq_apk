package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

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
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(AIOUtils.a(1.0F, getResources()));
  }
  
  /* Error */
  public void a(android.graphics.Canvas paramCanvas)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 66	android/graphics/Canvas:save	()I
    //   4: istore_2
    //   5: aload_1
    //   6: aload_0
    //   7: getfield 68	com/tencent/mobileqq/gamecenter/view/CornerImageViewWithCircle:jdField_a_of_type_Int	I
    //   10: i2f
    //   11: aload_0
    //   12: getfield 70	com/tencent/mobileqq/gamecenter/view/CornerImageViewWithCircle:b	I
    //   15: i2f
    //   16: aload_0
    //   17: getfield 72	com/tencent/mobileqq/gamecenter/view/CornerImageViewWithCircle:d	I
    //   20: i2f
    //   21: aload_0
    //   22: getfield 30	com/tencent/mobileqq/gamecenter/view/CornerImageViewWithCircle:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   25: invokevirtual 76	android/graphics/Canvas:drawCircle	(FFFLandroid/graphics/Paint;)V
    //   28: aload_1
    //   29: iload_2
    //   30: invokevirtual 80	android/graphics/Canvas:restoreToCount	(I)V
    //   33: return
    //   34: astore_3
    //   35: aload_1
    //   36: iload_2
    //   37: invokevirtual 80	android/graphics/Canvas:restoreToCount	(I)V
    //   40: return
    //   41: astore_3
    //   42: aload_1
    //   43: iload_2
    //   44: invokevirtual 80	android/graphics/Canvas:restoreToCount	(I)V
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	CornerImageViewWithCircle
    //   0	49	1	paramCanvas	android.graphics.Canvas
    //   4	40	2	i	int
    //   34	1	3	localException	java.lang.Exception
    //   41	7	3	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   5	28	34	java/lang/Exception
    //   5	28	41	finally
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
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.CornerImageViewWithCircle
 * JD-Core Version:    0.7.0.1
 */