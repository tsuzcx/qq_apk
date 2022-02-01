package dov.com.tencent.mobileqq.shortvideo;

import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer.VRErrorListener;

class ShortVideoVoiceRecognizer$1
  implements VoiceTextRecognizer.VRErrorListener
{
  ShortVideoVoiceRecognizer$1(ShortVideoVoiceRecognizer paramShortVideoVoiceRecognizer) {}
  
  public void onError(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoVoiceRecognizer", 1, "VoiceTextRecognizer error! errorCode = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoVoiceRecognizer.1
 * JD-Core Version:    0.7.0.1
 */