package com.tencent.mobileqq.emotionintegrate;

import anni;
import annj;
import com.tencent.qphone.base.util.QLog;

public class EmotionDownGIFCallback$2
  implements Runnable
{
  public EmotionDownGIFCallback$2(anni paramanni, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onDownloadProgress:", Integer.valueOf(this.a) });
    }
    anni.a(this.this$0).a(this.a, anni.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.2
 * JD-Core Version:    0.7.0.1
 */