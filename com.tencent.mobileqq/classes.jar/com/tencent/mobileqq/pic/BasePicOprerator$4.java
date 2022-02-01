package com.tencent.mobileqq.pic;

import azja;
import azjk;
import azke;
import azkk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPic;
import java.io.File;

public class BasePicOprerator$4
  implements Runnable
{
  public BasePicOprerator$4(azja paramazja, azjk paramazjk) {}
  
  public void run()
  {
    MessageForPic localMessageForPic;
    azkk localazkk;
    long l;
    if ((this.a != null) && (this.this$0.jdField_a_of_type_Azke.a != null) && (this.a.b != null))
    {
      localMessageForPic = this.this$0.jdField_a_of_type_Azke.a;
      File localFile = new File(this.a.b);
      if (this.a.a == 0)
      {
        localazkk = (azkk)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PICTURE_STATISTICS_MANAGER);
        if (localazkk != null)
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
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPicPreDownloader().a(this.this$0.jdField_a_of_type_Azke, this.a);
      return;
      localazkk.a(13059, l);
      continue;
      localazkk.a(13060, l);
      localazkk.b(localMessageForPic);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.4
 * JD-Core Version:    0.7.0.1
 */