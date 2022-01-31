package com.tencent.mobileqq.pic;

import awih;
import awiw;
import awjf;
import awjl;
import awju;
import awkj;
import azqb;
import bayf;
import bayk;
import bayo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;

public class BasePicOprerator$2
  implements Runnable
{
  public BasePicOprerator$2(awih paramawih, awjf paramawjf, awjl paramawjl) {}
  
  public void run()
  {
    awiw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      this.jdField_a_of_type_Awjf.a("doFastForward", "rec==null");
      this.this$0.a(4, this.jdField_a_of_type_Awjf.jdField_a_of_type_Awjh);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = this.jdField_a_of_type_Awjf.jdField_a_of_type_Awju.g;
    awih.a(this.this$0, this.jdField_a_of_type_Awjl, ((MessageForPic)localObject1).uniseq);
    if (this.jdField_a_of_type_Awjl.a != null) {
      ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_Awjl.a;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    awkj.b((CompressInfo)localObject2);
    if (((CompressInfo)localObject2).jdField_e_of_type_JavaLangString != null)
    {
      if (azqb.a())
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
      localObject1 = new bayk();
      ((bayk)localObject1).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((bayk)localObject1).c = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((bayk)localObject1).d = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((bayk)localObject1).jdField_a_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((bayk)localObject1).jdField_b_of_type_Int = 1;
      ((bayk)localObject1).jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((bayk)localObject1).jdField_a_of_type_Boolean = true;
      ((bayk)localObject1).jdField_e_of_type_Int = this.jdField_a_of_type_Awjf.jdField_a_of_type_Awju.jdField_a_of_type_Int;
      ((bayk)localObject1).i = this.jdField_a_of_type_Awjf.jdField_a_of_type_Awju.g;
      localObject2 = new bayo();
      if (this.jdField_a_of_type_Awjf.jdField_a_of_type_Awju.l != 1) {
        break label462;
      }
    }
    label462:
    for (boolean bool = true;; bool = false)
    {
      ((bayo)localObject2).jdField_a_of_type_Boolean = bool;
      ((bayk)localObject1).jdField_a_of_type_JavaLangObject = localObject2;
      ((bayk)localObject1).jdField_a_of_type_Awkh = this.this$0;
      ((bayk)localObject1).h = true;
      if ((this.jdField_a_of_type_Awjf.jdField_a_of_type_Awju.f != null) && (this.jdField_a_of_type_Awjf.jdField_a_of_type_Awju.j != 0) && (this.jdField_a_of_type_Awjf.jdField_a_of_type_Awju.k != 0) && (this.jdField_a_of_type_Awjf.jdField_a_of_type_Awju.c != 0L)) {
        break label467;
      }
      this.jdField_a_of_type_Awjf.a("doFastForward", "upInfo uncomplete!");
      this.this$0.a(4, this.jdField_a_of_type_Awjf.jdField_a_of_type_Awjh);
      return;
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
      break;
    }
    label467:
    ((bayk)localObject1).f = this.jdField_a_of_type_Awjf.jdField_a_of_type_Awju.f;
    awiw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", " Get width/height/filesize from UploadInfo");
    ((bayk)localObject1).l = this.jdField_a_of_type_Awjf.jdField_a_of_type_Awju.j;
    ((bayk)localObject1).m = this.jdField_a_of_type_Awjf.jdField_a_of_type_Awju.k;
    ((bayk)localObject1).jdField_e_of_type_Long = this.jdField_a_of_type_Awjf.jdField_a_of_type_Awju.c;
    localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    ((bayf)localObject2).a(((bayk)localObject1).c + ((bayk)localObject1).jdField_a_of_type_Long);
    ((bayf)localObject2).a((bayk)localObject1);
    this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Awjf.jdField_a_of_type_Awju.h);
    awiw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "end, req.mFastForwardWidth = " + ((bayk)localObject1).l + ",req.mFastForwardHeight = " + ((bayk)localObject1).m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.2
 * JD-Core Version:    0.7.0.1
 */