package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.widget.QQViewPager;

class EmoticonMainPanel$7
  implements Runnable
{
  EmoticonMainPanel$7(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter);
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(i, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.7
 * JD-Core Version:    0.7.0.1
 */