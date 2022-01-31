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

public class BasePicOprerator$2
  implements Runnable
{
  public BasePicOprerator$2(aump paramaump, aunn paramaunn, aunt paramaunt) {}
  
  public void run()
  {
    aune.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      this.jdField_a_of_type_Aunn.a("doFastForward", "rec==null");
      this.this$0.a(4, this.jdField_a_of_type_Aunn.jdField_a_of_type_Aunp);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = this.jdField_a_of_type_Aunn.jdField_a_of_type_Auob.g;
    aump.a(this.this$0, this.jdField_a_of_type_Aunt, ((MessageForPic)localObject1).uniseq);
    if (this.jdField_a_of_type_Aunt.a != null) {
      ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_Aunt.a;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    auoq.b((CompressInfo)localObject2);
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
      localObject1 = new aywa();
      ((aywa)localObject1).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((aywa)localObject1).c = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((aywa)localObject1).d = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((aywa)localObject1).jdField_a_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((aywa)localObject1).jdField_b_of_type_Int = 1;
      ((aywa)localObject1).jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((aywa)localObject1).jdField_a_of_type_Boolean = true;
      ((aywa)localObject1).jdField_e_of_type_Int = this.jdField_a_of_type_Aunn.jdField_a_of_type_Auob.jdField_a_of_type_Int;
      ((aywa)localObject1).i = this.jdField_a_of_type_Aunn.jdField_a_of_type_Auob.g;
      localObject2 = new aywe();
      if (this.jdField_a_of_type_Aunn.jdField_a_of_type_Auob.l != 1) {
        break label462;
      }
    }
    label462:
    for (boolean bool = true;; bool = false)
    {
      ((aywe)localObject2).jdField_a_of_type_Boolean = bool;
      ((aywa)localObject1).jdField_a_of_type_JavaLangObject = localObject2;
      ((aywa)localObject1).jdField_a_of_type_Auoo = this.this$0;
      ((aywa)localObject1).h = true;
      if ((this.jdField_a_of_type_Aunn.jdField_a_of_type_Auob.f != null) && (this.jdField_a_of_type_Aunn.jdField_a_of_type_Auob.j != 0) && (this.jdField_a_of_type_Aunn.jdField_a_of_type_Auob.k != 0) && (this.jdField_a_of_type_Aunn.jdField_a_of_type_Auob.c != 0L)) {
        break label467;
      }
      this.jdField_a_of_type_Aunn.a("doFastForward", "upInfo uncomplete!");
      this.this$0.a(4, this.jdField_a_of_type_Aunn.jdField_a_of_type_Aunp);
      return;
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
      break;
    }
    label467:
    ((aywa)localObject1).f = this.jdField_a_of_type_Aunn.jdField_a_of_type_Auob.f;
    aune.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", " Get width/height/filesize from UploadInfo");
    ((aywa)localObject1).l = this.jdField_a_of_type_Aunn.jdField_a_of_type_Auob.j;
    ((aywa)localObject1).m = this.jdField_a_of_type_Aunn.jdField_a_of_type_Auob.k;
    ((aywa)localObject1).jdField_e_of_type_Long = this.jdField_a_of_type_Aunn.jdField_a_of_type_Auob.c;
    localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    ((ayvv)localObject2).a(((aywa)localObject1).c + ((aywa)localObject1).jdField_a_of_type_Long);
    ((ayvv)localObject2).a((aywa)localObject1);
    this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Aunn.jdField_a_of_type_Auob.h);
    aune.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "end, req.mFastForwardWidth = " + ((aywa)localObject1).l + ",req.mFastForwardHeight = " + ((aywa)localObject1).m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.2
 * JD-Core Version:    0.7.0.1
 */