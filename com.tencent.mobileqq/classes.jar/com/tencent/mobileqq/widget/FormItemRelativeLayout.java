package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import bclw;
import com.tencent.mobileqq.theme.ThemeUtil;

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
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(bclw.c);
    setBackgroundDrawable(a(getResources(), this.jdField_a_of_type_Int));
  }
  
  public static Drawable a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (jdField_a_of_type_Boolean) {
        return paramResources.getDrawable(2130839169);
      }
      return paramResources.getDrawable(2130849239);
    }
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130839169);
    case 0: 
      if (jdField_a_of_type_Boolean) {
        return paramResources.getDrawable(2130839169);
      }
      return paramResources.getDrawable(2130849239);
    case 1: 
      if (jdField_a_of_type_Boolean) {
        return paramResources.getDrawable(2130839179);
      }
      return paramResources.getDrawable(2130849253);
    case 2: 
      if (jdField_a_of_type_Boolean) {
        return paramResources.getDrawable(2130839179);
      }
      return paramResources.getDrawable(2130849253);
    }
    if (jdField_a_of_type_Boolean) {
      return paramResources.getDrawable(2130839176);
    }
    return paramResources.getDrawable(2130849244);
  }
  
  private boolean a()
  {
    return ("1000".equals(ThemeUtil.curThemeId)) || ("999".equals(ThemeUtil.curThemeId));
  }
  
  protected Drawable a(Resources paramResources, int paramInt)
  {
    return a(paramResources, paramInt, a());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2))
    {
      if (!a()) {
        break label73;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(bclw.c);
    }
    for (;;)
    {
      int i = getMeasuredWidth();
      int j = getMeasuredHeight();
      this.jdField_a_of_type_AndroidGraphicsRect.set(bclw.d, j - bclw.b, i, j);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      label73:
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormItemRelativeLayout
 * JD-Core Version:    0.7.0.1
 */