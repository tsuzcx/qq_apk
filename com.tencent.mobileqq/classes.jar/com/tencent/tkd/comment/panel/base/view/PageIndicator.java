package com.tencent.tkd.comment.panel.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.tkd.comment.panel.base.R.color;
import com.tencent.tkd.comment.panel.base.R.styleable;

public class PageIndicator
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public PageIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  /* Error */
  @android.annotation.SuppressLint({"CustomViewStyleable"})
  public PageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 28	android/view/View:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aconst_null
    //   8: astore 5
    //   10: aload_1
    //   11: aload_2
    //   12: getstatic 33	com/tencent/tkd/comment/panel/base/R$styleable:jdField_a_of_type_ArrayOfInt	[I
    //   15: invokevirtual 39	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   18: astore_1
    //   19: aload_1
    //   20: astore 5
    //   22: aload_1
    //   23: invokevirtual 45	android/content/res/TypedArray:getIndexCount	()I
    //   26: istore 4
    //   28: iconst_0
    //   29: istore_3
    //   30: iload_3
    //   31: iload 4
    //   33: if_icmpge +19 -> 52
    //   36: aload_1
    //   37: astore 5
    //   39: aload_0
    //   40: aload_1
    //   41: iload_3
    //   42: invokespecial 48	com/tencent/tkd/comment/panel/base/view/PageIndicator:a	(Landroid/content/res/TypedArray;I)V
    //   45: iload_3
    //   46: iconst_1
    //   47: iadd
    //   48: istore_3
    //   49: goto -19 -> 30
    //   52: aload_1
    //   53: ifnull +7 -> 60
    //   56: aload_1
    //   57: invokevirtual 52	android/content/res/TypedArray:recycle	()V
    //   60: aload_0
    //   61: new 54	android/graphics/Paint
    //   64: dup
    //   65: invokespecial 56	android/graphics/Paint:<init>	()V
    //   68: putfield 58	com/tencent/tkd/comment/panel/base/view/PageIndicator:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 60	com/tencent/tkd/comment/panel/base/view/PageIndicator:f	I
    //   76: aload_0
    //   77: fconst_1
    //   78: putfield 62	com/tencent/tkd/comment/panel/base/view/PageIndicator:jdField_a_of_type_Float	F
    //   81: return
    //   82: astore_1
    //   83: aload 5
    //   85: ifnull -25 -> 60
    //   88: aload 5
    //   90: invokevirtual 52	android/content/res/TypedArray:recycle	()V
    //   93: goto -33 -> 60
    //   96: astore_1
    //   97: aconst_null
    //   98: astore 5
    //   100: aload_1
    //   101: astore_2
    //   102: aload 5
    //   104: ifnull +8 -> 112
    //   107: aload 5
    //   109: invokevirtual 52	android/content/res/TypedArray:recycle	()V
    //   112: aload_2
    //   113: athrow
    //   114: astore_2
    //   115: aload_1
    //   116: astore 5
    //   118: goto -16 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	PageIndicator
    //   0	121	1	paramContext	Context
    //   0	121	2	paramAttributeSet	AttributeSet
    //   0	121	3	paramInt	int
    //   26	8	4	i	int
    //   8	109	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   10	19	82	java/lang/Throwable
    //   22	28	82	java/lang/Throwable
    //   39	45	82	java/lang/Throwable
    //   10	19	96	finally
    //   22	28	114	finally
    //   39	45	114	finally
  }
  
  private void a(TypedArray paramTypedArray, int paramInt)
  {
    paramInt = paramTypedArray.getIndex(paramInt);
    if (paramInt == R.styleable.b) {
      this.c = paramTypedArray.getInt(paramInt, 0);
    }
    do
    {
      return;
      if (paramInt == R.styleable.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Int = paramTypedArray.getColor(paramInt, getResources().getColor(R.color.jdField_a_of_type_Int));
        return;
      }
      if (paramInt == R.styleable.e)
      {
        this.b = paramTypedArray.getColor(paramInt, getResources().getColor(R.color.b));
        return;
      }
      if (paramInt == R.styleable.c)
      {
        this.e = paramTypedArray.getDimensionPixelSize(paramInt, (int)TypedValue.applyDimension(1, 4.0F, getResources().getDisplayMetrics()));
        return;
      }
    } while (paramInt != R.styleable.d);
    this.d = paramTypedArray.getDimensionPixelOffset(paramInt, (int)TypedValue.applyDimension(1, 24.0F, getResources().getDisplayMetrics()));
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = (float)(this.e / 2.0D);
    float f2 = (this.d + this.e) * paramInt1;
    float f3 = getHeight() / 2.0F;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt2);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)Math.ceil(255.0F * paramFloat));
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    paramCanvas.drawCircle(f2 + f1, f3, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.f = paramInt;
    invalidate();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.c <= 0) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    int i = 0;
    while (i < this.c)
    {
      a(paramCanvas, i, this.b, 1.0F);
      i += 1;
    }
    a(paramCanvas, this.f, this.jdField_a_of_type_Int, 1.0F - this.jdField_a_of_type_Float);
    a(paramCanvas, (this.f + 1) % this.c, this.jdField_a_of_type_Int, this.jdField_a_of_type_Float);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (j == 1073741824) {
      if (i != 1073741824) {
        break label82;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      paramInt1 = getPaddingLeft() + getPaddingRight() + this.c * this.e + (this.c - 1) * this.d;
      break;
      label82:
      paramInt2 = getPaddingTop() + getPaddingBottom() + this.e;
    }
  }
  
  public void setPageCount(int paramInt)
  {
    this.c = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.base.view.PageIndicator
 * JD-Core Version:    0.7.0.1
 */