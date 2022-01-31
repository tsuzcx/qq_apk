package com.tencent.mobileqq.pic;

import aumr;
import aung;
import aunp;
import aunv;
import auod;
import auos;
import axqh;
import ayvx;
import aywc;
import aywg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;

public class BasePicOprerator$3
  implements Runnable
{
  public BasePicOprerator$3(aumr paramaumr, aunv paramaunv) {}
  
  public void run()
  {
    aunp localaunp = this.a.jdField_a_of_type_Aunp;
    aung.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      localaunp.a("doForward", "rec==null");
      this.this$0.a(4, localaunp.jdField_a_of_type_Aunr);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = localaunp.jdField_a_of_type_Auod.g;
    aumr.a(this.this$0, this.a, ((MessageForPic)localObject1).uniseq);
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null) {
      ((MessageForPic)localObject1).picExtraData = this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    auos.b((CompressInfo)localObject2);
    aywg localaywg;
    if (((CompressInfo)localObject2).jdField_e_of_type_JavaLangString != null)
    {
      if (axqh.a())
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
      localObject2 = new aywc();
      ((aywc)localObject2).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((aywc)localObject2).c = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((aywc)localObject2).d = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((aywc)localObject2).jdField_a_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((aywc)localObject2).jdField_b_of_type_Int = 1;
      ((aywc)localObject2).jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((aywc)localObject2).jdField_a_of_type_Boolean = true;
      ((aywc)localObject2).jdField_e_of_type_Int = localaunp.jdField_a_of_type_Auod.jdField_a_of_type_Int;
      ((aywc)localObject2).i = localaunp.jdField_a_of_type_Auod.g;
      localaywg = new aywg();
      if (localaunp.jdField_a_of_type_Auod.l != 1) {
        break label486;
      }
    }
    label486:
    for (boolean bool = true;; bool = false)
    {
      localaywg.jdField_a_of_type_Boolean = bool;
      ((aywc)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject1);
      ((aywc)localObject2).jdField_a_of_type_JavaLangObject = localaywg;
      ((aywc)localObject2).jdField_a_of_type_Auoq = this.this$0;
      localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      ((ayvx)localObject1).a(((aywc)localObject2).c + ((aywc)localObject2).jdField_a_of_type_Long);
      ((ayvx)localObject1).a((aywc)localObject2);
      this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localaunp.jdField_a_of_type_Auod.h);
      aung.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "end");
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