package com.tencent.mobileqq.qqexpand.audio.impl;

import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class ExpandAudioPlayerImpl$1
  implements VoicePlayer.VoicePlayerListener
{
  ExpandAudioPlayerImpl$1(ExpandAudioPlayerImpl paramExpandAudioPlayerImpl) {}
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    ExpandAudioPlayerImpl.access$100(this.a).onAudioFinishPlay(ExpandAudioPlayerImpl.access$000(this.a));
    if (QLog.isColorLevel()) {
      QLog.d("ExpandAudioPlayerImpl", 2, String.format(Locale.getDefault(), "playerCompletion: state=%d, path=%s, duration=%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) }));
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExpandAudioPlayerImpl", 2, String.format(Locale.getDefault(), "playerProgress : path=%s, duration=%d, current=%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExpandAudioPlayerImpl", 2, String.format(Locale.getDefault(), "playerPause : path=%s, duration=%d, current=%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.audio.impl.ExpandAudioPlayerImpl.1
 * JD-Core Version:    0.7.0.1
 */