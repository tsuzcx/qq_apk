package com.tencent.mobileqq.emotionintegrate;

import asul;
import asum;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class EmotionDownGIFCallback$2
  implements Runnable
{
  public EmotionDownGIFCallback$2(asul paramasul, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onDownloadProgress:", Integer.valueOf(this.a) });
    }
    if (asul.a(this.this$0).get() != null) {
      ((asum)asul.a(this.this$0).get()).a(this.a, asul.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.2
 * JD-Core Version:    0.7.0.1
 */