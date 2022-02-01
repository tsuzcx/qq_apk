package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.data.MessageForShortVideo;

class ShortVideoPreDownloader$3
  implements Runnable
{
  ShortVideoPreDownloader$3(ShortVideoPreDownloader paramShortVideoPreDownloader, ShortVideoDownloadInfo paramShortVideoDownloadInfo, MessageForShortVideo paramMessageForShortVideo, ShortVideoReq paramShortVideoReq) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start download thumb, fileType=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.e);
    localStringBuilder.append(", uniseq:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    ShortVideoPreDownloader.a("consumeShortVideoThumb", localStringBuilder.toString());
    ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq, this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.3
 * JD-Core Version:    0.7.0.1
 */