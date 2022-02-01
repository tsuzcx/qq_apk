package com.tencent.mobileqq.shortvideo;

import bcec;
import bcef;
import bcen;
import bcev;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoPreDownloader$3
  implements Runnable
{
  public ShortVideoPreDownloader$3(bcen parambcen, bcef parambcef, MessageForShortVideo paramMessageForShortVideo, bcev parambcev) {}
  
  public void run()
  {
    bcen.a("consumeShortVideoThumb", "start download thumb, fileType=" + this.jdField_a_of_type_Bcef.e + ", uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    bcec.a(this.jdField_a_of_type_Bcev, this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.3
 * JD-Core Version:    0.7.0.1
 */