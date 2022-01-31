package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R.styleable;
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
  Rect b = new Rect();
  
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
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QwRoundView, paramInt, 0);
    try
    {
      this.jdField_a_of_type_Float = ((int)paramContext.getDimension(1, 0.0F));
      this.jdField_a_of_type_Boolean = paramContext.getBoolean(0, false);
      return;
    }
    catch (Exception paramAttributeSet)
    {
      QLog.e("RoundImageView", 1, "initAttrs exception", paramAttributeSet);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
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
    float f1 = 0.0F;
    for (;;)
    {
      try
      {
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if (this.jdField_a_of_type_Float > 0.0F)
        {
          localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
          float f2 = i;
          float f3 = j;
          if (this.jdField_a_of_type_Boolean) {
            f1 = this.jdField_a_of_type_Float;
          }
          ((RectF)localObject).set(0.0F, 0.0F, f2, f1 + f3);
          this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, Path.Direction.CW);
          a(paramCanvas);
          localObject = getDrawable();
          if (localObject != null) {
            if ((localObject instanceof SkinnableBitmapDrawable))
            {
              localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
              if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
              {
                this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
                this.b.set(0, 0, i, j);
                paramCanvas.drawBitmap((Bitmap)localObject, this.jdField_a_of_type_AndroidGraphicsRect, this.b, null);
              }
            }
            else
            {
              if (!(localObject instanceof BitmapDrawable)) {
                break label217;
              }
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
        QLog.e("RoundImageView", 1, "onDraw exception", paramCanvas);
        return;
      }
      label217:
      Object localObject = null;
    }
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