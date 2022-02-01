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
import com.tencent.mobileqq.qqui.R.styleable;
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
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ak, paramInt, 0);
    try
    {
      this.jdField_a_of_type_Float = ((int)paramContext.getDimension(R.styleable.H, 0.0F));
      this.jdField_a_of_type_Boolean = paramContext.getBoolean(R.styleable.G, false);
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
  
  public void onDraw(Canvas paramCanvas)
  {
    float f1 = 0.0F;
    for (;;)
    {
      try
      {
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if (this.jdField_a_of_type_Float <= 0.0F) {
          break label241;
        }
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i + this.jdField_a_of_type_Float, j);
          this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, Path.Direction.CW);
          a(paramCanvas);
          localObject = getDrawable();
          if (localObject == null) {
            break label241;
          }
          if ((localObject instanceof SkinnableBitmapDrawable))
          {
            localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
            if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
              break label241;
            }
            this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, i, j);
            paramCanvas.drawBitmap((Bitmap)localObject, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, null);
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
          float f2 = i;
          float f3 = j;
          if (this.jdField_a_of_type_Boolean) {
            f1 = this.jdField_a_of_type_Float;
          }
          ((RectF)localObject).set(0.0F, 0.0F, f2, f1 + f3);
          continue;
        }
        if (!(localObject instanceof BitmapDrawable)) {
          break label247;
        }
      }
      catch (Exception paramCanvas)
      {
        QLog.e("RoundImageView", 1, "onDraw exception", paramCanvas);
        return;
      }
      Object localObject = ((BitmapDrawable)localObject).getBitmap();
      continue;
      label241:
      super.onDraw(paramCanvas);
      return;
      label247:
      localObject = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RoundImageView
 * JD-Core Version:    0.7.0.1
 */