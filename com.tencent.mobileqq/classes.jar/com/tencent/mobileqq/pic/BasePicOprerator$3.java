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

public class BasePicOprerator$3
  implements Runnable
{
  public BasePicOprerator$3(awdy paramawdy, awfc paramawfc) {}
  
  public void run()
  {
    awew localawew = this.a.jdField_a_of_type_Awew;
    awen.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      localawew.a("doForward", "rec==null");
      this.this$0.a(4, localawew.jdField_a_of_type_Awey);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = localawew.jdField_a_of_type_Awfl.g;
    awdy.a(this.this$0, this.a, ((MessageForPic)localObject1).uniseq);
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null) {
      ((MessageForPic)localObject1).picExtraData = this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    awga.b((CompressInfo)localObject2);
    bauf localbauf;
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
      localObject2 = new baub();
      ((baub)localObject2).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((baub)localObject2).c = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((baub)localObject2).d = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((baub)localObject2).jdField_a_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((baub)localObject2).jdField_b_of_type_Int = 1;
      ((baub)localObject2).jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((baub)localObject2).jdField_a_of_type_Boolean = true;
      ((baub)localObject2).jdField_e_of_type_Int = localawew.jdField_a_of_type_Awfl.jdField_a_of_type_Int;
      ((baub)localObject2).i = localawew.jdField_a_of_type_Awfl.g;
      localbauf = new bauf();
      if (localawew.jdField_a_of_type_Awfl.l != 1) {
        break label486;
      }
    }
    label486:
    for (boolean bool = true;; bool = false)
    {
      localbauf.jdField_a_of_type_Boolean = bool;
      ((baub)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject1);
      ((baub)localObject2).jdField_a_of_type_JavaLangObject = localbauf;
      ((baub)localObject2).jdField_a_of_type_Awfy = this.this$0;
      localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      ((batw)localObject1).a(((baub)localObject2).c + ((baub)localObject2).jdField_a_of_type_Long);
      ((batw)localObject1).a((baub)localObject2);
      this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localawew.jdField_a_of_type_Awfl.h);
      awen.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "end");
      return;
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.3
 * JD-Core Version:    0.7.0.1
 */