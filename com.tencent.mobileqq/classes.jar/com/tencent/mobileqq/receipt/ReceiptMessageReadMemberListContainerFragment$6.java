package com.tencent.mobileqq.receipt;

import bbai;
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
    MessageRecord localMessageRecord = ReceiptMessageReadMemberListContainerFragment.a(this.this$0).a().b(ReceiptMessageReadMemberListContainerFragment.a(this.this$0).jdField_a_of_type_JavaLangString, ReceiptMessageReadMemberListContainerFragment.a(this.this$0).jdField_a_of_type_Int, ReceiptMessageReadMemberListContainerFragment.c(this.this$0));
    if (ReceiptMessageReadMemberListContainerFragment.a(this.this$0).size() == 0) {
      bbai.a(ReceiptMessageReadMemberListContainerFragment.a(this.this$0), localMessageRecord, "3");
    }
    while (ReceiptMessageReadMemberListContainerFragment.b(this.this$0).size() <= 0) {
      return;
    }
    bbai.a(ReceiptMessageReadMemberListContainerFragment.a(this.this$0), localMessageRecord, "4");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.6
 * JD-Core Version:    0.7.0.1
 */