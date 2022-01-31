package com.tencent.mobileqq.pic;

import ator;
import atpg;
import atpp;
import atpv;
import atqd;
import atqs;
import awqg;
import axvo;
import axvt;
import axvx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;

public class BasePicOprerator$3
  implements Runnable
{
  public BasePicOprerator$3(ator paramator, atpv paramatpv) {}
  
  public void run()
  {
    atpp localatpp = this.a.jdField_a_of_type_Atpp;
    atpg.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      localatpp.a("doForward", "rec==null");
      this.this$0.a(4, localatpp.jdField_a_of_type_Atpr);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = localatpp.jdField_a_of_type_Atqd.g;
    ator.a(this.this$0, this.a, ((MessageForPic)localObject1).uniseq);
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null) {
      ((MessageForPic)localObject1).picExtraData = this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    atqs.b((CompressInfo)localObject2);
    axvx localaxvx;
    if (((CompressInfo)localObject2).jdField_e_of_type_JavaLangString != null)
    {
      if (awqg.a())
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
      localObject2 = new axvt();
      ((axvt)localObject2).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((axvt)localObject2).c = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((axvt)localObject2).d = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((axvt)localObject2).jdField_a_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((axvt)localObject2).jdField_b_of_type_Int = 1;
      ((axvt)localObject2).jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((axvt)localObject2).jdField_a_of_type_Boolean = true;
      ((axvt)localObject2).jdField_e_of_type_Int = localatpp.jdField_a_of_type_Atqd.jdField_a_of_type_Int;
      ((axvt)localObject2).i = localatpp.jdField_a_of_type_Atqd.g;
      localaxvx = new axvx();
      if (localatpp.jdField_a_of_type_Atqd.l != 1) {
        break label486;
      }
    }
    label486:
    for (boolean bool = true;; bool = false)
    {
      localaxvx.jdField_a_of_type_Boolean = bool;
      ((axvt)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject1);
      ((axvt)localObject2).jdField_a_of_type_JavaLangObject = localaxvx;
      ((axvt)localObject2).jdField_a_of_type_Atqq = this.this$0;
      localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      ((axvo)localObject1).a(((axvt)localObject2).c + ((axvt)localObject2).jdField_a_of_type_Long);
      ((axvo)localObject1).a((axvt)localObject2);
      this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localatpp.jdField_a_of_type_Atqd.h);
      atpg.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "end");
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