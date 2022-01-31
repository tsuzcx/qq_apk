package com.tencent.mobileqq.pic;

import awdy;
import awen;
import awew;
import awfc;
import awfl;
import awga;
import azls;
import batw;
import baub;
import bauf;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;

public class BasePicOprerator$2
  implements Runnable
{
  public BasePicOprerator$2(awdy paramawdy, awew paramawew, awfc paramawfc) {}
  
  public void run()
  {
    awen.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      this.jdField_a_of_type_Awew.a("doFastForward", "rec==null");
      this.this$0.a(4, this.jdField_a_of_type_Awew.jdField_a_of_type_Awey);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = this.jdField_a_of_type_Awew.jdField_a_of_type_Awfl.g;
    awdy.a(this.this$0, this.jdField_a_of_type_Awfc, ((MessageForPic)localObject1).uniseq);
    if (this.jdField_a_of_type_Awfc.a != null) {
      ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_Awfc.a;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    awga.b((CompressInfo)localObject2);
    if (((CompressInfo)localObject2).jdField_e_of_type_JavaLangString != null)
    {
      if (azls.a())
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
      localObject1 = new baub();
      ((baub)localObject1).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((baub)localObject1).c = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((baub)localObject1).d = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((baub)localObject1).jdField_a_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((baub)localObject1).jdField_b_of_type_Int = 1;
      ((baub)localObject1).jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((baub)localObject1).jdField_a_of_type_Boolean = true;
      ((baub)localObject1).jdField_e_of_type_Int = this.jdField_a_of_type_Awew.jdField_a_of_type_Awfl.jdField_a_of_type_Int;
      ((baub)localObject1).i = this.jdField_a_of_type_Awew.jdField_a_of_type_Awfl.g;
      localObject2 = new bauf();
      if (this.jdField_a_of_type_Awew.jdField_a_of_type_Awfl.l != 1) {
        break label462;
      }
    }
    label462:
    for (boolean bool = true;; bool = false)
    {
      ((bauf)localObject2).jdField_a_of_type_Boolean = bool;
      ((baub)localObject1).jdField_a_of_type_JavaLangObject = localObject2;
      ((baub)localObject1).jdField_a_of_type_Awfy = this.this$0;
      ((baub)localObject1).h = true;
      if ((this.jdField_a_of_type_Awew.jdField_a_of_type_Awfl.f != null) && (this.jdField_a_of_type_Awew.jdField_a_of_type_Awfl.j != 0) && (this.jdField_a_of_type_Awew.jdField_a_of_type_Awfl.k != 0) && (this.jdField_a_of_type_Awew.jdField_a_of_type_Awfl.c != 0L)) {
        break label467;
      }
      this.jdField_a_of_type_Awew.a("doFastForward", "upInfo uncomplete!");
      this.this$0.a(4, this.jdField_a_of_type_Awew.jdField_a_of_type_Awey);
      return;
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
      break;
    }
    label467:
    ((baub)localObject1).f = this.jdField_a_of_type_Awew.jdField_a_of_type_Awfl.f;
    awen.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", " Get width/height/filesize from UploadInfo");
    ((baub)localObject1).l = this.jdField_a_of_type_Awew.jdField_a_of_type_Awfl.j;
    ((baub)localObject1).m = this.jdField_a_of_type_Awew.jdField_a_of_type_Awfl.k;
    ((baub)localObject1).jdField_e_of_type_Long = this.jdField_a_of_type_Awew.jdField_a_of_type_Awfl.c;
    localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    ((batw)localObject2).a(((baub)localObject1).c + ((baub)localObject1).jdField_a_of_type_Long);
    ((batw)localObject2).a((baub)localObject1);
    this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Awew.jdField_a_of_type_Awfl.h);
    awen.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "end, req.mFastForwardWidth = " + ((baub)localObject1).l + ",req.mFastForwardHeight = " + ((baub)localObject1).m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.2
 * JD-Core Version:    0.7.0.1
 */