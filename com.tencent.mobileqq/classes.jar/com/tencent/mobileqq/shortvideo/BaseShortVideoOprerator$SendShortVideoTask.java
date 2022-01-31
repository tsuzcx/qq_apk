package com.tencent.mobileqq.shortvideo;

import aung;
import axey;
import ayvx;
import aywc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$SendShortVideoTask
  implements Runnable
{
  axey a;
  
  public BaseShortVideoOprerator$SendShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, axey paramaxey)
  {
    this.a = paramaxey;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      axey localaxey = this.a;
      Object localObject;
      int i;
      if (!localaxey.jdField_a_of_type_Boolean)
      {
        localObject = (MessageForShortVideo)localaxey.jdField_a_of_type_JavaLangObject;
        i = 0;
      }
      while (localObject != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        aywc localaywc = new aywc();
        localaywc.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localaywc.c = ((MessageRecord)localObject).frienduin;
        localaywc.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        if ((((MessageRecord)localObject).istroop == 0) || (((MessageRecord)localObject).istroop == 1008))
        {
          localaywc.jdField_b_of_type_Int = 6;
          label117:
          localaywc.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
          localaywc.jdField_a_of_type_Boolean = true;
          localaywc.e = localaxey.jdField_a_of_type_Int;
          localaywc.f = localaxey.e;
          localaywc.i = (localaxey.h + "QQ_&_MoblieQQ_&_QQ" + localaxey.j + "QQ_&_MoblieQQ_&_QQ" + localaxey.jdField_f_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + localaxey.jdField_g_of_type_JavaLangString);
          localaywc.jdField_a_of_type_Auoq = this.this$0;
          localaywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
          localaywc.jdField_a_of_type_JavaLangObject = this.a;
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywc);
          if ((!localaxey.d) && (!localaxey.jdField_f_of_type_Boolean))
          {
            if (localaxey.jdField_a_of_type_Boolean) {
              break label468;
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject);
          }
        }
        for (;;)
        {
          aung.a(this.this$0.jdField_g_of_type_JavaLangString, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          aung.a(this.this$0.jdField_g_of_type_JavaLangString, this.this$0.f, "doSendShortVideo.start", "TransferRequest: " + localaywc.toString());
          return;
          if (localaxey.jdField_g_of_type_Int == 0)
          {
            localObject = this.this$0.a(localaxey);
            i = 1;
            break;
          }
          if (localaxey.jdField_g_of_type_Int != 1) {
            break label484;
          }
          localObject = (MessageForShortVideo)localaxey.jdField_a_of_type_JavaLangObject;
          i = 0;
          break;
          if (((MessageRecord)localObject).istroop == 3000)
          {
            localaywc.jdField_b_of_type_Int = 17;
            break label117;
          }
          if (((MessageRecord)localObject).istroop != 1) {
            break label117;
          }
          localaywc.jdField_b_of_type_Int = 9;
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