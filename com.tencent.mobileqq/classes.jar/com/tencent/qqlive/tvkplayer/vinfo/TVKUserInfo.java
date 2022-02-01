package com.tencent.qqlive.tvkplayer.vinfo;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Map;

public class TVKUserInfo
  implements Serializable
{
  public static final int LOGIN_TYPE_OTHERS = 1;
  public static final int LOGIN_TYPE_QQ = 2;
  public static final int LOGIN_TYPE_WX = 3;
  public static final int VIP_TYPE_NONE = 1;
  public static final int VIP_TYPE_SUPPLEMENT_CARD = 3;
  public static final int VIP_TYPE_TENCENT_VIDEO = 2;
  private static final long serialVersionUID = 4925138540725095302L;
  private String mAccessToken;
  private Map<String, String> mCDNHttpHeader;
  private boolean mIsVip;
  private String mLoginCookie;
  @TVKUserInfo.LoginType
  private int mLoginType;
  private String mOAuthConsumerKey;
  private String mOpenId;
  private String mPf;
  private String mUin;
  private String mVUserId;
  @TVKUserInfo.VipType
  private int mVipType;
  private String mWXOpenID;
  
  public TVKUserInfo()
  {
    this.mUin = "";
    this.mLoginCookie = "";
    this.mIsVip = false;
    this.mVipType = 1;
    this.mWXOpenID = "";
    this.mLoginType = 1;
  }
  
  public TVKUserInfo(String paramString1, String paramString2)
  {
    this.mUin = paramString1;
    this.mLoginCookie = paramString2;
    this.mIsVip = false;
    this.mVipType = 1;
    this.mWXOpenID = "";
    this.mLoginType = 1;
  }
  
  public String getAccessToken()
  {
    return this.mAccessToken;
  }
  
  public Map<String, String> getCdnHttpHeader()
  {
    return this.mCDNHttpHeader;
  }
  
  public String getLoginCookie()
  {
    return this.mLoginCookie;
  }
  
  public int getLoginType()
  {
    return this.mLoginType;
  }
  
  public String getOauthConsumeKey()
  {
    return this.mOAuthConsumerKey;
  }
  
  public String getOpenId()
  {
    return this.mOpenId;
  }
  
  public String getPf()
  {
    return this.mPf;
  }
  
  public String getUin()
  {
    if (TextUtils.isEmpty(this.mUin)) {
      return "";
    }
    return this.mUin;
  }
  
  public String getVUserId()
  {
    return this.mVUserId;
  }
  
  public int getVipType()
  {
    return this.mVipType;
  }
  
  public String getWxOpenID()
  {
    if (TextUtils.isEmpty(this.mWXOpenID)) {
      return "";
    }
    return this.mWXOpenID;
  }
  
  public boolean isVip()
  {
    return this.mIsVip;
  }
  
  public void setCdnHttpHeader(Map<String, String> paramMap)
  {
    this.mCDNHttpHeader = paramMap;
  }
  
  public void setLoginCookie(String paramString)
  {
    this.mLoginCookie = paramString;
  }
  
  public void setLoginType(@TVKUserInfo.LoginType int paramInt)
  {
    this.mLoginType = paramInt;
  }
  
  public void setOpenApi(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mOpenId = paramString1;
    this.mAccessToken = paramString2;
    this.mOAuthConsumerKey = paramString3;
    this.mPf = paramString4;
  }
  
  public void setUin(String paramString)
  {
    this.mUin = paramString;
  }
  
  public void setVUserId(String paramString)
  {
    this.mVUserId = paramString;
  }
  
  public void setVip(boolean paramBoolean)
  {
    this.mIsVip = paramBoolean;
    if (paramBoolean) {
      this.mVipType = 2;
    }
  }
  
  public void setVipType(@TVKUserInfo.VipType int paramInt)
  {
    this.mVipType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKUserInfo
 * JD-Core Version:    0.7.0.1
 */