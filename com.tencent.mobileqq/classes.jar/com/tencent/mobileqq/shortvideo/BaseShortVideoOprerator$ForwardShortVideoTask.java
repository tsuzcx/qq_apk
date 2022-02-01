package com.tencent.mobileqq.shortvideo;

import agjf;
import ayxi;
import bceh;
import bdzi;
import bdzn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  bceh a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, bceh parambceh)
  {
    this.a = parambceh;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      bceh localbceh = this.a;
      long l = localbceh.jdField_a_of_type_Long;
      int j = localbceh.p;
      Object localObject;
      int i;
      if (localbceh.k == 3)
      {
        localObject = this.this$0.a(localbceh);
        i = 1;
      }
      while (localObject != null)
      {
        agjf.a().a(((MessageRecord)localObject).uniseq, l, j);
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        l = System.currentTimeMillis();
        bdzn localbdzn = new bdzn();
        localbdzn.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localbdzn.c = ((MessageRecord)localObject).frienduin;
        localbdzn.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        localbdzn.jdField_b_of_type_Int = 20;
        localbdzn.jdField_a_of_type_JavaLangObject = localbceh;
        localbdzn.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
        localbdzn.jdField_a_of_type_Boolean = true;
        localbdzn.e = 0;
        localbdzn.f = localbceh.e;
        localbdzn.i = (localbceh.h + "QQ_&_MoblieQQ_&_QQ" + localbceh.i + "QQ_&_MoblieQQ_&_QQ" + localbceh.j + "QQ_&_MoblieQQ_&_QQ" + localbceh.g);
        localbdzn.jdField_a_of_type_Ayyt = this.this$0;
        localbdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbdzn);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject, localbceh.b);
        }
        ayxi.a(this.this$0.g, this.this$0.f, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        ayxi.a(this.this$0.g, this.this$0.f, "doForwardShortVideo.start", "TransferRequest: " + localbdzn.toString());
        return;
        if (localbceh.k == 4)
        {
          localObject = (MessageForShortVideo)localbceh.jdField_a_of_type_JavaLangObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.ForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */