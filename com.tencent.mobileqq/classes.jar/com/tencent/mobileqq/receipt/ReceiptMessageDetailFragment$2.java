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
    if (this.b.isAdded())
    {
      ReceiptMessageDetailFragment localReceiptMessageDetailFragment = this.b;
      localReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment.getBaseActivity(), ReceiptMessageDetailFragment.b(this.b), this.a, ReceiptMessageDetailFragment.c(this.b));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.2
 * JD-Core Version:    0.7.0.1
 */