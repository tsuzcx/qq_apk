package com.tencent.mobileqq.qqguildsdk.data;

import android.text.TextUtils;
import com.tencent.gprosdk.GProGuild;
import com.tencent.mobileqq.qqguildsdk.manager.GProConfigManager;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import org.jetbrains.annotations.NotNull;

public class GProGuildInfo
  implements IGProGuildInfo
{
  public static final String TAG = "GProGuildInfo";
  private String guildId;
  private GProGuild mGuild;
  
  public GProGuildInfo(GProGuild paramGProGuild)
  {
    this.mGuild = paramGProGuild;
    this.guildId = GProConvert.a(paramGProGuild.getGuildId());
  }
  
  public GProGuildInfo(GuildMsgNode paramGuildMsgNode)
  {
    this.mGuild = getGProGuild(getGuildModifyInfo(paramGuildMsgNode));
    this.guildId = paramGuildMsgNode.a();
  }
  
  public static GProGuild getGProGuild(GuildCreateInfo paramGuildCreateInfo)
  {
    return new GProGuild(GProConvert.a(paramGuildCreateInfo.a()), GProConvert.a(paramGuildCreateInfo.b()), paramGuildCreateInfo.c(), paramGuildCreateInfo.d(), paramGuildCreateInfo.e(), paramGuildCreateInfo.p(), GProConvert.a(paramGuildCreateInfo.f()), paramGuildCreateInfo.q(), paramGuildCreateInfo.r(), paramGuildCreateInfo.j(), paramGuildCreateInfo.w(), paramGuildCreateInfo.k(), paramGuildCreateInfo.s(), paramGuildCreateInfo.t(), paramGuildCreateInfo.u(), paramGuildCreateInfo.l(), paramGuildCreateInfo.v(), paramGuildCreateInfo.m(), paramGuildCreateInfo.n(), paramGuildCreateInfo.x(), paramGuildCreateInfo.y(), paramGuildCreateInfo.z(), paramGuildCreateInfo.i(), paramGuildCreateInfo.A(), paramGuildCreateInfo.B(), paramGuildCreateInfo.C(), paramGuildCreateInfo.o(), paramGuildCreateInfo.g(), GProConvert.b(paramGuildCreateInfo.h()), 1000, 0);
  }
  
  public String getAvatarUrl(int paramInt)
  {
    return String.format("https://%1$s/%2$s/%3$d?t=%4$d", new Object[] { GProConfigManager.a().b(), this.guildId, Integer.valueOf(paramInt), Long.valueOf(this.mGuild.getAvatarSeq()) });
  }
  
  public boolean getChannelListChange()
  {
    return this.mGuild.getChannelListChange();
  }
  
  public String getClientId()
  {
    return GProConvert.a(this.mGuild.getClientId());
  }
  
  public String getCoverUrl(int paramInt1, int paramInt2)
  {
    if (this.mGuild.getCoverSeq() != 0L) {
      return String.format("https://%1$s/%2$s?imageView2/1/w/%3$s/h/%4$s&t=%5$d", new Object[] { GProConfigManager.a().c(), this.guildId, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(this.mGuild.getCoverSeq()) });
    }
    return "";
  }
  
  public long getCreateTime()
  {
    return this.mGuild.getCreateTime();
  }
  
  public String getCreatorId()
  {
    return GProConvert.a(this.mGuild.getCreatorTinyId());
  }
  
  public String getErrMsg()
  {
    return this.mGuild.getErrMsg();
  }
  
  public GProGuild getGuild()
  {
    return this.mGuild;
  }
  
  public String getGuildID()
  {
    return this.guildId;
  }
  
  public GuildCreateInfo getGuildModifyInfo(GuildMsgNode paramGuildMsgNode)
  {
    return new GuildCreateInfo.Builder().b(paramGuildMsgNode.a()).a(paramGuildMsgNode.c()).c(paramGuildMsgNode.b()).a();
  }
  
  public String getGuildName()
  {
    return this.mGuild.getName();
  }
  
  public int getGuildType()
  {
    return this.mGuild.getGuildType();
  }
  
  public boolean getIsBanned()
  {
    return this.mGuild.getIsBanned();
  }
  
  public boolean getIsFrozen()
  {
    return this.mGuild.getIsFrozen();
  }
  
  public boolean getIsValid()
  {
    return this.mGuild.getIsValid();
  }
  
  public long getJoinTime()
  {
    return this.mGuild.getJoinTime();
  }
  
  public int getMedalLevel()
  {
    return this.mGuild.getMedalLevel();
  }
  
  public String getProfile()
  {
    return this.mGuild.getProfile();
  }
  
  public int getResult()
  {
    return this.mGuild.getResult();
  }
  
  public String getSearchJoinSig()
  {
    return this.mGuild.getSearchJoinSig();
  }
  
  public String getShowNumber()
  {
    return GProConvert.a(this.mGuild.getShowNumber());
  }
  
  public long getU64guildSeq()
  {
    return this.mGuild.getU64guildSeq();
  }
  
  public String getUIData(String paramString)
  {
    return null;
  }
  
  public int getUserType()
  {
    return this.mGuild.getUserType();
  }
  
  public int getVisibleChannelMaxNum()
  {
    return this.mGuild.getVisibleChannelMaxNum();
  }
  
  public boolean isEqual(IGProGuildInfo paramIGProGuildInfo)
  {
    boolean bool = false;
    if (paramIGProGuildInfo == null) {
      return false;
    }
    if (getU64guildSeq() == paramIGProGuildInfo.getU64guildSeq()) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isMember()
  {
    return this.mGuild.getIsMember() == 2;
  }
  
  public boolean isTop()
  {
    return this.mGuild.getIsTop();
  }
  
  public GProGuildInfo reflash(GProGuild paramGProGuild)
  {
    this.mGuild = paramGProGuild;
    GProLog.a("GProGuildInfo", false, "cache", "reflash", "GProGuildInfo reflash", toString());
    return this;
  }
  
  public GProGuildInfo reflash(GuildMsgNode paramGuildMsgNode)
  {
    if ((!TextUtils.isEmpty(paramGuildMsgNode.c())) && (!paramGuildMsgNode.c().equals(getGuildName())))
    {
      this.mGuild.setName(paramGuildMsgNode.c());
      GProLog.a("GProGuildInfo", false, "cache", "reflash", "GProGuildInfo reflash", toString());
    }
    return this;
  }
  
  public void setGuildName(String paramString)
  {
    this.mGuild.setName(paramString);
  }
  
  public void setProfile(String paramString)
  {
    this.mGuild.setProfile(paramString);
  }
  
  public void setTop(boolean paramBoolean)
  {
    this.mGuild.setIsTop(paramBoolean);
  }
  
  public void setUIData(String paramString1, String paramString2) {}
  
  public void setUserType(int paramInt)
  {
    this.mGuild.setUserType(paramInt);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProGuildInfo{GuilId:");
    localStringBuilder.append(getGuildID());
    localStringBuilder.append(" name:");
    localStringBuilder.append(getGuildName());
    localStringBuilder.append(" showNumber:");
    localStringBuilder.append(getShowNumber());
    localStringBuilder.append(" isTop:");
    localStringBuilder.append(isTop());
    localStringBuilder.append(" CreatorId:");
    localStringBuilder.append(getCreatorId());
    localStringBuilder.append(" joinTime:");
    localStringBuilder.append(getJoinTime());
    localStringBuilder.append("userType: ");
    localStringBuilder.append(getUserType());
    localStringBuilder.append(" result:");
    localStringBuilder.append(getResult());
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(getErrMsg());
    localStringBuilder.append(" clientId:");
    localStringBuilder.append(getClientId());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo
 * JD-Core Version:    0.7.0.1
 */