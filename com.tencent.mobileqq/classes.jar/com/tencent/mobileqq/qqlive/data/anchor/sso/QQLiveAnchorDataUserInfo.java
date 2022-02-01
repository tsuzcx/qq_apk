package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;

public class QQLiveAnchorDataUserInfo
  implements BaseAnchorInfo
{
  public String avatarUrl;
  public String businessUid;
  public long explicitId;
  public long id;
  public int initialClientType;
  public String nickName;
  public long tinyId;
  
  public QQLiveAnchorDataUserInfo() {}
  
  public QQLiveAnchorDataUserInfo(QQLiveAnchorDataUserInfo paramQQLiveAnchorDataUserInfo)
  {
    this.id = paramQQLiveAnchorDataUserInfo.id;
    this.explicitId = paramQQLiveAnchorDataUserInfo.explicitId;
    this.nickName = paramQQLiveAnchorDataUserInfo.nickName;
    this.avatarUrl = paramQQLiveAnchorDataUserInfo.avatarUrl;
    this.initialClientType = paramQQLiveAnchorDataUserInfo.initialClientType;
    this.businessUid = paramQQLiveAnchorDataUserInfo.businessUid;
    this.tinyId = paramQQLiveAnchorDataUserInfo.tinyId;
  }
  
  public long getAnchorUid()
  {
    return this.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo
 * JD-Core Version:    0.7.0.1
 */