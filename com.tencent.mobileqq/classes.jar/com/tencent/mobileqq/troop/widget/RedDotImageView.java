package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class RedDotImageView
  extends ImageView
{
  protected float a;
  protected int a;
  protected Paint a;
  protected Drawable a;
  private boolean a;
  private float jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
  protected int b;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
  private boolean jdField_b_of_type_Boolean = false;
  private int c = 0;
  private int d = 13;
  private int e = 13;
  private int f = 0;
  
  public RedDotImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedDotImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0.0F;
  }
  
  public RedDotImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0.0F;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)) {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130850766);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" showRedDot() : ");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        localStringBuilder.append(",isShownBorder");
        localStringBuilder.append(this.jdField_b_of_type_Boolean);
        localStringBuilder.append("，this = ");
        localStringBuilder.append(this);
        QLog.d("Q.recent", 2, localStringBuilder.toString());
      }
      postInvalidate();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject;
    if ((QLog.isColorLevel()) && (toString().contains("qq_aio_panel_image")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onDraw() : ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(",isShownBorder");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append("，this = ");
      ((StringBuilder)localObject).append(this);
      QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
    }
    int i;
    double d1;
    double d2;
    int j;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      if (localObject != null)
      {
        ((Drawable)localObject).setState(getDrawableState());
        i = this.c;
        double d3;
        if (i == 0)
        {
          d1 = getWidth();
          Double.isNaN(d1);
          d2 = this.jdField_b_of_type_Float * this.d;
          Double.isNaN(d2);
          d3 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
          Double.isNaN(d3);
          i = (int)Math.ceil(d1 * 0.5D + d2 - d3 * 0.5D);
          d1 = getHeight();
          Double.isNaN(d1);
          d2 = this.jdField_b_of_type_Float * this.e;
          Double.isNaN(d2);
          d3 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
          Double.isNaN(d3);
        }
        for (d1 = Math.ceil(d1 * 0.5D - d2 - d3 * 0.5D);; d1 = Math.ceil(d1 - d2 * 0.5D))
        {
          j = (int)d1;
          break label386;
          if (i != 1) {
            break;
          }
          d1 = getWidth() + this.jdField_b_of_type_Float * this.d;
          d2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
          Double.isNaN(d2);
          Double.isNaN(d1);
          i = (int)Math.ceil(d1 - d2 * 0.5D);
          d1 = -this.jdField_b_of_type_Float * this.e;
          d2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
          Double.isNaN(d2);
          Double.isNaN(d1);
        }
        i = 0;
        j = 0;
        label386:
        localObject = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        ((Drawable)localObject).setBounds(i, j, ((Drawable)localObject).getIntrinsicWidth() + i, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + j);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
    if (this.jdField_b_of_type_Int > 0)
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localObject != null)
      {
        ((Drawable)localObject).setState(getDrawableState());
        i = getWidth();
        j = this.jdField_a_of_type_Int;
        if (i > j * 2) {
          d1 = Math.ceil(i / 2);
        } else {
          d1 = Math.ceil(i - j - this.f);
        }
        i = (int)d1;
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        j = this.jdField_a_of_type_Int;
        ((Drawable)localObject).setBounds(i, 0, i + j, j);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        j = (int)Math.ceil(this.jdField_a_of_type_AndroidGraphicsPaint.measureText(String.valueOf(this.jdField_b_of_type_Int)));
        int k = this.jdField_b_of_type_Int;
        d1 = i;
        i = this.jdField_a_of_type_Int;
        d2 = i - j;
        Double.isNaN(d2);
        Double.isNaN(d1);
        float f1 = (int)(d1 + d2 * 0.5D);
        d1 = i;
        d2 = this.jdField_a_of_type_Float;
        Double.isNaN(d2);
        Double.isNaN(d1);
        paramCanvas.drawText(String.valueOf(k), f1, (int)(d1 - d2 * 0.5D), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  public void setRedDotBase(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      postInvalidate();
    }
  }
  
  public void setRedDotDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    }
  }
  
  public void setReddotXOffsetDp(int paramInt)
  {
    if (paramInt != this.d)
    {
      this.d = paramInt;
      postInvalidate();
    }
  }
  
  public void setReddotYOffsetDp(int paramInt)
  {
    if (paramInt != this.e)
    {
      this.e = paramInt;
      postInvalidate();
    }
  }
  
  public void setShowBorder(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setUnreadNumber(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" setUnreadNumber() : ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",isShownBorder");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append("，this = ");
      ((StringBuilder)localObject).append(this);
      QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt > 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      float f1 = this.jdField_b_of_type_Float;
      this.jdField_a_of_type_Int = ((int)(20.0F * f1));
      this.f = ((int)(f1 * 6.0F));
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1509949441);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_b_of_type_Float * 12.0F);
      localObject = new Paint.FontMetrics();
      this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics((Paint.FontMetrics)localObject);
      this.jdField_a_of_type_Float = Math.abs(((Paint.FontMetrics)localObject).ascent);
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130845865);
      } else {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130850140);
      }
    }
    this.jdField_b_of_type_Int = paramInt;
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RedDotImageView
 * JD-Core Version:    0.7.0.1
 */