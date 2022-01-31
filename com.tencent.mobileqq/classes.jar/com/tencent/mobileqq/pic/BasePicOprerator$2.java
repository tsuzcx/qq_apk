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

public class BasePicOprerator$2
  implements Runnable
{
  public BasePicOprerator$2(aumr paramaumr, aunp paramaunp, aunv paramaunv) {}
  
  public void run()
  {
    aung.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      this.jdField_a_of_type_Aunp.a("doFastForward", "rec==null");
      this.this$0.a(4, this.jdField_a_of_type_Aunp.jdField_a_of_type_Aunr);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = this.jdField_a_of_type_Aunp.jdField_a_of_type_Auod.g;
    aumr.a(this.this$0, this.jdField_a_of_type_Aunv, ((MessageForPic)localObject1).uniseq);
    if (this.jdField_a_of_type_Aunv.a != null) {
      ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_Aunv.a;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    auos.b((CompressInfo)localObject2);
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
      localObject1 = new aywc();
      ((aywc)localObject1).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((aywc)localObject1).c = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((aywc)localObject1).d = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((aywc)localObject1).jdField_a_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((aywc)localObject1).jdField_b_of_type_Int = 1;
      ((aywc)localObject1).jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((aywc)localObject1).jdField_a_of_type_Boolean = true;
      ((aywc)localObject1).jdField_e_of_type_Int = this.jdField_a_of_type_Aunp.jdField_a_of_type_Auod.jdField_a_of_type_Int;
      ((aywc)localObject1).i = this.jdField_a_of_type_Aunp.jdField_a_of_type_Auod.g;
      localObject2 = new aywg();
      if (this.jdField_a_of_type_Aunp.jdField_a_of_type_Auod.l != 1) {
        break label462;
      }
    }
    label462:
    for (boolean bool = true;; bool = false)
    {
      ((aywg)localObject2).jdField_a_of_type_Boolean = bool;
      ((aywc)localObject1).jdField_a_of_type_JavaLangObject = localObject2;
      ((aywc)localObject1).jdField_a_of_type_Auoq = this.this$0;
      ((aywc)localObject1).h = true;
      if ((this.jdField_a_of_type_Aunp.jdField_a_of_type_Auod.f != null) && (this.jdField_a_of_type_Aunp.jdField_a_of_type_Auod.j != 0) && (this.jdField_a_of_type_Aunp.jdField_a_of_type_Auod.k != 0) && (this.jdField_a_of_type_Aunp.jdField_a_of_type_Auod.c != 0L)) {
        break label467;
      }
      this.jdField_a_of_type_Aunp.a("doFastForward", "upInfo uncomplete!");
      this.this$0.a(4, this.jdField_a_of_type_Aunp.jdField_a_of_type_Aunr);
      return;
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
      break;
    }
    label467:
    ((aywc)localObject1).f = this.jdField_a_of_type_Aunp.jdField_a_of_type_Auod.f;
    aung.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", " Get width/height/filesize from UploadInfo");
    ((aywc)localObject1).l = this.jdField_a_of_type_Aunp.jdField_a_of_type_Auod.j;
    ((aywc)localObject1).m = this.jdField_a_of_type_Aunp.jdField_a_of_type_Auod.k;
    ((aywc)localObject1).jdField_e_of_type_Long = this.jdField_a_of_type_Aunp.jdField_a_of_type_Auod.c;
    localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    ((ayvx)localObject2).a(((aywc)localObject1).c + ((aywc)localObject1).jdField_a_of_type_Long);
    ((ayvx)localObject2).a((aywc)localObject1);
    this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Aunp.jdField_a_of_type_Auod.h);
    aung.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "end, req.mFastForwardWidth = " + ((aywc)localObject1).l + ",req.mFastForwardHeight = " + ((aywc)localObject1).m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.2
 * JD-Core Version:    0.7.0.1
 */