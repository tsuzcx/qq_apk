package dov.com.tencent.mobileqq.shortvideo;

import aung;
import ayvx;
import aywc;
import blaa;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  blaa a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, blaa paramblaa)
  {
    this.a = paramblaa;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      blaa localblaa = this.a;
      Object localObject;
      int i;
      if (localblaa.k == 3)
      {
        localObject = this.this$0.a(localblaa);
        i = 1;
      }
      while (localObject != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        aywc localaywc = new aywc();
        localaywc.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localaywc.c = ((MessageRecord)localObject).frienduin;
        localaywc.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        localaywc.jdField_b_of_type_Int = 20;
        localaywc.jdField_a_of_type_JavaLangObject = localblaa;
        localaywc.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
        localaywc.jdField_a_of_type_Boolean = true;
        localaywc.e = 0;
        localaywc.f = localblaa.e;
        localaywc.i = (localblaa.h + "QQ_&_MoblieQQ_&_QQ" + localblaa.i + "QQ_&_MoblieQQ_&_QQ" + localblaa.j + "QQ_&_MoblieQQ_&_QQ" + localblaa.g);
        localaywc.jdField_a_of_type_Auoq = this.this$0;
        localaywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywc);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject);
        }
        aung.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        aung.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo.start", "TransferRequest: " + localaywc.toString());
        return;
        if (localblaa.k == 4)
        {
          localObject = (MessageForShortVideo)localblaa.jdField_a_of_type_JavaLangObject;
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