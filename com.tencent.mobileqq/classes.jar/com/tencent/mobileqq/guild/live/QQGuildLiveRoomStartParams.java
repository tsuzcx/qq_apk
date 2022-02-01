package com.tencent.mobileqq.guild.live;

import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.io.Serializable;

public class QQGuildLiveRoomStartParams
  implements Serializable
{
  private boolean allowStartLive;
  private IGProChannelInfo channelInfo;
  private IGProGuildInfo guildInfo;
  private LiveChannelRoomInfo liveRoomInfo;
  
  public boolean getAllowStartLive()
  {
    return this.allowStartLive;
  }
  
  public IGProChannelInfo getChannelInfo()
  {
    return this.channelInfo;
  }
  
  public IGProGuildInfo getGuildInfo()
  {
    return this.guildInfo;
  }
  
  public LiveChannelRoomInfo getLiveChannelRoomInfo()
  {
    return this.liveRoomInfo;
  }
  
  public String getLiveRoomProgramId()
  {
    LiveChannelRoomInfo localLiveChannelRoomInfo = this.liveRoomInfo;
    if (localLiveChannelRoomInfo != null) {
      return localLiveChannelRoomInfo.getProgramId();
    }
    return "";
  }
  
  public long getRoomId()
  {
    IGProChannelInfo localIGProChannelInfo = this.channelInfo;
    if (localIGProChannelInfo != null) {
      return localIGProChannelInfo.getLiveRoomId();
    }
    return 0L;
  }
  
  public int getViewerNumWhenInit()
  {
    LiveChannelRoomInfo localLiveChannelRoomInfo = this.liveRoomInfo;
    if (localLiveChannelRoomInfo != null) {
      return (int)localLiveChannelRoomInfo.getViewer();
    }
    return 0;
  }
  
  public boolean roomIdIsValid()
  {
    return getRoomId() > 0L;
  }
  
  public void setAllowStartLive(boolean paramBoolean)
  {
    this.allowStartLive = paramBoolean;
  }
  
  public void setChannelInfo(IGProChannelInfo paramIGProChannelInfo)
  {
    this.channelInfo = paramIGProChannelInfo;
  }
  
  public void setGuildInfo(IGProGuildInfo paramIGProGuildInfo)
  {
    this.guildInfo = paramIGProGuildInfo;
  }
  
  public void setLiveChannelRoomInfo(LiveChannelRoomInfo paramLiveChannelRoomInfo)
  {
    this.liveRoomInfo = paramLiveChannelRoomInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams
 * JD-Core Version:    0.7.0.1
 */