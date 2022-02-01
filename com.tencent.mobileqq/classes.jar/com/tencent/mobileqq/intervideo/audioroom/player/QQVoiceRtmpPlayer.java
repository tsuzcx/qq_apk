package com.tencent.mobileqq.intervideo.audioroom.player;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;

public class QQVoiceRtmpPlayer
  implements IQQVoiceRtmpPlayer, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnVideoPreparedListener
{
  private ISuperPlayer a;
  private IQQVoiceAudioListener b;
  private String c;
  
  private void a()
  {
    this.a = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 118, null);
    this.a.setOnCompletionListener(this);
    this.a.setOnInfoListener(this);
    this.a.setOnErrorListener(this);
    this.a.setOnVideoPreparedListener(this);
  }
  
  private void b()
  {
    String str = this.c;
    if (str != null) {
      play(str);
    }
  }
  
  public void init()
  {
    if (isPlayerReady())
    {
      a();
      return;
    }
    QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getContext(), new QQVoiceRtmpPlayer.1(this));
  }
  
  public boolean isDestroy()
  {
    return this.a == null;
  }
  
  public boolean isPlayerReady()
  {
    return (QQVideoPlaySDKManager.isSoLoadSucess()) && (QQVideoPlaySDKManager.isSDKReady());
  }
  
  public boolean isPlaying()
  {
    ISuperPlayer localISuperPlayer = this.a;
    return (localISuperPlayer != null) && (localISuperPlayer.isPlaying());
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = this.b;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.onCompletion();
    }
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramISuperPlayer = this.b;
    if (paramISuperPlayer != null) {
      return paramISuperPlayer.onError(paramInt1, paramInt2, paramInt3, paramString);
    }
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    paramISuperPlayer = this.b;
    if (paramISuperPlayer != null) {
      return paramISuperPlayer.onInfo(paramInt, paramLong1, paramLong2, paramObject);
    }
    return false;
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = this.a;
    if (paramISuperPlayer != null)
    {
      paramISuperPlayer.start();
      paramISuperPlayer = this.b;
      if (paramISuperPlayer != null) {
        paramISuperPlayer.onAudioFirstFrame();
      }
    }
  }
  
  public void play(String paramString)
  {
    if (this.a == null)
    {
      this.c = paramString;
      return;
    }
    this.c = null;
    paramString = SuperPlayerFactory.createVideoInfoForUrl(paramString, 103, null);
    this.a.openMediaPlayer(BaseApplicationImpl.getContext(), paramString, 0L);
  }
  
  public void release()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null) {
      return;
    }
    this.c = null;
    localISuperPlayer.stop();
    this.a.release();
    this.a = null;
  }
  
  public void setPlayAudioListener(IQQVoiceAudioListener paramIQQVoiceAudioListener)
  {
    this.b = paramIQQVoiceAudioListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.player.QQVoiceRtmpPlayer
 * JD-Core Version:    0.7.0.1
 */