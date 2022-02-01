package com.tencent.mobileqq.pic;

import aywt;
import ayxi;
import ayxr;
import ayxx;
import ayyg;
import ayyz;
import bcsc;
import bdzi;
import bdzn;
import bdzr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;

public class BasePicOprerator$2
  implements Runnable
{
  public BasePicOprerator$2(aywt paramaywt, ayxr paramayxr, ayxx paramayxx) {}
  
  public void run()
  {
    ayxi.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      this.jdField_a_of_type_Ayxr.a("doFastForward", "rec==null");
      this.this$0.a(4, this.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayxt);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = this.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString;
    aywt.a(this.this$0, this.jdField_a_of_type_Ayxx, ((MessageForPic)localObject1).uniseq);
    if (this.jdField_a_of_type_Ayxx.a != null) {
      ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_Ayxx.a;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    ayyz.b((CompressInfo)localObject2);
    if (((CompressInfo)localObject2).jdField_e_of_type_JavaLangString != null)
    {
      if (bcsc.a())
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
      localObject1 = new bdzn();
      ((bdzn)localObject1).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((bdzn)localObject1).c = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((bdzn)localObject1).d = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((bdzn)localObject1).jdField_a_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((bdzn)localObject1).jdField_b_of_type_Int = 1;
      ((bdzn)localObject1).jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((bdzn)localObject1).jdField_a_of_type_Boolean = true;
      ((bdzn)localObject1).jdField_e_of_type_Int = this.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayyg.jdField_a_of_type_Int;
      ((bdzn)localObject1).i = this.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString;
      localObject2 = new bdzr();
      if (this.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayyg.l != 1) {
        break label462;
      }
    }
    label462:
    for (boolean bool = true;; bool = false)
    {
      ((bdzr)localObject2).jdField_a_of_type_Boolean = bool;
      ((bdzn)localObject1).jdField_a_of_type_JavaLangObject = localObject2;
      ((bdzn)localObject1).jdField_a_of_type_Ayyt = this.this$0;
      ((bdzn)localObject1).h = true;
      if ((this.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayyg.f != null) && (this.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayyg.j != 0) && (this.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayyg.k != 0) && (this.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayyg.c != 0L)) {
        break label467;
      }
      this.jdField_a_of_type_Ayxr.a("doFastForward", "upInfo uncomplete!");
      this.this$0.a(4, this.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayxt);
      return;
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
      break;
    }
    label467:
    ((bdzn)localObject1).f = this.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayyg.f;
    ayxi.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", " Get width/height/filesize from UploadInfo");
    ((bdzn)localObject1).l = this.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayyg.j;
    ((bdzn)localObject1).m = this.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayyg.k;
    ((bdzn)localObject1).jdField_e_of_type_Long = this.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayyg.c;
    localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    ((bdzi)localObject2).a(((bdzn)localObject1).c + ((bdzn)localObject1).jdField_a_of_type_Long);
    ((bdzi)localObject2).a((bdzn)localObject1);
    this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayyg.jdField_g_of_type_Long);
    ayxi.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "end, req.mFastForwardWidth = " + ((bdzn)localObject1).l + ",req.mFastForwardHeight = " + ((bdzn)localObject1).m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.2
 * JD-Core Version:    0.7.0.1
 */