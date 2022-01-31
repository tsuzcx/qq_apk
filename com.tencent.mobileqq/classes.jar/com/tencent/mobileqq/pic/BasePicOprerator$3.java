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

public class BasePicOprerator$3
  implements Runnable
{
  public BasePicOprerator$3(awih paramawih, awjl paramawjl) {}
  
  public void run()
  {
    awjf localawjf = this.a.jdField_a_of_type_Awjf;
    awiw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      localawjf.a("doForward", "rec==null");
      this.this$0.a(4, localawjf.jdField_a_of_type_Awjh);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = localawjf.jdField_a_of_type_Awju.g;
    awih.a(this.this$0, this.a, ((MessageForPic)localObject1).uniseq);
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null) {
      ((MessageForPic)localObject1).picExtraData = this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    awkj.b((CompressInfo)localObject2);
    bayo localbayo;
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
      localObject2 = new bayk();
      ((bayk)localObject2).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((bayk)localObject2).c = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((bayk)localObject2).d = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((bayk)localObject2).jdField_a_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((bayk)localObject2).jdField_b_of_type_Int = 1;
      ((bayk)localObject2).jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((bayk)localObject2).jdField_a_of_type_Boolean = true;
      ((bayk)localObject2).jdField_e_of_type_Int = localawjf.jdField_a_of_type_Awju.jdField_a_of_type_Int;
      ((bayk)localObject2).i = localawjf.jdField_a_of_type_Awju.g;
      localbayo = new bayo();
      if (localawjf.jdField_a_of_type_Awju.l != 1) {
        break label486;
      }
    }
    label486:
    for (boolean bool = true;; bool = false)
    {
      localbayo.jdField_a_of_type_Boolean = bool;
      ((bayk)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject1);
      ((bayk)localObject2).jdField_a_of_type_JavaLangObject = localbayo;
      ((bayk)localObject2).jdField_a_of_type_Awkh = this.this$0;
      localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      ((bayf)localObject1).a(((bayk)localObject2).c + ((bayk)localObject2).jdField_a_of_type_Long);
      ((bayf)localObject1).a((bayk)localObject2);
      this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localawjf.jdField_a_of_type_Awju.h);
      awiw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "end");
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