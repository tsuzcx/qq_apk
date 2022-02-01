package com.tencent.mobileqq.intervideo.audioroom.player;

import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

class QQVoiceRtmpPlayer$1
  implements SDKInitListener
{
  QQVoiceRtmpPlayer$1(QQVoiceRtmpPlayer paramQQVoiceRtmpPlayer) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QQVoiceRtmpPlayer.a(this.a);
      QQVoiceRtmpPlayer.b(this.a);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initSDKAsync fail: ");
    localStringBuilder.append(QQVideoPlaySDKManager.isSoLoadSucess());
    localStringBuilder.append(", ");
    localStringBuilder.append(QQVideoPlaySDKManager.isSDKReady());
    QLog.w("QQVoiceRtmpPlayer", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.player.QQVoiceRtmpPlayer.1
 * JD-Core Version:    0.7.0.1
 */