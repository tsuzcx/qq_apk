package com.tencent.mobileqq.qqexpand.flutter.audio;

import android.os.Handler;
import android.os.Looper;
import com.qflutter.audio.BasePlayer;
import com.qflutter.audio.IPlayerStatusListener;
import com.tencent.mobileqq.qqexpand.audio.IExpandAudioPlayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodChannel.Result;

public class ExpandAudioPlayer
  implements BasePlayer
{
  private IExpandAudioPlayer a;
  private Handler b;
  
  public ExpandAudioPlayer()
  {
    QLog.w("ExpandAudioPlayer", 1, "flutter version");
    this.a = ((IExpandAudioPlayer)QRoute.api(IExpandAudioPlayer.class));
    this.b = new Handler(Looper.getMainLooper());
  }
  
  private void a(MethodChannel.Result paramResult, Object paramObject)
  {
    if (paramResult == null)
    {
      QLog.w("ExpandAudioPlayer", 1, "doMethodCallback result is null");
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramResult.success(paramObject);
      return;
    }
    this.b.post(new ExpandAudioPlayer.7(this, paramResult, paramObject));
  }
  
  public void audioPreDownLoad(String paramString, MethodChannel.Result paramResult)
  {
    this.a.audioPreDownLoad(paramString, new ExpandAudioPlayer.1(this, paramResult));
  }
  
  public void continueAudioPlay(MethodChannel.Result paramResult)
  {
    this.a.continueAudioPlay(new ExpandAudioPlayer.4(this, paramResult));
  }
  
  public void pauseAudioPlay(MethodChannel.Result paramResult)
  {
    this.a.pauseAudioPlay(new ExpandAudioPlayer.5(this, paramResult));
  }
  
  public void removeAudioPlayerListener()
  {
    this.a.removeAudioPlayerListener();
  }
  
  public void setAudioPlayerListener(IPlayerStatusListener paramIPlayerStatusListener)
  {
    this.a.setAudioPlayerListener(new ExpandAudioPlayer.6(this, paramIPlayerStatusListener));
  }
  
  public void startAudioPlay(String paramString, MethodChannel.Result paramResult)
  {
    this.a.startAudioPlay(paramString, new ExpandAudioPlayer.2(this, paramResult));
  }
  
  public void stopAudioPlay(MethodChannel.Result paramResult)
  {
    this.a.stopAudioPlay(new ExpandAudioPlayer.3(this, paramResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.audio.ExpandAudioPlayer
 * JD-Core Version:    0.7.0.1
 */