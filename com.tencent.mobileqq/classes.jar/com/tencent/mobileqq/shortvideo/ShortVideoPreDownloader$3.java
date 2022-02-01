package com.tencent.mobileqq.shortvideo;

import bcwu;
import bcwx;
import bcxf;
import bcxn;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoPreDownloader$3
  implements Runnable
{
  public ShortVideoPreDownloader$3(bcxf parambcxf, bcwx parambcwx, MessageForShortVideo paramMessageForShortVideo, bcxn parambcxn) {}
  
  public void run()
  {
    bcxf.a("consumeShortVideoThumb", "start download thumb, fileType=" + this.jdField_a_of_type_Bcwx.e + ", uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    bcwu.a(this.jdField_a_of_type_Bcxn, this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.3
 * JD-Core Version:    0.7.0.1
 */