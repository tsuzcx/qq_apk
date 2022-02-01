package com.tencent.mobileqq.guild.live.model;

import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomAnchorInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import java.io.Serializable;

public class LiveChannelRoomInfo
  implements Serializable
{
  private String anchorNick;
  private String programId;
  private long viewer;
  
  public static LiveChannelRoomInfo parseFrom(ILiveRoomInfo paramILiveRoomInfo)
  {
    if (paramILiveRoomInfo == null) {
      return null;
    }
    LiveChannelRoomInfo localLiveChannelRoomInfo = new LiveChannelRoomInfo();
    localLiveChannelRoomInfo.setProgramId(paramILiveRoomInfo.getProgramId());
    localLiveChannelRoomInfo.setViewer(paramILiveRoomInfo.getViewer());
    if (paramILiveRoomInfo.getAnchorInfo() != null) {
      localLiveChannelRoomInfo.setAnchorNick(paramILiveRoomInfo.getAnchorInfo().getAnchorName());
    }
    return localLiveChannelRoomInfo;
  }
  
  public String getAnchorNick()
  {
    return this.anchorNick;
  }
  
  public String getProgramId()
  {
    return this.programId;
  }
  
  public long getViewer()
  {
    return this.viewer;
  }
  
  public void setAnchorNick(String paramString)
  {
    this.anchorNick = paramString;
  }
  
  public void setProgramId(String paramString)
  {
    this.programId = paramString;
  }
  
  public void setViewer(long paramLong)
  {
    this.viewer = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo
 * JD-Core Version:    0.7.0.1
 */