package com.tencent.mobileqq.shortvideo;

import bcwz;
import bcxb;
import bcxj;
import bcxr;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoPreDownloader$3
  implements Runnable
{
  public ShortVideoPreDownloader$3(bcxj parambcxj, bcxb parambcxb, MessageForShortVideo paramMessageForShortVideo, bcxr parambcxr) {}
  
  public void run()
  {
    bcxj.a("consumeShortVideoThumb", "start download thumb, fileType=" + this.jdField_a_of_type_Bcxb.e + ", uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    bcwz.a(this.jdField_a_of_type_Bcxr, this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.3
 * JD-Core Version:    0.7.0.1
 */