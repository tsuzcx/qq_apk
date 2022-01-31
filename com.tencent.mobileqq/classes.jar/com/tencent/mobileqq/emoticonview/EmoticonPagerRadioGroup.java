package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import apqe;
import apur;
import com.tencent.common.config.AppSetting;

public class EmoticonPagerRadioGroup
  extends RadioGroup
  implements ViewPager.OnPageChangeListener
{
  private static int d = 1;
  private static int e = 2;
  private int jdField_a_of_type_Int;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener;
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  RadioButton jdField_a_of_type_AndroidWidgetRadioButton = a(2);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  RadioButton jdField_b_of_type_AndroidWidgetRadioButton = a(3);
  private int jdField_c_of_type_Int;
  RadioButton jdField_c_of_type_AndroidWidgetRadioButton = a(4);
  
  public EmoticonPagerRadioGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmoticonPagerRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private RadioButton a(int paramInt)
  {
    float f1 = 13.0F;
    float f2 = 10.0F;
    apqe localapqe = new apqe(this, getContext());
    Resources localResources;
    if (paramInt == 2)
    {
      localapqe.setButtonDrawable(2130846603);
      localapqe.setGravity(17);
      localResources = super.getContext().getResources();
      if (paramInt != 2) {
        break label209;
      }
      f1 = 15.0F;
      f2 = 15.0F;
    }
    for (;;)
    {
      RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams((int)TypedValue.applyDimension(1, f1, localResources.getDisplayMetrics()), (int)TypedValue.applyDimension(1, f2, localResources.getDisplayMetrics()));
      localLayoutParams.gravity = 17;
      int i = (int)TypedValue.applyDimension(1, 3.0F, localResources.getDisplayMetrics());
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = i;
      localapqe.setLayoutParams(localLayoutParams);
      localapqe.setClickable(true);
      if ((AppSetting.c) && (paramInt != 3) && (paramInt != 2))
      {
        localapqe.setClickable(false);
        localapqe.setFocusable(false);
      }
      return localapqe;
      if (paramInt == 3)
      {
        localapqe.setButtonDrawable(2130846604);
        break;
      }
      if (paramInt == 4)
      {
        localapqe.setButtonDrawable(2130838495);
        break;
      }
      localapqe.setButtonDrawable(2130839458);
      break;
      label209:
      if (paramInt == 3) {
        f1 = 24.0F;
      } else if (paramInt == 4) {
        f2 = 13.0F;
      } else {
        f1 = 10.0F;
      }
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    super.removeView(this.jdField_a_of_type_AndroidWidgetRadioButton);
    super.removeView(this.jdField_b_of_type_AndroidWidgetRadioButton);
    removeAllViews();
    if (paramBoolean) {
      super.addView(this.jdField_c_of_type_AndroidWidgetRadioButton);
    }
    this.jdField_b_of_type_Int = -1;
    int j = getChildCount();
    int i;
    if (paramInt > j)
    {
      i = 0;
      while (i < paramInt - j)
      {
        super.addView(a(1));
        i += 1;
      }
    }
    if (paramInt < j)
    {
      i = j - 1;
      while (i >= paramInt)
      {
        super.removeViewAt(i);
        i -= 1;
      }
    }
    if ((paramInt > 0) && (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null))
    {
      RadioButton localRadioButton = (RadioButton)super.getChildAt(0);
      if (!paramBoolean) {
        localRadioButton.setButtonDrawable(2130839458);
      }
      localRadioButton = (RadioButton)super.getChildAt(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
      if (localRadioButton != null) {
        localRadioButton.setChecked(true);
      }
    }
    paramInt = 0;
    while (paramInt < getChildCount())
    {
      ((RadioButton)super.getChildAt(paramInt)).setVisibility(0);
      paramInt += 1;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(int paramInt)
  {
    int j = 0;
    this.jdField_a_of_type_Int = paramInt;
    if (!this.jdField_a_of_type_Boolean)
    {
      removeAllViews();
      int k = apur.h;
      int m = Math.max(apur.h, paramInt);
      super.addView(this.jdField_b_of_type_AndroidWidgetRadioButton);
      int i = 0;
      while (i < m)
      {
        super.addView(a(1));
        i += 1;
      }
      super.addView(this.jdField_a_of_type_AndroidWidgetRadioButton);
      i = j;
      while (i < k + paramInt - m - 2)
      {
        RadioButton localRadioButton = a(1);
        localRadioButton.setVisibility(8);
        super.addView(localRadioButton);
        i += 1;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageSelected(paramInt);
    }
    int j;
    int k;
    int i;
    RadioButton localRadioButton;
    if (super.getChildCount() > paramInt)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label372;
      }
      j = apur.h;
      k = this.jdField_a_of_type_Int;
      if (((this.jdField_b_of_type_Int != j) || (paramInt != j - 1)) && (paramInt != 0)) {
        break label232;
      }
      this.jdField_b_of_type_AndroidWidgetRadioButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(0);
      if (j > k)
      {
        i = k + 1;
        while (i <= j)
        {
          localRadioButton = (RadioButton)super.getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(0);
          }
          i += 1;
        }
      }
      if (j < k)
      {
        i = j + 1;
        while (i <= k)
        {
          localRadioButton = (RadioButton)super.getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(8);
          }
          i += 1;
        }
      }
      this.jdField_c_of_type_Int = e;
      if (this.jdField_c_of_type_Int != e) {
        break label363;
      }
      i = paramInt + 1;
      label188:
      this.jdField_b_of_type_Int = paramInt;
    }
    for (;;)
    {
      paramInt = i;
      if (i >= super.getChildCount()) {
        paramInt = super.getChildCount() - 1;
      }
      localRadioButton = (RadioButton)super.getChildAt(paramInt);
      if (localRadioButton != null) {
        localRadioButton.setChecked(true);
      }
      return;
      label232:
      if ((paramInt != j) && (paramInt != j + k - 1)) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetRadioButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(8);
      if (j > k)
      {
        i = k + 1;
        while (i <= j)
        {
          localRadioButton = (RadioButton)super.getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(8);
          }
          i += 1;
        }
      }
      if (j < k)
      {
        i = j + 1;
        while (i <= k)
        {
          localRadioButton = (RadioButton)super.getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(0);
          }
          i += 1;
        }
      }
      this.jdField_c_of_type_Int = d;
      break;
      label363:
      i = paramInt - (j - 1);
      break label188;
      label372:
      this.jdField_b_of_type_Int = -1;
      i = paramInt;
    }
  }
  
  public void setPagerChangedListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
    if (paramViewPager != null) {
      paramViewPager.setOnPageChangeListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup
 * JD-Core Version:    0.7.0.1
 */