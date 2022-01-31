package com.tencent.mobileqq.shortvideo;

import ayyu;
import ayyx;
import ayzf;
import ayzo;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoPreDownloader$3
  implements Runnable
{
  public ShortVideoPreDownloader$3(ayzf paramayzf, ayyx paramayyx, MessageForShortVideo paramMessageForShortVideo, ayzo paramayzo) {}
  
  public void run()
  {
    ayzf.a("consumeShortVideoThumb", "start download thumb, fileType=" + this.jdField_a_of_type_Ayyx.e + ", uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    ayyu.a(this.jdField_a_of_type_Ayzo, this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.3
 * JD-Core Version:    0.7.0.1
 */