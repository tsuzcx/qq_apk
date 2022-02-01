package dov.com.tencent.mobileqq.shortvideo;

import azpw;
import beyb;
import beyg;
import brie;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$SendShortVideoTask
  implements Runnable
{
  brie a;
  
  public BaseShortVideoOprerator$SendShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, brie parambrie)
  {
    this.a = parambrie;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      brie localbrie = this.a;
      Object localObject;
      int i;
      if (!localbrie.jdField_a_of_type_Boolean)
      {
        localObject = (MessageForShortVideo)localbrie.jdField_a_of_type_JavaLangObject;
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
          localbeyg.e = localbrie.jdField_a_of_type_Int;
          localbeyg.jdField_f_of_type_JavaLangString = localbrie.e;
          localbeyg.i = (localbrie.h + "QQ_&_MoblieQQ_&_QQ" + localbrie.i + "QQ_&_MoblieQQ_&_QQ" + localbrie.jdField_f_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + localbrie.jdField_g_of_type_JavaLangString);
          localbeyg.jdField_a_of_type_Azrg = this.this$0;
          localbeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
          localbeyg.jdField_a_of_type_JavaLangObject = this.a;
          localbeyg.jdField_f_of_type_Boolean = localbrie.jdField_f_of_type_Boolean;
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbeyg);
          if (!localbrie.d)
          {
            if (localbrie.jdField_a_of_type_Boolean) {
              break label470;
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject);
          }
        }
        for (;;)
        {
          azpw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          azpw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doSendShortVideo.start", "TransferRequest: " + localbeyg.toString());
          return;
          if (localbrie.jdField_g_of_type_Int == 0)
          {
            localObject = this.this$0.a(localbrie);
            i = 1;
            break;
          }
          if (localbrie.jdField_g_of_type_Int != 1) {
            break label486;
          }
          localObject = (MessageForShortVideo)localbrie.jdField_a_of_type_JavaLangObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.SendShortVideoTask
 * JD-Core Version:    0.7.0.1
 */