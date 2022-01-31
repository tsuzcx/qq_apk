package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.qphone.base.util.QLog;

class AIOEmotionFragment$9
  implements Runnable
{
  AIOEmotionFragment$9(AIOEmotionFragment paramAIOEmotionFragment, float paramFloat) {}
  
  public void run()
  {
    if (this.a > 0.0F)
    {
      QLog.i("AIOEmotionFragment", 2, "AudioPlayer on onProgressChanged, playPosition = " + this.a);
      this.this$0.a.setProgress(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.9
 * JD-Core Version:    0.7.0.1
 */