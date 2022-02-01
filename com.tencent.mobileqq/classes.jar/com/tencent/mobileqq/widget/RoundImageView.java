package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;

public class RoundImageView
  extends ImageView
{
  float jdField_a_of_type_Float = 0.0F;
  Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  boolean jdField_a_of_type_Boolean = false;
  Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  boolean jdField_b_of_type_Boolean = false;
  
  public RoundImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  /* Error */
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: getstatic 56	com/tencent/mobileqq/qqui/R$styleable:aM	[I
    //   5: iload_3
    //   6: iconst_0
    //   7: invokevirtual 62	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   10: astore_1
    //   11: aload_0
    //   12: aload_1
    //   13: getstatic 66	com/tencent/mobileqq/qqui/R$styleable:aZ	I
    //   16: fconst_0
    //   17: invokevirtual 72	android/content/res/TypedArray:getDimension	(IF)F
    //   20: f2i
    //   21: i2f
    //   22: putfield 23	com/tencent/mobileqq/widget/RoundImageView:jdField_a_of_type_Float	F
    //   25: aload_0
    //   26: aload_1
    //   27: getstatic 75	com/tencent/mobileqq/qqui/R$styleable:aY	I
    //   30: iconst_0
    //   31: invokevirtual 79	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   34: putfield 25	com/tencent/mobileqq/widget/RoundImageView:jdField_a_of_type_Boolean	Z
    //   37: goto +17 -> 54
    //   40: astore_2
    //   41: goto +18 -> 59
    //   44: astore_2
    //   45: ldc 81
    //   47: iconst_1
    //   48: ldc 83
    //   50: aload_2
    //   51: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   54: aload_1
    //   55: invokevirtual 92	android/content/res/TypedArray:recycle	()V
    //   58: return
    //   59: aload_1
    //   60: invokevirtual 92	android/content/res/TypedArray:recycle	()V
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	RoundImageView
    //   0	65	1	paramContext	Context
    //   0	65	2	paramAttributeSet	AttributeSet
    //   0	65	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   11	37	40	finally
    //   45	54	40	finally
    //   11	37	44	java/lang/Exception
  }
  
  private void a(Canvas paramCanvas)
  {
    try
    {
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
      return;
    }
    catch (Exception paramCanvas)
    {
      QLog.e("RoundImageView", 1, "clipPathSafe exception", paramCanvas);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    for (;;)
    {
      try
      {
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if (this.jdField_a_of_type_Float > 0.0F)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i + this.jdField_a_of_type_Float, j);
          }
          else
          {
            localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
            float f2 = i;
            float f3 = j;
            if (!this.jdField_a_of_type_Boolean) {
              break label251;
            }
            f1 = this.jdField_a_of_type_Float;
            ((RectF)localObject).set(0.0F, 0.0F, f2, f3 + f1);
          }
          this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, Path.Direction.CW);
          a(paramCanvas);
          localObject = getDrawable();
          if (localObject != null)
          {
            if ((localObject instanceof SkinnableBitmapDrawable))
            {
              localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
            }
            else
            {
              if (!(localObject instanceof BitmapDrawable)) {
                break label256;
              }
              localObject = ((BitmapDrawable)localObject).getBitmap();
            }
            if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
            {
              this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
              this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, i, j);
              paramCanvas.drawBitmap((Bitmap)localObject, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, null);
              return;
            }
          }
        }
        super.onDraw(paramCanvas);
        return;
      }
      catch (Exception paramCanvas)
      {
        QLog.e("RoundImageView", 1, "onDraw exception", paramCanvas);
        return;
      }
      label251:
      float f1 = 0.0F;
      continue;
      label256:
      Object localObject = null;
    }
  }
  
  public void setRadiusWithoutRight(int paramInt)
  {
    this.jdField_a_of_type_Float = paramInt;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void setmRadius(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Float = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RoundImageView
 * JD-Core Version:    0.7.0.1
 */