package com.tencent.mobileqq.shortvideo;

import afcu;
import awiw;
import azdi;
import bayf;
import bayk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  azdi a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, azdi paramazdi)
  {
    this.a = paramazdi;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      azdi localazdi = this.a;
      long l = localazdi.jdField_a_of_type_Long;
      int j = localazdi.p;
      Object localObject;
      int i;
      if (localazdi.k == 3)
      {
        localObject = this.this$0.a(localazdi);
        i = 1;
      }
      while (localObject != null)
      {
        afcu.a().a(((MessageRecord)localObject).uniseq, l, j);
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        l = System.currentTimeMillis();
        bayk localbayk = new bayk();
        localbayk.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localbayk.c = ((MessageRecord)localObject).frienduin;
        localbayk.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        localbayk.jdField_b_of_type_Int = 20;
        localbayk.jdField_a_of_type_JavaLangObject = localazdi;
        localbayk.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
        localbayk.jdField_a_of_type_Boolean = true;
        localbayk.e = 0;
        localbayk.f = localazdi.e;
        localbayk.i = (localazdi.h + "QQ_&_MoblieQQ_&_QQ" + localazdi.i + "QQ_&_MoblieQQ_&_QQ" + localazdi.j + "QQ_&_MoblieQQ_&_QQ" + localazdi.g);
        localbayk.jdField_a_of_type_Awkh = this.this$0;
        localbayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbayk);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject, localazdi.b);
        }
        awiw.a(this.this$0.g, this.this$0.f, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        awiw.a(this.this$0.g, this.this$0.f, "doForwardShortVideo.start", "TransferRequest: " + localbayk.toString());
        return;
        if (localazdi.k == 4)
        {
          localObject = (MessageForShortVideo)localazdi.jdField_a_of_type_JavaLangObject;
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