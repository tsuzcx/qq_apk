package com.tencent.mobileqq.receipt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReceiptMessageDetailFragment$2
  implements View.OnClickListener
{
  ReceiptMessageDetailFragment$2(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment, MessageForPic paramMessageForPic) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageDetailFragment.isAdded())
    {
      ReceiptMessageDetailFragment localReceiptMessageDetailFragment = this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageDetailFragment;
      localReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment.getBaseActivity(), ReceiptMessageDetailFragment.a(this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageDetailFragment), this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, ReceiptMessageDetailFragment.a(this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageDetailFragment));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.2
 * JD-Core Version:    0.7.0.1
 */