package com.tencent.mobileqq.guild.audio;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.guild.audio.data.AudioRoomError;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.util.GuildAVPriorityManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;

class AudioRoom$7$1$1
  implements ITRTCAudioRoom.ITRTCAudioRoomCallback
{
  AudioRoom$7$1$1(AudioRoom.7.1 param1, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2) {}
  
  public void a(int paramInt, String paramString)
  {
    AudioRoom.a(this.h.a.c, false);
    if (paramInt != 0)
    {
      ((IGPSService)AudioRoom.f(this.h.a.c).getRuntimeService(IGPSService.class, "")).exitAudioChannel(this.a, AudioRoom.a(this.h.a.c).b, new AudioRoom.7.1.1.1(this));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("trtc enterRoom failed result:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", errMsg:");
      localStringBuilder.append(paramString);
      QLog.e("AudioRoom", 1, localStringBuilder.toString());
      GuildAVPriorityManager.a("频道通话");
      AudioRoomError.a(0);
      this.h.a.a.a(false, AudioRoomError.a(3, paramInt, paramString));
      return;
    }
    QLog.i("AudioRoom", 1, "trtc enterRoom success");
    AudioRoom.h(this.h.a.c).a();
    AudioRoom.a(this.h.a.c, this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    if (this.e) {
      this.h.a.c.a(false);
    } else if (this.f) {
      this.h.a.c.a(false);
    } else {
      this.h.a.c.a(true);
    }
    AudioRoom.b(this.h.a.c, "enterRoom");
    this.h.a.a.a(true, "");
    AudioRoom.i(this.h.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom.7.1.1
 * JD-Core Version:    0.7.0.1
 */