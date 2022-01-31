package com.tencent.mobileqq.shortvideo;

import aune;
import axew;
import ayvv;
import aywa;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$SendShortVideoTask
  implements Runnable
{
  axew a;
  
  public BaseShortVideoOprerator$SendShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, axew paramaxew)
  {
    this.a = paramaxew;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      axew localaxew = this.a;
      Object localObject;
      int i;
      if (!localaxew.jdField_a_of_type_Boolean)
      {
        localObject = (MessageForShortVideo)localaxew.jdField_a_of_type_JavaLangObject;
        i = 0;
      }
      while (localObject != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        aywa localaywa = new aywa();
        localaywa.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localaywa.c = ((MessageRecord)localObject).frienduin;
        localaywa.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        if ((((MessageRecord)localObject).istroop == 0) || (((MessageRecord)localObject).istroop == 1008))
        {
          localaywa.jdField_b_of_type_Int = 6;
          label117:
          localaywa.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
          localaywa.jdField_a_of_type_Boolean = true;
          localaywa.e = localaxew.jdField_a_of_type_Int;
          localaywa.f = localaxew.e;
          localaywa.i = (localaxew.h + "QQ_&_MoblieQQ_&_QQ" + localaxew.j + "QQ_&_MoblieQQ_&_QQ" + localaxew.jdField_f_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + localaxew.jdField_g_of_type_JavaLangString);
          localaywa.jdField_a_of_type_Auoo = this.this$0;
          localaywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
          localaywa.jdField_a_of_type_JavaLangObject = this.a;
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywa);
          if ((!localaxew.d) && (!localaxew.jdField_f_of_type_Boolean))
          {
            if (localaxew.jdField_a_of_type_Boolean) {
              break label468;
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject);
          }
        }
        for (;;)
        {
          aune.a(this.this$0.jdField_g_of_type_JavaLangString, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          aune.a(this.this$0.jdField_g_of_type_JavaLangString, this.this$0.f, "doSendShortVideo.start", "TransferRequest: " + localaywa.toString());
          return;
          if (localaxew.jdField_g_of_type_Int == 0)
          {
            localObject = this.this$0.a(localaxew);
            i = 1;
            break;
          }
          if (localaxew.jdField_g_of_type_Int != 1) {
            break label484;
          }
          localObject = (MessageForShortVideo)localaxew.jdField_a_of_type_JavaLangObject;
          i = 0;
          break;
          if (((MessageRecord)localObject).istroop == 3000)
          {
            localaywa.jdField_b_of_type_Int = 17;
            break label117;
          }
          if (((MessageRecord)localObject).istroop != 1) {
            break label117;
          }
          localaywa.jdField_b_of_type_Int = 9;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.SendShortVideoTask
 * JD-Core Version:    0.7.0.1
 */