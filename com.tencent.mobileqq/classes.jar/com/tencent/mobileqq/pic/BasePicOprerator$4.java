package com.tencent.mobileqq.pic;

import azpg;
import azpq;
import azqk;
import azqq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import java.io.File;

public class BasePicOprerator$4
  implements Runnable
{
  public BasePicOprerator$4(azpg paramazpg, azpq paramazpq) {}
  
  public void run()
  {
    MessageForPic localMessageForPic;
    azqq localazqq;
    long l;
    if ((this.a != null) && (this.this$0.jdField_a_of_type_Azqk.a != null) && (this.a.b != null))
    {
      localMessageForPic = this.this$0.jdField_a_of_type_Azqk.a;
      File localFile = new File(this.a.b);
      if (this.a.a == 0)
      {
        localazqq = (azqq)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
        if (localazqq != null)
        {
          l = localFile.length();
          switch (this.a.c)
          {
          }
        }
      }
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_Azqk, this.a);
      return;
      localazqq.a(13059, l);
      continue;
      localazqq.a(13060, l);
      localazqq.b(localMessageForPic);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.4
 * JD-Core Version:    0.7.0.1
 */