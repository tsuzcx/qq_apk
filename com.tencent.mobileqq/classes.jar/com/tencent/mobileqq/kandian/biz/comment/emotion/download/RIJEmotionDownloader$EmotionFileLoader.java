package com.tencent.mobileqq.kandian.biz.comment.emotion.download;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class RIJEmotionDownloader$EmotionFileLoader
{
  private RIJEmotionDownloader$EmotionFileLoader(RIJEmotionDownloader paramRIJEmotionDownloader) {}
  
  private void a(RIJEmotionDownloader.ServerEmotionHolder paramServerEmotionHolder)
  {
    ThreadManager.getUIHandler().post(new RIJEmotionDownloader.EmotionFileLoader.2(this, paramServerEmotionHolder));
  }
  
  void a()
  {
    QLog.d("RIJEmotionDownloader", 1, "EmotionFileLoader#loadData: start load file data");
    ThreadManager.getFileThreadHandler().post(new RIJEmotionDownloader.EmotionFileLoader.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.download.RIJEmotionDownloader.EmotionFileLoader
 * JD-Core Version:    0.7.0.1
 */