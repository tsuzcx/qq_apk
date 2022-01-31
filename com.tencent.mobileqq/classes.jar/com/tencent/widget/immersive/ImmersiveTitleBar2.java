package com.tencent.widget.immersive;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class ImmersiveTitleBar2
  extends View
{
  public static boolean a;
  public static boolean b;
  public int a;
  private int b;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
  }
  
  public ImmersiveTitleBar2(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ImmersiveTitleBar2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ImmersiveTitleBar2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public void a(int paramInt)
  {
    setBackgroundColor(paramInt);
  }
  
  public void a(Context paramContext)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("status", 2, "ImmersiveTitleBar initUI");
    }
    if ((jdField_a_of_type_Boolean) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      jdField_b_of_type_Boolean = bool;
      this.jdField_b_of_type_Int = ImmersiveUtils.a(paramContext);
      if (!jdField_b_of_type_Boolean) {
        break label74;
      }
      setCustomHeight(this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break label82;
      }
      setBackgroundResource(2130845871);
      return;
      bool = false;
      break;
      label74:
      setCustomHeight(0);
    }
    label82:
    setBackgroundColor(getResources().getColor(2131494254));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.jdField_a_of_type_Int);
  }
  
  public void setCustomHeight(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.immersive.ImmersiveTitleBar2
 * JD-Core Version:    0.7.0.1
 */