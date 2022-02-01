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
    QLog.w("QQVoiceRtmpPlayer", 1, "initSDKAsync fail: " + QQVideoPlaySDKManager.b() + ", " + QQVideoPlaySDKManager.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.player.QQVoiceRtmpPlayer.1
 * JD-Core Version:    0.7.0.1
 */