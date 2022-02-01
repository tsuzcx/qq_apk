package com.tencent.mobileqq.kandian.biz.comment.emotion.download;

import com.tencent.qphone.base.util.QLog;

class RIJEmotionDownloader$EmotionFileLoader$2
  implements Runnable
{
  RIJEmotionDownloader$EmotionFileLoader$2(RIJEmotionDownloader.EmotionFileLoader paramEmotionFileLoader, RIJEmotionDownloader.ServerEmotionHolder paramServerEmotionHolder) {}
  
  public void run()
  {
    this.b.a.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadDataOnMainThread: serverEmotionHolder=");
    localStringBuilder.append(this.a);
    QLog.d("RIJEmotionDownloader", 4, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.download.RIJEmotionDownloader.EmotionFileLoader.2
 * JD-Core Version:    0.7.0.1
 */