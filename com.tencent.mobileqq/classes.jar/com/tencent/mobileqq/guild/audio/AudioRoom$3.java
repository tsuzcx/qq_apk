package com.tencent.mobileqq.guild.audio;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfoList;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class AudioRoom$3
  extends GPServiceObserver
{
  AudioRoom$3(AudioRoom paramAudioRoom) {}
  
  protected void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBeKickFromGuild guild=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", black=");
    localStringBuilder.append(paramInt);
    QLog.i("AudioRoom", 1, localStringBuilder.toString());
    AudioRoom.a(this.a, paramString, "");
  }
  
  protected void a(String paramString, GuildUserAvatar paramGuildUserAvatar)
  {
    if (paramGuildUserAvatar == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetUserAvatarUrl tinyId:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", avatar url:");
    ((StringBuilder)localObject).append(paramGuildUserAvatar.c());
    QLog.i("AudioRoom", 1, ((StringBuilder)localObject).toString());
    localObject = AudioRoom.e(this.a).a(paramString);
    if (localObject != null)
    {
      ((UserInfo)localObject).j = paramGuildUserAvatar.c();
      AudioRoom.d(this.a, "onGetUserAvatarUrl");
    }
    paramString = AudioRoom.b(this.a).a(paramString);
    if (paramString != null)
    {
      paramString.j = paramGuildUserAvatar.c();
      AudioRoom.b(this.a, "onGetUserAvatarUrl");
    }
  }
  
  protected void a(String paramString1, String paramString2, IGProUserInfo paramIGProUserInfo)
  {
    if ((AudioRoom.a(this.a).a.equals(paramString1)) && (AudioRoom.a(this.a).b.equals(paramString2)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAudioChannelUserAdd guild=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", channelId=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", id:=");
      localStringBuilder.append(paramIGProUserInfo.a());
      localStringBuilder.append(", tid:");
      localStringBuilder.append(Thread.currentThread().getId());
      QLog.w("AudioRoom", 1, localStringBuilder.toString());
      if (AudioRoom.b(this.a).a.size() != 0) {
        AudioRoom.b(this.a).a(paramIGProUserInfo);
      }
      if (AudioRoom.a(this.a).h.equals(paramIGProUserInfo.a()))
      {
        AudioRoom.a(this.a).a(paramIGProUserInfo);
        paramString1 = AudioRoom.b(this.a).a(AudioRoom.a(this.a).h);
        if (paramString1 != null) {
          paramString1.a(AudioRoom.a(this.a));
        }
      }
      if (paramIGProUserInfo.h()) {
        AudioRoom.c(this.a).a(paramIGProUserInfo.a(), true);
      }
      AudioRoom.a(this.a, "onAudioChannelUserAdd", true);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAudioChannelUserAdd not match!!! guild=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", channelId=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", id:=");
    localStringBuilder.append(paramIGProUserInfo.a());
    localStringBuilder.append("; in room guildId=");
    localStringBuilder.append(AudioRoom.a(this.a).a);
    localStringBuilder.append(", channelId=");
    localStringBuilder.append(AudioRoom.a(this.a).b);
    QLog.w("AudioRoom", 1, localStringBuilder.toString());
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    if ((AudioRoom.a(this.a).a.equals(paramString1)) && (AudioRoom.a(this.a).b.equals(paramString2)))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onAudioChannelUserExit guild=");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(", channelId=");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(", id:=");
        localStringBuilder.append(paramString3);
        QLog.w("AudioRoom", 1, localStringBuilder.toString());
      }
      AudioRoom.b(this.a).b(paramString3);
      AudioRoom.b(this.a, "onAudioChannelUserExit");
      if ((this.a.c()) && (AudioRoom.a(this.a).h.equals(paramString3)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onAudioChannelUserExit self exit or kicked by other platform guild=");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(", channelId=");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(", id:=");
        localStringBuilder.append(paramString3);
        QLog.w("AudioRoom", 1, localStringBuilder.toString());
        AudioRoom.c(this.a, "");
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAudioChannelUserExit not match!!! guild=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", channelId=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", id:=");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("; in room guildId=");
    localStringBuilder.append(AudioRoom.a(this.a).a);
    localStringBuilder.append(", channelId=");
    localStringBuilder.append(AudioRoom.a(this.a).b);
    QLog.w("AudioRoom", 1, localStringBuilder.toString());
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    if ((AudioRoom.a(this.a).a.equals(paramString1)) && (AudioRoom.a(this.a).b.equals(paramString2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPushKickOutAudioChannel guild=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", channelId=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", id:=");
      localStringBuilder.append(paramString4);
      localStringBuilder.append(", operatorid:");
      localStringBuilder.append(paramString3);
      QLog.w("AudioRoom", 1, localStringBuilder.toString());
      if (AudioRoom.a(this.a).h.equals(paramString4))
      {
        paramString3 = this.a;
        if (paramInt != 10000) {
          paramString5 = AudioRoom.f(paramString3).getApplicationContext().getResources().getString(2131890255);
        }
        AudioRoom.a(paramString3, paramString1, paramString2, paramString5);
        return;
      }
      AudioRoom.b(this.a).b(paramString4);
      AudioRoom.b(this.a, "onPushKickOutAudioChannel");
      return;
    }
    paramString3 = new StringBuilder();
    paramString3.append("onAudioChannelUserAdd not match!!! guild=");
    paramString3.append(paramString1);
    paramString3.append(", channelId=");
    paramString3.append(paramString2);
    paramString3.append(", id:=");
    paramString3.append(paramString4);
    paramString3.append("; in room guildId=");
    paramString3.append(AudioRoom.a(this.a).a);
    paramString3.append(", channelId=");
    paramString3.append(AudioRoom.a(this.a).b);
    QLog.w("AudioRoom", 1, paramString3.toString());
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void a(String paramString, List<String> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPushChannelDestroy guild=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", channelIds=");
    ((StringBuilder)localObject).append(paramList);
    QLog.i("AudioRoom", 1, ((StringBuilder)localObject).toString());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      AudioRoom.a(this.a, paramString, (String)localObject, "子频道不存在了，去别的子频道逛逛吧。");
      AudioRoom.b(this.a, paramString, (String)localObject, "");
    }
  }
  
  protected void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDeleteGuild guild=");
    localStringBuilder.append(paramString);
    QLog.i("AudioRoom", 1, localStringBuilder.toString());
    AudioRoom.a(this.a, paramString, "");
  }
  
  protected void b(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAudioChannelUserPlatSwith guild:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", chnnUin:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", tinyId:");
    localStringBuilder.append(paramString3);
    QLog.i("AudioRoom", 1, localStringBuilder.toString());
    if ((this.a.c()) && (AudioRoom.a(this.a).h.equals(paramString3)))
    {
      QLog.i("AudioRoom", 1, "onAudioChannelUserPlatSwith exit room");
      AudioRoom.c(this.a, "");
    }
  }
  
  protected void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!AudioRoom.a(this.a).a.equals(paramString1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUserMuteSeatInGuild not match!!! guild=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", id:=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("; in room guildId=");
      localStringBuilder.append(AudioRoom.a(this.a).a);
      localStringBuilder.append(", channelId=");
      localStringBuilder.append(AudioRoom.a(this.a).b);
      QLog.w("AudioRoom", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUserMuteSeatInGuild guild=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", id=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", bMute=");
    localStringBuilder.append(paramBoolean);
    QLog.d("AudioRoom", 1, localStringBuilder.toString());
    paramString1 = AudioRoom.b(this.a).a(paramString2);
    if (paramString1 != null)
    {
      paramString1.p = paramBoolean;
      if (paramString1.h.equals(AudioRoom.a(this.a).h))
      {
        AudioRoom.a(this.a).p = paramBoolean;
        if (AudioRoom.a(this.a).p) {
          this.a.a(false);
        }
      }
      AudioRoom.b(this.a, "onUserMuteSeatInGuild");
    }
  }
  
  protected void c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRemoveGuild guild=");
    localStringBuilder.append(paramString);
    QLog.i("AudioRoom", 1, localStringBuilder.toString());
    AudioRoom.a(this.a, paramString, "");
  }
  
  protected void d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestoryGuild guild=");
    localStringBuilder.append(paramString);
    QLog.i("AudioRoom", 1, localStringBuilder.toString());
    AudioRoom.a(this.a, paramString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom.3
 * JD-Core Version:    0.7.0.1
 */