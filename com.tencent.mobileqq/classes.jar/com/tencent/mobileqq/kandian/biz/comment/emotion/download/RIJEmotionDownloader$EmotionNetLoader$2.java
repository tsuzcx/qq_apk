package com.tencent.mobileqq.kandian.biz.comment.emotion.download;

import com.tencent.mobileqq.utils.FileUtils;

class RIJEmotionDownloader$EmotionNetLoader$2
  implements Runnable
{
  RIJEmotionDownloader$EmotionNetLoader$2(RIJEmotionDownloader.EmotionNetLoader paramEmotionNetLoader, RIJEmotionDownloader.ServerEmotionHolder paramServerEmotionHolder) {}
  
  public void run()
  {
    FileUtils.writeObject("read_in_joy_comment_emotion_data", this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionDownloadRIJEmotionDownloader$ServerEmotionHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.download.RIJEmotionDownloader.EmotionNetLoader.2
 * JD-Core Version:    0.7.0.1
 */