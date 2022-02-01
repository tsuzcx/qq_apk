package com.tencent.mobileqq.pic;

import azpg;
import azpw;
import azqf;
import azqk;
import azqt;
import azrm;
import bdku;
import beyb;
import beyg;
import beyk;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;

public class BasePicOprerator$3
  implements Runnable
{
  public BasePicOprerator$3(azpg paramazpg, azqk paramazqk) {}
  
  public void run()
  {
    azqf localazqf = this.a.jdField_a_of_type_Azqf;
    azpw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      localazqf.a("doForward", "rec==null");
      this.this$0.a(4, localazqf.jdField_a_of_type_Azqh);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = localazqf.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString;
    azpg.a(this.this$0, this.a, ((MessageForPic)localObject1).uniseq);
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null) {
      ((MessageForPic)localObject1).picExtraData = this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    azrm.b((CompressInfo)localObject2);
    beyk localbeyk;
    if (((CompressInfo)localObject2).jdField_e_of_type_JavaLangString != null)
    {
      if (bdku.a())
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
      localObject2 = new beyg();
      ((beyg)localObject2).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((beyg)localObject2).c = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((beyg)localObject2).d = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((beyg)localObject2).jdField_a_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((beyg)localObject2).jdField_b_of_type_Int = 1;
      ((beyg)localObject2).jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((beyg)localObject2).jdField_a_of_type_Boolean = true;
      ((beyg)localObject2).jdField_e_of_type_Int = localazqf.jdField_a_of_type_Azqt.jdField_a_of_type_Int;
      ((beyg)localObject2).i = localazqf.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString;
      localbeyk = new beyk();
      if (localazqf.jdField_a_of_type_Azqt.l != 1) {
        break label486;
      }
    }
    label486:
    for (boolean bool = true;; bool = false)
    {
      localbeyk.jdField_a_of_type_Boolean = bool;
      ((beyg)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject1);
      ((beyg)localObject2).jdField_a_of_type_JavaLangObject = localbeyk;
      ((beyg)localObject2).jdField_a_of_type_Azrg = this.this$0;
      localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      ((beyb)localObject1).a(((beyg)localObject2).c + ((beyg)localObject2).jdField_a_of_type_Long);
      ((beyb)localObject1).a((beyg)localObject2);
      this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localazqf.jdField_a_of_type_Azqt.jdField_g_of_type_Long);
      azpw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "end");
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