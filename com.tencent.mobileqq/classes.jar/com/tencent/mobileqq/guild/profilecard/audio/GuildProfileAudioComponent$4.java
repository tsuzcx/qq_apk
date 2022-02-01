package com.tencent.mobileqq.guild.profilecard.audio;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;

class GuildProfileAudioComponent$4
  implements Observer<GuildAudioChannelData>
{
  GuildProfileAudioComponent$4(GuildProfileAudioComponent paramGuildProfileAudioComponent) {}
  
  public void a(GuildAudioChannelData paramGuildAudioChannelData)
  {
    String str1 = paramGuildAudioChannelData.b();
    int i = paramGuildAudioChannelData.c();
    String str2 = paramGuildAudioChannelData.d();
    int j = paramGuildAudioChannelData.e();
    boolean bool2 = paramGuildAudioChannelData.f();
    boolean bool3 = paramGuildAudioChannelData.g();
    boolean bool1;
    if (paramGuildAudioChannelData.h() == 2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (str1.equals(str2)) {
      GuildProfileAudioComponent.access$500(this.a);
    } else if (((i == 1) || (i == 2)) && (j == 0)) {
      GuildProfileAudioComponent.access$600(this.a, bool2, bool3, bool1);
    } else if ((i == 2) && (j == 1)) {
      GuildProfileAudioComponent.access$600(this.a, bool2, bool3, bool1);
    } else {
      GuildProfileAudioComponent.access$700(this.a, bool2, bool1);
    }
    QQGuildUIUtil.a(2130841028, 2130841018, 2130841004, 2130841021, GuildProfileAudioComponent.access$800(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.audio.GuildProfileAudioComponent.4
 * JD-Core Version:    0.7.0.1
 */