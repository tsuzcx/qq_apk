package dov.com.tencent.mobileqq.shortvideo;

import aune;
import ayvv;
import aywa;
import bkzj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  bkzj a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, bkzj parambkzj)
  {
    this.a = parambkzj;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      bkzj localbkzj = this.a;
      Object localObject;
      int i;
      if (localbkzj.k == 3)
      {
        localObject = this.this$0.a(localbkzj);
        i = 1;
      }
      while (localObject != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        aywa localaywa = new aywa();
        localaywa.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localaywa.c = ((MessageRecord)localObject).frienduin;
        localaywa.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        localaywa.jdField_b_of_type_Int = 20;
        localaywa.jdField_a_of_type_JavaLangObject = localbkzj;
        localaywa.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
        localaywa.jdField_a_of_type_Boolean = true;
        localaywa.e = 0;
        localaywa.f = localbkzj.e;
        localaywa.i = (localbkzj.h + "QQ_&_MoblieQQ_&_QQ" + localbkzj.i + "QQ_&_MoblieQQ_&_QQ" + localbkzj.j + "QQ_&_MoblieQQ_&_QQ" + localbkzj.g);
        localaywa.jdField_a_of_type_Auoo = this.this$0;
        localaywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywa);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject);
        }
        aune.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        aune.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo.start", "TransferRequest: " + localaywa.toString());
        return;
        if (localbkzj.k == 4)
        {
          localObject = (MessageForShortVideo)localbkzj.jdField_a_of_type_JavaLangObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.ForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */