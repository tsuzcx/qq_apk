package com.tencent.mobileqq.data;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MessageForNewGrayTips$1
  implements View.OnClickListener
{
  MessageForNewGrayTips$1(MessageForNewGrayTips paramMessageForNewGrayTips, GrayTipsSpan paramGrayTipsSpan) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForNewGrayTips.click(paramView, this.jdField_a_of_type_ComTencentMobileqqDataGrayTipsSpan.url);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNewGrayTips.1
 * JD-Core Version:    0.7.0.1
 */