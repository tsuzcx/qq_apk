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

public class BasePicOprerator$2
  implements Runnable
{
  public BasePicOprerator$2(azpg paramazpg, azqf paramazqf, azqk paramazqk) {}
  
  public void run()
  {
    azpw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      this.jdField_a_of_type_Azqf.a("doFastForward", "rec==null");
      this.this$0.a(4, this.jdField_a_of_type_Azqf.jdField_a_of_type_Azqh);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = this.jdField_a_of_type_Azqf.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString;
    azpg.a(this.this$0, this.jdField_a_of_type_Azqk, ((MessageForPic)localObject1).uniseq);
    if (this.jdField_a_of_type_Azqk.a != null) {
      ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_Azqk.a;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    azrm.b((CompressInfo)localObject2);
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
      localObject1 = new beyg();
      ((beyg)localObject1).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((beyg)localObject1).c = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((beyg)localObject1).d = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((beyg)localObject1).jdField_a_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((beyg)localObject1).jdField_b_of_type_Int = 1;
      ((beyg)localObject1).jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((beyg)localObject1).jdField_a_of_type_Boolean = true;
      ((beyg)localObject1).jdField_e_of_type_Int = this.jdField_a_of_type_Azqf.jdField_a_of_type_Azqt.jdField_a_of_type_Int;
      ((beyg)localObject1).jdField_i_of_type_JavaLangString = this.jdField_a_of_type_Azqf.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString;
      localObject2 = new beyk();
      if (this.jdField_a_of_type_Azqf.jdField_a_of_type_Azqt.l != 1) {
        break label462;
      }
    }
    label462:
    for (boolean bool = true;; bool = false)
    {
      ((beyk)localObject2).jdField_a_of_type_Boolean = bool;
      ((beyg)localObject1).jdField_a_of_type_JavaLangObject = localObject2;
      ((beyg)localObject1).jdField_a_of_type_Azrg = this.this$0;
      ((beyg)localObject1).jdField_i_of_type_Boolean = true;
      if ((this.jdField_a_of_type_Azqf.jdField_a_of_type_Azqt.f != null) && (this.jdField_a_of_type_Azqf.jdField_a_of_type_Azqt.j != 0) && (this.jdField_a_of_type_Azqf.jdField_a_of_type_Azqt.k != 0) && (this.jdField_a_of_type_Azqf.jdField_a_of_type_Azqt.c != 0L)) {
        break label467;
      }
      this.jdField_a_of_type_Azqf.a("doFastForward", "upInfo uncomplete!");
      this.this$0.a(4, this.jdField_a_of_type_Azqf.jdField_a_of_type_Azqh);
      return;
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
      break;
    }
    label467:
    ((beyg)localObject1).f = this.jdField_a_of_type_Azqf.jdField_a_of_type_Azqt.f;
    azpw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", " Get width/height/filesize from UploadInfo");
    ((beyg)localObject1).l = this.jdField_a_of_type_Azqf.jdField_a_of_type_Azqt.j;
    ((beyg)localObject1).m = this.jdField_a_of_type_Azqf.jdField_a_of_type_Azqt.k;
    ((beyg)localObject1).jdField_e_of_type_Long = this.jdField_a_of_type_Azqf.jdField_a_of_type_Azqt.c;
    localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    ((beyb)localObject2).a(((beyg)localObject1).c + ((beyg)localObject1).jdField_a_of_type_Long);
    ((beyb)localObject2).a((beyg)localObject1);
    this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Azqf.jdField_a_of_type_Azqt.jdField_g_of_type_Long);
    azpw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "end, req.mFastForwardWidth = " + ((beyg)localObject1).l + ",req.mFastForwardHeight = " + ((beyg)localObject1).m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.2
 * JD-Core Version:    0.7.0.1
 */