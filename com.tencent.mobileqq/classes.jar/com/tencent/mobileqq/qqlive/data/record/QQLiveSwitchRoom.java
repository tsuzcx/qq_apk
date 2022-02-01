package com.tencent.mobileqq.qqlive.data.record;

public class QQLiveSwitchRoom
{
  public String anchorNick = "";
  public String coverUrl = "";
  public int gameId;
  public int gameTagId;
  public Long popularity;
  public long roomId;
  public int roomType;
  public String rtmpUrl = "";
  public String title = "";
  public String traceInfo = "";
  public String videoId = "";
  public long videoSource;
  public String videoUrl = "";
  
  public QQLiveSwitchRoom(long paramLong1, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong2, String paramString3, String paramString4, Long paramLong, String paramString5)
  {
    this.roomId = paramLong1;
    this.videoUrl = paramString1;
    this.videoId = paramString2;
    this.roomType = paramInt1;
    this.gameId = paramInt2;
    this.gameTagId = paramInt3;
    this.videoSource = paramLong2;
    this.coverUrl = paramString3;
    this.title = paramString4;
    this.popularity = paramLong;
    this.anchorNick = paramString5;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQLiveSwitchRoom{roomId=");
    localStringBuilder.append(this.roomId);
    localStringBuilder.append(", videoUrl='");
    localStringBuilder.append(this.videoUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoId='");
    localStringBuilder.append(this.videoId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", roomType=");
    localStringBuilder.append(this.roomType);
    localStringBuilder.append(", gameId=");
    localStringBuilder.append(this.gameId);
    localStringBuilder.append(", gameTagId=");
    localStringBuilder.append(this.gameTagId);
    localStringBuilder.append(", videoSource=");
    localStringBuilder.append(this.videoSource);
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.coverUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.title);
    localStringBuilder.append('\'');
    localStringBuilder.append(", popularity=");
    localStringBuilder.append(this.popularity);
    localStringBuilder.append(", anchorNick='");
    localStringBuilder.append(this.anchorNick);
    localStringBuilder.append('\'');
    localStringBuilder.append(", rtmpUrl='");
    localStringBuilder.append(this.rtmpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", traceInfo='");
    localStringBuilder.append(this.traceInfo);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.record.QQLiveSwitchRoom
 * JD-Core Version:    0.7.0.1
 */