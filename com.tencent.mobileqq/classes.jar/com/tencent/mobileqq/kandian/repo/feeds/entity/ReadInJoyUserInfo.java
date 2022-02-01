package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.LiveStatus;

public class ReadInJoyUserInfo
  extends Entity
{
  @notColumn
  private static final String TAG = "ReadInJoyUserInfo";
  public int accountLevel;
  public int accountType;
  public String authorizeDesc;
  public String decorationIcon;
  public int decorationId;
  public String decorationName;
  public int faceFlag;
  public int faceType;
  public String faceUrl;
  @notColumn
  public int isApproved = -1;
  public String largeIconUrl;
  public long lastUpdateTimeMilliSecond = 0L;
  public oidb_cmd0xb81.LiveStatus liveStatus;
  public String nick;
  public String qqHeadUrl;
  public boolean readlTimeRead = false;
  @notColumn
  public boolean requestFlag = false;
  public String smallIconUrl;
  public int systemID;
  public long timestamp;
  public String uin;
  public String upIconUrl;
  
  private String getLiveStatusString()
  {
    oidb_cmd0xb81.LiveStatus localLiveStatus = this.liveStatus;
    if (localLiveStatus != null) {
      return String.format("{uint32_liveing: %d, uint64_live_time: %d, uint32_source: %d, str_url: %s}", new Object[] { Integer.valueOf(localLiveStatus.uint32_liveing.get()), Long.valueOf(this.liveStatus.uint64_live_time.get()), Integer.valueOf(this.liveStatus.uint32_source.get()), this.liveStatus.str_url.get() });
    }
    return null;
  }
  
  public int getLiveSource()
  {
    oidb_cmd0xb81.LiveStatus localLiveStatus = this.liveStatus;
    if ((localLiveStatus != null) && (localLiveStatus.uint32_source.has())) {
      return this.liveStatus.uint32_source.get();
    }
    return 0;
  }
  
  public String getLiveUrl()
  {
    oidb_cmd0xb81.LiveStatus localLiveStatus = this.liveStatus;
    if (localLiveStatus != null) {
      return localLiveStatus.str_url.get();
    }
    return null;
  }
  
  public boolean isLiving()
  {
    oidb_cmd0xb81.LiveStatus localLiveStatus = this.liveStatus;
    return (localLiveStatus != null) && (localLiveStatus.uint32_liveing.has()) && (this.liveStatus.uint32_liveing.get() == 1);
  }
  
  public boolean isReadlTimeRead()
  {
    return this.readlTimeRead;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadInJoyUserInfo, accountType = ");
    localStringBuilder.append(this.accountType);
    localStringBuilder.append('\n');
    localStringBuilder.append("uin = ");
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\n');
    localStringBuilder.append("nick = ");
    localStringBuilder.append(this.nick);
    localStringBuilder.append('\n');
    localStringBuilder.append("faceType = ");
    localStringBuilder.append(this.faceType);
    localStringBuilder.append('\n');
    localStringBuilder.append("timestamp = ");
    localStringBuilder.append(this.timestamp);
    localStringBuilder.append('\n');
    localStringBuilder.append("faceFlag = ");
    localStringBuilder.append(this.faceFlag);
    localStringBuilder.append('\n');
    localStringBuilder.append("faceUrl = ");
    localStringBuilder.append(this.faceUrl);
    localStringBuilder.append('\n');
    localStringBuilder.append("systemID = ");
    localStringBuilder.append(this.systemID);
    localStringBuilder.append('\n');
    localStringBuilder.append("requestFlag = ");
    localStringBuilder.append(this.requestFlag);
    localStringBuilder.append('\n');
    localStringBuilder.append("accountLevel = ");
    localStringBuilder.append(this.accountLevel);
    localStringBuilder.append('\n');
    localStringBuilder.append("smallIconUrl = ");
    localStringBuilder.append(this.smallIconUrl);
    localStringBuilder.append('\n');
    localStringBuilder.append("largeIconUrl = ");
    localStringBuilder.append(this.largeIconUrl);
    localStringBuilder.append('\n');
    localStringBuilder.append("authorizeDesc = ");
    localStringBuilder.append(this.authorizeDesc);
    localStringBuilder.append('\n');
    localStringBuilder.append("readlTimeRead = ");
    localStringBuilder.append(this.readlTimeRead);
    localStringBuilder.append('\n');
    localStringBuilder.append("liveStatus = ");
    localStringBuilder.append(getLiveStatusString());
    localStringBuilder.append('\n');
    localStringBuilder.append("decorationName='");
    localStringBuilder.append(this.decorationName);
    localStringBuilder.append('\n');
    localStringBuilder.append("decorationId=");
    localStringBuilder.append(this.decorationId);
    localStringBuilder.append('\n');
    localStringBuilder.append("decorationIcon='");
    localStringBuilder.append(this.decorationIcon);
    localStringBuilder.append('\n');
    localStringBuilder.append("updateTimeMilliSecond = ");
    localStringBuilder.append(this.lastUpdateTimeMilliSecond);
    localStringBuilder.append('\n');
    localStringBuilder.append("qqHeadUrl=");
    localStringBuilder.append(this.qqHeadUrl);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo
 * JD-Core Version:    0.7.0.1
 */