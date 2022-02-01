package com.tencent.mobileqq.guild.audio;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.guild.audio.data.AudioRoomError;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.util.GuildAVPriorityManager;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IEnterAudioChannelCallback;
import com.tencent.mobileqq.qqguildsdk.data.IEnterChannleInfoResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;
import kotlin.text.Charsets;

class AudioRoom$7$1
  implements IEnterAudioChannelCallback
{
  AudioRoom$7$1(AudioRoom.7 param7) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult, IEnterChannleInfoResult paramIEnterChannleInfoResult)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEnterAudioChannel failed result:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", errMsg:");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("AudioRoom", 1, ((StringBuilder)localObject).toString());
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      boolean bool1 = paramIEnterChannleInfoResult.e();
      boolean bool2 = paramIEnterChannleInfoResult.d();
      int i = paramIEnterChannleInfoResult.c();
      paramString = this.a.b.getGuildId();
      paramIGProSecurityResult = this.a.b.getChannelUin();
      localObject = ((IGPSService)AudioRoom.f(this.a.c).getRuntimeService(IGPSService.class, "")).getSelfTinyId();
      String str = new String(paramIEnterChannleInfoResult.a(), Charsets.UTF_8);
      paramIEnterChannleInfoResult = new String(paramIEnterChannleInfoResult.b(), Charsets.UTF_8);
      int j = AudioRoom.d(this.a.c).k;
      int k = this.a.b.getChannelMemberMax();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterAudioChannel result:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", sdkAppId:");
      localStringBuilder.append(i);
      localStringBuilder.append(", userId:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", trtcSig:");
      localStringBuilder.append(str);
      localStringBuilder.append("， pKey");
      localStringBuilder.append(paramIEnterChannleInfoResult);
      localStringBuilder.append(", globalmute:");
      localStringBuilder.append(bool1);
      localStringBuilder.append(", defaultMute:");
      localStringBuilder.append(bool2);
      localStringBuilder.append(", guildId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", roomId:");
      localStringBuilder.append(paramIGProSecurityResult);
      QLog.i("AudioRoom", 1, localStringBuilder.toString());
      AudioRoom.c(this.a.c).a(this.a.c);
      AudioRoom.c(this.a.c).a(3, i, paramIEnterChannleInfoResult, paramIGProSecurityResult, (String)localObject, str, 20, new AudioRoom.7.1.1(this, paramString, paramIGProSecurityResult, (String)localObject, k, bool1, bool2, j));
      return;
    }
    if ((paramIGProSecurityResult != null) && (!paramIGProSecurityResult.b().isEmpty())) {
      paramString = paramIGProSecurityResult.b();
    } else {
      paramString = AudioRoomError.a(2, paramInt, paramString);
    }
    paramIGProSecurityResult = new StringBuilder();
    paramIGProSecurityResult.append("onEnterAudioChannel failed result:");
    paramIGProSecurityResult.append(paramInt);
    paramIGProSecurityResult.append(", errMsg:");
    paramIGProSecurityResult.append(paramString);
    QLog.e("AudioRoom", 1, paramIGProSecurityResult.toString());
    GuildAVPriorityManager.a("频道通话");
    AudioRoomError.a(1);
    this.a.a.a(false, paramString);
    AudioRoom.a(this.a.c, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom.7.1
 * JD-Core Version:    0.7.0.1
 */