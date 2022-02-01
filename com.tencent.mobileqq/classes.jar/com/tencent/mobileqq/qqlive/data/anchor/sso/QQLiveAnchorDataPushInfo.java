package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

public class QQLiveAnchorDataPushInfo
  extends QQLiveAnchorDataBase
{
  public int expireTs;
  public String rtmpUrl;
  public String serverPart;
  public String streamParam;
  
  public QQLiveAnchorDataPushInfo() {}
  
  public QQLiveAnchorDataPushInfo(QQLiveAnchorDataPushInfo paramQQLiveAnchorDataPushInfo)
  {
    super(paramQQLiveAnchorDataPushInfo);
    if (paramQQLiveAnchorDataPushInfo == null) {
      return;
    }
    this.rtmpUrl = paramQQLiveAnchorDataPushInfo.rtmpUrl;
    this.serverPart = paramQQLiveAnchorDataPushInfo.serverPart;
    this.streamParam = paramQQLiveAnchorDataPushInfo.streamParam;
    this.expireTs = paramQQLiveAnchorDataPushInfo.expireTs;
  }
  
  public QQLiveAnchorDataPushInfo(boolean paramBoolean, QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    super(paramBoolean, paramQQLiveErrorMsg);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQLiveAnchorDataGetPush{\nrtmpUrl='");
    localStringBuilder.append(this.rtmpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append("\n, serverPart='");
    localStringBuilder.append(this.serverPart);
    localStringBuilder.append('\'');
    localStringBuilder.append("\n, streamParam='");
    localStringBuilder.append(this.streamParam);
    localStringBuilder.append('\'');
    localStringBuilder.append("\n, expireTs=");
    localStringBuilder.append(this.expireTs);
    localStringBuilder.append("\n, isSuccess=");
    localStringBuilder.append(this.isSuccess);
    localStringBuilder.append("\n, errorMsg='");
    localStringBuilder.append(this.errorMsg);
    localStringBuilder.append('\'');
    localStringBuilder.append("\n");
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo
 * JD-Core Version:    0.7.0.1
 */