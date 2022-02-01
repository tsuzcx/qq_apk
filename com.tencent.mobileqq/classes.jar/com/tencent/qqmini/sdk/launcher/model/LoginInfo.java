package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LoginInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LoginInfo> CREATOR = new LoginInfo.1();
  private String account;
  private String appId;
  private byte[] loginSig;
  private int loginType;
  private String nickName;
  private String payAccessToken;
  private String payOpenId;
  private String payOpenKey;
  private String platformId;
  
  public LoginInfo() {}
  
  public LoginInfo(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte, String paramString6, String paramString7)
  {
    this.loginType = paramInt;
    this.account = paramString1;
    this.nickName = paramString2;
    this.payOpenId = paramString3;
    this.payOpenKey = paramString4;
    this.payAccessToken = paramString5;
    if (paramArrayOfByte != null)
    {
      this.loginSig = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, this.loginSig, 0, paramArrayOfByte.length);
    }
    this.payOpenId = paramString3;
    this.appId = paramString7;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccount()
  {
    return this.account;
  }
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public byte[] getLoginSig()
  {
    return this.loginSig;
  }
  
  public int getLoginType()
  {
    return this.loginType;
  }
  
  public String getNickName()
  {
    return this.nickName;
  }
  
  public String getPayAccessToken()
  {
    return this.payAccessToken;
  }
  
  public String getPayOpenId()
  {
    return this.payOpenId;
  }
  
  public String getPayOpenKey()
  {
    return this.payOpenKey;
  }
  
  public String getPlatformId()
  {
    return this.platformId;
  }
  
  public void setAccount(String paramString)
  {
    this.account = paramString;
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setLoginSig(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      this.loginSig = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, this.loginSig, 0, paramArrayOfByte.length);
    }
  }
  
  public void setLoginType(int paramInt)
  {
    this.loginType = paramInt;
  }
  
  public void setNickName(String paramString)
  {
    this.nickName = paramString;
  }
  
  public void setPayAccessToken(String paramString)
  {
    this.payAccessToken = paramString;
  }
  
  public void setPayOpenId(String paramString)
  {
    this.payOpenId = paramString;
  }
  
  public void setPayOpenKey(String paramString)
  {
    this.payOpenKey = paramString;
  }
  
  public void setPlatformId(String paramString)
  {
    this.platformId = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.loginType);
    paramParcel.writeString(this.account);
    paramParcel.writeString(this.nickName);
    paramParcel.writeString(this.payOpenId);
    paramParcel.writeString(this.payOpenKey);
    paramParcel.writeString(this.payAccessToken);
    paramParcel.writeByteArray(this.loginSig);
    paramParcel.writeString(this.platformId);
    paramParcel.writeString(this.appId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.LoginInfo
 * JD-Core Version:    0.7.0.1
 */