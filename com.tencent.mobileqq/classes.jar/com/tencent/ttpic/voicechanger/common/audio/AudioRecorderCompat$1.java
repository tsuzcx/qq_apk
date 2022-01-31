package com.tencent.ttpic.voicechanger.common.audio;

class AudioRecorderCompat$1
  implements VoiceTextRecognizer.VRErrorListener
{
  AudioRecorderCompat$1(AudioRecorderCompat paramAudioRecorderCompat, OnErrorListener paramOnErrorListener) {}
  
  public void onError(int paramInt)
  {
    if (this.val$onErrorListener != null) {
      this.val$onErrorListener.onError(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat.1
 * JD-Core Version:    0.7.0.1
 */