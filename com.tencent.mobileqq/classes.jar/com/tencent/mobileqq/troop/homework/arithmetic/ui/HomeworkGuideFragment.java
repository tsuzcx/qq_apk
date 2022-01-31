package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bbza;
import bbzb;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.troop.homework.arithmetic.data.HWGuideItem;
import java.util.ArrayList;
import java.util.List;

public class HomeworkGuideFragment
  extends IphoneTitleBarFragment
{
  protected ViewPager a;
  protected TextView a;
  protected DotStyleNavBar a;
  public ArrayList<HWGuideItem> a;
  protected List<bbzb> a;
  
  public HomeworkGuideFragment()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_JavaUtilArrayList = getArguments().getParcelableArrayList("EXTRA_GUIDE_ITEM_LIST");
    paramLayoutInflater = getArguments().getString("EXTRA_GO_BUTTON_TXT");
    paramViewGroup = getArguments().getString("EXTRA_TITLE_TXT");
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.mContentView.findViewById(2131379941));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiDotStyleNavBar = ((DotStyleNavBar)this.mContentView.findViewById(2131365408));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131363596));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(new HomeworkGuideFragment.ContentAdapter(this, getActivity()));
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter().getCount() > 1) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiDotStyleNavBar.setViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiDotStyleNavBar.setOnPageChangeListener(new HomeworkGuideFragment.PagerListener(this));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramLayoutInflater);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bbza(this));
      setTitle(paramViewGroup);
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiDotStyleNavBar.setVisibility(4);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131560458;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.HomeworkGuideFragment
 * JD-Core Version:    0.7.0.1
 */