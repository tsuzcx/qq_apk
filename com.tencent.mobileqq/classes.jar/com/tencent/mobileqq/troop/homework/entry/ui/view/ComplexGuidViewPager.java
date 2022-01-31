package com.tencent.mobileqq.troop.homework.entry.ui.view;

import ajhz;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.troopgift.RadioButtonIndicator;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.troop.homework.config.HomeworkConfig.HomeWorkGuideInfo.PageInfo;
import java.util.ArrayList;

public class ComplexGuidViewPager
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener
{
  protected float a;
  protected int a;
  protected HorizontalScrollView a;
  protected ImageView a;
  protected TextView a;
  protected RadioButtonIndicator a;
  public ComplexGuidViewPager.OnGuideBtnClickListener a;
  protected GuideViewPager a;
  protected String a;
  protected ArrayList a;
  protected float b;
  protected int b;
  
  public ComplexGuidViewPager(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ComplexGuidViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ComplexGuidViewPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(2130970645, this, true);
    this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator = ((RadioButtonIndicator)findViewById(2131371550));
    this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator.setOrientation(0);
    this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator.setButtonResourceId(2130843350);
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131363769));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363265));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewGuideViewPager = ((GuideViewPager)findViewById(2131371549));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewGuideViewPager.setOnPagerSizeChangeListener(this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewGuideViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371548));
    this.jdField_a_of_type_Int = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ajhz(this));
  }
  
  public float a()
  {
    this.jdField_b_of_type_Float = ((this.jdField_b_of_type_Int - this.jdField_a_of_type_Int) / (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewGuideViewPager.a() - 1));
    this.jdField_a_of_type_Float = (this.jdField_b_of_type_Float / this.jdField_a_of_type_Int);
    return this.jdField_a_of_type_Float;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if ((this.jdField_a_of_type_Float == 0.0F) || (this.jdField_b_of_type_Int == 0))
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      a();
    }
    paramInt1 = (int)(paramInt1 * this.jdField_b_of_type_Float);
    paramInt2 = (int)(this.jdField_b_of_type_Float * paramFloat);
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.scrollTo(paramInt1 + paramInt2, 0);
  }
  
  public void onPageSelected(int paramInt)
  {
    AbstractGifImage.resumeAll();
    HomeworkConfig.HomeWorkGuideInfo.PageInfo localPageInfo = (HomeworkConfig.HomeWorkGuideInfo.PageInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator.onPageSelected(paramInt);
    RadioButtonIndicator localRadioButtonIndicator = this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator;
    if (localPageInfo.b) {}
    for (paramInt = 0;; paramInt = 8)
    {
      localRadioButtonIndicator.setVisibility(paramInt);
      return;
    }
  }
  
  public void setData(String paramString, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewGuideViewPager.setData(paramArrayList);
    GuideViewPager.setBitmapByPath(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_JavaLangString);
  }
  
  public void setOnActionBtnClickListener(ComplexGuidViewPager.OnGuideBtnClickListener paramOnGuideBtnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager$OnGuideBtnClickListener = paramOnGuideBtnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewGuideViewPager.setOnActionBtnClickListener(paramOnGuideBtnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.view.ComplexGuidViewPager
 * JD-Core Version:    0.7.0.1
 */