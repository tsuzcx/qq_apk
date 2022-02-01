package com.tencent.mobileqq.kandian.biz.comment.emotion.download;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class RIJEmotionDownloader$EmotionFileLoader$1
  implements Runnable
{
  RIJEmotionDownloader$EmotionFileLoader$1(RIJEmotionDownloader.EmotionFileLoader paramEmotionFileLoader) {}
  
  public void run()
  {
    Object localObject = FileUtils.readObject("read_in_joy_comment_emotion_data");
    if ((localObject instanceof RIJEmotionDownloader.ServerEmotionHolder))
    {
      localObject = (RIJEmotionDownloader.ServerEmotionHolder)localObject;
      if (((RIJEmotionDownloader.ServerEmotionHolder)localObject).isValid())
      {
        RIJEmotionDownloader.EmotionFileLoader.a(this.a, (RIJEmotionDownloader.ServerEmotionHolder)localObject);
        QLog.d("RIJEmotionDownloader", 1, "EmotionFileLoader#loadData: has file data");
        return;
      }
    }
    new RIJEmotionDownloader.EmotionNetLoader(this.a.a, null).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.download.RIJEmotionDownloader.EmotionFileLoader.1
 * JD-Core Version:    0.7.0.1
 */