package com.tencent.mobileqq.qqlive.data.login;

public class LoginInfo
{
  public static final long LIVE_A2_GAP_EXPIRE_TIME = 259200L;
  public static final long QQ_ACCESS_TOKEN_EXPIRE_TIME = 6000L;
  public String a2;
  public long a2ExpireTime;
  public String accessToken;
  public String businessUid;
  public int clientType;
  public String configData;
  public byte[] extData;
  public long lastLoginTime;
  public int loginType;
  public String openId;
  public String originExtData;
  public String originUin;
  public long tinyid;
  public long uid;
  
  public LoginInfo clone()
  {
    LoginInfo localLoginInfo = new LoginInfo();
    localLoginInfo.uid = this.uid;
    localLoginInfo.tinyid = this.tinyid;
    localLoginInfo.a2 = this.a2;
    localLoginInfo.openId = this.openId;
    localLoginInfo.accessToken = this.accessToken;
    localLoginInfo.businessUid = this.businessUid;
    localLoginInfo.a2ExpireTime = this.a2ExpireTime;
    localLoginInfo.configData = this.configData;
    localLoginInfo.originUin = this.originUin;
    localLoginInfo.originExtData = this.originExtData;
    localLoginInfo.clientType = this.clientType;
    return localLoginInfo;
  }
  
  public String toString()
  {
    return String.format("uid = %d, tinyid = %d, a2 = %s, openid = %s, access_token = %s, businessUid = %s, configData = %s", new Object[] { Long.valueOf(this.uid), Long.valueOf(this.tinyid), this.a2, this.openId, this.accessToken, this.businessUid, this.configData });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.login.LoginInfo
 * JD-Core Version:    0.7.0.1
 */