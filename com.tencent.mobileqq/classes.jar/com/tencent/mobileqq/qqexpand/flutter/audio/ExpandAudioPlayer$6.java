package com.tencent.mobileqq.qqexpand.flutter.audio;

import com.qflutter.audio.IPlayerStatusListener;
import com.tencent.mobileqq.qqexpand.audio.IAudioPlayerStatusListener;

class ExpandAudioPlayer$6
  implements IAudioPlayerStatusListener
{
  ExpandAudioPlayer$6(ExpandAudioPlayer paramExpandAudioPlayer, IPlayerStatusListener paramIPlayerStatusListener) {}
  
  public void onAudioFinishPlay(String paramString)
  {
    this.a.onAudioFinishPlay(paramString);
  }
  
  public void onAudioPlayFailed(String paramString1, int paramInt, String paramString2)
  {
    this.a.onAudioPlayFailed(paramString1, paramInt, paramString2);
  }
  
  public void onAudioStartPlay(String paramString)
  {
    this.a.onAudioStartPlay(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.audio.ExpandAudioPlayer.6
 * JD-Core Version:    0.7.0.1
 */