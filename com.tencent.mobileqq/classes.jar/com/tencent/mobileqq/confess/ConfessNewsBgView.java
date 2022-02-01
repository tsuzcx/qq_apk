package com.tencent.mobileqq.confess;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.util.VersionUtils;

public class ConfessNewsBgView
  extends View
{
  int jdField_a_of_type_Int = -6807359;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private Path jdField_a_of_type_AndroidGraphicsPath;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = { 16.0F, 16.0F, 16.0F, 16.0F, 16.0F, 16.0F, 16.0F, 16.0F };
  ConfessShareHelper.BgElement[] jdField_a_of_type_ArrayOfComTencentMobileqqConfessConfessShareHelper$BgElement = null;
  int b = 0;
  private int c = 0;
  
  public ConfessNewsBgView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ConfessNewsBgView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ConfessNewsBgView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    int i = this.c;
    int j = 0;
    Object localObject1;
    if (i == 2)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqConfessConfessShareHelper$BgElement = ConfessShareHelper.a(i, this.b);
      localObject1 = getResources();
      int k = ((Resources)localObject1).getDisplayMetrics().widthPixels;
      int m = ((Resources)localObject1).getDisplayMetrics().heightPixels;
      Object localObject2;
      if ((k != 0) && (Math.abs(k - 1080) > 200))
      {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqConfessConfessShareHelper$BgElement;
        int n = localObject1.length;
        i = 0;
        while (i < n)
        {
          localObject2 = localObject1[i];
          float f1 = localObject2.b;
          float f2 = k / 1080;
          if (k - (int)(f1 * f2) > 100) {
            localObject2.b = ((int)(localObject2.b * f2));
          }
          i += 1;
        }
      }
      if (m != 0)
      {
        double d1 = m;
        Double.isNaN(d1);
        d1 *= 0.8D;
        double d2 = 1800;
        Double.isNaN(d2);
        if (Math.abs(d1 - d2) > 200.0D)
        {
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqConfessConfessShareHelper$BgElement;
          k = localObject1.length;
          i = j;
          while (i < k)
          {
            localObject2 = localObject1[i];
            d2 = localObject2.c;
            double d3 = 1800;
            Double.isNaN(d3);
            d3 = d1 / d3;
            Double.isNaN(d2);
            localObject2.c = ((int)(d2 * d3));
            i += 1;
          }
        }
      }
    }
    else
    {
      localObject1 = ConfessShareHelper.a[0];
      i = this.b;
      if ((i >= 0) && (i < ConfessShareHelper.a.length))
      {
        localObject1 = ConfessShareHelper.a;
        i = this.b;
        localObject1 = localObject1[i];
        this.jdField_a_of_type_ArrayOfComTencentMobileqqConfessConfessShareHelper$BgElement = ConfessShareHelper.a(0, i);
      }
      else
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqConfessConfessShareHelper$BgElement = ConfessShareHelper.a(0, 0);
      }
    }
    try
    {
      this.jdField_a_of_type_Int = Color.parseColor((String)localObject1);
    }
    catch (Exception localException)
    {
      label359:
      break label359;
    }
    this.jdField_a_of_type_Int = -6807359;
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    if (!VersionUtils.h()) {
      setLayerType(1, null);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.jdField_a_of_type_Boolean)
    {
      if (isPressed()) {
        this.jdField_a_of_type_Int = Color.argb(100, Color.red(this.jdField_a_of_type_Int), Color.green(this.jdField_a_of_type_Int), Color.blue(this.jdField_a_of_type_Int));
      } else {
        this.jdField_a_of_type_Int = Color.argb(255, Color.red(this.jdField_a_of_type_Int), Color.green(this.jdField_a_of_type_Int), Color.blue(this.jdField_a_of_type_Int));
      }
      postInvalidate();
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getMeasuredWidth();
    j = getMeasuredHeight();
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i, j);
    if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    }
    int k = paramCanvas.save();
    try
    {
      Object localObject1 = this.jdField_a_of_type_AndroidGraphicsPath;
      ((Path)localObject1).reset();
      ((Path)localObject1).addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
      paramCanvas.clipPath((Path)localObject1);
      label90:
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqConfessConfessShareHelper$BgElement;
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int m = localObject1.length;
        i = 0;
        while (i < m)
        {
          Object localObject2 = localObject1[i];
          try
          {
            localDrawable = getResources().getDrawable(localObject2.jdField_a_of_type_Int);
            if (localObject2.jdField_a_of_type_Int == 2130844996) {
              break label343;
            }
            int n = localDrawable.getIntrinsicWidth();
            j = localDrawable.getIntrinsicHeight();
            float f2 = localObject2.b;
            float f1 = n;
            n = (int)(f2 * 1.8F - localObject2.jdField_a_of_type_Float * f1 * 1.0F / 2.0F);
            f2 = localObject2.c;
            float f3 = j;
            localDrawable.setBounds(n, (int)(f2 * 1.6F - localObject2.jdField_a_of_type_Float * f3 * 1.0F / 2.0F), (int)(localObject2.b * 1.8F + f1 * localObject2.jdField_a_of_type_Float * 1.0F / 2.0F), (int)(localObject2.c * 1.6F + f3 * localObject2.jdField_a_of_type_Float * 1.0F / 2.0F));
            if (!localObject2.jdField_a_of_type_Boolean) {
              break label337;
            }
            if (this.c != 2) {
              break label369;
            }
            j = 128;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Drawable localDrawable;
              continue;
              j = 77;
            }
          }
          localDrawable.setAlpha(j);
          localDrawable.setColorFilter(this.jdField_a_of_type_Int, PorterDuff.Mode.MULTIPLY);
          label337:
          localDrawable.draw(paramCanvas);
          label343:
          i += 1;
        }
      }
      else
      {
        paramCanvas.restoreToCount(k);
        return;
      }
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      break label90;
    }
  }
  
  public void setBgColor(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt) {
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void setBgType(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      a();
      postInvalidate();
    }
  }
  
  public void setPressMask(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setSize(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      a();
      postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessNewsBgView
 * JD-Core Version:    0.7.0.1
 */