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
import com.tencent.mobileqq.theme.ThemeUtil;
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
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_b_of_type_Boolean;
  private int c = 0;
  private int d = 13;
  private int e = 13;
  private int f;
  
  public RedDotImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedDotImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RedDotImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)) {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130850321);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, " showRedDot() : " + this.jdField_b_of_type_Int + ",isShownBorder" + this.jdField_b_of_type_Boolean + "，this = " + this);
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
    if ((QLog.isColorLevel()) && (toString().contains("qq_aio_panel_image"))) {
      QLog.d("Q.recent", 2, " onDraw() : " + this.jdField_b_of_type_Int + ",isShownBorder" + this.jdField_b_of_type_Boolean + "，this = " + this);
    }
    int j;
    int i;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setState(getDrawableState());
      if (this.c != 0) {
        break label385;
      }
      j = (int)Math.ceil(getWidth() * 0.5D + this.jdField_b_of_type_Float * this.d - this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() * 0.5D);
      i = (int)Math.ceil(getHeight() * 0.5D - this.jdField_b_of_type_Float * this.e - this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() * 0.5D);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(j, i, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() + j, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + i);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      if ((this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(getDrawableState());
        i = getWidth();
        if (i <= this.jdField_a_of_type_Int * 2) {
          break label463;
        }
      }
      label385:
      label463:
      for (i = (int)Math.ceil(i / 2);; i = (int)Math.ceil(i - this.jdField_a_of_type_Int - this.f))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i, 0, this.jdField_a_of_type_Int + i, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        j = (int)Math.ceil(this.jdField_a_of_type_AndroidGraphicsPaint.measureText(String.valueOf(this.jdField_b_of_type_Int)));
        int k = this.jdField_b_of_type_Int;
        double d1 = i;
        paramCanvas.drawText(String.valueOf(k), (int)((this.jdField_a_of_type_Int - j) * 0.5D + d1), (int)(this.jdField_a_of_type_Int - this.jdField_a_of_type_Float * 0.5D), this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
        if (this.c != 1) {
          break label485;
        }
        j = (int)Math.ceil(getWidth() + this.jdField_b_of_type_Float * this.d - this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() * 0.5D);
        i = (int)Math.ceil(-this.jdField_b_of_type_Float * this.e - this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() * 0.5D);
        break;
      }
      label485:
      i = 0;
      j = 0;
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, " setUnreadNumber() : " + paramInt + ",isShownBorder" + this.jdField_b_of_type_Boolean + "，this = " + this);
    }
    if ((paramInt > 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_a_of_type_Int = ((int)(this.jdField_b_of_type_Float * 20.0F));
      this.f = ((int)(this.jdField_b_of_type_Float * 6.0F));
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1509949441);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_b_of_type_Float * 12.0F);
      Paint.FontMetrics localFontMetrics = new Paint.FontMetrics();
      this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics(localFontMetrics);
      this.jdField_a_of_type_Float = Math.abs(localFontMetrics.ascent);
      if (!this.jdField_b_of_type_Boolean) {
        break label219;
      }
    }
    label219:
    for (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130845587);; this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130849722))
    {
      this.jdField_b_of_type_Int = paramInt;
      postInvalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RedDotImageView
 * JD-Core Version:    0.7.0.1
 */