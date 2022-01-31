package dov.com.tencent.mobileqq.shortvideo;

import awiw;
import bayf;
import bayk;
import bnpw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  bnpw a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, bnpw parambnpw)
  {
    this.a = parambnpw;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      bnpw localbnpw = this.a;
      Object localObject;
      int i;
      if (localbnpw.k == 3)
      {
        localObject = this.this$0.a(localbnpw);
        i = 1;
      }
      while (localObject != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        bayk localbayk = new bayk();
        localbayk.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localbayk.c = ((MessageRecord)localObject).frienduin;
        localbayk.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        localbayk.jdField_b_of_type_Int = 20;
        localbayk.jdField_a_of_type_JavaLangObject = localbnpw;
        localbayk.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
        localbayk.jdField_a_of_type_Boolean = true;
        localbayk.e = 0;
        localbayk.f = localbnpw.e;
        localbayk.i = (localbnpw.h + "QQ_&_MoblieQQ_&_QQ" + localbnpw.i + "QQ_&_MoblieQQ_&_QQ" + localbnpw.j + "QQ_&_MoblieQQ_&_QQ" + localbnpw.g);
        localbayk.jdField_a_of_type_Awkh = this.this$0;
        localbayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbayk);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject);
        }
        awiw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        awiw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo.start", "TransferRequest: " + localbayk.toString());
        return;
        if (localbnpw.k == 4)
        {
          localObject = (MessageForShortVideo)localbnpw.jdField_a_of_type_JavaLangObject;
          i = 0;
        }
        else
        {
          localObject = null;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.ForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */