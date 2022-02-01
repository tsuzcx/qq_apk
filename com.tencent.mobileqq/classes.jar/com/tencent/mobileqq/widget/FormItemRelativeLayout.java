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
  static boolean a = true;
  int b = 0;
  private final Rect c = new Rect();
  private final Paint d = new Paint();
  
  public FormItemRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormItemRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d.setAntiAlias(true);
    this.d.setColor(FormItemConstants.h);
    setBackgroundDrawable(a(getResources(), this.b));
  }
  
  public static Drawable a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (a) {
        return paramResources.getDrawable(2130839622);
      }
      return paramResources.getDrawable(2130852507);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return paramResources.getDrawable(2130839622);
          }
          if (a) {
            return paramResources.getDrawable(2130839629);
          }
          return paramResources.getDrawable(2130852512);
        }
        if (a) {
          return paramResources.getDrawable(2130839632);
        }
        return paramResources.getDrawable(2130852521);
      }
      if (a) {
        return paramResources.getDrawable(2130839632);
      }
      return paramResources.getDrawable(2130852521);
    }
    if (a) {
      return paramResources.getDrawable(2130839622);
    }
    return paramResources.getDrawable(2130852507);
  }
  
  private boolean a()
  {
    return QQTheme.isDefaultOrDIYTheme();
  }
  
  protected Drawable a(Resources paramResources, int paramInt)
  {
    return a(paramResources, paramInt, a());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = this.b;
    if ((i == 1) || (i == 2))
    {
      if (a()) {
        this.d.setColor(FormItemConstants.h);
      } else {
        this.d.setColor(0);
      }
      i = getMeasuredWidth();
      int j = getMeasuredHeight();
      this.c.set(FormItemConstants.i, j - FormItemConstants.g, i, j);
      paramCanvas.drawRect(this.c, this.d);
    }
  }
  
  public void setBGType(int paramInt)
  {
    this.b = paramInt;
    setBackgroundDrawable(a(getResources(), this.b));
  }
  
  public void setNeedFocusBg(boolean paramBoolean)
  {
    a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormItemRelativeLayout
 * JD-Core Version:    0.7.0.1
 */