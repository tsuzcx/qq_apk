package dov.com.tencent.mobileqq.shortvideo;

import azpw;
import beyb;
import beyg;
import brhx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  brhx a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, brhx parambrhx)
  {
    this.a = parambrhx;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      brhx localbrhx = this.a;
      Object localObject;
      int i;
      if (localbrhx.k == 3)
      {
        localObject = this.this$0.a(localbrhx);
        i = 1;
      }
      while (localObject != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        beyg localbeyg = new beyg();
        localbeyg.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localbeyg.c = ((MessageRecord)localObject).frienduin;
        localbeyg.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        localbeyg.jdField_b_of_type_Int = 20;
        localbeyg.jdField_a_of_type_JavaLangObject = localbrhx;
        localbeyg.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
        localbeyg.jdField_a_of_type_Boolean = true;
        localbeyg.e = 0;
        localbeyg.f = localbrhx.e;
        localbeyg.i = (localbrhx.h + "QQ_&_MoblieQQ_&_QQ" + localbrhx.i + "QQ_&_MoblieQQ_&_QQ" + localbrhx.j + "QQ_&_MoblieQQ_&_QQ" + localbrhx.g);
        localbeyg.jdField_a_of_type_Azrg = this.this$0;
        localbeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbeyg);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject);
        }
        azpw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        azpw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo.start", "TransferRequest: " + localbeyg.toString());
        return;
        if (localbrhx.k == 4)
        {
          localObject = (MessageForShortVideo)localbrhx.jdField_a_of_type_JavaLangObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.ForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */