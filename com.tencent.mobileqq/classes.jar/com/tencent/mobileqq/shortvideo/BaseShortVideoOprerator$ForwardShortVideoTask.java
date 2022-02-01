package com.tencent.mobileqq.shortvideo;

import agsg;
import azpw;
import bcwz;
import beyb;
import beyg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  bcwz a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, bcwz parambcwz)
  {
    this.a = parambcwz;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      bcwz localbcwz = this.a;
      long l = localbcwz.jdField_a_of_type_Long;
      int j = localbcwz.p;
      Object localObject;
      int i;
      if (localbcwz.k == 3)
      {
        localObject = this.this$0.a(localbcwz);
        i = 1;
      }
      while (localObject != null)
      {
        agsg.a().a(((MessageRecord)localObject).uniseq, l, j);
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        l = System.currentTimeMillis();
        beyg localbeyg = new beyg();
        localbeyg.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localbeyg.c = ((MessageRecord)localObject).frienduin;
        localbeyg.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        localbeyg.jdField_b_of_type_Int = 20;
        localbeyg.jdField_a_of_type_JavaLangObject = localbcwz;
        localbeyg.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
        localbeyg.jdField_a_of_type_Boolean = true;
        localbeyg.e = 0;
        localbeyg.f = localbcwz.e;
        localbeyg.i = (localbcwz.h + "QQ_&_MoblieQQ_&_QQ" + localbcwz.i + "QQ_&_MoblieQQ_&_QQ" + localbcwz.j + "QQ_&_MoblieQQ_&_QQ" + localbcwz.g);
        localbeyg.jdField_a_of_type_Azrg = this.this$0;
        localbeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbeyg);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject, localbcwz.b);
        }
        azpw.a(this.this$0.g, this.this$0.f, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        azpw.a(this.this$0.g, this.this$0.f, "doForwardShortVideo.start", "TransferRequest: " + localbeyg.toString());
        return;
        if (localbcwz.k == 4)
        {
          localObject = (MessageForShortVideo)localbcwz.jdField_a_of_type_JavaLangObject;
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