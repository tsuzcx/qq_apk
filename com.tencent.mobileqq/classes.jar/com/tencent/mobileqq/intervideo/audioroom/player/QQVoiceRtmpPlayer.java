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
    if (this.jdField_a_of_type_JavaLangString != null) {
      play(this.jdField_a_of_type_JavaLangString);
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
    return (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying());
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomPlayerIQQVoiceAudioListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomPlayerIQQVoiceAudioListener.onCompletion();
    }
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomPlayerIQQVoiceAudioListener != null) {
      return this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomPlayerIQQVoiceAudioListener.onError(paramInt1, paramInt2, paramInt3, paramString);
    }
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomPlayerIQQVoiceAudioListener != null) {
      return this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomPlayerIQQVoiceAudioListener.onInfo(paramInt, paramLong1, paramLong2, paramObject);
    }
    return false;
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
      if (this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomPlayerIQQVoiceAudioListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomPlayerIQQVoiceAudioListener.onAudioFirstFrame();
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
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = null;
  }
  
  public void setPlayAudioListener(IQQVoiceAudioListener paramIQQVoiceAudioListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomPlayerIQQVoiceAudioListener = paramIQQVoiceAudioListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.player.QQVoiceRtmpPlayer
 * JD-Core Version:    0.7.0.1
 */