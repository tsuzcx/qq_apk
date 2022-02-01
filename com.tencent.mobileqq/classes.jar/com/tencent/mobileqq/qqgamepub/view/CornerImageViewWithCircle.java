package com.tencent.mobileqq.qqgamepub.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;

public class CornerImageViewWithCircle
  extends CornerImageView
{
  int c;
  int d;
  int e;
  int f;
  private Paint g;
  
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
    this.g = new Paint();
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setAntiAlias(true);
    this.g.setStrokeWidth(UIUtils.a(1.0F, getResources()));
  }
  
  /* Error */
  protected void b(android.graphics.Canvas paramCanvas)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 69	android/graphics/Canvas:save	()I
    //   4: istore_2
    //   5: aload_1
    //   6: aload_0
    //   7: getfield 71	com/tencent/mobileqq/qqgamepub/view/CornerImageViewWithCircle:c	I
    //   10: i2f
    //   11: aload_0
    //   12: getfield 73	com/tencent/mobileqq/qqgamepub/view/CornerImageViewWithCircle:d	I
    //   15: i2f
    //   16: aload_0
    //   17: getfield 75	com/tencent/mobileqq/qqgamepub/view/CornerImageViewWithCircle:f	I
    //   20: i2f
    //   21: aload_0
    //   22: getfield 32	com/tencent/mobileqq/qqgamepub/view/CornerImageViewWithCircle:g	Landroid/graphics/Paint;
    //   25: invokevirtual 79	android/graphics/Canvas:drawCircle	(FFFLandroid/graphics/Paint;)V
    //   28: goto +11 -> 39
    //   31: astore_3
    //   32: aload_1
    //   33: iload_2
    //   34: invokevirtual 83	android/graphics/Canvas:restoreToCount	(I)V
    //   37: aload_3
    //   38: athrow
    //   39: aload_1
    //   40: iload_2
    //   41: invokevirtual 83	android/graphics/Canvas:restoreToCount	(I)V
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
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt4;
    this.f = paramInt3;
    this.g.setColor(paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.CornerImageViewWithCircle
 * JD-Core Version:    0.7.0.1
 */