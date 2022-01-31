package dov.com.tencent.mobileqq.shortvideo;

import atpg;
import axvo;
import axvt;
import bjiy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  bjiy a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, bjiy parambjiy)
  {
    this.a = parambjiy;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      bjiy localbjiy = this.a;
      Object localObject;
      int i;
      if (localbjiy.k == 3)
      {
        localObject = this.this$0.a(localbjiy);
        i = 1;
      }
      while (localObject != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        axvt localaxvt = new axvt();
        localaxvt.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localaxvt.c = ((MessageRecord)localObject).frienduin;
        localaxvt.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        localaxvt.jdField_b_of_type_Int = 20;
        localaxvt.jdField_a_of_type_JavaLangObject = localbjiy;
        localaxvt.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
        localaxvt.jdField_a_of_type_Boolean = true;
        localaxvt.e = 0;
        localaxvt.f = localbjiy.e;
        localaxvt.i = (localbjiy.h + "QQ_&_MoblieQQ_&_QQ" + localbjiy.i + "QQ_&_MoblieQQ_&_QQ" + localbjiy.j + "QQ_&_MoblieQQ_&_QQ" + localbjiy.g);
        localaxvt.jdField_a_of_type_Atqq = this.this$0;
        localaxvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaxvt);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject);
        }
        atpg.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        atpg.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo.start", "TransferRequest: " + localaxvt.toString());
        return;
        if (localbjiy.k == 4)
        {
          localObject = (MessageForShortVideo)localbjiy.jdField_a_of_type_JavaLangObject;
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