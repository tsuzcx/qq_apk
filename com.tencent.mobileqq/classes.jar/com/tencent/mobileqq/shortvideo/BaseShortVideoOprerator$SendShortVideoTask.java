package com.tencent.mobileqq.shortvideo;

import azpw;
import bcyf;
import beyb;
import beyg;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$SendShortVideoTask
  implements Runnable
{
  bcyf a;
  
  public BaseShortVideoOprerator$SendShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, bcyf parambcyf)
  {
    this.a = parambcyf;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      bcyf localbcyf = this.a;
      Object localObject;
      int i;
      if (!localbcyf.jdField_a_of_type_Boolean)
      {
        localObject = (MessageForShortVideo)localbcyf.jdField_a_of_type_JavaLangObject;
        i = 0;
      }
      while (localObject != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        beyg localbeyg = new beyg();
        localbeyg.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localbeyg.c = ((MessageRecord)localObject).frienduin;
        localbeyg.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        if ((((MessageRecord)localObject).istroop == 0) || (((MessageRecord)localObject).istroop == 1008))
        {
          localbeyg.jdField_b_of_type_Int = 6;
          label117:
          localbeyg.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
          localbeyg.jdField_a_of_type_Boolean = true;
          localbeyg.e = localbcyf.jdField_a_of_type_Int;
          localbeyg.f = localbcyf.e;
          localbeyg.i = (localbcyf.h + "QQ_&_MoblieQQ_&_QQ" + localbcyf.j + "QQ_&_MoblieQQ_&_QQ" + localbcyf.jdField_f_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + localbcyf.jdField_g_of_type_JavaLangString);
          localbeyg.jdField_a_of_type_Azrg = this.this$0;
          localbeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
          localbeyg.jdField_a_of_type_JavaLangObject = this.a;
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbeyg);
          if ((!localbcyf.d) && (!localbcyf.jdField_f_of_type_Boolean))
          {
            if (localbcyf.jdField_a_of_type_Boolean) {
              break label468;
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject);
          }
        }
        for (;;)
        {
          azpw.a(this.this$0.jdField_g_of_type_JavaLangString, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          azpw.a(this.this$0.jdField_g_of_type_JavaLangString, this.this$0.f, "doSendShortVideo.start", "TransferRequest: " + localbeyg.toString());
          return;
          if (localbcyf.jdField_g_of_type_Int == 0)
          {
            localObject = this.this$0.a(localbcyf);
            i = 1;
            break;
          }
          if (localbcyf.jdField_g_of_type_Int != 1) {
            break label484;
          }
          localObject = (MessageForShortVideo)localbcyf.jdField_a_of_type_JavaLangObject;
          i = 0;
          break;
          if (((MessageRecord)localObject).istroop == 3000)
          {
            localbeyg.jdField_b_of_type_Int = 17;
            break label117;
          }
          if (((MessageRecord)localObject).istroop != 1) {
            break label117;
          }
          localbeyg.jdField_b_of_type_Int = 9;
          break label117;
          label468:
          if (i != 0) {
            this.this$0.a((MessageRecord)localObject);
          }
        }
        label484:
        localObject = null;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.SendShortVideoTask
 * JD-Core Version:    0.7.0.1
 */