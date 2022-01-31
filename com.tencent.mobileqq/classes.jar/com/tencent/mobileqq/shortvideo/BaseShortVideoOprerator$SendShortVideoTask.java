package com.tencent.mobileqq.shortvideo;

import atpg;
import awfo;
import axvo;
import axvt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$SendShortVideoTask
  implements Runnable
{
  awfo a;
  
  public BaseShortVideoOprerator$SendShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, awfo paramawfo)
  {
    this.a = paramawfo;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      awfo localawfo = this.a;
      Object localObject;
      int i;
      if (!localawfo.jdField_a_of_type_Boolean)
      {
        localObject = (MessageForShortVideo)localawfo.jdField_a_of_type_JavaLangObject;
        i = 0;
      }
      while (localObject != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        axvt localaxvt = new axvt();
        localaxvt.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localaxvt.c = ((MessageRecord)localObject).frienduin;
        localaxvt.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        if ((((MessageRecord)localObject).istroop == 0) || (((MessageRecord)localObject).istroop == 1008))
        {
          localaxvt.jdField_b_of_type_Int = 6;
          label117:
          localaxvt.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
          localaxvt.jdField_a_of_type_Boolean = true;
          localaxvt.e = localawfo.jdField_a_of_type_Int;
          localaxvt.f = localawfo.e;
          localaxvt.i = (localawfo.h + "QQ_&_MoblieQQ_&_QQ" + localawfo.j + "QQ_&_MoblieQQ_&_QQ" + localawfo.jdField_f_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + localawfo.jdField_g_of_type_JavaLangString);
          localaxvt.jdField_a_of_type_Atqq = this.this$0;
          localaxvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
          localaxvt.jdField_a_of_type_JavaLangObject = this.a;
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaxvt);
          if ((!localawfo.d) && (!localawfo.jdField_f_of_type_Boolean))
          {
            if (localawfo.jdField_a_of_type_Boolean) {
              break label468;
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject);
          }
        }
        for (;;)
        {
          atpg.a(this.this$0.jdField_g_of_type_JavaLangString, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          atpg.a(this.this$0.jdField_g_of_type_JavaLangString, this.this$0.f, "doSendShortVideo.start", "TransferRequest: " + localaxvt.toString());
          return;
          if (localawfo.jdField_g_of_type_Int == 0)
          {
            localObject = this.this$0.a(localawfo);
            i = 1;
            break;
          }
          if (localawfo.jdField_g_of_type_Int != 1) {
            break label484;
          }
          localObject = (MessageForShortVideo)localawfo.jdField_a_of_type_JavaLangObject;
          i = 0;
          break;
          if (((MessageRecord)localObject).istroop == 3000)
          {
            localaxvt.jdField_b_of_type_Int = 17;
            break label117;
          }
          if (((MessageRecord)localObject).istroop != 1) {
            break label117;
          }
          localaxvt.jdField_b_of_type_Int = 9;
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