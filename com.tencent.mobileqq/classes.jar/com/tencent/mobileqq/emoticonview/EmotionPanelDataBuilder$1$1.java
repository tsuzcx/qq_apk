package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback;
import java.util.List;

class EmotionPanelDataBuilder$1$1
  implements Runnable
{
  EmotionPanelDataBuilder$1$1(EmotionPanelDataBuilder.1 param1, List paramList) {}
  
  public void run()
  {
    this.this$1.val$callback.callbackInMainThread(this.val$dataList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder.1.1
 * JD-Core Version:    0.7.0.1
 */