package com.tencent.mobileqq.kandian.biz.comment.emotion.download;

import com.tencent.qphone.base.util.QLog;

class RIJEmotionDownloader$EmotionFileLoader$2
  implements Runnable
{
  RIJEmotionDownloader$EmotionFileLoader$2(RIJEmotionDownloader.EmotionFileLoader paramEmotionFileLoader, RIJEmotionDownloader.ServerEmotionHolder paramServerEmotionHolder) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionDownloadRIJEmotionDownloader$EmotionFileLoader.a.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionDownloadRIJEmotionDownloader$ServerEmotionHolder);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadDataOnMainThread: serverEmotionHolder=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionDownloadRIJEmotionDownloader$ServerEmotionHolder);
    QLog.d("RIJEmotionDownloader", 4, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.download.RIJEmotionDownloader.EmotionFileLoader.2
 * JD-Core Version:    0.7.0.1
 */