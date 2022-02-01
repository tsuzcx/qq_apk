package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.utils.QQTheme;

public class FormItemRelativeLayout
  extends RelativeLayout
{
  static boolean jdField_a_of_type_Boolean = true;
  int jdField_a_of_type_Int = 0;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  
  public FormItemRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormItemRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(FormItemConstants.c);
    setBackgroundDrawable(a(getResources(), this.jdField_a_of_type_Int));
  }
  
  public static Drawable a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (jdField_a_of_type_Boolean) {
        return paramResources.getDrawable(2130839433);
      }
      return paramResources.getDrawable(2130850703);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return paramResources.getDrawable(2130839433);
          }
          if (jdField_a_of_type_Boolean) {
            return paramResources.getDrawable(2130839440);
          }
          return paramResources.getDrawable(2130850708);
        }
        if (jdField_a_of_type_Boolean) {
          return paramResources.getDrawable(2130839443);
        }
        return paramResources.getDrawable(2130850717);
      }
      if (jdField_a_of_type_Boolean) {
        return paramResources.getDrawable(2130839443);
      }
      return paramResources.getDrawable(2130850717);
    }
    if (jdField_a_of_type_Boolean) {
      return paramResources.getDrawable(2130839433);
    }
    return paramResources.getDrawable(2130850703);
  }
  
  private boolean a()
  {
    return QQTheme.b();
  }
  
  protected Drawable a(Resources paramResources, int paramInt)
  {
    return a(paramResources, paramInt, a());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = this.jdField_a_of_type_Int;
    if ((i == 1) || (i == 2))
    {
      if (a()) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(FormItemConstants.c);
      } else {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
      }
      i = getMeasuredWidth();
      int j = getMeasuredHeight();
      this.jdField_a_of_type_AndroidGraphicsRect.set(FormItemConstants.d, j - FormItemConstants.b, i, j);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setBGType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    setBackgroundDrawable(a(getResources(), this.jdField_a_of_type_Int));
  }
  
  public void setNeedFocusBg(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormItemRelativeLayout
 * JD-Core Version:    0.7.0.1
 */