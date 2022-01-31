package com.tencent.mobileqq.shortvideo;

import azdd;
import azdg;
import azdo;
import azdx;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoPreDownloader$3
  implements Runnable
{
  public ShortVideoPreDownloader$3(azdo paramazdo, azdg paramazdg, MessageForShortVideo paramMessageForShortVideo, azdx paramazdx) {}
  
  public void run()
  {
    azdo.a("consumeShortVideoThumb", "start download thumb, fileType=" + this.jdField_a_of_type_Azdg.e + ", uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    azdd.a(this.jdField_a_of_type_Azdx, this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.3
 * JD-Core Version:    0.7.0.1
 */