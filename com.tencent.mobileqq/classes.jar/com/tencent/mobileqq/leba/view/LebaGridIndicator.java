package com.tencent.mobileqq.leba.view;

import aebm;
import aebn;
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

public class LebaGridIndicator
  extends RadioButtonIndicator
  implements View.OnClickListener
{
  private LebaGridIndicator.onPageSeletedListener a;
  public int[] a;
  public int b;
  
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
    aebn localaebn = new aebn(this, getContext());
    if (AppSetting.b) {
      localaebn.setContentDescription("第" + (paramInt + 1) + "页");
    }
    localaebn.setButtonDrawable(this.jdField_a_of_type_Int);
    localaebn.setPadding(10, 0, 10, 0);
    localaebn.setClickable(true);
    return localaebn;
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
    if ((getChildAt(paramInt) instanceof RedDotAnimateView))
    {
      a(paramInt);
      if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator$onPageSeletedListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator$onPageSeletedListener.b(paramInt);
      }
    }
    Object localObject;
    if ((getChildAt(paramInt) instanceof RadioButton))
    {
      localObject = (RadioButton)getChildAt(paramInt);
      if (localObject != null) {
        ((RadioButton)localObject).setChecked(true);
      }
    }
    if (this.b != paramInt)
    {
      localObject = getChildAt(this.b);
      if ((localObject instanceof RadioButton)) {
        ((RadioButton)localObject).setChecked(false);
      }
      this.b = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator$onPageSeletedListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator$onPageSeletedListener.a(paramInt);
      }
    }
  }
  
  public void setButtonToRedDot(int paramInt)
  {
    Object localObject = getChildAt(paramInt);
    if (paramInt == this.b) {
      return;
    }
    if ((localObject instanceof RedDotAnimateView))
    {
      ((RedDotAnimateView)localObject).b();
      return;
    }
    removeViewAt(paramInt);
    localObject = new RedDotAnimateView(getContext());
    int i = (int)TypedValue.applyDimension(1, 7.5F, getContext().getResources().getDisplayMetrics());
    RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams(i, i);
    localLayoutParams.gravity = 16;
    localLayoutParams.rightMargin = AIOUtils.a(5.0F, getContext().getResources());
    ((RedDotAnimateView)localObject).setTag(Integer.valueOf(paramInt));
    addView((View)localObject, paramInt, localLayoutParams);
    ((RedDotAnimateView)localObject).setStaticRedDot(i, i);
    ((RedDotAnimateView)localObject).setVisibleAndZeroRadius();
    ((RedDotAnimateView)localObject).b();
    ((RedDotAnimateView)localObject).setContentDescription("第" + (paramInt + 1) + "页有更新");
    if ((paramInt > 0) && (paramInt < this.jdField_a_of_type_ArrayOfInt.length)) {
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 1;
    }
    ((RedDotAnimateView)localObject).setOnClickListener(new aebm(this, paramInt));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.LebaGridIndicator
 * JD-Core Version:    0.7.0.1
 */