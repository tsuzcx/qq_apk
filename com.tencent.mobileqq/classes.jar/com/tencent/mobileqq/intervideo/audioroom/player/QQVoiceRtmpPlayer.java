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
  private IQQVoiceAudioListener jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomPlayerIQQVoiceAudioListener;
  private ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private String jdField_a_of_type_JavaLangString;
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 118, null);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
  }
  
  private void b()
  {
    String str = this.jdField_a_of_type_JavaLangString;
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
    QQVideoPlaySDKManager.a(BaseApplicationImpl.getContext(), new QQVoiceRtmpPlayer.1(this));
  }
  
  public boolean isDestroy()
  {
    return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null;
  }
  
  public boolean isPlayerReady()
  {
    return (QQVideoPlaySDKManager.b()) && (QQVideoPlaySDKManager.a());
  }
  
  public boolean isPlaying()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    return (localISuperPlayer != null) && (localISuperPlayer.isPlaying());
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomPlayerIQQVoiceAudioListener;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.onCompletion();
    }
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramISuperPlayer = this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomPlayerIQQVoiceAudioListener;
    if (paramISuperPlayer != null) {
      return paramISuperPlayer.onError(paramInt1, paramInt2, paramInt3, paramString);
    }
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    paramISuperPlayer = this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomPlayerIQQVoiceAudioListener;
    if (paramISuperPlayer != null) {
      return paramISuperPlayer.onInfo(paramInt, paramLong1, paramLong2, paramObject);
    }
    return false;
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (paramISuperPlayer != null)
    {
      paramISuperPlayer.start();
      paramISuperPlayer = this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomPlayerIQQVoiceAudioListener;
      if (paramISuperPlayer != null) {
        paramISuperPlayer.onAudioFirstFrame();
      }
    }
  }
  
  public void play(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    this.jdField_a_of_type_JavaLangString = null;
    paramString = SuperPlayerFactory.createVideoInfoForUrl(paramString, 103, null);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(BaseApplicationImpl.getContext(), paramString, 0L);
  }
  
  public void release()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = null;
    localISuperPlayer.stop();
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = null;
  }
  
  public void setPlayAudioListener(IQQVoiceAudioListener paramIQQVoiceAudioListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomPlayerIQQVoiceAudioListener = paramIQQVoiceAudioListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.player.QQVoiceRtmpPlayer
 * JD-Core Version:    0.7.0.1
 */