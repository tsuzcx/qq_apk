package com.tencent.mobileqq.shortvideo;

import ayxi;
import bcfn;
import bdzi;
import bdzn;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$SendShortVideoTask
  implements Runnable
{
  bcfn a;
  
  public BaseShortVideoOprerator$SendShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, bcfn parambcfn)
  {
    this.a = parambcfn;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      bcfn localbcfn = this.a;
      Object localObject;
      int i;
      if (!localbcfn.jdField_a_of_type_Boolean)
      {
        localObject = (MessageForShortVideo)localbcfn.jdField_a_of_type_JavaLangObject;
        i = 0;
      }
      while (localObject != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        bdzn localbdzn = new bdzn();
        localbdzn.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localbdzn.c = ((MessageRecord)localObject).frienduin;
        localbdzn.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        if ((((MessageRecord)localObject).istroop == 0) || (((MessageRecord)localObject).istroop == 1008))
        {
          localbdzn.jdField_b_of_type_Int = 6;
          label117:
          localbdzn.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
          localbdzn.jdField_a_of_type_Boolean = true;
          localbdzn.e = localbcfn.jdField_a_of_type_Int;
          localbdzn.f = localbcfn.e;
          localbdzn.i = (localbcfn.h + "QQ_&_MoblieQQ_&_QQ" + localbcfn.j + "QQ_&_MoblieQQ_&_QQ" + localbcfn.jdField_f_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + localbcfn.jdField_g_of_type_JavaLangString);
          localbdzn.jdField_a_of_type_Ayyt = this.this$0;
          localbdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
          localbdzn.jdField_a_of_type_JavaLangObject = this.a;
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbdzn);
          if ((!localbcfn.d) && (!localbcfn.jdField_f_of_type_Boolean))
          {
            if (localbcfn.jdField_a_of_type_Boolean) {
              break label468;
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject);
          }
        }
        for (;;)
        {
          ayxi.a(this.this$0.jdField_g_of_type_JavaLangString, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          ayxi.a(this.this$0.jdField_g_of_type_JavaLangString, this.this$0.f, "doSendShortVideo.start", "TransferRequest: " + localbdzn.toString());
          return;
          if (localbcfn.jdField_g_of_type_Int == 0)
          {
            localObject = this.this$0.a(localbcfn);
            i = 1;
            break;
          }
          if (localbcfn.jdField_g_of_type_Int != 1) {
            break label484;
          }
          localObject = (MessageForShortVideo)localbcfn.jdField_a_of_type_JavaLangObject;
          i = 0;
          break;
          if (((MessageRecord)localObject).istroop == 3000)
          {
            localbdzn.jdField_b_of_type_Int = 17;
            break label117;
          }
          if (((MessageRecord)localObject).istroop != 1) {
            break label117;
          }
          localbdzn.jdField_b_of_type_Int = 9;
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