package com.tencent.mobileqq.shortvideo;

import bbqf;
import bbqh;
import bbqp;
import bbqx;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoPreDownloader$3
  implements Runnable
{
  public ShortVideoPreDownloader$3(bbqp parambbqp, bbqh parambbqh, MessageForShortVideo paramMessageForShortVideo, bbqx parambbqx) {}
  
  public void run()
  {
    bbqp.a("consumeShortVideoThumb", "start download thumb, fileType=" + this.jdField_a_of_type_Bbqh.e + ", uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    bbqf.a(this.jdField_a_of_type_Bbqx, this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.3
 * JD-Core Version:    0.7.0.1
 */