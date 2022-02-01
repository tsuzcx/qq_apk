package com.tencent.mobileqq.emotionintegrate;

import java.util.List;

class EmotionDataSource$1
  implements Runnable
{
  EmotionDataSource$1(EmotionDataSource paramEmotionDataSource, boolean paramBoolean, EmotionDataSource.DataLoadListener paramDataLoadListener, EmoticonPreviewData paramEmoticonPreviewData) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.a);
    EmotionDataSource.DataLoadListener localDataLoadListener = this.b;
    if (localDataLoadListener != null) {
      localDataLoadListener.a(localList, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDataSource.1
 * JD-Core Version:    0.7.0.1
 */