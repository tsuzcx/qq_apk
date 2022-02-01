package com.tencent.mobileqq.qqgamepub.web.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
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
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.qqgamepub.listener.IPageListener;
import java.util.ArrayList;
import java.util.List;

public class QQGameIndicator2
  extends RadioGroup
  implements ViewPager.OnPageChangeListener
{
  public ViewPager a;
  private IPageListener a;
  
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
    while (i < paramInt2)
    {
      RadioButton localRadioButton = (RadioButton)super.getChildAt(i);
      if (localRadioButton != null) {
        if (i == paramInt1) {
          localRadioButton.setTextColor(-1);
        } else {
          localRadioButton.setTextColor(Color.parseColor("#9B9B9B"));
        }
      }
      i += 1;
    }
  }
  
  public RadioButton a(int paramInt1, int paramInt2)
  {
    QQGameIndicator2.1 local1 = new QQGameIndicator2.1(this, super.getContext());
    local1.setButtonDrawable(null);
    local1.setId(2131375962 + paramInt1);
    local1.setBackgroundResource(2130846484);
    local1.setGravity(17);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("");
    local1.setText(((StringBuilder)localObject).toString());
    if (paramInt2 + 1 == paramInt1)
    {
      local1.setTextColor(-1);
      local1.setChecked(true);
    }
    else
    {
      local1.setTextColor(Color.parseColor("#9B9B9B"));
    }
    local1.setTextSize(12.0F);
    localObject = super.getContext().getResources();
    RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams((int)TypedValue.applyDimension(1, 20.0F, ((Resources)localObject).getDisplayMetrics()), (int)TypedValue.applyDimension(1, 20.0F, ((Resources)localObject).getDisplayMetrics()));
    localLayoutParams.gravity = 17;
    paramInt1 = (int)TypedValue.applyDimension(1, 2.0F, ((Resources)localObject).getDisplayMetrics());
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.rightMargin = paramInt1;
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
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
    if (localObject != null)
    {
      localObject = getChildAt(((ViewPager)localObject).getCurrentItem());
      if (localObject == null) {
        return;
      }
      float f = ((View)localObject).getLeft();
      localObject = new ArrayList();
      int k = 0;
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
    IPageListener localIPageListener = this.jdField_a_of_type_ComTencentMobileqqQqgamepubListenerIPageListener;
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
    localObject = ((ViewPager)localObject).getAdapter();
    if (localObject == null) {
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
    RadioButton localRadioButton = (RadioButton)super.getChildAt(i);
    if (localRadioButton != null) {
      localRadioButton.setChecked(true);
    }
    a(i, ((PagerAdapter)localObject).getCount());
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqgamepubListenerIPageListener;
    if (localObject != null) {
      ((IPageListener)localObject).a(paramInt);
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
  
  public void setPageListener(IPageListener paramIPageListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubListenerIPageListener = paramIPageListener;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.view.QQGameIndicator2
 * JD-Core Version:    0.7.0.1
 */