package com.tencent.mobileqq.shortvideo;

import awen;
import azae;
import batw;
import baub;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$SendShortVideoTask
  implements Runnable
{
  azae a;
  
  public BaseShortVideoOprerator$SendShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, azae paramazae)
  {
    this.a = paramazae;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      azae localazae = this.a;
      Object localObject;
      int i;
      if (!localazae.jdField_a_of_type_Boolean)
      {
        localObject = (MessageForShortVideo)localazae.jdField_a_of_type_JavaLangObject;
        i = 0;
      }
      while (localObject != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        baub localbaub = new baub();
        localbaub.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localbaub.c = ((MessageRecord)localObject).frienduin;
        localbaub.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        if ((((MessageRecord)localObject).istroop == 0) || (((MessageRecord)localObject).istroop == 1008))
        {
          localbaub.jdField_b_of_type_Int = 6;
          label117:
          localbaub.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
          localbaub.jdField_a_of_type_Boolean = true;
          localbaub.e = localazae.jdField_a_of_type_Int;
          localbaub.f = localazae.e;
          localbaub.i = (localazae.h + "QQ_&_MoblieQQ_&_QQ" + localazae.j + "QQ_&_MoblieQQ_&_QQ" + localazae.jdField_f_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + localazae.jdField_g_of_type_JavaLangString);
          localbaub.jdField_a_of_type_Awfy = this.this$0;
          localbaub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
          localbaub.jdField_a_of_type_JavaLangObject = this.a;
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbaub);
          if ((!localazae.d) && (!localazae.jdField_f_of_type_Boolean))
          {
            if (localazae.jdField_a_of_type_Boolean) {
              break label468;
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject);
          }
        }
        for (;;)
        {
          awen.a(this.this$0.jdField_g_of_type_JavaLangString, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          awen.a(this.this$0.jdField_g_of_type_JavaLangString, this.this$0.f, "doSendShortVideo.start", "TransferRequest: " + localbaub.toString());
          return;
          if (localazae.jdField_g_of_type_Int == 0)
          {
            localObject = this.this$0.a(localazae);
            i = 1;
            break;
          }
          if (localazae.jdField_g_of_type_Int != 1) {
            break label484;
          }
          localObject = (MessageForShortVideo)localazae.jdField_a_of_type_JavaLangObject;
          i = 0;
          break;
          if (((MessageRecord)localObject).istroop == 3000)
          {
            localbaub.jdField_b_of_type_Int = 17;
            break label117;
          }
          if (((MessageRecord)localObject).istroop != 1) {
            break label117;
          }
          localbaub.jdField_b_of_type_Int = 9;
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