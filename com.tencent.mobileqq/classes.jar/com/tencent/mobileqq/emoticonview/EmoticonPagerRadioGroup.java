package com.tencent.mobileqq.emoticonview;

import acng;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import com.tencent.common.config.AppSetting;

public class EmoticonPagerRadioGroup
  extends RadioGroup
  implements ViewPager.OnPageChangeListener
{
  private static int jdField_c_of_type_Int = 1;
  private static int d = 2;
  private int jdField_a_of_type_Int = -1;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener;
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  RadioButton jdField_a_of_type_AndroidWidgetRadioButton = a(2);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  RadioButton jdField_b_of_type_AndroidWidgetRadioButton = a(3);
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
    acng localacng = new acng(this, getContext());
    Resources localResources;
    if (paramInt == 2)
    {
      localacng.setButtonDrawable(2130844045);
      localacng.setGravity(17);
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
      localacng.setLayoutParams(localLayoutParams);
      localacng.setClickable(true);
      if ((AppSetting.b) && (paramInt != 3) && (paramInt != 2))
      {
        localacng.setClickable(false);
        localacng.setFocusable(false);
      }
      return localacng;
      if (paramInt == 3)
      {
        localacng.setButtonDrawable(2130844046);
        break;
      }
      if (paramInt == 4)
      {
        localacng.setButtonDrawable(2130838157);
        break;
      }
      localacng.setButtonDrawable(2130838910);
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
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, false);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    int j;
    RadioButton localRadioButton;
    if (paramBoolean1)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        removeAllViews();
        j = SystemAndEmojiEmoticonInfo.g;
        int k = SystemAndEmojiEmoticonInfo.f;
        int m = Math.max(SystemAndEmojiEmoticonInfo.g, SystemAndEmojiEmoticonInfo.f);
        super.addView(this.jdField_b_of_type_AndroidWidgetRadioButton);
        paramInt = 0;
        while (paramInt < m)
        {
          super.addView(a(1));
          paramInt += 1;
        }
        super.addView(this.jdField_a_of_type_AndroidWidgetRadioButton);
        paramInt = i;
        while (paramInt < k + j - m - 2)
        {
          localRadioButton = a(1);
          localRadioButton.setVisibility(8);
          super.addView(localRadioButton);
          paramInt += 1;
        }
      }
    }
    else
    {
      super.removeView(this.jdField_a_of_type_AndroidWidgetRadioButton);
      super.removeView(this.jdField_b_of_type_AndroidWidgetRadioButton);
      removeAllViews();
      if (paramBoolean2) {
        super.addView(this.jdField_c_of_type_AndroidWidgetRadioButton);
      }
      this.jdField_a_of_type_Int = -1;
      j = getChildCount();
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
        localRadioButton = (RadioButton)super.getChildAt(0);
        if (!paramBoolean2) {
          localRadioButton.setButtonDrawable(2130838910);
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
    }
    this.jdField_a_of_type_Boolean = paramBoolean1;
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
        break label371;
      }
      j = SystemAndEmojiEmoticonInfo.g;
      k = SystemAndEmojiEmoticonInfo.f;
      if (((this.jdField_a_of_type_Int != j) || (paramInt != j - 1)) && (paramInt != 0)) {
        break label231;
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
      this.jdField_b_of_type_Int = d;
      if (this.jdField_b_of_type_Int != d) {
        break label362;
      }
      i = paramInt + 1;
      label187:
      this.jdField_a_of_type_Int = paramInt;
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
      label231:
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
      this.jdField_b_of_type_Int = jdField_c_of_type_Int;
      break;
      label362:
      i = paramInt - (j - 1);
      break label187;
      label371:
      this.jdField_a_of_type_Int = -1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup
 * JD-Core Version:    0.7.0.1
 */