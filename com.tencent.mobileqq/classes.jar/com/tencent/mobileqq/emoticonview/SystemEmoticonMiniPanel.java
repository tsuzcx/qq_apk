package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import anyg;
import aocy;
import java.util.ArrayList;
import java.util.List;

public class SystemEmoticonMiniPanel
  extends SystemEmoticonPanel
{
  protected void a(Context paramContext, anyg paramanyg)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)this.b.findViewById(2131374683));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.b.findViewById(2131379152));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter = new EmoticonPagerAdapter();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new aocy(paramContext, paramanyg, 0, this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(localArrayList);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.getCount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemEmoticonMiniPanel
 * JD-Core Version:    0.7.0.1
 */