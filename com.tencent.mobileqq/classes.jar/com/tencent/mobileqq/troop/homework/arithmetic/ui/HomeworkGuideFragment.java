package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import ajgg;
import ajgh;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import java.util.ArrayList;
import java.util.List;

public class HomeworkGuideFragment
  extends IphoneTitleBarFragment
{
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DotStyleNavBar jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiDotStyleNavBar;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  protected int a()
  {
    return 2130969908;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_JavaUtilArrayList = getArguments().getParcelableArrayList("EXTRA_GUIDE_ITEM_LIST");
    paramLayoutInflater = getArguments().getString("EXTRA_GO_BUTTON_TXT");
    paramViewGroup = getArguments().getString("EXTRA_TITLE_TXT");
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.e.findViewById(2131368444));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiDotStyleNavBar = ((DotStyleNavBar)this.e.findViewById(2131368445));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.e.findViewById(2131368446));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(new ajgh(this, getActivity()));
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter().getCount() > 1) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiDotStyleNavBar.setViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiDotStyleNavBar.setOnPageChangeListener(new HomeworkGuideFragment.PagerListener(this));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramLayoutInflater);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ajgg(this));
      a(paramViewGroup);
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiDotStyleNavBar.setVisibility(4);
    }
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.HomeworkGuideFragment
 * JD-Core Version:    0.7.0.1
 */