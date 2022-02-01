package com.tencent.mobileqq.guild.main.data;

import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;

public class QQGuildChannelVoice
  extends QQChannelItemData
{
  private String b;
  private IGProChannelInfo c;
  private IAudioChannelMemberInfos d;
  
  public QQGuildChannelVoice(String paramString, IGProChannelInfo paramIGProChannelInfo)
  {
    this.b = paramString;
    this.c = paramIGProChannelInfo;
  }
  
  public IGProChannelInfo a()
  {
    return this.c;
  }
  
  public void a(IAudioChannelMemberInfos paramIAudioChannelMemberInfos)
  {
    this.d = paramIAudioChannelMemberInfos;
  }
  
  public void a(IGProChannelInfo paramIGProChannelInfo)
  {
    this.c = paramIGProChannelInfo;
  }
  
  public String b()
  {
    return this.c.getChannelUin();
  }
  
  public int c()
  {
    IAudioChannelMemberInfos localIAudioChannelMemberInfos = this.d;
    if (localIAudioChannelMemberInfos != null) {
      return localIAudioChannelMemberInfos.c();
    }
    return 0;
  }
  
  public int d()
  {
    IGProChannelInfo localIGProChannelInfo = this.c;
    if (localIGProChannelInfo != null) {
      return localIGProChannelInfo.getChannelMemberMax();
    }
    return 99;
  }
  
  public List<IGProUserInfo> e()
  {
    IAudioChannelMemberInfos localIAudioChannelMemberInfos = this.d;
    if (localIAudioChannelMemberInfos != null) {
      return localIAudioChannelMemberInfos.d();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.data.QQGuildChannelVoice
 * JD-Core Version:    0.7.0.1
 */