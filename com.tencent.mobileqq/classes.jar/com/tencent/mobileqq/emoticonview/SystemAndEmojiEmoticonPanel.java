package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import anxw;
import anyb;
import java.util.ArrayList;
import java.util.List;

public class SystemAndEmojiEmoticonPanel
  extends SystemEmoticonPanel
{
  public SystemAndEmojiEmoticonPanel(Context paramContext, anyb paramanyb)
  {
    super(paramContext, paramanyb);
  }
  
  protected void a(Context paramContext, anyb paramanyb)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)this.b.findViewById(2131374681));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.b.findViewById(2131379147));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter = new EmoticonPagerAdapter();
    ArrayList localArrayList = new ArrayList(1);
    paramContext = new anxw(paramContext, paramanyb, 9);
    localArrayList.add(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(localArrayList);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.b(paramContext.a());
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel
 * JD-Core Version:    0.7.0.1
 */