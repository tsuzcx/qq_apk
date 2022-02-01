package com.tencent.mobileqq.onlinestatus;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AutoReplyAdapter$4
  implements View.OnClickListener
{
  AutoReplyAdapter$4(AutoReplyAdapter paramAutoReplyAdapter, AutoReplyText paramAutoReplyText) {}
  
  public void onClick(View paramView)
  {
    if ((AutoReplyAdapter.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter) != null) && (paramView != null))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText.getTextId();
      AutoReplyAdapter.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter, (View)paramView.getParent(), i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyAdapter.4
 * JD-Core Version:    0.7.0.1
 */