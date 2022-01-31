package com.tencent.mobileqq.pic;

import aump;
import aune;
import aunn;
import aunt;
import auob;
import auoq;
import axqf;
import ayvv;
import aywa;
import aywe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;

public class BasePicOprerator$3
  implements Runnable
{
  public BasePicOprerator$3(aump paramaump, aunt paramaunt) {}
  
  public void run()
  {
    aunn localaunn = this.a.jdField_a_of_type_Aunn;
    aune.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      localaunn.a("doForward", "rec==null");
      this.this$0.a(4, localaunn.jdField_a_of_type_Aunp);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = localaunn.jdField_a_of_type_Auob.g;
    aump.a(this.this$0, this.a, ((MessageForPic)localObject1).uniseq);
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null) {
      ((MessageForPic)localObject1).picExtraData = this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    auoq.b((CompressInfo)localObject2);
    aywe localaywe;
    if (((CompressInfo)localObject2).jdField_e_of_type_JavaLangString != null)
    {
      if (axqf.a())
      {
        ((MessageForPic)localObject1).bigThumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
        ((MessageForPic)localObject1).thumbWidth = ((CompressInfo)localObject2).d;
        ((MessageForPic)localObject1).thumbHeight = ((CompressInfo)localObject2).jdField_e_of_type_Int;
      }
    }
    else
    {
      ((MessageForPic)localObject1).serial();
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, ((MessageForPic)localObject1).msgData);
      localObject2 = new aywa();
      ((aywa)localObject2).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((aywa)localObject2).c = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((aywa)localObject2).d = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((aywa)localObject2).jdField_a_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((aywa)localObject2).jdField_b_of_type_Int = 1;
      ((aywa)localObject2).jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((aywa)localObject2).jdField_a_of_type_Boolean = true;
      ((aywa)localObject2).jdField_e_of_type_Int = localaunn.jdField_a_of_type_Auob.jdField_a_of_type_Int;
      ((aywa)localObject2).i = localaunn.jdField_a_of_type_Auob.g;
      localaywe = new aywe();
      if (localaunn.jdField_a_of_type_Auob.l != 1) {
        break label486;
      }
    }
    label486:
    for (boolean bool = true;; bool = false)
    {
      localaywe.jdField_a_of_type_Boolean = bool;
      ((aywa)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject1);
      ((aywa)localObject2).jdField_a_of_type_JavaLangObject = localaywe;
      ((aywa)localObject2).jdField_a_of_type_Auoo = this.this$0;
      localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      ((ayvv)localObject1).a(((aywa)localObject2).c + ((aywa)localObject2).jdField_a_of_type_Long);
      ((ayvv)localObject1).a((aywa)localObject2);
      this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localaunn.jdField_a_of_type_Auob.h);
      aune.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "end");
      return;
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.3
 * JD-Core Version:    0.7.0.1
 */