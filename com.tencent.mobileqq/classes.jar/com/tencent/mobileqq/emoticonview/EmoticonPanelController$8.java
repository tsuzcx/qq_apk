package com.tencent.mobileqq.emoticonview;

class EmoticonPanelController$8
  implements Runnable
{
  EmoticonPanelController$8(EmoticonPanelController paramEmoticonPanelController) {}
  
  public void run()
  {
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.getCurrentItem();
    this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setAdapter(this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter);
    this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setCurrentItem(i, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelController.8
 * JD-Core Version:    0.7.0.1
 */