package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProLiveRoomInfo;
import com.tencent.gprosdk.GProRoomInfo;
import com.tencent.gprosdk.GProViewerExt;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import java.util.HashMap;

public class LiveRoomInfo
  implements ILiveRoomInfo
{
  private ILiveRoomAnchorInfo anchorInfo;
  private GProLiveRoomInfo liveRoomInfo;
  
  public LiveRoomInfo(GProLiveRoomInfo paramGProLiveRoomInfo)
  {
    this.liveRoomInfo = paramGProLiveRoomInfo;
    this.anchorInfo = new LiveRoomAnchorInfo(paramGProLiveRoomInfo.getAnchorInfo());
  }
  
  public ILiveRoomAnchorInfo getAnchorInfo()
  {
    return this.anchorInfo;
  }
  
  public int getFakeNum()
  {
    return this.liveRoomInfo.getRoomInfo().getViewerExt().getFakeNum();
  }
  
  public String getProgramId()
  {
    return this.liveRoomInfo.getRoomInfo().getProgramId();
  }
  
  public String getQueryId()
  {
    return GProConvert.a(this.liveRoomInfo.getQueryId());
  }
  
  public int getRealNum()
  {
    return this.liveRoomInfo.getRoomInfo().getViewerExt().getRealNum();
  }
  
  public int getRobotNum()
  {
    return this.liveRoomInfo.getRoomInfo().getViewerExt().getRebotNum();
  }
  
  public HashMap<String, String> getRoomIcons()
  {
    return this.liveRoomInfo.getRoomInfo().getRoomIcons();
  }
  
  public String getRoomId()
  {
    return GProConvert.a(this.liveRoomInfo.getRoomInfo().getRoomId());
  }
  
  public int getRoomState()
  {
    return this.liveRoomInfo.getRoomInfo().getRoomState();
  }
  
  public String getRoomTitle()
  {
    return this.liveRoomInfo.getRoomInfo().getRoomName();
  }
  
  public long getViewer()
  {
    return this.liveRoomInfo.getRoomInfo().getViewer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.LiveRoomInfo
 * JD-Core Version:    0.7.0.1
 */