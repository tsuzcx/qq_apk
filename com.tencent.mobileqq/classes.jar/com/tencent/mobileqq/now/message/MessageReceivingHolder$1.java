package com.tencent.mobileqq.now.message;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.now.widget.DecoratorViewPager;

class MessageReceivingHolder$1
  implements ViewPager.OnPageChangeListener
{
  private boolean jdField_a_of_type_Boolean = false;
  
  MessageReceivingHolder$1(MessageReceivingHolder paramMessageReceivingHolder) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if ((paramInt1 == 2) && (paramFloat > 0.4F))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        MessageReceivingHolder.a(this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingHolder);
      }
      MessageReceivingHolder.a(this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingHolder).setCurrentItem(2);
    }
    if (paramFloat == 0.0F) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    MessageReceivingHolder.a(this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingHolder, paramInt);
    MessageReceivingHolder localMessageReceivingHolder = this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingHolder;
    MessageReceivingHolder.a(localMessageReceivingHolder, MessageReceivingHolder.a(localMessageReceivingHolder).a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.MessageReceivingHolder.1
 * JD-Core Version:    0.7.0.1
 */