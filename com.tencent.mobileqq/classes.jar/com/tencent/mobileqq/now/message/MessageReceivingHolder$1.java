package com.tencent.mobileqq.now.message;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.now.widget.DecoratorViewPager;

class MessageReceivingHolder$1
  implements ViewPager.OnPageChangeListener
{
  private boolean b = false;
  
  MessageReceivingHolder$1(MessageReceivingHolder paramMessageReceivingHolder) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if ((paramInt1 == 2) && (paramFloat > 0.4F))
    {
      if (this.b)
      {
        this.b = false;
        MessageReceivingHolder.a(this.a);
      }
      MessageReceivingHolder.b(this.a).setCurrentItem(2);
    }
    if (paramFloat == 0.0F) {
      this.b = true;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    MessageReceivingHolder.a(this.a, paramInt);
    MessageReceivingHolder localMessageReceivingHolder = this.a;
    MessageReceivingHolder.a(localMessageReceivingHolder, MessageReceivingHolder.c(localMessageReceivingHolder).a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.MessageReceivingHolder.1
 * JD-Core Version:    0.7.0.1
 */