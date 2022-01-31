package com.tencent.mobileqq.leba.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.GridView;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.mobileqq.leba.header.GridMenuAdapter;
import com.tencent.mobileqq.theme.ThemeUtil;

public class LebaGridMenuView
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  public ViewPager a;
  private View jdField_a_of_type_AndroidViewView;
  public GridMenuAdapter a;
  public LebaGridIndicator a;
  private boolean jdField_a_of_type_Boolean;
  public boolean[] a;
  private int b;
  private int c;
  
  public LebaGridMenuView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[10];
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator != null) {
      return this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator.b;
    }
    return 0;
  }
  
  public View a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaHeaderGridMenuAdapter == null) {
      return null;
    }
    int i = paramInt / this.jdField_a_of_type_ComTencentMobileqqLebaHeaderGridMenuAdapter.d;
    int j = this.jdField_a_of_type_ComTencentMobileqqLebaHeaderGridMenuAdapter.d;
    View localView = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildAt(i);
    if ((localView instanceof GridView)) {}
    for (localView = ((GridView)localView).getChildAt(paramInt % j);; localView = null) {
      return localView;
    }
  }
  
  public void a()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    if (localLayoutInflater != null) {
      localLayoutInflater.inflate(2130970381, this);
    }
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131370311));
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator = ((LebaGridIndicator)findViewById(2131370312));
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559499);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369750);
    b();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator.a(paramInt);
    }
  }
  
  public boolean a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBoolean.length)
    {
      if (this.jdField_a_of_type_ArrayOfBoolean[i] != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int[] a()
  {
    int[] arrayOfInt = new int[10];
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator != null) {
      arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator.a;
    }
    return arrayOfInt;
  }
  
  public void b()
  {
    if (ThemeUtil.isNowThemeIsNight(PlayModeUtils.a(), false, null))
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#1D2A3D"));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#DEDFE0"));
  }
  
  public void c()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBoolean.length)
    {
      this.jdField_a_of_type_ArrayOfBoolean[i] = false;
      i += 1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.c = j;
      this.b = i;
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      int k = i - this.b;
      int m = j - this.c;
      if ((k > 20) || (k < -20)) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (((m > 20) || (m < -20)) && (!this.jdField_a_of_type_Boolean))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        continue;
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void setAdapter(GridMenuAdapter paramGridMenuAdapter, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator.setTag(paramString);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setTag(paramString);
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator.setViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    paramGridMenuAdapter.a(this.jdField_a_of_type_AndroidSupportV4ViewViewPager, this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator);
    this.jdField_a_of_type_ComTencentMobileqqLebaHeaderGridMenuAdapter = paramGridMenuAdapter;
  }
  
  public void setIndicatorListener(LebaGridIndicator.onPageSeletedListener paramonPageSeletedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator.setmOnPageSelectedListener(paramonPageSeletedListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.LebaGridMenuView
 * JD-Core Version:    0.7.0.1
 */