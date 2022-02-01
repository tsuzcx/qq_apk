package com.tencent.mobileqq.qqlive.data.datareport;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;

public class CommonReportData
{
  private final String appId;
  private long enterRoomTime;
  private LoginInfo loginInfo;
  private BaseRoomInfo roomInfo;
  private String url = "";
  private long videoCodec = 0L;
  private String videoResolution = "";
  private long videoTrans = 0L;
  
  public CommonReportData(String paramString)
  {
    this.appId = paramString;
  }
  
  public String getAppId()
  {
    if (!TextUtils.isEmpty(this.appId)) {
      return this.appId;
    }
    return "";
  }
  
  public String getCommid()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getAppId());
    localStringBuilder.append("_");
    localStringBuilder.append(getRoomId());
    localStringBuilder.append("_");
    localStringBuilder.append(this.enterRoomTime);
    return localStringBuilder.toString();
  }
  
  public String getExpgrpid()
  {
    return "";
  }
  
  public String getProgramId()
  {
    BaseRoomInfo localBaseRoomInfo = this.roomInfo;
    if (localBaseRoomInfo != null) {
      return localBaseRoomInfo.getProgramId();
    }
    return "";
  }
  
  public String getReportDevType()
  {
    return "Android";
  }
  
  public int getRoomId()
  {
    BaseRoomInfo localBaseRoomInfo = this.roomInfo;
    if (localBaseRoomInfo != null) {
      return (int)localBaseRoomInfo.getRoomId();
    }
    return -1;
  }
  
  public String getTestId()
  {
    return "";
  }
  
  public long getUid()
  {
    LoginInfo localLoginInfo = this.loginInfo;
    if (localLoginInfo == null) {
      return -1L;
    }
    return localLoginInfo.uid;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public long getVideoCodec()
  {
    return this.videoCodec;
  }
  
  public String getVideoResolution()
  {
    return this.videoResolution;
  }
  
  public long getVideoTrans()
  {
    return this.videoTrans;
  }
  
  public void reset()
  {
    this.loginInfo = null;
    this.roomInfo = null;
    this.enterRoomTime = 0L;
    this.url = "";
    this.videoCodec = 0L;
    this.videoTrans = 0L;
    this.videoResolution = "";
  }
  
  public void setEnterRoomTime(long paramLong)
  {
    this.enterRoomTime = paramLong;
  }
  
  public void setLoginInfo(LoginInfo paramLoginInfo)
  {
    this.loginInfo = paramLoginInfo;
  }
  
  public void setRoomInfo(BaseRoomInfo paramBaseRoomInfo)
  {
    this.roomInfo = paramBaseRoomInfo;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setVideoCodec(long paramLong)
  {
    this.videoCodec = paramLong;
  }
  
  public void setVideoResolution(String paramString)
  {
    this.videoResolution = paramString;
  }
  
  public void setVideoTrans(long paramLong)
  {
    this.videoTrans = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.datareport.CommonReportData
 * JD-Core Version:    0.7.0.1
 */