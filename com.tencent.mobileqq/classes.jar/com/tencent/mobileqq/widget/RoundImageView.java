package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.theme.SkinnableBitmapDrawable;

public class RoundImageView
  extends ImageView
{
  float jdField_a_of_type_Float = 0.0F;
  boolean jdField_a_of_type_Boolean = false;
  
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
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
  }
  
  /* Error */
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: getstatic 41	com/tencent/mobileqq/R$styleable:QwRoundView	[I
    //   5: iload_3
    //   6: iconst_0
    //   7: invokevirtual 47	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   10: astore_1
    //   11: aload_0
    //   12: aload_1
    //   13: iconst_0
    //   14: fconst_0
    //   15: invokevirtual 53	android/content/res/TypedArray:getDimension	(IF)F
    //   18: f2i
    //   19: i2f
    //   20: putfield 19	com/tencent/mobileqq/widget/RoundImageView:jdField_a_of_type_Float	F
    //   23: aload_0
    //   24: aload_1
    //   25: iconst_1
    //   26: iconst_0
    //   27: invokevirtual 57	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   30: putfield 21	com/tencent/mobileqq/widget/RoundImageView:jdField_a_of_type_Boolean	Z
    //   33: aload_1
    //   34: invokevirtual 61	android/content/res/TypedArray:recycle	()V
    //   37: return
    //   38: astore_2
    //   39: aload_1
    //   40: invokevirtual 61	android/content/res/TypedArray:recycle	()V
    //   43: return
    //   44: astore_2
    //   45: aload_1
    //   46: invokevirtual 61	android/content/res/TypedArray:recycle	()V
    //   49: aload_2
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	RoundImageView
    //   0	51	1	paramContext	Context
    //   0	51	2	paramAttributeSet	AttributeSet
    //   0	51	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   11	33	38	java/lang/Exception
    //   11	33	44	finally
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
          Object localObject = getDrawable();
          if (localObject != null) {
            if ((localObject instanceof SkinnableBitmapDrawable))
            {
              localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
              if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
              {
                Path localPath = new Path();
                float f2 = i;
                float f3 = j;
                if (!this.jdField_a_of_type_Boolean) {
                  break label195;
                }
                f1 = this.jdField_a_of_type_Float;
                localPath.addRoundRect(new RectF(0.0F, 0.0F, f2, f1 + f3), this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, Path.Direction.CW);
                paramCanvas.clipPath(localPath);
                paramCanvas.drawBitmap((Bitmap)localObject, new Rect(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight()), new Rect(0, 0, i, j), null);
              }
            }
            else
            {
              localObject = ((BitmapDrawable)localObject).getBitmap();
              continue;
            }
          }
        }
        super.onDraw(paramCanvas);
        return;
      }
      catch (Exception paramCanvas)
      {
        paramCanvas.printStackTrace();
        return;
      }
      label195:
      float f1 = 0.0F;
    }
  }
  
  public void setmRadius(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Float = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RoundImageView
 * JD-Core Version:    0.7.0.1
 */