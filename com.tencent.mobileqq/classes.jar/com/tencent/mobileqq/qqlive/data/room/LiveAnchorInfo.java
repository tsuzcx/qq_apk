package com.tencent.mobileqq.qqlive.data.room;

public class LiveAnchorInfo
  implements BaseAnchorInfo
{
  public String businessUid;
  public long explicitId;
  public String headUrl;
  public long imsdkTinyId;
  public int initialClientType;
  public String nickName;
  public int sex;
  public long uid;
  public String wechatPub;
  
  public long getAnchorUid()
  {
    return this.uid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo
 * JD-Core Version:    0.7.0.1
 */