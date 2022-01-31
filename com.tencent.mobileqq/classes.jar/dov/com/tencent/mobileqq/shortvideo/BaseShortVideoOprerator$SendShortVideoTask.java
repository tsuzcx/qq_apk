package dov.com.tencent.mobileqq.shortvideo;

import aune;
import ayvv;
import aywa;
import bkzr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$SendShortVideoTask
  implements Runnable
{
  bkzr a;
  
  public BaseShortVideoOprerator$SendShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, bkzr parambkzr)
  {
    this.a = parambkzr;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      bkzr localbkzr = this.a;
      Object localObject;
      int i;
      if (!localbkzr.jdField_a_of_type_Boolean)
      {
        localObject = (MessageForShortVideo)localbkzr.jdField_a_of_type_JavaLangObject;
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
          localaywa.jdField_e_of_type_Int = localbkzr.jdField_a_of_type_Int;
          localaywa.f = localbkzr.e;
          localaywa.i = (localbkzr.h + "QQ_&_MoblieQQ_&_QQ" + localbkzr.i + "QQ_&_MoblieQQ_&_QQ" + localbkzr.jdField_f_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + localbkzr.jdField_g_of_type_JavaLangString);
          localaywa.jdField_a_of_type_Auoo = this.this$0;
          localaywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
          localaywa.jdField_a_of_type_JavaLangObject = this.a;
          localaywa.jdField_e_of_type_Boolean = localbkzr.jdField_f_of_type_Boolean;
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywa);
          if (!localbkzr.d)
          {
            if (localbkzr.jdField_a_of_type_Boolean) {
              break label470;
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject);
          }
        }
        for (;;)
        {
          aune.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          aune.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doSendShortVideo.start", "TransferRequest: " + localaywa.toString());
          return;
          if (localbkzr.jdField_g_of_type_Int == 0)
          {
            localObject = this.this$0.a(localbkzr);
            i = 1;
            break;
          }
          if (localbkzr.jdField_g_of_type_Int != 1) {
            break label486;
          }
          localObject = (MessageForShortVideo)localbkzr.jdField_a_of_type_JavaLangObject;
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
          label470:
          if (i != 0) {
            this.this$0.a((MessageRecord)localObject);
          }
        }
        label486:
        localObject = null;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.SendShortVideoTask
 * JD-Core Version:    0.7.0.1
 */