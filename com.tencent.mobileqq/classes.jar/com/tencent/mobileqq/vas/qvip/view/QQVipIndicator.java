package com.tencent.mobileqq.vas.qvip.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

public class QQVipIndicator
  extends RadioGroup
  implements ViewPager.OnPageChangeListener
{
  public ViewPager a;
  private QQVipIndicator.IPageListener a;
  
  public QQVipIndicator(Context paramContext)
  {
    super(paramContext);
    super.setOrientation(0);
    super.setGravity(17);
  }
  
  public QQVipIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOrientation(0);
    super.setGravity(17);
  }
  
  public RadioButton a(int paramInt)
  {
    View localView = getChildAt(paramInt);
    if ((localView instanceof RadioButton)) {
      return (RadioButton)localView;
    }
    return null;
  }
  
  public RadioButton a(int paramInt1, int paramInt2)
  {
    QQVipIndicator.1 local1 = new QQVipIndicator.1(this, super.getContext());
    Resources localResources = super.getContext().getResources();
    RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams((int)TypedValue.applyDimension(1, 20.0F, localResources.getDisplayMetrics()), (int)TypedValue.applyDimension(1, 20.0F, localResources.getDisplayMetrics()));
    localLayoutParams.gravity = 17;
    int i = (int)TypedValue.applyDimension(1, 4.0F, localResources.getDisplayMetrics());
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    i = (int)TypedValue.applyDimension(1, 2.0F, localResources.getDisplayMetrics());
    localLayoutParams.bottomMargin = i;
    localLayoutParams.topMargin = i;
    local1.setButtonDrawable(null);
    local1.setBackgroundResource(2130847167);
    local1.setGravity(17);
    local1.setText(String.valueOf(paramInt1));
    if (paramInt2 + 1 == paramInt1) {
      local1.setTextColor(-1);
    } else {
      local1.setTextColor(Color.parseColor("#9B9B9B"));
    }
    local1.setTextSize(12.0F);
    local1.setTextColor(-1);
    local1.setLayoutParams(localLayoutParams);
    local1.setClickable(false);
    local1.setFocusable(false);
    return local1;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
    if (localObject == null) {
      return;
    }
    localObject = ((ViewPager)localObject).getAdapter();
    if (localObject == null) {
      return;
    }
    int k = ((PagerAdapter)localObject).getCount();
    super.removeAllViews();
    int j = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getCurrentItem();
    int i = 0;
    while (i < k)
    {
      i += 1;
      super.addView(a(i, j));
    }
    i = j;
    if (j >= super.getChildCount()) {
      i = super.getChildCount() - 1;
    }
    localObject = (RadioButton)super.getChildAt(i);
    if (localObject != null) {
      ((RadioButton)localObject).setChecked(true);
    }
    if (k <= 1)
    {
      super.setVisibility(4);
      return;
    }
    super.setVisibility(0);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    QQVipIndicator.IPageListener localIPageListener = this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator$IPageListener;
    if (localIPageListener != null) {
      localIPageListener.a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
    if (localObject == null) {
      return;
    }
    if (((ViewPager)localObject).getAdapter() == null) {
      return;
    }
    if (super.getChildCount() <= paramInt) {
      return;
    }
    int i;
    if (paramInt >= super.getChildCount()) {
      i = super.getChildCount() - 1;
    } else {
      i = paramInt;
    }
    localObject = (RadioButton)super.getChildAt(i);
    if (localObject != null) {
      ((RadioButton)localObject).setChecked(true);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator$IPageListener;
    if (localObject != null) {
      ((QQVipIndicator.IPageListener)localObject).a(paramInt);
    }
  }
  
  public void setCurrentIndex(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= super.getChildCount()) {
      i = super.getChildCount() - 1;
    }
    RadioButton localRadioButton = (RadioButton)super.getChildAt(i);
    if (localRadioButton != null) {
      localRadioButton.setChecked(true);
    }
  }
  
  public void setPageListener(QQVipIndicator.IPageListener paramIPageListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasQvipViewQQVipIndicator$IPageListener = paramIPageListener;
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = paramViewPager;
    paramViewPager = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
    if (paramViewPager != null) {
      paramViewPager.setOnPageChangeListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.QQVipIndicator
 * JD-Core Version:    0.7.0.1
 */