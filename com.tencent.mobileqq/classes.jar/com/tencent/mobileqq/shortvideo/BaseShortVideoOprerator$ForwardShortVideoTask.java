package com.tencent.mobileqq.shortvideo;

import adgf;
import aune;
import axdt;
import ayvv;
import aywa;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  axdt a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, axdt paramaxdt)
  {
    this.a = paramaxdt;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      axdt localaxdt = this.a;
      long l = localaxdt.jdField_a_of_type_Long;
      int j = localaxdt.p;
      Object localObject;
      int i;
      if (localaxdt.k == 3)
      {
        localObject = this.this$0.a(localaxdt);
        i = 1;
      }
      while (localObject != null)
      {
        adgf.a().a(((MessageRecord)localObject).uniseq, l, j);
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        l = System.currentTimeMillis();
        aywa localaywa = new aywa();
        localaywa.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localaywa.c = ((MessageRecord)localObject).frienduin;
        localaywa.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        localaywa.jdField_b_of_type_Int = 20;
        localaywa.jdField_a_of_type_JavaLangObject = localaxdt;
        localaywa.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
        localaywa.jdField_a_of_type_Boolean = true;
        localaywa.e = 0;
        localaywa.f = localaxdt.e;
        localaywa.i = (localaxdt.h + "QQ_&_MoblieQQ_&_QQ" + localaxdt.i + "QQ_&_MoblieQQ_&_QQ" + localaxdt.j + "QQ_&_MoblieQQ_&_QQ" + localaxdt.g);
        localaywa.jdField_a_of_type_Auoo = this.this$0;
        localaywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywa);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject, localaxdt.b);
        }
        aune.a(this.this$0.g, this.this$0.f, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        aune.a(this.this$0.g, this.this$0.f, "doForwardShortVideo.start", "TransferRequest: " + localaywa.toString());
        return;
        if (localaxdt.k == 4)
        {
          localObject = (MessageForShortVideo)localaxdt.jdField_a_of_type_JavaLangObject;
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
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.ForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */