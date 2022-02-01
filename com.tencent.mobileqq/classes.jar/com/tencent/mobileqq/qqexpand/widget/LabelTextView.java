package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.widget.ThemeImageWrapper;
import com.tencent.widget.ThemeImageWrapper.DrawInterface;

public class LabelTextView
  extends TextView
  implements ThemeImageWrapper.DrawInterface
{
  private int jdField_a_of_type_Int = 2147483647;
  protected ThemeImageWrapper a;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public LabelTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LabelTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public LabelTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setMaxLines(1);
    setGravity(17);
    setSingleLine();
    setEllipsize(TextUtils.TruncateAt.END);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetThemeImageWrapper = new ThemeImageWrapper();
    this.jdField_a_of_type_ComTencentWidgetThemeImageWrapper.setSupportMaskView(true);
    this.jdField_a_of_type_ComTencentWidgetThemeImageWrapper.setMaskShape(ThemeImageWrapper.MODE_OTHER);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.b)
    {
      ThemeImageWrapper localThemeImageWrapper = this.jdField_a_of_type_ComTencentWidgetThemeImageWrapper;
      if (localThemeImageWrapper != null)
      {
        localThemeImageWrapper.onDraw(paramCanvas, this);
        return;
      }
    }
    super.draw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_Boolean) {
      if (getMeasuredWidth() < this.jdField_a_of_type_Int)
      {
        if (getVisibility() == 0) {
          setVisibility(8);
        }
      }
      else if (getVisibility() != 0) {
        setVisibility(0);
      }
    }
  }
  
  public void setMinWidthCheck(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public void setParam(int paramInt1, int paramInt2, float paramFloat)
  {
    setTextColor(paramInt2);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt1);
    localGradientDrawable.setCornerRadius(paramFloat);
    setBackgroundDrawable(localGradientDrawable);
  }
  
  public void superOnDraw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.LabelTextView
 * JD-Core Version:    0.7.0.1
 */