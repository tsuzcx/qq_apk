package dov.com.tencent.mobileqq.shortvideo;

import awen;
import batw;
import baub;
import bnlk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  bnlk a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, bnlk parambnlk)
  {
    this.a = parambnlk;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      bnlk localbnlk = this.a;
      Object localObject;
      int i;
      if (localbnlk.k == 3)
      {
        localObject = this.this$0.a(localbnlk);
        i = 1;
      }
      while (localObject != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        baub localbaub = new baub();
        localbaub.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localbaub.c = ((MessageRecord)localObject).frienduin;
        localbaub.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        localbaub.jdField_b_of_type_Int = 20;
        localbaub.jdField_a_of_type_JavaLangObject = localbnlk;
        localbaub.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
        localbaub.jdField_a_of_type_Boolean = true;
        localbaub.e = 0;
        localbaub.f = localbnlk.e;
        localbaub.i = (localbnlk.h + "QQ_&_MoblieQQ_&_QQ" + localbnlk.i + "QQ_&_MoblieQQ_&_QQ" + localbnlk.j + "QQ_&_MoblieQQ_&_QQ" + localbnlk.g);
        localbaub.jdField_a_of_type_Awfy = this.this$0;
        localbaub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbaub);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject);
        }
        awen.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        awen.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo.start", "TransferRequest: " + localbaub.toString());
        return;
        if (localbnlk.k == 4)
        {
          localObject = (MessageForShortVideo)localbnlk.jdField_a_of_type_JavaLangObject;
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