package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.qphone.base.util.QLog;

class AIOEmotionFragment$12
  implements Runnable
{
  AIOEmotionFragment$12(AIOEmotionFragment paramAIOEmotionFragment, String paramString1, String paramString2, int paramInt, AudioPlayerBase paramAudioPlayerBase) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.b))
    {
      float f = this.jdField_a_of_type_Int / this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase.a();
      if (f > 0.0F)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AudioPlayer on onProgressChanged, playPosition = ");
        localStringBuilder.append(f);
        QLog.i("AIOEmotionFragment", 2, localStringBuilder.toString());
        this.this$0.a.setProgress(f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.12
 * JD-Core Version:    0.7.0.1
 */