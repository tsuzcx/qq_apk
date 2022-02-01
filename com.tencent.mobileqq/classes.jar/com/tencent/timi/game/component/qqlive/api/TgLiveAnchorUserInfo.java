package com.tencent.timi.game.component.qqlive.api;

import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;

public class TgLiveAnchorUserInfo
  implements BaseAnchorInfo
{
  public long a;
  public String b;
  public String c;
  public String d;
  public long e;
  public long f;
  public int g;
  @Deprecated
  public int h;
  @Deprecated
  public String i;
  
  public TgLiveAnchorUserInfo(QQLiveAnchorDataUserInfo paramQQLiveAnchorDataUserInfo)
  {
    if (paramQQLiveAnchorDataUserInfo != null)
    {
      this.a = paramQQLiveAnchorDataUserInfo.id;
      this.b = paramQQLiveAnchorDataUserInfo.nickName;
      this.c = paramQQLiveAnchorDataUserInfo.avatarUrl;
      this.d = paramQQLiveAnchorDataUserInfo.businessUid;
      this.e = paramQQLiveAnchorDataUserInfo.explicitId;
      this.f = paramQQLiveAnchorDataUserInfo.tinyId;
      this.g = paramQQLiveAnchorDataUserInfo.initialClientType;
    }
  }
  
  public TgLiveAnchorUserInfo(LiveAnchorInfo paramLiveAnchorInfo)
  {
    if (paramLiveAnchorInfo != null)
    {
      this.a = paramLiveAnchorInfo.uid;
      this.b = paramLiveAnchorInfo.nickName;
      this.c = paramLiveAnchorInfo.headUrl;
      this.d = paramLiveAnchorInfo.businessUid;
      this.e = paramLiveAnchorInfo.explicitId;
      this.f = paramLiveAnchorInfo.imsdkTinyId;
      this.g = paramLiveAnchorInfo.initialClientType;
      this.h = paramLiveAnchorInfo.sex;
      this.i = paramLiveAnchorInfo.wechatPub;
    }
  }
  
  public long getAnchorUid()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.api.TgLiveAnchorUserInfo
 * JD-Core Version:    0.7.0.1
 */