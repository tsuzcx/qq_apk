package com.tencent.mobileqq.pic;

import ayco;
import aycy;
import ayds;
import aydy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import java.io.File;

public class BasePicOprerator$4
  implements Runnable
{
  public BasePicOprerator$4(ayco paramayco, aycy paramaycy) {}
  
  public void run()
  {
    MessageForPic localMessageForPic;
    aydy localaydy;
    long l;
    if ((this.a != null) && (this.this$0.jdField_a_of_type_Ayds.a != null) && (this.a.b != null))
    {
      localMessageForPic = this.this$0.jdField_a_of_type_Ayds.a;
      File localFile = new File(this.a.b);
      if (this.a.a == 0)
      {
        localaydy = (aydy)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
        if (localaydy != null)
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
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPicPreDownloader().a(this.this$0.jdField_a_of_type_Ayds, this.a);
      return;
      localaydy.a(13059, l);
      continue;
      localaydy.a(13060, l);
      localaydy.b(localMessageForPic);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.4
 * JD-Core Version:    0.7.0.1
 */