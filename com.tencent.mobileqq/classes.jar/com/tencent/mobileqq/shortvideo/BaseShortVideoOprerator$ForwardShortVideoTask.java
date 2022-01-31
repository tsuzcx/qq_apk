package com.tencent.mobileqq.shortvideo;

import aeyf;
import awen;
import ayyz;
import batw;
import baub;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  ayyz a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, ayyz paramayyz)
  {
    this.a = paramayyz;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      ayyz localayyz = this.a;
      long l = localayyz.jdField_a_of_type_Long;
      int j = localayyz.p;
      Object localObject;
      int i;
      if (localayyz.k == 3)
      {
        localObject = this.this$0.a(localayyz);
        i = 1;
      }
      while (localObject != null)
      {
        aeyf.a().a(((MessageRecord)localObject).uniseq, l, j);
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        l = System.currentTimeMillis();
        baub localbaub = new baub();
        localbaub.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localbaub.c = ((MessageRecord)localObject).frienduin;
        localbaub.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        localbaub.jdField_b_of_type_Int = 20;
        localbaub.jdField_a_of_type_JavaLangObject = localayyz;
        localbaub.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
        localbaub.jdField_a_of_type_Boolean = true;
        localbaub.e = 0;
        localbaub.f = localayyz.e;
        localbaub.i = (localayyz.h + "QQ_&_MoblieQQ_&_QQ" + localayyz.i + "QQ_&_MoblieQQ_&_QQ" + localayyz.j + "QQ_&_MoblieQQ_&_QQ" + localayyz.g);
        localbaub.jdField_a_of_type_Awfy = this.this$0;
        localbaub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbaub);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject, localayyz.b);
        }
        awen.a(this.this$0.g, this.this$0.f, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        awen.a(this.this$0.g, this.this$0.f, "doForwardShortVideo.start", "TransferRequest: " + localbaub.toString());
        return;
        if (localayyz.k == 4)
        {
          localObject = (MessageForShortVideo)localayyz.jdField_a_of_type_JavaLangObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.ForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */