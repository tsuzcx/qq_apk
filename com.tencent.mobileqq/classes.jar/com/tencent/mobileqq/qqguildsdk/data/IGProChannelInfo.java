package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.List;

public abstract interface IGProChannelInfo
  extends Serializable
{
  public abstract int getBannedSpeak();
  
  public abstract long getCategoryId();
  
  public abstract String getCategoryName();
  
  public abstract int getChannelMemberMax();
  
  public abstract String getChannelName();
  
  public abstract String getChannelUin();
  
  public abstract long getCreateTime();
  
  public abstract String getCreatorId();
  
  public abstract int getFinalMsgNotify();
  
  public abstract String getGuildId();
  
  public abstract long getLastCntMsgSeq();
  
  public abstract long getLastCntMsgTime();
  
  public abstract long getLastMsgSeq();
  
  public abstract long getLastMsgTime();
  
  public abstract long getLiveAnchorTinyId();
  
  public abstract long getLiveRoomId();
  
  public abstract String getLiveRoomName();
  
  public abstract byte[] getMsgMeta();
  
  public abstract int getMsgNotify();
  
  public abstract int getMyMsgNotify();
  
  public abstract long getReadCntMsgSeq();
  
  public abstract long getReadCntMsgTime();
  
  public abstract byte[] getReadMsgMeta();
  
  public abstract long getReadMsgSeq();
  
  public abstract long getReadMsgTime();
  
  @NonNull
  public abstract List<Integer> getSpecialType();
  
  public abstract int getTalkPermission();
  
  public abstract int getType();
  
  public abstract int getVisibleType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
 * JD-Core Version:    0.7.0.1
 */