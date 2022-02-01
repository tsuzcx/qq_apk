package com.tencent.mobileqq.identification;

import java.io.Serializable;

public class FaceConf
  implements Serializable
{
  private AppConf mAppConf;
  private int mAppId;
  private String mCallback;
  private String mIdNum;
  private String mKey;
  private String mMethod;
  private String mName;
  private long mNonce;
  private String mOpenId;
  private int mPlatformAppId;
  private int mServiceType;
  private String mTicket;
  private String mUin;
  
  public AppConf getAppConf()
  {
    return this.mAppConf;
  }
  
  public int getAppId()
  {
    return this.mAppId;
  }
  
  public String getCallback()
  {
    return this.mCallback;
  }
  
  public String getIdNum()
  {
    return this.mIdNum;
  }
  
  public String getKey()
  {
    return this.mKey;
  }
  
  public String getMethod()
  {
    return this.mMethod;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public long getNonce()
  {
    return this.mNonce;
  }
  
  public String getOpenId()
  {
    return this.mOpenId;
  }
  
  public int getPlatformAppId()
  {
    return this.mPlatformAppId;
  }
  
  public int getServiceType()
  {
    return this.mServiceType;
  }
  
  public String getTicket()
  {
    return this.mTicket;
  }
  
  public String getUin()
  {
    return this.mUin;
  }
  
  public void setAppConf(AppConf paramAppConf)
  {
    this.mAppConf = paramAppConf;
  }
  
  public void setAppId(int paramInt)
  {
    this.mAppId = paramInt;
  }
  
  public void setCallback(String paramString)
  {
    this.mCallback = paramString;
  }
  
  public void setIdNum(String paramString)
  {
    this.mIdNum = paramString;
  }
  
  public void setKey(String paramString)
  {
    this.mKey = paramString;
  }
  
  public void setMethod(String paramString)
  {
    this.mMethod = paramString;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setNonce(long paramLong)
  {
    this.mNonce = paramLong;
  }
  
  public void setOpenId(String paramString)
  {
    this.mOpenId = paramString;
  }
  
  public void setPlatformAppId(int paramInt)
  {
    this.mPlatformAppId = paramInt;
  }
  
  public void setServiceType(int paramInt)
  {
    this.mServiceType = paramInt;
  }
  
  public void setTicket(String paramString)
  {
    this.mTicket = paramString;
  }
  
  public void setUin(String paramString)
  {
    this.mUin = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceConf
 * JD-Core Version:    0.7.0.1
 */