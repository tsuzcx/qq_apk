package com.tencent.mobileqq.shortvideo;

import awiw;
import azen;
import bayf;
import bayk;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$SendShortVideoTask
  implements Runnable
{
  azen a;
  
  public BaseShortVideoOprerator$SendShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, azen paramazen)
  {
    this.a = paramazen;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      azen localazen = this.a;
      Object localObject;
      int i;
      if (!localazen.jdField_a_of_type_Boolean)
      {
        localObject = (MessageForShortVideo)localazen.jdField_a_of_type_JavaLangObject;
        i = 0;
      }
      while (localObject != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        bayk localbayk = new bayk();
        localbayk.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localbayk.c = ((MessageRecord)localObject).frienduin;
        localbayk.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        if ((((MessageRecord)localObject).istroop == 0) || (((MessageRecord)localObject).istroop == 1008))
        {
          localbayk.jdField_b_of_type_Int = 6;
          label117:
          localbayk.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
          localbayk.jdField_a_of_type_Boolean = true;
          localbayk.e = localazen.jdField_a_of_type_Int;
          localbayk.f = localazen.e;
          localbayk.i = (localazen.h + "QQ_&_MoblieQQ_&_QQ" + localazen.j + "QQ_&_MoblieQQ_&_QQ" + localazen.jdField_f_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + localazen.jdField_g_of_type_JavaLangString);
          localbayk.jdField_a_of_type_Awkh = this.this$0;
          localbayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
          localbayk.jdField_a_of_type_JavaLangObject = this.a;
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbayk);
          if ((!localazen.d) && (!localazen.jdField_f_of_type_Boolean))
          {
            if (localazen.jdField_a_of_type_Boolean) {
              break label468;
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject);
          }
        }
        for (;;)
        {
          awiw.a(this.this$0.jdField_g_of_type_JavaLangString, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          awiw.a(this.this$0.jdField_g_of_type_JavaLangString, this.this$0.f, "doSendShortVideo.start", "TransferRequest: " + localbayk.toString());
          return;
          if (localazen.jdField_g_of_type_Int == 0)
          {
            localObject = this.this$0.a(localazen);
            i = 1;
            break;
          }
          if (localazen.jdField_g_of_type_Int != 1) {
            break label484;
          }
          localObject = (MessageForShortVideo)localazen.jdField_a_of_type_JavaLangObject;
          i = 0;
          break;
          if (((MessageRecord)localObject).istroop == 3000)
          {
            localbayk.jdField_b_of_type_Int = 17;
            break label117;
          }
          if (((MessageRecord)localObject).istroop != 1) {
            break label117;
          }
          localbayk.jdField_b_of_type_Int = 9;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.SendShortVideoTask
 * JD-Core Version:    0.7.0.1
 */