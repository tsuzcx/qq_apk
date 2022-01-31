package com.tencent.mobileqq.shortvideo;

import axdq;
import axdt;
import axeb;
import axei;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoPreDownloader$3
  implements Runnable
{
  public ShortVideoPreDownloader$3(axeb paramaxeb, axdt paramaxdt, MessageForShortVideo paramMessageForShortVideo, axei paramaxei) {}
  
  public void run()
  {
    axeb.a("consumeShortVideoThumb", "start download thumb, fileType=" + this.jdField_a_of_type_Axdt.e + ", uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    axdq.a(this.jdField_a_of_type_Axei, this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.3
 * JD-Core Version:    0.7.0.1
 */