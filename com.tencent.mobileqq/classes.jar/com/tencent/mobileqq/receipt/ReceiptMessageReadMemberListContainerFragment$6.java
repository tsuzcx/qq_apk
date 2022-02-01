package com.tencent.mobileqq.receipt;

import azuu;
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
    MessageRecord localMessageRecord = ReceiptMessageReadMemberListContainerFragment.a(this.this$0).getMessageFacade().queryMsgItemByUniseq(ReceiptMessageReadMemberListContainerFragment.a(this.this$0).curFriendUin, ReceiptMessageReadMemberListContainerFragment.a(this.this$0).curType, ReceiptMessageReadMemberListContainerFragment.c(this.this$0));
    if (ReceiptMessageReadMemberListContainerFragment.a(this.this$0).size() == 0) {
      azuu.a(ReceiptMessageReadMemberListContainerFragment.a(this.this$0), localMessageRecord, "3");
    }
    while (ReceiptMessageReadMemberListContainerFragment.b(this.this$0).size() <= 0) {
      return;
    }
    azuu.a(ReceiptMessageReadMemberListContainerFragment.a(this.this$0), localMessageRecord, "4");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.6
 * JD-Core Version:    0.7.0.1
 */