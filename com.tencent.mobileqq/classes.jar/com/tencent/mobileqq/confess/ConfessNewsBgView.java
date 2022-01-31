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
  private int c;
  
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
    Object localObject1;
    if (this.c == 2)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqConfessConfessShareHelper$BgElement = ConfessShareHelper.a(this.c, this.b);
      localObject1 = getResources();
      int k = ((Resources)localObject1).getDisplayMetrics().widthPixels;
      int j = ((Resources)localObject1).getDisplayMetrics().heightPixels;
      int i;
      Object localObject2;
      if ((k != 0) && (Math.abs(k - 1080) > 200))
      {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqConfessConfessShareHelper$BgElement;
        int m = localObject1.length;
        i = 0;
        while (i < m)
        {
          localObject2 = localObject1[i];
          if (k - (int)(localObject2.b * (k / 1080)) > 100) {
            localObject2.b = ((int)(localObject2.b * (k / 1080)));
          }
          i += 1;
        }
      }
      if ((j != 0) && (Math.abs(j * 0.8D - 1800) > 200.0D))
      {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqConfessConfessShareHelper$BgElement;
        k = localObject1.length;
        i = 0;
        while (i < k)
        {
          localObject2 = localObject1[i];
          localObject2.c = ((int)(localObject2.c * (j * 0.8D / 1800)));
          i += 1;
        }
      }
    }
    else
    {
      localObject1 = ConfessShareHelper.a[0];
      if ((this.b < 0) || (this.b >= ConfessShareHelper.a.length)) {
        break label309;
      }
      localObject1 = ConfessShareHelper.a[this.b];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqConfessConfessShareHelper$BgElement = ConfessShareHelper.a(0, this.b);
    }
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_Int = Color.parseColor((String)localObject1);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
        if (!VersionUtils.h()) {
          setLayerType(1, null);
        }
        return;
        label309:
        this.jdField_a_of_type_ArrayOfComTencentMobileqqConfessConfessShareHelper$BgElement = ConfessShareHelper.a(0, 0);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Int = -6807359;
      }
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.jdField_a_of_type_Boolean) {
      if (!isPressed()) {
        break label53;
      }
    }
    label53:
    for (this.jdField_a_of_type_Int = Color.argb(100, Color.red(this.jdField_a_of_type_Int), Color.green(this.jdField_a_of_type_Int), Color.blue(this.jdField_a_of_type_Int));; this.jdField_a_of_type_Int = Color.argb(255, Color.red(this.jdField_a_of_type_Int), Color.green(this.jdField_a_of_type_Int), Color.blue(this.jdField_a_of_type_Int)))
    {
      postInvalidate();
      return;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i, j);
    if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    }
    j = paramCanvas.save();
    try
    {
      Object localObject1 = this.jdField_a_of_type_AndroidGraphicsPath;
      ((Path)localObject1).reset();
      ((Path)localObject1).addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
      paramCanvas.clipPath((Path)localObject1);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqConfessConfessShareHelper$BgElement != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqConfessConfessShareHelper$BgElement.length > 0))
      {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqConfessConfessShareHelper$BgElement;
        int k = localObject1.length;
        i = 0;
        if (i < k)
        {
          Object localObject2 = localObject1[i];
          try
          {
            Drawable localDrawable = getResources().getDrawable(localObject2.jdField_a_of_type_Int);
            if (localObject2.jdField_a_of_type_Int == 2130842424) {
              break label352;
            }
            int i2 = localDrawable.getIntrinsicWidth();
            int m = localDrawable.getIntrinsicHeight();
            int n = (int)(localObject2.b * 1.8F - i2 * localObject2.jdField_a_of_type_Float * 1.0F / 2.0F);
            int i1 = (int)(localObject2.c * 1.6F - m * localObject2.jdField_a_of_type_Float * 1.0F / 2.0F);
            float f = localObject2.b;
            i2 = (int)(i2 * localObject2.jdField_a_of_type_Float * 1.0F / 2.0F + f * 1.8F);
            f = localObject2.c;
            localDrawable.setBounds(n, i1, i2, (int)(m * localObject2.jdField_a_of_type_Float * 1.0F / 2.0F + f * 1.6F));
            if (localObject2.jdField_a_of_type_Boolean)
            {
              localDrawable.setAlpha(128);
              localDrawable.setColorFilter(this.jdField_a_of_type_Int, PorterDuff.Mode.MULTIPLY);
            }
            localDrawable.draw(paramCanvas);
          }
          catch (Exception localException) {}
        }
      }
      paramCanvas.restoreToCount(j);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        continue;
        label352:
        i += 1;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessNewsBgView
 * JD-Core Version:    0.7.0.1
 */