package com.tencent.mobileqq.shortvideo;

import axdo;
import axdr;
import axdz;
import axeg;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoPreDownloader$3
  implements Runnable
{
  public ShortVideoPreDownloader$3(axdz paramaxdz, axdr paramaxdr, MessageForShortVideo paramMessageForShortVideo, axeg paramaxeg) {}
  
  public void run()
  {
    axdz.a("consumeShortVideoThumb", "start download thumb, fileType=" + this.jdField_a_of_type_Axdr.e + ", uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    axdo.a(this.jdField_a_of_type_Axeg, this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.3
 * JD-Core Version:    0.7.0.1
 */