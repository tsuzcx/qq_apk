package com.tencent.mobileqq.emotionintegrate;

import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class EmotionDownGIFCallback$2
  implements Runnable
{
  EmotionDownGIFCallback$2(EmotionDownGIFCallback paramEmotionDownGIFCallback, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onDownloadProgress:", Integer.valueOf(this.a) });
    }
    if (EmotionDownGIFCallback.a(this.this$0).get() != null) {
      ((EmotionDownGIFCallback.UiCallback)EmotionDownGIFCallback.a(this.this$0).get()).a(this.a, EmotionDownGIFCallback.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.2
 * JD-Core Version:    0.7.0.1
 */