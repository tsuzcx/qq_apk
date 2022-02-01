package com.tencent.mobileqq.gamecenter.web.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class QQGameIndicator2
  extends RadioGroup
  implements ViewPager.OnPageChangeListener
{
  public ViewPager a;
  private QQGameIndicator2.IPageListener a;
  
  public QQGameIndicator2(Context paramContext)
  {
    super(paramContext);
    super.setOrientation(0);
    super.setGravity(17);
  }
  
  public QQGameIndicator2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOrientation(0);
    super.setGravity(17);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < paramInt2)
    {
      RadioButton localRadioButton = (RadioButton)super.getChildAt(i);
      if (localRadioButton != null)
      {
        if (i != paramInt1) {
          break label40;
        }
        localRadioButton.setTextColor(-1);
      }
      for (;;)
      {
        i += 1;
        break;
        label40:
        localRadioButton.setTextColor(Color.parseColor("#9B9B9B"));
      }
    }
  }
  
  public RadioButton a(int paramInt1, int paramInt2)
  {
    QQGameIndicator2.1 local1 = new QQGameIndicator2.1(this, super.getContext());
    local1.setButtonDrawable(null);
    local1.setId(2131376453 + paramInt1);
    local1.setBackgroundResource(2130846604);
    local1.setGravity(17);
    local1.setText(paramInt1 + "");
    if (paramInt2 + 1 == paramInt1) {
      local1.setTextColor(-1);
    }
    for (;;)
    {
      local1.setTextSize(12.0F);
      Resources localResources = super.getContext().getResources();
      RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams((int)TypedValue.applyDimension(1, 20.0F, localResources.getDisplayMetrics()), (int)TypedValue.applyDimension(1, 20.0F, localResources.getDisplayMetrics()));
      localLayoutParams.gravity = 17;
      paramInt1 = (int)TypedValue.applyDimension(1, 2.0F, localResources.getDisplayMetrics());
      localLayoutParams.leftMargin = paramInt1;
      localLayoutParams.rightMargin = paramInt1;
      local1.setLayoutParams(localLayoutParams);
      local1.setClickable(false);
      local1.setFocusable(false);
      return local1;
      local1.setTextColor(Color.parseColor("#9B9B9B"));
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter();
    } while (localObject == null);
    int k = ((PagerAdapter)localObject).getCount();
    super.removeAllViews();
    int j = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
    int i = 0;
    while (i < k)
    {
      super.addView(a(i + 1, j));
      i += 1;
    }
    i = j;
    if (j >= super.getChildCount()) {
      i = super.getChildCount() - 1;
    }
    Object localObject = (RadioButton)super.getChildAt(i);
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
  
  public void b()
  {
    int k = 0;
    Object localObject;
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null)
    {
      localObject = getChildAt(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
      if (localObject != null) {
        break label29;
      }
    }
    for (;;)
    {
      return;
      label29:
      float f = ((View)localObject).getLeft();
      localObject = new ArrayList();
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= getChildCount()) {
          break;
        }
        AnimationSet localAnimationSet = new AnimationSet(true);
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(f - getChildAt(i).getLeft(), 0.0F, 0.0F, 0.0F);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.8F, 1.0F);
        localAnimationSet.addAnimation(localTranslateAnimation);
        localAnimationSet.addAnimation(localAlphaAnimation);
        localAnimationSet.setDuration(250L);
        localAnimationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        ((List)localObject).add(localAnimationSet);
        i += 1;
      }
      while (j < getChildCount())
      {
        getChildAt(j).startAnimation((AnimationSet)((List)localObject).get(j));
        j += 1;
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2$IPageListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2$IPageListener.a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) {}
    PagerAdapter localPagerAdapter;
    do
    {
      return;
      localPagerAdapter = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter();
    } while ((localPagerAdapter == null) || (super.getChildCount() <= paramInt));
    if (paramInt >= super.getChildCount()) {}
    for (int i = super.getChildCount() - 1;; i = paramInt)
    {
      RadioButton localRadioButton = (RadioButton)super.getChildAt(i);
      if (localRadioButton != null) {
        localRadioButton.setChecked(true);
      }
      a(i, localPagerAdapter.getCount());
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2$IPageListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2$IPageListener.a(paramInt);
      return;
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
  
  public void setPageListener(QQGameIndicator2.IPageListener paramIPageListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2$IPageListener = paramIPageListener;
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.view.QQGameIndicator2
 * JD-Core Version:    0.7.0.1
 */