package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

public abstract interface IGProGuildInfo
  extends Serializable
{
  public static final long serialVersionUID = 1L;
  
  public abstract String getAvatarUrl(int paramInt);
  
  public abstract boolean getChannelListChange();
  
  public abstract String getClientId();
  
  public abstract String getCoverUrl(int paramInt1, int paramInt2);
  
  public abstract long getCreateTime();
  
  public abstract String getCreatorId();
  
  public abstract String getErrMsg();
  
  public abstract String getGuildID();
  
  public abstract String getGuildName();
  
  public abstract int getGuildType();
  
  public abstract boolean getIsBanned();
  
  public abstract boolean getIsFrozen();
  
  public abstract boolean getIsValid();
  
  public abstract long getJoinTime();
  
  public abstract int getMedalLevel();
  
  public abstract String getProfile();
  
  public abstract int getResult();
  
  public abstract String getSearchJoinSig();
  
  public abstract String getShowNumber();
  
  public abstract long getU64guildSeq();
  
  public abstract String getUIData(String paramString);
  
  public abstract int getUserType();
  
  public abstract int getVisibleChannelMaxNum();
  
  public abstract boolean isMember();
  
  public abstract boolean isTop();
  
  public abstract void setUIData(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
 * JD-Core Version:    0.7.0.1
 */