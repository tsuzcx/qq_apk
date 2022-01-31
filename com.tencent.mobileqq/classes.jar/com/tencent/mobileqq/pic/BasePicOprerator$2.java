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

public class BasePicOprerator$2
  implements Runnable
{
  public BasePicOprerator$2(ator paramator, atpp paramatpp, atpv paramatpv) {}
  
  public void run()
  {
    atpg.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      this.jdField_a_of_type_Atpp.a("doFastForward", "rec==null");
      this.this$0.a(4, this.jdField_a_of_type_Atpp.jdField_a_of_type_Atpr);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = this.jdField_a_of_type_Atpp.jdField_a_of_type_Atqd.g;
    ator.a(this.this$0, this.jdField_a_of_type_Atpv, ((MessageForPic)localObject1).uniseq);
    if (this.jdField_a_of_type_Atpv.a != null) {
      ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_Atpv.a;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    atqs.b((CompressInfo)localObject2);
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
      localObject1 = new axvt();
      ((axvt)localObject1).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((axvt)localObject1).c = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((axvt)localObject1).d = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((axvt)localObject1).jdField_a_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((axvt)localObject1).jdField_b_of_type_Int = 1;
      ((axvt)localObject1).jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((axvt)localObject1).jdField_a_of_type_Boolean = true;
      ((axvt)localObject1).jdField_e_of_type_Int = this.jdField_a_of_type_Atpp.jdField_a_of_type_Atqd.jdField_a_of_type_Int;
      ((axvt)localObject1).i = this.jdField_a_of_type_Atpp.jdField_a_of_type_Atqd.g;
      localObject2 = new axvx();
      if (this.jdField_a_of_type_Atpp.jdField_a_of_type_Atqd.l != 1) {
        break label462;
      }
    }
    label462:
    for (boolean bool = true;; bool = false)
    {
      ((axvx)localObject2).jdField_a_of_type_Boolean = bool;
      ((axvt)localObject1).jdField_a_of_type_JavaLangObject = localObject2;
      ((axvt)localObject1).jdField_a_of_type_Atqq = this.this$0;
      ((axvt)localObject1).h = true;
      if ((this.jdField_a_of_type_Atpp.jdField_a_of_type_Atqd.f != null) && (this.jdField_a_of_type_Atpp.jdField_a_of_type_Atqd.j != 0) && (this.jdField_a_of_type_Atpp.jdField_a_of_type_Atqd.k != 0) && (this.jdField_a_of_type_Atpp.jdField_a_of_type_Atqd.c != 0L)) {
        break label467;
      }
      this.jdField_a_of_type_Atpp.a("doFastForward", "upInfo uncomplete!");
      this.this$0.a(4, this.jdField_a_of_type_Atpp.jdField_a_of_type_Atpr);
      return;
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
      break;
    }
    label467:
    ((axvt)localObject1).f = this.jdField_a_of_type_Atpp.jdField_a_of_type_Atqd.f;
    atpg.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", " Get width/height/filesize from UploadInfo");
    ((axvt)localObject1).l = this.jdField_a_of_type_Atpp.jdField_a_of_type_Atqd.j;
    ((axvt)localObject1).m = this.jdField_a_of_type_Atpp.jdField_a_of_type_Atqd.k;
    ((axvt)localObject1).jdField_e_of_type_Long = this.jdField_a_of_type_Atpp.jdField_a_of_type_Atqd.c;
    localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    ((axvo)localObject2).a(((axvt)localObject1).c + ((axvt)localObject1).jdField_a_of_type_Long);
    ((axvo)localObject2).a((axvt)localObject1);
    this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Atpp.jdField_a_of_type_Atqd.h);
    atpg.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "end, req.mFastForwardWidth = " + ((axvt)localObject1).l + ",req.mFastForwardHeight = " + ((axvt)localObject1).m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.2
 * JD-Core Version:    0.7.0.1
 */