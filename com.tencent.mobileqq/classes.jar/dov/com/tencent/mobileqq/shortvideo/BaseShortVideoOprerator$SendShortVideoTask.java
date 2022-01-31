package dov.com.tencent.mobileqq.shortvideo;

import atpg;
import axvo;
import axvt;
import bjjg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$SendShortVideoTask
  implements Runnable
{
  bjjg a;
  
  public BaseShortVideoOprerator$SendShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, bjjg parambjjg)
  {
    this.a = parambjjg;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      bjjg localbjjg = this.a;
      Object localObject;
      int i;
      if (!localbjjg.jdField_a_of_type_Boolean)
      {
        localObject = (MessageForShortVideo)localbjjg.jdField_a_of_type_JavaLangObject;
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
          localaxvt.jdField_e_of_type_Int = localbjjg.jdField_a_of_type_Int;
          localaxvt.f = localbjjg.e;
          localaxvt.i = (localbjjg.h + "QQ_&_MoblieQQ_&_QQ" + localbjjg.i + "QQ_&_MoblieQQ_&_QQ" + localbjjg.jdField_f_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + localbjjg.jdField_g_of_type_JavaLangString);
          localaxvt.jdField_a_of_type_Atqq = this.this$0;
          localaxvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
          localaxvt.jdField_a_of_type_JavaLangObject = this.a;
          localaxvt.jdField_e_of_type_Boolean = localbjjg.jdField_f_of_type_Boolean;
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaxvt);
          if (!localbjjg.d)
          {
            if (localbjjg.jdField_a_of_type_Boolean) {
              break label470;
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject);
          }
        }
        for (;;)
        {
          atpg.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          atpg.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doSendShortVideo.start", "TransferRequest: " + localaxvt.toString());
          return;
          if (localbjjg.jdField_g_of_type_Int == 0)
          {
            localObject = this.this$0.a(localbjjg);
            i = 1;
            break;
          }
          if (localbjjg.jdField_g_of_type_Int != 1) {
            break label486;
          }
          localObject = (MessageForShortVideo)localbjjg.jdField_a_of_type_JavaLangObject;
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