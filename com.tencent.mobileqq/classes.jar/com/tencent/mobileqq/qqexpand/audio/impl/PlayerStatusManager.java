package com.tencent.mobileqq.qqexpand.audio.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qqexpand.audio.IAudioPlayerStatusListener;
import com.tencent.qphone.base.util.QLog;

public class PlayerStatusManager
  implements IAudioPlayerStatusListener
{
  private IAudioPlayerStatusListener a;
  private Handler b = new Handler(Looper.getMainLooper());
  
  private boolean b()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(IAudioPlayerStatusListener paramIAudioPlayerStatusListener)
  {
    this.a = paramIAudioPlayerStatusListener;
  }
  
  public void onAudioFinishPlay(String paramString)
  {
    if (this.a == null)
    {
      QLog.e("PlayerStatusManager", 2, "onAudioFinishPlay mListener is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PlayerStatusManager", 2, "onAudioFinishPlay");
    }
    if (b())
    {
      this.a.onAudioFinishPlay(paramString);
      return;
    }
    this.b.post(new PlayerStatusManager.2(this, paramString));
  }
  
  public void onAudioPlayFailed(String paramString1, int paramInt, String paramString2)
  {
    if (this.a == null)
    {
      QLog.e("PlayerStatusManager", 2, "onAudioFinishPlay mListener is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PlayerStatusManager", 2, "onAudioFinishPlay");
    }
    if (b())
    {
      this.a.onAudioFinishPlay(paramString1);
      return;
    }
    this.b.post(new PlayerStatusManager.3(this, paramString1));
  }
  
  public void onAudioStartPlay(String paramString)
  {
    if (this.a == null)
    {
      QLog.e("PlayerStatusManager", 2, "onAudioStartPlay mListener is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PlayerStatusManager", 2, "onAudioStartPlay");
    }
    if (b())
    {
      this.a.onAudioStartPlay(paramString);
      return;
    }
    this.b.post(new PlayerStatusManager.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.audio.impl.PlayerStatusManager
 * JD-Core Version:    0.7.0.1
 */