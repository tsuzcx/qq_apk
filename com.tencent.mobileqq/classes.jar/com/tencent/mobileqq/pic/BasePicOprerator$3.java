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

public class BasePicOprerator$3
  implements Runnable
{
  public BasePicOprerator$3(aywt paramaywt, ayxx paramayxx) {}
  
  public void run()
  {
    ayxr localayxr = this.a.jdField_a_of_type_Ayxr;
    ayxi.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      localayxr.a("doForward", "rec==null");
      this.this$0.a(4, localayxr.jdField_a_of_type_Ayxt);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = localayxr.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString;
    aywt.a(this.this$0, this.a, ((MessageForPic)localObject1).uniseq);
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null) {
      ((MessageForPic)localObject1).picExtraData = this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    ayyz.b((CompressInfo)localObject2);
    bdzr localbdzr;
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
      localObject2 = new bdzn();
      ((bdzn)localObject2).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((bdzn)localObject2).c = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((bdzn)localObject2).d = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((bdzn)localObject2).jdField_a_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((bdzn)localObject2).jdField_b_of_type_Int = 1;
      ((bdzn)localObject2).jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((bdzn)localObject2).jdField_a_of_type_Boolean = true;
      ((bdzn)localObject2).jdField_e_of_type_Int = localayxr.jdField_a_of_type_Ayyg.jdField_a_of_type_Int;
      ((bdzn)localObject2).i = localayxr.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString;
      localbdzr = new bdzr();
      if (localayxr.jdField_a_of_type_Ayyg.l != 1) {
        break label486;
      }
    }
    label486:
    for (boolean bool = true;; bool = false)
    {
      localbdzr.jdField_a_of_type_Boolean = bool;
      ((bdzn)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject1);
      ((bdzn)localObject2).jdField_a_of_type_JavaLangObject = localbdzr;
      ((bdzn)localObject2).jdField_a_of_type_Ayyt = this.this$0;
      localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      ((bdzi)localObject1).a(((bdzn)localObject2).c + ((bdzn)localObject2).jdField_a_of_type_Long);
      ((bdzi)localObject1).a((bdzn)localObject2);
      this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localayxr.jdField_a_of_type_Ayyg.jdField_g_of_type_Long);
      ayxi.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "end");
      return;
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.3
 * JD-Core Version:    0.7.0.1
 */