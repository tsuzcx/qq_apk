package com.tencent.mobileqq.receipt;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;

class ReceiptMessageReadMemberListContainerFragment$6
  implements Runnable
{
  ReceiptMessageReadMemberListContainerFragment$6(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = ReceiptMessageReadMemberListContainerFragment.c(this.this$0).getMessageFacade().b(ReceiptMessageReadMemberListContainerFragment.h(this.this$0).b, ReceiptMessageReadMemberListContainerFragment.h(this.this$0).a, ReceiptMessageReadMemberListContainerFragment.i(this.this$0));
    if (ReceiptMessageReadMemberListContainerFragment.j(this.this$0).size() == 0)
    {
      ReceiptMsgManager.a(ReceiptMessageReadMemberListContainerFragment.c(this.this$0), localMessageRecord, "3");
      return;
    }
    if (ReceiptMessageReadMemberListContainerFragment.k(this.this$0).size() > 0) {
      ReceiptMsgManager.a(ReceiptMessageReadMemberListContainerFragment.c(this.this$0), localMessageRecord, "4");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.6
 * JD-Core Version:    0.7.0.1
 */