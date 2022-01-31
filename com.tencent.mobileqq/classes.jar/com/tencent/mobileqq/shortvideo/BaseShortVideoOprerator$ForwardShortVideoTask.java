package com.tencent.mobileqq.shortvideo;

import adgc;
import aung;
import axdv;
import ayvx;
import aywc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  axdv a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, axdv paramaxdv)
  {
    this.a = paramaxdv;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      axdv localaxdv = this.a;
      long l = localaxdv.jdField_a_of_type_Long;
      int j = localaxdv.p;
      Object localObject;
      int i;
      if (localaxdv.k == 3)
      {
        localObject = this.this$0.a(localaxdv);
        i = 1;
      }
      while (localObject != null)
      {
        adgc.a().a(((MessageRecord)localObject).uniseq, l, j);
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        l = System.currentTimeMillis();
        aywc localaywc = new aywc();
        localaywc.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localaywc.c = ((MessageRecord)localObject).frienduin;
        localaywc.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        localaywc.jdField_b_of_type_Int = 20;
        localaywc.jdField_a_of_type_JavaLangObject = localaxdv;
        localaywc.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
        localaywc.jdField_a_of_type_Boolean = true;
        localaywc.e = 0;
        localaywc.f = localaxdv.e;
        localaywc.i = (localaxdv.h + "QQ_&_MoblieQQ_&_QQ" + localaxdv.i + "QQ_&_MoblieQQ_&_QQ" + localaxdv.j + "QQ_&_MoblieQQ_&_QQ" + localaxdv.g);
        localaywc.jdField_a_of_type_Auoq = this.this$0;
        localaywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywc);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject, localaxdv.b);
        }
        aung.a(this.this$0.g, this.this$0.f, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        aung.a(this.this$0.g, this.this$0.f, "doForwardShortVideo.start", "TransferRequest: " + localaywc.toString());
        return;
        if (localaxdv.k == 4)
        {
          localObject = (MessageForShortVideo)localaxdv.jdField_a_of_type_JavaLangObject;
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