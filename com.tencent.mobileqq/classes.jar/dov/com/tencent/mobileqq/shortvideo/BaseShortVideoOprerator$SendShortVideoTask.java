package dov.com.tencent.mobileqq.shortvideo;

import aung;
import ayvx;
import aywc;
import blai;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$SendShortVideoTask
  implements Runnable
{
  blai a;
  
  public BaseShortVideoOprerator$SendShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, blai paramblai)
  {
    this.a = paramblai;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      blai localblai = this.a;
      Object localObject;
      int i;
      if (!localblai.jdField_a_of_type_Boolean)
      {
        localObject = (MessageForShortVideo)localblai.jdField_a_of_type_JavaLangObject;
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
          localaywc.jdField_e_of_type_Int = localblai.jdField_a_of_type_Int;
          localaywc.f = localblai.e;
          localaywc.i = (localblai.h + "QQ_&_MoblieQQ_&_QQ" + localblai.i + "QQ_&_MoblieQQ_&_QQ" + localblai.jdField_f_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + localblai.jdField_g_of_type_JavaLangString);
          localaywc.jdField_a_of_type_Auoq = this.this$0;
          localaywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
          localaywc.jdField_a_of_type_JavaLangObject = this.a;
          localaywc.jdField_e_of_type_Boolean = localblai.jdField_f_of_type_Boolean;
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywc);
          if (!localblai.d)
          {
            if (localblai.jdField_a_of_type_Boolean) {
              break label470;
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject);
          }
        }
        for (;;)
        {
          aung.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          aung.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doSendShortVideo.start", "TransferRequest: " + localaywc.toString());
          return;
          if (localblai.jdField_g_of_type_Int == 0)
          {
            localObject = this.this$0.a(localblai);
            i = 1;
            break;
          }
          if (localblai.jdField_g_of_type_Int != 1) {
            break label486;
          }
          localObject = (MessageForShortVideo)localblai.jdField_a_of_type_JavaLangObject;
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