package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProAnchorInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;

public class LiveRoomAnchorInfo
  implements ILiveRoomAnchorInfo
{
  private GProAnchorInfo anchorInfo;
  
  public LiveRoomAnchorInfo(GProAnchorInfo paramGProAnchorInfo)
  {
    this.anchorInfo = paramGProAnchorInfo;
  }
  
  public String getAnchorIcon()
  {
    return this.anchorInfo.getAnchorIcon();
  }
  
  public String getAnchorName()
  {
    return this.anchorInfo.getAnchorName();
  }
  
  public String getAnchorTinyId()
  {
    return GProConvert.a(this.anchorInfo.getTinyId());
  }
  
  public int getIdVerifyTimestamp()
  {
    return this.anchorInfo.getIdVerifyTimestamp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.LiveRoomAnchorInfo
 * JD-Core Version:    0.7.0.1
 */