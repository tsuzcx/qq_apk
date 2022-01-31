package com.tencent.mobileqq.shortvideo;

import acvh;
import atpg;
import awel;
import axvo;
import axvt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  awel a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, awel paramawel)
  {
    this.a = paramawel;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      awel localawel = this.a;
      long l = localawel.jdField_a_of_type_Long;
      int j = localawel.p;
      Object localObject;
      int i;
      if (localawel.k == 3)
      {
        localObject = this.this$0.a(localawel);
        i = 1;
      }
      while (localObject != null)
      {
        acvh.a().a(((MessageRecord)localObject).uniseq, l, j);
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        l = System.currentTimeMillis();
        axvt localaxvt = new axvt();
        localaxvt.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localaxvt.c = ((MessageRecord)localObject).frienduin;
        localaxvt.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        localaxvt.jdField_b_of_type_Int = 20;
        localaxvt.jdField_a_of_type_JavaLangObject = localawel;
        localaxvt.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
        localaxvt.jdField_a_of_type_Boolean = true;
        localaxvt.e = 0;
        localaxvt.f = localawel.e;
        localaxvt.i = (localawel.h + "QQ_&_MoblieQQ_&_QQ" + localawel.i + "QQ_&_MoblieQQ_&_QQ" + localawel.j + "QQ_&_MoblieQQ_&_QQ" + localawel.g);
        localaxvt.jdField_a_of_type_Atqq = this.this$0;
        localaxvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaxvt);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject, localawel.b);
        }
        atpg.a(this.this$0.g, this.this$0.f, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        atpg.a(this.this$0.g, this.this$0.f, "doForwardShortVideo.start", "TransferRequest: " + localaxvt.toString());
        return;
        if (localawel.k == 4)
        {
          localObject = (MessageForShortVideo)localawel.jdField_a_of_type_JavaLangObject;
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