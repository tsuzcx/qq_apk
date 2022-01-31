package com.tencent.mobileqq.leba.view;

import aejw;
import aejx;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup.LayoutParams;
import com.tencent.biz.troopgift.RadioButtonIndicator;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.troop.widget.RedDotAnimateView;
import com.tencent.qphone.base.util.QLog;

public class LebaGridIndicator
  extends RadioButtonIndicator
  implements View.OnClickListener
{
  private LebaGridIndicator.onPageSeletedListener a;
  public int[] a;
  public int c;
  
  public LebaGridIndicator(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ArrayOfInt = new int[5];
  }
  
  public LebaGridIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ArrayOfInt = new int[5];
  }
  
  public RadioButton a(int paramInt)
  {
    aejx localaejx = new aejx(this, getContext());
    if (AppSetting.b) {
      localaejx.setContentDescription("第" + (paramInt + 1) + "页");
    }
    localaejx.setButtonDrawable(this.jdField_a_of_type_Int);
    localaejx.setPadding(10, 0, 10, 0);
    localaejx.setClickable(true);
    return localaejx;
  }
  
  public RedDotAnimateView a(RadioButton paramRadioButton, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramRadioButton != null)
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < this.b)
        {
          removeView(paramRadioButton);
          localObject1 = new RedDotAnimateView(getContext());
          int i = (int)TypedValue.applyDimension(1, 7.5F, getContext().getResources().getDisplayMetrics());
          paramRadioButton = new RadioGroup.LayoutParams(i, i);
          paramRadioButton.gravity = 16;
          paramRadioButton.rightMargin = AIOUtils.a(5.0F, getContext().getResources());
          ((RedDotAnimateView)localObject1).setTag(Integer.valueOf(paramInt));
          ((RedDotAnimateView)localObject1).setStaticRedDot(i, i);
          ((RedDotAnimateView)localObject1).setVisibleAndZeroRadius();
          addView((View)localObject1, paramInt, paramRadioButton);
          ((RedDotAnimateView)localObject1).setContentDescription("第" + (paramInt + 1) + "页有更新");
          ((RedDotAnimateView)localObject1).setOnClickListener(new aejw(this, paramInt));
          this.jdField_a_of_type_ArrayOfInt[paramInt] = 1;
        }
      }
    }
    return localObject1;
  }
  
  public void a(int paramInt)
  {
    View localView = getChildAt(paramInt);
    if ((localView != null) && ((localView instanceof RedDotAnimateView)))
    {
      removeView(localView);
      addView(a(paramInt), paramInt);
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ArrayOfInt.length)) {
        this.jdField_a_of_type_ArrayOfInt[paramInt] = 0;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(i);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.b)) {
      return;
    }
    Object localObject2 = getChildAt(paramInt);
    Object localObject1 = null;
    if ((localObject2 instanceof RedDotAnimateView))
    {
      removeView((View)localObject2);
      localObject1 = a(paramInt);
      addView((View)localObject1, paramInt);
    }
    if ((localObject2 instanceof RadioButton)) {
      localObject1 = (RadioButton)localObject2;
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((RadioButton)localObject1).setChecked(true);
      }
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] == 1) {
        this.jdField_a_of_type_ArrayOfInt[paramInt] = 2;
      }
      if (this.c == paramInt) {
        break;
      }
      localObject1 = getChildAt(this.c);
      if ((localObject1 instanceof RadioButton))
      {
        localObject1 = (RadioButton)localObject1;
        if (this.jdField_a_of_type_ArrayOfInt[this.c] == 2)
        {
          localObject2 = a((RadioButton)localObject1, this.c);
          if (localObject2 != null) {
            ((RedDotAnimateView)localObject2).c();
          }
          this.jdField_a_of_type_ArrayOfInt[this.c] = 1;
        }
        ((RadioButton)localObject1).setChecked(false);
      }
      this.c = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator$onPageSeletedListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator$onPageSeletedListener.a(paramInt);
      return;
    }
  }
  
  public void setButtonToNormal(int paramInt)
  {
    boolean bool = true;
    Object localObject = getChildAt(paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ArrayOfInt.length))
    {
      if ((this.jdField_a_of_type_ArrayOfInt[paramInt] == 1) && ((localObject instanceof RedDotAnimateView)))
      {
        removeView((View)localObject);
        addView(a(paramInt), paramInt);
      }
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 0;
    }
    if ((localObject instanceof RadioButton))
    {
      localObject = (RadioButton)localObject;
      if (paramInt != this.c) {
        break label86;
      }
    }
    for (;;)
    {
      ((RadioButton)localObject).setChecked(bool);
      return;
      label86:
      bool = false;
    }
  }
  
  public void setButtonToRed(int paramInt)
  {
    Object localObject = getChildAt(paramInt);
    if (((localObject instanceof RadioButton)) && (paramInt != this.c))
    {
      localObject = a((RadioButton)localObject, paramInt);
      if (localObject != null) {
        ((RedDotAnimateView)localObject).c();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LebaGridIndicator", 2, "set " + paramInt + " to red dot");
    }
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ArrayOfInt.length))
    {
      if (paramInt == this.c) {
        this.jdField_a_of_type_ArrayOfInt[paramInt] = 2;
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ArrayOfInt[paramInt] = 1;
  }
  
  public void setButtonToRedDotAndPlayAnimation(int paramInt)
  {
    Object localObject = getChildAt(paramInt);
    if (paramInt == this.c)
    {
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 2;
      return;
    }
    if ((localObject instanceof RedDotAnimateView))
    {
      ((RedDotAnimateView)localObject).b();
      return;
    }
    if ((localObject instanceof RadioButton)) {}
    for (localObject = (RadioButton)localObject;; localObject = null)
    {
      localObject = a((RadioButton)localObject, paramInt);
      if (localObject == null) {
        break;
      }
      ((RedDotAnimateView)localObject).b();
      return;
    }
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
    if (paramViewPager != null) {
      paramViewPager.setOnPageChangeListener(this);
    }
  }
  
  public void setmOnPageSelectedListener(LebaGridIndicator.onPageSeletedListener paramonPageSeletedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator$onPageSeletedListener = paramonPageSeletedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.LebaGridIndicator
 * JD-Core Version:    0.7.0.1
 */