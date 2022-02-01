package dov.com.tencent.mobileqq.shortvideo;

import ayxi;
import bdzi;
import bdzn;
import bqgm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  bqgm a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, bqgm parambqgm)
  {
    this.a = parambqgm;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      bqgm localbqgm = this.a;
      Object localObject;
      int i;
      if (localbqgm.k == 3)
      {
        localObject = this.this$0.a(localbqgm);
        i = 1;
      }
      while (localObject != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        bdzn localbdzn = new bdzn();
        localbdzn.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localbdzn.c = ((MessageRecord)localObject).frienduin;
        localbdzn.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        localbdzn.jdField_b_of_type_Int = 20;
        localbdzn.jdField_a_of_type_JavaLangObject = localbqgm;
        localbdzn.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
        localbdzn.jdField_a_of_type_Boolean = true;
        localbdzn.e = 0;
        localbdzn.f = localbqgm.e;
        localbdzn.i = (localbqgm.h + "QQ_&_MoblieQQ_&_QQ" + localbqgm.i + "QQ_&_MoblieQQ_&_QQ" + localbqgm.j + "QQ_&_MoblieQQ_&_QQ" + localbqgm.g);
        localbdzn.jdField_a_of_type_Ayyt = this.this$0;
        localbdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbdzn);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject);
        }
        ayxi.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        ayxi.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo.start", "TransferRequest: " + localbdzn.toString());
        return;
        if (localbqgm.k == 4)
        {
          localObject = (MessageForShortVideo)localbqgm.jdField_a_of_type_JavaLangObject;
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