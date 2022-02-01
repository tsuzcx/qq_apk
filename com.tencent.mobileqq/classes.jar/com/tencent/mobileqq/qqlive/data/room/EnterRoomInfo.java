package com.tencent.mobileqq.qqlive.data.room;

public class EnterRoomInfo
  implements BaseRoomInfo
{
  private String channelId = "";
  private String deviceId = "";
  private String extraData = "";
  private long openLiveType;
  private String programId = "";
  private long roomId = 0L;
  private String source = "";
  private String transData = "";
  private String[] videoFormat = new String[0];
  
  public String getChannelId()
  {
    return this.channelId;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getExtraData()
  {
    return this.extraData;
  }
  
  public long getOpenLiveType()
  {
    return this.openLiveType;
  }
  
  public String getProgramId()
  {
    return this.programId;
  }
  
  public long getRoomId()
  {
    return this.roomId;
  }
  
  public String getSource()
  {
    return this.source;
  }
  
  public String getTransData()
  {
    return this.transData;
  }
  
  public String[] getVideoFormat()
  {
    return this.videoFormat;
  }
  
  public void setChannelId(String paramString)
  {
    this.channelId = paramString;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setExtraData(String paramString)
  {
    this.extraData = paramString;
  }
  
  public void setOpenLiveType(long paramLong)
  {
    this.openLiveType = paramLong;
  }
  
  public void setProgramId(String paramString)
  {
    this.programId = paramString;
  }
  
  public void setRoomId(long paramLong)
  {
    this.roomId = paramLong;
  }
  
  public void setSource(String paramString)
  {
    this.source = paramString;
  }
  
  public void setTransData(String paramString)
  {
    this.transData = paramString;
  }
  
  public void setVideoFormat(String[] paramArrayOfString)
  {
    this.videoFormat = paramArrayOfString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EnterRoomInfo:[roomId=");
    localStringBuilder.append(this.roomId);
    localStringBuilder.append(";source=");
    localStringBuilder.append(this.source);
    localStringBuilder.append(";programId=");
    localStringBuilder.append(this.programId);
    localStringBuilder.append(";deviceId=");
    localStringBuilder.append(this.deviceId);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo
 * JD-Core Version:    0.7.0.1
 */