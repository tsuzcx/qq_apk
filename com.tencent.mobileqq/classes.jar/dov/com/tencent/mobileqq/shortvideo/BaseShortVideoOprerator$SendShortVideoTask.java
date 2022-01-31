package dov.com.tencent.mobileqq.shortvideo;

import awen;
import batw;
import baub;
import bnls;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$SendShortVideoTask
  implements Runnable
{
  bnls a;
  
  public BaseShortVideoOprerator$SendShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, bnls parambnls)
  {
    this.a = parambnls;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      bnls localbnls = this.a;
      Object localObject;
      int i;
      if (!localbnls.jdField_a_of_type_Boolean)
      {
        localObject = (MessageForShortVideo)localbnls.jdField_a_of_type_JavaLangObject;
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
          localbaub.jdField_e_of_type_Int = localbnls.jdField_a_of_type_Int;
          localbaub.f = localbnls.e;
          localbaub.i = (localbnls.h + "QQ_&_MoblieQQ_&_QQ" + localbnls.i + "QQ_&_MoblieQQ_&_QQ" + localbnls.jdField_f_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + localbnls.jdField_g_of_type_JavaLangString);
          localbaub.jdField_a_of_type_Awfy = this.this$0;
          localbaub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
          localbaub.jdField_a_of_type_JavaLangObject = this.a;
          localbaub.jdField_e_of_type_Boolean = localbnls.jdField_f_of_type_Boolean;
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbaub);
          if (!localbnls.d)
          {
            if (localbnls.jdField_a_of_type_Boolean) {
              break label470;
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject);
          }
        }
        for (;;)
        {
          awen.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          awen.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doSendShortVideo.start", "TransferRequest: " + localbaub.toString());
          return;
          if (localbnls.jdField_g_of_type_Int == 0)
          {
            localObject = this.this$0.a(localbnls);
            i = 1;
            break;
          }
          if (localbnls.jdField_g_of_type_Int != 1) {
            break label486;
          }
          localObject = (MessageForShortVideo)localbnls.jdField_a_of_type_JavaLangObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.SendShortVideoTask
 * JD-Core Version:    0.7.0.1
 */