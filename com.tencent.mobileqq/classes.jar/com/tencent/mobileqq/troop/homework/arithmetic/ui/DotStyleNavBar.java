package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import ajgf;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;

public class DotStyleNavBar
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private int b;
  
  public DotStyleNavBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public DotStyleNavBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    int j = UIUtils.a(getContext(), 8.0F);
    int k = UIUtils.a(getContext(), 3.0F);
    int i = 0;
    if (i < this.jdField_a_of_type_Int)
    {
      ImageView localImageView = new ImageView(getContext());
      if (i == this.b) {
        localImageView.setImageResource(2130844685);
      }
      for (;;)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
        localLayoutParams.leftMargin = k;
        localLayoutParams.rightMargin = k;
        addView(localImageView, localLayoutParams);
        i += 1;
        break;
        localImageView.setImageResource(2130844686);
      }
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    removeAllViews();
    a();
  }
  
  private void b()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_Int)
    {
      ImageView localImageView = (ImageView)getChildAt(i);
      if (i == this.b) {
        localImageView.setImageResource(2130844685);
      }
      for (;;)
      {
        i += 1;
        break;
        localImageView.setImageResource(2130844686);
      }
    }
    postInvalidate();
  }
  
  public void setCurrent(int paramInt)
  {
    if (paramInt + 1 > this.jdField_a_of_type_Int) {
      paramInt = this.jdField_a_of_type_Int - 1;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      this.b = i;
      b();
      return;
    }
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
    a(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter().getCount());
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new ajgf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.DotStyleNavBar
 * JD-Core Version:    0.7.0.1
 */