package com.tencent.mobileqq.widget;

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

public class RoundRelativeLayout
  extends RelativeLayout
{
  public static final int[] c = { 1, 2, 4, 8 };
  public Path a;
  public int b;
  public int d = 15;
  private Paint e;
  private float[] f = new float[8];
  
  public RoundRelativeLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RoundRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RoundRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a(Canvas paramCanvas)
  {
    int i = 0;
    for (;;)
    {
      float[] arrayOfFloat = this.f;
      if (i >= arrayOfFloat.length) {
        break;
      }
      if ((c[(i / 2)] & this.d) != 0) {
        arrayOfFloat[i] = this.b;
      } else {
        arrayOfFloat[i] = 0.0F;
      }
      i += 1;
    }
    this.a.reset();
    this.a.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.f, Path.Direction.CW);
    paramCanvas.drawPath(this.a, this.e);
  }
  
  public void a()
  {
    this.a = new Path();
    this.a.setFillType(Path.FillType.INVERSE_WINDING);
    this.e = new Paint(1);
    this.e.setStyle(Paint.Style.FILL_AND_STROKE);
    this.e.setColor(0);
    this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  /* Error */
  protected void dispatchDraw(Canvas paramCanvas)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/tencent/mobileqq/widget/RoundRelativeLayout:b	I
    //   4: ifeq +81 -> 85
    //   7: aload_0
    //   8: getfield 26	com/tencent/mobileqq/widget/RoundRelativeLayout:d	I
    //   11: ifne +6 -> 17
    //   14: goto +71 -> 85
    //   17: aload_0
    //   18: invokevirtual 127	com/tencent/mobileqq/widget/RoundRelativeLayout:getMeasuredWidth	()I
    //   21: istore_2
    //   22: aload_0
    //   23: invokevirtual 130	com/tencent/mobileqq/widget/RoundRelativeLayout:getMeasuredHeight	()I
    //   26: istore_3
    //   27: aload_1
    //   28: fconst_0
    //   29: fconst_0
    //   30: iload_2
    //   31: i2f
    //   32: iload_3
    //   33: i2f
    //   34: aconst_null
    //   35: bipush 31
    //   37: invokevirtual 134	android/graphics/Canvas:saveLayer	(FFFFLandroid/graphics/Paint;I)I
    //   40: istore_2
    //   41: aload_0
    //   42: aload_1
    //   43: invokespecial 136	android/widget/RelativeLayout:dispatchDraw	(Landroid/graphics/Canvas;)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 138	com/tencent/mobileqq/widget/RoundRelativeLayout:a	(Landroid/graphics/Canvas;)V
    //   51: aload_1
    //   52: iload_2
    //   53: invokevirtual 141	android/graphics/Canvas:restoreToCount	(I)V
    //   56: return
    //   57: astore 4
    //   59: goto +18 -> 77
    //   62: astore 4
    //   64: ldc 143
    //   66: iconst_1
    //   67: ldc 145
    //   69: aload 4
    //   71: invokestatic 151	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   74: goto -23 -> 51
    //   77: aload_1
    //   78: iload_2
    //   79: invokevirtual 141	android/graphics/Canvas:restoreToCount	(I)V
    //   82: aload 4
    //   84: athrow
    //   85: aload_0
    //   86: aload_1
    //   87: invokespecial 136	android/widget/RelativeLayout:dispatchDraw	(Landroid/graphics/Canvas;)V
    //   90: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	RoundRelativeLayout
    //   0	91	1	paramCanvas	Canvas
    //   21	58	2	i	int
    //   26	7	3	j	int
    //   57	1	4	localObject	java.lang.Object
    //   62	21	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   46	51	57	finally
    //   64	74	57	finally
    //   46	51	62	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RoundRelativeLayout
 * JD-Core Version:    0.7.0.1
 */